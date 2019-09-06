package dev.learninggame.gfx;

import java.awt.image.BufferedImage;

//Imagem, som ou musica do jogo
public class Assets {
	
	private static final int w = 32, h = 32; // Width and Height
	private static final int wMan = 125, hMan = 125;
	private static final int wEnemy = 50, hEnemy = 94; //altura e largura da imagem 50x94
	private static final int wWoman = 100, hWoman = 100;
	private static final int sFire = 48;
	
	public static BufferedImage grass, dirt, rock, sand, brick, player, tree, enemy, woman;
	//omi
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	
	public static BufferedImage[] putBomb;
	public static BufferedImage[] bombFire;
	
	public static BufferedImage[] btn_play;
	
	//girl
	public static BufferedImage[] playerg_up;
	public static BufferedImage[] playerg_down;
	public static BufferedImage[] playerg_left;
	public static BufferedImage[] playerg_right;
	
	
	
	/**Separacao dos Sprites*/
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet2.png"));
		SpriteSheet botao = new SpriteSheet(ImageLoader.loadImage("/textures/botao.png"));
		SpriteSheet manSheet = new SpriteSheet(ImageLoader.loadImage("/textures/man.png"));
		SpriteSheet bombSheet = new SpriteSheet(ImageLoader.loadImage("/textures/bomba.png"));
		SpriteSheet enemySheet =  new SpriteSheet(ImageLoader.loadImage("/textures/patinador.png"));
		SpriteSheet girlSheet =  new SpriteSheet(ImageLoader.loadImage("/textures/woman.png"));
		SpriteSheet fireSheet = new SpriteSheet(ImageLoader.loadImage("/textures/explosao.png"));
		
		player = manSheet.crop(wMan, hMan*2, wMan, hMan); //primeira posicao no  frame
		enemy = enemySheet.crop(0, 0, wEnemy, hEnemy);
		woman = girlSheet.crop(0, 0, wWoman, hWoman); //primeira posicçao do frame na tela
		grass = sheet.crop(0, 0, w, h);
		sand = sheet.crop(w, 0, w, h);
		rock = sheet.crop(w * 2, 0, w, h);
		dirt = sheet.crop(0, h, w, h);
		brick = sheet.crop(w, h, w, h);
		tree = sheet.crop(w*3, h*2, w, h);
		
		
		//sequencias de passos muie - ta meio bugado pq ela anda muito detalhe q dps eu arrumo
		playerg_down = new BufferedImage[6];
		playerg_down[0] = girlSheet.crop(0, 0, wWoman, hWoman);
		playerg_down[1] = girlSheet.crop(wWoman, 0, wWoman, hWoman);
		playerg_down[2] = girlSheet.crop(wWoman*2, 0, wWoman, hWoman);
		playerg_down[3] = girlSheet.crop(wWoman*3, 0, wWoman, hWoman);
		playerg_down[4] = girlSheet.crop(wWoman*4, 0, wWoman, hWoman);
		playerg_down[5] = girlSheet.crop(wWoman*5, 0, wWoman, hWoman);
		
		playerg_up = new BufferedImage[6];
		playerg_up[0] = girlSheet.crop(0, hWoman, wWoman, hWoman);
		playerg_up[1] = girlSheet.crop(wWoman, hWoman, wWoman, hWoman);
		playerg_up[2] = girlSheet.crop(wWoman*2, hWoman, wWoman, hWoman);
		playerg_up[3] = girlSheet.crop(wWoman*3, hWoman, wWoman, hWoman);
		playerg_up[4] = girlSheet.crop(wWoman*4, hWoman, wWoman, hWoman);
		playerg_up[5] = girlSheet.crop(wWoman*5, hWoman, wWoman, hWoman);
		
		playerg_right = new BufferedImage[6];
		playerg_right[0] = girlSheet.crop(0, hWoman*2, wWoman, hWoman);
		playerg_right[1] = girlSheet.crop(wWoman, hWoman*2, wWoman, hWoman);
		playerg_right[2] = girlSheet.crop(wWoman*2, hWoman*2, wWoman, hWoman);
		playerg_right[3] = girlSheet.crop(wWoman*3, hWoman*2, wWoman, hWoman);
		playerg_right[4] = girlSheet.crop(wWoman*4, hWoman*2, wWoman, hWoman);
		playerg_right[5] = girlSheet.crop(wWoman*5, hWoman*2, wWoman, hWoman);
		
		playerg_left = new BufferedImage[6];
		playerg_left[0] = girlSheet.crop(0, hWoman*3, wWoman, hWoman);
		playerg_left[1] = girlSheet.crop(wWoman, hWoman*3, wWoman, hWoman);
		playerg_left[2] = girlSheet.crop(wWoman*2, hWoman*3, wWoman, hWoman);
		playerg_left[3] = girlSheet.crop(wWoman*3, hWoman*3, wWoman, hWoman);
		playerg_left[4] = girlSheet.crop(wWoman*4, hWoman*3, wWoman, hWoman);
		playerg_left[5] = girlSheet.crop(wWoman*5, hWoman*3, wWoman, hWoman);
		
		
		//sequencias de passos do omi
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
		putBomb[1] = bombSheet.crop(0, 512, 512, 512);
		
		bombFire = new BufferedImage[9];
		bombFire[0] = fireSheet.crop(0, 0, sFire, sFire); //Main
		bombFire[1] = fireSheet.crop(sFire, 0, sFire, sFire); //mid-right
		bombFire[2] = fireSheet.crop(sFire*2, 0, sFire, sFire); //right
		bombFire[3] = fireSheet.crop(sFire*2, sFire, sFire, sFire); //mid-left
		bombFire[4] = fireSheet.crop(sFire, sFire, sFire, sFire); //left
		bombFire[5] = fireSheet.crop(0, sFire, sFire, sFire); //mid-down
		bombFire[6] = fireSheet.crop(0, sFire*2, sFire, sFire); //down
		bombFire[7] = fireSheet.crop(sFire*3, sFire, sFire, sFire); //mid-top
		bombFire[8] = fireSheet.crop(sFire*3, 0, sFire, sFire); //top
		
		btn_play = new BufferedImage[2];
		btn_play[0] = botao.crop(9, 6, 293, 297);
		btn_play[1] = botao.crop(332, 6, 293, 297);
		
		
	}
	
}
