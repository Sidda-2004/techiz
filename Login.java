package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	Container c;
	JButton rules, back;
	JTextField  tfname;
	public Login() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\91707\\eclipse-workspace\\StaticQuiz\\src\\quiz\\quizTime.jpg");
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 600, 500);
		add(image);
		
		JLabel heading = new JLabel("Techiz");
		heading.setBounds(750, 60, 300, 45);
		heading.setFont(new Font("Viner Hand ITC" ,Font.BOLD, 45));
		heading.setForeground(Color.BLACK);
		add(heading);
		
		JLabel name = new JLabel("Enter your name");
		name.setBounds(810, 150, 300, 25);
		name.setFont(new Font("Mongolian Baiti",Font.BOLD, 18));
		add(name);
		
		tfname = new JTextField();
		tfname.setBounds(735, 200, 300, 25);
		tfname.setFont(new Font("Arial", Font.BOLD, 20));
		add(tfname);
		
		rules = new JButton("Rules");
		rules.setBounds(915, 270, 120, 25);
		rules.setBackground(Color.BLACK);
		rules.setForeground(Color.WHITE);
		rules.addActionListener(this);
		add(rules);
		
		back = new JButton("Back");
		back.setBounds(735, 270, 120, 25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		setSize(1000, 500);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {
		String s;
		if(ae.getSource() == rules) {
			s = tfname.getText();
			setVisible(false);
			new Rules(s);
		}
		else if(ae.getSource() == back) {
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		new Login();

	}

}