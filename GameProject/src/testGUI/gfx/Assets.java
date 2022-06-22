package testGUI.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 16, height = 16;
	
	public static BufferedImage player,sea, dirt, grass, stone, tree, building,background,bigTree,smallTree,flower,pCenter,pMart,pball;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] btn_start;
	 
	public static void init() {
		//SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet (2).png"));
		SpriteSheet map = new SpriteSheet(ImageLoader.loadImage("/textures/map.png"));
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/pocketmon.png"));
		SpriteSheet button = new SpriteSheet(ImageLoader.loadImage("/textures/sheet (3).png"));
		SpriteSheet intro = new SpriteSheet(ImageLoader.loadImage("/textures/introBackground.jpg"));
		
		player_down = new BufferedImage[4];
		player_up = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		
		player_down[0] = sheet.crop(0, 0, 32, 40);
		player_down[1] = sheet.crop(32, 0, 32, 40);
		player_down[2] = sheet.crop(64, 0, 32, 40);
		player_down[3] = sheet.crop(96, 0, 32, 40);
		player_up[0] = sheet.crop(0, 123, 32, 40);
		player_up[1] = sheet.crop(32, 123, 32, 40);
		player_up[2] = sheet.crop(64, 123, 32, 40);
		player_up[3] = sheet.crop(96, 123, 32, 40);
		player_left[0] = sheet.crop(0, 41, 32, 40);
		player_left[1] = sheet.crop(32, 41, 32, 40);
		player_left[2] = sheet.crop(64, 41, 32, 40);
		player_left[3] = sheet.crop(96, 41, 32, 40);
		player_right[0] = sheet.crop(0, 82, 32, 40);
		player_right[1] = sheet.crop(32, 82, 32, 40);
		player_right[2] = sheet.crop(64, 82, 32, 40);
		player_right[3] = sheet.crop(96, 82, 32, 40);
		
		btn_start = new BufferedImage[2];
		btn_start[0] = button.crop(width * 6 * 2,  height * 4 * 2, width * 4, height * 2);
		btn_start[1] = button.crop(width * 6 * 2,  height * 5 * 2, width * 4, height * 2);
		
		bigTree = map.crop(0, height, width, height*2);
		smallTree= map.crop(width, height*2, width, height);
		flower= map.crop(width*2, 0, width, height);
		pCenter=map.crop(width*4, height * 11, width*4, height*4);
		pMart=map.crop(0, height * 11, width * 4, height * 4);
		sea = map.crop(0, height*3, width*3, height*2);
		pball = map.crop(width * 7, height * 16 , width, height);
		
		background = intro.crop(0,0,800,600);
		dirt = map.crop(0, 0, width, height);
		grass = map.crop(width * 3, 0, width, height);
		stone = map.crop(width, 0, width, height);
		tree = map.crop(width * 2, height, width, height);
		building = map.crop(width * 3, height, width*4,height*4);
	}
}
