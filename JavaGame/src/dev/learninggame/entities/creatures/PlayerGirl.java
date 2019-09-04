package dev.learninggame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.learninggame.Handler;
import dev.learninggame.entities.Bomb;
import dev.learninggame.gfx.Animation;
import dev.learninggame.gfx.Assets;
/*
public class PlayerGirl extends Creature{
	//Atributos
	private int maxBombs;
	private int nOfBombs;
		
	//Animations
	private Animation animUp;
	private Animation animDown;
	private Animation animLeft;
	private Animation animRight;
	private long tempoInicio;
	private long tempoFinal;
	
	public PlayerGirl(Handler handler, float x, float y) {	
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//ajuste da posicao da hitbox
		bounds.x = 20;
		bounds.y = 50;
		//largura e comprimento da hitbox
		bounds.width = 20;
		bounds.height = 20;
		
		animDown = new Animation(100, Assets.playerg_down);
		animUp = new Animation(100, Assets.playerg_up);
		animRight = new Animation(100, Assets.playerg_right);
		animLeft = new Animation(100, Assets.playerg_left);
		
		
		

	}

	@Override
	public void tick() {
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		
		getInput();
		move();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimation(), (int)(x), (int)(y), width, height, null);
		g.setColor(Color.red); // Testar hit box
		g.fillRect((int) (x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
		
	}

	@Override
	protected void die() {
		// TODO Auto-generated method stub
		
	}
	
	private void getInput() {
		xMove = 0; //variaveis declaradas na classe Creature
		yMove = 0;
		
		if(handler.getKeyManager().up2)
			yMove = -speed;
		if(handler.getKeyManager().down2)
			yMove = speed;
		if(handler.getKeyManager().left2)
			xMove = -speed;
		if(handler.getKeyManager().right2)
			xMove = speed;
		if(handler.getKeyManager().bomb) {
			if(tempoFinal - tempoInicio > 200) {
				installBomb();
				tempoInicio = tempoFinal;
			}
		}
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
		 
		return Assets.woman;
	}
	public void installBomb() {
		if(!handler.getWorld().hasBomb(getCurrentTileX(x), getCurrentTileY(y+15)) 
				&& nOfBombs < maxBombs) {
			Bomb bomba = new Bomb(handler, (int)x, (int)y+15);
			handler.getWorld().getEntityManager().addBomb(bomba);
			//System.out.println("Bomba plantada");
			nOfBombs++;
		}
	}
 
}
*/