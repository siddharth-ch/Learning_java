package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 9, 1, 3, 6, 2, 9 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;

			mergeSort(arr, low, mid);
			System.out.println(Arrays.toString(arr));
			mergeSort(arr, mid + 1, high);
			doMergeParts(arr, low, mid, high);
		}
	}

	private static void doMergeParts(int[] arr, int low, int mid, int high) {

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
		System.out.println("After left merge" + Arrays.toString(temp));
	}
}
