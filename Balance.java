import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class Balance{
	JFrame frame = new JFrame("Check Balance");
	JLabel lb = new JLabel("Bts Bank");
	JLabel lb2 = new JLabel("Check balance");
	JLabel lb3;
	JButton bt = new JButton("BACK");
	
	Balance(String account, String password){
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
		
		try {
			int balance = Integer.parseInt(Files.readAllLines(Paths.get(account + ".txt")).get(2));
			lb3 = new JLabel("Amount: RM " + balance);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Money is not deposited yet", "Balance none", JOptionPane.ERROR_MESSAGE);
			lb3 = new JLabel("Amount: RM 0"); 
		}
		lb3.setBounds(280, 160, 300, 50);
		lb3.setFont(new Font("Consolas", Font.BOLD, 18));
		lb3.setForeground(Color.BLUE);
		
		bt.setBounds(290, 230, 100, 40);
		bt.setFont(new Font("Consolas", Font.BOLD, 20));
		bt.setFocusable(false);
		bt.setForeground(Color.white);
		bt.setBackground(Color.BLUE);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==bt) {
					frame.dispose();
					LoginPage loginpage = new LoginPage(account, password);
				}
		    }
	    });
		
  		frame.add(lb);
  		frame.add(lb2);
  		frame.add(lb3);
        frame.add(bt);
  		frame.setVisible(true);
	}
}