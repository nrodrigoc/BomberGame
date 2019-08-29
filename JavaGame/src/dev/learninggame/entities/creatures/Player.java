package dev.learninggame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.learninggame.Handler;
import dev.learninggame.entities.Bomb;
import dev.learninggame.gfx.Animation;
import dev.learninggame.gfx.Assets;

public class Player extends Creature implements Runnable{
	
	//Atributos
	private Bomb bomb;
	private int nOfBombs;
	
	
	//Animations
	private Animation animUp;
	private Animation animDown;
	private Animation animLeft;
	private Animation animRight;
	
	@Override
	public void run() {
		System.out.println("player iniciado");
	}
	
	public Player(Handler handler, float x, float y) {	
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bomb = null;
		nOfBombs = 1;
		
		//ajuste da posicao da hitbox
		bounds.x = 29;
		bounds.y = 40;
		//largura e comprimento da hitbox
		bounds.width = 22;
		bounds.height = 35;
		
		//Animations
		animUp = new Animation(180, Assets.player_up);
		animDown = new Animation(180, Assets.player_down);
		animLeft = new Animation(150, Assets.player_left);
		animRight = new Animation(150, Assets.player_right);
	}

	@Override
	public void tick() {
		//Animations
		animUp.tick();
		animDown.tick();
		animRight.tick();
		animLeft.tick();
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput() {
		xMove = 0; //variaveis declaradas na classe Creature
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		if(handler.getKeyManager().bomb)
			installBomb();
			
		
		/*else if(numero == 2) { 2 player
			if(handler.getKeyManager().up2)
				yMove = -speed;
			if(handler.getKeyManager().down2)
				yMove = speed;
			if(game.getKeyManager().left2)
				xMove = -speed;
			if(game.getKeyManager().right2)
				xMove = speed;
		}else {
			return;
		}*/
		
	}
	
	private void installBomb() {
		float bombPosX = (float)x + 15;
		float bombPosY = (float)y + 25;
		handler.getWorld().installBomb(bombPosX, bombPosY);
	}
	
	
	@Override
	public void render(Graphics g) {

		g.drawImage(getCurrentAnimation(), (int)(x), (int)(y), width, height, null);
		
		/*g.setColor(Color.red); // Testar hit box
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);*/
	}

	private BufferedImage getCurrentAnimation() {
		if(xMove > 0)
			return animRight.getCurrentFrame();
		if(xMove < 0)
			return animLeft.getCurrentFrame();
		if(yMove > 0)
			return animDown.getCurrentFrame();
		if(yMove < 0)
			return animUp.getCurrentFrame();
		return Assets.player;
	}
	
	

}
