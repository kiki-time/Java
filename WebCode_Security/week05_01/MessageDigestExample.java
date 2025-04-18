package prac1;

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestExample {
	
	private static final int SHA1_BLOCK_SIZE = 64;
	// 같은 입력값 - 같은 출력값
	// 1글자/1단어 달라질 때 해시값 얼마나 영향 받는가?
	// 데이터가 달라지는 위치는 해시값 위치에 영향?
	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		String plainText = "The Road Not Taken by Robert Frost";
		byte[] data = plainText.getBytes();
		
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
		
		for (int i=0; i < data.length; i+=SHA1_BLOCK_SIZE) {
			byte[] block = Arrays.copyOfRange(data, i, i+SHA1_BLOCK_SIZE);
			messageDigest.update(block);
		}
		
		byte[] messageDigestSHA1 = messageDigest.digest();
		System.out.println("plain text: "+ plainText);
		
		System.out.print("digestedSHA-1 (hex) \n");
		for (byte bytes : messageDigestSHA1) {
			System.out.print(String.format("%02x", bytes) + "\t");
		}
		System.out.println();
		
	}
	
}
