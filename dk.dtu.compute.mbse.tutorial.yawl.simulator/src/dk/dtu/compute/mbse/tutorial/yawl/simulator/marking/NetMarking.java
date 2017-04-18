package dk.dtu.compute.mbse.tutorial.yawl.simulator.marking;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Assert;

import dk.dtu.compute.mbse.yawl.Place;


/**
 * This class represents a marking of a YAWL net. It guarantees a uniform
 * way of dealing with markings and avoids a lot of redundant code scattered
 * in the simulator.
 * 
 * @author David Josef Kristensen - s143312 
 * @author Henrik Iller Wærsted - s154280
 * @author Lars Vandsted Myrup Jensen - s153201 
 * @author Rasmus Hannibal Barlach Moulvad - s153256
 * @author Rasmus Vulpius Gregersen - S144219
 *
 */

public class NetMarking {
	
	private Map<Place,Integer> marking;

	/**
	 * Creates a new empty marking.
	 */
	public NetMarking() {
		marking = new HashMap<Place,Integer>();
	}
	
	/**
	 * Creates a new marking, which is a copy of a given marking.
	 */
	public NetMarking(NetMarking marking) {
		this();
		for (Place Place: marking.getSupport()) {
			this.setMarking(Place, marking.getMarking(Place));
		}
	}

	/**
	 * Sets the marking of a given Place to the given value. 
	 */
	public void setMarking(Place Place, int value) {
		if (value > 0) {
			marking.put(Place, value);
		} else {
			marking.remove(Place);
		}
	}

	/**
	 * Returns the marking of a given Place. 
	 */
	public int getMarking(Place Place) {
		return marking.getOrDefault(Place,0);
	}

	/**
	 * Increments the marking of a given Place by a given increment. 
	 */
	public void incrementMarkingBy(Place Place, int increment) {
		Assert.isLegal(increment >= 0, "The incrememt must be greater or equal than 0");
		setMarking((Place) Place, getMarking((Place) Place) + increment);
	}
	
	/**
	 * Decrements the marking of a given Place by a given decrement. 
	 */
	public void decrementMarkingBy(Place Place, int decrement) {
		Assert.isLegal(decrement >= 0, "The decrememt must be greater or equal than 0");
		Assert.isLegal(getMarking((Place) Place) >= decrement,
				"Marking of Place must be greater than the decrement");
		setMarking((Place) Place, getMarking((Place) Place) - decrement);
	}
	
	/**
	 * Adds marking2 to this marking
	 */
	public void add(NetMarking marking2) {
		for (Place Place: marking2.marking.keySet()) {
			int m1 = marking.getOrDefault(Place,0);
			int m2 = marking2.marking.getOrDefault(Place, 0);
			if (m1 + m2 > 0) {
				marking.put(Place, m1 + m2);
			} else {
				marking.remove(Place);
			}
		}
	}
	
	/**
	 * Subtracts marking2 from this marking
	 */
	public void subtract(NetMarking marking2) {
		Assert.isLegal(this.isGreaterOrEqual(marking2), 
				"Subtraction the marking does not result in a marking again");
		
		for (Place Place: marking2.marking.keySet()) {
			int m1 = marking.getOrDefault(Place,0);
			int m2 = marking2.marking.getOrDefault(Place, 0);
			if (m1 - m2 > 0) {
				marking.put(Place, m1 - m2);
			} else {
				marking.remove(Place);
			}
		}
	}
	
	/**
	 * Checks whether this marking is greater or equal than marking2.
	 */
	public boolean isGreaterOrEqual(NetMarking marking2) {
		for (Place Place: marking2.marking.keySet()) {
			int m1 = marking.getOrDefault(Place,0);
			int m2 = marking2.marking.getOrDefault(Place, 0);
			if (m1 < m2) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns the set of all Places that have at least one token, which is
	 * often called the support of the marking.
	 */
	public Collection<Place> getSupport() {
		return java.util.Collections.unmodifiableCollection(marking.keySet());
	}

}