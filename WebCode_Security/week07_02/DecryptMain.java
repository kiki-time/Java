package prac7_2;
import prac7_1.KeyManager;

import java.security.*;
import java.util.*;


public class DecryptMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("복호화 키 파일: "); // prac7_1에서 만든 public.key, private.key
			String decryptedKeyFile = sc.nextLine();
			System.out.print("암호데이터 파일: "); // 암호화된 내용을 저장할 파일명
			String outputFile = sc.nextLine();

			// 부인방지
			PublicKey publicKey = KeyManager.loadPublicKey(decryptedKeyFile);
			Decryptor.decryptedPublicKey(outputFile, publicKey);
			
			
			// 기밀성
//			PrivateKey privateKey = KeyManager.loadPrivateKey(decryptedKeyFile);
//			Decryptor.decrypt(outputFile, privateKey);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
