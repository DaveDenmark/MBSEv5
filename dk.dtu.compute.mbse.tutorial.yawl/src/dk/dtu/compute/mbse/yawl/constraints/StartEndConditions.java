package dk.dtu.compute.mbse.yawl.constraints;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;

import dk.dtu.compute.mbse.yawl.PType;
import dk.dtu.compute.mbse.yawl.Place;
import dk.dtu.compute.mbse.yawl.YAWLNet;
import dk.dtu.compute.mbse.yawl.helpfunctions.YAWLFunctions;

/**
 * 
 * Constraint to guarantee there is exactly 1 start and 1 end place.
 * 
 * @author Henrik Iller Wærsted - s154280 
 * @author Rasmus Hannibal Barlach Moulvad - s153256
 *
 */

public class StartEndConditions extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject object = ctx.getTarget();
		if (object instanceof YAWLNet) {
			EObject container = object.eContainer();
			if (container instanceof PetriNet) {
				int startCount = 0;
				int endCount = 0;
				Iterator<EObject> iterator = container.eAllContents();
				while (iterator.hasNext()) {
					EObject content = iterator.next();
					if (content instanceof Place) {
						Place place = (Place) content;
						PType type = YAWLFunctions.getType(place);
						if (type.equals(PType.START)) {
							startCount++;
							if (startCount > 1) {
								break;
							}
						} else if (type.equals(PType.FINISH)) {
							endCount++;
							if (endCount > 1) {
								break;
							}
						}
					}
				}
				if (startCount != 1 || endCount != 1) {
					// if there is not exactly one start place and exactly one
					// end place, return a failure status.
					return ctx.createFailureStatus(new Object[] { container });
				}
			}
		}
		// otherwise return a success status
		return ctx.createSuccessStatus();
	}

}
