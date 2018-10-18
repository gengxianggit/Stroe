package Views.view2;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeSuperView {

	JTextField nameText;

	JFrame frame;
	JButton bnt;

	public void init() {

		frame = new JFrame();

		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(1);
		frame.setLocationRelativeTo(null);
		JPanel mainpanel = (JPanel) frame.getContentPane();
		mainpanel.setLayout(new BoxLayout(mainpanel, 1));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		mainpanel.add(panel1);
		mainpanel.add(panel2);
		
		JLabel nameLabel = new JLabel("≤ø√≈");
		panel1.add(nameLabel);
		nameText=new JTextField();
		nameText.setPreferredSize(new Dimension(50,30));
		panel1.add(nameText);
		bnt=new JButton();
		panel2.add(bnt);


	}
}
