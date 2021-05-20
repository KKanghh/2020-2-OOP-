import java.util.*;

public class Date {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
	public Date(int year, int month, int day, int hour, int minute) throws DateException {
		if (!isValid(year, month, day, hour, minute)) throw new DateException();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}
	
	 public static boolean isValid(int yy, int mm, int dd, int ho, int mi) {
		 if (ho >= 24 || ho < 0) {
			 return false;
		 }
		 if (mi >= 60 || mi < 0){
			 return false;
		 }
		 GregorianCalendar date = new GregorianCalendar(yy, mm, dd);
		 switch (mm) {
		 case 1:
		 case 3:
		 case 5:
		 case 7:
		 case 8:
		 case 10:
		 case 12:
			 if (dd >= 1 && dd <= 31) {
				 return true;
			 }
			 else {
				 return false;
			 }
		 case 4:
		 case 6:
		 case 9:
		 case 11:
			 if (dd >= 1 && dd <= 30) {
				 return true;
			 }
			 else {
				 return false;
			 }
		 case 2:
			 if(date.isLeapYear(yy)) {
				 if (dd >= 1 && dd <= 29) {
					 return true;
				 }
				 else {
					 return false;
				 }
			 }
			 else {
				 if (dd >= 1 && dd <= 28) {
					 return true;
				 }
				 else {
					 return false;
				 }
			 }
		 default :
			return false;
		 }
	 }
	 
	 public int getYear() {
		 return year;
	 }
	 
	 public int getMonth() {
		 return month;
	 }
	 
	 public int getDay() {
		 return day;
	 }
	 
	 public int getHour() {
		 return hour;
	 }
	 
	 public int getMinute() {
		 return minute;
	 }
	 public String toString() {
		 String smonth = Integer.toString(month);
		 String sday = Integer.toString(day);
		 String shour = Integer.toString(hour);
		 String sminute = Integer.toString(minute);
		 if (month < 10) {
			 smonth = "0" + month;
		 }
		 if (day < 10) {
			 sday = "0" + day;
		 }
		 if (hour < 10) {
			 shour = "0" + hour;
		 }
		 if (minute < 10) {
			 sminute = "0" + minute;
		 }
		 return year+"/"+smonth+"/"+sday+" "+shour+":"+sminute;
	 }
	 
	 public static int howlong(Date d1, Date d2) throws OutDateException {
		Calendar in = new GregorianCalendar(d1.getYear(), d1.getMonth(), d1.getDay(), d1.getHour(), d1.getMinute());
		Calendar out = new GregorianCalendar(d2.getYear(), d2.getMonth(), d2.getDay(), d2.getHour(), d2.getMinute());
		if (out.before(in)) throw new OutDateException();
		long diffsec = (out.getTimeInMillis() - in.getTimeInMillis()) / 1000;
		long diffmin = diffsec / 60;
		int diff = Long.valueOf(diffmin).intValue();
		return diff;
	 }

}
