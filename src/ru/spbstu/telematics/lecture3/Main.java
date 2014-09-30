package ru.spbstu.telematics.lecture3;

public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneExample c = new CloneExample(1, new Object(), "a string");
		System.out.println(c);
		CloneExample c2 = (CloneExample) c.clone();
		System.out.println(c2);
	}
}
