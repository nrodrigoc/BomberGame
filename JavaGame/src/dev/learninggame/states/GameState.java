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
		enemy = new Enemy(handler, 150, 150); //lugar do enemy na tela
		playerG =  new PlayerGirl(handler, 100, 100); //lugar do enemy na tela
	}
	
	@Override
	public void tick() {
		world.tick();
		enemy.tick(); //FAZ O inimigo andar
		playerG.tick();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		enemy.render(g); //aparece o enemy na tela
		playerG.render(g);
	}

}
