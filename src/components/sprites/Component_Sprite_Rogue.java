package components.sprites;

import java.awt.Graphics2D;

import components.Component;
import entities.Entity;
import util.Assets;
import util.Constants;

public class Component_Sprite_Rogue extends Component_Sprite{
	private int progress = 0;
	private int lastStatus = 0;
	private long lastTime = System.nanoTime();

	public Component_Sprite_Rogue(Entity entity) {
		super(entity, "Sprite");
		
	}

	@Override
	public void update() {
		if(lastStatus!=entity.getStatus()) {
			progress=0;
			lastStatus=entity.getStatus();
			lastTime = System.nanoTime();
		}
		else {
			if(System.nanoTime()-lastTime>100000000) {
				progress++;
				lastTime=System.nanoTime();
				if (progress>=4)
					progress=0;
			}
		}
	}
	
	@Override
	public void render(Graphics2D g2) {
		
		
		g2.drawImage(Assets.rogue.getSprite(entity.getDirection()*4+(entity.getStatus()*progress)), (int) getX(),(int) getY(), entity.getWidth(), entity.getHeight(), null);
		
		if(Constants.showSpriteBorders)
			renderBorder(g2);
		//g2.drawImage(Assets.rogue.get(0).getSprite(0), (int) entity.getX(),(int) entity.getY(), entity.getWidth(), entity.getHeight(), null);
	}
}
