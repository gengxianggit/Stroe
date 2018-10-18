package Views.view2.manageProject;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import dao.D_pDao;
import dao.ProjectDao;
import entity.Department;
import entity.Project;
import util.CallBack;

public class Projection2DpartmentVision {
	JTable table;
	D_pDao dao=new D_pDao();
	Project2DepartmentTableModel model1;
	List<Project> proList;
	 List<Project> notProList;
	Department dep;
	 JComboBox proBox;
	public Projection2DpartmentVision (Department dep) {
		this.dep=dep;
	}
	

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
		JLabel nameLabel = new JLabel(dep.getName());
		nameLabel.setFont(new Font(null,Font.BOLD,20));
		panel1.add(nameLabel);
		
		
		
		proList = dao.searchbyDepartment(dep.getId());
		model1 = new Project2DepartmentTableModel(proList);
		
		table = new JTable();
		table.setModel(model1);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(300, 200));
		panel2.add(scroll);
          proBox=new JComboBox();
        
         notProList=dao.searchbyNotDepartment(dep.getId());
              for(int i=0;i<notProList.size();i++)
         {
        	 proBox.addItem(notProList.get(i).getName());
        	 
         }
         
         
         panel3.add(proBox);
		

		JButton addBnt = new JButton("ÃÌº”");
		panel3.add(addBnt);
		

		addBnt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index=proBox.getSelectedIndex();
				if(index!=-1) {
			   boolean flag=dao.add( notProList.get(index).getId(),dep.getId());
				}
				
			
			refreshTable();
			refresh();
				
				
			}
		});

		
			

	
		JButton deleteBnt = new JButton("Ñh≥˝");
		panel3.add(deleteBnt);
		deleteBnt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				  
				int  index=table.getSelectedRow();
				 
			  if(index>-1) 
				{
				  int a=proList.get(index).getId();
				  dao.delete(a,dep.getId());
				  table.clearSelection();
				  
				}
				else {
					JOptionPane.showMessageDialog(null, "’àﬂx÷–");
				}
				table.clearSelection();
			     refresh();
			     refreshTable();
				
			}
		});
	
		
		 
		frame.setVisible(true);
	}
	
	
	
	public void refreshTable() {
		proList = new D_pDao().searchbyDepartment(dep.getId());
		model1.setList(proList);
		table.updateUI();

	}
	public void refresh() {
		proBox.removeAllItems();
		notProList=dao.searchbyNotDepartment(dep.getId());
        for(int i=0;i<notProList.size();i++)
         {
        	 proBox.addItem(notProList.get(i).getName());
        	 
         }
		

	}

		}
