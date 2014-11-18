package ru.spbstu.telematics.lecture8;

public class Account2 {
	private int amount = 0;

	public Account2(int initialMoney) {
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
