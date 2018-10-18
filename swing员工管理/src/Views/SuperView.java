package Views;



import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.DepartmentDao;
import entity.Department;

public class SuperView {
	
	JTextField ageText;
	JTextField nameText;
	JComboBox sexBox;
	JComboBox deBox;
	 JFrame frame;
    JButton bnt; 
    Department dep;
 	List<Department>depList;

	public void init() {
		   
		
	    frame = new JFrame();
        
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(1);
		frame.setLocationRelativeTo(null);
		JPanel mainpanel = (JPanel) frame.getContentPane();
		mainpanel.setLayout(new BoxLayout(mainpanel, 1));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		mainpanel.add(panel1);
		mainpanel.add(panel2);
		mainpanel.add(panel3);
		mainpanel.add(panel4);
		mainpanel.add(panel5);
		JLabel nameLabel = new JLabel("姓名");
		panel1.add(nameLabel);
		 nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(50, 30));
		panel1.add(nameText);
		JLabel sexLabel = new JLabel("性別");
		panel2.add(sexLabel);
		sexBox = new JComboBox();
		sexBox.addItem("男");
		sexBox.addItem("女");
		panel2.add(sexBox);
		JLabel ageLabel = new JLabel("年龄");
		panel3.add(ageLabel);
		 ageText = new JTextField();
		ageText.setPreferredSize(new Dimension(50, 30));
		panel3.add(ageText);
		bnt=new JButton();
		panel5.add(bnt);
		JLabel depLabel=new JLabel("部门");
		 deBox = new JComboBox();
		   List<Department>list=new DepartmentDao().search();
		
		   for(int i=0;i<list.size();i++)
		 {deBox.addItem(list.get(i).getName());
			 
		 }
		  			panel4.add(deBox);

}}
