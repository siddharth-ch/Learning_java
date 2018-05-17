import java.util.Arrays;

public class ArrayMaxSubArray1s {

    static int max = 0;

    static int maxi = 0;
    static int maxj = 0;
    static int count = 0;

    public static void main(String[] args) {
	int[][] ar = new int[][] { //
		{ 0, 1, 1, 0, 1 }, //
		{ 1, 1, 1, 1, 1 }, //
		{ 0, 1, 1, 1, 1 }, //
		{ 1, 1, 1, 1, 1 }, //
		{ 1, 1, 1, 1, 1 }, //
		{ 0, 1, 1, 1, 1 }//
	};
	int[][] sum = new int[ar.length][ar[0].length];
	for (int i = 0; i < ar.length - 1; i++) {
	    for (int j = 0; j < ar[i].length - 1; j++) {
		checkNeb(ar, i, j, sum);
	    }
	}
	System.out.println(maxi + " : " + maxj + " size: " + max);
    }

    /**
     * 0,0 0,1 0,2 // 1,0 1,1 1,2 // 2,0 2,1 2,2//
     */
    private static void checkNeb(int[][] ar, int i, int j, int[][] sum) {
	boolean flag = true;
	if (ar[i][j] == 1 && sum[i][j] == 0) {
	    sum[i][j] = 1;
	}
	if (j + 1 < ar[i].length && ar[i][j + 1] == 1) {
	    if (sum[i][j + 1] == 0) {
		sum[i][j + 1] = 1;
	    }
	}
	if (i + 1 < ar.length && ar[i + 1][j] == 1) {
	    if (sum[i + 1][j] == 0) {
		sum[i + 1][j] = 1;
	    }
	}
	if (i + 1 < ar.length && j + 1 < ar[i].length && ar[i + 1][j + 1] == 1) {

	    sum[i + 1][j + 1] = Math.min(sum[i][j + 1], Math.min(sum[i][j], sum[i + 1][j])) + 1;
	    // if (sum[i + 1][j + 1] >= max
	    // && (sum[i + 1][j + 1] == sum[i][j + 1] + 1 || sum[i + 1][j + 1] == sum[i +
	    // 1][j] + 1)) {
	    if (sum[i + 1][j + 1] >= max) {
		max = sum[i + 1][j + 1];
		maxi = i + 1;
		maxj = j + 1;
	    }
	    // }
	}
	System.out.println(Arrays.deepToString(sum) + " : " + ++count);
    }

}
