package ru.spbstu.telematics.lecture6;

import java.util.Random;

public class Bank {
	private Account a = new Account(50);
	private Account b = new Account(50);

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
		new Bank().start();
	}

	private void start() {
		new Thread(new BankProcess()).start();
		new Thread(new BankProcess()).start();
	}

	private void print() {
		System.out.println("a = " + a.getAmount() + ", b=" + b.getAmount()
				+ ", sum=" + (a.getAmount() + b.getAmount()));
	}

	private synchronized void transfer(Account buyer, Account seller, int val) {
		if (buyer.canBuy(val)) {
			buyer.buy(val);
			seller.sell(val);
		}
	}

}
