/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.DAO;

import do_an_java_new.DTO.KhachHangDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class KhachHangDAO {
    public static ArrayList<KhachHangDTO> getDanhSachKhachHang() throws Exception {
        ArrayList<KhachHangDTO> res = new ArrayList<>();
        Connection conn = ConnectionDAO.getConnection();
        Statement st = conn.createStatement();
        
        String query = "SELECT MaKH, Ho, TenLot, Ten, Phai, NgaySinh, SDT, TenTThanh, DiaChi, NgayThamGia, Diem, TrangThai\n" +
            "FROM KhachHang\n" +
            "left join TinhThanh on MaTThanh = TinhThanh\n";
        
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            res.add(new KhachHangDTO(
                rs.getString("MaKH"),
                rs.getString("Ho"),
                rs.getString("TenLot"),
                rs.getString("Ten"),
                rs.getString("Phai"),
                rs.getDate("NgaySinh"),
                rs.getString("SDT"),
                rs.getString("TenTThanh"),
                rs.getString("DiaChi"),
                rs.getDate("NgayThamGia"),
                rs.getInt("Diem"),
                rs.getString("TrangThai")
            ));
        }
        return res;
    }
    
    public static void themKhachHang(KhachHangDTO khachHang, int maTinh) throws Exception {
        Connection conn = ConnectionDAO.getConnection();
        
        String query = "INSERT INTO KhachHang (MaKH, Ho, TenLot, Ten, Phai, NgaySinh, SDT, TinhThanh, DiaChi, NgayThamGia, Diem, TrangThai)  \n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, khachHang.getMaKH());
        ps.setString(2, khachHang.getHo());
        ps.setString(3, khachHang.getTenlot());
        ps.setString(4, khachHang.getTen());
        ps.setString(5, khachHang.getPhai());
        ps.setDate(6, khachHang.getNgaysinh());
        ps.setString(7, khachHang.getSdt());
        ps.setInt(8, maTinh);
        ps.setString(9, khachHang.getDiachi());
        ps.setDate(10, khachHang.getNgaythamgia());
        ps.setInt(11, 0);
        ps.setString(12, khachHang.getTrangthai());

        ps.executeUpdate();   
    }
    
    public static void suaKhachHang(KhachHangDTO khachhang, int maTinh) throws Exception {
        Connection con = ConnectionDAO.getConnection();
        String query = "UPDATE KhachHang\n" +
            "SET Ho = ?, \n" +
            "    TenLot = ?, \n" +
            "    Ten = ?, \n" +
            "    Phai = ?, \n" +
            "    NgaySinh = ?, \n" +
            "    SDT = ?, \n" +
            "    TinhThanh = ?, \n" +
            "    DiaChi = ?, \n" +
            "    NgayThamGia = ?, \n" +
            "    Diem = ?, \n" +
            "    TrangThai = ?\n" +
            "WHERE MaKH = ?;";
        
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, khachhang.getHo());
        st.setString(2, khachhang.getTenlot());
        st.setString(3, khachhang.getTen());
        st.setString(4, khachhang.getPhai());
        st.setDate(5, khachhang.getNgaysinh());
        st.setString(6, khachhang.getSdt());
        st.setInt(7, maTinh);
        st.setString(8, khachhang.getDiachi());
        st.setDate(9, khachhang.getNgaythamgia());
        st.setInt(10, khachhang.getDiem());
        st.setString(11, khachhang.getTrangthai());
        st.setString(12, khachhang.getMaKH());
        
        st.executeUpdate();
    }
    
    public static void xoaKhachHang(String makh) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "DELETE FROM khachhang\n" +
                "WHERE MaKH = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, makh);
        
        st.executeUpdate();
    }
    
    public static ArrayList<Object[]> thongKeKhachHang(Date beginDate, Date endDate) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "select khachhang.MaKH, khachhang.Ho, khachhang.TenLot, khachhang.Ten, sub1.soLuong, sub1.tien\n" +
                "FROM khachhang\n" +
                "INNER JOIN (\n" +
                "	SELECT hoadon.MaKH, SUM(sub2.soLuong) as 'soLuong', SUM(TongTien - TienGiam) as 'tien'\n" +
                "    FROM hoadon\n" +
                "    INNER JOIN (\n" +
                "    	SELECT MaHD, SUM(chitiethoadon.SoLuong) as 'soLuong'\n" +
                "        FROM chitiethoadon\n" +
                "        GROUP BY MaHD\n" +
                "    ) sub2 on sub2.MaHD = hoadon.MaHD\n" +
                "    WHERE hoadon.ThoiGian BETWEEN ? and ?\n" +
                "    GROUP BY hoadon.MaKH\n" +
                ") sub1 on sub1.MaKH = khachhang.MaKH";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setDate(1, beginDate);
        st.setDate(2, endDate);
        
        ResultSet rs = st.executeQuery();
        
        ArrayList<Object[]> res = new ArrayList<>();
        while (rs.next()) {
            res.add(new Object[] {
                rs.getString("MaKH"),
                rs.getString("Ho") + " " + rs.getString("TenLot"),
                rs.getString("Ten"),
                rs.getInt("soLuong"),
                rs.getInt("tien")
            });
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String query = "select khachhang.MaKH, khachhang.Ho, khachhang.TenLot, khachhang.Ten, sub1.soLuong, sub1.tien\n" +
                "FROM khachhang\n" +
                "INNER JOIN (\n" +
                "	SELECT hoadon.MaKH, SUM(sub2.soLuong) as 'soLuong', SUM(TongTien - TienGiam) as 'tien'\n" +
                "    FROM hoadon\n" +
                "    INNER JOIN (\n" +
                "    	SELECT MaHD, SUM(chitiethoadon.SoLuong) as 'soLuong'\n" +
                "        FROM chitiethoadon\n" +
                "        GROUP BY MaHD\n" +
                "    ) sub2 on sub2.MaHD = hoadon.MaHD\n" +
                "    WHERE hoadon.ThoiGian BETWEEN ? and ?\n" +
                "    GROUP BY hoadon.MaKH\n" +
                ") sub1 on sub1.MaKH = khachhang.MaKH";
                
    }
}
