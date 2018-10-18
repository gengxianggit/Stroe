package Views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
import dao.StudentDao;
import entity.Department;
import entity.Student;
import util.CallBack;

public class StudentVision {
	JTable table;
	StudentTableModel model;
	List<Student> list = new ArrayList();

	List<Department> depList = new ArrayList();

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
		nameText.setPreferredSize(new Dimension(50, 30));
		panel1.add(nameText);
		JLabel sexLabel = new JLabel("性别");
		panel1.add(sexLabel);
		JComboBox sexBox=new JComboBox<>();
		sexBox.addItem("-");
		sexBox.addItem("男");
		
		sexBox.addItem("女");
		sexBox.setPreferredSize(new Dimension(50, 30));
		panel1.add(sexBox);
		JLabel ageLabel = new JLabel("年龄");
		panel1.add(ageLabel);

		JTextField ageText = new JTextField();
		ageText.setPreferredSize(new Dimension(50, 30));
		panel1.add(ageText);

		JComboBox deBox = new JComboBox();
		depList = new DepartmentDao().search();
		deBox.addItem("請選擇部門");

		for (int i = 0; i < depList.size(); i++) {

			deBox.addItem(depList.get(i).getName());

		}
		deBox.addItem("請選擇部門");

		panel1.add(deBox);
		JButton searchBnt = new JButton("搜索");
		panel1.add(searchBnt);
		// StudentDao dao=new StudentDao();
		list = new StudentDao().search();
		
		model = new StudentTableModel(list);
		table = new JTable();
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(300, 200));
		panel2.add(scroll);

		searchBnt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String name = nameText.getText();
				String sex = (String)sexBox.getSelectedItem();
			
				int age;
				if (ageText.getText().equals(""))
					age = -1;
				else {
					age = Integer.parseInt(ageText.getText());
				}
				int indenx = deBox.getSelectedIndex();
				Department dep = new Department();
				Student emp = new Student();
				if (indenx == 0) {
					dep.setId(-1);
				} else {
					List<Department> depList = new ArrayList();
					depList = new DepartmentDao().search();
					dep = depList.get(indenx - 1);
				}
				emp.setAge(age);
				emp.setDep(dep);
				emp.setSex(sex);
				emp.setName(name);
				
				list = new StudentDao().select1(emp);

				model.setList(list);
				table.updateUI();

			}
		});

		JButton addBnt = new JButton("添加");
		panel3.add(addBnt);

		addBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent f) {
				// TODO Auto-generated method stub
				AddBnt avg = AddBnt.getInstance(new CallBack() {
					public void call() {
						
						refreshTable();
					}
				});
				avg.opWindow();
			}
		});
		JButton modifyBnt = new JButton("修改");
		panel3.add(modifyBnt);
		modifyBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectIndex = table.getSelectedRow();

				if (selectIndex > -1) {
					Student emp = new Student();
					 emp = list.get(selectIndex);
						 new ModifyBnt (emp, new CallBack() {
						public void call() {
							refreshTable();
						}
					}).init();
					
				} else {
					JOptionPane.showMessageDialog(null, "Please select");
				}

			}
		});
		JButton deleteBnt = new JButton("刪除");
		panel3.add(deleteBnt);
		deleteBnt.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				int[] a = table.getSelectedRows();
				if (a.length > 0) {
					int option = JOptionPane.showConfirmDialog(null, "是否删除", "删除", 0);
					if (option == 0) {

						if (a.length > 0) {
							for (int i = 0; i <= a.length - 1; i++) {
								Student emp = new Student();
								emp = list.get(a[i]);
								new StudentDao().delete(emp.getId());
								
							

							}
							refreshTable();
							table.clearSelection();
							JOptionPane.showMessageDialog(null,"删除成功");
						}

						

					}
				
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select");
				}
			}
		});
		frame.setVisible(true);
	}

	public void refreshTable() {
		list = new StudentDao().search();
		model.setList(list);
		table.updateUI();

	}

}
