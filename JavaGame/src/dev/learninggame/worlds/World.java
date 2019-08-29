package dev.learninggame.worlds;

import java.awt.Graphics;

import dev.learninggame.Handler;
import dev.learninggame.entities.Bomb;
import dev.learninggame.entities.Entity;
import dev.learninggame.entities.EntityManager;
import dev.learninggame.entities.creatures.Player;
import dev.learninggame.tiles.Tile;
import dev.learninggame.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	//Coordenadas das Tiles para as bombas
	private boolean[][] coordinates;
	//Entities
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g){
		/*//for(Entity e : entityManager.getEntities()) 
		//contem o inicio do campo de visao do jogador no eixo x
		int xStart = 0;
		//contem o fim do campo de visao do jogador no eixo x
		
		int xEnd = (int) Math.min(width, (handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getWidth()) / Tile.TILEHEIGHT + 1);
		*/
		
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
		coordinates = new boolean[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
				coordinates[x][y] = false;
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public boolean hasBomb(int x, int y) {
		System.out.println(coordinates[x][y]);
		return coordinates[x][y];
	}

	public void setCoordinates(int x, int y, boolean b) {
		coordinates[x][y] = b;
	}
	
	
	
}
