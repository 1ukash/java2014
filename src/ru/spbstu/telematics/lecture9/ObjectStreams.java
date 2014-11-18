package ru.spbstu.telematics.lecture9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ObjectStreams {
	public static void main(String[] args) throws IOException, IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
		FileOutputStream os = new FileOutputStream("/tmp/test.obj");

		Cipher cipher = Cipher.getInstance("AES");
		SecretKeySpec secretKeySpec = new SecretKeySpec("C0C1C2C3C4C5C6C7C8C9CACBCCCDCECF".getBytes(), "AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

		CipherOutputStream cos = new CipherOutputStream(os, cipher);
		ObjectOutputStream oos = new ObjectOutputStream(cos);
		
		TestObject obj = new TestObject(100L, 11, "Test", 22);
		System.out.println("obj : " + obj);
		oos.writeObject(obj);
		oos.close();
		
		Cipher cipher2 = Cipher.getInstance("AES");
		cipher2.init(Cipher.DECRYPT_MODE, secretKeySpec );
		FileInputStream is = new FileInputStream("/tmp/test.obj");
		CipherInputStream cis = new CipherInputStream(is, cipher2);
		ObjectInputStream ois = new ObjectInputStream(cis);
		TestObject obj2= (TestObject) ois.readObject();
		System.out.println("obj2 : " + obj2);
		ois.close();
		
	}
}
