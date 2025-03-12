/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO;

import com.mycompany.DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class NhanVienDAO {
    public static NhanVienDTO timNhanVien(String id) throws Exception {
        Connection conn = ConnectionDAL.getConnection();
        String query = "select MaNV, Ho, TenLot, Ten, Phai, NgaySinh, SDT, TinhThanh, DiaChi, Luong, chucVu, TrangThai\n" +
            "from nhanvien\n" +
            "where MaNV = ?";
        
        PreparedStatement st = conn.prepareStatement(query) ;
        st.setString(1, id);
        
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return new NhanVienDTO(
                            rs.getString("MaNV"),
                            rs.getString("Ho"),
                            rs.getString("TenLot"),
                            rs.getString("Ten"),
                            rs.getString("Phai"),
                            rs.getDate("NgaySinh"),
                            rs.getString("SDT"),
                            rs.getString("TinhThanh"),
                            rs.getString("DiaChi"),
                            rs.getInt("Luong"),
                            rs.getString("chucVu"),
                            rs.getString("TrangThai")
            );
        } else 
            throw new Exception("Không tìm thấy nhân viên");
    }
}
