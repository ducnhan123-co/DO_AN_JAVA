package do_an_java_new.DAO;

import do_an_java_new.DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Date;
import java.sql.Statement;

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
      
    public static void themNhanVien(NhanVienDTO nhanvien, int maTinh) throws Exception {
                
        Connection con = ConnectionDAL.getConnection();
        String query = "insert into NhanVien(MaNV, Ho, TenLot, Ten, Phai, NgaySinh, SDT,"
                + " TinhThanh, DiaChi, Luong, chucVu, TrangThai, MatKhau)\n" +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);
        
        st.setString(1, nhanvien.getMaNV());
        st.setString(2, nhanvien.getHo());
        st.setString(3, nhanvien.getTenLot());
        st.setString(4, nhanvien.getTen());
        st.setString(5, nhanvien.getPhai());
        st.setDate(6, nhanvien.getNgaysinh());
        st.setString(7, nhanvien.getSdt());
        st.setInt(8, maTinh);
        st.setString(9, nhanvien.getDiachi());
        st.setInt(10, nhanvien.getLuong());
        st.setString(11, nhanvien.getChucVu());
        st.setString(12, nhanvien.getTrangthai());
        st.setString(13, nhanvien.getMaNV());
        
        st.executeUpdate();
    }
    public static void suaNhanVien(NhanVienDTO nhanVien, int matinh) throws Exception {
        Connection con = ConnectionDAL.getConnection();
        String query = "UPDATE NhanVien \n" +
            "SET Ho = ?, TenLot = ?, Ten = ?, Phai = ?, NgaySinh = ?, SDT = ?,\n" +
            "    TinhThanh = ?, DiaChi = ?, Luong = ?, ChucVu = ?, TrangThai = ?\n" +
            "WHERE MaNV = ?";

        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, nhanVien.getHo());
        st.setString(2, nhanVien.getTenLot());
        st.setString(3, nhanVien.getTen());
        st.setString(4, nhanVien.getPhai());
        st.setDate(5, nhanVien.getNgaysinh()); 
        st.setString(6, nhanVien.getSdt());
        st.setInt(7, matinh);
        st.setString(8, nhanVien.getDiachi());
        st.setInt(9, nhanVien.getLuong());
        st.setString(10, nhanVien.getChucVu());
        st.setString(11, nhanVien.getTrangthai());
        st.setString(12, nhanVien.getMaNV());
        int res = st.executeUpdate();
    }
    public static ArrayList<NhanVienDTO> getDanhSachNhanVien() throws Exception {
        ArrayList<NhanVienDTO> res = new ArrayList<>();
        Connection conn = ConnectionDAL.getConnection();
        Statement st = conn.createStatement();
        String query = "SELECT MaNV, Ho, TenLot, Ten, Phai, NgaySinh, SDT, TenTThanh, DiaChi, Luong, chucVu, TrangThai \n" +
            "FROM NhanVien\n" +
            "left join TinhThanh on MaTThanh = TinhThanh";
        
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            res.add(new NhanVienDTO(
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
            ));
        }
        return res;
    }
      
}
