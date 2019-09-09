package dev.learninggame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.learninggame.Handler;
import dev.learninggame.gfx.Assets;
import dev.learninggame.tiles.Tile;

public class Fire extends Entity{
	
	public static final int MAIN = 0;
	public static final int MID_RIGHT = 1;
	public static final int RIGHT = 2;
	public static final int MID_LEFT = 3;
	public static final int LEFT = 4;
	public static final int MID_BOT = 5;
	public static final int BOT = 6;
	public static final int MID_TOP = 7;
	public static final int TOP = 8;
	
	private BufferedImage[] fireSheet;
	private int currentAsset;
	
	
	public Fire(Handler handler, float x, float y, int currentAsset) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		this.currentAsset = currentAsset;
		
		bounds.x = Tile.TILEWIDTH * getCurrentTileX(x);
		bounds.y = Tile.TILEHEIGHT * getCurrentTileY(y);

		bounds.width = Tile.TILEWIDTH;
		bounds.height = Tile.TILEHEIGHT;
		
		fireSheet = Assets.bombFire;
	}
	
	@Override
	public void tick() {
	
	}
	
	/**
	 * @author Nathan Rodrigo
	 * Verifica se o fogo pode se espalhar para as Tiles acima
	 */
	public void verifyOpenYtop() {
		//Cima
		int ty = (int) y - Tile.TILEHEIGHT;
		
		if(!collisionWithTile(getCurrentTileX(x), getCurrentTileY(ty)) && this.currentAsset == MAIN) {
			handler.getWorld().installFire(x, ty, MID_TOP);
		}
		if(!collisionWithTile(getCurrentTileX(x), getCurrentTileY(ty)) && this.currentAsset == MID_TOP) {
			handler.getWorld().installFire(x, ty, TOP);
		}
	}
	
	/**
	 * @author Nathan Rodrigo
	 * Verifica se o fogo pode se espalhar para as Tiles abaixo
	 */
	public void verifyOpenYbot() {
		//Cima
		int ty = (int) y + Tile.TILEHEIGHT;
		
		if(!collisionWithTile(getCurrentTileX(x), getCurrentTileY(ty)) && this.currentAsset == MAIN) {
			handler.getWorld().installFire(x, ty, MID_BOT);
		}
		if(!collisionWithTile(getCurrentTileX(x), getCurrentTileY(ty)) && this.currentAsset == MID_BOT) {
			handler.getWorld().installFire(x, ty, BOT);
		}
	}
	
	/**
	 * @author Nathan Rodrigo
	 * Verifica se o fogo pode se espalhar para as Tiles a direita
	 */
	public void verifyOpenXright() {
		//Direita
		int tx = (int) x + Tile.TILEWIDTH;
		
		if(!collisionWithTile(getCurrentTileX(tx), getCurrentTileY(y)) && this.currentAsset == MAIN) {
			handler.getWorld().installFire(tx, y, MID_RIGHT);
		}
		if(!collisionWithTile(getCurrentTileX(tx), getCurrentTileY(y)) && this.currentAsset == MID_RIGHT) {
			handler.getWorld().installFire(tx, y, RIGHT);
		}
	}
	
	/**
	 * @author Nathan Rodrigo
	 * Verifica se o fogo pode se espalhar para as Tiles a esquerda
	 */
	public void verifyOpenXleft() {
		//Esquerda
		int tx = (int) x - Tile.TILEWIDTH;
		
		if(!collisionWithTile(getCurrentTileX(tx), getCurrentTileY(y)) && this.currentAsset == MAIN) {
			handler.getWorld().installFire(tx, y, MID_LEFT);
		}
		if(!collisionWithTile(getCurrentTileX(tx), getCurrentTileY(y)) && this.currentAsset == MID_LEFT) {
			handler.getWorld().installFire(tx, y, LEFT);
		}
	}

	
	private boolean collisionWithTile(int nextTileX, int nextTileY) {
		return handler.getWorld().getTile(nextTileX, nextTileY).isSolid();
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(fireSheet[this.currentAsset], Tile.TILEWIDTH*getCurrentTileX(x), 
				Tile.TILEHEIGHT*getCurrentTileY(y), Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
		
		//Retangulo para testar hitbox do fogo
		/*g.setColor(Color.red); // Testar hit box
		g.fillRect((int) (bounds.x), (int)(bounds.y), bounds.width, bounds.height);*/
		
	}

	@Override
	protected void die() {
		
	}

}
