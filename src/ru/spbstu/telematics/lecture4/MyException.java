package ru.spbstu.telematics.lecture4;

import java.io.FileNotFoundException;

public class MyException extends Exception {

	public MyException(FileNotFoundException e) {
		super(e);
	}

}
