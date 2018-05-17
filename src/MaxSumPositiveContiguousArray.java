/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.*/
//imports for BufferedReader
import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumPositiveContiguousArray {

    public static void main(String args[]) throws Exception {
	MaxSumPositiveContiguousArray test = new MaxSumPositiveContiguousArray();
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.addAll(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));

	for (Integer i :
	// test.rotateArray(list, 7)) {
	test.maxset(list)) {
	    System.out.println(i);
	}
    }

    // contiguos array sum
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	ArrayList<Integer> l = new ArrayList<Integer>();
	long sum = 0, lastsum = 0, maxsum = 0;
	int z = 0, n = 0, lastk = 0, lastj = 0, k = 0, j = 0;
	for (int i = 0; i < a.size(); i++) {

	    if (a.get(i) < 0) {
		lastk = k;
		lastj = j;
		k = i + 1;
		if (sum > 0)
		    lastsum = sum;
		sum = 0;
	    } else {
		sum += a.get(i);
	    }

	    if (sum >= maxsum) {
		z = k;
		n = i;
		j = i;
		maxsum = sum;
	    }

	    if (lastsum == sum && lastj - lastk > j - k) {
		z = lastk;
		n = lastj;
	    }
	}

	for (int m = z; m <= n; m++) {
	    l.add(a.get(m));
	}
	return l;
    }

    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
	ArrayList<Integer> ret = new ArrayList<Integer>();
	for (int i = 0; i < A.size(); i++) {
	    System.out.println(i + " : " + (i + B) + ": " + (i + B) % A.size());
	    ret.add(A.get((i + B) % A.size()));
	}
	return ret;
    }
}
