package prac7_1;

import java.util.*;
import java.io.*;
import java.security.*;

public class SaveKey {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		KeyPair keypair = KeyManager.generateKeyPair();
		PublicKey publicKey = keypair.getPublic();		
		PrivateKey privateKey = keypair.getPrivate();
		
		System.out.println("암호화 알고리즘: " + publicKey.getAlgorithm());
		System.out.println("생성된 공개키 정보: ");
		System.out.println("키의 길이 (bytes): "+ publicKey.getEncoded().length);
		printBytes(publicKey.getEncoded());
		
		System.out.println("생성된 개인키 정보: ");
		System.out.println("키의 길이 (bytes) "+ privateKey.getEncoded().length);
		printBytes(privateKey.getEncoded());
		
		System.out.print("공개키를 저장할 파일 이름: ");
		String filename = sc.nextLine();
		KeyManager.savePublicKey(publicKey, filename);
		
		System.out.print("개인키를 저장할 파일 이름: ");
		filename= sc.nextLine();
		KeyManager.savePrivateKey(privateKey,filename);
	}

	private static void printBytes(byte[] encoded) {
		// TODO Auto-generated method stub
		for(byte b: encoded) {
			System.out.print(String.format("%02X", b)+ "    ");
		}
		System.out.println();
	}
}
