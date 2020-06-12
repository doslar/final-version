package entities;


import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import components.Component;
import util.Proportions;
import util.Vector2;

public class Entity {
	protected String id;
	protected String name;
	protected Vector2 possition;
	
//	 	5	1  4
//        \ | /
//		2 - O - 0
//		  / | \	
//		 6	3  7
	protected  int direction = 3;
	
	// Status 0 = idle, 1 = running
	protected int status = 0;

	protected Proportions proportions;
	protected List<Component> components;
	
	public Entity(String id,String name, Vector2 posstion, Proportions proportions) {
		this.id=id;
		this.name=name;
		this.possition=posstion;
		this.proportions=proportions;
		components = new ArrayList<Component>();
		
		init();
	}

	public int getWidth() {
		switch(direction) {
			case 3 :
			
			case 4 :
			
			case 5 :
				
			case 6 :
			
			case 7 :	
				
			case 1 : return proportions.getWidth();
			
			case 0 :
			
			case 2 : return proportions.getThicness();
			
			default	: System.out.println(name + " error with getting proportions " + direction);
				return 0;
		}
	}
	
	public int getHeight() {
		return proportions.getHeight();
	}
	
	public void update() {
		for(Component c : components) {
			c.update();
		}
	}
	
	public void render(Graphics2D g2) {
		//g2.drawRect((int) getX()-(getWidth()/2),(int) getY()-getHeight(), getWidth(), getHeight());
		for(Component c : components) {
			c.render(g2);
		}
	}
	
	protected void init() {
		return;
	}
	
	
	public void addComponent(Component component) {
		components.add(component);
	}
	
	public void removeComponent(String name) {
		components.remove(this.getComponent(name));
	}
	
	public Component getComponent(String name) {
		for(Component c : components) {
			if(c.getName() == name) {
				return c;
			}
		}
		System.out.println(this.name + " component "+ name + " nenalezen");
		return null;
	}

	public Vector2 getPossition() {
		return possition;
	}

	public void setPossition(Vector2 possition) {
		this.possition = possition;
	}

	public Proportions getProportions() {
		return proportions;
	}

	public void setProportions(Proportions proportions) {
		this.proportions = proportions;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public float getY() {
		return (possition.getY());
	}
	
	public float getX() {
		return (possition.getX());
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
