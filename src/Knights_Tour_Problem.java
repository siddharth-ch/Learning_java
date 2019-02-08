import java.util.Arrays;

public class Knights_Tour_Problem {

	public static void main(String[] args) {
		int knights = 4;
		knightsTour(knights, 5);
	}

	private static void knightsTour(int knights, int k) {

		for (int start = 0; start < k; start++) {
			int[][] arr = new int[k][k];
			if (knightsT(knights, arr, start)) {
				System.out.println(Arrays.deepToString(arr));
			} else {
				System.out.println("Unable to place all");
			}
		}
	}

	private static boolean knightsT(int k, int[][] arr, int start) {
		int[] row = new int[] { 1, -1, 1, -1, 0, 1, 0, -1 };
		int[] col = new int[] { 1, -1, -1, 1, 1, 0, -1, 0 };
		if (k == 0)
			return true;
		for (int i = start; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 1) {
					if (safe(arr, row, col, i, j)) {
						arr[i][j] = 1;
						if (knightsT(k - 1, arr, start)) {
							return true;
						} else {
							arr[i][j] = 0;
						}
					}
				}
			}
		}
		return false;

	}

	private static boolean safe(int[][] arr, int[] row, int[] col, int i, int j) {
		for (int j2 = 0; j2 < col.length; j2++) {
			int r = i + row[j2];
			int c = j + col[j2];
			if (r < arr.length && r >= 0 && c < arr.length && c >= 0 && arr[r][c] == 1) {
				return false;
			}
		}

		return true;
	}

}
