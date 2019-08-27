package dev.learninggame;

import dev.learninggame.Game;

//Responsavel por inciar o game
public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game("METAL SLUG", 800, 650);
		game.start();
	}
	
	
}
