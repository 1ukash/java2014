package ru.spbstu.telematics.lecture2;

public class HashcodeExample {
	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
		
		System.out.println(o1 == o2);
		System.out.println(o1.equals(o2));
		
		Number n1 = new Number(1);
		Number n2 = new Number(1);
		
		System.out.println(n1.equals(n2));
		System.out.println(n1.hashCode() == n2.hashCode());
		System.out.println(n1);
	}
}
