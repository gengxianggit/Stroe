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
import entity.Department;

public class DepartmentDao extends BaseDao{

	
	List<Department> depList = new ArrayList();
	
	

	public List<Department> search() {
		getDao();

		try {
			rs = stata.executeQuery("select * from department");

			while (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("id"));
				dep.setName(rs.getString("name"));
				dep.setNum(rs.getInt("num"));
				depList.add(dep);

			}
		} catch (SQLException e) {

		} finally {
			closeAll(rs, stata, conn);
		}

		return depList;

	}
	public List<Department> search1() {
		getDao();

		try {
			rs = stata.executeQuery("select d.*,p.name as pname,p.id as pid from department as d left join "
					+ " relation as r on (d.id=r.d_id)left join project as p on(r.id= p.id)");

			while (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("id"));
				dep.setName(rs.getString("name"));
				dep.setNum(rs.getInt("num"));
				Project pro=new Project();
				pro.setId(rs.getInt("pid"));
				pro.setName(rs.getString("pname"));
				dep.setPro(pro);
				depList.add(dep);

			}
		} catch (SQLException e) {

		} finally {
			closeAll(rs, stata, conn);
		}

		return depList;

	}


	public boolean add(Department dep) {
		boolean flag = false;

		getDao();
		

		try {
			String sql="insert into department (name,num) values ('" + dep.getName() + "',"+dep.getNum()+")";
			
			int rs = stata.executeUpdate(sql);
					
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

	public void delete( Department dep) {
		getDao();
		try {
			if (dep.getNum() != 0) {
				String sql = "update employee set e_id=" + null + "   " + "where E_id="
						+ dep.getId();
				int rs = stata.executeUpdate(sql);

			}
			int rs = stata.executeUpdate("delete from department where id=" + dep.getId());
			 int ra= stata.executeUpdate("delete from relation where d_id=" + dep.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, stata, conn);
		}

	}

	public List<Department> select1(String sql) {
		getDao();

		try {
		     rs = stata.executeQuery(sql);
			while (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("id"));
				dep.setName(rs.getString("name"));
				dep.setNum(rs.getInt("num"));
				depList.add(dep);
			
			}

		} catch (SQLException e) {

		} finally {
			closeAll(rs, stata, conn);
		}
		
		
		return depList;
		

	}

	
}
