package prac2;

import java.util.*;

public class CompareHash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Scanner sc = new Scanner(System.in)){
			System.out.print("입력 파일 이름 : ");
			String inputFname = sc.nextLine();
			
			byte[] hash = HashManager.calcHashVal(inputFname);
			System.out.println("계산된 해시값");
			HashManager.printBytes(hash);
			
			System.out.print("저장된 해시값 파일 이름 : ");
			String hashFile = sc.nextLine();
			
			byte[] savedHash = HashManager.readHashVal(hashFile);
			boolean result = HashManager.compareHashVal(hash, savedHash);
			System.out.println("비교 결과 : " + result);
		}catch (Exception e) {
			System.err.println("CompareHash 오류");
		}
	}

}
