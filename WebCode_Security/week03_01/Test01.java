package prac03_01;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s= new Scanner(System.in);
		
		System.out.print("컴퓨터의 입력 : ");
		String comInput = s.next();
		Game com = Game.encode(comInput);
		
		System.out.print("당신의 입력 : ");
		String yourInput = s.next();
		Game user = Game.encode(yourInput);
		
		Score rslt = Score.whoswin(com, user);
		
		if(rslt==Score.WIN) {
			System.out.println("당신이 이겼습니다.");
		}else if(rslt == Score.LOSE) {
			System.out.println("컴퓨터가 이겼습니다.");
		}else if(rslt == Score.EQUAL){
			System.out.println("비겼습니다.");
		}else {
			System.out.println("ERROR!!");
		}
	}

	public enum Score {
		WIN, LOSE, EQUAL, ERROR;

		static Score whoswin(Game com, Game you) {
			if(com == Game.ERROR || you == Game.ERROR) return ERROR;
			
			if(com == you) {
				return EQUAL;
			}else if(com == Game.ROCK){
				if(you==Game.PAPER) {
					return WIN;
				}else {
					return LOSE;
				}
			}else if(com == Game.SCISSORS) {
				if(you==Game.PAPER) {
					return LOSE;
				}else {
					return WIN;
				}
			}else if(com == Game.PAPER) {
				if(you==Game.ROCK) {
					return LOSE;
				}else {
					return WIN;
				}
			}
			
			return ERROR;
		}
	}


}
