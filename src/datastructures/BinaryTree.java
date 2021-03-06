package datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
		b.getAllPathsFromRootToLeaf(b.head, "", list);
		System.out.println("Paths from Root to Leaf: ");
		list.stream().forEach(System.out::println);
		list.clear();
		b.findPathForAGivenSum(b.head, 0, 35, list, "");
		System.out.println("Path with sum of 35: ");
		list.stream().forEach(System.out::println);
		b.mirrorOfTree(b.head);
		System.out.println("Mirror of Tree : ");
		BTreePrinter.printNode(b.head);
		System.out.println("LCA of two nodes: " + getLCAOfNOdes(b.head, 9, 1).data);
		System.out.println("Zig Zag Print of Tree");
		printZigZagTree(b.head);
	}

	private static void printZigZagTree(Node temp) {
		Stack<Node> zig = new Stack();
		// true= zig (>) false = zag(<)
		boolean var = false;
		Stack<Node> zag = new Stack();
		zig.add(temp);

		while (!zig.isEmpty()) {
			temp = zig.pop();
			System.out.print(temp.data + " ");
			if (!var) {
				if (temp.left != null) {
					zag.push(temp.left);
				}
				if (temp.right != null) {
					zag.push(temp.right);
				}
			} else {
				if (temp.right != null) {
					zag.push(temp.right);
				}
				if (temp.left != null) {
					zag.push(temp.left);
				}
			}

			if (zig.isEmpty()) {
				var = !var;
				Stack st = zig;
				zig = zag;
				zag = st;
			}
		}
	}

	private static Node getLCAOfNOdes(Node temp, int i, int j) {
		if (temp == null) {
			return temp;
		}
		if (temp.data == i || temp.data == j)
			return temp;
		Node left = getLCAOfNOdes(temp.left, i, j);
		Node right = getLCAOfNOdes(temp.right, i, j);
		if (left != null && right != null) {
			return temp;
		} else {
			return left != null ? left : right;
		}
	}

	private void mirrorOfTree(Node temp) {
		if (temp == null)
			return;
		Node left = temp.left;
		temp.left = temp.right;
		temp.right = left;
		mirrorOfTree(temp.left);
		mirrorOfTree(temp.right);
	}

	private void findPathForAGivenSum(Node temp, int sum, int desiredSum, List<String> list, String str) {
		if (temp == null)
			return;
		str += temp.data + "->";
		sum += temp.data;
		if (sum == desiredSum) {
			list.add(str);
		} else if (sum > desiredSum) {
			return;
		}
		findPathForAGivenSum(temp.left, sum, desiredSum, list, str);
		findPathForAGivenSum(temp.right, sum, desiredSum, list, str);
	}

	private void getAllPathsFromRootToLeaf(Node temp, String str, List<String> list) {
		if (temp == null) {
			return;
		}
		str += temp.data + "->";
		getAllPathsFromRootToLeaf(temp.left, str, list);
		getAllPathsFromRootToLeaf(temp.right, str, list);
		if (temp.left == null && temp.right == null) {
			list.add(str);
		}
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

	public Node traverseMorrisInOrder(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {

		}
		return root;
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

	static class BTreePrinter {

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
}
