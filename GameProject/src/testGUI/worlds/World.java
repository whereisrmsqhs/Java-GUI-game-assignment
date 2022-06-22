package testGUI.worlds;

import java.awt.Graphics;

import testGUI.Handler;
import testGUI.entities.EntityManager;
import testGUI.entities.creatures.Player;
import testGUI.entities.statics.BigTree;
import testGUI.entities.statics.House;
import testGUI.entities.statics.PBall;
import testGUI.entities.statics.PCenter;
import testGUI.entities.statics.PMart;
import testGUI.entities.statics.Sea;
import testGUI.tiles.Tile;
import testGUI.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int [][] tiles;
	
	private EntityManager entityManager;
	
	public World(Handler  handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		entityManager.addEntity(new House(handler, 200, 500));
		for(int i = 70;i<1000;i+=70) {
			entityManager.addEntity(new BigTree(handler, i, 300));
		}
	    //entityManager.addEntity(new BigTree(handler, 70, 300));
	    //entityManager.addEntity(new BigTree(handler, 140, 300));
		entityManager.addEntity(new PCenter(handler, 700, 500));
		entityManager.addEntity(new PMart(handler, 700, 900));
		entityManager.addEntity(new Sea(handler, 200, 900));
		//entityManager.addEntity(new PBall(handler, 1140,1000));       위치가 애매함
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g) { 
		int xStart =(int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0,  handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y =yStart;y< yEnd ; y++) {
			for(int x = xStart; x< xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),(int)( y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y< 0 || x>= width || y>= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if( t == null )
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path) {		//입력값 불러오기 
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++) {
			for(int x = 0;x<width;x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
