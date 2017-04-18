package org.pnml.tools.epnk.tutorials.app.technical.helpers;

/**
 * This is an enumeration of all possible arc types. Note there are more
 * types here than in the model of the Technical Net Type PNTD: NORMAL
 * is the default value when no type is chosen for an arc between places and
 * transitions; RESET is the default value (actually the only possible value)
 * for an arc from a page to a transition. This class together with the static
 * methods from {@link TechnicalNetTypeFunctions} should assure the uniform interpretation
 * of arc types.
 * 
 * @author ekki@dtu.dk
 * @generated NOT
 *
 */
public enum ArcType {

	NORMAL, READ, RESET, INHIBITOR

}
