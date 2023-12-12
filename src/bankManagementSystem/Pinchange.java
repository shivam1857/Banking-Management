package bankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
	JTextField npintext,rpintext;
	JButton change,back;
	String pinnumber;
	
	Pinchange(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 850, 850);
		add(image);
		
		JLabel text=new JLabel("Pin Change");
		text.setBounds(260, 280, 700, 25);
		text.setFont(new Font("Raleway",Font.BOLD,15));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		JLabel npin=new JLabel("Enter New PIN");
		npin.setBounds(160, 350, 200, 20);
		npin.setFont(new Font("Raleway",Font.BOLD,15));
		npin.setForeground(Color.WHITE);
		image.add(npin);
		
		npintext=new JTextField();
		npintext.setBounds(280, 350, 200, 20);
		image.add(npintext);
		
		JLabel rpin =new JLabel("ReEnter the PIN");
		rpin.setBounds(160, 400, 200, 20);
		rpin.setFont(new Font("Raleway",Font.BOLD,15));
		rpin.setForeground(Color.WHITE);
		image.add(rpin);
		
		rpintext=new JTextField();
		rpintext.setBounds(280, 400, 200, 20);
		image.add(rpintext);
		
		change=new JButton("CHANGE");
		change.setForeground(Color.BLACK);
		change.setBounds(370, 460, 120, 25);
		change.addActionListener(this);
		image.add(change);
		
		back=new JButton("BACK");
		back.setForeground(Color.BLACK);
		back.setBounds(370, 490, 120, 25);
		back.addActionListener(this);
		image.add(back);
		
		
			
		
		
		
		setSize(850,850);
		setLocation(350,0);
	//	setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
		try {
			String npin=npintext.getText();
			String rpin=rpintext.getText();
			
			
			    if(!rpin.equals(npin)) {
				  JOptionPane.showMessageDialog(null,"Values are not Same");
				  return;
				
		    	}
			Conn c=new Conn();
			String q1="update bank set pinnumber= '"+npin+"' where pinnumber='"+pinnumber+"'";
			String q2="update login set pinnumber= '"+npin+"' where pinnumber='"+pinnumber+"'";
			String q3="update signupthree set pinnumber= '"+npin+"' where pinnumber='"+pinnumber+"'";
			c.s.executeUpdate(q1);
			c.s.executeUpdate(q2);
			c.s.executeUpdate(q3);
			JOptionPane.showMessageDialog(null, "Pin Changed Success");
			
		  }catch(Exception e) {
			System.out.println(e);
		    }
		}else if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
      
	public static void main(String[] args) {
		new Pinchange("");

	}

}
