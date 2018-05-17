import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapSack_Truck {

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n, List<Integer> incl, List<Integer> v) {
	List<Integer> v1 = new ArrayList<>();
	List<Integer> v2 = new ArrayList<>();
	// Base Case
	if (n == 0 || W == 0)
	    return 0;
	// If weight of the nth item is more than Knapsack capacity W, then
	// this item cannot be included in the optimal solution
	if (wt[n - 1] > W) {
	    return knapSack(W, wt, val, n - 1, incl, v1);
	}

	// Return the maximum of two cases:
	// (1) nth item included
	// (2) not included
	else {
	    System.out.println(wt[n - 1]);
	    v1.add(n - 1);
	    int m = val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1, incl, v1);
	    int n1 = knapSack(W, wt, val, n - 1, incl, v2);
	    if (Math.max(m, n1) == m) {
		v.addAll(v1);
	    } else {
		v.addAll(v2);
	    }
	    return Math.max(m, n1);
	}
    }

    // Driver program to test above function
    public static void main(String args[]) {
	List<Integer> list = new ArrayList<>();
	int id[] = new int[] { 38, 21, 13, 15 };
	int val[] = new int[] { 500, 1800, 1500, 50 };
	int wt[] = new int[] { 130, 280, 120, 50 };
	int W = 300;
	int n = val.length;
	System.out.println(knapSack(W, wt, val, n, list, list));
	System.out.println(Arrays.toString(list.toArray()));
    }
}