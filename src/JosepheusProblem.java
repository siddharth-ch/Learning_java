public class JosepheusProblem {

    public static void main(String[] args) {
	Node head = new Node(null, 1);
	Node prev = head;
	for (int i = 2; i < 11; i++) {
	    prev.next = new Node(null, i);
	    prev = prev.next;
	}
	prev.next = head;
	// 1->2->3->4->5->6->7->8->9->10
	// 1->2-4-5-7-8-10
	// 1-4-8-10
	// 4-8
	// 4
	Node temp = head;
	int m = 3;
	Node temp2 = null;
	while (temp.next != temp) {
	    int count = 1;

	    while (count != m) {
		temp2 = temp;
		temp = temp.next;
		count++;
	    }
	    System.out.println("Removing data->" + temp2.next.data);
	    temp2.next = temp.next;
	    temp = temp.next;
	}
	System.out.println(temp.data);
    }

    static class Node {

	Node next;
	int data;

	Node(Node n, int data) {
	    this.data = data;
	    next = n;
	}
    }
}
