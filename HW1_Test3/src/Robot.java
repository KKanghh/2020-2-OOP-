public class Robot {
	private Pos position = new Pos(0, 0);
	private String name;
	private Board board;
	private static final Pos[] robotmove = new Pos[4];
	static		
	{
			robotmove[0] = new Pos(0, 1);
			robotmove[1] = new Pos(1, 0);
			robotmove[2] = new Pos(0, -1);
			robotmove[3] = new Pos(-1, 0);
	}
	private int dir = 0;
	private static int count = 0;
	
	public Robot(Board b, String name) {
		board = b;
		this.name = name;
		setPos(position);
		count++;
	}
	
	public Robot(Board b, String name, Pos p) {
		board = b;
		this.name = name;
		setPos(p);
		position = p;
		count++;
	}
	
	public String getName() {
		return name;
	}
	public Pos getPos() {
		Pos temp = new Pos(position.getx(), position.gety());
		return temp;
	}
	
	public void setPos(Pos p) {
		int x = p.getx(), y = p.gety();
		if (x >= board.getsize() || y >= board.getsize() || x < 0 || y < 0) {
			System.out.println("보드의 바깥입니다.");
			return;
		}
		else if (board.gete(p.getx(), p.gety()) == 0) {
			board.removerobot(position);
			position = p;
			board.boardchange(p);
		}
		else {
			System.out.println("이미 로봇이 위치해있습니다.");
		}
	}
	
	public int getsize() {
		return board.getsize();
	}
	
	public void setDir(int n) {
		while(n < 0) {
			n += 4;
		}
		dir = n % 4;
	}
	
	public void move(int num) {
		Pos temp;
		int x = position.getx();
		int y = position.gety();
		for (int i = 0; i < num; i++) {
			x += robotmove[dir].getx();
			y += robotmove[dir].gety();
			if (x >= board.getsize() || y >= board.getsize() || x < 0 || y < 0) {
				System.out.println("이동할 수 없습니다.");
				return;
			}
			else if (board.gete(x, y) == 1) {
				System.out.println("경로에 로봇이 위치해 있습니다.");
				return;
			}
		}
		temp = new Pos(x, y);
		setPos(temp);
		
	}
	
	public void turnRight() {
		dir = (dir + 1) % 4;
	}
	
	public void turnLeft() {
		dir = dir - 1;
		if (dir < 0) {
			dir += 4;
		}
	}
	
	public void traverse() {
		setDir(1);
		board.removerobot(position);
		Board originalboard = board;
		Board tempboard = new Board(board.getsize());
		board = tempboard;
		Pos tempPos = new Pos(0,0);
		setPos(tempPos);
		System.out.printf("%s\n", getPos());
		for (int i = 0; i < getsize(); i++) {
			for (int j = 0; j < getsize() - 1; j++) {
				move(1);
				System.out.printf("%s\n", getPos());
			}
			int x = position.getx();
			int y = position.gety();
			if (y == getsize() - 1) {
				board = originalboard;
				setPos(position);
				return;
			}
			if (x == 0) {
				turnRight();
				move(1);
				System.out.printf("%s\n", getPos());
				turnRight();
			}
			else if (x == getsize() - 1) {
				turnLeft();
				move(1);
				System.out.printf("%s\n", getPos());
				turnLeft();
			}
		}
	}

	public static int count() {
		return count;
	}
	
	public boolean meetrobot() {
		int x, y;
		Pos p = getPos();
		x = p.getx() + robotmove[dir].getx();
		y = p.gety() + robotmove[dir].gety();
		if (board.gete(x, y) == 1) {
			return true;
		}
		else return false;
	}
}
