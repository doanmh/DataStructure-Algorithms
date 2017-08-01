package ctci.chapter03.question06_AnimalShelter;

import java.util.EmptyStackException;

import ds.stackandqueue.LinkedListQueue;

public class AnimalShelterQueue {
	private LinkedListQueue<Dog> dog = new LinkedListQueue<Dog>();
	private LinkedListQueue<Cat> cat = new LinkedListQueue<Cat>();
	private int order = 0;
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if (a instanceof Dog) {
			dog.enqueue((Dog)a);
		} else if (a instanceof Cat) {
			cat.enqueue((Cat) a);
		}
	}
	
	public Animal dequeueAny() {
		if (dog.empty()) {
			dequeueCat();
		} else if (cat.empty()) {
			dequeueDog();
		}
		Dog d = dog.peek();
		Cat c = cat.peek();
		if (d.isOlderThan(c)) {
			return dog.dequeue();
		} else {
			return cat.dequeue();
		}
	}
	
	public Animal peekAny() {
		if (dog.empty()) {
			peekCat();
		} else if (cat.empty()) {
			peekDog();
		}
		Dog d = dog.peek();
		Cat c = cat.peek();
		if (d.isOlderThan(c)) {
			return d;
		} else {
			return c;
		}
	}
	
	public Dog dequeueDog() {
		if (dog.empty()) {
			throw new EmptyStackException();
		}
		return dog.dequeue();
	}
	
	public Cat dequeueCat() {
		if (cat.empty()) {
			throw new EmptyStackException();
		}
		return cat.dequeue();
	}
	
	public Dog peekDog() {
		if (dog.empty()) {
			throw new EmptyStackException();
		}
		return dog.peek();
	}
	
	public Cat peekCat() {
		if (cat.empty()) {
			throw new EmptyStackException();
		}
		return cat.peek();
	}
}
