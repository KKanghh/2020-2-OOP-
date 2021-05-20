public class Pos {
	private int x;
	private int y;
	
	public Pos(int num1,int num2) {
		x = num1;
		y = num2;
	}
	
	public int getx() {
		return x;
	}
	
	public int gety() {
		return y;
	}
	
	public String toString() {
		String temp = "("+x+","+y+")";
		return temp;
	}
}
