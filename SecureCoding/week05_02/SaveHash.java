package prac2;

import java.util.*;
/*import java.security.MessageDigest;*/
import java.security.NoSuchAlgorithmException;

public class SaveHash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("입력 파일 이름 : ");
			String inputFname = sc.nextLine();
			
			byte[] hash = HashManager.calcHashVal(inputFname);
			System.out.println("계산된 해시값");
			HashManager.printBytes(hash);
			
			System.out.print("해시값을 저장할 파일이름 : ");
			String hashFile = sc.nextLine();
			
			HashManager.saveBytes(hashFile, hash);
		}catch(Exception e) {
			System.err.println("SaveHash 오류");
		}
		
	}
	
}
