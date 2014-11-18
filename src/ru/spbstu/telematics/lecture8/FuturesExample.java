package ru.spbstu.telematics.lecture8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturesExample {
	ExecutorService service = Executors.newFixedThreadPool(10);
	int[][] arr = new int[10][1000000];

	public static void main(String[] args) throws InterruptedException {
		FuturesExample instance = new FuturesExample();
		instance.generate();
		instance.calculate();
	}

	private long calculate() throws InterruptedException {
		long t1 = System.currentTimeMillis();
		List<Future<Long>> calcs = new ArrayList<>();
		for (int k = 0; k < arr.length; k++) {
			final int idx = k;
			Future<Long> future = service.submit(new Callable<Long>() {

				@Override
				public Long call() throws Exception {
					long sum = 0;
					Thread.sleep(new Random().nextInt(5000));
					for (int l : arr[idx]) {
						sum += l;
					}
					System.out.println("summ[arr[k]]=" + sum);
					return sum;
				}
			});
			calcs.add(future);
		}

		long sum = 0;
		Set<Future<Long>> processed = new HashSet<>();
		while (processed.size() < 10) {
			for (Future<Long> f : calcs) {
				if (f.isDone() && ! processed.contains(f)) {
					try {
						Long res = f.get();
						System.out.println("Got " + res);
						sum += res;
						processed.add(f);
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println("Result is " + sum);

		System.out.println("calc:" + (System.currentTimeMillis() - t1));
		return 0;
	}

	private void generate() {
		long t1 = System.currentTimeMillis();

		Random r = new Random();
		for (int j = 0; j < arr.length; j++)
			for (int i = 0; i < arr[j].length; i++) {
				arr[j][i] = r.nextInt();
			}

		System.out.println("gen " + (System.currentTimeMillis() - t1));
	}

}
