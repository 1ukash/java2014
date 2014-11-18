package ru.spbstu.telematics.lecture9;

import java.io.Serializable;

public class TestObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5643151635332376834L;
	long id;
	int idInDb;
	String name;
	int num;
	
	transient Object resource;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIdInDb() {
		return idInDb;
	}

	public void setIdInDb(int idInDb) {
		this.idInDb = idInDb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TestObject(long id, int idInDb, String name, int num) {
		super();
		this.id = id;
		this.idInDb = idInDb;
		this.name = name;
		this.num = num;
	}

	public TestObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return getName() + " " +  getId() + " " + getIdInDb();
	}
}
