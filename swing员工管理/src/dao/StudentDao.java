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
import entity.Student;

public class StudentDao extends BaseDao {
	List<Student>list = new ArrayList();
	
	public List<Student> search() {
		getDao();
		

		try {
rs = stata.executeQuery("select e.*,d.name as dname ,num from employee as e left join department as d on e_id=d.id");
			while (rs.next()) {
				
				Student emp = new Student();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSex(rs.getString("sex"));
				emp.setAge(rs.getInt("age"));
				
				Department dep=new Department();
				
				dep.setId(rs.getInt("e_id"));
				
				dep.setName(rs.getString("dname"));
		        dep.setNum(rs.getInt("num"));
                emp.setDep(dep);
               
				list.add(emp);
			
			}
		} catch (SQLException e) {
		

		} finally {
			closeAll(rs, stata, conn);
		}

		return list;

	}

	public boolean add(Student emp) {
		boolean flag = false;

		getDao();

		try {
			String sql="insert into employee  (name,sex ,age,e_id) values ('" + emp.getName() + "','"
			
					+ emp.getSex() + "'," + emp.getAge() + "," + emp.getDep().getId() + ")";
          System.out.println(sql);			
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

	public boolean update(Student emp) {
		// 2.利用反射加载数据库驱动
		boolean flag = false;
		getDao();
		
		try {
		int	rs = stata.executeUpdate("update employee  set name='" + emp.getName() + "',sex='" + emp.getSex() + "',age="
					+ emp.getAge() + ",e_id=" +emp.getDep().getId()+" where id=" +emp.getId() );

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, stata, conn);
		}
		return flag;

	}

	public void delete(int a) {
		getDao();
		try {
			int rs = stata.executeUpdate("delete from employee where id=" + a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, stata, conn);
		}

	}

	public List<Student> select1( Student emp ) {
		getDao();

		try {  
			
			  String sql=null;
			   String where="having 1=1"+" ";
			   sql="select e.*,d.name as dname,d.id as did ,num from employee as e left join department as d on (e_id=d.id)  ";
			  if(!emp.getName().equals(""))
			where+= "    and name='"+emp.getName()+"'";
			 if(!emp.getSex().equals("-"))
				 where+="   and sex='"+emp.getSex()+"'";
			  if(emp.getAge()!=-1){
				  where+=" "+" and  age ="+emp.getAge();
			  }
			  if(emp.getDep().getId()!=-1)
			  {
				  where+=" "+"and e_id="+emp.getDep().getId();
			  }
			  
			sql=sql+where;
			
			
			rs = stata.executeQuery(sql);
			while (rs.next()) {
				Student emp1 = new Student();
				emp1.setId(rs.getInt("id"));
				emp1.setName(rs.getString("name"));
				emp1.setSex(rs.getString("sex"));
				emp1.setAge(rs.getInt("age"));
				Department dp=new Department();
				dp.setId(rs.getInt("did"));
			    dp.setName(rs.getString("dname"));
			    dp.setNum(rs.getInt("num"));
			     emp1.setDep(dp);
				list.add(emp1);
			}

		} catch (SQLException e) {
			
		} finally {
			closeAll(rs, stata, conn);
		}

		return list;

	}

	
}
