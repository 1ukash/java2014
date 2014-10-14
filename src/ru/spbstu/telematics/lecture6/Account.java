package ru.spbstu.telematics.lecture6;

public class Account {
	private int amount = 0;

	public Account(int initialMoney) {
		amount = initialMoney;
	}

	public boolean canBuy(int value) {
		return amount >= value;
	}
	
	public void buy(int value) {
		amount -= value;
	}
	
	public void sell(int value) {
		amount += value;
	}

	public int getAmount() {
		return amount;
	}
}
