package do_an_java_new.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThongKeDAO {

    public static List<Object[]> thongKeSanPham(String maSP, Date tuNgay, Date denNgay, String kieuThongKe) throws SQLException {
        List<Object[]> result = new ArrayList<>();
        Connection conn = ConnectionDAL.getConnection();
        StringBuilder query = new StringBuilder();

        switch (kieuThongKe) {
            case "doanhthu":
                query.append("SELECT sp.MaSP, sp.TenSP, SUM(ct.SoLuong * ct.DonGia) AS TongDoanhThu ");
                query.append("FROM SanPham sp ");
                query.append("LEFT JOIN Hang h ON sp.MaSP = h.MaSP ");
                query.append("LEFT JOIN ChiTietHoaDon ct ON h.MaHang = ct.MaHang ");
                query.append("LEFT JOIN HoaDon hd ON ct.MaHD = hd.MaHD ");
                query.append("WHERE 1=1 ");
                if (maSP != null && !maSP.isBlank()) {
                    query.append("AND sp.MaSP = ? ");
                }
                if (tuNgay != null) {
                    query.append("AND hd.ThoiGian >= ? ");
                }
                if (denNgay != null) {
                    query.append("AND hd.ThoiGian <= ? ");
                }
                query.append("GROUP BY sp.MaSP, sp.TenSP ");
                break;

            case "soluong":
                query.append("SELECT sp.MaSP, sp.TenSP, SUM(ct.SoLuong) AS TongSoLuong ");
                query.append("FROM SanPham sp ");
                query.append("LEFT JOIN Hang h ON sp.MaSP = h.MaSP ");
                query.append("LEFT JOIN ChiTietHoaDon ct ON h.MaHang = ct.MaHang ");
                query.append("LEFT JOIN HoaDon hd ON ct.MaHD = hd.MaHD ");
                query.append("WHERE 1=1 ");
                if (maSP != null && !maSP.isBlank()) {
                    query.append("AND sp.MaSP = ? ");
                }
                if (tuNgay != null) {
                    query.append("AND hd.ThoiGian >= ? ");
                }
                if (denNgay != null) {
                    query.append("AND hd.ThoiGian <= ? ");
                }
                query.append("GROUP BY sp.MaSP, sp.TenSP ");
                break;

            case "loaisp":
                query.append("SELECT l.TenLoai, SUM(ct.SoLuong) AS TongSoLuong, SUM(ct.SoLuong * ct.DonGia) AS TongDoanhThu ");
                query.append("FROM SanPham sp ");
                query.append("JOIN Loai l ON sp.Loai = l.MaLoai ");
                query.append("LEFT JOIN Hang h ON sp.MaSP = h.MaSP ");
                query.append("LEFT JOIN ChiTietHoaDon ct ON h.MaHang = ct.MaHang ");
                query.append("LEFT JOIN HoaDon hd ON ct.MaHD = hd.MaHD ");
                query.append("WHERE 1=1 ");
                if (tuNgay != null) {
                    query.append("AND hd.ThoiGian >= ? ");
                }
                if (denNgay != null) {
                    query.append("AND hd.ThoiGian <= ? ");
                }
                query.append("GROUP BY l.TenLoai ");
                break;

            default:
                query.append("SELECT sp.MaSP, sp.TenSP, sp.SoLuongTon ");
                query.append("FROM SanPham sp ");
                query.append("WHERE 1=1 ");
                if (maSP != null && !maSP.isBlank()) {
                    query.append("AND sp.MaSP = ? ");
                }
                break;
        }

        PreparedStatement ps = conn.prepareStatement(query.toString());
        int index = 1;
        if (maSP != null && !maSP.isBlank() && !kieuThongKe.equals("loaisp")) {
            ps.setString(index++, maSP);
        }
        if (tuNgay != null && !kieuThongKe.equals("default")) {
            ps.setDate(index++, new java.sql.Date(tuNgay.getTime()));
        }
        if (denNgay != null && !kieuThongKe.equals("default")) {
            ps.setDate(index++, new java.sql.Date(denNgay.getTime()));
        }

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Object[] row;
            if (kieuThongKe.equals("loaisp")) {
                row = new Object[]{
                    rs.getString("TenLoai"),
                    rs.getInt("TongSoLuong"),
                    rs.getLong("TongDoanhThu")
                };
            } else if (kieuThongKe.equals("doanhthu")) {
                row = new Object[]{
                    rs.getString("MaSP"),
                    rs.getString("TenSP"),
                    rs.getLong("TongDoanhThu")
                };
            } else if (kieuThongKe.equals("soluong")) {
                row = new Object[]{
                    rs.getString("MaSP"),
                    rs.getString("TenSP"),
                    rs.getInt("TongSoLuong")
                };
            } else {
                row = new Object[]{
                    rs.getString("MaSP"),
                    rs.getString("TenSP"),
                    rs.getInt("SoLuongTon")
                };
            }
            result.add(row);
        }
        return result;
    }
}