package prac7_2;
import java.io.*;
import java.security.*;
import javax.crypto.*;

public class Encryptor {

	public static void encrypt(String inputFile, String outputFile, PublicKey publicKey) {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			
			try(FileInputStream fis = new FileInputStream(inputFile);
					FileOutputStream fos = new FileOutputStream(outputFile);
					CipherOutputStream cos = new CipherOutputStream(fos, cipher)){
				
				byte[] buf = new byte[1024];
				int readBuf;
				while((readBuf = fis.read(buf)) != -1) {
					cos.write(buf, 0, readBuf);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
	}
	public static void encryptPrivateKey(String inputFile, String outputFile, PrivateKey privateKey) {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			
			try(FileInputStream fis = new FileInputStream(inputFile);
					FileOutputStream fos = new FileOutputStream(outputFile);
					CipherOutputStream cos = new CipherOutputStream(fos, cipher)){
				
				byte[] buf = new byte[1024];
				int readBuf;
				while((readBuf = fis.read(buf)) != -1) {
					cos.write(buf, 0, readBuf);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
	}
	
}
