/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.DAO;

import do_an_java_new.DTO.HoaDonDTO;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
/**
 *
 * @author Administrator
 */
public class HoaDonDAO {

    public static void themHoaDon(HoaDonDTO hoaDon) throws SQLException {
        Connection cn = ConnectionDAO.getConnection();
        String query = "insert into hoaDon(MaHD, MaKH, MaNV, TongTien, ThoiGian, KhuyenMai, TienGiam)\n"
                + "values (?,?,?,?,current_timestamp(), ?, ?);\n";
        
        PreparedStatement st = cn.prepareStatement(query);
        st.setString(1, hoaDon.getMaHD());
        st.setString(2, hoaDon.getMaKH());
        st.setString(3, hoaDon.getMaNV());
        st.setInt(4, hoaDon.getTongTien());
        st.setString(5, hoaDon.getMaKM());
        st.setInt(6, hoaDon.getTienGiam());
               
        st.executeUpdate();
    }

    public static void xoaHoaDon(String maHD) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String sql = ("DELETE FROM hoadon\n" +
                "WHERE hoadon.MaHD= ?");

        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, maHD);
        
        st.executeUpdate();
    }

    //Lấy tất cả dl của hoadon từ database
    public static ArrayList<HoaDonDTO> getDanhSachHoaDon() {
        ArrayList<HoaDonDTO> result = new ArrayList<HoaDonDTO>();
        try {
            Connection cn = ConnectionDAO.getConnection();
            String sql = "SELECT `MaHD`, `MaKH`, `MaNV`, `TongTien`, `TienGiam`, `ThoiGian`, `KhuyenMai` \n" +
                    "FROM `hoadon`";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                String maHD = rs.getString("MaHD");
                String maKH = rs.getString("MaKH");
                String maNV = rs.getString("MaNV");
                int tongTien = rs.getInt("TongTien");
                int tienGiam = rs.getInt("TienGiam");                
                Date thoiGian = rs.getDate("ThoiGian");
                String km = rs.getString("KhuyenMai");
                
                HoaDonDTO tmp = new HoaDonDTO(maHD, maKH, maNV, tongTien, tienGiam, thoiGian, km);
                result.add(tmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //Lấy hóa đơn theo mã từ database
    public HoaDonDTO selectByid(String id) {
        HoaDonDTO result=null;
        try {
            Connection cn = ConnectionDAO.getConnection();
            String sql = "SELECT `MaHD`, `MaKH`, `MaNV`, `TongTien`, `TienGiam`, `ThoiGian`, `KhuyenMai` \n" +
                    "FROM `hoadon`"+
                    "WHERE `maHD` = ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, id);
            System.out.println("Chạy câu lệnh: "+sql);

            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String maHD = rs.getString("MaHD");
                String maKH = rs.getString("MaKH");
                String maNV = rs.getString("MaNV");
                int tongTien = rs.getInt("TongTien");
                int tienGiam = rs.getInt("TienGiam");
                Date thoiGian = rs.getDate("ThoiGian");
                String km = rs.getString("KhuyenMai");
                result = new HoaDonDTO(maHD, maKH, maNV, tongTien, tienGiam, thoiGian, km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static ArrayList<Object[]> thongKeDoanhThu(Date beginDate, Date endDate) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "SELECT DATE(ThoiGian) as Ngay, SUM(TongTien) as DoanhThu \n" +
                       "FROM hoadon \n" +
                       "WHERE ThoiGian BETWEEN ? AND ? \n" +
                       "GROUP BY DATE(ThoiGian) \n" +
                       "ORDER BY Ngay ASC";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setDate(1, beginDate);
        st.setDate(2, endDate);

        ResultSet rs = st.executeQuery();

        ArrayList<Object[]> result = new ArrayList<>();
        while (rs.next()) {
            Date ngay = rs.getDate("Ngay");
            int doanhThu = rs.getInt("DoanhThu");
            result.add(new Object[]{ngay, doanhThu});
        }
        
        return result;
    }
    
    public static int[] thongKeTheoQuy(int year) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "SELECT QUARTER(hoadon.ThoiGian), SUM(hoadon.TongTien)\n" +
                "FROM hoadon\n" +
                "WHERE YEAR(hoadon.ThoiGian) = ?\n" +
                "GROUP BY QUARTER(hoadon.ThoiGian)";     
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, year);

        ResultSet rs = st.executeQuery();

        int result[] = new int[4];
        while (rs.next()) 
            result[rs.getInt(1)-1] = rs.getInt(2);
        
        return result;
    }   
}