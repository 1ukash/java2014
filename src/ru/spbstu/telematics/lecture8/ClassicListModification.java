package ru.spbstu.telematics.lecture8;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ClassicListModification {
	private static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

	static Executor executor = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		list.add(1);
		list.add(2);
		list.add(3);

		executor.execute(new Runnable() {

			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					list.add(new Random().nextInt());
				}
			}
		});

		while (true) {
			executor.execute(new Runnable() {

				@Override
				public void run() {
					for (Integer i : list) {
						System.out.println(i);
					}
					// TODO Auto-generated method stub

				}
			});
		}
	}
}
