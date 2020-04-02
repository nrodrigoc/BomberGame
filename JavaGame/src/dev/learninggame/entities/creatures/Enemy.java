package dev.learninggame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import dev.learninggame.gfx.Animation;
import dev.learninggame.Handler;
import dev.learninggame.gfx.Assets;
import dev.learninggame.tiles.Tile;

public class Enemy extends Creature{

	public Enemy(Handler handler, float x, float y) {
		super(handler, x, y,  Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		//ajuste da posicao da hitbox
		bounds.x = 10;
		bounds.y = 40;
		//largura e comprimento da hitbox
		bounds.width = 30;
		bounds.height = 35;
		
	}

	@Override
	public void tick() {
		getInput();
		move();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.enemy, (int)(x), (int)(y), null);
		g.setColor(Color.red); // Testar hit box
		//g.fillRect((int) (x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
	}

	@Override
	protected void die() {
		
		
	}

	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		/*
		 * if(handler.getKeyManager().up2) yMove = -speed;
		 * if(handler.getKeyManager().down2) yMove = speed;
		 * if(handler.getKeyManager().left2) xMove = -speed;
		 * if(handler.getKeyManager().right2) xMove = speed;
		 */
	}
	
	public boolean isSolid() {
		return true;
	}
	
	public boolean getisSolid() {
		return isSolid();
	}

}
