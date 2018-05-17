import java.util.Arrays;
import java.util.Stack;

public class StackSort_Recursion {

    public static void main(String args[]) throws Exception {

	Stack<Integer> s = new Stack<>();
	s.push(2);
	s.push(1);
	s.push(-5);
	s.push(30);
	s.push(8);
	s.push(6);
	System.out.println(Arrays.toString(s.toArray()));
	sortStack(s);
	System.out.println(Arrays.toString(s.toArray()));
    }

    private static void sortStack(Stack<Integer> s) {
	if (s.empty())
	    return;
	int temp = s.pop();
	sortStack(s);
	sortInternal(s, temp);
    }

    private static void sortInternal(Stack<Integer> s, int temp) {
	if (s.empty()) {
	    s.push(temp);
	} else {
	    int t = s.pop();
	    if (temp > t) {
		s.push(t);
		s.push(temp);
	    } else {
		sortInternal(s, temp);
		s.push(t);
	    }
	}

    }
}