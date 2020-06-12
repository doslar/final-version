package states;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entities.Entity;
import entities.Entity_Rock;
import entities.Entity_Test;
import levels.Level;
import util.Constants;
import util.GameCamera;
import util.Proportions;
import util.Vector2;

public class State_Game extends State{
	
	private List<Entity> entities;
	public static Level currentLevel;
	private static GameCamera camera = new GameCamera();

	
	public State_Game() {

		currentLevel= new Level("res/worlds/world1.txt");

		}
	
	@Override
	public void update() {
		currentLevel.update();

	}

	@Override
	public void render(Graphics2D g2) {
		
		g2.translate(-(camera.getX()-(Constants.WINDOW_WIDTH/2)), -(camera.getY()-(Constants.WINDOW_HEIGHT/2)));
		currentLevel.render(g2);
		
		g2.translate((camera.getX()-(Constants.WINDOW_WIDTH/2)), (camera.getY()-(Constants.WINDOW_HEIGHT/2)));

		//g2.drawLine(Constants.WINDOW_WIDTH/2, 0, Constants.WINDOW_WIDTH/2, Constants.WINDOW_HEIGHT);
		//g2.drawLine(0, Constants.WINDOW_HEIGHT/2, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT/2);
	}

	public void addEntity(Entity entity) {
		entities.add(entity);
	}

	public static GameCamera getCamera() {
		return camera;
	}

	public static void setCamera(GameCamera camera) {
		State_Game.camera = camera;
	}

}
