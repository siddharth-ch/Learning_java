package datastructures;

import java.util.Arrays;
import java.util.Iterator;

public class CustomArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_SIZE = 10;
    private Object[] obj = null;
    int actSize = 0;

    public CustomArrayList() {
	obj = new Object[DEFAULT_SIZE];
    }

    CustomArrayList(int size) {
	obj = new Object[size];
    }

    public boolean add(T o) {
	ensureCap(actSize + 1);
	obj[actSize++] = o;
	return true;
    }

    public boolean add(int idx, Object o) {
	if (idx < 0 || idx > actSize) {
	    throw new IndexOutOfBoundsException();
	}
	ensureCap(actSize + 1);
	for (int i = idx; i < actSize; i++) {
	    obj[i + 1] = obj[i];
	}
	obj[idx] = o;
	return true;
    }

    private void ensureCap(int newl) {
	if (newl >= obj.length) {
	    obj = Arrays.copyOf(obj, obj.length * 3 / 2);
	}
    }

    public int size() {
	return actSize;
    }

    public boolean remove(Object o) {
	if (o == null) {
	    for (int i = 0; i < actSize; i++) {
		if (obj[i] == null) {
		    remove(i);
		    return true;
		}
	    }
	} else {
	    for (int i = 0; i < actSize; i++) {
		if (obj[i] == o || obj[i].equals(o)) {
		    remove(i);
		    return true;
		}
	    }
	}
	return false;
    }

    public T remove(int idx) {
	if (idx < 0 || idx >= actSize) {
	    throw new IndexOutOfBoundsException();
	}
	Object E = obj[idx];
	obj[idx] = null;
	for (int i = idx; i + 1 < actSize; i++) {
	    obj[i] = obj[i + 1];
	}
	actSize--;
	return (T) E;
    }

    public T get(int idx) {
	if (idx < 0 || idx >= actSize) {
	    throw new IndexOutOfBoundsException();
	}

	return (T) obj[idx];
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return Arrays.toString(obj);
    }

    @Override
    public Iterator<T> iterator() {
	return new Iterator<T>() {

	    int current = 0;
	    int lastReturn = -1;

	    @Override
	    public boolean hasNext() {
		return actSize > current && obj[current] != null;
	    }

	    @Override
	    public T next() {
		lastReturn = current;
		return (T) obj[current++];
	    }

	    @Override
	    public void remove() {
		if (lastReturn < actSize && lastReturn >= 0)
		    CustomArrayList.this.remove(lastReturn);
		current--;
	    }

	};
    }

    public static void main(String[] args) {
	CustomArrayList<Integer> c = new CustomArrayList<>();
	for (int i = 0; i < 10; i++) {
	    c.add(i);
	}

	for (Integer i : c) {
	    c.iterator().remove();
	    System.out.println(i);
	}
    }
}
