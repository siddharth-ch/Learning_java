import java.util.Arrays;

public class RemoveDuplicateArray {

    public static void main(String[] args) {
	int[] arr = { 10, 9, 4, 5, 7, 6, 6, 2, 4, 3, 15, 17, 23, 5, 6, 12 };
	int j = arr.length - 1;
	int i = 0;
	while (i < j) {
	    if (arr[i] % 2 == 0) {
		i++;
	    }

	    if (arr[j] % 2 == 1) {
		j--;
	    }
	    if (arr[i] % 2 != 0 && arr[j] % 2 == 0) {
		System.out.println("SWAPPING idx " + i + " : " + j);
		swap(arr, j, i);
		System.out.println(Arrays.toString(arr));
		i++;
		j--;
	    }

	}

	System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int j, int i) {
	int t = arr[j];
	arr[j] = arr[i];
	arr[i] = t;
    }

}
