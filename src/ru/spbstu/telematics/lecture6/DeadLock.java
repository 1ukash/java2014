package ru.spbstu.telematics.lecture6;

import java.util.Date;
import java.util.Random;

public class DeadLock {

	private static int a = 1, b = 1;
	private static Object lockA = new Object(), lockB = new Object();

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				Random r = new Random();
				@Override
				public void run() {
					while(!Thread.currentThread().isInterrupted()) {
						
						if (r.nextBoolean()) {
							synchronized (lockA) {
								a ++;
								synchronized (lockB) {
									b++;
								}
								a += b;
							}
						} else {
							synchronized (lockB) {
								b ++;
								synchronized (lockA) {
									a++;
								}
								b += a;
							}
						}
						System.out.println("alive " + new Date());
					}
				}
			}).start();
		}
	}
}
