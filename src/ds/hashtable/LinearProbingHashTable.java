package ds.hashtable;

public class LinearProbingHashTable<Key, Value> {
	private static int INIT_CAPACITY = 8;
	
	private int capacity;
	private int size;
	private Key[] keys;
	private Value[] values;
	
	public LinearProbingHashTable() {
		this(INIT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashTable(int init_capacity) {
		capacity = init_capacity;
		size = 0;
		keys = (Key[]) new Object[capacity];
		values = (Value[]) new Object[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean exists(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("key cannot be null!");
		}
		return get(key) != null;
	}
	
	
	/**
	 * This hash function was copied from: http://algs4.cs.princeton.edu/34hash/LinearProbingHashST.java.html
	 * @param key the key
	 * @return if hash value between 0 and size - 1;
	 */
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % capacity;
	}
	
	private void resize(int new_capacity) {
		LinearProbingHashTable<Key, Value> temp = new LinearProbingHashTable<Key, Value>(new_capacity);
		for (int i = 0; i < capacity; i++) {
			if (keys[i] != null) {
				temp.add(keys[i], values[i]);
			}
		}
		capacity = temp.capacity;
		keys = temp.keys;
		values = temp.values;
		size = temp.size;
	}
	
	public void add(Key key, Value value) {
		if (key == null) {
			throw new IllegalArgumentException("key cannot be null!");
		}
		if (value == null) {
			remove(key);
			return;
		}
		
		if (size >= capacity/2) {
			resize(2*capacity);
		}
		
		int i;
		for (i = hash(key); keys[i] != null; i = (i+1) % capacity) {
			if (keys[i].equals(key)) {
				values[i] = value;
				return;
			}
		}
		keys[i] = key;
		values[i] = value;
		size++;
	}
	
	public Value get(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("key cannot be null!");
		}
		for (int i = hash(key); keys[i] != null; i = (i+1) % capacity) {
			if (keys[i].equals(key)) {
				return values[i];
			}
		}
		return null;
	}
	
	public void remove(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("key cannot be null!");
		}
		if (!exists(key)) {
			return;
		}
		int i = hash(key);
		while(!key.equals(keys[i])) {
			i = (i + 1) % capacity;
		}
		
		keys[i] = null;
		values[i] = null;
		
		i = (i + 1) % capacity;
		while(keys[i] != null) {
			Key keyToReHash = keys[i];
			Value valueToReHash = values[i];
			keys[i] = null;
			values[i] = null;
			size--;
			add(keyToReHash, valueToReHash);
			i = (i + 1) % capacity;
		}
		
		size--;
		
		if (size > 0 && size <= capacity/8) {
			resize(capacity/2);
		}
	}
}
