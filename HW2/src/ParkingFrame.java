import java.awt.*;
import java.util.Collections;

import javax.swing.*;

public class ParkingFrame extends JFrame{
	private static final int DEFUALT_WIDTH = 300;
	private static final int DEFUALT_HEIGHT = 700;
	private Parkinglot parkinglot;
	
	public ParkingFrame() {
		setSize(DEFUALT_WIDTH, DEFUALT_HEIGHT);
		
		parkinglot = new Parkinglot(30);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 1));
		
		JButton Entry = new JButton("입차");
		JButton Exit = new JButton("출차");
		JButton Show = new JButton("차량 보기");
		JButton fee = new JButton("수입 보기");
		JButton quit = new JButton("종료");
		
		buttonPanel.add(Entry);
		buttonPanel.add(Exit);
		buttonPanel.add(Show);
		buttonPanel.add(fee);
		buttonPanel.add(quit);
		
		JPanel title = new JPanel();
		title.setBackground(Color.BLACK);
		JLabel titlelabel = new JLabel("주차장 관리 프로그램");
		title.add(titlelabel);
		titlelabel.setForeground(Color.WHITE);
		titlelabel.setFont(new Font(title.getFont().toString() ,Font.BOLD, 15));
		
		add(buttonPanel, BorderLayout.CENTER);
		add(title, BorderLayout.NORTH);
		
		Entry.addActionListener(event -> {
			if (parkinglot.isFull()) {
				JOptionPane.showMessageDialog(null, "주차장이 꽉 찼습니다.", "오류!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			EntryFrame f = new EntryFrame(parkinglot);
			f.setTitle("입차");
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			f.setVisible(true);
		});
		
		Exit.addActionListener(event -> {
			if (parkinglot.isEmpty()) {
				JOptionPane.showMessageDialog(null, "주차장이 비어 있습니다.", "오류!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			ExitFrame f = new ExitFrame(parkinglot);
			f.setTitle("출차");
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			f.setVisible(true);
		});
		
		Show.addActionListener(event -> {
			PrintFrame print = new PrintFrame();
			parkinglot.append(print.getTextArea());
			print.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			print.setVisible(true);
		});
		
		fee.addActionListener(event -> {
			JOptionPane.showMessageDialog(null, "총 수입은 " + parkinglot.getIncome() + "원 입니다.", "수입 보기", JOptionPane.INFORMATION_MESSAGE);
		});
		
		quit.addActionListener(event -> {
			System.exit(0);
		});
	}
	
}
