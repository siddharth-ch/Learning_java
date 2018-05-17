public class StringLastIndexOf {

	public static void main(String[] args) {
		String s = "AMEIAMSIDDASIAMSIDDHARTHFJDKGJDKIAMSIDDHARTH";
		System.out.println(indexOf("IAMSIDDHARTH".toCharArray(),
				s.toCharArray()));
		System.out.println("Actual: " + s.lastIndexOf("IAMSIDDHARTH") + " : "
				+ s.length());
	}

	private static int indexOf(char[] search, char[] cs) {
		int k = 0;
		int m;

		int lastIndex = -1;
		for (m = 0; m < cs.length && k < search.length; m++) {
			if (search[k] == cs[m]) {
				System.out.println(cs[m]);
				if (k + 1 == search.length) {
					lastIndex = m - k;
					k = 0;
				}
				k++;
			} else {
				k = 0;
			}
		}

		return lastIndex;
	}
}
