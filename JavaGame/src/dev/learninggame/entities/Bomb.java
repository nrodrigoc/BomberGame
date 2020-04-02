package dev.learninggame.entities;

import java.awt.Graphics;
import java.io.FileNotFoundException;

import dev.learninggame.Handler;
import dev.learninggame.gfx.Animation;
import dev.learninggame.gfx.Assets;
import dev.learninggame.tiles.Tile;

public class Bomb extends Entity{
	
	public static final int BOY = 1;
	public static final int GIRL = 0;
	
	private Animation animBomb;
	//Tempo que a bomba esta ativa
	private long initialTime;
	private long currentTime;
	private int gender;
	private int id;

	public Bomb(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		//Personagem que colocou a bomba
		gender = BOY;
		
		//Posicao da bomba
		bounds.x = Tile.TILEWIDTH * getCurrentTileX(x);
		bounds.y = Tile.TILEHEIGHT * getCurrentTileY(y);
		//Largura e comprimento da hitbox
		bounds.width = Tile.TILEWIDTH;
		bounds.height = Tile.TILEHEIGHT;
		
		//Tempo inicial da bomba
		initialTime = System.currentTimeMillis();
		currentTime = System.currentTimeMillis();
		
		animBomb = new Animation(300, Assets.putBomb);
		
	}
	
	@Override
	public void tick() {
		animBomb.tick();
		verifyTime();
		currentTime = System.currentTimeMillis();
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
		return currentTime - initialTime;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void explodeThisBomb() {
		System.out.println("aqui");
		currentTime = System.currentTimeMillis() + 5000;
	}
	
	/**
	 * @author Nathan Rodrigo
	 * Funcao para verificar se o tempo da bomba deve esgotar
	 * @throws FileNotFoundException 
	 */
	public void verifyTime() {
		int fireId = handler.getWorld().getCurrentId();
		if(getTimeToExplode() > 5000) {
			handler.getWorld().installFire(x, y, Fire.MAIN, fireId);
			handler.getWorld().getEntityManager().removeBomb(id);
			handler.getWorld().addCurrentId();
			if(gender == BOY)
				handler.getWorld().getEntityManager().getPlayer().addnOfBombs();
			else
				handler.getWorld().getEntityManager().getPlayerGirl().addnOfBombs();
			
		}
	}
	
	/*
	 * Aponta qual personagem colocou a bomba
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	@Override
	protected void die() {
	
	}

}
