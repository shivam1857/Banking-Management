package bankManagementSystem;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
public class Transactions extends JFrame implements ActionListener{
	JButton deposit,cashw,fcash,minis,pinchange,balanceenq,exit;
	String pinnumber;
	Transactions(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg")); 
		Image i2=i1.getImage().getScaledInstance(850, 850,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 850, 850);
		add(image);
		
		JLabel text=new JLabel("Please Select Your Transactions");
		text.setBounds(160, 280, 700, 25);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,20));
		image.add(text);
		
		deposit =new JButton("Deposit");
		deposit.setBounds(145, 390, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		cashw =new JButton("Cash Withdrawl");
		cashw.setBounds(330, 390, 150, 30);
		cashw.addActionListener(this);
		image.add(cashw);
		
		fcash =new JButton("Fast Cash");
		fcash.setBounds(145, 425, 150, 30);
		fcash.addActionListener(this);
		image.add(fcash);
		
	    minis =new JButton("Mini Statement");
		minis.setBounds(330, 425, 150, 30);
		minis.addActionListener(this);
		image.add(minis);
		
		pinchange =new JButton("Pin Change");
		pinchange.setBounds(145, 460, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenq =new JButton("Balance Enquiry");
		balanceenq.setBounds(330, 460, 150, 30);
		balanceenq.addActionListener(this);
		image.add(balanceenq);
		
	    exit= new JButton("Exit");
		exit.setBounds(330, 495, 150, 25);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
		setSize(850,850);
		setLocation(350,0);
		setUndecorated(true);
		setVisible(true);
		
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			System.exit(0);
		}else if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}else if(ae.getSource()==cashw) {
			setVisible(false);
			new Cashw(pinnumber).setVisible(true);
		}else if(ae.getSource()==fcash) {
			setVisible(false);
			new Fcash(pinnumber).setVisible(true);
		}else if(ae.getSource()==pinchange) {
			setVisible(false);
			new Pinchange(pinnumber).setVisible(true);
			
		}else if(ae.getSource()==balanceenq) {
			setVisible(false);
			new Balanceenq(pinnumber).setVisible(true);
		}
		
	}
	

	public static void main(String[] args) {
	 new Transactions("");
	 

	}
}



