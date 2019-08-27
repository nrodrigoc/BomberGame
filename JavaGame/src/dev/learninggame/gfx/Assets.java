package dev.learninggame.gfx;

import java.awt.image.BufferedImage;

//Imagem, som ou musica do jogo
public class Assets {
	
	private static final int w = 32, h = 32; // Width and Height
	private static final int wMan = 125, hMan = 125;
	
	public static BufferedImage grass, dirt, rock, sand, brick, player, tree;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage[] putBomb;
	public static BufferedImage[] btn_play;
	
	
	/**Separacao dos Sprites*/
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet2.png"));
		SpriteSheet botao = new SpriteSheet(ImageLoader.loadImage("/textures/botao.png"));
		SpriteSheet manSheet = new SpriteSheet(ImageLoader.loadImage("/textures/man.png"));
		SpriteSheet bombSheet = new SpriteSheet(ImageLoader.loadImage("/textures/bomba.png"));
		
		btn_play = new BufferedImage[2];
		btn_play[0] = botao.crop(9, 6, 293, 297);
		btn_play[1] = botao.crop(332, 6, 293, 297);
		
		player_left = new BufferedImage[4];
		player_left[0] = manSheet.crop(0, 0, wMan, hMan);
		player_left[1] = manSheet.crop(wMan, 0, wMan, hMan);
		player_left[2] = manSheet.crop(wMan*2, 0, wMan, hMan);
		player_left[3] = manSheet.crop(wMan*3, 0, wMan, hMan);
		
		player_right = new BufferedImage[4];
		player_right[0] = manSheet.crop(0, hMan, wMan, hMan);
		player_right[1] = manSheet.crop(wMan, hMan, wMan, hMan);
		player_right[2] = manSheet.crop(wMan*2, hMan, wMan, hMan);
		player_right[3] = manSheet.crop(wMan*3, hMan, wMan, hMan);
		
		player_down = new BufferedImage[4];
		player_down[0] = manSheet.crop(0, hMan*2, wMan, hMan);
		player_down[1] = manSheet.crop(wMan, hMan*2, wMan, hMan);
		player_down[2] = manSheet.crop(wMan*2, hMan*2, wMan, hMan);
		player_down[3] = manSheet.crop(wMan*3, hMan*2, wMan, hMan);
		
		player_up = new BufferedImage[4];
		player_up[0] = manSheet.crop(0, hMan*3, wMan, hMan);
		player_up[1] = manSheet.crop(wMan, hMan*3, wMan, hMan);
		player_up[2] = manSheet.crop(wMan*2, hMan*3, wMan, hMan);
		player_up[3] = manSheet.crop(wMan*3, hMan*3, wMan, hMan);
		
		putBomb = new BufferedImage[2];
		putBomb[0] = bombSheet.crop(0, 0, 512, 512);
		putBomb[0] = bombSheet.crop(0, 512, 512, 512);
		
		player = manSheet.crop(wMan, hMan*2, wMan, hMan);
		grass = sheet.crop(0, 0, w, h);
		sand = sheet.crop(w, 0, w, h);
		rock = sheet.crop(w * 2, 0, w, h);
		dirt = sheet.crop(0, h, w, h);
		brick = sheet.crop(w, h, w, h);
		tree = sheet.crop(w*3, h*2, w, h);
	}
	
}
