package prac01;

import java.io.*;
import java.security.*;
import java.util.*;

public class VerificationMode {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		final String keyAlgorithm = "RSA";
		final String signAlgorithm = "SHA1withRSA";

		String data = "Software security of Dongduk University";
		byte[] dataBytes = data.getBytes("UTF-8");
		
		System.out.println("서명에 사용할 데이터 : "+ data);
		
		System.out.print("공개키 파일 이름: ");
		String pubKeyFile = sc.nextLine();
		PublicKey publicKey = loadPublicKey(pubKeyFile);
		
		System.out.print("전자서명 파일 이름 : ");
		String sigFilename = sc.nextLine();
		byte[] signature = loadSignature(sigFilename);

		Signature sig = Signature.getInstance(signAlgorithm);
		sig.initVerify(publicKey);
		sig.update(dataBytes);
		
		System.out.println("입력된 서명 정보: " + signature.length + "bytes");
		for(byte b : signature) {
			System.out.printf("%02X    ", b);
		}
		System.out.println();
		
		boolean rslt = sig.verify(signature);
		System.out.println("서명 검증 결과 : "+ rslt);
		
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
	private static byte[] loadSignature(String filename) {
		try(FileInputStream fis = new FileInputStream(filename)){
			return fis.readAllBytes();
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
