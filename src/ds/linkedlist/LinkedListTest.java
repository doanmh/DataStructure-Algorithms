package ds.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LinkedListTest {

	@Test
	public void testSize() {
		LinkedList<Integer> llist = new LinkedList<Integer>();
		for (int i = 0; i < 6; i++) {
			llist.push_back(i);
		}
		assertEquals(llist.size(), 6);
	}

	@Test
	public void testEmpty() {
		LinkedList<Integer> llist = new LinkedList<Integer>();
		assertTrue(llist.isEmpty());
	}

	@Test
	public void testValueAt() {
		LinkedList<String> llist = new LinkedList<String>();
		llist.push_front("head");
		llist.push_front("tail");
		llist.push_front("pointer");
		llist.push_front("abc");
		llist.push_front("push");
		assertEquals(llist.value_at(3), "tail");
		assertEquals(llist.front(), "push");
		assertEquals(llist.back(), "head");
		assertEquals(llist.size(), 5);
	}

	@Test
	public void testPops() {
		LinkedList<String> llist = new LinkedList<String>();
		llist.push_front("head");
		llist.push_front("tail");
		llist.push_front("pointer");
		llist.push_front("abc");
		llist.push_front("push");
		assertEquals(llist.pop_front(), "push");
		assertEquals(llist.value_at(0), "abc");
		assertEquals(llist.size(), 4);
		assertEquals(llist.pop_back(), "head");
		assertEquals(llist.value_at(2), "tail");
		assertEquals(llist.size(), 3);
	}

	@Test
	public void testInsert() {
		LinkedList<Integer> llist = new LinkedList<Integer>();
		for (int i = 0; i < 5; i++) {
			llist.push_back(i);
		}
		llist.insert(0, 10);
		assertEquals(llist.size(), 6);
		assertTrue(llist.value_at(0) == 10);
		llist.insert(6, 15);
		assertEquals(llist.size(), 7);
		assertTrue(llist.back() == 15);
		llist.insert(4, 20);
		assertEquals(llist.size(), 8);
		assertTrue(llist.value_at(4) == 20);
		assertTrue(llist.value_at(3) == 2);
		assertTrue(llist.value_at(5) == 3);
	}

	@Test
	public void testErase() {
		LinkedList<Integer> llist = new LinkedList<Integer>();
		for (int i = 0; i < 5; i++) {
			llist.push_back(i);
		}
		llist.erase(2);
		assertEquals(llist.size(), 4);
		assertTrue(llist.value_at(2) == 3);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testErase2() {
		LinkedList<Integer> llist = new LinkedList<Integer>();
		for (int i = 0; i < 5; i++) {
			llist.push_back(i);
		}
		llist.erase(5);
		llist.erase(-1);
	}

	@Test
	public void testValueFromEnd() {
		LinkedList<Integer> llist = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			llist.push_back(i);
		}
		assertTrue(llist.value_n_from_end(3) == 6);
		assertTrue(llist.value_n_from_end(9) == 0);
	}

	@Test
	public void testReverse() {
		LinkedList<Integer> llist = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			llist.push_back(i);
		}
		llist = llist.reverse();
		for (int i = 0; i < 10; i++) {
			assertTrue(llist.value_at(i) == (9 - i));
		}
	}
	
	@Test
	public void testRemoveValue() {
		LinkedList<String> llist = new LinkedList<String>();
		llist.push_front("abc");
		llist.push_front("def");
		llist.push_front("abc");
		llist.push_front("ghi");
		llist.push_back("mno");
		llist.remove_value("abc");
		assertEquals(llist.value_at(1), "def");
		llist.remove_value("abc");
		assertEquals(llist.value_at(2), "mno");
		assertEquals(llist.size(), 3);
	}
}
