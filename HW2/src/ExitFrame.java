import javax.swing.*;
import java.awt.*;

public class ExitFrame extends JFrame{
	
	public ExitFrame(Parkinglot p) {
		setSize(400, 200);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,1));
		
		JLabel label1 = new JLabel("출차 시간");
		label1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label1);
		
		JPanel DatePanel = new JPanel();
		DatePanel.setLayout(new GridLayout(1, 10));
		JTextField year = new JTextField();
		year.setHorizontalAlignment(JLabel.CENTER);
		DatePanel.add(year);
		DatePanel.add(new JLabel("년"));
		JTextField month = new JTextField();
		month.setHorizontalAlignment(JLabel.CENTER);
		DatePanel.add(month);
		DatePanel.add(new JLabel("월"));
		JTextField day = new JTextField();
		day.setHorizontalAlignment(JLabel.CENTER);
		DatePanel.add(day);
		DatePanel.add(new JLabel("일"));
		JTextField hour = new JTextField();
		hour.setHorizontalAlignment(JLabel.CENTER);
		DatePanel.add(hour);
		DatePanel.add(new JLabel("시"));
		JTextField minute = new JTextField();
		minute.setHorizontalAlignment(JLabel.CENTER);
		DatePanel.add(minute);
		DatePanel.add(new JLabel("분"));
		panel.add(DatePanel);
		
		JLabel label2 = new JLabel("차량 번호");
		label2.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label2);
		
		JPanel NumberPanel = new JPanel();
		NumberPanel.setLayout(new GridLayout(1,3));
		NumberPanel.add(new JLabel());
		JTextField Number = new JTextField();
		NumberPanel.add(Number);
		Number.setHorizontalAlignment(JLabel.CENTER);
		NumberPanel.add(new JLabel());
		panel.add(NumberPanel);
		
		add(panel);
		
		JPanel buttonPanel = new JPanel();
		
		JButton OK = new JButton("확인");
		JButton NO = new JButton("취소");
		buttonPanel.add(OK);
		buttonPanel.add(NO);
		add(buttonPanel, BorderLayout.SOUTH);
		
		OK.addActionListener(event -> {
			try {
				Date d = new Date(Integer.parseInt(year.getText()), Integer.parseInt(month.getText()), Integer.parseInt(day.getText()), Integer.parseInt(hour.getText()), Integer.parseInt(minute.getText()));
				int num = Integer.parseInt(Number.getText());
				p.Exit(num, d);
				dispose();
			}
			catch (DateException de) {
				JOptionPane.showMessageDialog(null, "출차 시간의 입력이 잘못되었습니다.", "오류!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			catch (CarnumberException ce) {
				JOptionPane.showMessageDialog(null, "유효하지 않은 용량값입니다.", "오류!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			catch (OutDateException oe) {
				JOptionPane.showMessageDialog(null, "출차시간이 입차시간보다 빠릅니다.", "오류!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			catch (NoCarException n) {
				JOptionPane.showMessageDialog(null, "입력한 차량 번호는 주차되어 있지 않습니다.", "오류!", JOptionPane.ERROR_MESSAGE);
				return;
			}
		});
		
		NO.addActionListener(event -> {
			dispose();
		});
	}
	
}
