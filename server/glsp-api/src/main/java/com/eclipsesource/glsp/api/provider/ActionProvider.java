/*******************************************************************************

 * Copyright (c) 2018 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *   
 * Contributors:
 * 	Tobias Ortmayr - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.glsp.api.provider;

import java.util.Collections;
import java.util.Set;

import com.eclipsesource.glsp.api.action.Action;

public interface ActionProvider {

	Set<Action> getActions();

	public static class NullImpl implements ActionProvider {

		@Override
		public Set<Action> getActions() {
			return Collections.emptySet();
		}

	}

}
