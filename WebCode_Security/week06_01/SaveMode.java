package prac6_1;

import java.io.*;
import java.util.*;
import javax.crypto.*;
import java.security.*;

public class SaveMode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			
			KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(128);
			
			Key secretKey = keyGen.generateKey();
			
			System.out.println("암호화 알고리즘: "+secretKey.getAlgorithm());
			System.out.println("키의 길이 (bytes): "+secretKey.getEncoded().length);
			printBytes(secretKey.getEncoded());
			
			System.out.print("비밀키를 저장할 파일 이름: ");
			String fileName = sc.nextLine();
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(secretKey);
			oos.close();
			
			System.out.println("비밀키가 파일에 저장되었습니다.");
		}catch(NoSuchAlgorithmException e) {
			System.err.println(e.getMessage());
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}finally {
			sc.close();
		}	
	}

	private static void printBytes(byte[] b) {
		for (byte val: b) {
			System.out.print(String.format("%02X", val)+"   ");
		}
		System.out.println();
	}
}
