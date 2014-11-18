package ru.spbstu.telematics.lecture9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Streams {
	
	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream(new File("/tmp/test.gzip"));
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(os)));
//		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));
		
		Random r = new Random();
		
		for (int i = 0; i< 1000000; i++) {
			dos.writeInt(r.nextInt(10));
		}
		
//		byte[] bytes = "Hello!\n".getBytes();
//		os.write(bytes);
		dos.flush();
		dos.close();
		
		InputStream is = new FileInputStream(new File("/tmp/test.gzip"));
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new GZIPInputStream(is)));
//		DataInputStream dis = new DataInputStream(new BufferedInputStream(is));
		
		for (int i = 0; i < 1000000; i++) {
			if (i % 10000 == 0)
			  System.out.println(dis.readInt());
		}
		
		dis.close();
		
//		bytes = new byte[is.available()];
//		is.read(bytes);
		
//		System.out.println(new String(bytes));
	}

}
