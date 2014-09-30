package ru.spbstu.telematics.lecture3;

public class CloneExample implements Cloneable {
	private int a;
	private Object b;
	private String c;
	
	public CloneExample() {
		super();
	}

	public CloneExample(int a, Object b, String c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public String toString() {
		return "a = " + a + ", b =" + b + ", c=" + c;
	}
	
	@Override
	protected CloneExample clone() throws CloneNotSupportedException {
		
		CloneExample c2 = new CloneExample(a, new Object(), c);
		
		return c2;
	}
	
}
