package it6020002.section;

import java.sql.*;
import java.util.ArrayList;

import it6020002.*;
import it6020002.objects.SectionObject;

public class Section {
	
	private Connection con;
	
	private ConnectionPool cp;
	
	public Section() {
		this.cp = new ConnectionPoolImpl();
		
		try {
			this.con = this.cp.getConnection("Section");
			
			if(this.con.getAutoCommit()) {
				this.con.setAutoCommit(false); //Cham dut che do thuc thi tu dong cua ket noi
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<SectionObject> getSectionObjects(SectionObject similar, byte total) {
		ArrayList<SectionObject> items = new ArrayList<>();
		
		SectionObject item;
		
		String sql = "SELECT * FROM tblsection ";
		sql += "";
		sql += "ORDER BY section_name ASC ";
		sql += "LIMIT ?";
		
		//Bien dich cau lenh
//		Statement sta = this.con.createStatement();
//		sta.executeUpdate(sql);
//		CallableStatement cal = this.con.prepareCall(sql);
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			// Truyen tong so ban ghi can lay
			pre.setByte(1, total);
			
			//Lay danh sach ban ghi
			ResultSet rs = pre.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					item = new SectionObject();
//					item.setSection_id(rs.getShort(1));
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					item.setSection_created_date(rs.getString("section_created_date"));
					item.setSection_notes(rs.getString("section_notes"));
					
					// Dua vao tap hop
					items.add(item);
				}
				// Dong tap ket qua lai
				rs.close();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} //Tro ve trang thai an toan cua ket noi
		}
		
		
		
		return items;
		
	}
	
	public boolean addSection(SectionObject item) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tblsection(");
		sql.append("section_name, section_notes, section_created_date,");
		sql.append("section_manager_id, section_enable, section_delete,");
		sql.append("section_last_modified, section_created_author_id,");
		sql.append("section_name_en, section_language) ");
		sql.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
		
		// Bien dich 
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			// Truyen gia tri
			pre.setString(1, item.getSection_name());
			pre.setString(2, item.getSection_notes());
			pre.setString(3, item.getSection_created_date());
			pre.setInt(4, item.getSection_manager_id());
			pre.setBoolean(5, item.isSection_enable());
			pre.setBoolean(6, item.isSection_delete());
			pre.setString(7, item.getSection_last_modified());
			pre.setInt(8, item.getSection_created_author_id());
			pre.setString(9, item.getSection_name_en());
			pre.setByte(10, item.getSection_language());
			
			int result = pre.executeUpdate(); // Thuc thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			// Xac nhan thuc thi sau cung
			this.con.commit();
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		Section s = new Section();
		
		// Tao chuyen muc moi
		SectionObject nsection = new SectionObject();
		nsection.setSection_name("Lap trinh java nang cao");
	    nsection.setSection_created_date("27/10/2023");
	    nsection.setSection_notes("Kiểm thử chức năng thêm Chuyên mục");
	    
	    if(!s.addSection(nsection)) {
	    	System.out.print("\n-----KHÔNG THÀNH CÔNG-----\n");
	    }
		
		
		
		
		
		// Lay danh sach Chuyen muc
		ArrayList<SectionObject> items = s.getSectionObjects(null, (byte)10);
		
		// In danh sach ra man hinh
		items.forEach(item -> {
			System.out.println(item);
		});
	}
	 
}
