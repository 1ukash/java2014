package ru.spbstu.telematics.lecture7;

import java.util.Date;
import java.util.Random;

public class Launcher {
	private static final int DELAY = 3000;

	public static void main(String[] args) {
		final RendezvousObject rendezvous = new RendezvousObject();
		
		new Thread(new Runnable() { //Reader
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
					
					System.out.println("Read " + rendezvous.getObject());
				}
			}
		}).start();
		new Thread(new Runnable() { //Writer
			Random r = new Random();
			@Override
			public void run() {
				while (!Thread.interrupted()) {
					Date obj = new Date();
					System.out.println("Wrote " + obj);
					rendezvous.publishObject(obj);
					try {
						Thread.sleep(r.nextInt(DELAY));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					obj = new Date();
					System.out.println("Wrote " + obj);
					rendezvous.publishObject(obj);
				}
			}
		}).start();

	}
}
