package ru.spbstu.telematics.lecture10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class LocalClient {
	public static void main(String[] args) throws Exception, IOException {
		Socket s = new Socket("localhost", 10000);
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		DataInputStream dis = new DataInputStream(is);
		
		os.write(("Hello! " + new Date()).getBytes());
		
		os.flush();
		Thread.sleep(1000);
		s.close();
		
	}
}
