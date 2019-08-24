package dev.learninggame.tiles;

import dev.learninggame.gfx.Assets;

public class GrassTile extends Tile{
	
	public GrassTile(int id) {
		super(Assets.grass, id);
	}
	
	@Override
	public boolean isSolid() {
		return false;
	}
}
