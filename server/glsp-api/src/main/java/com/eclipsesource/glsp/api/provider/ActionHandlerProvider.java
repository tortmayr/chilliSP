package com.eclipsesource.glsp.api.provider;
/*******************************************************************************

 * Copyright (c) 2018 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 * 	Tobias Ortmayr - initial API and implementation
 ******************************************************************************/
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import com.eclipsesource.glsp.api.action.Action;
import com.eclipsesource.glsp.api.action.ActionHandler;


public interface ActionHandlerProvider {

	Set<ActionHandler> getActionHandlers();

	default boolean isHandled(Action action) {
		return getActionHandler(action).isPresent();
	}

	default Optional<ActionHandler> getActionHandler(Action action) {
		return getActionHandlers().stream().filter(ha -> ha.handles(action)).findFirst();
	}
	
	final static class NullImpl implements ActionHandlerProvider{

		@Override
		public Set<ActionHandler> getActionHandlers() {
			return Collections.emptySet();
		}
		
	}
}
