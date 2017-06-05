import java.util.*;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		VirtualPetShelter shelter = new VirtualPetShelter();

		boolean quit = false;
		VirtualPet gregg = new VirtualPet("Gregg", "you don't want to know the tale of Old Gregg", 50, 50, 50, 50, 50);
		shelter.intake(gregg);
		HungryPet charles = new HungryPet("Charles", "is a hungry dog", 50);
		shelter.intake(charles);
		MessyPet shelly = new MessyPet("Shelly", "is a very messy pet", 50);
		shelter.intake(shelly);
		
		do {
			writeLine("\nThank you for volunteering at the animal shelter!");
			writeLine("\nThis is the status of your pets: ");
			writeLine("\nName\t|Hunger\t|Thirst\t|Boredom|Cage Messiness");
			writeLine("--------|-------|-------|-------|-------");

			for (VirtualPet currentPet : shelter.pets()) {
				writeLine(currentPet.name + "\t|" + currentPet.hunger + "\t|" + currentPet.thirst + "\t|"
						+ currentPet.boredom + "\t|" + currentPet.cageMessiness);
			}
			writeLine("\nWhat would you like to do next?");
			writeLine(
					"\n1.Feed the pets \n2.Water the pets \n3.Play with a pet \n4.Adopt a pet \n5.Admit a pet \n6.Clean Cage \n7.Do nothing \n8.Quit");
			String response = input.nextLine();
			switch (response) {
			case "1": // feed
	 			shelter.feedPets();
				writeLine("Thank you for feeding the pets in the shelter!");
				break;
			case "2": // water
				shelter.waterPets();
				writeLine("Thank you for watering the pets in the shelter!");
				break;
			case "3": // play
				writeLine("Ok, so you'd like to play with a pet. Please choose one:\n");
				displayPets(shelter);
				writeLine("\nWhich pet would you like to play with?");
				String petName = input.nextLine();
				shelter.playWith(petName);
				writeLine("OK, you play with " + petName + ". ");
				break;
			case "4": // adopt
				writeLine("Ok, so you'd like to adopt a pet. Please choose one:\n");
				displayPets(shelter);
				writeLine("\nWhich pet would you like to adopt");
				String nameToAdopt = input.nextLine();
				VirtualPet x = shelter.getPet(nameToAdopt);
				shelter.adopt(x);
				writeLine("You adopted " + nameToAdopt + ". Please take good care of him/her!");
				break;
			case "5": // admit
				writeLine("Please enter the name of the new pet: ");
				String name = input.nextLine();
				writeLine("Please enter the descritpion of the new pet: ");
				String description = input.nextLine();
				VirtualPet p = new VirtualPet(name, description);
				shelter.intake(p);
				writeLine("Thank you for admitting " + p.getName() + "! We will take good care of him/her.");
				break;
			case "6": // clean cage
				writeLine("Ok, so you'd like to clean a cage. Please choose one:\n");
				displayPets(shelter);
				writeLine("\nWhich pet's cage would you like to clean?");
				String cageName = input.nextLine();
				shelter.cleanCage(cageName);
				writeLine("OK, you clean " + cageName + "'s cage. ");
				break;
			case "7": // do nothing
				break;
			case "8": // quit
				writeLine("Nobody likes a quitter...");
				System.exit(0);
			default:
				writeLine("Sorry, I didn't understand you. Try again.");
				break;
			}
			shelter.tick();

		} while (!quit);
		input.close();
	}

	public static void writeLine(String message) {
		System.out.println(message);
	}

	private static void displayPets(VirtualPetShelter s) {
		for (VirtualPet currentPet : s.pets()) {
			System.out.println(currentPet);
		}
	}

}