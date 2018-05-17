import java.util.Stack;

public class ReverseLinkedList {

    public static void main(String[] args) {
	SingleLinkedNode n1 = new SingleLinkedNode();
	n1.data = 1;
	SingleLinkedNode n2 = new SingleLinkedNode();
	n2.data = 2;
	n1.next = n2;
	SingleLinkedNode n3 = new SingleLinkedNode();
	n3.data = 3;
	n2.next = n3;
	SingleLinkedNode l1 = reverseSingleRecursion(n1);
	while (l1 != null) {
	    System.out.println(l1.data);
	    l1 = l1.next;
	}

	DoubleLinkedNode d1 = new DoubleLinkedNode();
	d1.data = 1;
	d1.prev = null;
	DoubleLinkedNode d2 = new DoubleLinkedNode();
	d2.data = 2;
	d2.prev = d1;
	d1.next = d2;
	DoubleLinkedNode d3 = new DoubleLinkedNode();
	d3.data = 3;
	d3.prev = d2;
	d2.next = d3;
	DoubleLinkedNode d4 = new DoubleLinkedNode();
	d4.data = 4;
	d4.prev = d3;
	d3.next = d4;
	DoubleLinkedNode l = reverseDouble(d1);
	while (l != null) {
	    System.out.println(l.data);
	    l = l.next;
	}
    }

    private static SingleLinkedNode reverseSingle(SingleLinkedNode d1) {
	SingleLinkedNode cur = d1;
	SingleLinkedNode next = null;
	SingleLinkedNode prev = null;
	// 1->2->3->null
	// 2->1->null
	while (cur != null) {
	    next = cur.next;
	    cur.next = prev;
	    prev = cur;
	    cur = next;
	}
	return prev;
    }

    private static SingleLinkedNode reverseSingleRecursion(SingleLinkedNode root) {
	if (root == null || root.next == null) {
	    return root;
	}

	SingleLinkedNode temp = reverseSingleRecursion(root.next);
	root.next.next = root;
	root.next = null;
	return temp;
    }

    private static DoubleLinkedNode reverseDouble(DoubleLinkedNode d1) {
	DoubleLinkedNode cur = d1;
	DoubleLinkedNode next = null;
	DoubleLinkedNode last = null;
	while (cur != null) {
	    if (cur.next == null) {
		last = cur;
	    }
	    next = cur.next;
	    cur.next = cur.prev;
	    cur.prev = next;
	    cur = next;
	}

	return last;

    }

    private static void print(SingleLinkedNode n1) {
	if (n1 == null)
	    return;

	print(n1.next);
	System.out.println(n1.data);
    }

    private static void print2(SingleLinkedNode n) {
	Stack<SingleLinkedNode> s = new Stack<SingleLinkedNode>();
	SingleLinkedNode cur = n;
	while (cur != null) {
	    s.add(cur);
	    cur = cur.next;
	}
	while (!s.isEmpty()) {
	    System.out.println(s.pop().data);
	}
    }

    private static class SingleLinkedNode {
	public int data;
	public SingleLinkedNode next;
    }

    private static class DoubleLinkedNode {
	public int data;
	public DoubleLinkedNode next;
	public DoubleLinkedNode prev;

	@Override
	public String toString() {
	    // TODO Auto-generated method stub
	    return data + "";
	}
    }
}
