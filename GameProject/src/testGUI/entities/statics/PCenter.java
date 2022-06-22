package testGUI.entities.statics;

import java.awt.Graphics;

import testGUI.Handler;
import testGUI.gfx.Assets;
import testGUI.tiles.Tile;

public class PCenter extends StaticEntity {

	public PCenter(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH*4 ,Tile.TILEHEIGHT * 4);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.pCenter,(int)(x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width,height,null);
	}
	
	
	
}
