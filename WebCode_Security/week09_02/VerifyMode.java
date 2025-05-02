package prac02;

import java.util.*;
import java.io.*;
import java.security.*;

public class VerifyMode {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		final String keyAlgorithm = "RSA";
		final String signAlgorithm = "SHA256withRSA";
		
		System.out.print("데이터 파일 이름 : ");
		String filename = sc.nextLine();
		byte[] data = loadFile(filename);
		
		System.out.print("공개키 파일 이름: ");
		String pubKeyName = sc.nextLine();
		PublicKey publicKey = loadPublicKey(pubKeyName);
		
		System.out.print("전자서명 파일 이름 : ");
		String sigFilename = sc.nextLine();
		byte[] signature = loadFile(sigFilename);
		
		Signature sig = Signature.getInstance(signAlgorithm);
		sig.initVerify(publicKey);
		sig.update(data);
		
		System.out.println("입력된 서명 정보: "+ signature.length + "bytes");
		for(byte b : signature) {
			System.out.printf("%02X    ", b);
		}
		System.out.println();
		
		boolean rslt = sig.verify(signature);
		System.out.println("서명 검증 결과:"+ rslt);
		
		sc.close();
		
	}

	private static PublicKey loadPublicKey(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			return (PublicKey) ois.readObject();
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	private static byte[] loadFile(String filename) {
		try(FileInputStream fis = new FileInputStream(filename)){
			return fis.readAllBytes();
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
