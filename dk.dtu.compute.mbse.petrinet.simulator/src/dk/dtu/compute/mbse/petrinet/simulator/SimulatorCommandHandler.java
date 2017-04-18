package dk.dtu.compute.mbse.petrinet.simulator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

import dk.dtu.compute.mbse.petrinet.Arc;
import dk.dtu.compute.mbse.petrinet.Node;
import dk.dtu.compute.mbse.petrinet.PetrinetFactory;
import dk.dtu.compute.mbse.petrinet.Transition;
import dk.dtu.compute.mbse.petrinet.commands.FireTransitionCommand;
import dk.dtu.compute.mbse.petrinet.Place;
import dk.dtu.compute.mbse.petrinet.Token;


public class SimulatorCommandHandler extends AbstractHandler {

//	@Override
//	public Object execute(ExecutionEvent event) throws ExecutionException {
//		final Transition transition = getTransition(event.getApplicationContext());
//		if (isEnabled(transition)) {
//			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(transition);
//			if(domain != null) {
//				domain.getCommandStack().execute(new FireTransitionCommand(domain, transition));
//			}
//			fire(transition);
//		}
//		return null;
//	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Transition transition = getTransition(event.getApplicationContext());
		if (isEnabled(transition)) {
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(transition);
			if (domain instanceof TransactionalEditingDomain) {
				domain.getCommandStack().execute(
						new RecordingCommand((TransactionalEditingDomain) domain, "Fire Transition (RC)") {
							@Override
							protected void doExecute() {
								fire(transition);
							}
						});
			} else if (domain != null) {
				domain.getCommandStack().execute(new FireTransitionCommand(domain, transition));
			} else {
				fire(transition);
			}
		}
		return null;
	}

	@Override
	public void setEnabled(Object context) {
		Transition transition = getTransition(context);
		setBaseEnabled(isEnabled(transition));
	}
		
//	static private boolean isEnabled(Transition transition) {
//		if (transition != null) {
//			Map<Place, Integer> needed = new HashMap<Place, Integer>();
//			for (Arc arc: transition.getIn()) {
//				Node node = arc.getSource();
//				if(node instanceof Place) {
//					Place source = (Place) node;
//					//needed.put(source, needed.getOrDefault(source, 0) + 1);
//					if(source.getTokens().isEmpty()) {
//						return false;
//					}
//				}
//			} 
//			return true;
//		}
//		return false;
//	}
		
	static private boolean isEnabled(Transition t) {
		if (t != null) {
			Map<Place, Integer> needed = new HashMap<Place,Integer>();
			for (Arc arc: t.getIn()) {
				Node node = arc.getSource();
				if (node instanceof Place) {
					Place source = (Place) node;	
					// if (source.getTokens().isEmpty())
					needed.put(source, needed.getOrDefault(source, 0) + 1);
					
				}
				
			}
			for (Place p: needed.keySet()) {
				if (p.getTokens().size() < needed.getOrDefault(p,0)) {
					return false;
				}
			
			}
				
		}
		return true;
	}


	static private void fire(Transition transition) {
		if (transition != null) {
			for (Arc arc: transition.getIn()) {
				Node node = arc.getSource();
				if(node instanceof Place) {
					// Consume tokens
					Place source = (Place) node;
					source.getTokens().remove(0);
//					Place place = (Place) node;
//					List<Token> tokens = place.getTokens();
//					if(!tokens.isEmpty()) {}
				}
			}
			// Generate new tokens
			for ( Arc arc : transition.getOut()){
				Node node = arc.getTarget();
				if (node instanceof Place){
					Place target = (Place) node;
					Token token = PetrinetFactory.eINSTANCE.createToken();
					target.getTokens().add(token);
				}
			}			

		}
	}

	static private Transition getTransition(Object context) {
		if (context instanceof IEvaluationContext) {
			IEvaluationContext evaluationContext = (IEvaluationContext) context;
			Object object = evaluationContext.getDefaultVariable();
			if (object instanceof List) {
				@SuppressWarnings("rawtypes")
				List list = (List) object;
				if (list.size() == 1) {
					object = list.get(0);
					if (object instanceof Transition) {
						return (Transition) object;
					} else if (object instanceof IGraphicalEditPart) {
						IGraphicalEditPart editPart = (IGraphicalEditPart) object;
						Object model = editPart.getModel();
						if (model instanceof View) {
							Object element = ((View) model).getElement();
							if (element instanceof Transition) {
								return (Transition) element;
							}
						}
					}
				}
			}
		}
		return null;
	}

}
