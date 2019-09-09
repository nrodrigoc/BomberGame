package dev.learninggame.states;

import java.awt.Graphics;

import dev.learninggame.Handler;
import dev.learninggame.entities.creatures.Enemy;
import dev.learninggame.entities.creatures.PlayerGirl;
import dev.learninggame.worlds.World;

public class GameState extends State {
	
	private World world;
	private Enemy enemy;
	private PlayerGirl playerG;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		
	}
	
	@Override
	public void tick() {
		world.tick();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
