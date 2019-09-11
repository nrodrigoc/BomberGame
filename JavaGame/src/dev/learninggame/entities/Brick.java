package dev.learninggame.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.learninggame.Handler;
import dev.learninggame.gfx.Assets;
import dev.learninggame.tiles.Tile;


/**
 * 
 * @author Nathan Rodrigo
 *Classe dos tijolos destrutiveis
 */
public class Brick extends Entity{

	private BufferedImage brickTexture;
	
	
	public Brick(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		this.brickTexture = Assets.brick;
		
		//Posicao da bomba
		bounds.x = Tile.TILEWIDTH * getCurrentTileX(x);
		bounds.y = Tile.TILEHEIGHT * getCurrentTileY(y);
		//Largura e comprimento da hitbox
		bounds.width = Tile.TILEWIDTH;
		bounds.height = Tile.TILEHEIGHT;
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(brickTexture, Tile.TILEWIDTH*getCurrentTileX(x), 
				Tile.TILEHEIGHT*getCurrentTileY(y), Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
		
	}
	
	public int getBoundsX() {
		return bounds.x;
	}
	
	public int getBoundsY() {
		return bounds.y;
	}
	
	@Override
	protected void die() {
		// TODO Auto-generated method stub
		
	}

}
