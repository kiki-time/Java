package prac2;

import java.security.MessageDigest;
import java.util.*;
import java.io.*;

public class HashManager {

	public static byte[] calcHashVal(String fname) {

		try (FileInputStream fis = new FileInputStream(fname)) {
			MessageDigest md = MessageDigest.getInstance("SHA-1");

			byte[] buf = new byte[64];
			int readBuf;

			while ((readBuf = fis.read(buf)) != -1) {
				md.update(buf, 0, readBuf);
			}
			return md.digest();
		} catch (Exception e) {
			System.err.println("해시값 계산 오류");
			return null;
		}
	}

	public static void saveBytes(String fname, byte[] b) {
		try (FileOutputStream fos = new FileOutputStream(fname)) {
			fos.write(b);
		} catch (IOException e) {
			System.err.println("해시값 저장 오류");
		}
	}
	
	public static byte[] readHashVal (String fname) {
		byte[] buf = new byte[20];
		try (FileInputStream fis = new FileInputStream(fname)) {
			int read = fis.read(buf);
			if (read != 20) 
				throw new IOException("해시값 길이 검증 오류");
			
			return buf;
		} catch (Exception e) {
			System.err.println("해시값 읽기 오류");
			return null;
		}
	}
	
	public static boolean compareHashVal(byte[] h1, byte[] h2) {
		if (h1.length != h2.length)
			return false;
		for(int i =0; i<h1.length; i++) {
			if (h1[i]!=h2[i]) return false;
		}
		return true;
	}
	
	public static void printBytes(byte[] b) {
		for (byte val: b) {
			System.out.print(String.format("%02X", val)+ "   ");
		}
		System.out.println();
	}
}
