package bankManagementSystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,clear;
	String formno;
	
	SignUpThree(String formno){
	this.formno=formno;
	
	setLayout(null);
	getContentPane().setBackground(Color.WHITE);
	
	JLabel l1=new JLabel("Page:3 Account Details");
	l1.setBounds(280, 40, 400, 40);
	l1.setFont(new Font("Raleway",Font.BOLD,22));
	add(l1);
	
	JLabel type=new JLabel("Account Type");
	type.setBounds(100, 140, 200, 30);
	type.setFont(new Font("Raleway",Font.BOLD,20));
	add(type);
	
	r1=new JRadioButton("Saving Account");
	r1.setBounds(100, 180, 200, 20);
	r1.setFont(new Font("Raleway",Font.BOLD,12));
	r1.setBackground(Color.WHITE);
	add(r1);
	
	r2=new JRadioButton("Fixed Deposit");
	r2.setBounds(320, 180, 200, 20);
	r2.setFont(new Font("Raleway",Font.BOLD,12));
	r2.setBackground(Color.WHITE);
	add(r2);
	
	r3=new JRadioButton("Current Account");
	r3.setBounds(100, 220, 200, 20);
	r3.setFont(new Font("Raleway",Font.BOLD,12));
	r3.setBackground(Color.WHITE);
	add(r3);
	
	r4=new JRadioButton("Deposit Account");
	r4.setBounds(320, 220, 200, 20);
	r4.setFont(new Font("Raleway",Font.BOLD,12));
	r4.setBackground(Color.WHITE);
	add(r4);
	
	ButtonGroup typegroup=new ButtonGroup();
	typegroup.add(r1);
	typegroup.add(r2);
	typegroup.add(r3);
	typegroup.add(r4);
	
	JLabel card=new JLabel("Card Number");
	card.setBounds(100, 260, 200, 30);
	card.setFont(new Font("Raleway",Font.BOLD,20));
	add(card);
	JLabel cdetails=new JLabel("Your 16 Digit Card Number");
	cdetails.setBounds(100, 290, 200, 20);
	cdetails.setFont(new Font("Raleway",Font.ITALIC,12));
	add(cdetails);
	
	JLabel number=new JLabel("XXXX-XXXX-XXXX-1234");
	number.setBounds(320, 260, 220, 30);
	number.setFont(new Font("Raleway",Font.BOLD,18));
	add(number);
	
	JLabel pin=new JLabel("PIN");
	pin.setBounds(100, 330, 200, 30);
	pin.setFont(new Font("Raleway",Font.BOLD,20));
	add(pin);
	JLabel pdetails=new JLabel("Your 4 digit Pin");
	pdetails.setBounds(100, 350, 200, 20);
	pdetails.setFont(new Font("Raleway",Font.ITALIC,12));
	add(pdetails);
	
	JLabel pnumber=new JLabel("XXXX");
	pnumber.setBounds(320, 330, 220, 30);
	pnumber.setFont(new Font("Raleway",Font.BOLD,18));
	add(pnumber);
	
	JLabel services=new JLabel("Services Required");
	services.setBounds(100, 390, 200, 20);
	services.setFont(new Font("Raleway",Font.BOLD,20));
	add(services);
	
	c1=new JCheckBox("ATM CARD");
	c1.setBounds(100,430,200,16);
	c1.setFont(new Font("Raleway",Font.BOLD,12));
	c1.setBackground(Color.WHITE);
	add(c1);
	

	c2=new JCheckBox("Internet Banking");
	c2.setBounds(320,430,200,16);
	c2.setFont(new Font("Raleway",Font.BOLD,12));
	c2.setBackground(Color.WHITE);
	add(c2);
	

	c3=new JCheckBox("Mobile Banking");
	c3.setBounds(100,470,200,16);
	c3.setFont(new Font("Raleway",Font.BOLD,12));
	c3.setBackground(Color.WHITE);
	add(c3);
	

	c4=new JCheckBox("Email and SMS Alert");
	c4.setBounds(320,470,200,16);
	c4.setFont(new Font("Raleway",Font.BOLD,12));
	c4.setBackground(Color.WHITE);
	add(c4);
	

	c5=new JCheckBox("Cheque Book");
	c5.setBounds(100,510,200,16);
	c5.setFont(new Font("Raleway",Font.BOLD,12));
	c5.setBackground(Color.WHITE);
	add(c5);
	

	c6=new JCheckBox("E-Statement");
	c6.setBounds(320,510,200,16);
	c6.setFont(new Font("Raleway",Font.BOLD,12));
	c6.setBackground(Color.WHITE);
	add(c6);
	
	c7=new JCheckBox("I hereby Declare That above filled details are True To The Best Of My Knoweledge");
	c7.setBounds(100,570,500,16);
	c7.setFont(new Font("Raleway",Font.BOLD,12));
	c7.setBackground(Color.WHITE);
	add(c7);
	
	submit=new JButton("Submit");
	submit.setBounds(500, 610, 150, 30);
	submit.setBackground(Color.BLACK);
	submit.setForeground(Color.WHITE);
	submit.addActionListener(this);
    add(submit);	
    
    clear=new JButton("Clear");
    clear.setBounds(100, 610, 150, 30);
    clear.setBackground(Color.BLACK);
    clear.setForeground(Color.WHITE);
    clear.addActionListener(this);
    add(clear);
	
	
	
	
	
	
	
	setSize(850,820);
	setLocation(350,0);
	setVisible(true);
	
	
	
	
	
	}
	 public void actionPerformed(ActionEvent ae) {
		 if(ae.getSource()==submit) {
			 String type=null;
			 if(r1.isSelected()) {
				 type="Saving Account";
			 }else if(r2.isSelected()) {
				 type="Fixed Deposit";
			 }else if(r3.isSelected()) {
				 type="Current Account";
			 }else if(r4.isSelected()) {
				 type="Deposit Account";
			 }
			 
			 Random random=new Random();
			 String cardnumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
			 String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
		
			 String services="";
			 if(c1.isSelected()) {
				 services=services+"ATM CARD";
			 }else if(c2.isSelected()) {
				 services=services+"Internet Banking";
			 }else if(c3.isSelected()) {
				 services=services+"Mobile Banking";
			 }else if(c4.isSelected()) {
				 services=services+"Email and SMS Alert";
			 }else if(c5.isSelected()) {
				 services=services+"Cheque Book";
			 }else if(c6.isSelected()) {
				 services=services+"E Statement";
			 }
			 
			 try {
				 
				 Conn c=new Conn();
				 String query1="insert into SignUpThree values('"+formno+"','"+type+"','"+cardnumber+"','"+pinnumber+"','"+services+"')";
				 c.s.executeUpdate(query1);
				 String query2 ="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
				 c.s.executeUpdate(query2);
				 
				 JOptionPane.showMessageDialog(null, "Card Number:"+cardnumber+"\n Pin:"+pinnumber);
				 
			 }catch(Exception e) {
				 System.out.println(e);
			 }
		
			 
		 }else if(ae.getSource()==clear) {
			 setVisible(false);
			 new login().setVisible(true);
		 }
		 
	 }



	public static void main(String[] args) {
		new SignUpThree("");
		

	}

}
