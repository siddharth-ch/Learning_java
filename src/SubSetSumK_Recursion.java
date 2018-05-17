import java.util.Arrays;

public class SubSetSumK_Recursion {

    static int count = 0;

    public static void main(String t[]) {
	int A[] = { -9, -4, 1, 2, 3, 8 };
	boolean[] B = new boolean[A.length];
	subset(A, 3, 0, 0, B);
	System.out.println(count);
    }

    public static void subset(int[] A, int k, int start, int currLen, boolean[] used) {
	if (currLen == k) {
	    int sum = 0;
	    for (int i = 0; i < A.length; i++) {
		if (used[i] == true) {
		    System.out.print(A[i] + " ");
		    sum += A[i];
		}
	    }
	    if (sum == 0)
		count++;
	    System.out.println();
	    return;
	}
	if (start == A.length) {
	    return;
	}
	// For every index we have two options,
	// 1.. Either we select it, means put true in used[] and make currLen+1
	used[start] = true;
	System.out.println("Top: " + (start + 1) + " : " + (currLen + 1));
	System.out.println(Arrays.toString(used));
	subset(A, k, start + 1, currLen + 1, used);
	// 2.. OR we dont select it, means put false in used[] and dont increase
	// currLen

	used[start] = false;
	System.out.println("Bottom : " + (start + 1) + " : " + (currLen));
	System.out.println(Arrays.toString(used));
	subset(A, k, start + 1, currLen, used);
    }
}