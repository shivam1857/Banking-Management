package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import java.sql.*;

public class Balanceenq extends JFrame implements ActionListener{
	JButton back;
	String pinnumber;
	int balance=0;
      
	Balanceenq(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg")); 
		Image i2=i1.getImage().getScaledInstance(850, 850,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 850, 850);
		add(image);
		Conn c=new Conn();
		try {
		ResultSet rs=c.s.executeQuery("select*from bank where pinnumber='"+pinnumber+"'");
		while(rs.next()) 
		{
			if(rs.getString("type").equals("Deposit")) 
			{
				balance=balance+Integer.parseInt(rs.getString("amountnumber"));
				
			}else
			  {
				balance-=Integer.parseInt(rs.getString("amountnumber"));
			  }
		}
		}catch(Exception e) 
		  {
			System.out.println(e);
	   	}
		
		JLabel text=new JLabel("Your Balance is "+balance);
		text.setBounds(160, 280, 700, 25);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.BOLD,15));
		image.add(text);
		
		
		
		back=new JButton("BACK");
		back.setForeground(Color.BLACK);
		back.setBounds(370, 490, 120, 25);
		back.addActionListener(this);
		image.add(back);
		
		
		
		
		setSize(850,850);
		setLocation(350,0);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}
	public static void main(String[] args) {
	   new Balanceenq("");

	}

}
