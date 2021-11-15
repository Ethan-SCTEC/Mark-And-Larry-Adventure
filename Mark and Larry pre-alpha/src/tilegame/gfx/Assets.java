package tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage grass, dirt, tile, flower, bob, bob_walk;
	public static BufferedImage water, stone, sun_back, fox; 
	public static BufferedImage missingNo;
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(imageLoader.loadImage("/textures/SpriteSheet.png"));
		
		//row 1
		grass = sheet.crop(0,0,width,height);
		dirt = sheet.crop(width, 0, width, height);
		tile = sheet.crop(width*2,0,width,height);
		flower = sheet.crop(width*3, 0, width, height);
		bob = sheet.crop(width*4,0,width,height);
		bob_walk = sheet.crop(width*5,0,width,height);
		
		//row 2
		water = sheet.crop(0,height,width,height);
		stone = sheet.crop(width, height, width, height);
		sun_back = sheet.crop(width*2, height, width, height);
		fox = sheet.crop(width*3, height, width, height);
		
		
		//funny
		missingNo = sheet.crop(width*7, height*7, width, height);
	}
	
}
