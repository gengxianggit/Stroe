package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.DepartmentDao;
import dao.StudentDao;
import entity.Student;
import util.CallBack;

public class ModifyBnt extends SuperView {
	CallBack callBack;
	int a;
	Student emp = new Student();
	private static ModifyBnt instance;

	public ModifyBnt( Student emp, CallBack callBack) {
		this.callBack = callBack;
		this.emp = emp;
	}
	
	   
	   
		   
	public void init() {
		
	      super.init();
		bnt.setText("修改");
		nameText.setText(emp.getName());
		sexBox.setSelectedItem(emp.getSex());
		deBox.setSelectedItem(emp.getDep().getName());
		ageText.setText(String.valueOf(emp.getAge()));
		bnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					

					String name = nameText.getText();
					String sex = (String) sexBox.getSelectedItem();
					int age = Integer.parseInt(ageText.getText());
					int indenx=deBox.getSelectedIndex();
				    depList=new DepartmentDao().search();
				    
					dep=depList.get(indenx);
					emp.setDep(dep);
					emp.setAge(age);
					emp.setName(name);
				     emp.setSex(sex);
				   String de = (String) deBox.getSelectedItem();
				 
					new StudentDao().update(emp);
					callBack.call();
					
					frame.dispose();
				} catch (NumberFormatException e1) {
					
					JOptionPane.showMessageDialog(null, "请输入完整数据");
				}
        
			}
		});
		frame.setVisible(true);

	}

}
