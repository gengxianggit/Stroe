package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) {
		//2.利用反射加载数据库驱动
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//3.建立连接
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8","root","123");
			//建 statement sql语句执行器
				Statement stat= conn.createStatement();
				//执行sql语句并得到结果
	 int rs=stat.executeUpdate("update employee set name='大佬憋',sex='男',age=1000,e_id=2 where id=1");
			//对结果集处理
				if(rs>0) {
			
					System.out.println("save");
				}
				else
				System.out.println("gg");
				//7.关闭
				
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
