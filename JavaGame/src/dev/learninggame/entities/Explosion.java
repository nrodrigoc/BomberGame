package dev.learninggame.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.learninggame.Handler;
import dev.learninggame.gfx.Assets;
import dev.learninggame.tiles.Tile;

public class Explosion extends Entity{
	
	private BufferedImage[] fireSheet;
	
	public Explosion(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = Tile.TILEWIDTH * getCurrentTileX(x);
		bounds.y = Tile.TILEHEIGHT * getCurrentTileY(y);

		bounds.width = Tile.TILEWIDTH;
		bounds.height = Tile.TILEHEIGHT;
		
		fireSheet = Assets.bombFire;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	private BufferedImage getCurrentTexture() {
		return null;
	}
	
	private boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void die() {
		
	}

}
