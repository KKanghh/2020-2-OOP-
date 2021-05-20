import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

public class PrintFrame extends JFrame {
	JTextArea textarea;
	
	public PrintFrame() {
		setSize(200, 300);
		JFrame textFrame = new JFrame();
		JPanel buttonPanel = new JPanel();
		JButton exit = new JButton("´Ý±â");
		buttonPanel.add(exit);
		add(buttonPanel, BorderLayout.SOUTH);
		JPanel text = new JPanel();
		textarea = new JTextArea(10,10);
		textarea.setFont(new Font("Serif", Font.PLAIN, 15));
		JScrollPane scrollPane = new JScrollPane(textarea);
		text.add(textarea);
		add(text);
		exit.addActionListener(e -> dispose());
	}
	
	public JTextArea getTextArea() {return textarea;}
}
