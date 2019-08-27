package dev.learninggame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.learninggame.Handler;

/**
 * 
 * @author nrodrigo
 * Classe responsavel por conter os atributos das entidades contidas no jogo
 */
public abstract class Entity {
	
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	//Rentangulo do Hitbox
	protected Rectangle bounds;
	
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
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

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
	}
}
