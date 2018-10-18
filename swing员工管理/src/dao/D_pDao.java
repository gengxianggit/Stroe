package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Department;
import entity.Project;

public class D_pDao extends BaseDao {
	List<Project> proList = new ArrayList();

	public List<Project> searchbyDepartment(int depId) {

	
		getDao();
		try {
			String sql = "select * from d_prelation where did=" + depId;
			rs = stata.executeQuery(sql);
			
		 	while (rs.next()) {
                Project pro=new Project();
				pro.setId((rs.getInt("pid")));
				pro.setName(rs.getString("pname"));

				proList.add(pro);

			}
		} catch (SQLException e) {

		} finally {
			closeAll(rs, stata, conn);
		}

		return proList;

	}

	public List<Project> searchbyNotDepartment(int id) {
		List<Project> proList = new ArrayList();
		getDao();
		String sql = "select * from project where id not in" + " (select  pid  from d_prelation where did=" + id + ")";
     
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

	public boolean add(int a, int b) {
	     int rs = 0;
		getDao();

		try {
			String sql ="insert into relation (id,d_id) values (" + a + "," + b + ")";
		
           rs=stata.executeUpdate(sql);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, stata, conn);
		}

		return rs>0;

	}

	public void delete(int a, int b) {
		getDao();
		try {
			int rs = stata.executeUpdate("delete from relation  where id=" + a + " " + "and d_id=" + b);
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, stata, conn);
		}

	}

}
