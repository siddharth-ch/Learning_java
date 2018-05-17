package datastructures;

import java.util.Iterator;

public class CustomLinkedList<T> implements Iterable<T> {

    private Node head;
    private int actSize;

    public CustomLinkedList() {
    }

    private static class Node {
	public Object data;
	public Node next;
	public Node prev;

	Node(Object d, Node next, Node prev) {
	    this.data = d;
	    this.next = next;
	    this.prev = prev;
	}
    }

    public Object get(int idx) {
	if (idx < 0 || idx >= actSize)
	    throw new IndexOutOfBoundsException();

	Node current = head;
	if (idx == 0)
	    return head.data;
	for (int i = 1; i <= idx && current != null; i++) {
	    current = current.next;
	}
	if (current == null)
	    return null;
	return current.data;
    }

    public boolean add(Object o) {
	if (head == null) {
	    head = new Node(o, null, null);
	} else {
	    Node current = head;
	    Node temp = null;
	    while (current.next != null) {
		current = current.next;
	    }
	    temp = new Node(o, null, current);
	    current.next = temp;
	}
	actSize++;
	return true;
    }

    public boolean add(int idx, Object obj) {
	if (idx < 0 || idx > actSize)
	    throw new IndexOutOfBoundsException();
	Node current = head;
	Node temp;
	if (idx == 0) {
	    head = new Node(obj, current, null);
	    current.prev = head;
	} else {
	    for (int i = 1; i < idx && current != null; i++) {
		current = current.next;
	    }
	    temp = current.next;
	    Node n = new Node(obj, temp, current);
	    current.next = n;
	}
	actSize++;

	return true;
    }

    public boolean remove(Object o) {
	if (head.data == o) {
	    head = head.next;
	    head.prev = null;
	    return true;
	}
	Node current = head;
	while (current != null) {
	    if (current.data == o)
		break;
	    current = current.next;
	}
	Node prev = current.prev;
	Node next = current.next;
	next.prev = prev;
	prev.next = next;
	current.data = null;

	actSize--;
	return true;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	Node current = head;
	sb.append("[");
	while (current != null) {
	    sb.append(current.data.toString() + ",");
	    current = current.next;
	}
	sb.append("]");
	return sb.toString();
    }

    public static void main(String[] args) {
	CustomLinkedList<String> list = new CustomLinkedList<String>();
	list.add("ABC");
	list.add("CBE");
	list.add(0, "BCFF");
	list.add("HAS");
	// list.remove("CBE");
	// System.out.println(list.get(1));
	for (String str : list) {
	    System.out.println(str);
	}

    }

    @Override
    public Iterator<T> iterator() {
	return new Iterator<T>() {

	    int current = 0;
	    Node lastItem = head;

	    @Override
	    public boolean hasNext() {
		return current < actSize;
	    }

	    @Override
	    public T next() {
		current++;
		Node temp = lastItem;
		lastItem = lastItem.next;
		return (T) temp.data;
	    }

	    @Override
	    public void remove() {
		current--;
		CustomLinkedList.this.actSize--;
		CustomLinkedList.this.remove(lastItem.data);
	    }

	};
    }
}
