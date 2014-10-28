package ru.spbstu.telematics.lecture7;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {
	private int capacity;
	private List<T> elems = new LinkedList<T>();

	public BlockingQueue(int capacity) {
		super();
		this.capacity = capacity;
	}
	
	void put(T el) {
		synchronized (this) {
			while (elems.size() == capacity) {
				try {
					System.out.println(Thread.currentThread().getName() + ": Queue is full. Waiting...");
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			elems.add(el);
			
			notify();
		}
	}
	
	T get() {
		T el = null;
		synchronized (this) {
			while (elems.isEmpty()) {
				try {
					System.out.println(Thread.currentThread().getName() + ": Waiting on empty queue");
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			el = elems.remove(0);
			
			notify();
		}
		return el;
	}
}
