package util;

public class GameCamera {
	private Vector2 possition;
	
	public GameCamera() {
		possition = new Vector2(0,0);
	}

	public Vector2 getPossition() {
		return possition;
	}

	public void setPossition(Vector2 possition) {
		this.possition = possition;
	}
	
	public void move(Vector2 v2) {
		possition.addVector2(v2);
	}
	
	public int getX() {
		return (int)possition.getX();
	}
	
	public int getY() {
		return (int)possition.getY();
	}
	
}
