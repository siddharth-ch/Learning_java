import java.util.HashSet;

public class FindLongestSubstringLength {

    public static void main(String[] args) {
	String s = "aabchgdabcfe";

	System.out.println(findLongestSubstring(s));
    }

    private static int findLongestSubstring(String s) {
	HashSet<Character> cset = new HashSet<Character>();
	char[] chars = s.toCharArray();
	int j = 1, length = 0, maxL = 0;
	char prev = 0;
	for (int i = 0; i < chars.length; i++) {
	    System.out.println("Selecting char :" + chars[i]);
	    j = i + 1;
	    length = 1;
	    cset.add(chars[i]);
	    if (chars[i] != prev) {
		while (j < chars.length) {
		    if (cset.contains(chars[j])) {
			cset.clear();
			break;
		    } else {
			cset.add(chars[j]);
			length++;
			j++;
		    }
		}
		System.out.println("Length found from char: " + chars[i] + " as " + length);
		if (length > maxL) {
		    maxL = length;
		    length = 0;
		}
	    }
	}
	return maxL;
    }
}
