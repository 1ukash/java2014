package ru.spbstu.telematics.lecture8;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RendezvousObjectWithLock {
	private volatile Date exchangeObject;
	
	private ReentrantLock lock = new ReentrantLock(true);
	private Condition cond = lock.newCondition();
	
	void publishObject(Date obj) {
		
		lock.lock();
		try {
			exchangeObject = obj;
			cond.signal();
			try {
				cond.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		} finally {
			lock.unlock();
		}
		
	}
	
	Date getObjedct() {
		Date res = null;
		lock.lock();
		try {
			while (exchangeObject == null) {
				try {
					cond.await();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			} 
			res = exchangeObject;
			exchangeObject = null;
			cond.signal();
		} finally {
			lock.unlock();
		}
		
		return res;
	}
	
}
