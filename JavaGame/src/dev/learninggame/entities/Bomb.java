package dev.learninggame.entities;

import java.awt.Graphics;

import dev.learninggame.Handler;
import dev.learninggame.gfx.Animation;
import dev.learninggame.gfx.Assets;
import dev.learninggame.tiles.Tile;

public class Bomb extends Entity{
	
	private Animation animBomb;
	
	public Bomb(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		//Posicao da bomba
		bounds.x = (int)x;
		bounds.y = (int)y;
		//Largura e comprimento da hitbox
		bounds.width = Tile.TILEWIDTH;
		bounds.height = Tile.TILEHEIGHT;
		
		animBomb = new Animation(300, Assets.putBomb);
		
	}

	@Override
	public void tick() {
		animBomb.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(animBomb.getCurrentFrame(), (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y- handler.getGameCamera().getyOffset()), Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
		
	}

}
