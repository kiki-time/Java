package prac6_1;
import java.io.*;
import java.util.*;
import java.security.Key;
import javax.crypto.*;

public class LoadMode {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("비밀키를 저장한 파일 이름: ");
			String fileName = sc.nextLine();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
			Key secretKey = (SecretKey) ois.readObject();
			ois.close();
			
			System.out.println("암호화 알고리즘: " + secretKey.getAlgorithm());
			System.out.println("키의 길이 (bytes): "+secretKey.getEncoded().length);
			printBytes(secretKey.getEncoded());
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}catch(ClassNotFoundException e) {
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
