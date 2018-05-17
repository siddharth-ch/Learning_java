package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    static int[] arr = null;

    public static void main(String[] args) {
	arr = new int[] { 123, 453, 24, 435, 3543, 1, 3, 5 };
	System.out.println(Arrays.toString(selectionSort(arr)));
    }

    private static int[] selectionSort(int[] arr) {
	int len = arr.length;
	System.out.println(Arrays.toString(arr));
	int count = 0;
	for (int i = 0; i < arr.length; i++) {
	    int min = arr[i];
	    int k = i;
	    for (int j = i + 1; j < arr.length; j++) {
		if (arr[j] < min) {
		    min = arr[j];
		    k = j;
		    count++;
		}
	    }
	    swap(k, i);
	    System.out.println(Arrays.toString(arr));
	}
	System.out.println(count);
	return arr;
    }

    public static void swap(int a, int b) {
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
    }
}
