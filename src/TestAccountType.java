import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TestAccountType extends JFrame {
	private static final int ADMIN = 0;
	private static final int STUDENT = 0;
	private static final int STAFF = 0;

	public TestAccountType() {
		final int userAccntType = ADMIN;
		final String username = "Likun";
		final String password = "GoodLuck";
		final JPanel contentPane = new JPanel();
		final JComboBox comboBox = new JComboBox();
		final JButton ok = new JButton("OK");
		JLabel label = new JLabel("Account Type:");
		this.setTitle("Account Type");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 250, 100);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(label);
		comboBox.addItem("Admin");
		comboBox.addItem("Student");
		comboBox.addItem("Staff");
		contentPane.add(comboBox);
		contentPane.add(ok);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(ok)) {
					int accntType = comboBox.getSelectedIndex();
					String typedUserNm = "";
					String typedPassword = "";
					boolean loginUser = false;
					boolean loginPass = false;
					for (int i = 0; i < 3; i++) {
						typedUserNm = JOptionPane
								.showInputDialog("Enter Username:");
						if (null == typedUserNm) {
							break;
						}
						if (typedUserNm.equals(username)) {
							loginUser = true;
							if (accntType != userAccntType) {
								JOptionPane.showMessageDialog(null,
										"Accont type is not right!");
								break;
							}
							for (int j = 0; j < 3; j++) {
								typedPassword = JOptionPane
										.showInputDialog("Enter Password:");
								if (null == typedPassword) {
									break;
								}
								if (typedPassword.equals(password)) {

									switch (accntType) {
									case 0:
										JOptionPane.showMessageDialog(null,
												"Welcome Admin!");
										break;

									case 1:
										JOptionPane.showMessageDialog(null,
												"Welcome Student!");
										break;
									case 2:
										JOptionPane.showMessageDialog(null,
												"Welcome Staff!");
										break;
									default:
										break;
									}
									loginPass = true;
									break;
								}
							}
							if (null == typedPassword) {
								break;
							}
							if (!loginPass) {
								JOptionPane.showMessageDialog(null,
										"Contact Administrator");
							} else {
								break;
							}
						}
					}
					if (null != typedPassword && null != typedUserNm
							&& (!loginUser || !loginPass)) {
						JOptionPane.showMessageDialog(null,
								"Contact Administrator");
					}
					// System.exit(0);
				}
			}
		});

		this.setVisible(true);
	}

	public static void main(String[] args) {
		TestAccountType example = new TestAccountType();
	}
}

