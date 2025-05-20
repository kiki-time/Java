package week11_02;

import java.util.Random;
import java.util.Scanner;

import week11_02.RPSGameV1;
import week11_02.RPSGameV2;
import week11_02.RPSGameV3;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] rps = {"가위", "바위", "보" };
		Random rand = new Random();
		String com = rps[rand.nextInt(3)];
		
		System.out.println("컴퓨터의 생성: " + com);
		
		// 1. whoswin() pre-condition으로 체크
//		String you = RPSGameV1.getInput(sc);
//		int result = RPSGameV1.whoswin(com, you);
		
		// 2. getInput() 반환 직전 post-condition으로 체크
//		String you = RPSGameV2.getInput(sc);
//		int result = RPSGameV2.whoswin(com, you);
		
		// 3. getInput() 반환 값에 대한 post-condition으로 체크 
		String you = RPSGameV3.getInput(sc);
		assert you.equals("가위") || you.equals("바위") || you.equals("보") : "Invalid input to main()";
		int result = RPSGameV3.whoswin(com, you);
 		
		
		
		switch(result) {
			case 1 :
				System.out.println("당신이 이겼습니다.");
				break;
			case 0 :
				System.out.println("비겼습니다.");
				break;
			case -1 :
				System.out.println("당신이 졌습니다.");
				break;
		}
	}

}
