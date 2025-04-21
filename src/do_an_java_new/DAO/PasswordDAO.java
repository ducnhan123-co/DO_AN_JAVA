/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.DAO;
import java.sql.*;
import do_an_java_new.DTO.NhanVienDTO;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class PasswordDAO {
    public static NhanVienDTO checkPassword(String id,  String password) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "SELECT MaNV, Ho, TenLot, Ten, Phai, NgaySinh, SDT, TenTThanh, DiaChi, Luong, chucVu, TrangThai \n" +
                "FROM NhanVien\n" +
                "left join TinhThanh on MaTThanh = TinhThanh\n"+ 
                "WHERE MaNV = ? and MatKhau = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, id);
        st.setString(2, password);
        
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
                    rs.getString("TenTThanh"),
                    rs.getString("DiaChi"),
                    rs.getInt("Luong"),
                    rs.getString("chucVu"),
                    rs.getString("TrangThai")                  
            );
        }
        return null;
    }
}
