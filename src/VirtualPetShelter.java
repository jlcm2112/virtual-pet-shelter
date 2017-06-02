import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> mapOfPets = new HashMap<String, VirtualPet>(); //instance variable

	public Collection<VirtualPet> getPets(){
		return mapOfPets.values();
	}
	public VirtualPet getPet(String name){
		return mapOfPets.get("name");
	}
	public void addPet(VirtualPet pet){
		mapOfPets.put(pet.name, pet);
	}

	public void removePet(String name){
		mapOfPets.remove(name);
	}
	public void feedAll(){
		for(VirtualPet currentPet: mapOfPets.values()){
			currentPet.feed();
		}
	}
	public void waterAll(){
		for(VirtualPet currentPet: mapOfPets.values()){
			currentPet.water();
		}
	}
	public void playWith(String nameParam){
		VirtualPet p = mapOfPets.get(nameParam);
		p.play();
	}
	public void tick() {
		for(VirtualPet currentPet: mapOfPets.values()){
			currentPet.tick();
		}
	}
	@Override
	public String toString() {
		return ("" + mapOfPets.keySet() + mapOfPets.values()); 
	}
}
