import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class Changepin{
	JFrame frame = new JFrame("Change pin");
	JLabel lb = new JLabel("Bts Bank");
	JLabel lb2 = new JLabel("Enter your new password below");
	JLabel lb3 = new JLabel("New pin: ");
	JLabel lb4 = new JLabel("Confirm pin: ");
	JTextField tf = new JTextField();
	JTextField tf2 = new JTextField();
	JButton bt = new JButton("CHANGE");
	JButton bt2 = new JButton("BACK");
	
	Changepin(String account, String password){
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
		
		lb3.setBounds(130, 120, 150, 50);
		lb3.setFont(new Font("Consolas", Font.BOLD, 18));
		lb3.setForeground(Color.BLUE);
		
		lb4.setBounds(130, 180, 150, 50);
		lb4.setFont(new Font("Consolas", Font.BOLD, 18));
		lb4.setForeground(Color.BLUE);
		
		tf.setBounds(300, 120, 250, 35);
		tf.setFont(new Font("Monospaced", Font.BOLD, 18));
		tf.setForeground(Color.BLACK);
		
		tf2.setBounds(300, 180, 250, 35);
		tf2.setFont(new Font("Monospaced", Font.BOLD, 18));
		tf2.setForeground(Color.BLACK);
		
		bt.setBounds(160, 250, 150, 50);
		bt.setFont(new Font("Consolas", Font.BOLD, 20));
		bt.setFocusable(false);
		bt.setForeground(Color.white);
		bt.setBackground(Color.BLUE);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==bt) {
					try {
						if(tf.getText().isEmpty() || tf2.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please enter your new and confirm pin", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
						}else {
							int pin = Integer.parseInt(tf.getText());
							int pin2 = Integer.parseInt(tf2.getText());
							if(pin == pin2) {
								int result = JOptionPane.showConfirmDialog(null, "Are you sure to change to this pin?", "Choose Yes or No", JOptionPane.YES_NO_OPTION);
								if(result == JOptionPane.YES_OPTION) {
									try {
										int pwd = Integer.parseInt(Files.readAllLines(Paths.get(account + ".txt")).get(1));
										int balance = Integer.parseInt(Files.readAllLines(Paths.get(account + ".txt")).get(2));
									    FileWriter writer = new FileWriter(account + ".txt");
									    writer.write(account + "\n" + pin + "\n" + balance);
									    writer.close();
									    JOptionPane.showMessageDialog(null, "Change pin successfully", "Change pin successfully", JOptionPane.INFORMATION_MESSAGE);
									    frame.dispose();
									    Atm atm = new Atm();
									} catch (IOException e1) {
										JOptionPane.showMessageDialog(null, "Invalid input, We only accept integer values", "Invalid input", JOptionPane.ERROR_MESSAGE);
									}
								}
							}else if(pin != pin2) {
								JOptionPane.showMessageDialog(null, "New pin and confirm pin are not equal", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
							}
							
						}
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Invalid input, We only accept integer values", "Invalid input", JOptionPane.ERROR_MESSAGE);
					}
				}
		    }
	    });
		
		bt2.setBounds(350, 250, 150, 50);
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
  		frame.add(lb4);
  		frame.add(tf);
  		frame.add(tf2);
        frame.add(bt);
        frame.add(bt2);
  		frame.setVisible(true);
	}
}
