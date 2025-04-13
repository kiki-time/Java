package prac6_2;

import java.io.*;
import java.util.*;
import javax.crypto.*;
import java.security.*;

public class DecryptMode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			// 파일 이름 입력
			System.out.print("비밀키 파일: ");
			String keyFile = sc.nextLine();
			
			System.out.print("암호 파일: ");
			String encryptedFile = sc.nextLine();
			
			// 저장된 비밀키 파일 -> secretKey 복원
			SecretKey secretKey = null;
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(keyFile))){
				Object obj = ois.readObject();
				if(obj instanceof SecretKey) {
					secretKey = (SecretKey) obj;
				}else {
					System.err.println();
					return;
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			// Cipher 객체 생성 및 복호화 모드로 초기화
			Cipher c2 = Cipher.getInstance("AES/ECB/PKCS5Padding");
			c2.init(Cipher.DECRYPT_MODE, secretKey);
			
			// 암호문 파일을 읽고 복호화
			String decrypted = new String();
			
			try(FileInputStream bis = new FileInputStream(encryptedFile);
					CipherInputStream cis = new CipherInputStream(bis, c2);
					Scanner scan = new Scanner(cis)){
				while(scan.hasNext()) {
					decrypted += scan.nextLine();
					decrypted+="\n";
				}
			}catch(IOException e) {
				e.printStackTrace();
				return;
			}
			
			System.out.println("복호화 결과: ");
			System.out.println(decrypted.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
	}
}
