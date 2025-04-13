package prac03_02;

public enum Game {

	ROCK(0), PAPER(1), SCISSORS(2), ERROR(-1);

	private int codeNum;
	
	Game(int num){
		codeNum = num;
	}
	
	static Game encode(String str) {
		if (str.equals("바위")) {
			return ROCK;
		}else if (str.equals("가위")) {
			return SCISSORS;
		}else if (str.equals("보")) {
			return PAPER;
		}else return ERROR;
	}

	public int getCodeNum() {
		return codeNum;
	}
}
