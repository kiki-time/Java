package prac03_01;

public enum Game{
	ROCK, PAPER, SCISSORS, ERROR;
	
	public static Game encode(String str) {
		if (str.equals("바위")) {
			return ROCK;
		}else if (str.equals("가위")) {
			return SCISSORS;
		}else if (str.equals("보")) {
			return PAPER;
		}else return ERROR;
	}
}