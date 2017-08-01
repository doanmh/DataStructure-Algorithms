package ctci.chapter03.question06_AnimalShelter;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalShelterQueueTest {

	@Test
	public void testDequeueAny() {
		Dog dog1 = new Dog("Dog1");
		Dog dog2 = new Dog("Dog2");
		Dog dog3 = new Dog("Dog3");
		Cat cat1 = new Cat("Cat1");
		Cat cat2 = new Cat("Cat2");
		Cat cat3 = new Cat("Cat3");
		AnimalShelterQueue queue = new AnimalShelterQueue();
		queue.enqueue(dog1);
		queue.enqueue(cat1);
		queue.enqueue(dog2);
		queue.enqueue(cat2);
		queue.enqueue(dog3);
		queue.enqueue(cat3);
		assertEquals(queue.dequeueAny(), dog1);
		assertEquals(queue.dequeueCat(), cat1);
		assertEquals(queue.dequeueDog(), dog2);
		assertEquals(queue.dequeueAny(), cat2);
	}

}
