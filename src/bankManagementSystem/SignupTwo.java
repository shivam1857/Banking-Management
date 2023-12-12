package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long random;
	JTextField Pantext,Aadhartext;
	JRadioButton yes1,no1,yes2,no2;
    JButton next;
    JComboBox religionbox,categorybox,educationbox,occupationbox;
    String formno;
	SignupTwo(String formno){
		this.formno=formno;
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
		setTitle("NEW APPLICATION FORM. PAGE 2");
	
		
		JLabel additional=new JLabel("Page 2:Additional Details");
		additional.setBounds(290, 80, 300, 30);
		additional.setFont(new Font("Raleway",Font.BOLD,18));
		add(additional);
		
		JLabel religion=new JLabel("Religion");
		religion.setBounds(100, 150, 100, 20);
		religion.setFont(new Font("Raleway",Font.BOLD,15));
		add(religion);
		
		String valReligion[]= {"Hindu","Islam","Buddhism","Sikhism","Christian"};
	    religionbox=new JComboBox(valReligion); 
	    religionbox.setBounds(300, 150, 200, 20);
	    religionbox.setBackground(Color.WHITE);
		add(religionbox);
		
		JLabel category=new JLabel("Category");
		category.setBounds(100, 190, 100, 20);
		category.setFont(new Font("Raleway",Font.BOLD,15));
		add(category);
		
		String valCategory[]= {"General","OBC","SC","ST"};
	    categorybox=new JComboBox(valCategory); 
	    categorybox.setBounds(300, 190, 200, 20);
	    categorybox.setBackground(Color.WHITE);
		add(categorybox);
		
	
 		JLabel education=new JLabel("Education");
 		education.setBounds(100, 270, 100, 20);
 		education.setFont(new Font("Raleway",Font.BOLD,15));
    	add(education);
		
    	String valEducation[]= {"10th","12th","Bachelor","Masters"};
    	educationbox=new JComboBox(valEducation);
    	educationbox.setBounds(300, 270, 200, 20);
    	educationbox.setBackground(Color.WHITE);
    	add(educationbox);
	
		
		JLabel occupation=new JLabel("Occupation");
		occupation.setBounds(100, 310, 150, 20);
		occupation.setFont(new Font("Raleway",Font.BOLD,15));
		add(occupation);
		
		String valOccupation[]= {"Salaried","Self-Employed","Business Man","Student","UnEmployed"};
		
		occupationbox=new JComboBox(valOccupation);
		occupationbox.setBounds(300, 310, 200, 20);
		occupationbox.setBackground(Color.WHITE);
		add(occupationbox);
		
		
	
		
		JLabel Pan=new JLabel("PAN NO.");
		Pan.setBounds(100, 350, 150, 20);
		Pan.setFont(new Font("Raleway",Font.BOLD,15));
		add(Pan);
		
		Pantext =new JTextField();
		Pantext.setBounds(300, 350, 200, 20);
		Pantext.setFont(new Font("Raleway",Font.BOLD,15));
		add(Pantext);
		
		JLabel Aadhar=new JLabel("Aadhar Number");
		Aadhar.setBounds(100, 390, 150, 20);
		Aadhar.setFont(new Font("Raleway",Font.BOLD,15));
		add(Aadhar);
		
		Aadhartext=new JTextField();
		Aadhartext.setBounds(300, 390, 200, 20);
		Aadhartext.setFont(new Font("Raleway",Font.BOLD,15));
		add(Aadhartext);
		
		JLabel senior=new JLabel("Senior Citizen");
		senior.setBounds(100, 430, 150, 20);
		senior.setFont(new Font("Raleway",Font.BOLD,15));
		add(senior);
		
	    yes1=new JRadioButton("Yes");
		yes1.setBounds(300, 430, 80, 20);
		yes1.setBackground(Color.WHITE);
		add(yes1);
		
		no1=new JRadioButton("No");
		no1.setBounds(400, 430, 80, 20);
		no1.setBackground(Color.WHITE);
		add(no1);
		
		ButtonGroup seniorgroup=new ButtonGroup();
		seniorgroup.add(no1);
		seniorgroup.add(yes1);
		
		
		JLabel existing=new JLabel("Existing Account");
		existing.setBounds(100, 470, 150, 20);
		existing.setFont(new Font("Raleway",Font.BOLD,15));
		add(existing);
		
		yes2=new JRadioButton("Yes");
		yes2.setBounds(300, 470, 80, 20);
		yes1.setBackground(Color.WHITE);
		add(yes2);
		
		no2=new JRadioButton("No");
		no2.setBounds(400, 470, 80, 20);
		no1.setBackground(Color.WHITE);
		add(no2);
		
		ButtonGroup existinggroup=new ButtonGroup();
		existinggroup.add(no2);
		existinggroup.add(yes2);
		

	
		
		next=new JButton("Next");
		next.setBounds(600, 510, 80, 30);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		add(next);
		next.addActionListener(this);
		
		
		
		
		
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		
		String sreligion=(String)religionbox.getSelectedItem();
		String scategory=(String)categorybox.getSelectedItem();
		String seducation=(String)educationbox.getSelectedItem();
		String soccupation=(String)occupationbox.getSelectedItem();
		String saadhar=Aadhartext.getText();
		String span=Pantext.getText();
		
		
		String seniorcitizen=null;
		if(yes1.isSelected()) {
			seniorcitizen="Yes";
			
		}else if(no1.isSelected()) {
			seniorcitizen="No";
		}
		
		String existingaccount=null;
		if(yes2.isSelected()) {
			existingaccount="Yes";
			
		}else if(no2.isSelected()) {
			existingaccount="No";
		}
		
		
		
		try{
			
			
	
			Conn c=new Conn();
			String query="insert into SignupTwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+seducation+"','"+soccupation+"','"+saadhar+"','"+span+"','"+seniorcitizen+"','"+existingaccount+"')";
			c.s.executeUpdate(query);
			
			setVisible(false);
			new SignUpThree(formno).setVisible(true);
		
			
			
		}catch(Exception e ) {
			System.out.println(e);
			
		}
		
		
	}

	public static void main(String[] args) {
	new SignupTwo("");

	}

}

