package org.pnml.tools.epnk.tutorials.app.technical.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.helpers.NetFunctions;
import org.pnml.tools.epnk.pnmlcoremodel.Node;
import org.pnml.tools.epnk.tutorials.app.technical.Arc;
import org.pnml.tools.epnk.tutorials.app.technical.helpers.ArcType;
import org.pnml.tools.epnk.tutorials.app.technical.helpers.TechnicalNetTypeFunctions;

/**
 * This is a constraint saying that there should be no duplicate inhibitor or reset arcs of type
 * between two net objects (i.e. two arcs with the same source and target and with the same type).
 * Due to the reference nodes in the ePNK, this constraint is a bit more involved; so it is
 * easier to implement it as a Java constraint.
 *
 * @author ekki@dtu.dk
 * @generated NOT
 */
public class NoDuplicateArcs extends AbstractModelConstraint {

	public IStatus validate(IValidationContext ctx) {
		EObject object = ctx.getTarget();
		if (object instanceof Arc) {
			Arc arc = (Arc) object;
			ArcType arcType = TechnicalNetTypeFunctions.getArcType(arc);
			Node source = NetFunctions.resolve(arc.getSource());
			Node target = NetFunctions.resolve(arc.getTarget());
			
			FlatAccess flatAccess = FlatAccess.getFlatAccess(NetFunctions.getPetriNet(arc));
			if ((arcType == ArcType.INHIBITOR || arcType == ArcType.READ) && 
					source != null && 
					flatAccess != null) {
				for (org.pnml.tools.epnk.pnmlcoremodel.Arc other: flatAccess.getOut(source)) {
					if (other != arc) {
						if (other instanceof Arc) {
							Arc arc2 = (Arc) other;
							Node target2 = NetFunctions.resolve(arc2.getTarget());
							if (target == target2) {
								if (TechnicalNetTypeFunctions.getArcType(arc) == TechnicalNetTypeFunctions.getArcType(arc2)) {
									return ctx.createFailureStatus(new Object[] {arc});
								}
							}
						}
					}
				}	
			}
		} 
		return ctx.createSuccessStatus();
	}

}
