package bankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class signUp extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long random;
	JLabel formNo;
	JTextField nametext,Fnametext,Emailtext,Addresstext,Citytext,Statetext,pinCtext;
	JRadioButton male,female,married,other;
    JButton next;
	signUp(){
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
		Random ran =new Random();
	    random=Math.abs((ran.nextLong()%9000L)+1000L);
		formNo=new JLabel("APPLICATION FORM NO."+ random);
		formNo.setBounds(140, 20, 600, 40);
		formNo.setFont(new Font("Raleway",Font.BOLD,38));
		add(formNo);
		
		JLabel personal=new JLabel("Page 1:Personal Details");
		personal.setBounds(290, 80, 300, 30);
		personal.setFont(new Font("Raleway",Font.BOLD,18));
		add(personal);
		
		JLabel name=new JLabel("Name");
		name.setBounds(100, 150, 100, 20);
		name.setFont(new Font("Raleway",Font.BOLD,15));
		add(name);
		
	    nametext =new JTextField();
		nametext.setBounds(300, 150, 200, 20);
		nametext.setFont(new Font("Raleway",Font.BOLD,15));
		add(nametext);
		
		JLabel Fname=new JLabel("Father Name");
		Fname.setBounds(100, 190, 100, 20);
		Fname.setFont(new Font("Raleway",Font.BOLD,15));
		add(Fname);
		
		Fnametext =new JTextField();
		Fnametext.setBounds(300, 190, 200, 20);
		Fnametext.setFont(new Font("Raleway",Font.BOLD,15));
		add(Fnametext);
		
//		JLabel DOB=new JLabel("Date of Birth");
//		DOB.setBounds(100, 230, 100, 20);
//		DOB.setFont(new Font("Raleway",Font.BOLD,15));
//		add(DOB);
//		
 		JLabel Gender=new JLabel("Gender");
    	Gender.setBounds(100, 270, 100, 20);
    	Gender.setFont(new Font("Raleway",Font.BOLD,15));
    	add(Gender);
		
		male=new JRadioButton("Male");
		male.setBounds(300, 270, 70, 20);
		male.setBackground(Color.WHITE);
		add(male);
		

		female=new JRadioButton("Female");
		female.setBounds(400, 270, 70, 20);
		female.setBackground(Color.WHITE);
		add(female);
		
		// Grouping the male and Female Button Using ButtonGroup
		
		ButtonGroup genderGroup=new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		
		
		
		JLabel Email=new JLabel("Email Address");
		Email.setBounds(100, 310, 150, 20);
		Email.setFont(new Font("Raleway",Font.BOLD,15));
		add(Email);
		

		Emailtext =new JTextField();
		Emailtext.setBounds(300, 310, 200, 20);
		Emailtext.setFont(new Font("Raleway",Font.BOLD,15));
		add(Emailtext);
		
		JLabel Marital=new JLabel("Marital Status");
		Marital.setBounds(100, 350, 150, 20);
		Marital.setFont(new Font("Raleway",Font.BOLD,15));
		add(Marital);
		
		married=new JRadioButton("Married");
		married.setBounds(300, 350, 70, 20);
		married.setBackground(Color.WHITE);
		add(married);
		

		other=new JRadioButton("Other");
		other.setBounds(400, 350, 70, 20);
		other.setBackground(Color.WHITE);
		add(other);
		
		// Grouping the male and Female Button Using ButtonGroup
		
		ButtonGroup maritalGroup=new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(other);
		
		JLabel Address=new JLabel("Address");
		Address.setBounds(100, 390, 150, 20);
		Address.setFont(new Font("Raleway",Font.BOLD,15));
		add(Address);
		
		Addresstext =new JTextField();
		Addresstext.setBounds(300, 390, 200, 20);
		Addresstext.setFont(new Font("Raleway",Font.BOLD,15));
		add(Addresstext);
		
		JLabel City=new JLabel("City");
		City.setBounds(100, 430, 150, 20);
		City.setFont(new Font("Raleway",Font.BOLD,15));
		add(City);
		
		Citytext=new JTextField();
		Citytext.setBounds(300, 430, 200, 20);
		Citytext.setFont(new Font("Raleway",Font.BOLD,15));
		add(Citytext);
		
		JLabel State=new JLabel("State");
		State.setBounds(100, 470, 150, 20);
		State.setFont(new Font("Raleway",Font.BOLD,15));
		add(State);
		
		Statetext=new JTextField();
		Statetext.setBounds(300, 470, 200, 20);
		Statetext.setFont(new Font("Raleway",Font.BOLD,15));
		add(Statetext);
		
		
//		JLabel PinC=new JLabel("Pin Code");
//		PinC.setBounds(100, 510, 150, 20);
//		PinC.setFont(new Font("Raleway",Font.BOLD,15));
//		add(PinC);
//		
//
//		pinCtext=new JTextField();
//		pinCtext.setBounds(300, 510, 200, 20);
//		pinCtext.setFont(new Font("Raleway",Font.BOLD,15));
//		add(pinCtext);
		
		next=new JButton("Next");
		next.setBounds(600, 560, 80, 30);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		add(next);
		next.addActionListener(this);
		
		
		
		
		
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		String formno= ""+random;
		String name=nametext.getText();
		String Fname=Fnametext.getText();
		
		String gender=null;
		if(male.isSelected()) {
			gender="male";
		}else if(female.isSelected()) {
			gender="female";
		}
		String email=Emailtext.getText();
		
		String marital=null;
		if(married.isSelected()) {
			marital="married";
		}else if(other.isSelected()) {
			marital="other";
		}
		
		String Address=Addresstext.getText();
		String City=Citytext.getText();
		//String pinC=pinCtext.getText();
		String State=Statetext.getText();
		
		
		try{
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Fill all the required fields");
			}else {
			String query =	 "insert into signup values('"+formno+"','"+name+"','"+Fname+"','"+gender+"','"+email+"','"+marital+"','"+Address+"','"+City+"','"+State+"')";
	
			Conn c=new Conn();
			c.s.executeUpdate(query);
			
			setVisible(false);
			new SignupTwo(formno).setVisible(true);;
			}
			
		}catch(Exception e ) {
			System.out.println(e);
			
		}
		
		
	}

	public static void main(String[] args) {
	new signUp();

	}

}
