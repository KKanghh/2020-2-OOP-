import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Parkinglot {
	private ArrayList<Car> parkinglot;
	private int income;
	private int size;
	
	public Parkinglot(int size) {
		parkinglot = new ArrayList<Car>();
		this.size = size;
		income = 0;
	}
	
	public void printCar() {
		if (parkinglot.isEmpty()) {
			System.out.println("�������� ��� �ֽ��ϴ�.");
		}
		Collections.sort(parkinglot);
		for (Car car: parkinglot) {
			System.out.println(car);
		}
	}
	
	public void Entry(Car car) throws DuplicateException {
		for (Car parking: parkinglot) {
			if (parking.getCarnumber() == car.getCarnumber()) {
				throw new DuplicateException();
			}
		}
		parkinglot.add(car);
	}
	
	public void Exit(int num, Date out) throws NoCarException{
		for (Car car: parkinglot) {
			if (num == car.getCarnumber()) {
				Date in = car.getDate();
				int time = Date.howlong(in, out);
				int[] info = car.calculate(time);
				income += info[1];
				parkinglot.remove(car);
				JOptionPane.showMessageDialog(null, "�����ð��� " + info[0]/60 + "�ð� " + info[0]%60 + "�� �Դϴ�.\n��������� " + info[1] + "�� �Դϴ�.", "���� ����", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}
		throw new NoCarException();
	}
	
	public int getIncome() {
		return income;
	}
	
	public boolean isFull() {
		return parkinglot.size() == size;
	}
	
	public boolean isEmpty() {
		return parkinglot.size() == 0;
	}
	
	public void append(JTextArea t) {
		Collections.sort(parkinglot);
		for (Car car: parkinglot) {
			t.append(car.toString() + "\n");
		}
	}
	
}
