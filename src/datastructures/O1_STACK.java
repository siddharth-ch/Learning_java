package datastructures;

import java.util.Stack;

public class O1_STACK {

	Stack<Integer> m = new Stack<Integer>();

	Stack<Integer> minStk = new Stack<Integer>();

	public void push(Integer i) {
		m.push(i);
		if (!minStk.isEmpty()) {
			Integer min = minStk.peek();
			if (i <= min) {
				minStk.push(i);
			} else {
				minStk.push(min);
			}
		} else {
			minStk.push(i);
		}
	}

	public int pop() {
		minStk.pop();
		return m.pop();
	}

	public int getMin() {
		return minStk.peek();
	}

	public static void main(String[] args) {
		O1_STACK l = new O1_STACK();
		l.push(6);
		l.push(1);
		l.push(2);
		l.push(4);
		l.push(-1);
		System.out.println(l.getMin());
		System.out.println("Pop" + l.pop());
		System.out.println(l.getMin());
	}
}
