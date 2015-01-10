package ru.spbstu.telematics.lecture11;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class JustAClient {
	public static void main(String[] args) throws Exception, IOException {
		Socket s = new Socket("localhost", 10000);
		OutputStream os = s.getOutputStream();
		for (int i = 0; i < 100; i ++) {
			byte[] b = {1,2,3,4,5};
			os.write(b);
			os.flush();
			System.out.println("wrote " + i);
			Thread.sleep(5000);
		}
		s.close();
	}
}
