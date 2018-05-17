package datastructures;

public class SplayTree<T extends Comparable<T>> {

    private Node<T> head;

    public Node<T> insert(T data) {
	if (head == null) {
	    Node<T> n = new Node<>(data);
	    head = n;
	    return head;
	}
	head = splay(head, data);
	Node<T> temp = head;
	if (data.compareTo(head.data) < 0) {
	    head = new Node<T>(data);
	    head.right = temp.left;
	    temp.left = null;
	    head.right = temp;
	} else {
	    head = new Node<T>(data);
	    if (temp.right != null && data.compareTo(temp.right.data) < 0) {
		head.right = temp.right;
		temp.right = null;
	    }
	    head.left = temp;
	}
	System.out.println(head);
	return head;

    }

    private Node<T> splay(Node<T> node, T data) {
	if (node == null) {
	    return node;
	}
	if (data.compareTo(node.data) < 0) {
	    if (node.left != null) {
		if (data.compareTo(node.left.data) < 0) {
		    node.left.left = splay(node.left.left, data);
		    if (node.left.left != null)
			node.left = rightRotation(node.left);
		} else if (data.compareTo(node.left.data) > 0) {
		    node.left.right = splay(node.left.right, data);
		    if (node.left.right != null)
			node.left = leftRotation(node.left);
		}
		if (node.left == null)
		    return node;
		return rightRotation(node);
	    }
	} else if (node.data.compareTo(data) > 0) {
	    if (node.right != null) {
		if (data.compareTo(node.right.data) < 0) {
		    node.right.left = splay(node.right.left, data);
		    node.right = rightRotation(node.right);
		} else if (data.compareTo(node.right.data) > 0) {
		    node.right.right = splay(node.right.right, data);
		    node.right = leftRotation(node.right);
		}
		node.right = leftRotation(node.right);
		if (node.right == null)
		    return node;
		return leftRotation(node);
	    }
	}

	return node;

    }

    // private Node<T> splay(Node<T> currentNode, T data) {
    // if (currentNode == null)
    // return null;
    // if (data.compareTo(currentNode.data) == 0)
    // return currentNode;
    // if (currentNode.left != null && currentNode.left.left != null
    // && data.compareTo(currentNode.left.left.data) == 0) {
    // currentNode = doubleRightRotation(currentNode);
    // } else if (currentNode.right != null && currentNode.right.right != null
    // && data.compareTo(currentNode.right.right.data) == 0) {
    // currentNode = doubleLeftRotation(currentNode);
    // } else if (currentNode.left != null && currentNode.left.right != null
    // && data.compareTo(currentNode.left.right.data) == 0) {
    // currentNode.left = leftRotation(currentNode.left);
    // currentNode = rightRotation(currentNode);
    // } else if (currentNode.right != null && currentNode.right.left != null
    // && data.compareTo(currentNode.right.left.data) == 0) {
    // currentNode.right = rightRotation(currentNode.right);
    // currentNode = leftRotation(currentNode);
    // } else if (currentNode.left != null && data.compareTo(currentNode.left.data)
    // == 0) {
    // currentNode = rightRotation(currentNode);
    // } else if (currentNode.right != null &&
    // data.compareTo(currentNode.right.data) == 0) {
    // currentNode = leftRotation(currentNode);
    // }
    // return currentNode;
    // }

