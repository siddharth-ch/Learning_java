package concurrency;

public class PrintOddEvenInOrder_Yield {

    /**
     * @param args
     */
    public static void main(String[] args) {
	even.setPriority(Thread.MAX_PRIORITY);
	even.start();
	odd.setPriority(Thread.MIN_PRIORITY);
	odd.start();

    }

    private static Thread odd = new Thread() {

	@Override
	public void run() {
	    int i = 1;
	    do {
		System.out.println(i);
		i += 2;
		yield();
	    } while (i < 10);
	}
    };

    private static Thread even = new Thread() {

	@Override
	public void run() {
	    int i = 0;
	    do {
		System.out.println(i);
		i += 2;
		yield();
	    } while (i < 10);
	}
    };
}