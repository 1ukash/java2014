package ru.spbstu.telematics.lecture7;

import java.util.Date;
import java.util.Random;

public class QueueLauncher {
	protected static final int DELAY = 2000;

	public static void main(String[] args) {
		final BlockingQueue<Date> queue = new BlockingQueue<>(10);
		for (int i = 0; i < 10; i++)
			new Thread(new Runnable() { // Reader
						Random r = new Random();

						@Override
						public void run() {
							while (!Thread.interrupted()) {
								try {
									Thread.sleep(r.nextInt(DELAY));
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								System.out.println("Read " + queue.get());
							}
						}
					}).start();
		for (int i = 0; i < 5; i++)
			new Thread(new Runnable() { // Writer
						Random r = new Random();

						@Override
						public void run() {
							while (!Thread.interrupted()) {
								Date obj = new Date();
								System.out.println("Wrote " + obj);
								queue.put(obj);
								try {
									Thread.sleep(r.nextInt(DELAY));
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}).start();

	}
}
