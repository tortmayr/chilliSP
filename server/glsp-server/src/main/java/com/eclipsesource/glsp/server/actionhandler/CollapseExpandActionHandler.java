/*******************************************************************************
 * Copyright (c) 2019 EclipseSource and others.
 *  
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v. 2.0 which is available at
 *   http://www.eclipse.org/legal/epl-2.0.
 *  
 *   This Source Code may also be made available under the following Secondary
 *   Licenses when the conditions for such availability set forth in the Eclipse
 *   Public License v. 2.0 are satisfied: GNU General Public License, version 2
 *   with the GNU Classpath Exception which is available at
 *   https://www.gnu.org/software/classpath/license.html.
 *  
 *   SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ******************************************************************************/
package com.eclipsesource.glsp.server.actionhandler;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import com.eclipsesource.glsp.api.action.AbstractActionHandler;
import com.eclipsesource.glsp.api.action.Action;
import com.eclipsesource.glsp.api.action.kind.CollapseExpandAction;
import com.eclipsesource.glsp.api.action.kind.CollapseExpandAllAction;
import com.eclipsesource.glsp.api.model.IModelExpansionListener;
import com.eclipsesource.glsp.api.model.IModelState;
import com.eclipsesource.glsp.api.utils.SModelIndex;
import com.google.inject.Inject;

public class CollapseExpandActionHandler extends AbstractActionHandler {
	@Inject
	protected IModelExpansionListener expansionListener;

	@Override
	protected Collection<Action> handleableActionsKinds() {
		return Arrays.asList(new CollapseExpandAction(), new CollapseExpandAllAction());
	}

	@Override
	public Optional<Action> execute(Action action, String clientId) {
		switch (action.getKind()) {
		case Action.Kind.COLLAPSE_EXPAND:
			return handleCollapseExpandAction((CollapseExpandAction) action, getModelState(clientId));
		case Action.Kind.COLLAPSE_EXPAND_ALL:
			return handleCollapseExpandAllAction((CollapseExpandAllAction) action, getModelState(clientId));
		default:
			return Optional.empty();
		}
	}

	private Optional<Action> handleCollapseExpandAllAction(CollapseExpandAllAction action, IModelState modelState) {
		Set<String> expandedElements = modelState.getExpandedElements();
		expandedElements.clear();
		if (action.isExpand()) {
			new SModelIndex(modelState.getCurrentModel()).allIds().forEach(id -> expandedElements.add(id));
		}
		if (expansionListener != null) {
			expansionListener.expansionChanged(action);
		}
		return Optional.empty();
	}

	private Optional<Action> handleCollapseExpandAction(CollapseExpandAction action, IModelState modelState) {
		Set<String> expandedElements = modelState.getExpandedElements();
		if (action.getCollapseIds() != null) {
			expandedElements.removeAll(Arrays.asList(action.getCollapseIds()));
		}
		if (action.getExpandIds() != null) {
			expandedElements.addAll(Arrays.asList(action.getExpandIds()));
		}

		if (expansionListener != null) {
			expansionListener.expansionChanged(action);
		}

		return Optional.empty();

	}


}
