import java.util.Calendar;
import java.util.GregorianCalendar;

public class Car implements Comparable<Car> {
	private Date in;
	private int carnumber;
	private int battery;
	private int compare;
	
	public Car() {
		in = null;
		carnumber = 0;
		battery = 0;
		compare = 0;
	}
	
	public void setVolume(int num) throws VolumeException {
		if (num < 0 || num > 60) throw new VolumeException();
		battery = num;
	}
	
	public void setCompare(int comp) {
		compare = comp;
	}
	
	public void setDate(Date date) {
		in = date;
	}
	
	public void setCarnumber(int num) throws CarnumberException{
		if (num < 1000 || num > 9999) throw new CarnumberException();
		carnumber = num;
	}
		
	public Date getDate(){
		Date temp = new Date(in.getYear(), in.getMonth(), in.getDay(), in.getHour(), in.getMinute());
		return temp;
	}
	
	public int getCarnumber() {
		return carnumber;
	}
	@Override
	public int compareTo(Car other) {
		if (compare != other.compare) {
			return Integer.compare(compare, other.compare);
		}
		
		Date com = other.getDate();
		if (Integer.compare(in.getYear(), com.getYear()) == 0) {
			if (Integer.compare(in.getMonth(), com.getMonth()) == 0) {
				if (Integer.compare(in.getDay(), com.getDay()) == 0) {
					if (Integer.compare(in.getHour(), com.getHour()) == 0) {
						return Integer.compare(in.getMinute(), com.getMinute());
					}
					else return Integer.compare(in.getHour(),  com.getHour());
				}
				else return Integer.compare(in.getDay(), com.getDay());
			}
			else return Integer.compare(in.getMonth(), com.getMonth());
		}
		else return Integer.compare(in.getYear(), com.getYear());
	}
	
	public String toString() {
		return "승용차 " + " " + carnumber + " " + in; 
	}
	
	public int[] calculate(int diff) {
		int cost = 0;
		if (battery != 0) {
			int charge = 0;
			while (battery + 0.2 * charge < 60 && charge < diff) {
				charge++;
			}
			cost += charge * 60;
		}
		if (diff <= 30) {
			//System.out.printf("주차시간은 30분입니다.\n");
			cost += 1000;
			diff = 30;
		}
		else {
			diff -= 30;
			int temp = diff % 10;
			if (temp != 0) {
				diff += 30 + (10 - temp);
			}
			else diff += 30;
			if (diff < 60) {
				//System.out.printf("주차시간은 %d분입니다.\n",diff);
			}
			else //System.out.printf("주차시간은 %d시간 %d분입니다.\n", diff/60, diff%60);
			cost += 1000 + 500 * ((diff - 30) / 10);
		}
		
		int[] info = new int[2];
		info[0] = diff;
		info[1] = cost;
		return info;
	}
}
