package com.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * 自定义文件类加载器
 */
public class FileSystemClassLoader extends ClassLoader {

	private String rootDir;		//文件位置
	
	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		
		Class<?> c = findLoadedClass(name);   //检查类是否已经被加载过
		if(c != null) {
			return c;	//若已经加载则直接返回
		}else {
			ClassLoader parent = null;
			try {
				parent = this.getParent();	//获取父类加载器
			} catch (Exception e) {
				e.printStackTrace();
			}
			c = parent.loadClass(name);		//委派给父类加载
			if(c != null) {
				return c;
			} else {
				byte[] classData = getClassData(name);	//父类无法加载则调用自己的类加载器
				if(classData == null) {
					throw new ClassNotFoundException();
				}else {
					c = defineClass(name, classData, 0, classData.length);
				}
			}
		}
		return c;
	}
	
	/**
	 * 自己的加载类信息
	 * @param className
	 * @return
	 */
	public byte[] getClassData(String className) {
		//把包格式“com.walkerwang.***.class”转化成目录格式“com/walkerwang/***.class”
		String path = rootDir + "/" + className.replace('.', '/') + ".class";
		FileInputStream is = null;	//输入流
		ByteArrayOutputStream baos = new ByteArrayOutputStream();	//字节数组输出流
		try {
			is = new FileInputStream(path);		//把文件封装成输入流
			byte[] buff = new byte[1024];
			int tmp = 0;
			while((tmp = is.read(buff)) != 0) {		//不断读取文件流
				baos.write(buff, 0, tmp);	//写入到输出流中
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
