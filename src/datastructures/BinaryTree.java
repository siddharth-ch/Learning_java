package datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import datastructures.BinaryTree.Node;

public class BinaryTree {
	Node head = null;

	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		/*
		 * 5 / \ 2 8 / 1
		 * 
		 */
		b.insert(10);
		b.insert(13);
		b.insert(12);
		b.insert(20);
		b.insert(8);
		b.insert(9);
		b.insert(3);
		b.insert(1);
		b.insert(5);
		b.insert(7);
		b.insert(6);
		// b.insert(4);
		// b.traverse();

		//
		// b.traversePostOrder(b.head);
		BTreePrinter.printNode(b.head);
		System.out.println("PreOrder Recursion");
		b.traversePreORec(b.head);
		System.out.println();
		b.traversePreOrder(b.head);
		System.out.println("InOrder recursion");
		b.traverseInORec(b.head);
		System.out.println();
		b.traverseInOrder(b.head);
		System.out.println("PostOrder Recursion");
		b.traversePostORec(b.head);
		System.out.println();
		b.traversePostOrder(b.head);
		Node item = b.searchRec(b.head, 15);
		System.out.println("Height of Tree from Root: Recursive: " + b.getHeightRec(b.head) + " Iterative: "
				+ b.getHeightIterative());
		System.out.println("Diameter of tree is " + b.getMaxDiameterOfTree());
		List<String> list = new ArrayList<String>();
		b.getAllPathsFromRootToLeaf(list);
		System.out.println("Paths : " );
		list.stream().forEach(System.out::println);
	}

	private void getAllPathsFromRootToLeaf() {

	}

	private int getMaxDiameterOfTree() {
		int[] res = new int[1];
		getDiameter(head, res);
		return res[0];
	}

	private int getDiameter(Node temp, int[] res) {
		if (temp == null) {
			return 0;
		}
		int left = getDiameter(temp.left, res);
		int right = getDiameter(temp.right, res);
		res[0] = Math.max(res[0], left + right);
		return Math.max(left, right) + 1;
	}

	private int getHeightIterative() {
		Queue<Node> q = new LinkedList<>();
		q.add(head);
		q.add(null);
		int level = 0;
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp == null) {
				level++;
				if (!q.isEmpty())
					q.add(null);
			} else {
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
		}
		return level;
	}

	private int getHeightRec(Node temp) {
		if (temp == null)
			return 0;
		int leftH = getHeightRec(temp.left);
		int rightH = getHeightRec(temp.right);
		return Math.max(leftH, rightH) + 1;
	}

	private Node searchRec(Node temp, int i) {
		if (temp == null)
			return null;
		if (temp.data > i) {
			return searchRec(temp.left, i);
		} else if (i > temp.data) {
			return searchRec(temp.right, i);
		} else if (temp.data == i) {
			return temp;
		} else {
			return null;
		}
	}

	private void traverse() {
		System.out.println("PreOrder Recursion");
		traversePreORec(head);
		System.out.println();
	}

	public void traversePreORec(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		traversePreORec(head.left);
		traversePreORec(head.right);
	}

	public void traverseInORec(Node head) {
		if (head == null) {
			return;
		}
		traverseInORec(head.left);
		System.out.print(head.data + " ");
		traverseInORec(head.right);
	}

	public void traversePostORec(Node head) {
		if (head == null) {
			return;
		}
		traversePostORec(head.left);
		traversePostORec(head.right);
		System.out.print(head.data + " ");
	}

	public void traversePreOrder(Node head) {
		Stack<Node> s = new Stack<>();
		s.push(head);
		while (!s.isEmpty()) {
			Node temp = s.pop();
			if (temp != null) {
				System.out.print(temp.data + " ");
				if (temp.right != null)
					s.push(temp.right);
				if (temp.left != null)
					s.push(temp.left);
			}
		}
		System.out.println();
	}

	private void traversePostOrder(Node head) {
		System.out.println("Post Order Traversal");
		Stack<Node> s = new Stack<>();
		Node temp = head;
		while (true) {
			while (temp != null) {
				s.push(temp);
				temp = temp.left;
			}
			if (s.isEmpty())
				break;
			temp = s.peek();
			if (temp.right == null) {
				temp = s.pop();
				System.out.print(temp.data + " ");
				while (!s.isEmpty() && temp == s.peek().right) {
					temp = s.pop();
					System.out.print(temp.data + " ");
				}
				temp = null;
			} else
				temp = temp.right;
		}
		System.out.println();
	}

	public void traverseInOrder(Node head) {
		System.out.println("In Order Traversal");
		Stack<Node> s = new Stack<>();
		Node temp = head;
		while (true) {
			while (temp != null) {
				s.push(temp);
				temp = temp.left;
			}
			if (s.isEmpty())
				break;
			Node temp2 = s.pop();
			System.out.print(temp2.data + " ");
			temp = temp2.right;
		}
		System.out.println();
	}

	public void insert(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			head = insertRec(head, data);
		}
	}

	private Node insertRec(Node temp, int data) {
		if (temp == null) {
			return new Node(data);
		}

		if (data < temp.data) {
			temp.left = insertRec(temp.left, data);

		} else if (data > temp.data) {
			temp.right = insertRec(temp.right, data);
		}

		return temp;
	}

	static class Node<T> {
		Node left;
		Node right;
		int data;

		Node(Node left, int data, Node right) {
			this.left = left;
			this.right = right;
			this.data = data;
		}

		Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return Integer.toString(this.data);
		}
	}

}

class BTreePrinter {

	public static <T extends Comparable<?>> void printNode(Node<T> root) {
		int maxLevel = BTreePrinter.maxLevel(root);
		System.out.println(maxLevel);
		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BTreePrinter.printWhitespaces(firstSpaces);

		List<Node<T>> newNodes = new ArrayList<Node<T>>();
		for (Node<T> node : nodes) {
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

	private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
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
