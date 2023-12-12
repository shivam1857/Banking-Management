package bankManagementSystem;
import java.sql.*;
public class Conn {
	Connection c;
	Statement s;
  public Conn(){
	   try{
		   
		   c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bankmanagementsystem","root","2001");
		   s=c.createStatement();
	   }catch(Exception e){
		   System.out.println(e);
	   }
   }
}
