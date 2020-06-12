package components;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import entities.Entity;
import main.Game;
import util.Vector2;

public class Component_PlayerMovement extends Component{

	public Component_PlayerMovement(Entity entity) {
		super(entity, "PlayerMovement");
		
	}

	@Override
	public void update() {
		Vector2 direction = new Vector2(0,0);
		Component_Movement movement =(Component_Movement) entity.getComponent("Movement");
		Component_Stats stats = (Component_Stats) entity.getComponent("Stats");
		float movementSpeed = stats.getMovementSpeed();
		
		if(Game.keyListener.isKeyPressed(KeyEvent.VK_W)) {
			direction.addVector2(new Vector2(0,-1));
		}
			
		if(Game.keyListener.isKeyPressed(KeyEvent.VK_A)) {
			direction.addVector2(new Vector2(-1,0));
		}
		
		if(Game.keyListener.isKeyPressed(KeyEvent.VK_S)) {
			direction.addVector2(new Vector2(0,1));
		}
		
		if(Game.keyListener.isKeyPressed(KeyEvent.VK_D)) {
			direction.addVector2(new Vector2(1,0));
		}
		
		movement.walk(direction.multiply(movementSpeed/10), movementSpeed);
		
		if(direction.getX() != 0 && direction.getY()!= 0) {

		}
		
		else {

			if(direction.getX()==0) {
			movement.slowDownX(movementSpeed/10);
			}
		
			if(direction.getY()==0) {
			movement.slowDownY(movementSpeed/10);
			}
		
		}
		if(direction.getX() == 0 && direction.getY()==0) {
			entity.setStatus(0);
		}
		else {
			entity.setStatus(1);
			entity.setDirection(direction.getNumDirection());
		}

	}
	
}
