package week11_02;

import java.util.Scanner;

public class RPSGameV3 {
	public static int whoswin(String com, String you) {		
		if(com.equals(you)) {
			return 0;
		}
		
		if((com.equals("가위") && you.equals("바위")) ||
				(com.equals("바위") && you.equals("보")) || 
				(com.equals("보") && you.equals("가위"))) {
			return 1;
		}else {
			return -1;
		}
	}
	
	public static String getInput(Scanner sc) {
		System.out.print("당신의 입력: ");
		String input = sc.next();
		return input;
	}
}
