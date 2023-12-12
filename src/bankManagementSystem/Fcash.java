package bankManagementSystem;


import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Date;
public class Fcash extends JFrame implements ActionListener{
	JButton fiveh,onet,twot,threet,fivet,tent,exit;
	String pinnumber;
	Fcash(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg")); 
		Image i2=i1.getImage().getScaledInstance(850, 850,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 850, 850);
		add(image);
		
		JLabel text=new JLabel("Please Select Your Amount");
		text.setBounds(160, 280, 700, 25);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,20));
		image.add(text);
		
		fiveh =new JButton("500");
		fiveh.setBounds(145, 390, 150, 30);
		fiveh.addActionListener(this);
		image.add(fiveh);
		
		onet =new JButton("1000");
		onet.setBounds(330, 390, 150, 30);
		onet.addActionListener(this);
		image.add(onet);
		
		twot =new JButton("2000");
		twot.setBounds(145, 425, 150, 30);
		twot.addActionListener(this);
		image.add(twot);
		
	    threet =new JButton("3000");
	    threet.setBounds(330, 425, 150, 30);
	    threet.addActionListener(this);
		image.add(threet);
		
		fivet=new JButton("5000");
		fivet.setBounds(145, 460, 150, 30);
		fivet.addActionListener(this);
		image.add(fivet);
		
		tent =new JButton("10000");
		tent.setBounds(330, 460, 150, 30);
		tent.addActionListener(this);
		image.add(tent);
		
	    exit= new JButton("Back");
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
			setVisible(true);
			new Transactions(pinnumber).setVisible(true);
		}else {
			String amountnumber=((JButton)ae.getSource()).getText().substring(0);
			Conn c=new Conn();
			try {
				ResultSet rs=c.s.executeQuery("select*from bank where pinnumber='"+pinnumber+"'");
				int balance=0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance=balance+Integer.parseInt(rs.getString("amountnumber"));
						
					}else {
						balance-=Integer.parseInt(rs.getString("amountnumber"));
					}
				}
				if(balance< Integer.parseInt(rs.getString("amountnumber"))) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				Date date =new Date();
				
				String query="insert into bank values('"+pinnumber+"','"+date+"','"+amountnumber+"','Withdrawl')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rupees "+amountnumber+" Debited Succefully");
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
	}
	

	public static void main(String[] args) {
	 new Fcash("");
	 

	}
}



