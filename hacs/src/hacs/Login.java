package hacs;

import javax.swing.*;

import hacs.UserInfoItem.USER_TYPE;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * 
 *          Update to Java 8
 */

public class Login extends JDialog {

	boolean m_bExit = false;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JButton loginButton = new JButton();
	JButton buttonExit = new JButton();
	JTextField UserNameText = new JTextField();
	JPasswordField PasswordText = new JPasswordField();
	JRadioButton StudentRadio = new JRadioButton();
	JRadioButton InstructorRadio = new JRadioButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();

	private String userBox = null;
	private USER_TYPE userType = USER_TYPE.Student; // default to Student

	public Login() {
		try {
			jbInit();
			setSize(300, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		jLabel1.setText("UserName");
		jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
		jLabel2.setText("Password");
		jLabel2.setBounds(new Rectangle(23, 119, 80, 18));
		loginButton.setText("Login");
		loginButton.setBounds(new Rectangle(31, 212, 85, 28));
		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButton_actionPerformed(e);
			}
		});
		buttonExit.setText("Exit");
		buttonExit.setBounds(new Rectangle(180, 211, 97, 28));
		buttonExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonExit_actionPerformed(e);
			}
		});
		UserNameText.setBounds(new Rectangle(119, 52, 144, 22));
		PasswordText.setBounds(new Rectangle(118, 119, 147, 22));
		StudentRadio.setSelected(true);
		StudentRadio.setText("Student");
		StudentRadio.setBounds(new Rectangle(37, 164, 103, 26));
		InstructorRadio.setText("Instructor");
		InstructorRadio.setBounds(new Rectangle(177, 162, 103, 26));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(loginButton, null);
		this.getContentPane().add(buttonExit, null);
		this.getContentPane().add(UserNameText, null);
		this.getContentPane().add(PasswordText, null);
		this.getContentPane().add(StudentRadio, null);
		this.getContentPane().add(InstructorRadio, null);
		buttonGroup1.add(StudentRadio);
		buttonGroup1.add(InstructorRadio);
	}

	void loginButton_actionPerformed(ActionEvent e) {
		BufferedReader file;
		m_bExit = false;
		System.out.println("login clicked");
		try {
			if (StudentRadio.isSelected() == true) {
				userType = USER_TYPE.Student;
				file = new BufferedReader(new FileReader("StuInfo.txt"));
			} else// instructor
			{
				userType = USER_TYPE.Instructor;
				file = new BufferedReader(new FileReader("InsInfor.txt"));
			}
			userBox = UserNameText.getText();
			String PasswordBox = new String(PasswordText.getPassword());
			String LoginName = null;
			String aline = null, UserName = null, Password = null;
			while ((aline = file.readLine()) != null) {
				UserName = getUserName(aline);
				Password = getPassword(aline);
				if (UserName.compareTo(userBox) == 0 && Password.compareTo(PasswordBox) == 0)
					LoginName = UserName;
			}
			if (LoginName != null) {
				this.setVisible(false);
			}
		} catch (Exception ee) {
			;
		}

	}

	/**
	 * Get the user name from aline UserName:Password
	 * 
	 * @param aline
	 * @return
	 */
	private String getUserName(String aline) {
		int sep = aline.lastIndexOf(':');
		return aline.substring(0, sep);
	}

	/**
	 * Get the password from aline UserName:Password
	 * 
	 * @param aline
	 * @return
	 */
	private String getPassword(String aline) {
		int sep = aline.lastIndexOf(':');
		return aline.substring(sep + 1, aline.length());
	}

	/* after login get the UserName of the login interface */
	public String getUserName() {
		return userBox;
	}

	/* after login get the userType of the login interface */
	public USER_TYPE getUserType() {
		return userType;
	}

	public boolean isExit() {
		return m_bExit;
	}

	void buttonExit_actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}