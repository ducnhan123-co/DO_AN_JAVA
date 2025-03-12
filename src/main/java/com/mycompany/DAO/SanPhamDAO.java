/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO;

import com.mycompany.DTO.SanPhamDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class SanPhamDAO {
    public static ArrayList<SanPhamDTO> getDanhSachSanPham() throws Exception{
        ArrayList<SanPhamDTO> res = new ArrayList<>();
        Connection conn = ConnectionDAL.getConnection();
        String query = "select MaSP, TenSP, TenLoai, TenDonVi, HSDung, SanPham.MoTa, gia, SoLuongTon\n" +
            "from SanPham \n" +
            "inner join Loai on Loai.MaLoai = SanPham.Loai\n" +
            "inner join DonVi on MaDonVi = SanPham.DonViTinh";
        
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            res.add(new SanPhamDTO(rs.getString("masp"), rs.getString("tensp"), rs.getString("tenloai"), rs.getString("tendonvi"), rs.getInt("HSDung"), rs.getString("mota"),rs.getInt("gia"), rs.getInt("soluongton")));
        }
        
        return res;
    }
}
