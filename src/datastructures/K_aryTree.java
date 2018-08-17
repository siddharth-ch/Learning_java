package datastructures;

public class K_aryTree {
	Node head = null;
	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 6, 2, 7, 11, 14, 16, 17 };
		Node n = createTree(arr, 0, 3);
		System.out.println(n.data);
	}

	private static Node createTree(int[] arr, int i, int k) {
		if (i >= arr.length)
			return null;
		Node node = new Node(arr[i]);
		node.nodes = new Node[k];
		int idx = 0;
		for (int j = i * k + 1; j <= i * k + k; j++) {
			node.nodes[idx++] = createTree(arr, j, k);
		}
		return node;
	}
	static class Node {
		int data;
		Node[] nodes;

		Node(int data) {
			this.data = data;
		}
	}

}
