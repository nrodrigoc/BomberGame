package dev.learninggame.entities.creatures;

import dev.learninggame.Handler;
import dev.learninggame.entities.Bomb;
import dev.learninggame.entities.Entity;
import dev.learninggame.tiles.Tile;

public abstract class Creature extends Entity{
	
	public static final int UP = 55;
	public static final int DOWN = 56;
	public static final int LEFT = 57;
	public static final int RIGHT = 58;
			
	public static final float DEFAULT_SPEED = 3.f;
	//Tamanho em pixels das criaturas
	public static final int DEFAULT_CREATURE_WIDTH = 100,
							DEFAULT_CREATURE_HEIGHT = 79;
	
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		if(xMove > 0) {//Moving Right
		    
		    int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
		    
		    //Verifica se a hitbox da criatura esta em contato com algo solido
		    if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
		    		!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) && collisionWithBomb(RIGHT)) {
		    	x += xMove;
		    }else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		    
		}else if(xMove < 0) {//Moving Left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
		    if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
		    		!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) && collisionWithBomb(LEFT)) {
		    	x += xMove;
		    }else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	
	public void moveY() {
		if(yMove < 0) { //Cima
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
		
			if(!collisionWithTile((int) ((x + bounds.x) / Tile.TILEWIDTH), ty) &&
					!collisionWithTile((int) ((x + bounds.x + bounds.width) / Tile.TILEWIDTH), ty) && collisionWithBomb(UP)){
					y += yMove;
			}else {
				y = ty * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.y;
			}
			
		}else if(yMove > 0) { //Baixo 
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) ((x + bounds.x) / Tile.TILEWIDTH), ty) &&
					!collisionWithTile((int) ((x + bounds.x + bounds.width) / Tile.TILEWIDTH), ty) && collisionWithBomb(DOWN)) {
					y += yMove;
			}else {
				y = ty * Tile.TILEWIDTH - bounds.height - bounds.y - 1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	/**
	 * @author Nathan Rodrigo
	 * @param direction direcao para onde o personagem vai andar
	 * @return false se o player pode seguir em frente
	 */
	protected boolean collisionWithBomb(int direction){
		Bomb bomb = new Bomb(handler, x, y);
		if(direction == DOWN &&
				handler.getWorld().hasBomb(getCurrentTileX(x), getCurrentTileY(y+26))) {
			
			bomb = handler.getWorld().getBomb(getCurrentTileX(x), getCurrentTileY(y+26));
			int boundsBombY = (int)bomb.getBoundsY();
			if(this.y < boundsBombY - Tile.TILEHEIGHT)
				return false;
			
		}else if(direction == UP &&
				handler.getWorld().hasBomb(getCurrentTileX(x), getCurrentTileY(y-12))) {
			
			bomb = handler.getWorld().getBomb(getCurrentTileX(x), getCurrentTileY(y-12));
			int boundsBombY = (int)bomb.getBoundsY();
			if(this.y > boundsBombY)
				return false;
		}else if(direction == RIGHT &&
				handler.getWorld().hasBomb(getCurrentTileX(x+16), getCurrentTileY(y))) {
			
			bomb = handler.getWorld().getBomb(getCurrentTileX(x+16), getCurrentTileY(y));
			int boundsBombX = (int)bomb.getBoundsX();
			if(this.x < boundsBombX - Tile.TILEWIDTH)
				return false;
		}else if(direction == LEFT &&
				handler.getWorld().hasBomb(getCurrentTileX(x-16), getCurrentTileY(y))) {
			
			bomb = handler.getWorld().getBomb(getCurrentTileX(x-16), getCurrentTileY(y));
			int boundsBombX = (int)bomb.getBoundsX();
			if(this.x > boundsBombX)
				return false;
		}
			return true;
	}
	/*
	public boolean collisionwithcreatures(int x, int y) {
		
	}
	*/
	
	//GETTERS AND SETTERS
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
}
