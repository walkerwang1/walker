package com.walkerwang.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class IODemo01 extends ArrayList<String>{

	public static String read(String fileName) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(
					new File(fileName).getAbsoluteFile()));
			String s;
			while((s = in.readLine()) != null) {
				sb.append(s);
				sb.append("\n");
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public  static void write(String fileName, String text) {
		try {
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsoluteFile());
			out.print(text);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public IODemo01(String fileName, String splitter) {
		super(Arrays.asList(read(fileName).split(splitter)));
		if (get(0).equals(" ")) {
			remove(0);
		}
	}
	
	public IODemo01(String fileName) {
		this(fileName, "\n");
	}
	
	public void write(String fileName) {
		PrintWriter out;
		try {
			out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				for(String item : this) {
					out.println(item);
				}
			} finally {
				out.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
