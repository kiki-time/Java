package prac7_1;

import java.io.*;
import java.util.*;
import java.security.*;

import javax.crypto.SecretKey;

public class LoadKey {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("공개키를 저장한 파일 이름: ");
		String fileName = sc.nextLine();
		
		PublicKey publicKey = KeyManager.loadPublicKey(fileName);
		System.out.println("암호화 알고리즘: " + publicKey.getAlgorithm());
		System.out.println("복구된 공개키 정보: ");
		System.out.println("키의 길이 (bytes): "+publicKey.getEncoded().length);
		printBytes(publicKey.getEncoded());
		System.out.println();
		
		System.out.print("개인키를 저장한 파일 이름: ");
		fileName = sc.nextLine();
		
		PrivateKey privateKey = KeyManager.loadPrivateKey(fileName);
		System.out.println("암호화 알고리즘: "+ privateKey.getAlgorithm());
		System.out.println("복구된 개인키 정보: ");
		System.out.println("키의 길이 (bytes): "+ privateKey.getEncoded().length);
		printBytes(privateKey.getEncoded());
	}
	private static void printBytes(byte[] encoded) {
		// TODO Auto-generated method stub
		for(byte b: encoded) {
			System.out.print(String.format("%02X", b)+ "    ");
		}
		System.out.println();
	}
}
