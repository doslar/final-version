package components.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import components.Component;
import entities.Entity;

public class Component_Sprite_Human extends Component{

	
	public Component_Sprite_Human(Entity entity) {
		super(entity, "Sprite");
		
	}
	
	@Override
	public void render(Graphics2D g2) {
		BufferedImage image = new BufferedImage(entity.getWidth(), entity.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		switch (entity.getDirection()) {
			
			case 0 : 
				break;
	
			case 1 : 
				break;
				
			case 2 : 
				break;
		
			case 3 : 
				break;
		
		
		default : System.out.println(entity + " " + this + " error witch direction");
		}
			Graphics g = image.getGraphics();
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, image.getWidth()-1, image.getHeight()-1);
			// image.getGraphics().drawRect((int)(entity.getX()), (int) entity.getPossition().getY(), entity.getWidth(), entity.getHeight());
			 g2.drawImage(image,(int) entity.getX(),(int) entity.getY(), entity.getWidth(), entity.getHeight(), null);
		

	}
	// head
	public void renderH(Graphics2D g2) {
		
	}
	
	//Left Arm
	public void renderLA(Graphics2D g2) {
		
	}
	
	//Right Arm
	public void renderRA(Graphics2D g2) {
		
	}
	
	//Body
	public void renderB(Graphics2D g2) {
		
	}
	
	//Left Leg
	public void renderLL(Graphics2D g2) {
		
	}
	
	//Right Leg
	public void renderRL(Graphics2D g2) {
		
	}
}
