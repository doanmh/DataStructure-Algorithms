package ds.arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class DynamicArrayTest {

	@Test
	public void testConstructor() {
		DynamicArray<Integer> testArray = new DynamicArray<Integer>();
		assertEquals(testArray.capacity(), 16);
		DynamicArray<Integer> testArray1 = new DynamicArray<Integer>(20);
		assertEquals(testArray1.capacity(), 20);
	}
	
	@Test
	public void testPush() {
		DynamicArray<String> testArray = new DynamicArray<String>();
		testArray.push("abc");
		testArray.push("def");
		testArray.push("ghi");
		testArray.push("jkl");
		testArray.push("mno");
		assertEquals(testArray.size(), 5);
		assertEquals(testArray.at(0), "abc");
	}
	
	@Test
	public void testPushOverCapacity() {
		DynamicArray<Integer> testArray = new DynamicArray<Integer>();
		int initialCapacity = testArray.capacity();
		for (int i = 0; i < initialCapacity; i++) {
			testArray.push(i);
		}
		testArray.push(initialCapacity + 1);
		assertEquals(testArray.size(), 17);
		assertEquals(testArray.capacity(), 32);
		assertEquals(testArray.at(16), new Integer(17));
	}
	
	@Test
	public void testInsert() {
		DynamicArray<Integer> testArray = new DynamicArray<Integer>();
		for (int i = 0; i < 5; i++) {
			testArray.push(i);
		}
		testArray.insert(2, 3);
		assertEquals(testArray.size(), 6);
		assertEquals(testArray.capacity(), 16);
		assertTrue(testArray.at(2) == 3);
		assertTrue(testArray.at(3) == 2);
		assertTrue(testArray.at(5) == 4);
		testArray.insert(6, 100);
		assertEquals(testArray.size(), 7);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsert1() {
		DynamicArray<Integer> testArray = new DynamicArray<Integer>();
		for (int i = 0; i < 5; i++) {
			testArray.push(i);
		}
		testArray.insert(-1, 100);
		testArray.insert(6,	100);
	}
	
	@Test
	public void testPrepend() {
		DynamicArray<String> testArray = new DynamicArray<String>();
		testArray.push("Array");
		testArray.push("List");
		testArray.push("Apple");
		testArray.prepend("Orange");
		assertEquals(testArray.at(0), "Orange");
		assertEquals(testArray.size(), 4);
	}

	@Test(expected = Error.class)
	public void testPopEmptyArray() {
		DynamicArray<String> testArray = new DynamicArray<String>();
		testArray.pop();
	}
	
	@Test
	public void testPop() {
		DynamicArray<String> testArray = new DynamicArray<String>();
		testArray.push("Array");
		testArray.push("List");
		testArray.push("Apple");
		String apple = testArray.pop();
		assertEquals(apple, "Apple");
		assertEquals(testArray.at(1), "List");
		assertEquals(testArray.capacity(), 16);
		assertEquals(testArray.size(), 2);
	}
	
	@Test
	public void testDelete() {
		DynamicArray<Integer> testArray = new DynamicArray<Integer>();
		for (int i = 0; i < 31; i++) {
			testArray.push(i);
		}
		for (int i = 0; i < 24; i++) {
			testArray.delete(7);
		}
		assertEquals(testArray.size(), 7);
		assertEquals(testArray.capacity(), 16);
		assertTrue(testArray.at(3) == 3);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testDelete2() {
		DynamicArray<Integer> testArray = new DynamicArray<Integer>();
		for (int i = 0; i < 31; i++) {
			testArray.push(i);
		}
		testArray.delete(31);
	}
	
	@Test
	public void testRemove() {
		DynamicArray<String> testArray = new DynamicArray<String>();
		testArray.push("Array");
		testArray.push("List");
		testArray.push("Apple");
		testArray.push("List");
		testArray.push("Lemon");
		testArray.push("Pingpong");
		testArray.push("List");
		testArray.remove("List");
		assertEquals(testArray.size(), 4);
		assertEquals(testArray.at(1), "Apple");
		assertEquals(testArray.pop(), "Pingpong");
	}
	
	@Test
	public void testFind() {
		DynamicArray<String> testArray = new DynamicArray<String>();
		testArray.push("Array");
		testArray.push("List");
		testArray.push("Apple");
		testArray.push("List");
		testArray.push("Lemon");
		testArray.push("Pingpong");
		testArray.push("List");
		assertEquals(testArray.find("List"), 1);
		testArray.delete(1);;
		assertEquals(testArray.find("List"), 2);
		testArray.remove("List");
		assertEquals(testArray.find("List"), -1);
	}
}
