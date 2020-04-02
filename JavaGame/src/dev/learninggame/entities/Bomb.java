package dev.learninggame.entities;

import java.awt.Graphics;

import dev.learninggame.Handler;
import dev.learninggame.gfx.Animation;
import dev.learninggame.gfx.Assets;
import dev.learninggame.tiles.Tile;

public class Bomb extends Entity{
	
	private Animation animBomb;
	//Tempo que a bomba esta ativa
	private long initialTime;
	private long timeToExplode;
	private int id;

	public Bomb(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		//id da bomba e posicao dela no array
		
		//Posicao da bomba
		bounds.x = Tile.TILEWIDTH * getCurrentTileX(x);
		bounds.y = Tile.TILEHEIGHT * getCurrentTileY(y);
		//Largura e comprimento da hitbox
		bounds.width = Tile.TILEWIDTH;
		bounds.height = Tile.TILEHEIGHT;
		
		//Tempo inial da bomba
		initialTime = System.currentTimeMillis();
		timeToExplode = System.currentTimeMillis();
		
		animBomb = new Animation(300, Assets.putBomb);
		
	}
	
	@Override
	public void tick() {
		animBomb.tick();
		timeToExplode = System.currentTimeMillis();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(animBomb.getCurrentFrame(), Tile.TILEWIDTH*getCurrentTileX(x), 
				Tile.TILEHEIGHT*getCurrentTileY(y), Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
		
		//Teste para hitbox bomba
		/*g.setColor(Color.red); // Testar hit box
		g.fillRect((int) (bounds.x), (int)(bounds.y), bounds.width, bounds.height);*/
	}
	
	public int getBoundsX() {
		return bounds.x;
	}
	
	public int getBoundsY() {
		return bounds.y;
	}
	
	public long getTimeToExplode() {
		return timeToExplode - initialTime;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	protected void die() {}

}
