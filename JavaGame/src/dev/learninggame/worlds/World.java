package dev.learninggame.worlds;

import java.awt.Graphics;
import java.util.Iterator;

import dev.learninggame.Handler;
import dev.learninggame.entities.Bomb;
import dev.learninggame.entities.EntityManager;
import dev.learninggame.entities.Fire;
import dev.learninggame.entities.creatures.Player;
import dev.learninggame.entities.creatures.PlayerGirl;
import dev.learninggame.tiles.Tile;
import dev.learninggame.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	//Coordenadas das tiles
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	//ID e indice da ultima bomba do arrayList
	//private int currentId;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100),  new PlayerGirl(handler, 100, 100));
		loadWorld(path);
		
		//currentId = -1;
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick() {
		entityManager.tick();
		explodeBombs();
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
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
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
	
	public void explodeBombs() {
		for(Iterator<Bomb> b = entityManager.getBombs().iterator(); b.hasNext(); ) {
			Bomb bomba = b.next();
			if(bomba.getTimeToExplode() > 5000) {
				installFire(bomba.getX(), bomba.getY(), Fire.MAIN);
				b.remove();
				entityManager.getPlayer().addnOfBombs(); //Diminui a contagem de bombas colocadas do player
			}
		}
	}
	
	/**
	 * @author Nathan Rodrigo
	 * @param currentPlayerX pos x da tile atual do player
	 * @param currentPlayerY pos y da tile atual do player
	 * @return True se a tile sugerida possui bomba  
	 */
	public boolean hasBomb(int currentPlayerX, int currentPlayerY) {
		for(Bomb b : entityManager.getBombs()) {
			int currentBombX = (int)b.getCurrentTileX(b.getX());
			int currentBombY = (int)b.getCurrentTileX(b.getY());
			if(currentPlayerX == currentBombX && currentPlayerY == currentBombY) {
				return true;
			}
		}
		return false;
	}
	
	public Bomb getBomb(int currentPlayerX, int currentPlayerY) {
		for(Bomb b : entityManager.getBombs()) {
			int currentBombX = (int)b.getCurrentTileX(b.getX());
			int currentBombY = (int)b.getCurrentTileX(b.getY());
			if(currentPlayerX == currentBombX && currentPlayerY == currentBombY) {
				return b;
			}
		}
		return null;
	}

	public Tile getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void installFire(float bombX, float bombY, int asset) {
		Fire fire = new Fire(handler, bombX, bombY, asset);
		entityManager.addEntity(fire);
		for(int i = 0; i < 2; i++) {
			fire.verifyOpenXleft();
			fire.verifyOpenXright();
			fire.verifyOpenYtop();
			fire.verifyOpenYbot();
		}
		
	}
	
	/*public int currentBombID() {
		return currentId;
	}

	public int getCurrentId() {
		return currentId;
	}
	
	/**
	 * @author Nathan Rodrigo
	 * @param removedId Id da bomba recem removida
	 * <p>Reajusta todos os ids das bombas para que sejam identificadas posteriormente</p>
	 */
	/*public void idReadjustment(int removedId) {
		for(Bomb b : entityManager.getBombs()) {
			System.out.println("Removed: " + removedId + "Current: "+ b.getId());
			if(b.getId() > removedId) {
				b.setId(b.getId()-1);
			}
		}
	}
	
	/public void setCurrentId(int currentId) {
		this.currentId = currentId;
	}*/
}
