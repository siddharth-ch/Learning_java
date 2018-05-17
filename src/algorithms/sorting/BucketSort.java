package algorithms.sorting;
import java.util.Arrays;

/* IMPORTANT: Multiple classes and nested static classes are supported */

//imports for BufferedReader

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class BucketSort {
    public static void sort(int[] a, int maxVal) {
	int[] buckets = new int[maxVal + 1];
	for (int i = 0; i < buckets.length; i++) {
	    buckets[i] = 0;
	}
	for (int i = 0; i < a.length; i++) {
	    buckets[a[i]]++;
	}
	System.out.println(Arrays.toString(buckets));
	int outPos = 0;
	for (int i = 0; i < buckets.length; i++) {
	    for (int j = 0; j < buckets[i]; j++) {
		a[outPos++] = i;
	    }
	}
    }

    public static void main(String[] args) {
	int maxVal = 7;
	int[] data = { 7, 4, 1, 4, 1, 0, 5, 2, 3, 1, 4 };
	System.out.println("Before: " + Arrays.toString(data));
	sort(data, maxVal);
	System.out.println("After: " + Arrays.toString(data));
    }

}
