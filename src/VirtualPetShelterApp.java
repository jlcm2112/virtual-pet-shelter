import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		VirtualPetShelter shelter = new VirtualPetShelter();

		boolean wantsToQuit = false;
		do {
			writeLine("\nThank you for volunteering at the animal shelter!");
			displayStatus(shelter);
			writeLine("\nWhat would you like to do next?");
			writeLine(
					"\n1.Feed the pets \n2.Water the pets \n3.Play with a pet \n4.Adopt a pet \n5.Admit a pet \n6.Do nothing \n7.Quit");
			String response = input.next();
			input.nextLine();
			switch (response) {
			case "1": // feed
				shelter.feedAll();
				writeLine("Thank you for feeding the pets in the shelter!");
				break;
			case "2": // water
				shelter.waterAll();
				writeLine("Thank you for watering the pets in the shelter!");
				break;
			case "3": // play
				writeLine("Ok, so you'd like to play with a pet. Please choose one:\n");
				displayPets(shelter);
				writeLine("\nWhich pet would you like to play with?");
				String play = input.next();
				shelter.playWith(play);
				writeLine("OK, you play with " + play + ". ");
				break;
			case "4": // adopt
				writeLine("Ok, so you'd like to adopt a pet. Please choose one:\n");
				displayPets(shelter);
				writeLine("\nWhich pet would you like to adopt");
				String nameToAdopt = input.next();
				shelter.removePet(nameToAdopt);
				writeLine("You adopted " + nameToAdopt + ". Please take good care of him/her!");
				break;
			case "5": // admit
				writeLine("Please enter the name of the new pet: ");
				String name = input.nextLine();
				writeLine("Please enter the descritpion of the new pet: ");
				String description = input.nextLine();
				VirtualPet p = new VirtualPet(name, description);
				shelter.addPet(p);
				writeLine("Thank you for admitting " + p.getName() + "! We will take good care of him/her.");
				break;
			case "6": // do nothing
				break;
			case "7": // quit
				writeLine("Nobody likes a quitter...");
				System.exit(0);
			default:
			writeLine("Sorry, I didn't understand you. Try again.");
			break;
			}
			shelter.tick();

		} while (!wantsToQuit);

	}

	public static void writeLine(String message) {
		System.out.println(message);
	}

	public static void displayStatus(VirtualPetShelter s) {
		System.out.println("\nThis is the status of your pets: ");
		System.out.println("\nName\t|Hunger\t|Thirst\t|Boredom");
		System.out.println("--------|-------|-------|-------");
		Collection<VirtualPet> listOfPets = new ArrayList<>();
		listOfPets = s.getPets();
		for (VirtualPet currentPet : listOfPets) {
			System.out.println(currentPet.name + "\t|" + currentPet.hunger + "\t|" + currentPet.thirst + "\t|"
					+ currentPet.boredom);
		}
	}

	private static void displayPets(VirtualPetShelter s) {
		Collection<VirtualPet> listOfPets = new ArrayList<>();
		listOfPets = s.getPets();
		for (VirtualPet currentPet : listOfPets) {
			System.out.println(currentPet);
		}

	}

}
