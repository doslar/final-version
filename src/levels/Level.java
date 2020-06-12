package levels;

import java.awt.Graphics2D;
import java.util.UUID;

import entities.Entity;
import entities.Entity_Rock;
import entities.Entity_Test;
import tiles.Tile;
import util.Constants;
import util.Proportions;
import util.Utils;
import util.Vector2;

public class Level {
	//Columns, Rows
	private int[][] tileMap;
	private int width, height;
	private int spawnX, spawnY;
	public static EntityManager entityManager;
	public static BoundsManager boundsManager;
	
	public Level(String path) {
		
		entityManager = new EntityManager();
		boundsManager = new BoundsManager();
		
		loadLevel(path);
		

		
		
		addEntity(new Entity_Test(null,new Vector2(spawnX,spawnY),new Proportions(100, 100, 100)));
		addEntity(new Entity_Rock(null,new Vector2(100,100),new Proportions(50,50)));
	}
	
	private void loadLevel(String path) {
		
		String file = Utils.loadFileAsString(path);
		
		String[] tokens = file.split("\\s+");
		
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tileMap = new int[width][height];
		
		
		for(int r = 0; r<height;r++) {
			for(int c = 0; c<width;c++) {
				tileMap[c][r]=Utils.parseInt(tokens[(c+r*width)+4]);
			}
		}
	}
	
	
	public void update() {
		for(int r = 0; r<height;r++) {
			for(int c = 0; c<width;c++) {
				getTile(c,r).update();
			}
		}
		
		entityManager.update();
	}
	
	public void render(Graphics2D g2) {
		for(int r = 0; r<height;r++) {
			for(int c = 0; c<width;c++) {
				getTile(c,r).render(g2, c, r);
			}
		}
		
		entityManager.render(g2);
	}
	
	public Tile getTile(int x, int y) {
		if( x < 0 || y<0 || x>= width || y>= height)
			return Tile.tileSet.get(0);
		
		Tile t = Tile.tileSet.get(tileMap[x][y]);
		if(t==null)
			return Tile.tileSet.get(0);
		return t;
	}

	public Tile getTileCoordinates(float x, float y) {
		if( (int)x/Constants.tileSize < 0 || (int)y/Constants.tileSize<0 || (int)x/Constants.tileSize>= width || (int)y/Constants.tileSize>= height)
			return Tile.tileSet.get(0);
		
		Tile t = Tile.tileSet.get(tileMap[(int)x/Constants.tileSize][(int)y/Constants.tileSize]);
		if(t==null)
			return Tile.tileSet.get(0);
		return t;
	}
	
	public Tile getTileVector2(Vector2 v2) {
		if( (int)v2.getX()/Constants.tileSize < 0 || (int)v2.getY()/Constants.tileSize<0 || (int)v2.getX()/Constants.tileSize>= width || (int)v2.getY()/Constants.tileSize>= height)
			return Tile.tileSet.get(0);
		
		Tile t = Tile.tileSet.get(tileMap[(int)v2.getX()/Constants.tileSize][(int)v2.getY()/Constants.tileSize]);
		if(t==null)
			return Tile.tileSet.get(0);
		return t;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public String generateId(){
		return UUID.randomUUID().toString();
	}
	
	public void addEntity(Entity e) {
		if(e.getId()==null) {
			String id;
			do {
				id = generateId();
			} while(entityManager.getEntity(id)!=null);
			
			e.setId(id);
		}
		entityManager.addEntity(e);
	}
	
	public Entity getEntity(String id) {
		return entityManager.getEntity(id);
	}
}
