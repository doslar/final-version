package components.sprites;

import java.awt.Graphics2D;

import components.Component;
import entities.Entity;
import util.Assets;
import util.Constants;

public class Component_Sprite_Rock extends Component_Sprite{

	public Component_Sprite_Rock(Entity entity) {
		super(entity, "Sprite");
		
	}
	
	@Override
	public void render(Graphics2D g2) {
		g2.drawImage(Assets.rock,(int)getX(),(int)getY(),entity.getWidth(),entity.getHeight(),null);
		
		if(Constants.showSpriteBorders)
			renderBorder(g2);
	}
}
