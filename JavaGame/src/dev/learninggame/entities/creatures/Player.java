package dev.learninggame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.learninggame.Handler;
import dev.learninggame.entities.Bomb;
import dev.learninggame.entities.Entity;
import dev.learninggame.gfx.Animation;
import dev.learninggame.gfx.Assets;
import dev.learninggame.tiles.Tile;

public class Player extends Creature implements Runnable{
	
	//Atributos
	private int maxBombs;
	private int nOfBombs;
	
	//Animations
	private Animation animUp;
	private Animation animDown;
	private Animation animLeft;
	private Animation animRight;
	
	private Animation animUp2;
	private Animation animDown2;
	private Animation animLeft2;
	private Animation animRight2;
	
	private long tempoInicio;
	private long tempoFinal;
	
	@Override
	public void run() {
		tick();
	}
	
	public Player(Handler handler, float x, float y) {	
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		maxBombs = 10;
		
		//ajuste da posicao da hitbox
		bounds.x = 34;
		bounds.y = 38;
		//largura e comprimento da hitbox
		bounds.width = 30;
		bounds.height = 35;
		
		//Animations
		animUp = new Animation(180, Assets.player_up);
		animDown = new Animation(180, Assets.player_down);
		animLeft = new Animation(150, Assets.player_left);
		animRight = new Animation(150, Assets.player_right);
		
		animDown2 = new Animation(150, Assets.playerg_down);
		animUp2 = new Animation(150, Assets.playerg_up);
		animRight2 = new Animation(150, Assets.playerg_right);
		animLeft2 = new Animation(150, Assets.playerg_left);
		
		//Contagem do tempo
		tempoInicio = 0;
		tempoFinal = System.currentTimeMillis();
	}

	@Override
	public void tick() {
		//Animations
		animUp.tick();
		animDown.tick();
		animRight.tick();
		animLeft.tick();
		
		animUp2.tick();
		animDown2.tick();
		animRight2.tick();
		animLeft2.tick();
		
		//Tempo
		tempoFinal = System.currentTimeMillis();
		
		//Movement
		getInput();
		getInput2();
		move();
		//handler.getGameCamera().centerOnEntity(this);
		//Attack
		checkAttacks();
		
	}
	
	//Melee Attacks
	private void checkAttacks() {
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().bomb) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		}else
			return;
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) 
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)) {
				e.hurt(1);
				return;
			}
			
		}
		
	}
	
	public void die() {
		System.out.println("U lose");
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
		if(handler.getKeyManager().bomb) {
			if(tempoFinal - tempoInicio > 200) {
				installBomb();
				tempoInicio = tempoFinal;
			}
		}
			
			
		
	}
	private void getInput2() {
		
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
	public void installBomb() {
		if(!handler.getWorld().hasBomb(getCurrentTileX(x), getCurrentTileY(y+15)) 
				&& nOfBombs < maxBombs) {
			Bomb bomba = new Bomb(handler, (int)x, (int)y+15);
			handler.getWorld().getEntityManager().addBomb(bomba);
			//System.out.println("Bomba plantada");
			nOfBombs++;
		}
	}
	
	@Override
	public void render(Graphics g) {

		g.drawImage(getCurrentAnimation(), (int)(x), (int)(y), width, height, null);
		g.drawImage(getCurrentAnimation2(), (int)(x), (int)(y), width, height, null);
		
		/*g.setColor(Color.red); // Testar hit box
		g.fillRect((int) (x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);*/
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
	
	private BufferedImage getCurrentAnimation2() {
		
		 if(xMove > 0) 
			 return animRight2.getCurrentFrame(); 
		 if(xMove < 0) 
			 return animLeft2.getCurrentFrame();
		  if(yMove > 0)
			  return animDown2.getCurrentFrame();
		 if(yMove < 0)
			 return animUp2.getCurrentFrame();
		 
		return Assets.woman;
	}

	public int getnOfBombs() {
		return nOfBombs;
	}

	public void addnOfBombs() {
		this.nOfBombs++;
	}
	
	public int getMaxBombs() {
		return maxBombs;
	}

}
