package dev.learninggame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.learninggame.Handler;
import dev.learninggame.tiles.Tile;

/**
 * 
 * @author nrodrigo
 * Classe responsavel por conter os atributos das entidades contidas no jogo
 */
public abstract class Entity {
	
	public static final int DEFAULT_HEALTH = 50;
	
	protected Handler handler;
	protected float x, y;
	protected int width, height;

	//Vida da entidade
	protected int health;
	protected boolean active = true;

	//Rentangulo do Hitbox
	protected Rectangle bounds;
	
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		setHealth(DEFAULT_HEALTH);
		
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	protected abstract void die();

	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	/** @author Nathan Rodrigo
	 * @param x Posicao X em pixel da criatura
	 * @return A coordenada X da Tile onde se encontra a criatura*/
	public int getCurrentTileX(float x) {
		for(int i = 0; i < (handler.getHeight()/Tile.TILEHEIGHT) + (Tile.TILEHEIGHT*2); i++) {
			if(x <= Tile.TILEHEIGHT*i) {
				return i;
			}
		}
		return 0;
	}
	
	/** @author Nathan Rodrigo
	 * @param y Posicao Y em pixel da criatura
	 * @return A coordenada Y da Tile onde se encontra a criatura*/
	public int getCurrentTileY(float y) {
		for(int i = 0; i < handler.getHeight()/Tile.TILEHEIGHT + (Tile.TILEWIDTH*2); i++) {
			if(y <= Tile.TILEHEIGHT*i) {
				return i;
			}
		}
		return 0;
	}
	
	
}
