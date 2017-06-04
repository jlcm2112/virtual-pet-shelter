public class MessyPet extends VirtualPet {



	public MessyPet(String nameParam, String descriptionParam, int cageMessinessParam) {
		super(nameParam, descriptionParam);
		name = nameParam;
		description = descriptionParam;
		cageMessiness = cageMessinessParam;

	}

	// increments variables semi-randomly to simulate passage of time
	public void tick() {
		hunger += (10 + generateRandom());
		thirst += (10 + generateRandom());
		temp -= (1 + generateRandom());
		boredom += (1 + generateRandom());
		cageMessiness += (20 + generateRandom());
	}

}
