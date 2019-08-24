package dev.learninggame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC STUFF
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rockTile = new RockTile(2);
	public static Tile sandTile = new SandTile(3);
	public static Tile brickTile = new BrickTile(4);
	
	//CLASS
	public static final int TILEWIDTH = 40, TILEHEIGHT = 40; // Tamanho dos elementos do mapa
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture,int id) {
		this.texture = texture;
		this.id = id;
	
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEWIDTH, null);
	}
	
	public boolean isSolid() {
		return true;
	}
	
	public int getId() {
		return id;
	}
	
	
}
