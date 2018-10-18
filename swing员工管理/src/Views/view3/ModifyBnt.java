package Views.view3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.ProjectDao;
import entity.Project;
import util.CallBack;

public class ModifyBnt extends DeSuperView {
	CallBack callBack;
	Project pro = new Project();

	public ModifyBnt( Project pro, CallBack callBack) {
		this.callBack = callBack;
		this.pro = pro;
	}

	public void init() {
	      super.init();
		bnt.setText("修改");
		nameText.setText(pro.getName());
		
		bnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
				String 	name=nameText.getText();
				   pro.setName(name);
			String sql="update  project  set name='" + pro.getName() + "'where id=" + pro.getId();
				 new ProjectDao().update(sql);
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
