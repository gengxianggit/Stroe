package score;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.DepartmentDao;
import dao.ProjectDao;
import dao.ScoreDao;
import dao.StudentDao;
import entity.Department;
import entity.Project;
import entity.Score;
import entity.Student;
import util.CallBack;

public class ScoreView {
	JTable table;
	ScoreTableModel model;
	List<Score> list = new ArrayList();
	List<Project> proList;
	List<Department>depList;
	
	public void init() {
		JFrame frame = new JFrame();
		frame.setSize(500, 400);
		
		frame.setLocationRelativeTo(null);
		JPanel mainpanel = (JPanel) frame.getContentPane();
		mainpanel.setLayout(new BoxLayout(mainpanel, 1));
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(1, 5, 5));
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel1.setLayout(new FlowLayout(1, 5, 5));
		mainpanel.add(panel1);
		mainpanel.add(panel2);
		mainpanel.add(panel3);
		JLabel nameLabel = new JLabel("姓名");
		panel1.add(nameLabel);
		JTextField nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(40, 30));
		panel1.add(nameText);
      
				
		JLabel departmentLabel = new JLabel("部门");
		panel1.add(departmentLabel);
		 JComboBox depBox=new JComboBox<>();
	       depList=new DepartmentDao().search();
	       depBox.addItem("");
	       for(int i=0;i<depList.size();i++)
	       {
	    	 depBox.addItem(depList.get(i).getName());  
	       }
	       depBox.setPreferredSize(new Dimension(40, 30));
	     	panel1.add(depBox);
		
		JLabel projectLabel = new JLabel("项目");
		panel1.add(projectLabel);
		 JComboBox proBox=new JComboBox<>();
		 proList=new ProjectDao().search();
		 proBox.addItem("  ");
	       for(int i=0;i<proList.size();i++)
	       {
	    	 proBox.addItem(proList.get(i).getName());  
	       }
	      proBox.setPreferredSize(new Dimension(40, 30));
	     	panel1.add(proBox);
		
		JLabel valueLabel = new JLabel("成绩");
		panel1.add(valueLabel);
		JTextField valueText = new JTextField();
		valueText.setPreferredSize(new Dimension(40, 30));
		panel1.add(valueText);

		JLabel gradeLabel = new JLabel("等级");
		panel1.add(gradeLabel);
		 JComboBox gradeBox=new JComboBox<>();
		 gradeBox.addItem("");
		 gradeBox.addItem("优秀");
		 gradeBox.addItem("良好");
		 gradeBox.addItem("一般");
		 gradeBox.addItem("及格");
		 gradeBox.addItem("不及格");
		 gradeBox.setPreferredSize(new Dimension(40, 30));
		panel1.add(gradeBox);

		JButton searchBnt = new JButton("搜索");
		panel1.add(searchBnt);

		  list = new ScoreDao().search();
		model = new ScoreTableModel(list);
		table = new JTable();
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(300, 200));

		panel2.add(scroll);
	searchBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String ename = nameText.getText();
				String dname =(String) depBox.getSelectedItem();
				String pname = (String) proBox.getSelectedItem();
				String grade = (String) gradeBox.getSelectedItem();
				int value;
				if (valueText.getText().equals("")) {
					value = -1;
				} else {
					value = Integer.parseInt(valueText.getText());
				}
				Score sc = new Score();
				Student emp=new Student();
				emp.setName(ename);
				Department dep=new Department();
				dep.setName(dname);
				emp.setDep(dep);
				Project pro=new Project();
				pro.setName(pname);
				sc.setEmp(emp);
				sc.setGrade(grade);
				sc.setPro(pro);
				sc.setValue(value);
				

				list = new ScoreDao().searchScore(sc);
				
				model.setList(list);
				table.updateUI();

			}
		});
		JButton saveBnt = new JButton("保存");
		
		panel3.add(saveBnt );
		saveBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Set<Score>set=model.getSet();
			
				 new ScoreDao().save(set);
				 refreshTable();
				 set.clear();
				
			}
		});

		frame.setVisible(true);

	}

	public void refreshTable() {
		list = new ScoreDao().search();
		model.setList(list);
		table.updateUI();

	}/* 该表用的更新 */

}
