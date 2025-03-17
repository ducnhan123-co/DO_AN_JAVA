/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.DAO;

/**
 *
 * @author pducn
 */

import do_an_java_new.DTO.LoaiSPDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class LoaiSPDAO {
    public static ArrayList<LoaiSPDTO> getDanhSachLoaiSP() throws Exception {
        ArrayList<LoaiSPDTO> res = new ArrayList<>();
        Connection conn = ConnectionDAL.getConnection();
        String query = "select * from Loai";
        PreparedStatement st = conn.prepareStatement(query);

        ResultSet rs = st.executeQuery();
        while (rs.next()) 
            res.add(new LoaiSPDTO(rs.getString(1), rs.getString(2), rs.getString(3)));

        return res;
    }
    
    public static int getMaLoai(String ten) {
        try {
            Connection conn = ConnectionDAL.getConnection();
            String query = "SELECT MaLoai FROM loai \n" +
                    "where TenLoai = ?";
            
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, ten);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) 
                return rs.getInt("MaLoai");
            else 
                throw new Exception("Không tìm thấy loại");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public static void themLoaiSP(LoaiSPDTO loai) throws SQLException {
        Connection con = ConnectionDAL.getConnection();
        String query = "insert into Loai\n" +
            "values (?, ?, ?)";
        
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, loai.getMaLoai());
        st.setString(2, loai.getTenLoai());
        st.setString(3, loai.getMota());
        
        st.executeUpdate();
    }
    
    public static void suaLoaiSP(LoaiSPDTO loai) throws Exception {
        Connection con = ConnectionDAL.getConnection();
        String query = "update Loai\n" +
            "set \n" +
            "	TenLoai = ?,\n" +
            "	MoTa = ?\n" +
            "where MaLoai = ?";
        System.out.println(loai.getMaLoai());
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, loai.getTenLoai());
        st.setString(2, loai.getMota());
        st.setString(3, loai.getMaLoai());
        
        st.executeUpdate();
    }
}
