package algorithms.sorting;

import java.util.Arrays;

public class MergeSort_Iterative {

    public static void main(String[] args) {
	int[] arr = { 1, 10, 5, 6, 14, 16, 21, 17, 31, 42 };
	/*
	 * 1,10.. 1 10,5 6, 14 16,21 17,31 42
	 *
	 * 1 10 5 6, 14 16,21 17 , 31 42
	 *
	 * 1 10 5 6 14 16,21 17 ,31 42
	 *
	 *
	 *
	 */
	System.out.println(Arrays.toString(arr));
	int low = 0, mid = 0, high = 0;
	for (int i = 1; i < arr.length / 2 - 1; i++) {
	    for (int j = 0; j < arr.length; j += i * 2) {
		low = j;
		high = Math.min(j + 2 * i - 1, arr.length - 1);
		mid = (j + high) / 2;
		mergeSort(arr, low, mid, high);
	    }
	}
	System.out.println(Arrays.toString(arr));

    }

    private static void mergeSort(int[] arr, int low, int mid, int high) {
	System.out.println("low: " + low + " mid: " + mid + " high: " + high);
	int temp[] = new int[arr.length];
	for (int i = 0; i < arr.length; i++) {
	    temp[i] = arr[i];
	}
	int i = low;
	int j = mid + 1;
	int k = low;

	while (i <= mid && j <= high) {
	    if (temp[i] <= temp[j]) {
		arr[k] = temp[i];
		i++;
	    } else {
		arr[k] = temp[j];
		j++;
	    }
	    k++;
	}
	System.out.println("After merge" + Arrays.toString(arr));
	while (i <= mid) {
	    arr[k] = temp[i];
	    k++;
	    i++;
	}
	while (j <= high) {
	    arr[k] = temp[j];
	    k++;
	    j++;
	}
	temp = null;
	// int i, j, k;
	// int n1 = mid - low + 1;
	// int n2 = high - mid;
	// System.out.println("low: " + low + " mid: " + mid + " high: " + high);
	// /* create temp arrays */
	// int[] L = new int[n1];
	// int R[] = new int[n2];
	//
	// /* Copy data to temp arrays L[] and R[] */
	// for (i = 0; i < n1; i++)
	// L[i] = arr[low + i];
	// for (j = 0; j < n2; j++)
	// R[j] = arr[mid + 1 + j];
	//
	// /* Merge the temp arrays back into arr[l..r] */
	// i = 0;
	// j = 0;
	// k = low;
	// while (i < n1 && j < n2) {
	// if (L[i] <= R[j]) {
	// arr[k] = L[i];
	// i++;
	// } else {
	// arr[k] = R[j];
	// j++;
	// }
	// k++;
	// }
	//
	// /* Copy the remaining elements of L[], if there are any */
	// while (i < n1) {
	// arr[k] = L[i];
	// i++;
	// k++;
	// }
	//
	// /* Copy the remaining elements of R[], if there are any */
	// while (j < n2) {
	// arr[k] = R[j];
	// j++;
	// k++;
	// }

    }
}
