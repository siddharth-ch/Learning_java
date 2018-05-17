
public class StringPermute {
    static int count = 0, count2 = 0, count3 = 0;

    public static void main(String args[]) {
	permuteString("", "ABC");
	System.out.println(count + " : " + count2 + " : " + count3);
    }

    public static void permuteString(String prefix, String endingString) {
	++count;
	if (endingString.length() <= 1)
	    System.out.println(prefix + endingString);
	else
	    for (int i = 0; i < endingString.length(); i++) {
		++count2;
		System.out.println("i: " + i + " beg: " + prefix + " end: " + endingString);
		try {
		    String newString = endingString.substring(0, i) + endingString.substring(i + 1);
		    ++count3;
		    System.out.println("New String " + endingString.substring(0, i) + " + "
			    + endingString.substring(i + 1) + "  to " + newString);
		    permuteString(prefix + endingString.charAt(i), newString);
		    System.out.println("Returned  from " + prefix + endingString.charAt(i) + newString);
		} catch (StringIndexOutOfBoundsException exception) {
		    exception.printStackTrace();
		}
	    }
    }

}