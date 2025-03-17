package do_an_java_new.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import do_an_java_new.DTO.NhanVienDTO;
import java.sql.Date;

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
