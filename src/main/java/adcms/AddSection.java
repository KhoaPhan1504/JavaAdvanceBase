package adcms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import it6020002.objects.*;
import it6020002.section.*;

public class AddSection extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtNotes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Section s = new Section();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSection frame = new AddSection(s);
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
	public AddSection(Section s) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Thêm chuyên mục mới");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(147, 10, 258, 52);
		contentPane.add(lblTitle);
		
		JLabel lblName = new JLabel("Tên chuyên mục");
		lblName.setForeground(Color.GRAY);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(51, 75, 120, 27);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(51, 112, 473, 36);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNotes = new JLabel("Mô tả chi tiết");
		lblNotes.setForeground(Color.GRAY);
		lblNotes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNotes.setBounds(51, 173, 120, 27);
		contentPane.add(lblNotes);
		
		txtNotes = new JTextField();
		txtNotes.setColumns(10);
		txtNotes.setBounds(51, 223, 473, 274);
		contentPane.add(txtNotes);
		
		JButton btnSave = new JButton("Thêm mới");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lay thong tin
				String name = txtName.getText();
				String notes = txtNotes.getText();
				if(!"".equalsIgnoreCase(name) && !"".equalsIgnoreCase(notes)) {
					// Tao doi tuong
					SectionObject nsection = new SectionObject();
					nsection.setSection_name(name);
					nsection.setSection_notes(notes);
					nsection.setSection_created_date("03//11/2023");
					nsection.setSection_created_author_id(20);
					nsection.setSection_name_en(name);
					
					if(!s.addSection(nsection)) {
				    	System.out.print("\n-----KHÔNG THÀNH CÔNG-----\n");
				    } else {
				    	txtName.setText("");
				    	txtNotes.setText("");
					}
				}
				
				
			}
		});
		btnSave.setBackground(Color.BLUE);
		btnSave.setForeground(Color.YELLOW);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(133, 521, 314, 44);
		contentPane.add(btnSave);
	}
}
