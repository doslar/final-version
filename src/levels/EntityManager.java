package levels;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entities.Entity;
import util.Proportions;
import util.Vector2;

public class EntityManager {
	
	private List<Entity> entities;
	private Comparator<Entity> comparator;
	
	public EntityManager() {
		comparator = new Comparator<Entity>() {

			@Override
			public int compare(Entity e1, Entity e2) {
				int compareValue= Integer.compare((int)e1.getPossition().getY(),(int) e2.getPossition().getY());
				return compareValue;
			}
		};
		
		entities = new ArrayList<Entity>();
		

	}
	
	public void update() {
		for(Entity e : entities) {
			e.update();
		}
		entities.sort(comparator);
	}
	
	public void render(Graphics2D g2) {
		for(Entity e : entities) {
			e.render(g2);
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public Entity getEntity(String id) {
		for( Entity e : entities) {
			
			if(e.getId().equals(id))
				return e;
		}
		return null;	
	}
}
