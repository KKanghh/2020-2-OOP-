public class Board {
	private int[][] board;
	private int size;
	
	public Board(int x) {
		board = new int[x][x];
		size = x;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				board[i][j] = 0;
			}
		}
	}
	public int gete(int x, int y) {
		return board[x][y];
	}
	
	public int getsize() {
		return size;
	}
	
	public void boardchange(Pos p) {
		board[p.getx()][p.gety()] = 1;
	}
	
	public void removerobot(Pos p) {
		board[p.getx()][p.gety()] = 0;
	}
	
}
