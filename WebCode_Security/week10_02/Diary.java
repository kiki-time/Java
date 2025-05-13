package prac10_2;

public class Diary implements Cloneable{
	private Date[] listOfDates;
	
	public Diary(Date[] listOfDates) {
		this.listOfDates = listOfDates;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Diary d = (Diary)super.clone();
		d.listOfDates = new Date[3];
		d.listOfDates[0] = (Date)this.listOfDates[0].clone();
		d.listOfDates[1] = (Date)this.listOfDates[1].clone();
		d.listOfDates[2] = (Date)this.listOfDates[2].clone();

		return d;
	}
	public String toString() {
		return "{ " + listOfDates[0] +", "+listOfDates[1] +", "+listOfDates[2] + " }";
	}
	public Date[] getListOfDates() {
		return listOfDates;
	}
}
