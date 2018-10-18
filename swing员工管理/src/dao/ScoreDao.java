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
import java.util.Set;

import javax.swing.text.AttributeSet.ParagraphAttribute;

import com.mysql.jdbc.PreparedStatement;

import entity.Department;
import entity.Project;
import entity.Score;
import entity.Student;

public class ScoreDao extends BaseDao {

	public List<Score> search() {
		List<Score> scList = new ArrayList();
		getDao();
		try {
			rs = stata.executeQuery("select * from sumview");
			while (rs.next()) {

				Score sc = new Score();

				sc.setId(rs.getInt("sid"));

				sc.setGrade(rs.getString("grade"));

				sc.setValue((Integer) (rs.getObject("value")));
				Student emp = new Student();
				emp.setId(rs.getInt("eid"));
				emp.setName(rs.getString("ename"));
				Department dep = new Department();
				dep.setName(rs.getString("dname"));
		         dep.setId(rs.getInt("did"));
				emp.setDep(dep);
				sc.setEmp(emp);

				Project pro = new Project();
			 pro.setId(rs.getInt("pid"));
				pro.setName(rs.getString("pname"));
				sc.setPro(pro);

				scList.add(sc);

			}
		} catch (SQLException e) {

		} finally {
			closeAll(rs, stata, conn);
		}

		return scList;

	}

	public void add(Score sc) {
		getDao();
		String sql = "insert into score  (e_id,R_id,value) values" + "(" + sc.getEmp().getId() + ","
				+ sc.getPro().getId() + "," + sc.getValue() + ")";

		try {
			int rs = stata.executeUpdate(sql);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, stata, conn);
		}

	}

	public List<Score> searchScore(Score sc) {
		getDao();
		List<Score> scList = new ArrayList();
		try {

			String sql = null;
			String where = "having 1=1" + " ";
			sql = "select * from sumview ";
			if (!sc.getEmp().getName().equals(""))
				where += " " + "and ename='" + sc.getEmp().getName() + "'";
			if (!sc.getEmp().getDep().getName().equals(""))
				where += " " + "and dname='" + sc.getEmp().getDep().getName() + "'";
			if (!sc.getPro().getName().equals("  ")) {
				where += " " + " and pname ='" + sc.getPro().getName() + "'";
			}
			if (sc.getValue() != -1) {
				where += " " + "and value=" + sc.getValue();
			}
			if (!sc.getGrade().equals("")) {
				where += " " + "and grade ='" + sc.getGrade() + "'";
			}

			sql = sql + where;
			
			

			rs = stata.executeQuery(sql);
			while (rs.next()) {
				Score sc1 = new Score();
				sc1.setId(rs.getInt("sid"));
				sc1.setGrade(rs.getString("grade"));
				sc1.setValue((Integer) (rs.getObject("value")));
				Student emp = new Student();
				emp.setName(rs.getString("ename"));
				Department dep = new Department();
				dep.setName(rs.getString("dname"));
				emp.setDep(dep);
				sc1.setEmp(emp);

				Project pro = new Project();

				pro.setName(rs.getString("pname"));
				sc1.setPro(pro);

				scList.add(sc1);

			}

		} catch (SQLException e) {

		} finally {
			closeAll(rs, stata, conn);
		}

		return scList;

	}

	public void update(Score sc) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root",
					"123");

			String sql = "update score set value=" + sc.getValue() + " " + "where id=" + sc.getId();

			stata = conn.createStatement();
			int rs = stata.executeUpdate(sql);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public boolean save(Set<Score> set) {
		int rs = 0;

		for (Score sc : set) {
			if (sc.getId() == 0) {
				add(sc);

			} else {

				update(sc);
			}
		}
		return rs > 0;
	}

}
