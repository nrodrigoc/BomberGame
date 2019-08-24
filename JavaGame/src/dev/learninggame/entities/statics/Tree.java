package dev.learninggame.entities.statics;

import java.awt.Graphics;

import dev.learninggame.Handler;
import dev.learninggame.gfx.Assets;
import dev.learninggame.tiles.Tile;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH * 2, Tile.TILEHEIGHT * 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
	
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int)(y- handler.getGameCamera().getyOffset()), width, height, null);
		
	}
	
}
