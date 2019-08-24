package dev.learninggame.gfx;

import java.awt.image.BufferedImage;

//Imagem, som ou musica do jogo
public class Assets {
	
	private static final int w = 32, h = 32; // Width and Height
	
	public static BufferedImage grass, dirt, rock, sand, brick, player, tree;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	
	/**Separacao dos Sprites*/
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet2.png"));
		
		player_down = new BufferedImage[2];
		player_down[1] = sheet.crop(w*3, 0, w, h);
		player_down[0] = sheet.crop(w*3, h, w, h);
		
		player_left = new BufferedImage[3];
		player_left[0] = sheet.crop(0, h*2, w, h);
		player_left[1] = sheet.crop(w, h*2, w, h);
		player_left[2] = sheet.crop(w*2, h*2, w, h);
		
		player_right = new BufferedImage[3];
		player_right[0] = sheet.crop(0, h*3, w, h);
		player_right[1] = sheet.crop(w, h*3, w, h);
		player_right[2] = sheet.crop(w*2, h*3, w, h);
		
		
		player = sheet.crop(w*2, h, w, h);
		grass = sheet.crop(0, 0, w, h);
		sand = sheet.crop(w, 0, w, h);
		rock = sheet.crop(w * 2, 0, w, h);
		dirt = sheet.crop(0, h, w, h);
		brick = sheet.crop(w, h, w, h);
		tree = sheet.crop(w*3, h*2, w, h);
	}
	
}
