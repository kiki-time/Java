package prac10_1;

public class Diary implements Cloneable{

	private Date[] listOfDates;
	
	public Diary(Date[] listOfDates) {
		this.listOfDates = listOfDates;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	public String toString() {
		return "{ "+listOfDates[0]+ ", " + listOfDates[1]+ ", "+ listOfDates[2]+" }";
	}
	
	public Date[] getListOfDates() {
		return listOfDates;
	}
}
