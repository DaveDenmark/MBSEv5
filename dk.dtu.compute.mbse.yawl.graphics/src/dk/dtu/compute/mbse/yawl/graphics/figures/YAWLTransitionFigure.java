package dk.dtu.compute.mbse.yawl.graphics.figures;


import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.TransitionFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;
import dk.dtu.compute.mbse.yawl.helpfunctions.YAWLFunctions;
import dk.dtu.compute.mbse.yawl.TType;

public class YAWLTransitionFigure extends TransitionFigure {
	
	private TType JType;
	private TType SType;
	
	public YAWLTransitionFigure(Transition transition) {
		super(transition);
		JType = YAWLFunctions.getJoinType(transition);
		SType = YAWLFunctions.getSplitType(transition);
	}
	
	@Override
	public void update() {
		TType oldJoinType = JType;
		TType oldSplitType = SType;
		JType = YAWLFunctions.getJoinType(transition);
		SType = YAWLFunctions.getSplitType(transition);
		if (oldJoinType != JType || oldSplitType != SType) {
			this.repaint();
		}
	}
	@Override
	protected void fillShape(Graphics graphics) {
		super.fillShape(graphics);
		

		graphics.pushState();

		graphics.setLineWidth(1);
		Rectangle rectangle = this.getClientArea();
	
		if (this.JType == TType.AND) {
				int x1 = rectangle.x;
				int y1 = rectangle.y;
				int x2 = rectangle.x;
				int y2 = rectangle.y + rectangle.height;
				int x3 = rectangle.x + rectangle.width/3;
				int y3 = rectangle.y + rectangle.height/2;
				int x4 = rectangle.x + rectangle.width/3;
				int y4 = rectangle.y;
				int x5 = rectangle.x + rectangle.width/3;
				int y5 = rectangle.y + rectangle.height;
				graphics.setBackgroundColor(getForegroundColor());
				// Set up AND join figure
				int points[] = { x1, y1, x2, y2, x3, y3 };
		
				
				graphics.drawPolygon(points);
				graphics.drawLine(x4, y4, x5, y5);

			
		} else if(this.JType == TType.OR) {
		
			
			graphics.setLineWidth(1);

			int x1 = rectangle.x + rectangle.width/6;
			int y1 = rectangle.y + rectangle.height;
			int x2 = rectangle.x + rectangle.width/3;;
			int y2 = rectangle.y + rectangle.height/2;
			int x3 = x1;
			int y3 = rectangle.y;
			int x4 = rectangle.x;
			int y4 = y2;
			int x5 = rectangle.x + rectangle.width/3;
			int y5 = rectangle.y + rectangle.height;
			int x6 = rectangle.x + rectangle.width/3;
			int y6 = rectangle.y;
			int points[] = { x1, y1, x2, y2, x3, y3, x4, y4 };
			
			graphics.drawPolygon(points);
			graphics.drawLine(x5, y5, x6, y6);
	
		} else if(this.JType == TType.XOR) {
	
			
			graphics.setLineWidth(1);

			int x1 = rectangle.x + rectangle.width/3;
			int y1 = rectangle.y + rectangle.height;
			int x2 = x1;
			int y2 = rectangle.y;
			int x3 = rectangle.x;
			int y3 = rectangle.y + rectangle.height/2;
			int points[] = { x1, y1, x2, y2, x3, y3 };
			graphics.fillPolygon(points);
			graphics.drawPolygon(points);
		}
		
		if (this.SType == TType.AND) {

			
			graphics.setLineWidth(1);

			int x1 = rectangle.x + rectangle.width;
			int y1 = rectangle.y + rectangle.height;
			int	x2 = x1;
			int	y2 = rectangle.y;
			int x3 = x1 - rectangle.width/3;
			int y3 = rectangle.y + rectangle.height/2;
			int x4 = rectangle.x + rectangle.width - rectangle.width/3;
			int y4 = rectangle.y + rectangle.height;
			int x5 = rectangle.x + rectangle.width - rectangle.width/3;
			int y5 = rectangle.y;
			int points[] = { x1, y1, x2, y2, x3, y3 };

			graphics.drawLine(x4, y4, x5, y5);
			graphics.drawPolygon(points);
			
		} else if(this.SType == TType.OR) {
			
			graphics.setLineWidth(1);

			int x1 = rectangle.x + rectangle.width - rectangle.width/6;
			int y1 = rectangle.y + rectangle.height;
			int x2 = rectangle.x + rectangle.width;
			int y2 = rectangle.y + rectangle.height/2;
			int x3 = x1;
			int y3 = rectangle.y;
			int x4 = rectangle.x + rectangle.width - rectangle.width/3;
			int y4 = y2;
			int x5 = rectangle.x + rectangle.width - rectangle.width/3;
			int y5 = rectangle.y + rectangle.height;
			int x6 = rectangle.x + rectangle.width - rectangle.width/3;
			int y6 = rectangle.y;
			int points[] = { x1, y1, x2, y2, x3, y3, x4, y4 };
	
			graphics.drawLine(x5, y5, x6, y6);
			graphics.drawPolygon(points);
		} else if(this.SType == TType.XOR) {

			
			graphics.setLineWidth(1);

			int x1 = rectangle.x + rectangle.width - rectangle.width/3;
			int y1 = rectangle.y + rectangle.height;
			int x2 = rectangle.x + rectangle.width;
			int y2 = rectangle.y + rectangle.height/2;
			int x3 = x1;
			int y3 = rectangle.y;
			int points[] = { x1, y1, x2, y2, x3, y3 };
			graphics.fillPolygon(points);
			graphics.drawPolygon(points);
		}
		
		graphics.popState();
	}

}



	