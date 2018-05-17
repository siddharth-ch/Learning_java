package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
	int[] arr = { 4, 5, 9, 1, 3, 6, 2, 10 };
	quickSort(arr, 0, arr.length - 1);
	System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
	System.out.println("SORT - > from i:" + low + " to j:" + high);
	int i = low;
	int j = high;
	int pivot = arr[i + (j - i) / 2];
	while (i <= j) {
	    System.out.println("PIVOT-> " + pivot + " ith->" + arr[i] + " jth->" + arr[j]);
	    while (arr[i] <= pivot) {
		i++;
	    }
	    System.out.println("ith- >" + i);
	    while (arr[j] > pivot) {
		j--;
	    }
	    System.out.println("Jth- >" + j);
	    if (i <= j) {
		System.out.println("SWAP ->" + arr[i] + " and " + arr[j]);
		swap(arr, i, j);
		i++;
		j--;
		System.out.println("ARRAY NOW  ->" + Arrays.toString(arr));
	    }
	    System.out.println(arr[i] + " <-> " + arr[j]);

	}
	if (j > low) {
	    quickSort(arr, low, j);
	}
	if (i < high) {
	    quickSort(arr, i, high);
	}

    }

    public static void swap(int[] arr, int a, int b) {
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
    }
}
