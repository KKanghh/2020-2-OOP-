public class Test3 {
	public static void main(String[] args) {
		int N = 5;
		Board board = new Board(N);
		Robot rb1 = new Robot(board, "Kiro", new Pos(1,2));
		Robot rb2 = new Robot(board, "Miro");
		int count = Robot.count();
		System.out.println("# of Robots: " +count);
		
		rb2.move(2);
		rb2.turnRight();
		rb2.move(1);
		System.out.printf("%s in %s & %s in %s\n", rb1.getName(), rb1.getPos(), rb2.getName(), rb2.getPos());
		rb1.turnLeft();
		rb1.turnLeft();
		rb1.move(3);
		rb1.move(2);
		System.out.printf("%s in %s\n", rb1.getName(), rb1.getPos());
		rb2.move(2);
		System.out.printf("%s in %s\n", rb2.getName(), rb2.getPos());
		rb1.traverse();
		System.out.printf("%s in %s\n", rb1.getName(), rb1.getPos());
		rb1.setPos(new Pos(1,0));
		traverse2(rb1);
		System.out.printf("%s in %s\n", rb1.getName(), rb1.getPos());

	}
	
	public static void traverse2(Robot rb) {
		Pos p = rb.getPos();
		if (p.getx() % 2 == 1) {
			rb.setDir(1);
		}
		else rb.setDir(3);
		System.out.println(rb.getPos());
		while(p.getx() < rb.getsize() - 1 && p.getx() > 0) {
			if (rb.meetrobot()) {
				return;
			}
			rb.move(1);
			System.out.println(rb.getPos());
			p = rb.getPos();
		}
		if ( p.getx() == 0) {
			rb.turnRight();
			if (rb.meetrobot()) {
				return;
			}
			rb.move(1);
			System.out.printf("%s\n", rb.getPos());
			rb.turnRight();
		}
		else if (p.getx() == rb.getsize() - 1) {
			rb.turnLeft();
			if (rb.meetrobot()) {
				return;
			}
			rb.move(1);
			System.out.printf("%s\n", rb.getPos());
			rb.turnLeft();
		}
		for (int i = 0; i < rb.getsize(); i++) {
			for (int j = 0; j < rb.getsize() - 1; j++) {
				if (rb.meetrobot()) {
					return;
				}
				rb.move(1);
				System.out.printf("%s\n", rb.getPos());
			}
			p = rb.getPos();
			int x = p.getx();
			int y = p.gety();
			if (y == rb.getsize() - 1) {
				return;
			}
			if (x == 0) {
				rb.turnRight();
				if (rb.meetrobot()) {
					return;
				}
				rb.move(1);
				System.out.printf("%s\n", rb.getPos());
				rb.turnRight();
			}
			else if (x == rb.getsize() - 1) {
				rb.turnLeft();
				if (rb.meetrobot()) {
					return;
				}
				rb.move(1);
				System.out.printf("%s\n", rb.getPos());
				rb.turnLeft();
			}
		}
	}
}
