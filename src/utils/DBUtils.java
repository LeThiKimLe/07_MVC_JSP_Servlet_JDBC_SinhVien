package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.SinhVien;

public class DBUtils {
	public static List<SinhVien> listSinhVien(Connection conn) throws SQLException {
        String sql = "Select id, name,  address from student";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        
        List<SinhVien> list = new ArrayList<SinhVien>();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String address = rs.getString("address");
            
            SinhVien sv = new SinhVien();
            sv.setId(id);
            sv.setHoten(name);
            sv.setDiachi(address);            
            
            list.add(sv);
        }
        return list;
    }
    public static SinhVien findSinhVien(Connection conn, int idIn) throws SQLException {
        String sql = "Select a.id, a.name, a.address from Student a where a.id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setInt(1, idIn);
        
        //"Select a.id, a.name, a.address from Student a where a.id=12";
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	 int id = rs.getInt("id");
            String name = rs.getString("name");           
            String diachi = rs.getString("address");
            
            SinhVien sv = new SinhVien(id, name, diachi);
            return sv;
        }
        return null;
    }
	public static void updateSinhVien(Connection conn, SinhVien sv) throws SQLException {
        String sql = "Update Student set name=?, address=? where id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, sv.getHoten());
        pstm.setString(2, sv.getDiachi());
        pstm.setInt(3, sv.getId());
        //"Update Student set name='nguyen van a', address='thu duc' where id=12"
        pstm.executeUpdate();
    }
	public static void insertSinhVien(Connection conn, SinhVien sv) throws SQLException {
        String sql = "Insert Student values (?, ?, ?)";
 //
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, sv.getId());
        pstm.setString(2, sv.getHoten());
        pstm.setString(3, sv.getDiachi());
        ///Insert Student values (123, 'nguyen van b', 'thu duc)
        
        pstm.executeUpdate();
    }
	public static void deleteSinhVien(Connection conn, int idIn) throws SQLException {
        String sql = "Delete from Student where id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, idIn);  
        
        pstm.executeUpdate();
    }
}
