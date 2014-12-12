package ru.spbstu.telematics.lecture10;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer {
	public static void main(String[] args) throws Exception {
		ServerSocket s = new ServerSocket(10000);
		while (true) {
			final Socket income = s.accept();
			
			Thread t = new Thread(new Runnable(){
				
				@Override
				public void run(){
					System.out.println(income);
					
					InputStream is;
					try {
						is = income.getInputStream();
						while (!(is.available() > 0))
							Thread.sleep(100);
						System.out.println(is.available());

						byte[] data = new byte[is.available()];
						is.read(data);
						String reply = new String(data);
						System.out.println("Message from client: " + reply);

						income.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});
			
			t.start();
		}
	}
}
