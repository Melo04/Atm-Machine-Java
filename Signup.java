import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class Signup implements ActionListener{
    JFrame frame = new JFrame("Signup");
    JLabel lb = new JLabel("Bts Bank");
	JLabel lb2 = new JLabel("Please select one of the operation");
	JLabel lb3 = new JLabel("Name: ");
	JLabel lb4 = new JLabel("Date Of Birth: ");
	JLabel lb5 = new JLabel("Gender: ");
	JLabel lb6 = new JLabel("Phone No: ");
	JLabel lb7 = new JLabel("Account No: ");
	JLabel lb8 = new JLabel("Password: ");
	JComboBox comboBox, comboBox2, comboBox3;
	JRadioButton maleButton = new JRadioButton("Male");
	JRadioButton femaleButton = new JRadioButton("Female");
	JCheckBox checkBox = new JCheckBox("I accept all terms and condition.");
	JTextField tf = new JTextField();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JButton bt, bt2;
	
	Signup(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		frame.setSize(700, 600);
  		frame.setLayout(null);
  		frame.setResizable(false);
  		
  		lb.setBounds(0, 0, 700, 60);
		lb.setFont(new Font("Ink Free", Font.BOLD, 30));
		lb.setHorizontalAlignment(JLabel.CENTER);
		lb.setForeground(Color.WHITE);
		lb.setBackground(Color.BLUE);
		lb.setOpaque(true);
		
		lb2.setBounds(0, 50, 700, 50);
		lb2.setFont(new Font("Consolas", Font.BOLD, 18));
		lb2.setHorizontalAlignment(JLabel.CENTER);
		lb2.setForeground(Color.WHITE);
		lb2.setBackground(Color.BLUE);
		lb2.setOpaque(true);
  		
		lb3.setBounds(60, 120, 170, 50);
		lb3.setFont(new Font("Monospaced", Font.BOLD, 20));
		lb3.setForeground(Color.blue);
		
		lb4.setBounds(60, 170, 200, 50);
		lb4.setFont(new Font("Monospaced", Font.BOLD, 20));
		lb4.setForeground(Color.blue);
		
		lb5.setBounds(60, 220, 170, 50);
		lb5.setFont(new Font("Monospaced", Font.BOLD, 20));
		lb5.setForeground(Color.blue);
		
		lb6.setBounds(60, 270, 170, 50);
		lb6.setFont(new Font("Monospaced", Font.BOLD, 20));
		lb6.setForeground(Color.blue);
		
		lb7.setBounds(60, 320, 170, 50);
		lb7.setFont(new Font("Monospaced", Font.BOLD, 20));
		lb7.setForeground(Color.blue);
		
		lb8.setBounds(60, 370, 170, 50);
		lb8.setFont(new Font("Monospaced", Font.BOLD, 20));
		lb8.setForeground(Color.blue);
		
		tf.setBounds(290, 130, 300, 30);
		tf.setFont(new Font("Monospaced", Font.BOLD, 18));
		tf.setForeground(Color.BLACK);
		
		String[] date = {"date", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				     "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		String[] month = {"month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		String[] year = {"year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", 
				      "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", 
				      "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" };
		comboBox = new JComboBox(date);
		comboBox.setBounds(290, 185, 80, 25);
		comboBox2 = new JComboBox(month);
		comboBox2.setBounds(380, 185, 80, 25);
		comboBox3 = new JComboBox(year);
		comboBox3.setBounds(470, 185, 100, 25);
		
		ButtonGroup group = new ButtonGroup();
		maleButton.setBounds(290, 230, 100, 30);
		femaleButton.setBounds(450, 230, 120, 30);
		maleButton.setFont(new Font("Monospaced", Font.BOLD, 16));
		femaleButton.setFont(new Font("Monospaced", Font.BOLD, 16));
		group.add(maleButton);
		group.add(femaleButton);
	
		tf1.setBounds(290, 280, 300, 30);
		tf1.setFont(new Font("Monospaced", Font.BOLD, 20));
		tf1.setForeground(Color.BLACK);
		
		tf2.setBounds(290, 330, 300, 30);
		tf2.setFont(new Font("Monospaced", Font.BOLD, 20));
		tf2.setForeground(Color.BLACK);
		
		tf3.setBounds(290, 380, 300, 30);
		tf3.setFont(new Font("Monospaced", Font.BOLD, 20));
		tf3.setForeground(Color.BLACK);
		
		checkBox.setFocusable(false);
		checkBox.setBounds(200, 430, 500, 50);
		checkBox.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		bt = new JButton("SIGN UP");
		bt.setBounds(100, 480, 170, 50);
		bt.setFont(new Font("Consolas", Font.BOLD, 20));
		bt.setFocusable(false);
		bt.setForeground(Color.white);
		bt.setBackground(Color.red);
		bt.addActionListener(this);
		
		bt2 = new JButton("CANCEL");
		bt2.setBounds(400, 480, 170, 50);
		bt2.setFont(new Font("Consolas", Font.BOLD, 20));
		bt2.setFocusable(false);
		bt2.setForeground(Color.white);
		bt2.setBackground(Color.red);
		bt2.addActionListener(this);
  		
		frame.add(lb);
		frame.add(lb2);
		frame.add(lb3);
		frame.add(lb4);
		frame.add(lb5);
		frame.add(lb6);
		frame.add(lb7);
		frame.add(lb8);
		frame.add(tf);
		frame.add(tf1);
		frame.add(tf2);
		frame.add(tf3);
		frame.add(comboBox);
		frame.add(comboBox2);
		frame.add(comboBox3);
		frame.add(maleButton);
		frame.add(femaleButton);
		frame.add(checkBox);
		frame.add(bt);
		frame.add(bt2);
  		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bt) {
			if(tf.getText().isEmpty() || tf1.getText().isEmpty() || tf2.getText().isEmpty() ||  tf3.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "You have not fulfill all the values", "Sign Up Unsuccessful", JOptionPane.ERROR_MESSAGE);
			}else {
				if(checkBox.isSelected()) {
					try { 
						int account = Integer.parseInt(tf2.getText());
						int pwd = Integer.parseInt(tf3.getText());
						File filename = new File(account + ".txt");
						if(filename.exists()) {
							JOptionPane.showMessageDialog(null, "This account is registered by other user", "Sign Up Unsuccessful", JOptionPane.ERROR_MESSAGE);
						}else{
							FileWriter writer = new FileWriter(account + ".txt");
						    writer.write(account + "\n" + pwd);
						    writer.close();
						    JOptionPane.showMessageDialog(null, "Sign Up Successfully", "Sign Up Successful", JOptionPane.INFORMATION_MESSAGE);
						    frame.dispose();
						    Atm atm = new Atm();
						}
					}catch(Exception exception) {
						JOptionPane.showMessageDialog(null, "Invalid input for Account No & Password, we only accept integer values", "Sign Up Unsuccessful", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please accept the terms and condition given", "Sign Up Unsuccessful", JOptionPane.ERROR_MESSAGE);
				}
		     }
		}else if(e.getSource() == bt2) {
			frame.dispose();
			Atm atm = new Atm();
	    }
	}
}
