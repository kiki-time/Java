package prac03_02;

import java.util.Scanner;

import prac03_02.Game;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		System.out.print("컴퓨터의 입력 : ");
		String comInput = s.next();
		Game com = Game.encode(comInput);
		
		System.out.print("당신의 입력 : ");
		String yourInput = s.next();
		Game user = Game.encode(yourInput);
		
		Score rslt = whoswin(com,user);
		System.out.println(Score.print(rslt));	
		
	}
	static Score whoswin(Game com, Game you) {
	
		
		if(com == Game.ERROR || you == Game.ERROR) return Score.ERROR;
		
		if(com == you) {
			return Score.EQUAL;
		}
		
		Score[][] scoreBoard = {
            {Score.EQUAL, Score.LOSE,  Score.WIN},
            {Score.WIN,   Score.EQUAL, Score.LOSE},
            {Score.LOSE,  Score.WIN,   Score.EQUAL}
        };
	        
	        // 사용자와 컴퓨터의 getCodeNum()을 인덱스로 사용
        return scoreBoard[you.getCodeNum()][com.getCodeNum()];
    }
	
	public enum Score{
		WIN, LOSE, EQUAL, ERROR;
		
		static String print(Score rslt) {
			
			switch(rslt) {
			case WIN:
				return "당신이 이겼습니다.";
			case LOSE:
				return "컴퓨터가 이겼습니다.";
			case EQUAL:
				return "비겼습니다.";
			case ERROR:
				return "ERROR!!";	
			default:
		 		return "error2";
			}
		}
	}
}

