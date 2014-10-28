package ru.spbstu.telematics.lecture7;

import java.util.Date;

public class RendezvousObject {
	private Date exchangeObject;
	
	void publishObject(Date obj) {
		
		synchronized (this) {
			exchangeObject = obj;
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
		
	}
	
	Date getObject() {
		Date res = null;
		
		synchronized (this) {
			while (exchangeObject == null) {
				try {
					wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			} 
			res = exchangeObject;
			exchangeObject = null;
			notify();
		}
		
		return res;
	}
	
}
