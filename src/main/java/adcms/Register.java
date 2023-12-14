package adcms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtYourName;
	private JTextField txtYourEmail;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setForeground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("Đăng ký người sử dụng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 596);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setToolTipText("Người sử dụng");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Create an Account");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(160, 10, 240, 61);
		contentPane.add(lblTitle);
		
		JLabel lblSubTitle = new JLabel("Enter your personal details to create account");
		lblSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubTitle.setForeground(Color.GRAY);
		lblSubTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubTitle.setBounds(121, 72, 318, 31);
		contentPane.add(lblSubTitle);
		
		JLabel lblYourName = new JLabel("Your name");
		lblYourName.setForeground(Color.GRAY);
		lblYourName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYourName.setBounds(49, 113, 79, 31);
		contentPane.add(lblYourName);
		
		txtYourName = new JTextField();
		txtYourName.setForeground(Color.BLACK);
		txtYourName.setBounds(49, 145, 482, 36);
		contentPane.add(txtYourName);
		txtYourName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Your email");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(49, 191, 84, 17);
		contentPane.add(lblNewLabel);
		
		txtYourEmail = new JTextField();
		txtYourEmail.setForeground(Color.BLACK);
		txtYourEmail.setColumns(10);
		txtYourEmail.setBounds(49, 218, 482, 36);
		contentPane.add(txtYourEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.GRAY);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(49, 264, 84, 17);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(Color.BLACK);
		txtUsername.setColumns(10);
		txtUsername.setBounds(49, 291, 482, 36);
		contentPane.add(txtUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(49, 341, 84, 17);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setColumns(10);
		txtPassword.setBounds(49, 368, 482, 36);
		contentPane.add(txtPassword);
		
		JButton btnDangKy = new JButton("Đăng ký Tài khoản");
		btnDangKy.setForeground(Color.YELLOW);
		btnDangKy.setBackground(Color.RED);
		btnDangKy.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDangKy.setBounds(91, 486, 402, 44);
		contentPane.add(btnDangKy);
		
		JCheckBox chkAgree = new JCheckBox("I agree and accept the terms and conditions");
		chkAgree.setForeground(Color.GRAY);
		chkAgree.setFont(new Font("Tahoma", Font.BOLD, 14));
		chkAgree.setBounds(49, 428, 360, 21);
		contentPane.add(chkAgree);
	}
}
