/**
 * Copyright (c) 2019 EclipseSource and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package com.eclipsesource.glsp.example.workflow.wfgraph.util;

import com.eclipsesource.glsp.example.workflow.wfgraph.*;

import com.eclipsesource.glsp.graph.GAlignable;
import com.eclipsesource.glsp.graph.GBoundsAware;
import com.eclipsesource.glsp.graph.GCompartment;
import com.eclipsesource.glsp.graph.GEdge;
import com.eclipsesource.glsp.graph.GEdgeLayoutable;
import com.eclipsesource.glsp.graph.GLabel;
import com.eclipsesource.glsp.graph.GLayouting;
import com.eclipsesource.glsp.graph.GModelElement;
import com.eclipsesource.glsp.graph.GNode;
import com.eclipsesource.glsp.graph.GShapeElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.eclipsesource.glsp.example.workflow.wfgraph.WfgraphPackage
 * @generated
 */
public class WfgraphAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WfgraphPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WfgraphAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = WfgraphPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WfgraphSwitch<Adapter> modelSwitch = new WfgraphSwitch<Adapter>() {
		@Override
		public Adapter caseActivityNode(ActivityNode object) {
			return createActivityNodeAdapter();
		}

		@Override
		public Adapter caseDecisionNode(DecisionNode object) {
			return createDecisionNodeAdapter();
		}

		@Override
		public Adapter caseMergeNode(MergeNode object) {
			return createMergeNodeAdapter();
		}

		@Override
		public Adapter caseTaskNode(TaskNode object) {
			return createTaskNodeAdapter();
		}

		@Override
		public Adapter caseAutomatedTask(AutomatedTask object) {
			return createAutomatedTaskAdapter();
		}

		@Override
		public Adapter caseManualTask(ManualTask object) {
			return createManualTaskAdapter();
		}

		@Override
		public Adapter caseIcon(Icon object) {
			return createIconAdapter();
		}

		@Override
		public Adapter caseWeightedEdge(WeightedEdge object) {
			return createWeightedEdgeAdapter();
		}

		@Override
		public Adapter caseLabelHeading(LabelHeading object) {
			return createLabelHeadingAdapter();
		}

		@Override
		public Adapter caseLabelText(LabelText object) {
			return createLabelTextAdapter();
		}

		@Override
		public Adapter caseLabelIcon(LabelIcon object) {
			return createLabelIconAdapter();
		}

		@Override
		public Adapter caseGModelElement(GModelElement object) {
			return createGModelElementAdapter();
		}

		@Override
		public Adapter caseGBoundsAware(GBoundsAware object) {
			return createGBoundsAwareAdapter();
		}

		@Override
		public Adapter caseGShapeElement(GShapeElement object) {
			return createGShapeElementAdapter();
		}

		@Override
		public Adapter caseGEdgeLayoutable(GEdgeLayoutable object) {
			return createGEdgeLayoutableAdapter();
		}

		@Override
		public Adapter caseGLayouting(GLayouting object) {
			return createGLayoutingAdapter();
		}

		@Override
		public Adapter caseGNode(GNode object) {
			return createGNodeAdapter();
		}

		@Override
		public Adapter caseGCompartment(GCompartment object) {
			return createGCompartmentAdapter();
		}

		@Override
		public Adapter caseGEdge(GEdge object) {
			return createGEdgeAdapter();
		}

		@Override
		public Adapter caseGAlignable(GAlignable object) {
			return createGAlignableAdapter();
		}

		@Override
		public Adapter caseGLabel(GLabel object) {
			return createGLabelAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.example.workflow.wfgraph.ActivityNode <em>Activity Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.example.workflow.wfgraph.ActivityNode
	 * @generated
	 */
	public Adapter createActivityNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.example.workflow.wfgraph.DecisionNode <em>Decision Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.example.workflow.wfgraph.DecisionNode
	 * @generated
	 */
	public Adapter createDecisionNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.example.workflow.wfgraph.MergeNode <em>Merge Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.example.workflow.wfgraph.MergeNode
	 * @generated
	 */
	public Adapter createMergeNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.example.workflow.wfgraph.TaskNode <em>Task Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.example.workflow.wfgraph.TaskNode
	 * @generated
	 */
	public Adapter createTaskNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.example.workflow.wfgraph.AutomatedTask <em>Automated Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.example.workflow.wfgraph.AutomatedTask
	 * @generated
	 */
	public Adapter createAutomatedTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.example.workflow.wfgraph.ManualTask <em>Manual Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.example.workflow.wfgraph.ManualTask
	 * @generated
	 */
	public Adapter createManualTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.example.workflow.wfgraph.Icon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.example.workflow.wfgraph.Icon
	 * @generated
	 */
	public Adapter createIconAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.example.workflow.wfgraph.WeightedEdge <em>Weighted Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.example.workflow.wfgraph.WeightedEdge
	 * @generated
	 */
	public Adapter createWeightedEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.example.workflow.wfgraph.LabelHeading <em>Label Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.example.workflow.wfgraph.LabelHeading
	 * @generated
	 */
	public Adapter createLabelHeadingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.example.workflow.wfgraph.LabelText <em>Label Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.example.workflow.wfgraph.LabelText
	 * @generated
	 */
	public Adapter createLabelTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.example.workflow.wfgraph.LabelIcon <em>Label Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.example.workflow.wfgraph.LabelIcon
	 * @generated
	 */
	public Adapter createLabelIconAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.graph.GModelElement <em>GModel Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.graph.GModelElement
	 * @generated
	 */
	public Adapter createGModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.graph.GBoundsAware <em>GBounds Aware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.graph.GBoundsAware
	 * @generated
	 */
	public Adapter createGBoundsAwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.graph.GShapeElement <em>GShape Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.graph.GShapeElement
	 * @generated
	 */
	public Adapter createGShapeElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.graph.GEdgeLayoutable <em>GEdge Layoutable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.graph.GEdgeLayoutable
	 * @generated
	 */
	public Adapter createGEdgeLayoutableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.graph.GLayouting <em>GLayouting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.graph.GLayouting
	 * @generated
	 */
	public Adapter createGLayoutingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.graph.GNode <em>GNode</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.graph.GNode
	 * @generated
	 */
	public Adapter createGNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.graph.GCompartment <em>GCompartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.graph.GCompartment
	 * @generated
	 */
	public Adapter createGCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.graph.GEdge <em>GEdge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.graph.GEdge
	 * @generated
	 */
	public Adapter createGEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.graph.GAlignable <em>GAlignable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.graph.GAlignable
	 * @generated
	 */
	public Adapter createGAlignableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eclipsesource.glsp.graph.GLabel <em>GLabel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eclipsesource.glsp.graph.GLabel
	 * @generated
	 */
	public Adapter createGLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //WfgraphAdapterFactory