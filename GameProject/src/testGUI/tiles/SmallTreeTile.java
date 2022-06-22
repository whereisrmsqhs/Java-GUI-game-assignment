package testGUI.tiles;

import testGUI.gfx.Assets;

public class SmallTreeTile extends Tile{

	public SmallTreeTile(int id) {
		super(Assets.smallTree, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
}
