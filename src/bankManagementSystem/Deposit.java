package bankManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
	JTextField amount;
	JButton submit;
	JButton back;
	String pinnumber;
	Deposit(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg")); 
		Image i2=i1.getImage().getScaledInstance(850, 850,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 850, 850);
		add(image);
		
		JLabel text=new JLabel("Enter The Amount You Want To Deposit");
		text.setBounds(150, 280, 600, 20);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,15));
		image.add(text);
		
		amount=new JTextField();
		amount.setBounds(150, 320, 340, 20);
		image.add(amount);
		
		submit=new JButton("Submit");
		submit.setBounds(330, 460, 150, 25);
		submit.addActionListener(this);
		image.add(submit);
		
		back=new JButton("Back");
		back.setBounds(330, 495, 150, 25);
		back.addActionListener(this);
		image.add(back);
		
		
		
		
		
		setSize(850,850);
		setLocation(350,0);
	   //setUndecorated(true);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			String amountnumber=amount.getText();
			Date date=new Date();
			if(amountnumber.equals("")) {
				JOptionPane.showMessageDialog(null,"Please Enter the Amount");
				
			}else {
				try {
					Conn c=new Conn();
					String query="insert into bank values('"+pinnumber+"','"+date+"','"+amountnumber+"','Deposit')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rupees"+amountnumber+"Deposited Successfully");
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			
		}else if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		new Deposit("");

	}

}
