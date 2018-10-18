package Views.view2;

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


import Views.view2.manageProject.Projection2DpartmentVision;
import dao.DepartmentDao;
import entity.Department;
import util.CallBack;

public class DepartmentVision {
	JTable table;
	DeparetmentTableModel model;
	List<Department> depList;



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
		JLabel nameLabel = new JLabel("部门");
		panel1.add(nameLabel);
		JTextField nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(50, 30));
		panel1.add(nameText);
		JLabel numLabel = new JLabel("个数");
		panel1.add(numLabel);
		JTextField numText = new JTextField();
		numText.setPreferredSize(new Dimension(50, 30));
		panel1.add(numText);

		JButton searchBnt = new JButton("搜索");
		panel1.add(searchBnt);

		depList = new DepartmentDao().search();
	
		model = new DeparetmentTableModel(depList); 
		table = new JTable();
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(300, 200));
		panel2.add(scroll);

		searchBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = null;
				int num;

				if (numText.getText().equals(""))
					num = -1;
				else
					num = Integer.parseInt(numText.getText());

				String name = nameText.getText();
				String where = "where 1=1";
				if (!name.equals(""))
					where += " " + "and  name='" + name + "'";
				if (num != -1)
					where += " " + "and  num=" + num;
				sql = "select * from department" + " " + where;

				depList = new DepartmentDao().select1(sql);
				

				model.setList(depList);

				table.updateUI();

			}
		});

		JButton addBnt = new JButton("添加");
		panel3.add(addBnt);
		searchBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		////
		addBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent f) {
				
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
					Department dep = new Department();
					dep = depList.get(selectIndex);
					new  ModifyBnt(dep, new CallBack() {
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
							for (int i = 0; i < a.length; i++) {
								Department dep = new Department();
								dep = depList.get(a[i]);

								new DepartmentDao().delete(dep);
							

							}
						}	
						table.clearSelection();
						refreshTable();
						JOptionPane.showMessageDialog(null,"删除成功");
						

					}
				} else {
					JOptionPane.showMessageDialog(null, "Please select");
				}
			}
		});
		JButton managnerBnt = new JButton("项目管理");
		panel3.add(managnerBnt);

		managnerBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();

				if (index > -1) {
					Department dep = depList.get(index);

					Projection2DpartmentVision avg = new Projection2DpartmentVision(dep);

					avg.init();

				} else {
					JOptionPane.showMessageDialog(null, "请选中");
				}
			}
		});
		frame.setVisible(true);
	}

	public void refreshTable() {
		depList = new DepartmentDao().search();
		model.setList(depList);
		table.updateUI();

	}

}
