package Classes;

public class Date {
	private int day ;
	private int mnth;
	private int year;
	
	public Date(int d ,int m ,int y){
		day = d;
		mnth =m;
		year =y;
	}
	public String showDate(){
		return day+" "+mnth+" "+year;
	}
	
}
