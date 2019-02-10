package datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BST {

	Node root = null;
	static SLLNode sllHead = null;

	public static void main(String[] args) {

		BST tree = new BST();

		// Let us create the tree shown in above diagram
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(11);
		tree.root.right.right = new Node(20);

		// Print the converted list
		BTreePrinter.printNode(tree.root);
		// Convert to DLL
		Node head = tree.convertToDoubleLinkedList(tree.root);
		while (head.left != null) {
			head = head.left;
		}
		for (; head != null; head = head.right)
			System.out.print(head.data + "->");
		LinkedList list = new LinkedList();
		SLLNode n1 = new SLLNode();
		n1.data = 1;
		SLLNode n2 = new SLLNode();
		n2.data = 2;
		n1.next = n2;
		SLLNode n3 = new SLLNode();
		n3.data = 3;
		n2.next = n3;
		SLLNode n4 = new SLLNode();
		n4.data = 4;
		n3.next = n4;
		SLLNode n5 = new SLLNode();
		n5.data = 5;
		n4.next = n5;
		list.head = n1;
		sllHead = list.head;
		System.out.println();
		convertSLL_To_BST(5);
	}

	private static Node convertSLL_To_BST(int n) {
		if (n <= 0)
			return null;
		Node left = convertSLL_To_BST(n / 2);
		Node root = new Node(sllHead.data);
		root.left = left;
		sllHead = sllHead.next;
		System.out.println("data : " + root.data);
		if (root.left != null)
			System.out.println("Added to roots left : " + root.left.data);
		Node right = convertSLL_To_BST(n - (n / 2) - 1);
		root.right = right;
		if (root.right != null)
			System.out.println("Added to roots right : " + root.right.data);
		// System.out.println("returning for " + n);
		return root;
	}

	private Node convertToDoubleLinkedList(Node root) {
		Node left;
		Node right;
		if (root == null)
			return root;
		if (root.left != null) {
			left = convertToDoubleLinkedList(root.left);
			while (left.right != null) {
				left = left.right;
			}
			left.right = root;
			root.left = left;
		}
		if (root.right != null) {
			right = convertToDoubleLinkedList(root.right);
			while (right.left != null) {
				right = right.left;
			}
			root.right = right;
			right.left = root;
		}
		return root;
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
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

	private static class LinkedList {
		private SLLNode head;
	}

	private static class SLLNode {
		private SLLNode next;
		private int data;
	}
}
