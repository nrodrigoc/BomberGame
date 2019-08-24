package dev.learninggame.entities.statics;

import dev.learninggame.Handler;
import dev.learninggame.entities.Entity;

//Classe para entidades que nao se movem
public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
	}

}
