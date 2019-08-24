package dev.learninggame.tiles;

import dev.learninggame.gfx.Assets;

public class BrickTile extends Tile{
	
	public BrickTile(int id) {
		super(Assets.brick, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
}
