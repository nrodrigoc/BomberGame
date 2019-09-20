package dev.learninggame.worlds;

import java.awt.Graphics;
import java.util.Iterator;

import dev.learninggame.Handler;
import dev.learninggame.entities.Bomb;
import dev.learninggame.entities.Brick;
import dev.learninggame.entities.EntityManager;
import dev.learninggame.entities.Fire;
import dev.learninggame.entities.creatures.Player;
import dev.learninggame.entities.creatures.PlayerGirl;
import dev.learninggame.tiles.Tile;
import dev.learninggame.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnXBoy, spawnYBoy, spawnXGirl, spawnYGirl;
	//Coordenadas das tiles
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	//ID da ultima explosao ocorrida no jogo
	private int currentId;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100),  new PlayerGirl(handler, 100, 100));
		loadWorld(path);
		
		currentId = 0;
		
		entityManager.getPlayer().setX(spawnXBoy);
		entityManager.getPlayer().setY(spawnYBoy);
		entityManager.getPlayerGirl().setX(spawnXGirl);
		entityManager.getPlayerGirl().setY(spawnYGirl);
	}
	
	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g){
		for(int y = 0; y < handler.getHeight()/Tile.TILEHEIGHT; y++){
			for(int x = 0; x < handler.getWidth()/Tile.TILEWIDTH; x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH),(int) (y * Tile.TILEHEIGHT));
			}
		}
		//Entities
		entityManager.render(g);
		
	}
	
	public Tile getTile(int x, int y) {
		if ( x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	/*Metodo capaz de transformar o mapa de ids do arquivo txt em um mapa de imagens
	 * */
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnXBoy = Utils.parseInt(tokens[2]);
		spawnYBoy = Utils.parseInt(tokens[3]);
		spawnXGirl = Utils.parseInt(tokens[4]);
		spawnYGirl = Utils.parseInt(tokens[5]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				if(Utils.parseInt(tokens[(x + y * width) + 6]) == 4) {
					tiles[x][y] = 0;
					putBrick(x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
					continue;
				}
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 6]);
			}
		}
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	/**
	 * @author Nathan Rodrigo
	 * @param currentPlayerX pos x da tile atual da entidade
	 * @param currentPlayerY pos y da tile atual da entidade
	 * @return True se a tile sugerida possui bomba  
	 */
	public boolean hasBomb(int currentEntityX, int currentEntityY) {
		for(Bomb b : entityManager.getBombs()) {
			int currentBombX = (int)b.getCurrentTileX(b.getX());
			int currentBombY = (int)b.getCurrentTileX(b.getY());
			if(currentEntityX == currentBombX && currentEntityY == currentBombY) {
				return true;
			}
		}
		return false;
	}
	
	public Bomb getBomb(int currentEntityX, int currentEntityY) {
		for(Bomb b : entityManager.getBombs()) {
			int currentBombX = (int)b.getCurrentTileX(b.getX());
			int currentBombY = (int)b.getCurrentTileX(b.getY());
			if(currentEntityX == currentBombX && currentEntityY == currentBombY) {
				return b;
			}
		}
		return null;
	}
	
	public boolean hasFire(int currentEntityX, int currentEntityY) {
		for(Fire f : entityManager.getFires()) {
			int currentBombX = (int)f.getCurrentTileX(f.getX());
			int currentBombY = (int)f.getCurrentTileX(f.getY());
			if(currentEntityX == currentBombX && currentEntityY == currentBombY) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasBrick(int currentEntityX, int currentEntityY) {
		for(Brick b : entityManager.getBricks()) {
			int currentBrickX = (int)b.getCurrentTileX(b.getX());
			int currentBrickY = (int)b.getCurrentTileX(b.getY());
			if(currentEntityX == currentBrickX && currentEntityY == currentBrickY) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPlayer(int currentEntityX, int currentEntityY) {
		float playerX = entityManager.getPlayer().getX();
		float playerY = entityManager.getPlayer().getY();
		int currentPlayerX = (int)entityManager.getPlayer().getCurrentTileX(playerX);
		int currentPlayerY = (int)entityManager.getPlayer().getCurrentTileX(playerY);
		if(currentEntityX == currentPlayerX && currentEntityY == currentPlayerY)
			return true;
		
		
		return false;
	}
	
	public Brick getBrick(int currentEntityX, int currentEntityY) {
		for(Brick b : entityManager.getBricks()) {
			int currentBrickX = (int)b.getCurrentTileX(b.getX());
			int currentBrickY = (int)b.getCurrentTileX(b.getY());
			if(currentEntityX == currentBrickX && currentEntityY == currentBrickY) {
				return b;
			}
		}
		return null;
	}
	
	public Tile getPlayer() {
		return null; // Isso nem faz sentido
	}
	
	public void installFire(float bombX, float bombY, int asset, int id) {
		Fire fire = new Fire(handler, bombX, bombY, asset);
		fire.setId(id);
		entityManager.addFire(fire);
		for(int i = 0; i < 2; i++) {
			fire.verifyOpenXleft();
			fire.verifyOpenXright();
			fire.verifyOpenYtop();
			fire.verifyOpenYbot();
		}
	}
	
	public void putBrick(float posX, float posY) {
		Brick brick = new Brick(handler, posX, posY);
		entityManager.addBrick(brick);
	}
	
	public void addCurrentId() {
		this.currentId++;
	}
	
	public int getCurrentId() {
		return currentId;
	}
}
