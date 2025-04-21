/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import do_an_java_new.DTO.SanPhamDTO;
import do_an_java_new.DTO.ThongKeSanPhamDTO;
import java.sql.SQLException;

/**
 *
 * @author pducn
 */
public class SanPhamDAO {
    public static ArrayList<SanPhamDTO> getDanhSachSanPham() throws Exception{
        ArrayList<SanPhamDTO> res = new ArrayList<>();
        Connection conn = ConnectionDAO.getConnection();
        String query = "select MaSP, TenSP, TenLoai, TenDonVi, HSDung, SanPham.MoTa, gia, SoLuongTon\n" +
            "from SanPham \n" +
            "inner join Loai on Loai.MaLoai = SanPham.Loai\n" +
            "inner join DonVi on MaDonVi = SanPham.DonViTinh\n";
                        
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            res.add(new SanPhamDTO(rs.getString("masp"), rs.getString("tensp"), rs.getString("tenloai"),
                    rs.getString("tendonvi"), rs.getInt("HSDung"), rs.getString("mota"),rs.getInt("gia"),
                    rs.getInt("soluongton")));
        }
        
        return res;
    }

    public static ArrayList<SanPhamDTO> timSanPham(String keyWord) throws Exception{
        ArrayList<SanPhamDTO> res = new ArrayList<>();
        Connection conn = ConnectionDAO.getConnection();
        String query = "select MaSP, TenSP, TenLoai, TenDonVi, HSDung, SanPham.MoTa, gia, SoLuongTon\n" +
            "from SanPham \n" +
            "inner join Loai on Loai.MaLoai = SanPham.Loai\n" +
            "inner join DonVi on MaDonVi = SanPham.DonViTinh"+ 
            "where ";
        
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            res.add(new SanPhamDTO(rs.getString("masp"), rs.getString("tensp"), rs.getString("tenloai"), rs.getString("tendonvi"), rs.getInt("HSDung"), rs.getString("mota"),rs.getInt("gia"), rs.getInt("soluongton")));
        }
        
        return res;
    }    
    
    public static void themSanPham(SanPhamDTO sanPham, int maLoai, int maDVT) throws SQLException {
        Connection con = ConnectionDAO.getConnection();
        String query = "insert into SanPham\n" +
            "values (?, ?, ?, ?, ?, ?, ?, 0)";
        
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, sanPham.getMaSP());
        st.setString(2, sanPham.getTenSP());
        st.setInt(3, maLoai);
        st.setInt(4, maDVT);
        st.setInt(5, sanPham.getHanSuDung());
        st.setString(6, sanPham.getMoTa());
        st.setInt(7, sanPham.getGia());
        
        st.executeUpdate();
    }
    
    public static void suaSanPham(SanPhamDTO sanPham, int maLoai, int maDVT) throws SQLException {
        Connection con = ConnectionDAO.getConnection();
        String query = "UPDATE SanPham "
                + "SET TenSP = ?, Loai = ?, DonViTinh = ?, HSDung = ?, MoTa = ?, Gia = ? "
                + "WHERE MaSP = ?";

        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, sanPham.getTenSP());
        st.setInt(2, maLoai);
        st.setInt(3, maDVT);
        st.setInt(4, sanPham.getHanSuDung());
        st.setString(5, sanPham.getMoTa());
        st.setInt(6, sanPham.getGia());
        st.setString(7, sanPham.getMaSP());

        int rowsUpdated = st.executeUpdate();
        if (rowsUpdated == 0) {
            throw new SQLException("Không tìm thấy sản phẩm để cập nhật!");
        }
    }
    
    public static void xoaSanPham(String maSP) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "DELETE FROM sanpham \n" +
                "WHERE MaSP = ?" ;
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, maSP);
        
        st.executeUpdate();
    }
    
    public static void updateSoLuong(String maSP, int n) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "UPDATE `sanpham` \n" +
                "SET `SoLuongTon` = SoLuongTon + ?\n" +
                "WHERE `sanpham`.`MaSP` =  ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, n);
        st.setString(2, maSP);
        
        st.executeUpdate();
    }
    
    public static ArrayList<ThongKeSanPhamDTO> getDanhSachThongKe(Date beginDate, Date endDate) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "SELECT sanpham.MaSP, sanpham.TenSP, SUM(sub.soLuongBan) as 'soLuongBan', SUM(sub.doanhThu) as 'doanhThu', SUM(sub.doanhThu)-SUM(chitietpnhap.DonGia*sub.soLuongBan) as 'loiNhuan'\n" +
                "FROM sanpham\n" +
                "INNER JOIN hang on hang.MaSP = sanpham.MaSP\n" +
                "INNER JOIN chitietpnhap on chitietpnhap.MaHang = hang.MaHang\n" +
                "INNER JOIN (\n" +
                "	SELECT chitiethoadon.MaHang, SUM(chitiethoadon.SoLuong) as 'soLuongBan', SUM(chitiethoadon.SoLuong * chitiethoadon.DonGia) as 'doanhThu'\n" +
                "    FROM chitiethoadon\n" +
                "    WHERE chitiethoadon.MaHD in (\n" +
                "    	SELECT MaHD\n" +
                "        FROM hoadon\n" +
                "        WHERE hoadon.ThoiGian BETWEEN ? and ? \n" +
                "    )\n" +
                "    GROUP BY chitiethoadon.MaHang\n" +
                ") sub on sub.MaHang = hang.MaHang\n" +
                "\n" +
                "GROUP BY sanpham.MaSP, sanpham.TenSP\n"+
                "ORDER BY loiNhuan desc";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setDate(1, beginDate);
        st.setDate(2, endDate);
        
        ArrayList<ThongKeSanPhamDTO> res = new ArrayList<>();
        
        ResultSet rs = st.executeQuery();
        while (rs.next())
            res.add(new ThongKeSanPhamDTO(
                    rs.getString("MaSP"),
                    rs.getString("TenSP"),
                    rs.getInt("soLuongBan"),
                    rs.getInt("doanhThu"), 
                    rs.getInt("loiNhuan")
            ));
        
        return res;
    }
}
