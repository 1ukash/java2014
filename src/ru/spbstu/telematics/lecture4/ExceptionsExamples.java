package ru.spbstu.telematics.lecture4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsExamples {
	public static void main(String[] args) {
		try {
			willThrowIO();
		} catch (MyException e1) {
			e1.printStackTrace();
		}
		
		try {
			willSendExceptionUP();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		willNotThrowNPE(null);
		
		willThrowNPE();
	}

	private static void willNotThrowNPE(Object ref) {
		try {
			ref.toString();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage() + ": ");
			// will never happen
		}
		// TODO Auto-generated method stub
		
	}

	private static void willSendExceptionUP() throws FileNotFoundException {
		File f = new File("/root/notexists");
		FileInputStream fis = null;
		fis = new FileInputStream(f);
		System.out.println("after file open");
		
	}

	private static void willThrowIO() throws MyException {
		File f = new File("/root/notexists");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			System.out.println("after file open");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyException(e);
		} finally {
			System.out.println("The end");
		}
//		try {
//			fis.read();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	private static void willThrowNPE() {
		Object withError = null;
		withError.hashCode();
	}
}
