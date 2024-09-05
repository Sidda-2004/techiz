package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Score extends JFrame implements ActionListener {
	int score;
	public Score(String name, int score) {
		this.score = score;
		setBounds(400, 150, 750, 550);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\91707\\eclipse-workspace\\StaticQuiz\\src\\quiz\\score.png");
		Image i2 = i1.getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT);
		JLabel image = new JLabel(i1);
		image.setBounds(30, 150, 500, 200);
		add(image);
		
		JLabel heading = new JLabel("Thankyou "+name+" for playing Techiz");
		heading.setBounds(45, 50, 700, 30);
		heading.setFont(new Font("Kristen ITC" ,Font.BOLD, 32));
		add(heading);
		
		JLabel scores = new JLabel("Your score is "+ score);
		scores.setBounds(550, 200, 300, 30);
		scores.setFont(new Font("Tahoma" ,Font.BOLD, 20));
		add(scores);
		
		JButton play = new JButton("Play Again");
		play.setBounds(560, 270, 120, 30);
		play.setFont(new Font("Tahoma" ,Font.PLAIN, 15));
		play.setBackground(Color.BLACK);
		play.setForeground(Color.WHITE);
		play.addActionListener(this);
		add(play);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Login();
	}

	public static void main(String[] args) {
		new Score("User", 0);
	}

}