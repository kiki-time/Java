package week11_01;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] rps = {"가위", "바위", "보" };
		Random rand = new Random();
		
		String you;
		String com = rps[rand.nextInt(3)];
		
		System.out.println("컴퓨터의 생성: " + com);
		
		try {
			you = RPSGame.getInput(sc);
			int result = RPSGame.whoswin(com, you);
			
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
		}catch(InvalidInputException e) {
			System.out.println(e.getMessage());
		}
	}
}
