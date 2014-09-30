package ru.spbstu.telematics.lecture2.a;

import java.awt.Color;
import java.util.Date;

public abstract class AbstractCreature implements Creature {
	private Date birhDate = new Date();
	private int age;
	
	public Date getBirhDate() {
		return birhDate;
	}
	
	public void setBirhDate(Date birhDate) {
		this.birhDate = birhDate;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public abstract Color getColor(); 
	
	@Override
	public void live() {
		for (int i = 0; i < 10; i++) {
			doTurn();
		}
		die();
	}

	abstract void doTurn();
	
}
