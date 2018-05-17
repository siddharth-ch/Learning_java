package datastructures;

import java.util.Stack;

public class BinaryTree {
    Node head = null;

    public static void main(String[] args) {
	BinaryTree b = new BinaryTree();
	b.insert(5);
	b.insert(3);
	b.insert(10);
	b.insert(2);
	b.insert(1);
	b.insert(8);
	b.traverse();
    }

    private void traverse() {
	traverse(head);
	System.out.println();
	System.out.println("Preorder iteration");
	traversePreOrder(head);
    }

    public void traverse(Node head) {
	if (head == null) {
	    return;
	}
	System.out.print(head.data + " ");
	traverse(head.left);
	traverse(head.right);

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

    public void traverseInOrder(Node head) {
	Stack<Node> s = new Stack<>();
	while (true) {
	    Node temp = head;
	    while (temp != null) {
		s.push(temp);
		temp = temp.left;
	    }
	    if (s.isEmpty())
		break;
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
