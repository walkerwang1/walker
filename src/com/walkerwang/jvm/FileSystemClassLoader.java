package com.walkerwang.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * 自定义文件类加载器
 */
public class FileSystemClassLoader extends ClassLoader {

	private String rootDir;
	
	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);
		if(c != null) {
			return c;
		}else {
			ClassLoader parent = null;
			try {
				parent = this.getParent();
			} catch (Exception e) {
				e.printStackTrace();
			}
			c = parent.loadClass(name);		//委派给父类加载
			if(c != null) {
				return c;
			} else {
				byte[] classData = getClassData(name);
				if(classData == null) {
					throw new ClassNotFoundException();
				}else {
					c = defineClass(name, classData, 0, classData.length);
				}
			}
		}
		return c;
	}
	
	//自己加载类信息
	public byte[] getClassData(String className) {
		String path = rootDir + "/" + className.replace('.', '/') + ".class";
		FileInputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			is = new FileInputStream(path);
			byte[] buff = new byte[1024];
			int tmp = 0;
			while((tmp = is.read(buff)) != 0) {
				baos.write(buff, 0, tmp);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(is != null){
					is.close();
				}
				if(baos != null) {
					baos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		FileSystemClassLoader loader1 = new FileSystemClassLoader("d:/java");
	}
}
