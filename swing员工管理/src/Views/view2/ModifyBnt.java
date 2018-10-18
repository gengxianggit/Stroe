package Views.view2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import dao.DepartmentDao;
import entity.Department;
import entity.Student;
import util.CallBack;

public class ModifyBnt extends DeSuperView {
	CallBack callBack;
	Department dep = new Department();
	private static   ModifyBnt instance;

	public ModifyBnt( Department dep, CallBack callBack) {
		this.callBack = callBack;
		this.dep = dep;
	}	
	

	public void init() {
	      super.init();
		bnt.setText("修改");
		nameText.setText(dep.getName());
		
		bnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
				String 	name=nameText.getText();
				   dep.setName(name);
			String sql="update  department  set name='" + dep.getName() + "'where id=" + dep.getId();
				 new DepartmentDao().update(sql);
					callBack.call();
					frame.dispose();
				} catch (NumberFormatException e1) {
					
					JOptionPane.showMessageDialog(null, "请输入完整数据");
				}
         frame.dispose();
			}
		});
		frame.setVisible(true);

	}

}
