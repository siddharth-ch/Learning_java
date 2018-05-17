import java.util.Scanner;

public class SquareRootDemo {

    public static void main(String[] args) {
	System.out.print("Enter the number: ");
	// Number for which square root is to be found
	double number = new Scanner(System.in).nextInt();
	double guess = number / 2;
	// This method finds out the square root
	System.out.println(findSquareRoot(number, guess));

    }

    /*
     * This method finds out the square root without using any built-in functions
     * and displays it
     */
    public static double findSquareRoot(double number, double guess) {
	if (closeEnough(number / guess, guess)) {
	    return guess;
	} else {
	    return findSquareRoot(number, newGuess(number, guess));
	}

    }

    private static double newGuess(double number, double guess) {
	guess = (guess + (number / guess)) / 2;
	return guess;
    }

    private static boolean closeEnough(double d, double guess) {
	if (Math.abs(d - guess) <= Math.abs(0.00000000000001))
	    return true;
	return false;
    }
}