package com.walkerwang.demo;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.ByteBuffer;

public class Demo01 {
	public static void main(String[] args) {
		System.out.println("demo01 main method");
		
		DataOutputStream dos;
		try {
			File file = new File("d:\text.txt");
			FileOutputStream fos = new FileOutputStream(file, true);
			if (!file.exists()) {
				file.createNewFile();
			}
			String content = "waangkang";
			byte[] bs = content.getBytes();
			fos.write(bs);
			fos.flush();
			fos.close();
			
			InputStream is = new DataInputStream(new FileInputStream(new File("dat.txt")));
			Reader reader;
			DataInputStream dataInputStream;
			DataOutputStream dos2;
			ByteBuffer bggg;
			ByteArrayInputStream byteArrayInputStream;
			System.out.println("");
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

interface A {
	void get();
}

interface B {
	void get();
}

class SubClass implements A,B {

	@Override
	public void get() {
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) {
		System.out.println("subclass main method");
	}
	
}
