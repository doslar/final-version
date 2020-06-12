package components;

import java.awt.Graphics2D;

import entities.Entity;

public class Component {
	protected Entity entity;
	protected String name;
	
	public Component(Entity entity, String name) {
		this.entity=entity;
		this.setName(name);
	}
	
	public void update() {
		return;
	}
	
	public void render(Graphics2D g2) {
		//g2.drawRect((int) entity.getX(),(int) entity.getY(), entity.getWidth(), entity.getHeight());
		return;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return (name);
	}
	
	public void kill() {
		return;
	}
}

