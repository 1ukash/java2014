package ru.spbstu.telematics.lecture5;

public class SeparateThread implements Runnable {

	private int a = 1;
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			changeA(1);
			System.out.println(Thread.currentThread().getName() + ": " + a);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
			if (a > 50)
				break;
		}
	}
	
	public void changeA(int byWhat) {
		a += byWhat;
		System.out.println("changed by " + Thread.currentThread().getName() + ": " + a);
	}

}
