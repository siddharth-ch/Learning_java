package datastructures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashSet<K> implements Iterable<K> {

	private static final int DEFAULT = 16;
	private Map<K, Object> map = null;
	private final Object DUMMY = new Object();
	private int size;

	public HashSet() {
		map = new HashMap<K, Object>(DEFAULT);
	}

	public HashSet(int size) {
		map = new HashMap<K, Object>(size);
	}

	public boolean add(K k) {
		if (!map.containsKey(k)) {
			map.put(k, DUMMY);
			size++;
			return true;
		} else
			return false;
	}

	public boolean remove(K k) {
		size--;
		return map.remove(k) == DUMMY;
	}

	@Override
	public Iterator<K> iterator() {
		return new Iterator() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Object next() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub

			}

		};
	}

}
