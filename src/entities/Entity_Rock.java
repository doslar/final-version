package entities;

import components.Component_BoxBounds;
import components.sprites.Component_Sprite_Rock;
import util.Proportions;
import util.Vector2;

public class Entity_Rock extends Entity{

	public Entity_Rock(String id,Vector2 posstion, Proportions proportions) {
		super(id,"Rock", posstion, proportions);
		
		addComponent(new Component_Sprite_Rock(this));
		addComponent(new Component_BoxBounds(this, getWidth(), getHeight()));
	}
	
}
