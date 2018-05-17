public class StringIndexOf {

	public static void main(String[] args) {
		String s = "AMEIAMSIDDASIAMSIDDHARTHFJDKGJDKIAMSIDDHARTH";
		System.out.println(indexOf("IAMSIDDHARTH".toCharArray(),
				s.toCharArray(), 0, s.length() - 1));
		System.out.println("Actual: " + s.indexOf("IAMSIDDHARTH") + " : "
				+ s.length());
	}

	private static int indexOf(char[] search, char[] cs, int i, int j) {
		int k = 0;
		int m;
		for (m = 0; m < cs.length && k < search.length; m++) {
			if (search[k] == cs[m]) {
				System.out.println(cs[m]);
				if (k + 1 == search.length)
					return m - k;
				k++;
			} else {
				k = 0;
			}
		}

		return -1;
	}
}
