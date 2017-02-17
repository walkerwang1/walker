package com.thinkinjava.ch18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {

	private static final int BSIZE = 1024;
	
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("arguments: sourefile destfile");
			System.exit(1);
		}
		
		FileChannel
			in = new FileInputStream("in.txt").getChannel(),
			out = new FileOutputStream("out.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while(in.read(buffer) != -1) {
			buffer.flip();	//prepare for writing
			out.write(buffer);
			buffer.clear();	//prepare for reading
		}
	}
}
