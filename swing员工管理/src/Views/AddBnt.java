
package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dao.DepartmentDao;
import dao.StudentDao;
import entity.Department;
import entity.Student;
import util.CallBack;

public class AddBnt extends SuperView{
CallBack callBack;
 private  static	AddBnt instance;
	
     
	   public AddBnt( CallBack callBack) {
		
		this.callBack = callBack;
	}
	   public  synchronized static  AddBnt getInstance( CallBack callBack) {
		   if(instance==null) {
			   instance=new AddBnt(callBack);
		   }
		   return instance;
	   }
	   
	   public void opWindow() {
		   if(frame==null) {
		      init();
		      }
		  else
			  { 
			  ageText.setText(null);
			   nameText.setText(null); 
			  frame.setVisible(true);
		   }
		   
		  
	   }
	public void init() {
		super.init();
		bnt.setText("保存");
		 bnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = nameText.getText();
					String sex = (String) sexBox.getSelectedItem();
					int indenx=deBox.getSelectedIndex();
				    depList=new DepartmentDao().search();
				    dep=depList.get(indenx);
					int age = Integer.parseInt(ageText.getText());
					Student emp = new Student();
					
					emp.setName(name);
					emp.setSex(sex);
					emp.setAge(age);
				     emp.setDep(dep);
					   boolean   flag=new StudentDao().add(emp);
					if(flag==true) {
						JOptionPane.showMessageDialog(null, "保存ok");
					}
					
					callBack.call();
					frame.dispose();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "请输入完整数据");
				}

			}
		});
		frame.setVisible(true);

	}
}
