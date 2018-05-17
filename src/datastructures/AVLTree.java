package datastructures;

public class AVLTree {
    public static void main(String args[]) throws Exception {
	AVLT<Integer> av = new AVLT<>();
	av.insert(8);
	av.insert(5);
	av.insert(3);
	av.insert(1);
	av.insert(6);
	av.insert(12);
	av.insert(7);
	AVLNode<Integer> head = av.insert(10);
	av.preOrder(head);
	System.out.println();
	av.remove(8);
	av.preOrder(head);
	System.out.println();
	av.remove(10);
	av.preOrder(head);
    }

}

class AVLT<T extends Comparable<T>> {

    private AVLNode<T> head;
    private int size;

    public AVLNode<T> insert(T data) {
	head = insertNode(head, data);
	size++;
	return head;
    }

    private <E extends T> AVLNode<T> insertNode(AVLNode<T> currentNode, E data) {
	// The current root node is empty. Create a new node here
	if (currentNode == null) {
	    return new AVLNode<T>(data);
	}

	if (data.compareTo(currentNode.data) < 0) {
	    currentNode.left = insertNode(currentNode.left, data);
	} else if (data.compareTo(currentNode.data) > 0) {
	    currentNode.right = insertNode(currentNode.right, data);
	}
	currentNode = balanceTree(currentNode, data);
	currentNode.height = calcHeight(currentNode);
	return currentNode;

    }

    private <E extends T> AVLNode<T> balanceTree(AVLNode<T> currentNode, E data) {
	int balance = currentNode == null ? 0 : (height(currentNode.left) - height(currentNode.right));

	if (balance > 1) {
	    if (data.compareTo(currentNode.left.data) < 0) {
		currentNode = rightRotation(currentNode);
	    } else {
		currentNode = leftRightRotation(currentNode);
	    }

	} else if (balance < -1) {
	    if (data.compareTo(currentNode.right.data) > 0) {
		currentNode = leftRotation(currentNode);
	    } else {
		currentNode = rightLeftRotation(currentNode);
	    }
	}
	return currentNode;
    }

    public AVLNode<T> remove(T data) {
	head = remove(head, data);
	return head;
    }

    private AVLNode<T> remove(AVLNode<T> currentNode, T data) {
	if (currentNode == null) {
	    return null;
	} else if (data.compareTo(currentNode.data) < 0) {
	    currentNode.left = remove(currentNode.left, data);
	} else if (data.compareTo(currentNode.data) > 0) {
	    currentNode.right = remove(currentNode.right, data);
	} else {
	    // zero child
	    if (currentNode.left == null && currentNode.right == null) {
		System.out.println("Remove as 0 child : " + currentNode.data);
		return null;
	    } // one child
	    else if (currentNode.left == null) {
		System.out.println("Remove as 1 child : " + currentNode.data);
		return currentNode.right;
	    } else if (currentNode.right == null) {
		System.out.println("Remove as 1 child : " + currentNode.data);
		return currentNode.left;
	    } else {
		// two child
		// findMaxFromLeft could be used
		currentNode.data = finMinFromRight(currentNode.right).data;
		currentNode.right = remove(currentNode.right, currentNode.data);
	    }
	}
	currentNode = balanceTree(currentNode, data);
	currentNode.height = calcHeight(currentNode);
	return currentNode;
    }

    private AVLNode<T> finMinFromRight(AVLNode<T> node) {
	if (node.left == null)
	    return node;
	return finMinFromRight(node.left);
    }

    public void preOrder(AVLNode<T> current) {
	if (current != null) {
	    // System.out.print("null ");
	    // } else {
	    System.out.print(current.data + " ");
	    preOrder(current.left);
	    preOrder(current.right);
	}

    }

    private int height(AVLNode<T> node) {
	return node == null ? -1 : node.height;
    }

    private int calcHeight(AVLNode<T> currentNode) {
	return Math.max(height(currentNode.left), height(currentNode.right)) + 1;
    }

    private AVLNode<T> leftRotation(AVLNode<T> currentNode) {
	AVLNode<T> right = currentNode.right;
	right.left = currentNode;
	currentNode.right = null;
	currentNode.height = calcHeight(currentNode);
	right.height = calcHeight(right);
	return right;
    }

    private AVLNode<T> rightRotation(AVLNode<T> currentNode) {
	AVLNode<T> left = currentNode.left;
	left.right = currentNode;
	currentNode.left = null;
	currentNode.height = calcHeight(currentNode);
	left.height = calcHeight(left);
	return left;
    }

    private AVLNode<T> leftRightRotation(AVLNode<T> currentNode) {
	currentNode.left = leftRotation(currentNode.left);
	return rightRotation(currentNode);
    }

    private AVLNode<T> rightLeftRotation(AVLNode<T> currentNode) {
	currentNode.right = rightRotation(currentNode.right);
	return leftRotation(currentNode);
    }
}

class AVLNode<T extends Comparable<T>> {
    public AVLNode<T> left;
    public T data;
    public AVLNode<T> right;

    public int height = 0;

    public AVLNode(AVLNode<T> left, T data, AVLNode<T> right) {
	this.left = left;
	this.data = data;
	this.right = right;
    }

    public AVLNode(T data) {
	this.data = data;
    }

    @Override
    public String toString() {
	return "AVLNode [left=" + left + ", data=" + data + ", right=" + right + ", height=" + height + "]";
    }

}