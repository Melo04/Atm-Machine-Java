import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class Deposit{
	JFrame frame = new JFrame("Deposit Cash");
	JLabel lb = new JLabel("Bts Bank");
	JLabel lb2 = new JLabel("Enter the amount to deposit in bank");
	JLabel lb3 = new JLabel("Amount: ");
	JTextField tf = new JTextField();
	JButton bt = new JButton("DEPOSIT");
	JButton bt2 = new JButton("BACK");
	
	Deposit(String account, String password){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		frame.setSize(700, 400);
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
		
		lb3.setBounds(120, 160, 150, 50);
		lb3.setFont(new Font("Consolas", Font.BOLD, 18));
		lb3.setForeground(Color.BLUE);
		
		tf.setBounds(300, 160, 250, 35);
		tf.setFont(new Font("Monospaced", Font.BOLD, 18));
		tf.setForeground(Color.BLACK);
		
		bt.setBounds(160, 230, 150, 50);
		bt.setFont(new Font("Consolas", Font.BOLD, 20));
		bt.setFocusable(false);
		bt.setForeground(Color.white);
		bt.setBackground(Color.BLUE);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(e.getSource()==bt) {
						if(tf.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please fill in the deposit amount", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
						}else {
							int amount = Integer.parseInt(tf.getText());
							int result = JOptionPane.showConfirmDialog(null, "Are you sure to deposit this amount?", "Choose Yes or No", JOptionPane.YES_NO_OPTION);
							if(result == JOptionPane.YES_OPTION) {
								try {
									String line = Files.readAllLines(Paths.get(account + ".txt")).get(2);
									int balance = Integer.parseInt(line);
									balance += amount;
									JOptionPane.showMessageDialog(null, "Balance: RM" + balance, "Successfully deposited", JOptionPane.INFORMATION_MESSAGE);
								    FileWriter writer = new FileWriter(account + ".txt");
								    writer.write(account + "\n" + password + "\n" + balance);
								    writer.close();
								}catch(Exception e1) {
									JOptionPane.showMessageDialog(null, "Balance: RM" + amount, "Successfully deposited", JOptionPane.INFORMATION_MESSAGE);
								    FileWriter writer = new FileWriter(account + ".txt");
								    writer.write(account + "\n" + password + "\n" + amount);
								    writer.close();
								}
								frame.dispose();
							    LoginPage loginpage = new LoginPage(account, password);
							}
						}
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Invalid input, We only accept integer values", "Invalid input", JOptionPane.ERROR_MESSAGE);
				}
		    }
	    });
		
		bt2.setBounds(350, 230, 150, 50);
		bt2.setFont(new Font("Consolas", Font.BOLD, 20));
		bt2.setFocusable(false);
		bt2.setForeground(Color.white);
		bt2.setBackground(Color.BLUE);
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==bt2) {
					frame.dispose();
					LoginPage loginpage = new LoginPage(account, password);
				}
		    }
	    });
		
  		frame.add(lb);
  		frame.add(lb2);
  		frame.add(lb3);
  		frame.add(tf);
        frame.add(bt);
        frame.add(bt2);
  		frame.setVisible(true);
	}
}
