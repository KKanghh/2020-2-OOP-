import javax.swing.*;
import java.awt.*;

public class ExitFrame extends JFrame{
	
	public ExitFrame(Parkinglot p) {
		setSize(400, 200);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,1));
		
		JLabel label1 = new JLabel("���� �ð�");
		label1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label1);
		
		JPanel DatePanel = new JPanel();
		DatePanel.setLayout(new GridLayout(1, 10));
		JTextField year = new JTextField();
		year.setHorizontalAlignment(JLabel.CENTER);
		DatePanel.add(year);
		DatePanel.add(new JLabel("��"));
		JTextField month = new JTextField();
		month.setHorizontalAlignment(JLabel.CENTER);
		DatePanel.add(month);
		DatePanel.add(new JLabel("��"));
		JTextField day = new JTextField();
		day.setHorizontalAlignment(JLabel.CENTER);
		DatePanel.add(day);
		DatePanel.add(new JLabel("��"));
		JTextField hour = new JTextField();
		hour.setHorizontalAlignment(JLabel.CENTER);
		DatePanel.add(hour);
		DatePanel.add(new JLabel("��"));
		JTextField minute = new JTextField();
		minute.setHorizontalAlignment(JLabel.CENTER);
		DatePanel.add(minute);
		DatePanel.add(new JLabel("��"));
		panel.add(DatePanel);
		
		JLabel label2 = new JLabel("���� ��ȣ");
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
		
		JButton OK = new JButton("Ȯ��");
		JButton NO = new JButton("���");
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
				JOptionPane.showMessageDialog(null, "���� �ð��� �Է��� �߸��Ǿ����ϴ�.", "����!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			catch (CarnumberException ce) {
				JOptionPane.showMessageDialog(null, "��ȿ���� ���� �뷮���Դϴ�.", "����!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			catch (OutDateException oe) {
				JOptionPane.showMessageDialog(null, "�����ð��� �����ð����� �����ϴ�.", "����!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			catch (NoCarException n) {
				JOptionPane.showMessageDialog(null, "�Է��� ���� ��ȣ�� �����Ǿ� ���� �ʽ��ϴ�.", "����!", JOptionPane.ERROR_MESSAGE);
				return;
			}
		});
		
		NO.addActionListener(event -> {
			dispose();
		});
	}
	
}
