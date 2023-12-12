package bankManagementSystem;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener {
       /**
	 * Bank Management 
	 */
	JButton login,signup,clear;
	JTextField cardtext;
	JPasswordField pintext;
	private static final long serialVersionUID = 1L;
	login(){
    	   
    	   setTitle("ATM");
    	   setLayout(null);
    	   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
    	   Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    	   ImageIcon i3=new ImageIcon(i2);
    	   JLabel label=new JLabel(i3);
    	   label.setBounds(70, 10, 100, 100);
    	   add(label);
    	   
    	   setSize(900,480);
    	   setVisible(true);
    	   setLocation(300,200);
    	   getContentPane().setBackground(Color.blue);
    	   
    	   JLabel text=new JLabel("Welcome to ATM");
    	   text.setFont(new Font("Osward",Font.BOLD,28));
    	   text.setBounds(200, 40, 400, 40);
    	   
    	   add(text);
    	   
    	   JLabel card=new JLabel("Card No.");
    	   card.setFont(new Font("Osward",Font.BOLD,28));
    	   card.setBounds(120, 150, 150, 30);
    	   
    	   add(card);
    	   
    	   cardtext=new JTextField();
    	   cardtext.setBounds(300, 150, 250, 30);
    	   add(cardtext);
    	   
    	   JLabel pin=new JLabel("PIN");
    	   pin.setFont(new Font("Osward",Font.BOLD,28));
    	   pin.setBounds(120, 220, 250, 30);
    	   
    	   add(pin);
    	   
    	   pintext=new JPasswordField();
    	   pintext.setBounds(300, 220, 250, 30);
    	   add(pintext);
    	   
    	   login=new JButton("SIGN IN");
    	   login.setBounds(300, 300, 100, 30);
    	   login.setBackground(Color.black);
    	   login.setForeground(Color.white);
    	   login.addActionListener(this);
    	   add(login);
    	   

    	   clear=new JButton("CLEAR");
    	   clear.setBounds(430, 300, 100, 30);
    	   clear.setBackground(Color.black);
    	   clear.setForeground(Color.white);
    	   clear.addActionListener(this);
    	   add(clear);
    	   
    	   signup=new JButton("SIGN UP");
    	   signup.setBounds(300, 350, 230, 30);
    	   signup.setBackground(Color.black);
    	   signup.setForeground(Color.white);
    	   signup.addActionListener(this);
    	   add(signup);
    	   
    	   
    	   
       }
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==login) {
			Conn c=new Conn();
			
			String cardnumber=cardtext.getText();
			String pinnumber=pintext.getText();
			String query="select*from login where CardNumber='"+cardnumber+"'and pinnumber='"+pinnumber+"' ";
			try {
				ResultSet rs =c.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);;
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect CardNumber or Pin");
				}
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}else if(ae.getSource()==clear) {
			cardtext.setText("");
			pintext.setText("");
			
		}else if(ae.getSource()==signup) {
			setVisible(false);
			new signUp().setVisible(true);
			
		}
		
	}
	public static void main(String[] args) {
		
         new login();
	}

}
