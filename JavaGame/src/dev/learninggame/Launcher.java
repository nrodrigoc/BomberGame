package dev.learninggame;

import dev.learninggame.Game;

//Responsavel por inciar o game
public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game("The bomber game", 850, 650);
		game.start();
	}
	
	
}
