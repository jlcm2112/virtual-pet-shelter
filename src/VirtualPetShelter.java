import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> mapOfPets = new HashMap<String, VirtualPet>(); //instance variable

	public Collection<VirtualPet> pets(){
		return mapOfPets.values();
	}
	public VirtualPet getPet(String name){
		return mapOfPets.get(name);
	}
	public void intake(VirtualPet pet){
		mapOfPets.put(pet.name, pet);
	}
	public void adopt(String name){
		mapOfPets.remove(name);
	}
	public void feedPets(){
		for(VirtualPet currentPet: mapOfPets.values()){
			currentPet.feed();
		}
	}
	public void waterPets(){
		for(VirtualPet currentPet: mapOfPets.values()){
			currentPet.water();
		}
	}
	public void playWith(VirtualPet p){
		p.play();
	}
	public void cleanCage(VirtualPet p){
		p.cleanCage();
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
