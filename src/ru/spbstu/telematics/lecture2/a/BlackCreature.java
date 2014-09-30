package ru.spbstu.telematics.lecture2.a;

import java.awt.Color;

public class BlackCreature extends AbstractCreature {

	@Override
	public Color getColor() {
		return Color.BLACK;
	}

	@Override
	public void die() {
		System.out.println("Im' dead now");
	}

	@Override
	void doTurn() {
		System.out.println("I'm " + getColor() + "!");
	}

}
