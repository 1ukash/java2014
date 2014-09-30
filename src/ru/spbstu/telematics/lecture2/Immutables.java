package ru.spbstu.telematics.lecture2;

public class Immutables {
	public static void main(String[] args) {
		String s = "abcd";
		foo(s);
		System.out.println(s);
		
		String s2 = "a";
		String s3 = "a";
		System.out.println(s2.equals(s3));
	}
	
	static void foo(String s) {
		s = s + "!";
	}
}
