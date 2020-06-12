package components;

import entities.Entity;

public class Component_Stats extends Component{
	private int baseStrenght, baseEndurance, baseInteligence , baseLuck, baseCharisma, baseAgility;
	private float strenght, endurance, inteligence , luck, charisma, agility;
	private float movementSpeed;
	
	public Component_Stats(Entity entity, int strenght, int endurance,int inteligence, int luck, int charisma, int agility) {
		super(entity, "Stats");
		this.strenght=this.baseStrenght=strenght;
		this.endurance=this.baseEndurance=endurance;
		this.inteligence=this.baseInteligence=inteligence;
		this.luck=this.baseLuck=luck;
		this.charisma=this.baseCharisma=charisma;
		this.agility=this.baseAgility=agility;
		
		this.movementSpeed =(float) (this.agility*1.25);
	}
	
	public float getMovementSpeed() {
		return movementSpeed;
	}
}
