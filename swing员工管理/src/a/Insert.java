package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert{
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
				int rs=stat.executeUpdate("insert into employee (name,sex ,age,e_id) values ('马可波罗','男',221,5) ");
			//对结果集处理
				if(rs>0) {
					System.out.println("保存成功");
				}				else
					System.out.println("保存失败");
					
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
