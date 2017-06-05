public class HungryPet extends VirtualPet {
	  
	public HungryPet(String nameParam, String descriptionParam, int hungerParam) {
		super(nameParam, descriptionParam);
		name = nameParam;
		description = descriptionParam;	
		hunger = hungerParam;
		}
	
	//increments variables semi-randomly to simulate passage of time 
	public void tick() {
		hunger += (20 + generateRandom());
		thirst += (10 + generateRandom());
		temp -= (1 + generateRandom());
		boredom += (1 + generateRandom());
		cageMessiness += (1 + generateRandom());
	}
}