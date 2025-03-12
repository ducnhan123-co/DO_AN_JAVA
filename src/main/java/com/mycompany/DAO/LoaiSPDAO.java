/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO;

import com.mycompany.DTO.LoaiSPDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
}
