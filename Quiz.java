package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Quiz extends JFrame implements ActionListener {

	String questions[][];	
	String[] answers ;
	String user_ans[] ;
	JButton next, submit, lifeline;
	JLabel qno, question;
	JRadioButton opt1, opt2, opt3, opt4;
	
	public static int timer = 60;
	public static int ans_given = 0;
	public static int count = 0, len = 0, score = 0;
	ButtonGroup groupOptions;
	String username;
	public Quiz(String username) {
		this.username = username;
		
		String path = "C:\\Users\\91707\\eclipse-workspace\\StaticQuiz\\src\\quiz\\quiz_qn.txt";
		String ans_path = "C:\\Users\\91707\\eclipse-workspace\\StaticQuiz\\src\\quiz\\quiz_ans.txt";
		
		TextFileTo2DArray tfa = new TextFileTo2DArray(path);
		DataToArrayConverter dca = new DataToArrayConverter();
		
		
		questions = tfa.quizArray;
		answers = dca.readDataFromFile(ans_path);
		len = questions.length;
		user_ans = new String[len];
		
		setBounds(0, 0, 1400, 850);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\91707\\eclipse-workspace\\StaticQuiz\\src\\quiz\\Screenshot (77).png");
		JLabel image = new JLabel(i1);
		
		Image i2 = i1.getImage().getScaledInstance(1300, 350, Image.SCALE_DEFAULT);
		image.setBounds(0, 0, 1300, 300);
		//image.setBounds(score, len, count, ans_given);
		add(image);
		
		qno = new JLabel();
		qno.setBounds(100, 400, 50, 30);
		qno.setFont(new Font("Taboma", Font.PLAIN, 24));
		add(qno);
		
		question = new JLabel();
		question.setBounds(150, 400, 900, 30);
		question.setFont(new Font("Taboma", Font.PLAIN, 24));
		add(question);
		
		
		opt1 = new JRadioButton();
		opt1.setBounds(170, 470, 700, 30);
		opt1.setBackground(Color.WHITE);
		opt1.setFont(new Font("Dialog", Font.PLAIN,20));
		add(opt1);
		
		opt2 = new JRadioButton();
		opt2.setBounds(170, 510, 700, 30);
		opt2.setBackground(Color.WHITE);
		opt2.setFont(new Font("Dialog", Font.PLAIN,20));
		add(opt2);
		
		opt3 = new JRadioButton();
		opt3.setBounds(170, 550, 700, 30);
		opt3.setBackground(Color.WHITE);
		opt3.setFont(new Font("Dialog", Font.PLAIN,20));
		add(opt3);
		
		opt4= new JRadioButton();
		opt4.setBounds(170, 590, 700, 30);
		opt4.setBackground(Color.WHITE);
		opt4.setFont(new Font("Dialog", Font.PLAIN,20));
		add(opt4);
		
		groupOptions = new  ButtonGroup();
		groupOptions.add(opt1);
		groupOptions.add(opt2);
		groupOptions.add(opt3);
		groupOptions.add(opt4);
		
		next = new JButton("Next");
		next.setBounds(1100, 480, 200, 30);
		next.setFont(new Font("Tahoma", Font.PLAIN, 22));
		next.setBackground(Color.DARK_GRAY);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);
		
		lifeline = new JButton("50-50 lifeline");
		lifeline.setBounds(1100, 530, 200, 30);
		lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lifeline.setBackground(Color.DARK_GRAY);
		lifeline.setForeground(Color.WHITE);
		lifeline.addActionListener(this);
		add(lifeline);
		
		submit = new JButton("Submit");
		submit.setBounds(1100, 580, 200, 30);
		submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		submit.setBackground(Color.DARK_GRAY);
		submit.setForeground(Color.WHITE);
		submit.setEnabled(false);
		submit.addActionListener(this);
		add(submit);
		
		start(count);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == next) {
			
			repaint();
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);
			
			ans_given = 1;
			
			if(groupOptions.getSelection() == null) {
				user_ans[count] = " ";
			}
			else {
				user_ans[count] = groupOptions.getSelection().getActionCommand();
			}
			
			if(count == len-2) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			count++;
			start(count);
		}
		else if(ae.getSource() == lifeline) {
			if(count == 2 || count == 4 || count == 6 || count == 8 || count == 10) {
				opt2.setEnabled(false);
				opt3.setEnabled(false);
			}
			else {
				opt1.setEnabled(false);
				opt4.setEnabled(false);
			}
			lifeline.setEnabled(false);
		}
		else if(ae.getSource() == submit){
			ans_given = 1;
			if(groupOptions.getSelection() == null) {
				user_ans[count] = "";
			}
			else {
				user_ans[count] = groupOptions.getSelection().getActionCommand();
			}
			for(int i=0;i<user_ans.length; i++) {
				if(user_ans[i].equals(answers[i]))
					score += 10;
			}
			setVisible(false);
			new Score(username, score);
			
		}
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		String time = "Time left : "+ timer + " seconds";  // 60
		g.setColor(Color.RED);
		g.setFont(new Font("Tahoma", Font.BOLD, 20));
	
		if(timer > 0) {
			g.drawString(time, 1000, 400);
		}
		else {
			g.drawString("Times up!!", 1000, 400);
		}
		timer --;
		
		try {
			Thread.sleep(1000);
			repaint();
		}
		catch(Exception e) {}
		
		if (ans_given == 1) {
			ans_given = 0;
			timer = 60;
		}
		else if (timer < 0) {
			timer = 60;
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);
			if(count == len-2) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			if(count == len-1) {    //submit
				if(groupOptions.getSelection() == null) {
					user_ans[count] = "";
				}
				else {
					user_ans[count] = groupOptions.getSelection().getActionCommand();
				}
				for(int i=0;i<user_ans.length; i++) {
					if(user_ans[i].equals(answers[i]))
						score += 10;
				}
				setVisible(false);
				new Score(username, score);
			}else {   
				// wait
				//wait
				//wait
				
				if(groupOptions.getSelection() == null) {
					user_ans[count] = "";
				}
				else {
					user_ans[count] = groupOptions.getSelection().getActionCommand();
				}
				count ++;
				start(count);
			}
			if(groupOptions.getSelection() == null) {
				user_ans[count] = "";
			}
			else {
				user_ans[count] = groupOptions.getSelection().getActionCommand();
			}
			count ++;
			start(count);
		}
	}
	public void start(int count) {
		qno.setText(""+ (count + 1) + ". ");
		
		question.setText(questions[count][0]);
		opt1.setText(questions[count][1]);
		opt1.setActionCommand(questions[count][1]);
		
		opt2.setText(questions[count][2]);
		opt2.setActionCommand(questions[count][2]);
		
		opt3.setText(questions[count][3]);
		opt3.setActionCommand(questions[count][3]);
		
		opt4.setText(questions[count][4]);
		opt4.setActionCommand(questions[count][4]);
		
		groupOptions.clearSelection();
		
	}
	public static void main(String[] args) {
		new Quiz("User");
	}

}