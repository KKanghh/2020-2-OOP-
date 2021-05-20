import java.util.Calendar;
import java.util.GregorianCalendar;

public class Truck extends Car {
	private int weight;
	

	public Truck() {
		super();
		setCompare(2);
		weight = 0;
	}
	
	public void setVolume(int num) throws VolumeException {
		if (num <= 0) throw new VolumeException();
		weight = num;
	}
	
	public String toString() {
		return "트럭    "  + " " + getCarnumber() + " " + getDate();
	}
	
	public int[] calculate(int diff) {
		int cost = 0;
		int temp = diff % 60;
		if (temp != 0) {
			diff += 60 - temp;
		}
			
		//System.out.printf("주차시간은 %d시간 00분입니다.\n", diff / 60);
		if (weight < 5) {
			cost += 2000 * (diff/60);
		}
		else if (weight < 10) {
			cost += 3000 * (diff/60);
		}
		else cost += 4000 * (diff/60);
		
		//System.out.printf("주차요금은 %d원입니다.\n", cost);
		int[] info = new int[2];
		info[0] = diff;
		info[1] = cost;
		return info;
	}
	
}
