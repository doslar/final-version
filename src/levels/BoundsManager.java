package levels;

import java.util.ArrayList;
import java.util.List;

import components.Component_BoxBounds;
import entities.Entity;

public class BoundsManager {
	private List<Component_BoxBounds> bounds;
	
	public BoundsManager() {
		bounds = new ArrayList<Component_BoxBounds>();
	}
	
	public void addBounds(Component_BoxBounds boxBound) {
		bounds.add(boxBound);
	}
}
