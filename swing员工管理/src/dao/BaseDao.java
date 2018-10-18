package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Department;
import entity.Project;
import entity.Student;

public class BaseDao {
	

	Student emp = new Student();
	String b[] = new String[100];
	String name[];
	String sex[];
	String age[];
	ResultSet rs=null;
	Statement stata=null;
	Connection conn=null;

	public void getDao() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root",
					"123");
			stata = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

	}
	public void closeAll(ResultSet rs, Statement stata, Connection conn) {

		try {
			if (rs != null) {

				rs.close();
			}

			if (stata != null) {
				stata.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
