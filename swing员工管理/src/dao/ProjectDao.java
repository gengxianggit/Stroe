package dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import entity.Project;

public class ProjectDao extends BaseDao {

	List<Project>proList = new ArrayList();
	
	public List<Project> search() {
		getDao();

		try {
			rs = stata.executeQuery("select * from project");

			while (rs.next()) {
				Project pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				
				proList.add(pro);

			}
		} catch (SQLException e) {

		} finally {
			closeAll(rs, stata, conn);
		}

		return proList;

	}

	public boolean add(Project pro) {
		boolean flag = false;

		getDao();
		

		try {
			int rs = stata.executeUpdate("insert into project (name) values ('" + pro.getName() + "')");
					
			if (rs > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, stata, conn);
		}

		return flag;

	}

	public boolean update(String sql) {
		// 2.利用反射加载数据库驱动
		boolean flag = false;
		getDao();

		try {
			int rs = stata.executeUpdate(sql);
   
			if (rs > 0) {
				flag = true;
			}

			// 7.关闭

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, stata, conn);
		}
		return flag;

	}

	public void delete( Project pro) {
		getDao();
		try {
			int rs = stata.executeUpdate("delete from project where id=" + pro.getId());
			int ra = stata.executeUpdate("delete from relation  where id=" + pro.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, stata, conn);
		}

	}

	public List<Project> select1(String sql) {
		getDao();

		try {
			
				 rs = stata.executeQuery(sql);
			while (rs.next()) {
				Project pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				
				proList.add(pro);
			}

		} catch (SQLException e) {

		} finally {
			closeAll(rs, stata, conn);
		}

		return proList;

	}

	
}
