import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class StringReversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "Hello";
		strRev1(s);
		strRev2(s);

	}

	/**
	 * cusing char array
	 * @param s
	 */
	private static void strRev2(String s) {
		char[] d = new char[s.length()];
		int i=s.length()-1;
		for(char c : s.toCharArray()){
			d[i--]= c;
		}
		System.out.println("Char array :"+new String(d));
	}
	/**
	 * using recursion
	 * @param s
	 */
	private static void strRev1(String s) {
		System.out.println("Recursion :"+recursive(s));
	}
	
	private static String recursive(String s) {
		if(s.length()<=1){
			return s;
		} 
		return recursive(s.substring(1))+s.charAt(0);
	}
	
}
