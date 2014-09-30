package ru.spbstu.telematics.lecture2.a;

public class PojoExample {
	private int counter;
	private String name;
	
	public PojoExample(int counter, String name) {
		super();
		this.counter = counter;
		this.name = name;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
