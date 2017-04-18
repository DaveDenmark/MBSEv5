package org.pnml.tools.epnk.tutorials.app.graphics.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.TransitionFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;

import org.pnml.tools.epnk.tutorials.app.technical.helpers.TechnicalNetTypeFunctions;

/**
 * The figure defining implementing the graphical appearance of transitions in the
 * Technical Net Type. The transitions will be shown with a cross in on the
 * left or ride side of the transition if the transition does not have NORMAL
 * incoming or outgoing arcs.
 * 
 * @author ekki@dtu.dk
 * 
 */
public class TechnicalNetTypeTransitionFigure extends TransitionFigure {

	private boolean hasNormalInArcs;
	private boolean hasNormalOutArcs;	
	
	public TechnicalNetTypeTransitionFigure(Transition transition) {
		super(transition);
		hasNormalInArcs = TechnicalNetTypeFunctions.hasNormalInArcs(
				(org.pnml.tools.epnk.tutorials.app.technical.Transition) transition);
		hasNormalOutArcs = TechnicalNetTypeFunctions.hasNormalOutArcs(
				(org.pnml.tools.epnk.tutorials.app.technical.Transition) transition);
	}

	/**
	 * This method is called whenever some attribute of the transition which might
	 * influence the graphical appearance of the transition changes.
	 */
	@Override
	public void update() {
		boolean oldHasNormalInArcs = this.hasNormalInArcs;
		boolean oldhasNormalOutArcs = this.hasNormalOutArcs;
		hasNormalInArcs = TechnicalNetTypeFunctions.hasNormalInArcs(
				(org.pnml.tools.epnk.tutorials.app.technical.Transition) transition);
		hasNormalOutArcs = TechnicalNetTypeFunctions.hasNormalOutArcs(
				(org.pnml.tools.epnk.tutorials.app.technical.Transition) transition);
		if (oldHasNormalInArcs != this.hasNormalInArcs ||
				 oldhasNormalOutArcs != this.hasNormalOutArcs) {
			// only call the repaint() method, when there was a change that has
			// an effect to the graphical appearance of the transition
			this.repaint();
		}
	}
	
	@Override
	protected void fillShape(Graphics graphics) {
		super.fillShape(graphics);
		
		// in order to make sure that the changes made to the drawing style
		// have an effect within the scope of this method only, the state
		// of the graphics object is pushed here. Note that the state needs
		// to be popped from the stack again before finishing this method
		// (see below).
		graphics.pushState();

		graphics.setLineWidth(1);
		Rectangle rectangle = this.getClientArea();
		int w = rectangle.width / 3;
		if (!this.hasNormalInArcs) {
			// if there are no incoming NORMAL arcs, draw a cross in the
			// left third of the transition
			graphics.drawLine(rectangle.x + w, rectangle.y,
					rectangle.x + w, rectangle.y + rectangle.height-1);
			graphics.drawLine(rectangle.x + w, rectangle.y,
					rectangle.x, rectangle.y + rectangle.height-1);
			graphics.drawLine(rectangle.x, rectangle.y,
					rectangle.x + w, rectangle.y + rectangle.height-1);
		}
		
		if (!this.hasNormalOutArcs) {
			// if there are no outgoing NORMAL arcs, draw a cross in the
			// right third of the transition
			graphics.drawLine(rectangle.x + 2*w, rectangle.y,
					rectangle.x + 2*w, rectangle.y + rectangle.height-1);
			graphics.drawLine(rectangle.x + rectangle.width-1, rectangle.y,
					rectangle.x + 2*w, rectangle.y + rectangle.height-1);
			graphics.drawLine(rectangle.x + 2*w, rectangle.y,
					rectangle.x + rectangle.width-1, rectangle.y + rectangle.height-1);
		}
		
		// Make sure that graphics.pushState(); and graphics.popState(); always
		// are called in a balanced way! If push and pop operations are not
		// properly paired, this will result in runtime exceptions and the
		// editor not working properly!
		graphics.popState();
	}

}
