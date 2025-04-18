package prac7_2;

import prac7_1.KeyManager;
import java.security.*;
import java.util.*;


public class EncryptMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("암호화 키 파일: "); // prac7_1에서 만든 public.key, private.key
			String encryptedKeyFile = sc.nextLine();
			System.out.print("데이터 파일 이름: "); // 평문 파일
			String dataFile = sc.nextLine();
			System.out.print("암호데이터 출력 파일: "); // 암호화된 내용을 저장할 파일명
			String outputFile = sc.nextLine();
			
			// 기밀성
//			PublicKey publicKey = KeyManager.loadPublicKey(encryptedKeyFile);
//			Encryptor.encrypt(dataFile, outputFile, publicKey);
			
			// 부인방지
			PrivateKey privateKey = KeyManager.loadPrivateKey(encryptedKeyFile);
			Encryptor.encryptPrivateKey(dataFile, outputFile, privateKey);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
