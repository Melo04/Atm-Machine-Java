import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class LoginPage{
	JFrame frame = new JFrame("Bts Bank");
	JLabel lb = new JLabel("Bts Bank");
	JLabel lb2 = new JLabel("Please select one of the operation");
	JLabel lb3;
	JButton bt, bt1, bt2, bt3, bt4;
	String text, text2;
	
     LoginPage(String text, String text2){
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		frame.setSize(700, 500);
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
		
		lb3 = new JLabel("Account No: " + text);
		lb3.setBounds(230, 110, 300, 30);
		lb3.setFont(new Font("Monospaced", Font.BOLD, 20));
		lb3.setForeground(Color.RED);
		
		bt = new JButton("DEPOSIT");
		bt.setBounds(100, 170, 170, 50);
		bt.setFont(new Font("Consolas", Font.BOLD, 20));
		bt.setFocusable(false);
		bt.setForeground(Color.white);
		bt.setBackground(Color.BLUE);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bt) {
					frame.dispose();
					Deposit deposit = new Deposit(text, text2);
				}
		    }
	    });
		
		bt1 = new JButton("WITHDRAW");
		bt1.setBounds(100, 250, 170, 50);
		bt1.setFont(new Font("Consolas", Font.BOLD, 20));
		bt1.setFocusable(false);
		bt1.setForeground(Color.white);
		bt1.setBackground(Color.BLUE);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bt1) {
					frame.dispose();
					Withdraw withdraw = new Withdraw(text, text2);
				}
		    }
	    });
		
		bt2 = new JButton("CHECK BALANCE");
		bt2.setBounds(360, 170, 200, 50);
		bt2.setFont(new Font("Consolas", Font.BOLD, 20));
		bt2.setFocusable(false);
		bt2.setForeground(Color.white);
		bt2.setBackground(Color.BLUE);
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bt2) {
					frame.dispose();
					Balance balance = new Balance(text, text2);
				}
		    }
	    });
		
		bt3 = new JButton("CHANGE PIN");
		bt3.setBounds(360, 250, 200, 50);
		bt3.setFont(new Font("Consolas", Font.BOLD, 20));
		bt3.setFocusable(false);
		bt3.setForeground(Color.white);
		bt3.setBackground(Color.BLUE);
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bt3) {
					frame.dispose();
					Changepin changepin = new Changepin(text, text2);
				}
		    }
	    });
		
		bt4 = new JButton("LOGOUT");
		bt4.setBounds(200, 330, 170, 50);
		bt4.setFont(new Font("Consolas", Font.BOLD, 20));
		bt4.setFocusable(false);
		bt4.setForeground(Color.white);
		bt4.setBackground(Color.BLUE);
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==bt4) {
					frame.dispose();
					Atm atm = new Atm();
				}
		    }
	    });
        
        frame.add(lb);
        frame.add(lb2);
        frame.add(lb3);
        frame.add(bt);
        frame.add(bt1);
        frame.add(bt2);
        frame.add(bt3);
        frame.add(bt4);
 		frame.setVisible(true);
     }
}
