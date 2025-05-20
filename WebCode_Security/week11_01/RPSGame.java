package week11_01;

import java.util.Scanner;

public class RPSGame {
	public static String getInput(Scanner sc) throws InvalidInputException{
		System.out.print("당신의 입력: ");
		String input = sc.next();
		
		if(!input.equals("가위") && !input.equals("바위") && !input.equals("보")) {
			throw new InvalidInputException("잘못된 입력입니다.");
		}
		return input;
	}
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
}