    // private Node splay(Comparable x, Node t) {
    // Node leftTreeMax, rightTreeMin;
    //
    // head.left = head.right = null;
    // leftTreeMax = rightTreeMin = head;
    //
    // nullNode.data = x; // Guarantee a match
    //
    // for (;;)
    // if (x.compareTo(t.data) < 0) {
    // if (x.compareTo(t.left.data) < 0)
    // t = rotateWithLeftChild(t);
    // if (t.left == nullNode)
    // break;
    // // Link Right
    // rightTreeMin.left = t;
    // rightTreeMin = t;
    // t = t.left;
    // } else if (x.compareTo(t.data) > 0) {
    // if (x.compareTo(t.right.data) > 0)
    // t = rotateWithRightChild(t);
    // if (t.right == nullNode)
    // break;
    // // Link Left
    // leftTreeMax.right = t;
    // leftTreeMax = t;
    // t = t.right;
    // } else
    // break;
    //
    // leftTreeMax.right = t.left;
    // rightTreeMin.left = t.right;
    // t.left = head.right;
    // t.right = head.left;
    // return t;
    // }
    //
    // /**
    // * Rotate binary tree node with left child.
    // */
    // static Node rotateWithLeftChild(Node k2) {
    // Node k1 = k2.left;
    // k2.left = k1.right;
    // k1.right = k2;
    // return k1;
    // }
    //
    // /**
    // * Rotate binary tree node with right child.
    // */
    // static Node rotateWithRightChild(Node k1) {
    // Node k2 = k1.right;
    // k1.right = k2.left;
    // k2.left = k1;
    // return k2;
    // }
    //
    // private Node<T> doubleLeftRotation(Node<T> node) {
    // Node temp = node.right.right;
    // Node parent = node.right;
    // temp.left = parent;
    // parent.left = node;
    // node.right = null;
    // parent.right = null;
    // return temp;
    // }
    //
    // private Node<T> doubleRightRotation(Node<T> node) {
    // /*
    // * 15 10 9
    // *
    // */
    // Node temp = node.left.left;
    // Node parent = node.left;
    // temp.right = parent;
    // parent.right = node;
    // node.left = null;
    // parent.left = null;
    // return temp;
    // }

    private Node<T> rightRotation(Node<T> currentNode) {
	Node<T> left = currentNode.left;
	Node<T> temp = null;
	if (left == null)
	    return null;
	if (left.right != null) {
	    temp = left.right;
	}

	if (temp != null && temp.data.compareTo(currentNode.data) > 0) {
	    currentNode.right = temp;
	}
	currentNode.left = temp;
	left.right = currentNode;
	return left;
    }

    private Node<T> leftRotation(Node<T> currentNode) {
	Node<T> right = currentNode.right;
	Node<T> temp = null;
	if (right == null) {
	    return null;
	}
	if (right.left != null) {
	    temp = right.left;
	}
	if (temp != null && temp.data.compareTo(currentNode.data) < 0) {
	    currentNode.left = temp;
	}

	currentNode.right = temp;
	right.left = currentNode;
	return right;
    }

    private Node<T> insert(Node<T> currentNode, T data) {
	if (currentNode == null) {
	    return new Node<T>(data);
	}

	if (data.compareTo(currentNode.data) < 0) {
	    currentNode.left = insert(currentNode.left, data);
	} else if (data.compareTo(currentNode.data) > 0) {
	    currentNode.right = insert(currentNode.right, data);
	}

	return currentNode;
    }

    public void preOrder(Node<T> node) {
	if (node != null) {
	    // System.out.print("null ");
	    // } else {
	    System.out.print(node.data + " ");
	    preOrder(node.left);
	    preOrder(node.right);
	}

    }

    private static class Node<T extends Comparable<T>> {
	public Node(T data) {
	    this.data = data;
	}

	public Node<T> left;
	public T data;
	public Node<T> right;

	@Override
	public String toString() {
	    // TODO Auto-generated method stub
	    return data.toString();
	}

    }

    public static void main(String[] args) {
	SplayTree<Integer> i = new SplayTree<>();
	i.insert(5);
	i.insert(10);
	Node node = i.insert(15);
	i.preOrder(node);
	System.out.println();
	node = i.insert(6);
	i.preOrder(node);
	System.out.println();
	node = i.insert(9);
	i.preOrder(node);
	System.out.println();
	node = i.insert(7);
	i.preOrder(node);
	System.out.println();
	node = i.insert(11);
	i.preOrder(node);
	System.out.println();
	node = i.insert(4);
	i.preOrder(node);
	System.out.println();
    }
}
