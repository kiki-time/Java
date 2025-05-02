package prac01;

import java.io.*;
import java.security.*;
import java.util.*;

public class SignMode {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String keyAlgorithm = "RSA";
		String signAlgorithm = "SHA1withRSA";

		MyKeyPair keyPair = MyKeyPair.getInstance(1024);
		keyPair.createKeys();
		PrivateKey privateKey = keyPair.getPrivateKey();
		PublicKey publicKey = keyPair.getPublicKey();
		
		String data = "Software security of Dongduk University";
		byte[] dataBytes = data.getBytes("UTF-8");
		
		Signature sig = Signature.getInstance(signAlgorithm);
		sig.initSign(keyPair.getPrivateKey());
		sig.update(dataBytes);
		byte[] signature = sig.sign();
		
		System.out.println("서명에 사용할 데이터 : "+ data);
		
		System.out.print("개인키 파일 이름: ");
		String priKeyFile = sc.nextLine();
		savePrivateKey(privateKey, priKeyFile);
		
		savePublicKey(publicKey, "public.key");
		
		System.out.println("생성된 서명 정보: " + signature.length + "bytes");
		for(byte b: signature) {
			System.out.print(String.format("%02X", b)+ "    ");
		}
		System.out.println();
		
		System.out.print("서명을 저장할 파일 이름 : ");
		String sigFilename = sc.nextLine();
		saveSig(signature, sigFilename);
		
		sc.close();
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
