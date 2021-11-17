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
		grass = getSheetTile(sheet, 0, 0);
		dirt = getSheetTile(sheet, 1, 0);
		tile = getSheetTile(sheet, 1, 1);
		flower = getSheetTile(sheet, 0, 6);
		bob = getSheetTile(sheet, 0, 7);
		bob_walk = getSheetTile(sheet, 1, 7);
		
		//row 2
		water = getSheetTile(sheet, 3, 0);
		stone = getSheetTile(sheet, 2, 0);
		sun_back = getSheetTile(sheet, 0, 1);
		fox = getSheetTile(sheet, 1, 6);
		
		
		//funny
		missingNo = sheet.crop(width*7, height*7, width, height);
	}
	
	public static BufferedImage getSheetTile(SpriteSheet sheet, int x, int y) {
		return sheet.crop(width*x, height*y, width, height);
	}
	
}
