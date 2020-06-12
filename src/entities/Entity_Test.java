package entities;

import components.Component;
import components.Component_BoxBounds;
import components.Component_CameraMan;
import components.Component_Movement;
import components.Component_PlayerMovement;
import components.Component_Stats;
import components.sprites.Component_Sprite_Rogue;
import util.Proportions;
import util.Vector2;

public class Entity_Test extends Entity{

	public Entity_Test(String id, Vector2 posstion, Proportions proportions) {
		super(id,"TestEntity", posstion, proportions);
	}

	@Override
	protected void init() {
		this.addComponent(new Component(this,"test"));
		this.addComponent(new Component_Stats(this, 5, 5, 5, 5, 5, 5));
		this.addComponent(new Component_Movement(this));
		this.addComponent(new Component_PlayerMovement(this));
		this.addComponent(new Component_Sprite_Rogue(this));
		this.addComponent(new Component_CameraMan(this));
		this.addComponent(new Component_BoxBounds(this, 50, 75));
	}
}
