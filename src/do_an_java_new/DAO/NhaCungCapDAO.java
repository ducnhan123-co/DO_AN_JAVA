/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.DAO;

import do_an_java_new.DTO.NhaCungCapDTO;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class NhaCungCapDAO {
    public static ArrayList<NhaCungCapDTO> getDanhSachNCC() throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "select MaNCCap, TenNCCap, TenLienHe, SDThoai, TenTThanh, DiaChi, TrangThai\n" +
                "from nhacungcap\n" +
                "INNER JOIN TinhThanh on MaTThanh = TinhThanh";
        PreparedStatement st = conn.prepareStatement(query);
        
        ResultSet rs = st.executeQuery();
        
        ArrayList<NhaCungCapDTO> res = new ArrayList<>();
        while (rs.next()) {
            res.add(new NhaCungCapDTO(
                    rs.getString("MaNCCap"),
                    rs.getString("TenNCCap"),
                    rs.getString("TenLienHe"),
                    rs.getString("SDThoai"),
                    rs.getString("TenTThanh"),
                    rs.getString("DiaChi"),
                    rs.getString("TrangThai")
            ));
        }
        
        return res;
    }
    
    public static void themNhaCungCap(NhaCungCapDTO ncc, int matinh) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "INSERT INTO nhacungcap (MaNCCap, TenNCCap, TenLienHe, SDThoai, TinhThanh, DiaChi, TrangThai) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, ncc.getMaNCC());
        st.setString(2, ncc.getTenNCC());
        st.setString(3, ncc.getTenLienHe());
        st.setString(4, ncc.getSdt());
        st.setInt(5, matinh);
        st.setString(6, ncc.getDiaChi());
        st.setString(7, ncc.getTrangThai());
        
        st.executeUpdate();
    }
    
    public static void suaNhaCungCap(NhaCungCapDTO ncc, int matinh) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "UPDATE nhacungcap \n" +
                "SET TenNCCap = ?, TenLienHe = ?, SDThoai = ?, TinhThanh = ?, DiaChi = ?, TrangThai = ?\n" +
                "WHERE nhacungcap.MaNCCap = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(7, ncc.getMaNCC());
        st.setString(1, ncc.getTenNCC());
        st.setString(2, ncc.getTenLienHe());
        st.setString(3, ncc.getSdt());
        st.setInt(4, matinh);
        st.setString(5, ncc.getDiaChi());
        st.setString(6, ncc.getTrangThai());
        
        st.executeUpdate();
    }
    
    public static void xoaNhaCungCap(String maNCC) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "DELETE FROM nhacungcap \n" +
                "WHERE MaNCCap = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, maNCC);
        
        st.executeUpdate();
    }
}
