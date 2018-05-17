public class Sudoku_Solver {
    // Driver code
    public static void main(String[] args) {
	int[][] grid = { //
		{ 3, 0, 6, 5, 0, 8, 4, 0, 0 }, //
		{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, //
		{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, //
		//
		{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, //
		{ 9, 0, 0, 8, 6, 3, 0, 0, 5 }, //
		{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, //
		//
		{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, //
		{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, //
		{ 0, 0, 5, 2, 0, 6, 3, 0, 0 }//
	};
	if (solveSudoku(grid)) {
	    displaySudoku(grid);
	}
    }

    public static void displaySudoku(int[][] grid) {
	for (int i = 0; i < 9; i++) {
	    if (i % 3 == 0 && i != 0) {
		System.out.println("----------------------------------\n");
	    }
	    for (int j = 0; j < 9; j++) {
		if (j % 3 == 0 && j != 0) {
		    System.out.print(" | ");
		}
		System.out.print(" " + grid[i][j] + " ");

	    }

	    System.out.println();
	}
	System.out.println("\n\n__________________________________________\n\n");
    }

    private static boolean solveSudoku(int[][] grid) {
	for (int i = 0; i < grid.length; i++) {
	    for (int j = 0; j < grid.length; j++) {
		if (grid[i][j] == 0) {
		    for (int k = 1; k <= 9; k++) {
			if (canBePlaced(grid, i, j, k)) {
			    grid[i][j] = k;
			    if (solveSudoku(grid)) {
				return true;
			    }
			    grid[i][j] = 0;
			}
		    }
		    return false;
		} else {
		    if (checkSolved(grid)) {
			return true;
		    }
		}

	    }
	}

	return true;
    }

    private static boolean checkSolved(int[][] grid) {
	for (int i = 0; i < grid.length; i++) {
	    for (int j = 0; j < grid[0].length; j++) {
		if (grid[i][j] == 0) {
		    return false;
		}
	    }
	}
	return true;
    }

    static boolean canBePlaced(int[][] grid, int i, int j, int num) {
	// every col on that row
	for (int j2 = 0; j2 < grid.length; j2++) {
	    if (grid[i][j2] == num) {
		return false;
	    }
	}

	// every row on col
	for (int j2 = 0; j2 < grid.length; j2++) {
	    if (grid[j2][j] == num) {
		return false;
	    }
	}
	int m = i - i % 3;
	int n = j - j % 3;
	// grid
	for (int k = m; k < m + 3; k++) {
	    for (int j2 = n; j2 < n + 3; j2++) {
		if (grid[k][j2] == num) {
		    return false;
		}
	    }
	}

	return true;
    }

}