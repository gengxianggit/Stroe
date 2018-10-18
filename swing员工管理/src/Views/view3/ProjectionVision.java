package Views.view3;

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

import dao.ProjectDao;
import entity.Project;
import util.CallBack;

public class ProjectionVision {
	JTable table;
	ProjectTableModel model;
	List<Project> proList = new ArrayList();

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
		JLabel nameLabel = new JLabel("ÏîÄ¿");
		panel1.add(nameLabel);
		JTextField nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(50, 30));
		panel1.add(nameText);

		JButton searchBnt = new JButton("ËÑË÷");
		panel1.add(searchBnt);

		proList = new ProjectDao().search();
		model = new ProjectTableModel(proList);
		table = new JTable();
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(300, 200));
		panel2.add(scroll);

		searchBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = null;

				Project pro = new Project();

				String name = nameText.getText();

				if (!name.equals(""))

					sql = "select * from project  where  name='" + name + "'";
				else {
					sql="select * from project";
					
				}

				proList = new ProjectDao().select1(sql);

				model.setList(proList);
				table.updateUI();

			}
		});

		JButton addBnt = new JButton("Ìí¼Ó");
		panel3.add(addBnt);

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
		JButton modifyBnt = new JButton("ÐÞ¸Ä");
		panel3.add(modifyBnt);
		modifyBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectIndex = table.getSelectedRow();

				if (selectIndex > -1) {
					Project pro = new Project();
					pro = proList.get(selectIndex);
					new ModifyBnt(pro, new CallBack() {
						public void call() {
							refreshTable();
						}
					}).init();
				} else {
					JOptionPane.showMessageDialog(null, "Please select");
				}

			}
		});
		JButton deleteBnt = new JButton("„h³ý");
		panel3.add(deleteBnt);
		deleteBnt.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				int[] a = table.getSelectedRows();
				List<Project> proList = new ProjectDao().search();
				if (a.length > 0) {
					int option = JOptionPane.showConfirmDialog(null, "ÊÇ·ñÉ¾³ý", "É¾³ý", 0);
					if (option == 0) {

						if (a.length > 0) {
							for (int i = 0; i <= a.length - 1; i++) {
								Project pro = new Project();
								pro = proList.get(a[i]);
								new ProjectDao().delete(pro);
								
							}
						}
						table.clearSelection();
						refreshTable();
           JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦");

					}
				} else {
					JOptionPane.showMessageDialog(null, "Please select");
				}
				
			}
		});

		frame.setVisible(true);
	}

	public void refreshTable() {
		proList = new ProjectDao().search();
		model.setList(proList);
		table.updateUI();

	}

}
