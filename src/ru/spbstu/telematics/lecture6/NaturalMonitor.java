package ru.spbstu.telematics.lecture6;

public class NaturalMonitor {
	private int a;
	private int b;
	private double c;
	public synchronized int getA() {
		return a;
	}
	public synchronized void setA(int a) {
		this.a = a;
	}
	public synchronized int getB() {
		return b;
	}
	public synchronized void setB(int b) {
		this.b = b;
	}
	public synchronized double getC() {
		return c;
	}
	public synchronized void setC(double c) {
		this.c = c;
	}
}
