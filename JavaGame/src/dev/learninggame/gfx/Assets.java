package dev.learninggame.gfx;

import java.awt.image.BufferedImage;

//Imagem, som ou musica do jogo
public class Assets {
	
	private static final int w = 32, h = 32; // Width and Height
	private static final int wMan = 125, hMan = 125;
	private static final int wEnemy = 50, hEnemy = 94; //altura e largura da imagem 50x94
	private static final int Wwoman = 100, Hwoman = 100;
	
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
		grass = sheet.crop(0, 0, w, h);
		sand = sheet.crop(w, 0, w, h);
		rock = sheet.crop(w * 2, 0, w, h);
		dirt = sheet.crop(0, h, w, h);
		brick = sheet.crop(w, h, w, h);
		tree = sheet.crop(w*3, h*2, w, h);
		enemy = enemySheet.crop(0, 0, wEnemy, hEnemy);
		woman = girlSheet.crop(0, 0, Wwoman, Hwoman); //primeira posicçao do frame na tela
		
		//sequencias de passos muie - ta meio bugado pq ela anda muito detalhe q dps eu arrumo
		playerg_down = new BufferedImage[6];
		playerg_down[0] = girlSheet.crop(0, 0, Wwoman, Hwoman);
		playerg_down[1] = girlSheet.crop(Wwoman, 0, Wwoman, Hwoman);
		playerg_down[2] = girlSheet.crop(Wwoman*2, 0, Wwoman, Hwoman);
		playerg_down[3] = girlSheet.crop(Wwoman*3, 0, Wwoman, Hwoman);
		playerg_down[4] = girlSheet.crop(Wwoman*4, 0, Wwoman, Hwoman);
		playerg_down[5] = girlSheet.crop(Wwoman*5, 0, Wwoman, Hwoman);
		
		playerg_up = new BufferedImage[6];
		playerg_up[0] = girlSheet.crop(0, Hwoman, Wwoman, Hwoman);
		playerg_up[1] = girlSheet.crop(Wwoman, Hwoman, Wwoman, Hwoman);
		playerg_up[2] = girlSheet.crop(Wwoman*2, Hwoman, Wwoman, Hwoman);
		playerg_up[3] = girlSheet.crop(Wwoman*3, Hwoman, Wwoman, Hwoman);
		playerg_up[4] = girlSheet.crop(Wwoman*4, Hwoman, Wwoman, Hwoman);
		playerg_up[5] = girlSheet.crop(Wwoman*5, Hwoman, Wwoman, Hwoman);
		
		playerg_right = new BufferedImage[6];
		playerg_right[0] = girlSheet.crop(0, Hwoman*2, Wwoman, Hwoman);
		playerg_right[1] = girlSheet.crop(Wwoman, Hwoman*2, Wwoman, Hwoman);
		playerg_right[2] = girlSheet.crop(Wwoman*2, Hwoman*2, Wwoman, Hwoman);
		playerg_right[3] = girlSheet.crop(Wwoman*3, Hwoman*2, Wwoman, Hwoman);
		playerg_right[4] = girlSheet.crop(Wwoman*4, Hwoman*2, Wwoman, Hwoman);
		playerg_right[5] = girlSheet.crop(Wwoman*5, Hwoman*2, Wwoman, Hwoman);
		
		playerg_left = new BufferedImage[6];
		playerg_left[0] = girlSheet.crop(0, Hwoman*3, Wwoman, Hwoman);
		playerg_left[1] = girlSheet.crop(Wwoman, Hwoman*3, Wwoman, Hwoman);
		playerg_left[2] = girlSheet.crop(Wwoman*2, Hwoman*3, Wwoman, Hwoman);
		playerg_left[3] = girlSheet.crop(Wwoman*3, Hwoman*3, Wwoman, Hwoman);
		playerg_left[4] = girlSheet.crop(Wwoman*4, Hwoman*3, Wwoman, Hwoman);
		playerg_left[5] = girlSheet.crop(Wwoman*5, Hwoman*3, Wwoman, Hwoman);
		
		
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

		btn_play = new BufferedImage[2];
		btn_play[0] = botao.crop(9, 6, 293, 297);
		btn_play[1] = botao.crop(332, 6, 293, 297);
		
		
	}
	
}
