package dev.learninggame;

import dev.learninggame.Game;
import dev.learninggame.gfx.Som;

//Responsavel por inciar o game
public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game("BOMBER MAN", 850, 650);
		game.start();
	}
	
	
}
