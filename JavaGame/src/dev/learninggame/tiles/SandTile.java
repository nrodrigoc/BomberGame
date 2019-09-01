package dev.learninggame.tiles;

import dev.learninggame.gfx.Assets;

public class SandTile extends Tile{
	
	
	public SandTile(int id) {
		super(Assets.sand, id);
		setSolidity(false);
	}
}
