package datastructures;

import java.util.HashSet;
import java.util.Set;

public class HashMap<K, V> {

    private static final int DEFAULT_SIZE = 16;
    private final Entry<K, V>[] table;
    private int size;

    HashMap(int defCap) {
	table = new Entry[defCap];
    }

    HashMap() {
	table = new Entry[DEFAULT_SIZE];
    }

    public Set<Entry<K, V>> entrySet() {

	Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
	for (int i = 0; i < table.length; i++) {
	    Entry temp = table[i];
	    while (temp != null) {
		set.add(temp);
		temp = temp.next;
	    }
	}
	return set;
    }

    public V put(K k, V v) {
	int hash = hashCode(k);
	if (table[hash] == null) {
	    table[hash] = new Entry<K, V>(k, v, null);
	} else {
	    Entry node = table[hash];
	    Entry prev = null;
	    while (node != null) {
		if (node.key.equals(k)) {
		    node.value = v;
		    return v;
		}
		prev = node;
		node = node.next;
	    }
	    prev.next = new Entry(k, v, null);
	    size++;
	}
	return v;
    }

    public V get(K k) {
	int hash = hashCode(k);
	if (table[hash] == null) {
	    return null;
	} else {
	    Entry node = table[hash];
	    while (node != null) {
		if (node.key.equals(k)) {
		    return (V) node.value;
		}
		node = node.next;
	    }
	}
	return null;
    }

    private int hashCode(K key) {
	return Math.abs(key.hashCode()) % table.length;
    }

    private static class Entry<K, V> {
	public K key;
	public V value;
	public Entry<K, V> next;

	Entry() {
	}

	Entry(K k, V v, Entry<K, V> next) {
	    key = k;
	    value = v;
	    this.next = next;
	}
    }

    public static void main(String[] args) {
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("A", "1");
	map.put("B", "2");
	map.put("C", "3");
	map.put("D", "3");
	map.put("E", "3");
	map.put("F", "3");
	map.put("G", "3");
	map.put("H", "3");
	map.put("I", "3");
	map.put("J", "3");
	map.put("K", "3");
	map.put("F", "4");
	map.put("L", "3");
	map.put("M", "3");
	map.put("N", "3");
	map.put("AVC", "3");
	map.put("GG", "3");
	map.put("KSAF", "3");
	map.put("ERER", "3");
	map.put("ERER", "6");
	map.put("I", "100");
	for (Entry entry : map.entrySet()) {
	    System.out.println(entry.key + " : " + entry.value);
	}
    }

}
