import java.awt.*;
import javax.swing.*;

public class ParkingManager {
	public static void main(String[] args) {
		EventQueue.invokeLater(() ->
		{
		ParkingFrame frame = new ParkingFrame();
		frame.setTitle("������ ���� ���α׷�");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		});
	}
}

