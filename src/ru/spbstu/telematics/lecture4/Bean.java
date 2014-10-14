package ru.spbstu.telematics.lecture4;

public class Bean {
	int num;
	String name;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bean(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public Bean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private String secretMethod() {
		return "password";
	}

	@Override
	public String toString() {
		return num + " is  " + name;
	}
}
