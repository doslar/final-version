package components;

import entities.Entity;
import util.Vector2;

public class Component_HitBox extends Component{
	private Vector2 center;
	private int xOffSet;
	private int yOffSet;
	
	public Component_HitBox(Entity entity, int xOffSet, int yOffSet) {
		super(entity, "HitBox");
		center = new Vector2();
		this.xOffSet=xOffSet;
		this.yOffSet=yOffSet;
	}

	@Override
	public void update() {
		center = new Vector2(entity.getPossition());
		center.addVector2(new Vector2(0,-entity.getHeight()/2));
		xOffSet=entity.getWidth()/2;
		yOffSet=entity.getHeight()/2;
	}
	
	public static int collision(Component_HitBox hb1, Component_HitBox hb2) {
		int x=0;
		
		if(hb1.getCenter().getX()>hb2.getCenter().getX()) {
			if(hb1.getCenter().getX()-hb2.getCenter().getX() < hb1.getXOffSet()+hb2.getXOffSet()) {
				x=1;
			}
			else {
				return 0;
			}
		}
		else 	{
			if(hb2.getCenter().getX()-hb1.getCenter().getX() < hb1.getXOffSet()+hb2.getXOffSet()) {
				x=1;
			}
			else {
				return 0;
			}
		}
		
		return 0;
	}
	

	public Vector2 getCenter() {
		return center;
	}

	public void setCenter(Vector2 center) {
		this.center = center;
	}

	public int getXOffSet() {
		return xOffSet;
	}

	public void setXOffSet(int xOffSet) {
		this.xOffSet = xOffSet;
	}

	public int getYOffSet() {
		return yOffSet;
	}

	public void setYOffSet(int yOffSet) {
		this.yOffSet = yOffSet;
	}
}
