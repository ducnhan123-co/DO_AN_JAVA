/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.DAO;

import java.sql.*;
import do_an_java_new.DTO.KhuyenMaiDTO;
import java.util.ArrayList;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class KhuyenMaiDAO { 
    public static ArrayList<KhuyenMaiDTO> getDanhSachKhuyenMai() throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "SELECT `MaKM`, `TenKM`, `MoTa`, `NgayBatDau`, `NgayKetThuc`, `MaSP`, `GiaTri`, `SoLuong`, `TrangThai`\n" +
                "FROM `khuyenmai`";
        
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        
        ArrayList<KhuyenMaiDTO> res = new ArrayList<>();
        while (rs.next()) {
            res.add(new KhuyenMaiDTO(
                    rs.getString("MaKM"),
                    rs.getString("TenKM"),
                    rs.getString("MoTa"),
                    rs.getString("MaSP"),
                    rs.getDate("NgayBatDau"),
                    rs.getDate("NgayKetThuc"),
                    rs.getInt("GiaTri"),
                    rs.getInt("SoLuong"),
                    rs.getString("TrangThai")                   
            ));
        }
        
        return res;
    }
    
    public static void themKhuyenMai(KhuyenMaiDTO khuyenMai) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "INSERT INTO `khuyenmai`(`MaKM`, `TenKM`, `MoTa`, `NgayBatDau`, `NgayKetThuc`, `MaSP`, `GiaTri`, `SoLuong`, `TrangThai`) \n" +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, khuyenMai.getMaKM());
        st.setString(2, khuyenMai.getTenKM());
        st.setString(3, khuyenMai.getNoiDung());
        st.setDate(4, khuyenMai.getNgayBD());
        st.setDate(5, khuyenMai.getNgayKT());
        st.setString(6, khuyenMai.getMaSP());
        st.setInt(7, khuyenMai.getGiaTri());
        st.setInt(8, khuyenMai.getSoLuong());
        st.setString(9, khuyenMai.getTrangThai());
        
        st.executeUpdate();
    }
    
    public static void updateSoLuong(String maKM, int count) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "UPDATE `khuyenmai` \n" +
                "SET `SoLuong` = SoLuong + ? \n" +
                "WHERE `khuyenmai`.`MaKM` = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, count);
        st.setString(2, maKM);
        st.executeUpdate();
    }
    
    public static void updateKhuyenMai(KhuyenMaiDTO khuyenMai) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "UPDATE `khuyenmai` SET " +
                "`TenKM` = ?, " +
                "`MoTa` = ?, " +
                "`NgayBatDau` = ?, " +
                "`NgayKetThuc` = ?, " +
                "`MaSP` = ?, " +
                "`GiaTri` = ?, " +
                "`SoLuong` = ?, " +
                "`TrangThai` = ? " +
                "WHERE `MaKM` = ?";

        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, khuyenMai.getTenKM());
        st.setString(2, khuyenMai.getNoiDung());
        st.setDate(3, khuyenMai.getNgayBD());
        st.setDate(4, khuyenMai.getNgayKT());
        st.setString(5, khuyenMai.getMaSP());
        st.setInt(6, khuyenMai.getGiaTri());
        st.setInt(7, khuyenMai.getSoLuong());
        st.setString(8, khuyenMai.getTrangThai());
        st.setString(9, khuyenMai.getMaKM());

        st.executeUpdate();
    }
    
}
