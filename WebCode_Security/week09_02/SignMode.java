package prac02;

import java.util.*;
import java.io.*;
import java.security.*;

public class SignMode {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String keyAlgorithm = "RSA";
		String signAlgorithm = "SHA256withRSA";
		
		KeyManager keyPair = KeyManager.getInstance(1024);
		keyPair.createKeys();
		PrivateKey privateKey = keyPair.getPrivateKey();
		PublicKey publicKey = keyPair.getPublicKey();
		
		System.out.print("데이터 파일 이름: ");
		String filename = sc.nextLine();
		byte[] data = loadFile(filename);
		
		System.out.print("개인키 파일 이름: ");
		String priKeyName = sc.nextLine();
		savePrivateKey(privateKey, priKeyName);
		savePublicKey(publicKey, "public.key");
		
		Signature sig = Signature.getInstance(signAlgorithm);
		sig.initSign(keyPair.getPrivateKey());
		sig.update(data);
		byte[] signature = sig.sign();
		
		System.out.println("생성된 서명 정보: "+ signature.length + "bytes");
		for(byte b: signature) {
			System.out.print(String.format("%02X    ", b));
		}
		System.out.println();
		
		System.out.print("서명을 저장할 파일 이름 : " );
		String sigFilename = sc.nextLine();
		saveSig(signature, sigFilename);
		
		sc.close();
	}
	
	private static byte[] loadFile(String filename) {
		try(FileInputStream fis = new FileInputStream(filename)){
			return fis.readAllBytes();
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	private static void savePublicKey(PublicKey key, String filename) {
		try(FileOutputStream fos = new FileOutputStream(filename);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(key); // key를 파일에 저장
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	private static void savePrivateKey(PrivateKey key, String filename) {
		try(FileOutputStream fos = new FileOutputStream(filename);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(key); // key를 파일에 저장
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	private static void saveSig(byte[] data, String filename) {
		try (FileOutputStream fos = new FileOutputStream(filename)){
			fos.write(data);
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("서명을 파일에 저장했습니다.");
	}
}
