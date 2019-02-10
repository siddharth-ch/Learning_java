package datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree {

    Node head;

    public static void main(String[] args) {
	BinarySearchTree b = new BinarySearchTree();
	b.insert(15);
	b.insert(8);
	b.insert(5);
	b.insert(6);
	b.insert(2);
	b.insert(10);
	b.insert(22);
	b.insert(20);
	b.insert(25);
	BTreePrinter.printNode(b.head);
    }

    public void insert(int data) {
	if (head == null) {
	    head = new Node(data);
	    return;
	}
	Node temp = head;
	Node prev = null;
	while (temp != null) {
	    prev = temp;
	    if (temp.data > data) {
		temp = temp.left;
	    } else if (temp.data < data) {
		temp = temp.right;
	    }
	}
	if (prev.data < data) {
	    prev.right = new Node(data);
	} else {
	    prev.left = new Node(data);
	}

    }

    static class Node {
	public Node(int data) {
	    this.data = data;
	}

	int data;
	Node left;
	Node right;
    }

    static class BTreePrinter {

	public static <T extends Comparable<?>> void printNode(Node root) {
	    int maxLevel = BTreePrinter.maxLevel(root);
	    System.out.println(maxLevel);
	    printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static <T extends Comparable<?>> void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
	    if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
		return;

	    int floor = maxLevel - level;
	    int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
	    int firstSpaces = (int) Math.pow(2, (floor)) - 1;
	    int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

	    BTreePrinter.printWhitespaces(firstSpaces);

	    List<Node> newNodes = new ArrayList<Node>();
	    for (Node node : nodes) {
		if (node != null) {
		    System.out.print(node.data);
		    newNodes.add(node.left);
		    newNodes.add(node.right);
		} else {
		    newNodes.add(null);
		    newNodes.add(null);
		    System.out.print(" ");
		}

		BTreePrinter.printWhitespaces(betweenSpaces);
	    }
	    System.out.println("");

	    for (int i = 1; i <= edgeLines; i++) {
		for (int j = 0; j < nodes.size(); j++) {
		    BTreePrinter.printWhitespaces(firstSpaces - i);
		    if (nodes.get(j) == null) {
			BTreePrinter.printWhitespaces(edgeLines + edgeLines + i + 1);
			continue;
		    }

		    if (nodes.get(j).left != null)
			System.out.print("/");
		    else
			BTreePrinter.printWhitespaces(1);

		    BTreePrinter.printWhitespaces(i + i - 1);

		    if (nodes.get(j).right != null)
			System.out.print("\\");
		    else
			BTreePrinter.printWhitespaces(1);

		    BTreePrinter.printWhitespaces(edgeLines + edgeLines - i);
		}

		System.out.println("");
	    }

	    printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
	    for (int i = 0; i < count; i++)
		System.out.print(" ");
	}

	private static <T extends Comparable<?>> int maxLevel(Node node) {
	    if (node == null)
		return 0;

	    return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
	    for (Object object : list) {
		if (object != null)
		    return false;
	    }

	    return true;
	}
    }
}
