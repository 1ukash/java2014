package ru.spbstu.telematics.lecture9;

import java.nio.charset.Charset;

public class Texts {
	public static void main(String[] args) {
		System.out.println(Charset.defaultCharset().displayName());
		for (String cs : Charset.availableCharsets().keySet()) {
			System.out.println(cs);
		}
	}
}
