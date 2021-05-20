import javax.swing.*;
import java.awt.*;

public class EntryFrame extends JFrame{
	private Car car;
	
	public EntryFrame(Parkinglot p) {
		setSize(600, 300);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 1));
		
		JLabel label1 = new JLabel("���� ����");
		label1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label1);
		
		JPanel bp = new JPanel();
		ButtonGroup g = new ButtonGroup();
		JRadioButton CarButton = new JRadioButton("Car");
		JRadioButton TruckButton = new JRadioButton("Truck");
		JRadioButton BusButton = new JRadioButton("Bus");
		g.add(CarButton);
		g.add(TruckButton);
		g.add(BusButton);
		bp.add(CarButton);
		bp.add(TruckButton);
		bp.add(BusButton);
		panel.add(bp);
		
		JLabel label2 = new JLabel("���� �뷮");
		label2.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label2);
		
		JPanel VolumePanel = new JPanel();
		VolumePanel.setLayout(new GridLayout(1, 3));
		VolumePanel.add(new JLabel());
		JTextField Volume = new JTextField();
		VolumePanel.add(Volume);
		Volume.setHorizontalAlignment(JLabel.CENTER);
		VolumePanel.add(new JLabel());
		panel.add(VolumePanel);
		
		JLabel label3 = new JLabel("���� �ð�");
		label3.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label3);
		
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
		
		JLabel label4 = new JLabel("���� ��ȣ");
		label4.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label4);
		
		JPanel NumberPanel = new JPanel();
		NumberPanel.setLayout(new GridLayout(1,3));
		NumberPanel.add(new JLabel());
		JTextField Number = new JTextField();
		NumberPanel.add(Number);
		Number.setHorizontalAlignment(JLabel.CENTER);
		NumberPanel.add(new JLabel());
		panel.add(NumberPanel);
		
		add(panel);
		
		JPanel OKpanel = new JPanel();
		JButton OK = new JButton("Ȯ��");
		JButton No = new JButton("���");
		OKpanel.add(OK);
		OKpanel.add(No);
		add(OKpanel, BorderLayout.SOUTH);
		
		CarButton.addActionListener(event -> {
			car = new Car();
		});
		
		TruckButton.addActionListener(event -> {
			car = new Truck();
		});
		
		BusButton.addActionListener(event -> {
			car = new Bus();
		});
		
		OK.addActionListener(event -> {
			try {
				car.setVolume(Integer.parseInt(Volume.getText()));
				Date d = new Date(Integer.parseInt(year.getText()), Integer.parseInt(month.getText()), Integer.parseInt(day.getText()), Integer.parseInt(hour.getText()), Integer.parseInt(minute.getText()));
				car.setDate(d);
				car.setCarnumber(Integer.parseInt(Number.getText()));
				p.Entry(car);
				dispose();
			}
			catch (DateException ie) {
				JOptionPane.showMessageDialog(null, "���� �ð��� �Է��� �߸� �Ǿ����ϴ�.", "����!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			catch (CarnumberException oe) {
				JOptionPane.showMessageDialog(null, "������ȣ�� 1000 ~ 9999 ������ ���� �Է��� �ּ���.", "����!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			catch (VolumeException v) {
				JOptionPane.showMessageDialog(null, "��ȿ���� ���� �뷮 ���Դϴ�.", "����!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			catch (DuplicateException d) {
				JOptionPane.showMessageDialog(null, "�̹� �����Ǿ� �ִ� ���� ��ȣ�Դϴ�.", "����!", JOptionPane.ERROR_MESSAGE);
				return;
			}
		});
		
		No.addActionListener(event -> {
			dispose();
		});
	}
}


