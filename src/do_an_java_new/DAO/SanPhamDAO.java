/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import do_an_java_new.DTO.SanPhamDTO;
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
}
