import java.util.Calendar;
import java.util.GregorianCalendar;

public class Bus extends Car {
	private int seater;

	public Bus() {
		super();
		setCompare(1);
		seater = 0;
	}
	
	public void setVolume(int num) throws VolumeException {
		if (num <= 0) throw new VolumeException();
		seater = num;
	}

	public String toString() {
		return "버스    "  + " " + getCarnumber() + " " + getDate();
	}
	
	public int[] calculate(int diff) {
		int cost = 0;
		if (diff < 60) {
			diff = 60;
			//System.out.println("주차시간은 1시간 00분입니다.");
		}
		else {
			int temp;
			diff -= 60;
			temp = diff % 30;
			if (temp != 0) {
				diff += 60 + (30 - temp);
			}
			else diff += 60;
			//System.out.printf("주차시간은 %d시간 %d분입니다.\n", diff/60, diff%60);
		}
		
		int dif = diff;
		
		if (seater < 24) {
			diff -= 60;
			cost += 2000;
			while (diff !=0) {
				diff -= 30;
				cost += 1000;
			}
		}
		else if (seater < 40) {
			diff -= 60;
			cost += 3000;
			while (diff !=0) {
				diff -= 30;
				cost += 1500;
			}
		}
		else {
			diff -= 60;
			cost += 4000;
			while (diff !=0) {
				diff -= 30;
				cost += 2000;
			}
		}
		
		//System.out.printf("주차요금은 %d원입니다.\n", cost);
		int[] info = new int[2];
		info[0] = dif;
		info[1] = cost;
		return info;
	}
}
