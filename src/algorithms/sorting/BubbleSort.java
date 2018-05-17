package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {
	static int[] arr = null;

	public static void main(String[] args) {
		arr = new int[] { 123, 453, 24, 435, 3543, 1, 3, 5 };
		System.out.println(Arrays.toString(bubbleSort(arr)));
	}

	public static int[] bubbleSort(int[] arr) {
		int min, len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[i]) {
					swap(i, j);
				}
			}
		}
		return arr;
	}

	public static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
