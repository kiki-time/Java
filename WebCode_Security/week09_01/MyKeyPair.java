package prac01;

import java.security.*;

public class MyKeyPair {
	private static final String keyAlgorithm = "RSA";
	
	private KeyPairGenerator keyGen;
	private KeyPair pair;
	
	private PrivateKey privateKey;
	private PublicKey publicKey;

	public static MyKeyPair getInstance(int keyLength) 
			throws NoSuchAlgorithmException, NoSuchProviderException{
		MyKeyPair rslt = new MyKeyPair();
		
		rslt.keyGen = KeyPairGenerator.getInstance(keyAlgorithm);
		rslt.keyGen.initialize(keyLength);
		
		return rslt;
	}	
	public void createKeys() {
		this.pair = this.keyGen.generateKeyPair();
		this.privateKey = pair.getPrivate();
		this.publicKey = pair.getPublic();
	}
	
	public PrivateKey getPrivateKey() {
		return this.privateKey;
	}
	public PublicKey getPublicKey() {
		return this.publicKey;
	}

}
