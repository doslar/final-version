package components;

import entities.Entity;
import states.State_Game;
import util.Constants;
import util.Vector2;

public class Component_CameraMan extends Component{

	public Component_CameraMan(Entity entity) {
		super(entity, "CameraMan");
		
	}
	public void update() {
		
		int xOverlap = 0;
		int yOverlap = 0;
		
		if((entity.getX()<Constants.WINDOW_WIDTH/2))
			xOverlap = -10;

		else if(entity.getX()+(Constants.WINDOW_WIDTH/2)>State_Game.currentLevel.getWidth()*Constants.tileSize)
			xOverlap = 10;
		
		if((entity.getY()<Constants.WINDOW_HEIGHT/2))
			yOverlap = -1;

		else if(entity.getY()+(Constants.WINDOW_HEIGHT/2)>(State_Game.currentLevel.getHeight()+1)*Constants.tileSize)
			yOverlap = 1;
		
		switch (xOverlap+yOverlap) {
			case -10 :	State_Game.getCamera().setPossition(new Vector2(Constants.WINDOW_WIDTH/2,entity.getY()));
				return;
			case -11 :	State_Game.getCamera().setPossition(new Vector2(Constants.WINDOW_WIDTH/2,Constants.WINDOW_HEIGHT/2));
				return;	
			case -1  : 	State_Game.getCamera().setPossition(new Vector2(entity.getX(),Constants.WINDOW_HEIGHT/2));
				return;	
			case 10  : 	State_Game.getCamera().setPossition(new Vector2(State_Game.currentLevel.getWidth()*Constants.tileSize-(Constants.WINDOW_WIDTH/2),entity.getY()));
				return;
			case 9   :	State_Game.getCamera().setPossition(new Vector2(State_Game.currentLevel.getWidth()*Constants.tileSize-(Constants.WINDOW_WIDTH/2),Constants.WINDOW_HEIGHT/2));
				return;
			case 1   :	State_Game.getCamera().setPossition(new Vector2(entity.getX(),(State_Game.currentLevel.getHeight()+1)*Constants.tileSize-(Constants.WINDOW_HEIGHT/2)));
				return;	
			case 11  :	State_Game.getCamera().setPossition(new Vector2(State_Game.currentLevel.getWidth()*Constants.tileSize-(Constants.WINDOW_WIDTH/2),(State_Game.currentLevel.getHeight()+1)*Constants.tileSize-(Constants.WINDOW_HEIGHT/2)));
				return;
			case -9  :	State_Game.getCamera().setPossition(new Vector2(Constants.WINDOW_WIDTH/2,(State_Game.currentLevel.getHeight()+1)*Constants.tileSize-(Constants.WINDOW_HEIGHT/2)));
				return;
			default : 	State_Game.getCamera().setPossition(new Vector2(entity.getPossition()));
		}
	}
}
