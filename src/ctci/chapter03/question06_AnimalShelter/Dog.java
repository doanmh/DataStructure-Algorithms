package ctci.chapter03.question06_AnimalShelter;

public class Dog extends Animal {
	public Dog(String n) {
		super(n);
	}
	
	public String name() {
		return "Dog: " + name;
	}
}
