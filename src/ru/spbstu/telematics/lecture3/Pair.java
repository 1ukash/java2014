package ru.spbstu.telematics.lecture3;

public class Pair<K1, K2 extends Comparable<K2>> {
	K1 obj1;
	K2 obj2;
	
	public K1 getObj1() {
		return obj1;
	}
	public void setObj1(K1 obj1) {
		this.obj1 = obj1;
	}
	public K2 getObj2() {
		return obj2;
	}
	public void setObj2(K2 obj2) {
		this.obj2 = obj2;
	}
	
	
}
