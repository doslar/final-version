package components;

import entities.Entity;
import states.State_Game;
import util.Vector2;

public class Component_Movement extends Component{

	private Vector2 momentum;
	
	public Component_Movement(Entity entity) {
		super(entity, "Movement");
		momentum = new Vector2(0,0);
	}
	
	public void forceMove(Vector2 v2) {
		momentum.addVector2(v2);
	}
	
	public void walk(Vector2 v2, float maxSpeed) {
		momentum.addVector2(v2, maxSpeed);
	}
	
	public void slowDownX(float speed) {
		momentum.slowDownX(speed);
	}
	
	public void slowDownY(float speed) {
		momentum.slowDownY(speed);
	}
	
	@Override
	public void update() {
		Component_BoxBounds boxBounds =(Component_BoxBounds) entity.getComponent("BoxBounds");
		if(boxBounds==null) {
			entity.getPossition().addVector2(momentum);			
		}
		else {

				if(!boxBounds.passableX(momentum.getX())) {
					int i = 0;
					if(momentum.getX()>0) {
						while(boxBounds.passableX(i+1)) {
							i++;
							}
						momentum.setX(i);
					} else if(momentum.getX()<0) {
							while(boxBounds.passableX(i-1)) {
								i--;
								}
							momentum.setX(i);
					}
						
				}
			

				if(!boxBounds.passableY(momentum.getY())) {
					int i = 0;
					if(momentum.getY()>0) {
						while(boxBounds.passableY(i+1)) {
							i++;
							}
						momentum.setY(i);
					} else if(momentum.getY()<0) {
							while(boxBounds.passableY(i-1)) {
								i--;
								}
							momentum.setY(i);
					}
					

			}
							entity.getPossition().addVector2(momentum);	
		}
	}
}
