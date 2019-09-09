package dev.learninggame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import dev.learninggame.Handler;
import dev.learninggame.entities.creatures.Player;
import dev.learninggame.entities.creatures.PlayerGirl;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private PlayerGirl playerg;
	private ArrayList<Entity> entities;
	private ArrayList<Bomb> bombs; 
	private ArrayList<Fire> fires;
	
	public EntityManager(Handler handler, Player player, PlayerGirl playerg) {
		this.handler = handler;
		this.player = player;
		this.playerg = playerg;
		entities = new ArrayList<>();
		bombs = new ArrayList<>();
		fires = new ArrayList<>();
		addEntity(player);
		addEntity(playerg);
	}
	
	public void tick() {
		for(int i = 0; i < bombs.size(); i++) {
			Entity e = bombs.get(i);
			e.tick();
			if(!e.isActive()) {
				entities.remove(e);
			}
		}
		for(int i = 0; i < fires.size(); i++) {
			Entity e = fires.get(i);
			e.tick();
			if(!e.isActive()) {
				entities.remove(e);
			}
		}
		
		for(int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
			if(!e.isActive()) {
				entities.remove(e);
			}
		}
		
	}
	
	public void render(Graphics g) {
		for(Bomb b : bombs) {
			b.render(g);
		}
		for(Fire f : fires) {
			f.render(g);
		}
		for(Entity e : entities) {
			e.render(g);
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void addBomb(Bomb b) {
		bombs.add(b);
	}
	
	public void addFire(Fire f) {
		fires.add(f);
	}
	
	//GETTERS AND SETTERS
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public ArrayList<Bomb> getBombs(){
		return bombs;
	}
	
	public ArrayList<Fire> getFires(){
		return fires;
	}
	
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	public void removeFire(int id) {
		for(Iterator<Fire> f = fires.iterator(); f.hasNext(); ) {
			Fire fire = f.next();
			if(fire.getId() == id) {
				fire.setActive(false);
				f.remove();
			}
		}
	}
	
	public void removeBomb(int id) {
		bombs.remove(id);
	}
}
