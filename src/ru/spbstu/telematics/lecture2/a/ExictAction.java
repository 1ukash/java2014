package ru.spbstu.telematics.lecture2.a;

import java.awt.Point;

public class ExictAction implements Action {

	@Override
	public void doClick(Point c) {
		System.exit(1);
	}

}
