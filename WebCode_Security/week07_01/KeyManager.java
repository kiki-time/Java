package prac7_1;

import java.io.*;
import java.security.*;

public class KeyManager {

	public static KeyPair generateKeyPair() {
		KeyPair keypair = null;
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		
			keyPairGen.initialize(1024);
			keypair = keyPairGen.generateKeyPair();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return keypair;
	}
	public static void savePublicKey(PublicKey key, String filename) {
		try(FileOutputStream fos = new FileOutputStream(filename);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(key); // key를 파일에 저장
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void savePrivateKey(PrivateKey key, String filename) {
		try(FileOutputStream fos = new FileOutputStream(filename);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(key); // key를 파일에 저장
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static PublicKey loadPublicKey(String filename) {
		PublicKey publicKey = null;
		try(FileInputStream fis = new FileInputStream(filename);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			publicKey = (PublicKey) ois.readObject();
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return publicKey;
	}
	public static PrivateKey loadPrivateKey(String filename) {
		PrivateKey privateKey = null;
		try(FileInputStream fis = new FileInputStream(filename);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			privateKey = (PrivateKey) ois.readObject();
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return privateKey;
		
	}
}
