package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class aepae {
 public static void main(String[] args) {
	

	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8","root","123");
		   String sql="delete from employee where name =?";
	      
			PreparedStatement pstate=conn.prepareStatement(sql);
		   pstate.setString(1,"…œµ•");
		   int rs=pstate.executeUpdate();
	     conn.close();
	     System.out.println(sql);
	   
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

	}
	}
}
