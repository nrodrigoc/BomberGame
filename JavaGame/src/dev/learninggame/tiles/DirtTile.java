package dev.learninggame.tiles;

import dev.learninggame.gfx.Assets;

public class DirtTile extends Tile{

	public DirtTile(int id) {
		super(Assets.dirt, id);
	}
	
	@Override
	public boolean isSolid() {
		return false;
	}
}
