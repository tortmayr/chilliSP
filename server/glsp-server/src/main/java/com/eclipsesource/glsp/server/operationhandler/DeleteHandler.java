/*******************************************************************************
 * Copyright (c) 2018 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *   
 * Contributors:
 * 	Camille Letavernier - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.glsp.server.operationhandler;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import javax.swing.text.ElementIterator;

import org.apache.log4j.Logger;

import com.eclipsesource.glsp.api.action.kind.DeleteElementOperationAction;
import com.eclipsesource.glsp.api.action.kind.ExecuteOperationAction;
import com.eclipsesource.glsp.api.handler.OperationHandler;
import com.eclipsesource.glsp.api.model.ModelState;
import com.eclipsesource.glsp.api.utils.SModelIndex;

import io.typefox.sprotty.api.SEdge;
import io.typefox.sprotty.api.SModelElement;
import io.typefox.sprotty.api.SModelRoot;
import io.typefox.sprotty.api.SNode;

/**
 * Generic handler implementation for {@link DeleteElementOperationAction}
 */
public class DeleteHandler implements OperationHandler {
	private static Logger log = Logger.getLogger(DeleteHandler.class);

	@Override
	public boolean handles(ExecuteOperationAction action) {
		return action instanceof DeleteElementOperationAction;
	}

	@Override
	public Optional<SModelRoot> execute(ExecuteOperationAction execAction, ModelState modelState) {
		DeleteElementOperationAction action = (DeleteElementOperationAction) execAction;
		String elementIds[] = action.getElementIds();
		if (elementIds == null || elementIds.length == 0) {
			log.warn("Elements to delete are not specified");
			return Optional.empty();
		}
		SModelIndex index = modelState.getCurrentModelIndex();

		boolean success = Arrays.stream(elementIds).allMatch(eId -> delete(eId, index, modelState));
		if (!success) {
			return Optional.empty();
		}

		SModelRoot currentModel = modelState.getCurrentModel();
		return Optional.of(currentModel);
	}

	protected boolean delete(String elementId, SModelIndex index, ModelState modelState) {
		SModelElement element = index.get(elementId);

		if (element == null) {
			log.warn("Element not found: " + elementId);
			return false;
		}

		// Always delete the top-level node
		SModelElement nodeToDelete = findTopLevelElement(element, index);
		SModelElement parent = index.getParent(nodeToDelete);
		if (parent == null) {
			log.warn("The requested node doesn't have a parent; it can't be deleted");
			return false; // Can't delete the root, or an element that doesn't belong to the model
		}

		Set<SModelElement> dependents = new LinkedHashSet<>();
		collectDependents(dependents, nodeToDelete, modelState);

		dependents.forEach(modelElement -> delete(modelElement, modelState));
		return true;
	}

	protected void delete(SModelElement element, ModelState modelState) {
		SModelElement parent = modelState.getCurrentModelIndex().getParent(element);
		modelState.getCurrentModelIndex().removeFromIndex(element);

		if (parent == null || parent.getChildren() == null) {
			return;
		}
		parent.getChildren().remove(element);
	}

	protected void collectDependents(Set<SModelElement> dependents, SModelElement nodeToDelete, ModelState modelState) {
		if (dependents.contains(nodeToDelete)) {
			return;
		}

		// First, children
		if (nodeToDelete.getChildren() != null) {
			for (SModelElement child : nodeToDelete.getChildren()) {
				collectDependents(dependents, child, modelState);
			}
		}

		SModelIndex index = modelState.getCurrentModelIndex();

		// Then, incoming/outgoing links
		for (SModelElement incoming : index.getIncomingEdges(nodeToDelete)) {
			collectDependents(dependents, incoming, modelState);
		}
		for (SModelElement outgoing : index.getOutgoingEdges(nodeToDelete)) {
			collectDependents(dependents, outgoing, modelState);
		}

		// Finally, the node to delete
		dependents.add(nodeToDelete);
	}

	protected SModelElement findTopLevelElement(SModelElement element, SModelIndex index) {
		if (element instanceof SNode || element instanceof SEdge) {
			return element;
		}

		SModelElement parent = index.getParent(element);
		if (parent == null) {
			return element;
		}
		return findTopLevelElement(parent, index);
	}

}
