/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class LoginDAO {
    public static String getMatKhau(String id) throws Exception {
        Connection conn = ConnectionDAL.getConnection();
        String query = "select MatKhau \n" +
            "from nhanvien \n" +
            "where MaNV = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, id);
        
        ResultSet rs = st.executeQuery();
        
        if (rs.next()) {
            return rs.getString("MatKhau");
        } else {
            throw new Exception("Không tồn tại người dùng");
        }
    }
}
