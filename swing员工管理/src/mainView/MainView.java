package mainView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Views.StudentVision;
import Views.view2.DepartmentVision;
import Views.view3.ProjectionVision;
import score.ScoreView;

public class MainView {
	public void init() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(3);
		frame.setSize(500, 300);
		frame.setLocationRelativeTo(null);
		JPanel mainpanel = (JPanel) frame.getContentPane();
		mainpanel.setLayout(new FlowLayout());
		JButton bnt1 = new JButton("学生管理");
		bnt1.setPreferredSize(new Dimension(200, 120));
		bnt1.setFont(new Font(null, Font.BOLD, 20));
		bnt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new StudentVision().init();

			}
		});
		JButton bnt2 = new JButton("部门管理");
		bnt2.setPreferredSize(new Dimension(200, 120));
		bnt2.setFont(new Font(null, Font.BOLD, 20));

		bnt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new DepartmentVision().init();

			}
		});

		JButton bnt3 = new JButton("项目管理");
		bnt3.setPreferredSize(new Dimension(200, 120));
		bnt3.setFont(new Font(null, Font.BOLD, 20));
		bnt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new ProjectionVision().init();

			}
		});
		JButton bnt4 = new JButton("绩效管理");
		bnt4.setPreferredSize(new Dimension(200, 120));
		bnt4.setFont(new Font(null, Font.BOLD, 20));
		bnt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				new ScoreView().init();

			}
		});
		mainpanel.add(bnt1);
		mainpanel.add(bnt2);
		mainpanel.add(bnt3);
		mainpanel.add(bnt4);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new MainView().init();
	}
}
