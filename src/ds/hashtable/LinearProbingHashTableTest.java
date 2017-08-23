package ds.hashtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinearProbingHashTableTest {

	@Test
	public void testAdd() {
		LinearProbingHashTable<String, String> ht = new LinearProbingHashTable<String, String>();
		ht.add("dog", "Golden");
		ht.add("cat", "English");
		ht.add("bird", "Parrot");
		ht.add("tiger", "Siberian");
		ht.add("fish", "Golden");
		assertTrue(ht.exists("cat"));
		assertEquals(ht.get("dog"), "Golden");
		assertFalse(ht.exists("cheetah"));
	}
	
	@Test
	public void testRemove() {
		LinearProbingHashTable<String, String> ht = new LinearProbingHashTable<String, String>();
		ht.add("dog", "Golden");
		ht.add("cat", "English");
		ht.add("bird", "Parrot");
		ht.add("tiger", "Siberian");
		ht.add("fish", "Golden");
		assertEquals(ht.get("dog"), "Golden");
		ht.remove("dog");
		assertFalse(ht.exists("dog"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullKey() {
		LinearProbingHashTable<String, String> ht = new LinearProbingHashTable<String, String>();
		ht.add("dog", "Golden");
		ht.add(null, "Parrot");
	}
	
	@Test
	public void testDuplicateKey() {
		LinearProbingHashTable<String, String> ht = new LinearProbingHashTable<String, String>();
		ht.add("dog", "Golden");
		ht.add("cat", "English");
		ht.add("bird", "Parrot");
		ht.add("tiger", "Siberian");
		ht.add("fish", "Golden");
		ht.add("dog", "German");
		assertEquals(ht.get("dog"), "German");
	}
	
	@Test
	public void testCollision() {
//		String[] arr = {"dog", "doge", "bird"};
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println((arr[i].hashCode() & 0x7fffffff) % 8);
//		}
		LinearProbingHashTable<String, String> ht = new LinearProbingHashTable<String, String>();
		ht.add("dog", "Golden");
		ht.add("doge", "English");
		ht.add("bird", "Parrot");
		assertEquals(ht.get("doge"), "English");
	}
}
