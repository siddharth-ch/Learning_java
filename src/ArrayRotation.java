public class ArrayRotation {

    static boolean checkBST(Node root) {
	Node head = root;
	while (head != null) {

	    Node left = head.left;
	    Node right = head.right;
	    if (left != null && right != null) {

	    } else {
		return true;
	    }
	}

	return false;

    }

    public static void main(String[] args) {
	Node n = new Node();

	Node n4 = new Node();
	n4.data = 3;
	Node n5 = new Node();
	n5.data = 5;
	Node n6 = new Node();
	n6.data = 7;
	Node n3 = new Node();
	n3.data = 1;

	Node n1 = new Node();
	n1.data = 2;
	n1.left = n3;
	n1.right = n4;
	Node n2 = new Node();
	n2.left = n5;
	n2.right = n6;
	n2.data = 6;

	n.data = 4;
	n.left = n1;
	n.right = n2;

	System.out.println(checkBST(n));
    }

    private static class Node {
	public Node() {
	    // TODO Auto-generated constructor stub
	}

	int data;
	Node left;
	Node right;
    }
}