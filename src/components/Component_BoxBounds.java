package components;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import entities.Entity;
import states.State_Game;
import util.Constants;
import util.Vector2;

public class Component_BoxBounds extends Component{

	private Vector2 center;
	private int polomerX, polomerY;

	public Component_BoxBounds(Entity entity,int width,int height) {
		super(entity, "BoxBounds");
		this.polomerX=width/2;
		this.polomerY=height/2;
		update();
	}

	@Override
	public void update() {
		center = new Vector2(entity.getX(),entity.getY()-polomerY);
	}
	
	@Override
	public void render(Graphics2D g2) {
		if(Constants.showBoxBounds) {
			g2.drawRect((int)(center.getX()-polomerX),(int)(center.getY()-polomerY),polomerX*2,polomerY*2);
		}
	}

	
	public boolean passableX(float momentum) {
		if(momentum>0) {
			int x = (int) (center.getX()+polomerX+momentum);
			for(int i = 0; i<((polomerY*2)/Constants.tileSize)+1;i++) {
				if(!isTilePassable(x,(int) ((center.getY()-polomerY)+(i*Constants.tileSize)))) 
					return false;
			}
			if(!isTilePassable(x,(int)(center.getY()+polomerY)))
				return false;
		}else 	if(momentum<0) {
					int x = (int) ((center.getX()-polomerX)+momentum);
					
					for(int i = 0; i<((polomerY*2)/Constants.tileSize)+1;i++) {
						if(!isTilePassable(x,(int) ((center.getY()-polomerY)+(i*Constants.tileSize)))) 
							return false;
						
					}
					if(!isTilePassable(x,(int)(center.getY()+polomerY)))
						return false;
		}
		return true;
	}
	
	public boolean passableY(float momentum) {
		if(momentum>0) {
			int y =(int) ((center.getY()+polomerY)+momentum);
			for(int i = 0; i<((polomerX*2)/Constants.tileSize)+1;i++) {
				if(!isTilePassable((int) ((center.getX()-polomerX)+(i*Constants.tileSize)), y))
					return false;
			}
			if(!isTilePassable((int) ((center.getX()+polomerX)), y))
				return false;
		}else if (momentum<0) {
			int y =(int) ((center.getY()-polomerY)+momentum);
			for(int i = 0; i<((polomerX*2)/Constants.tileSize)+1;i++) {
				if(!isTilePassable((int) ((center.getX()-polomerX)+(i*Constants.tileSize)), y))
						return false;
			}
			if(!isTilePassable((int) ((center.getX()+polomerX)), y))
				return false;
		}	
		return true;
	}
	
	private boolean isTilePassable(float x,float y) {
		return State_Game.currentLevel.getTileCoordinates(x, y).isPassable();
	}
}
