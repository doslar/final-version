package components.sprites;

import java.awt.Graphics2D;

import components.Component;
import entities.Entity;

public class Component_Sprite extends Component{

	public Component_Sprite(Entity entity, String name) {
		super(entity, name);
		
	}
	
	public float getX() {
		return (entity.getX()-(entity.getWidth()/2));
	}
	
	public float getY() {
		return (entity.getY()-(entity.getHeight()));
	}
	
	protected void renderBorder(Graphics2D g2) {
		g2.drawRect((int)getX(),(int) getY(), entity.getWidth(), entity.getHeight());
	}
}
