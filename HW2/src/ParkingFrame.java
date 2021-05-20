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
		
		JButton Entry = new JButton("����");
		JButton Exit = new JButton("����");
		JButton Show = new JButton("���� ����");
		JButton fee = new JButton("���� ����");
		JButton quit = new JButton("����");
		
		buttonPanel.add(Entry);
		buttonPanel.add(Exit);
		buttonPanel.add(Show);
		buttonPanel.add(fee);
		buttonPanel.add(quit);
		
		JPanel title = new JPanel();
		title.setBackground(Color.BLACK);
		JLabel titlelabel = new JLabel("������ ���� ���α׷�");
		title.add(titlelabel);
		titlelabel.setForeground(Color.WHITE);
		titlelabel.setFont(new Font(title.getFont().toString() ,Font.BOLD, 15));
		
		add(buttonPanel, BorderLayout.CENTER);
		add(title, BorderLayout.NORTH);
		
		Entry.addActionListener(event -> {
			if (parkinglot.isFull()) {
				JOptionPane.showMessageDialog(null, "�������� �� á���ϴ�.", "����!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			EntryFrame f = new EntryFrame(parkinglot);
			f.setTitle("����");
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			f.setVisible(true);
		});
		
		Exit.addActionListener(event -> {
			if (parkinglot.isEmpty()) {
				JOptionPane.showMessageDialog(null, "�������� ��� �ֽ��ϴ�.", "����!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			ExitFrame f = new ExitFrame(parkinglot);
			f.setTitle("����");
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
			JOptionPane.showMessageDialog(null, "�� ������ " + parkinglot.getIncome() + "�� �Դϴ�.", "���� ����", JOptionPane.INFORMATION_MESSAGE);
		});
		
		quit.addActionListener(event -> {
			System.exit(0);
		});
	}
	
}
