package adcms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import it6020002.objects.*;
import it6020002.section.*;

public class ViewSectionList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblSection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Section s = new Section();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSectionList frame = new ViewSectionList(s);
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
	public ViewSectionList(Section s) {
		setResizable(false);
		setTitle("Danh sách chuyên mục");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Danh sách chuyên mục trong hệ thống");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitle.setBounds(176, 10, 487, 63);
		contentPane.add(lblTitle);
		
		ArrayList<SectionObject> list = s.getSectionObjects(null, (byte)20);
		
		// Tieu de bang
		String[] columnNames = {"ID", "Name", "Notes"};
				
		// Data
		String[][] datas = new String[list.size()][3];
		
		Counter c = new Counter();
		list.forEach(item -> {
			datas[c.getCount()] = new String[]{item.getSection_id() + "", item.getSection_name() + "", item.getSection_notes() + ""};
		});
		
		tblSection = new JTable(datas,columnNames);
		tblSection.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblSection.setBounds(32, 114, 717, 390);
		
		contentPane.add(tblSection);
		
		JButton btnBack = new JButton("Trở về");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog( btnBack,"Confirm if you want to Exit","Product Group List",
			            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			            System.exit(0);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(342, 525, 141, 43);
		contentPane.add(btnBack);
	}
}

class Counter {
	private static int count;
	public Counter() {
		Counter.count = 0;
	}
	public int getCount() {
		return Counter.count++;
	}
}

