package org.pnml.tools.epnk.tutorials.app.simulator.application;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import org.pnml.tools.epnk.helpers.FlatAccess;

/**
 * This is a Listener, which will be attached to the FlattAccess object used
 * in the simulator. It will notify the end user when the underlying net
 * is changed while the application is running and ask the end user whether
 * to shut down the simulator (continuing would not be save).
 * 
 * @author ekki@dtu.dk
 *
 */
public class NetChangeListener implements Adapter {
	
	TechnicalSimulator simulator;

	public NetChangeListener(TechnicalSimulator simulator) {
		super();
		this.simulator = simulator;
	}

	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public boolean isAdapterForType(Object arg0) {
		return false;
	}

	@Override
	public void notifyChanged(Notification arg0) {
		String name = simulator.getName();
		if (name != null) {
			name = "Technical Simulator: " + name; 
		} else {
			name = "Technical Simulator";
		}

		FlatAccess flatAccess = simulator.flatAccess;
		if (flatAccess != null) {
			flatAccess.removeInvalidationListener(this);
			simulator.flatAccess = null;
		}
		
		final String label = name;
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if (MessageDialog.openConfirm(null, label, 
						"The underlying net has been modified." + System.lineSeparator() +
						"It is unsafe to continue using the application, and it may show wrong results." + System.lineSeparator() +
						"Do you want stop this application (recommended)?")) {
					simulator.dispose();
				}
			}
		});
	}

	@Override
	public void setTarget(Notifier arg0) {
	}

}