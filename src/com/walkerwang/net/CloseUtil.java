package com.walkerwang.net;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {

	public static void closeAll(Closeable... io) {
		for (Closeable tmp : io) {
			try {
				tmp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
