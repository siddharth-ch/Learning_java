
public class SubSet_SUM {

    public static void main(String[] args) {
	int[] ar = { 1, 5, 2, 6, 7 };
	int[] solution = new int[ar.length];
	subsetSum(ar, 0, 0, 7, solution);
    }

    private static void subsetSum(int[] ar, int i, int sum, int target, int solution[]) {
	if (target == sum) {
	    System.out.print("[");
	    for (int j = 0; j < solution.length; j++) {
		if (solution[j] == 1) {
		    System.out.print("  " + ar[j]);
		}
	    }
	    System.out.print("]");
	    System.out.println();
	    return;
	} else if (sum > target) {
	    System.out.println("Exceeding sum : " + "index :" + i);
	    return;
	}
	if (i == ar.length)
	    return;
	solution[i] = 1;
	System.out.println("BEFORE sum : " + (sum + ar[i]) + " index " + i);
	subsetSum(ar, i + 1, sum + ar[i], target, solution);
	System.out.println("AFTER sum : " + sum + " next index " + i);
	solution[i] = 0;
	subsetSum(ar, i + 1, sum, target, solution);

    }

}
