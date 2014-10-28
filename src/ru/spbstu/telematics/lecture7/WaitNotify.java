package ru.spbstu.telematics.lecture7;

public class WaitNotify {
	
	private final Object lock = new Object();
	
	class Waiter implements Runnable {

		@Override
		public void run() {
			while(!Thread.interrupted()) {
				System.out.println(Thread.currentThread().getName() + ": Going to sleep");
				synchronized(lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}
				}
				System.out.println(Thread.currentThread().getName() + ": I'm wake up");
			}
		}
		
	}
	
	class Notifier implements Runnable {

		@Override
		public void run() {
			while(!Thread.interrupted()) {
				synchronized (lock) {
					System.out.println(Thread.currentThread().getName() + ": Send signal!");
//					lock.notifyAll();
					lock.notify();
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new WaitNotify().launch();
	}

	private void launch() {
		for (int i = 0; i < 10; i++)
		  new Thread(new Waiter()).start();
		new Thread(new Notifier()).start();
	}
}
