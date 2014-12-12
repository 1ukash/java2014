package ru.spbstu.telematics.lecture10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {
	public static void main(String[] args) throws UnknownHostException, IOException, Exception {
		
		InetAddress[] addr = InetAddress.getAllByName("ya.ru");
		
		for (InetAddress a: addr)
		  System.out.println(a);
		
		Socket s = new Socket(addr[0], 80);
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		DataInputStream dis = new DataInputStream(is);
		
		dos.writeUTF("GET / HTTP/1.1");
		dos.writeUTF("\n");
		dos.writeUTF("\n");
		
		dos.flush();
		
		while( !(dis.available() > 0) )
			Thread.sleep(100);
		System.out.println(dis.available());
		
		byte[] data = new byte[dis.available()];
		is.read(data);
		
		String reply = new String(data);
		
		System.out.println(reply);
		
		s.close();
	}
}
