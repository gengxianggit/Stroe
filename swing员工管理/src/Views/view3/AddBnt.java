
package Views.view3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.ProjectDao;
import entity.Project;
import util.CallBack;

public class AddBnt extends DeSuperView {

	CallBack callBack;
	private static AddBnt instance;

	public AddBnt(CallBack callBack) {

		this.callBack = callBack;
	}

	public synchronized static AddBnt getInstance(CallBack callBack) {
		if (instance == null) {
			instance = new AddBnt(callBack);
		}
		return instance;
	}

	public void opWindow() {
		if (frame == null) {
			init();
		} else {

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
					
					Project pro=new Project();
					pro.setName(name);
					boolean flag = new ProjectDao().add(pro);
					if (flag == true) {
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
