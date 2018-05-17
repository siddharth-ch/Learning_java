package concurrency;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer_Consumer_Fast {

	public static void main(String[] args) throws IOException {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		Producer p = new Producer(queue);
		File f = new File("ABC.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final ConcurrentLinkedQueue<String> l2 = new ConcurrentLinkedQueue<String>();
		Consumer c = new Consumer(queue, l2);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
		ExecutorService es = Executors.newCachedThreadPool();
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(new File("ABC.txt"), true);
			while (!l2.isEmpty()) {
				es.execute(new Process(l2.poll(), fileWriter));
			}
			es.shutdown();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (!es.isTerminated()) {
			System.out.println("NT shutdown");
		}
		System.out.println("DONE");
		fileWriter.close();
	}
}

class Process implements Runnable {
	private String l = null;
	private FileWriter fileWriter = null;

	public Process(String l, FileWriter fileWriter) {
		this.l = l;
		this.fileWriter = fileWriter;
	}

	@Override
	public void run() {
		BufferedWriter out = null;
		try {
			synchronized (fileWriter) {
				out = new BufferedWriter(fileWriter);
				out.append(l);
				out.newLine();
				out.flush();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Producer implements Runnable {

	private final BlockingQueue<String> queue;

	Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				queue.put("ABC " + i);
				System.out.println("Produced :" + "ABC " + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {

	private final BlockingQueue<String> queue;

	private final ConcurrentLinkedQueue<String> list;
	public AtomicInteger count = new AtomicInteger(0);

	Consumer(BlockingQueue<String> queue, ConcurrentLinkedQueue<String> l2) {
		this.queue = queue;
		this.list = l2;
	}

	@Override
	public void run() {
		while (count.intValue() != 100) {
			try {
				final String x = queue.take();
				System.out.println("Consumed :" + x);
				list.add(x);
				count.getAndIncrement();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
