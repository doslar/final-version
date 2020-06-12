package tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import util.Constants;

public class Tile {
	
	//TileSet
	public static List<Tile> tileSet = new ArrayList<Tile>();
	public static Tile grassTile = new Tile_Grass(0);
	public static Tile redFlowersTile = new Tile_RedFlowers(1);

	protected BufferedImage texture;
	protected final int id;
	// 0 = no obstacle ,(future feature jumpAble, flayAble, ...)
	protected boolean isPassable = true;
	
	public Tile(BufferedImage texture, int id) {
		this.texture=texture;
		this.id =id;
		
		tileSet.add(id, this);
	}
	
	public int getId() {
		return id;
	}
	
	public void update() {
		return;
	}
	
	public boolean isPassable(){
		return isPassable;
	}
	
	public void setPassable(boolean isPassable) {
		this.isPassable=isPassable;
	}
	
	public void render(Graphics2D g2, int x, int y) {
		g2.drawImage(texture, x*Constants.tileSize, y*Constants.tileSize, Constants.tileSize, Constants.tileSize, null);
	}
}
