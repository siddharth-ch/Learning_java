package concurrency;

public class PrintOddEvenInOrder_Sleep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		even.start();
		odd.start();

	}

	private static Thread odd = new Thread() {

		@Override
		public void run() {
			int i = 1;
			//synchronized (this) {
				do {
					System.out.println(i);
					i += 2;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (i < 10);
			//}
		}
	};

	private static Thread even = new Thread() {

		@Override
		public void run() {
			int i = 0;
			//synchronized (this) {
				do {
					System.out.println(i);
					i += 2;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (i < 10);
			//}
		}
	};
}