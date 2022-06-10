import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	JFrame frame;
	JTextField field;
	JButton[] numberBtn = new JButton[10];
	JButton[] functionBtn = new JButton[9];
	JButton addbtn, subbtn, multiplybtn, dividebtn, equalbtn, decimalbtn, deletebtn, clearbtn, negbtn;
	JPanel panel;

	Font font = new Font("Wingdings", Font.BOLD, 25);

	double num1 = 0, num2 = 0, result = 0;
	char operator;

	Calculator() {
		frame = new JFrame("Calculator 0.1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 700);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);

		field = new JTextField();
		field.setBounds(50, 25, 400, 70);
		field.setFont(font);
		field.setEditable(false);

		addbtn = new JButton("+");
		subbtn = new JButton("-");
		multiplybtn = new JButton("x");
		dividebtn = new JButton("÷");
		equalbtn = new JButton("=");
		clearbtn = new JButton("Clr");
		decimalbtn = new JButton(".");
		deletebtn = new JButton("Del");
		negbtn = new JButton("(-)");

		functionBtn[0] = addbtn;
		functionBtn[1] = subbtn;
		functionBtn[2] = multiplybtn;
		functionBtn[3] = dividebtn;
		functionBtn[4] = decimalbtn;
		functionBtn[5] = equalbtn;
		functionBtn[6] = deletebtn;
		functionBtn[7] = clearbtn;
		functionBtn[8] = negbtn;

		for (int i = 0; i < 9; i++) {
			functionBtn[i].addActionListener(this);
			functionBtn[i].setFont(font);
			functionBtn[i].setFocusable(false);
		}

		for (int i = 0; i < 10; i++) {
			numberBtn[i] = new JButton(String.valueOf(i));
			numberBtn[i].addActionListener(this);
			numberBtn[i].setFont(font);
			numberBtn[i].setFocusable(false);
		}
		negbtn.setBounds(27, 570, 145, 50);
		deletebtn.setBounds(177, 570, 145, 50);
		clearbtn.setBounds(327, 570, 145, 50);

		panel = new JPanel();
		panel.setBounds(50, 120, 400, 400);
		panel.setLayout(new GridLayout(4, 4, 10, 10));

		panel.add(numberBtn[1]);
		panel.add(numberBtn[2]);
		panel.add(numberBtn[3]);
		panel.add(functionBtn[0]);
		panel.add(numberBtn[4]);
		panel.add(numberBtn[5]);
		panel.add(numberBtn[6]);
		panel.add(functionBtn[1]);

		panel.add(numberBtn[7]);
		panel.add(numberBtn[8]);
		panel.add(numberBtn[9]);
		panel.add(functionBtn[2]);
		panel.add(numberBtn[0]);
		panel.add(functionBtn[4]);
		panel.add(functionBtn[3]);
		panel.add(functionBtn[5]);

		frame.add(panel);
		frame.add(negbtn);
		frame.add(deletebtn);
		frame.add(clearbtn);

		frame.add(field);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) throws NumberFormatException {
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberBtn[i]) {
				field.setText(field.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decimalbtn) {
			field.setText(field.getText().concat("."));
		}
		if (e.getSource() == addbtn) {
			num1 = Double.parseDouble(field.getText());
			operator = '+';
			field.setText("");
		}
		if (e.getSource() == subbtn) {
			num1 = Double.parseDouble(field.getText());
			operator = '-';
			field.setText("");
		}
		if (e.getSource() == multiplybtn) {
			num1 = Double.parseDouble(field.getText());
			operator = '*';
			field.setText("");
		}
		if (e.getSource() == dividebtn) {
			num1 = Double.parseDouble(field.getText());
			operator = '/';
			field.setText("");
		}
		if (e.getSource() == equalbtn) {
			num2 = Double.parseDouble(field.getText());
			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			field.setText(String.valueOf(result));
			num1 = result;
		}
		if (e.getSource() == clearbtn) {
			field.setText("");
		}
		if (e.getSource() == deletebtn) {
			String str = field.getText();
			field.setText("");
			for (int i = 0; i < str.length() - 1; i++) {
				field.setText(field.getText() + str.charAt(i));
			}

		}
		if (e.getSource() == negbtn) {
			double temp = Double.parseDouble(field.getText());
			temp *= -1;
			field.setText(String.valueOf(temp));
		}
	}
}
