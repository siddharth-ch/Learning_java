package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    static int[] arr = null;

    public static void main(String[] args) {
	arr = new int[] { 1, 5, 4, 3, 2, 6, 10, 8, 9, 7, 5 };
	System.out.println(Arrays.toString(insertionSort(arr)));
    }

    private static int[] insertionSort(int[] arr) {
	int len = arr.length, j;
	int count = 0;
	for (int i = 1; i < len; i++) {
	    int temp = arr[i];
	    j = i;
	    while (j >= 0 && arr[j - 1] > temp) {// compare thro array with
						 // preious entry
						 // where u find bigger no.
						 // before smaller
		arr[j] = arr[j - 1];// shift right
		--j;
		count++;
	    }
	    arr[j] = temp;
	}
	System.out.println(count);
	return arr;
    }

    public static int[] insertSort2(int[] arr) {
	int len = arr.length;
	for (int i = 1; i < len; i++) {
	    int temp = arr[i];
	    int j = 0;
	    for (j = i; j > 0 && arr[j - 1] > temp; j--)
		arr[j] = arr[j - 1];
	    arr[j] = temp;
	}
	return arr;
    }
}
