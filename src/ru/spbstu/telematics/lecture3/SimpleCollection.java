package ru.spbstu.telematics.lecture3;

import java.util.Iterator;

public class SimpleCollection<T,V> implements Iterable<String> {

	String[] arr = new String[] {"a", "b","c", "d"};
	
	T obj;
	V val;
	
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			int idx = -1;
			@Override
			public boolean hasNext() {
				return idx + 1 < arr.length;
			}

			@Override
			public String next() {
				return arr[++idx];
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
		};
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public V getVal() {
		return val;
	}

	public void setVal(V val) {
		this.val = val;
	}
}
