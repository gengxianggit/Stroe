package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
	//1.在项目导入jar包
	public static void main(String[] args) {
	//2.利用反射加载数据库驱动
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//3.建立连接
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8","root","123");
		//建 statement sql语句执行器
			Statement stat= conn.createStatement();
			//执行sql语句并得到结果
			ResultSet rs=stat.executeQuery("select * from employee where name='小妹'and sex='女'and age=18 ");
		//对结果集处理
			while(rs.next()) {
				System.out.print(rs.getInt("id")+" ");
			    System.out.print(rs.getString("name")+" ");
			    System.out.print(rs.getString("sex")+" ");
			     System.out.println(rs.getInt("age"));
			}
			//7.关闭
			rs.close();
			stat.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
