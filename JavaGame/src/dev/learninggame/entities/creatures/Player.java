package dev.learninggame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.learninggame.Handler;
import dev.learninggame.gfx.Animation;
import dev.learninggame.gfx.Assets;

public class Player extends Creature implements Runnable{
	
	//Animations
	private Animation animDown;
	private Animation animLeft;
	private Animation animRight;
	@Override
	public void run() {
		System.out.println("player iniciado");
	}
	
	public Player(Handler handler, float x, float y) {	
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//ajuste
		bounds.x = 21;
		bounds.y = 24;
		//largura e comprimento da hitbox
		bounds.width = 17;
		bounds.height = 23;
		
		//Animations
		animDown = new Animation(400, Assets.player_down);
		animLeft = new Animation(200, Assets.player_left);
		animRight = new Animation(200, Assets.player_right);
	}

	@Override
	public void tick() {
		//Animations
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
	
	@Override
	public void render(Graphics g) {

		g.drawImage(getCurrentAnimation(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y- handler.getGameCamera().getyOffset()), width, height, null);
		
		g.setColor(Color.red); // Testar hit box
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

	private BufferedImage getCurrentAnimation() {
		if(xMove > 0)
			return animRight.getCurrentFrame();
		if(xMove < 0)
			return animLeft.getCurrentFrame();
		if(yMove > 0)
			return animDown.getCurrentFrame();
		return Assets.player;
	}
	
	

}
