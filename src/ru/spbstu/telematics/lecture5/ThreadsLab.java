package ru.spbstu.telematics.lecture5;

public class ThreadsLab {
	public static void main(String[] args) {
		
		SeparateThread st = new SeparateThread();
		Thread t = new Thread(st);
//		t.setDaemon(true);
		t.start();
//		st.run();
		int a = 1;
		a ++;
		st.changeA(10);
		System.out.println(a);
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.getName() + " is terminated");
		
	}
}
