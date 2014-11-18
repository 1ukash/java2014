package ru.spbstu.telematics.lecture8;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class QueueLauncher {
	protected static final int DELAY = 2000;

	public static void main(String[] args) {
		final SynchronousQueue<Date> queue = new SynchronousQueue<>();
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

								try {
									System.out.println("Read " + queue.take());
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
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
								try {
									queue.put(obj);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
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
