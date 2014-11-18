package ru.spbstu.telematics.lecture8;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank2 {
	private Account2 a = new Account2(50);
	private Account2 b = new Account2(50);

	Lock lock = new ReentrantLock();

	private class BankProcess implements Runnable {
		Random r = new Random();

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				int val = r.nextInt(10);

				if (r.nextBoolean()) {
					transfer(a, b, val);
				} else {
					transfer(b, a, val);
				}
				print();
			}
		}

	}

	public static void main(String[] args) {
		new Bank2().start();
	}

	private void start() {
		new Thread(new BankProcess()).start();
		new Thread(new BankProcess()).start();
	}

	private void print() {
		System.out.println("a = " + a.getAmount() + ", b=" + b.getAmount()
				+ ", sum=" + (a.getAmount() + b.getAmount()));
	}

	private void transfer(Account2 buyer, Account2 seller, int val) {

		while (lock.tryLock()) {
			try {
				if (buyer.canBuy(val)) {
					buyer.buy(val);
					seller.sell(val);
				}
			} finally {
				lock.unlock();
			}
		}
	}

}
