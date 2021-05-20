import java.awt.*;
import javax.swing.*;

public class ParkingManager {
	public static void main(String[] args) {
		EventQueue.invokeLater(() ->
		{
		ParkingFrame frame = new ParkingFrame();
		frame.setTitle("주차장 관리 프로그램");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		});
	}
}

