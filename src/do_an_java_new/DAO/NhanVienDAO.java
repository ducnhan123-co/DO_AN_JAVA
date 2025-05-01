package do_an_java_new.DAO;

import do_an_java_new.DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.SQLException;
import java.sql.Statement;

public class NhanVienDAO {
    public static void themNhanVien(NhanVienDTO nhanvien, int maTinh) throws Exception {                
        Connection con = ConnectionDAO.getConnection();
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
        Connection con = ConnectionDAO.getConnection();
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
        st.executeUpdate();
    }
    public static ArrayList<NhanVienDTO> getDanhSachNhanVien() throws Exception {
        ArrayList<NhanVienDTO> res = new ArrayList<>();
        Connection conn = ConnectionDAO.getConnection();
        Statement st = conn.createStatement();
        
        String query = "SELECT MaNV, Ho, TenLot, Ten, Phai, NgaySinh, SDT, TenTThanh, DiaChi, Luong, chucVu, TrangThai \n" +
                "FROM NhanVien\n" +
                "left join TinhThanh on MaTThanh = TinhThanh\n";
                
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
      
    public static void xoaNhanVien(String manv) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "DELETE FROM nhanvien\n" +
                "WHERE MaNV = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, manv);
        
        st.executeUpdate();
    }
    
    public static void doiMatKhau(String id, String password) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "UPDATE `nhanvien` \n" +
                "SET `MatKhau` = ? \n" +
                "WHERE `MaNV` = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, password);
        st.setString(2, id);
        
        st.executeUpdate();
    }
    
    public static ArrayList<Object[]> thongKeNhanVien(Date beginDate, Date endDate) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "SELECT nhanvien.MaNV, nhanvien.Ho, nhanvien.TenLot, nhanvien.Ten, sub.SoLuongHD, sub.tien \n" +
                "FROM nhanvien\n" +
                "INNER JOIN (\n" +
                "	SELECT hoadon.MaNV, COUNT(*) as 'SoLuongHD', SUM(hoadon.TongTien) as 'tien'\n" +
                "    FROM hoadon\n" +
                "    WHERE hoadon.ThoiGian BETWEEN ? and ?\n" +
                "    GROUP BY MaNV\n" +
                ") sub on sub.MaNV = nhanvien.MaNV";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setDate(1, beginDate);
        st.setDate(2, endDate);
        
        ResultSet rs = st.executeQuery();
        
        ArrayList<Object[]> result = new ArrayList<>();
        while (rs.next()) {
            result.add(new Object[]{
                rs.getString("MaNV"),
                rs.getString("Ho") + " " + rs.getString("TenLot"),
                rs.getString("Ten"),
                rs.getInt("SoLuongHD"),
                rs.getInt("tien")
            });
        }
        return result;
    }
    
    public static void main(String[] args) {
        String query = "SELECT nhanvien.MaNV, nhanvien.Ho, nhanvien.TenLot, nhanvien.Ten, COUNT(*) as 'SoLuongHD', SUM(hoadon.TongTien) as 'tien'\n" +
                "FROM nhanvien\n" +
                "INNER JOIN hoadon on hoadon.MaNV = nhanvien.MaNV\n" +
                "WHERE hoadon.ThoiGian BETWEEN ? and ?\n" +
                "GROUP BY nhanvien.MaNV, nhanvien.Ten, nhanvien.Ho, nhanvien.TenLot";
                
        System.out.println(query);
    }
}
