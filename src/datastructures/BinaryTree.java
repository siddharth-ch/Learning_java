package datastructures;

import java.util.Stack;

public class BinaryTree {
    Node head = null;

    public static void main(String[] args) {
	BinaryTree b = new BinaryTree();
	Node n1 = new Node(1);
	Node n2 = new Node(2);
	Node n3 = new Node(3);
	n1.left = n2;
	n1.right = n3;
	n2.left = new Node(4);
	n2.right = new Node(5);
	n3.left = new Node(6);
	n3.right = new Node(7);
	b.head = n1;
	b.traversePreOrder();
	b.traverseInOrder();
	b.traversePostOrder();
    }

    private void traversePreOrder() {
	traversePreOrderRec(head);
	System.out.println();
	System.out.println("Preorder iteration");
	traversePreOrder(head);
    }

    private void traverseInOrder() {
	System.out.println();
	System.out.println("In Order recursion");
	traverseInOrderRec(head);
	System.out.println();
	traverseInOrder(head);
    }

    private void traversePostOrder() {
	System.out.println();
	System.out.println("Post Order recursion");
	traversePostOrderRec(head);
	System.out.println();
	traversePostOrder(head);
    }

    private void traversePostOrderRec(Node head) {
	if (head == null) {
	    return;
	}
	traversePostOrderRec(head.left);
	traversePostOrderRec(head.right);
	System.out.print(head.data + " ");
    }

    private void traversePostOrder(Node head) {
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
		s.pop();
		System.out.print(temp.data + " ");
		while (!s.isEmpty() && temp == s.peek().right) {
		    temp = s.pop();
		    System.out.print(temp.data + " ");
		}
	    }
	    if (!s.isEmpty()) {
		temp = s.peek().right;
	    } else {
		temp = null;
	    }
	}

    }

    public void traversePreOrderRec(Node head) {
	if (head == null) {
	    return;
	}
	System.out.print(head.data + " ");
	traversePreOrderRec(head.left);
	traversePreOrderRec(head.right);

    }

    public void traversePreOrder(Node head) {
	Stack<Node> s = new Stack<>();
	s.push(head);
	while (!s.isEmpty()) {
	    Node temp = s.pop();
	    if (temp != null) {
		System.out.print(temp.data + " ");
		s.push(temp.right);
		s.push(temp.left);
	    }
	}
    }

    public void traverseInOrderRec(Node head) {
	if (head == null) {
	    return;
	}
	traverseInOrderRec(head.left);
	System.out.print(head.data + " ");
	traverseInOrderRec(head.right);

    }

    public void traverseInOrder(Node head) {
	Stack<Node> s = new Stack<>();
	Node temp = head;
	while (true) {
	    while (temp != null) {
		s.push(temp);
		temp = temp.left;
	    }
	    if (s.isEmpty())
		break;
	    temp = s.pop();
	    System.out.print(temp.data + " ");
	    temp = temp.right;
	}
    }

    public void insert(int data) {
	if (head == null) {
	    head = new Node(data);
	} else {
	    head = insertRec(head, data);
	}
    }

    private Node insertRec(Node head, int data) {
	Node temp = head;
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

    static class Node {
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
    }
}
