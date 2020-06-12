package util;

import java.awt.image.BufferedImage;


public class Assets {

	public static  BufferedImage[] []  	player;
	public static  BufferedImage		grass,
										redFlowers,
										rock;
	
	//public static List<SpriteSheet> rogue;
	
	public static SpriteSheet rogue;
	public Assets() {
		//rogue = new ArrayList<SpriteSheet>();
		//rogue.add(new SpriteSheet(ImageLoader.loadImage("/textures/Rogue/Right.png"),16,16,1,1));
		//rogue.add(new SpriteSheet(ImageLoader.loadImage("/textures/Rogue/Back.png"),16,16,1,1));
		//rogue.add(new SpriteSheet(ImageLoader.loadImage("/textures/Rogue/Left.png"),16,16,1,1));
		//rogue.add(new SpriteSheet(ImageLoader.loadImage("/textures/Rogue/Front.png"),16,16,1,1));
		//rogue.add(new SpriteSheet(ImageLoader.loadImage("/textures/Rogue/Back Right.png"),16,16,1,1));
		//rogue.add(new SpriteSheet(ImageLoader.loadImage("/textures/Rogue/Back Left.png"),16,16,1,1));
		//rogue.add(new SpriteSheet(ImageLoader.loadImage("/textures/Rogue/Front Left.png"),16,16,1,1));
		//rogue.add(new SpriteSheet(ImageLoader.loadImage("/textures/Rogue/Front Right.png"),16,16,1,1));
		//Rogue_Left_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Rogue/Left.png"),16,16,1,1);
		
		rogue = new SpriteSheet(ImageLoader.loadImage("/textures/Rogue/Rogue.png"),16,16,0,31);
		
		player = new BufferedImage[] []{

			
			//Still Right
			new BufferedImage [] {
					ImageLoader.loadImage("/textures/Rogue_run_Right_Front/Rogue_still00.png")},

			//Still Up
			new BufferedImage [] {
					ImageLoader.loadImage("/textures/Rogue_run_Back/Rogue_still00.png")},
			
			//Still Left
			new BufferedImage [] {
					ImageLoader.loadImage("/textures/Rogue_run_Left_Front/Rogue_still00.png")},
			
			//Still Down
			new BufferedImage [] {
					ImageLoader.loadImage("/textures/Rogue_run_Front/Rogue_still00.png")},
			
			//running Right
			new BufferedImage [] {
			                   ImageLoader.loadImage("/textures/Rogue_run_Right_Front/Rogue_still00.png"),
			                   ImageLoader.loadImage("/textures/Rogue_run_Right_Front/Rogue_run01.png"),
			                   ImageLoader.loadImage("/textures/Rogue_run_Right_Front/Rogue_still00.png"),
			                   ImageLoader.loadImage("/textures/Rogue_run_Right_Front/Rogue_run02.png") 
			},
			
			//running up
			new BufferedImage [] {
			                   ImageLoader.loadImage("/textures/Rogue_run_Back/Rogue_still00.png"),
			                   ImageLoader.loadImage("/textures/Rogue_run_Back/Rogue_run01.png"),
			                   ImageLoader.loadImage("/textures/Rogue_run_Back/Rogue_still00.png"),
			                   ImageLoader.loadImage("/textures/Rogue_run_Back/Rogue_run02.png") 
			},
			//running Left
			new BufferedImage [] {
			                   ImageLoader.loadImage("/textures/Rogue_run_Left_Front/Rogue_still00.png"),
			                   ImageLoader.loadImage("/textures/Rogue_run_Left_Front/Rogue_run01.png"),
			                   ImageLoader.loadImage("/textures/Rogue_run_Left_Front/Rogue_still00.png"),
			                   ImageLoader.loadImage("/textures/Rogue_run_Left_Front/Rogue_run02.png") 
			},
			//running Down
			new BufferedImage [] {
			                   ImageLoader.loadImage("/textures/Rogue_run_Front/Rogue_still00.png"),
			                   ImageLoader.loadImage("/textures/Rogue_run_Front/Rogue_run01.png"),
			                   ImageLoader.loadImage("/textures/Rogue_run_Front/Rogue_still00.png"),
			                   ImageLoader.loadImage("/textures/Rogue_run_Front/Rogue_run02.png") 
			 },
		};
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Scan Domca1.jpg"));
		
		
		

		
		grass=sheet.crop(5,5,50,50);
		redFlowers=sheet.crop(415,110,100,100);
		rock= ImageLoader.loadImage("/textures/Rock/Rock.png");
	}
	
}
