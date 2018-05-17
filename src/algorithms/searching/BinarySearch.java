package algorithms.searching;

public class BinarySearch {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] arr = { 1, 2, 3, 5, 6, 7, 8, 9, 10 };
	int i = 9;
	System.out.println(binarySearch(i, arr));
    }

    public static int binarySearch(int i, int[] arr) {
	int curIn, lower = 0, upper = arr.length - 1;
	while (lower <= upper) {
	    curIn = (lower + (upper - lower)) / 2;
	    if (arr[curIn] == i) {
		return curIn;
	    } else if (arr[curIn] > i) {
		upper = curIn - 1;
	    } else {
		lower = curIn + 1;
	    }
	}
	return -1;
    }

}
