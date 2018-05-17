package algorithms.sorting;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
	int[] ar = { 5, 10, 12, 14, 20, 25, 40, 6, 50, 7, 60 };
	/*
	 * 5 10 12 14,20 25,40 6 50, 7 60
	 *
	 */
	buildHeap(ar);
	int sizeOfHeap = ar.length - 1;
	for (int i = sizeOfHeap; i > 0; i--) {
	    swap(ar, 0, i);
	    maxHeapify(ar, 0, --sizeOfHeap);
	}
	System.out.println(Arrays.toString(ar));
    }

    private static void buildHeap(int[] ar) {
	for (int i = (ar.length - 1) / 2; i >= 0; i--) {
	    maxHeapify(ar, i, ar.length);
	}
    }

    private static void maxHeapify(int[] ar, int i, int size) {
	int l = 2 * i + 1;
	int r = 2 * i + 2;
	int max = i;
	if (l < size && ar[l] > ar[i]) {
	    max = l;
	}
	if (r < size && ar[r] > ar[max]) {
	    max = r;
	}
	if (max != i) {
	    swap(ar, max, i);
	    maxHeapify(ar, max, size);
	}
    }

    private static void swap(int[] ar, int max, int i) {
	int temp = ar[i];
	ar[i] = ar[max];
	ar[max] = temp;

    }

}
