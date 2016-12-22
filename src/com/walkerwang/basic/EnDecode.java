package com.walkerwang.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;

/**
 * 加解密
 * 
 * @author walkerwang
 *
 */
public class EnDecode {

	public static void main(String[] args) {
		
	}
	
	private static final String KEY_DES = "DES";
	private final static String KEY_MD5 = "MD5";
	
	Key key;	//密钥
	
	/**
	 * 文件file进行加密并保存目标文件destFile中
	 * 
	 * @param file	要加密的文件，如d:/srcFile.txt
	 * @param des	加密后存放的文件名
	 */
	public void encrypt(String srcFile, String destFile) throws Exception{
		Cipher cipher = Cipher.getInstance(KEY_DES);
		cipher.init(Cipher.DECRYPT_MODE, this.key);
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		CipherInputStream cis = new CipherInputStream(fis, cipher);
		byte[] buffer = new byte[1024];
		int line;
		while((line = cis.read(buffer)) > 0) {
			fos.write(buffer, 0, line);
		}
		cis.close();
		fos.close();
		fis.close();
	}
	
	/**
	 * 文件采用DES算法解密文件
	 * 
	 * @param srcFile	已加密的文件
	 * @param destFile	//解密后存放的文件名
	 */
	public void decrypt(String srcFile, String destFile) throws Exception {
		Cipher cipher = Cipher.getInstance(KEY_DES);
		cipher.init(cipher.DECRYPT_MODE, this.key);
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		CipherOutputStream cos = new CipherOutputStream(fos, cipher);
		byte[] buffer = new byte[1024];
		int line;
		while((line = fis.read(buffer)) >= 0) {
			cos.write(buffer, 0, line);
		}
		cos.close();
		fos.close();
		fis.close();
	}
	
	/**
	 * 根据参数生成KEY
	 * @param strKey
	 */
	public void getKey(String strKey) {
		try {
			KeyGenerator _generator = KeyGenerator.getInstance("DES");
			_generator.init(new SecureRandom(strKey.getBytes()));
			this.key = _generator.generateKey();
			_generator = null;
		} catch (Exception e) {}
	}
}
