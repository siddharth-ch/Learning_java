package datastructures;
public class DoublyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private Node<E> temp = null;

	private int counter = 0;

	public DoublyLinkedList() {
	}

	public int size() {
		return counter;
	}

	private static class Node<E> {
		Node<E> next, previous;
		E elem;

		Node(Node<E> previous,E elem, Node<E> next) {
			this.previous=previous;
			this.elem=elem;
			this.next = next;
		}
	}

	public void add(E elem) {
		// if we don't have any elems in our LinkedList
		if (head == null) {
			head = tail = new Node<E>(tail,elem,null);
			head.elem = elem;
			head.next = tail;
			tail = head;
		} else {
			tail.next = new Node<E>(null,elem,null); // add a new node to the end of the list
			tail.previous = tail; // set the tail pointer to that node
			tail=tail.next;
		}
		counter++;
	}
	public static void main(String[] args) {
		DoublyLinkedList<String> a = new DoublyLinkedList<String>();
		a.add("1");
		a.add("2");
		System.out.println(a);
	}
}
