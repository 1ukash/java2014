package ru.spbstu.telematics.lecture2;

public class Number {
	int num;
	
	public Number(int num) {
		this.num = num;
	}

	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Number) ) {
			return false;
		}
		return num == ((Number) obj).num;
	}
	
	@Override
	public int hashCode() {
		return num;
	}
	
	@Override
	public String toString() {
		return "Number with value " + num;
	}
}
