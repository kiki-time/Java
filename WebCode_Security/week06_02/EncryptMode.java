package prac6_2;
import java.io.*;
import java.util.Scanner;

import javax.crypto.*;
public class EncryptMode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			// 비밀키 준비
			System.out.print("비밀키 파일: " );
			String keyFile = sc.nextLine();
			
			System.out.print("데이터 파일 이름: ");
			String plainFile = sc.nextLine();
			
			System.out.print("암호화 출력 파일: ");
			String encryptedFile = sc.nextLine();
			
			KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(128);
			SecretKey secretKey = keyGen.generateKey();
			
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(keyFile))){
				oos.writeObject(secretKey);
			}catch(IOException e) {
				e.printStackTrace();
				return;
			}
			// Cipher 객체 생성
			Cipher c1 = Cipher.getInstance("AES/ECB/PKCS5Padding");
			c1.init(Cipher.ENCRYPT_MODE, secretKey);
			
			try(FileInputStream fis = new FileInputStream(plainFile);
					FileOutputStream fos = new FileOutputStream(encryptedFile);
					CipherOutputStream cos = new CipherOutputStream(fos, c1)){
				byte[] buf = new byte[16];
				int bytesRead;
				
				while((bytesRead = fis.read(buf)) != -1) {
					cos.write(buf, 0, bytesRead);
				}
				cos.flush();
			}catch(IOException e) {
				e.printStackTrace();
				return;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
