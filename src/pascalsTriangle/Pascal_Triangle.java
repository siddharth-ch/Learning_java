/**
 * 
 */
package pascalsTriangle;

/**
 * @author Siddharth 1 1 1 1 2 1 1 3 3 1 1 4 6 4 1 1 5 10 10 5 1
 */
public class Pascal_Triangle {

	void getNum(int n) {
		int[][] temp = new int[n][n];
		temp[0][0] = 1;
		int y = 0;
		for (int i = 1; i < n; i++) {

			temp[i][0] = 1;
			for (y = 1; y < i; y++) {
				temp[i][y] = temp[i - 1][y] + temp[i - 1][y - 1];
			}
			temp[i][y] = 1;
		}
		for (int i = 0; i < temp.length; i++) {
			int[] integers = temp[i];
			for (int j = 0; j < integers.length; j++) {
				int integer = integers[j];
				if (integer != 0) {
					System.out.print(" ");
					System.out.print(integer);
				}

			}
			System.out.println();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pascal_Triangle().getNum(5);
	}

}
