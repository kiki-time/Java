package prac10_2;

public class Date implements Cloneable {
	private int y;
	private int m;
	private int d;
	
	public Date(int y, int m, int d) {
		this.y = y;
		this.m = m;
		this.d = d;
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public String toString() {
		return y+ "년 "+ m +"월 "+ d + "일";
	}
	
}
