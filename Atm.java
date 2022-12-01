import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class Atm implements ActionListener{
	
	JFrame frame;
	JPanel panel;
	JButton bt, bt2;
	JTextField tf, tf1;
	JLabel lb, lb1, lb2, lb3;
	
	Atm(){
		frame = new JFrame("Atm Machine");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 500);
		frame.setLayout(null);
		frame.setResizable(false);
		
		lb = new JLabel(); 
		lb.setBounds(230, 50, 300, 100);
		lb.setText("ATM Machine");
		lb.setFont(new Font("Ink Free", Font.BOLD, 30));
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setForeground(new Color(0xFF0000));
		
		lb1 = new JLabel();
		lb1.setBounds(120, 110, 250, 100);
		lb1.setText("Account No.");
		lb1.setFont(new Font("Monospaced", Font.BOLD, 23));
		lb1.setForeground(new Color(0xFF0000));
		
		lb2 = new JLabel();
		lb2.setBounds(120, 170, 250, 100); 
		lb2.setText("Pin number");
		lb2.setFont(new Font("Monospaced", Font.BOLD, 23));
		lb2.setForeground(new Color(0xFF0000));
		
		lb3 = new JLabel();
		lb3.setBounds(180, 160, 400, 250);
		lb3.setText("New User? Click the sign up button");
		lb3.setFont(new Font("Comic Sans", Font.BOLD, 18));
		lb3.setForeground(new Color(0xFF0000));
		
		tf = new JTextField();
		tf.setBounds(300, 150, 250, 35);
		tf.setFont(new Font("Monospaced", Font.BOLD, 20));
		tf.setForeground(Color.BLACK);
		
		tf1 = new JTextField();
		tf1.setBounds(300, 210, 250, 35);
		tf1.setFont(new Font("Monospaced", Font.BOLD, 20));
		tf1.setForeground(Color.BLACK);
		
		bt = new JButton();
		bt.setBounds(150, 310, 100, 40);
		bt.setText("Login");
		bt.setFont(new Font("Comic Sans", Font.BOLD, 20));
		bt.setFocusable(false);
		bt.setForeground(Color.white);
		bt.setBackground(new Color(0x0020FF));
		bt.addActionListener(this);
		
		bt2 = new JButton();
		bt2.setBounds(350, 310, 150, 40);
		bt2.setText("Sign Up");
		bt2.setFont(new Font("Comic Sans", Font.BOLD, 20));
		bt2.setFocusable(false);
		bt2.setForeground(Color.white);
		bt2.setBackground(new Color(0x0020FF));
		bt2.addActionListener(this);
		
		frame.add(lb);
		frame.add(lb1);
		frame.add(lb2);
		frame.add(lb3);
		frame.add(tf);
		frame.add(tf1);
		frame.add(bt);
		frame.add(bt2);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atm atm = new Atm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt) {
			try {
				if(tf.getText().isEmpty() || tf1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill in the username & password", "Unsuccessful Login", JOptionPane.ERROR_MESSAGE);
				}else {
					int account = Integer.parseInt(tf.getText());
					int pwd = Integer.parseInt(tf1.getText());
					try {
						int number = Integer.parseInt(Files.readAllLines(Paths.get(account + ".txt")).get(0));
				        int password = Integer.parseInt(Files.readAllLines(Paths.get(account + ".txt")).get(1));
				        if((account == number) && (pwd == password)) {
				        	LoginPage loginpage = new LoginPage(tf.getText(), tf1.getText());
				        	frame.dispose();
				        }else if((account == number) & (pwd != password)) {
				        	JOptionPane.showMessageDialog(null, "Password Incorrect", "Password incorrect", JOptionPane.ERROR_MESSAGE);
				        }
					}catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Username doesn't exist", "Unsuccessful login", JOptionPane.ERROR_MESSAGE);
				    }
				}
			}catch(Exception e2) {
				JOptionPane.showMessageDialog(null, "Invalid input, we only accept integer values", "Invalid input", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == bt2) {
			frame.dispose();
			Signup signup = new Signup();
		}
	}

}
