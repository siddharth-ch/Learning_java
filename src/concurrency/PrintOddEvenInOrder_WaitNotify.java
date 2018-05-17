package concurrency;

public class PrintOddEvenInOrder_WaitNotify {

    private static Object obj = new Object();

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
	even.start();
	odd.start();
	// even.join();
	// odd.join();

    }

    private static Thread odd = new Thread() {

	@Override
	public void run() {
	    synchronized (obj) {
		for (int j = 1; j <= 20; j += 2) {
		    System.out.println(j);
		    obj.notify();
		    try {
			obj.wait();
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }

		}
		obj.notify();
	    }
	}
    };

    private static Thread even = new Thread() {

	@Override
	public void run() {
	    synchronized (obj) {
		for (int j = 0; j <= 20; j += 2) {
		    System.out.println(j);
		    obj.notify();
		    try {
			obj.wait();
		    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		    obj.notify();
		}
	    }
	}
    };
}