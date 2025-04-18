package prac7_2;

import java.io.*;
import java.security.*;
import javax.crypto.*;
import java.util.*;

public class Decryptor {

	public static void decrypt(String inputFile, PrivateKey privateKey) {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			try(FileInputStream fis = new FileInputStream(inputFile);
					CipherInputStream cis = new CipherInputStream(fis, cipher);
					Scanner sc =new Scanner(cis)){
				
				String decrypted = new String();
				
				while(sc.hasNext()) {
					decrypted += sc.nextLine();
					decrypted += "\n";
				}
				System.out.println(decrypted);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InvalidKeyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}
	public static void decryptedPublicKey(String inputFile, PublicKey publicKey) {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			try(FileInputStream fis = new FileInputStream(inputFile);
					CipherInputStream cis = new CipherInputStream(fis, cipher);
					Scanner sc =new Scanner(cis)){
				
				String decrypted = new String();
				
				while(sc.hasNext()) {
					decrypted += sc.nextLine();
					decrypted += "\n";
				}
				System.out.println(decrypted);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InvalidKeyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
}
