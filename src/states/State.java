package states;

import java.awt.Graphics2D;

public abstract class State {
	
	public abstract void update();
	
	public abstract void render(Graphics2D g2 );
	
	
	
	
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState=state;
	}
	
	public static State getState() {
		return currentState;
	}
}
