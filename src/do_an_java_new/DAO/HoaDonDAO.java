/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.DAO;

import do_an_java_new.DTO.HoaDonDTO;
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

    public int update(HoaDonDTO hoaDon) {
        int result = 0;
        try {
            Connection cn = ConnectionDAO.getConnection();
            String sql = "update hoaDon set MaHD=?, MaKH=?, MaNV=?, tongTien=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, hoaDon.getMaHD());
            st.setString(2, hoaDon.getMaKH());
            st.setString(3, hoaDon.getMaNV());
            st.setInt(3, hoaDon.getTongTien());
            result = st.executeUpdate();
            System.out.println("Số dòng đã bị thay đổi: "+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(int maHD) {
        int result=0;
        try {
            Connection cn = ConnectionDAO.getConnection();
            String sql = ("delete from hoaDon where MaHD="+maHD);
            
            PreparedStatement st = cn.prepareStatement(sql);
            result = st.executeUpdate();
            
            System.out.println("Số dòng đã bị thay đổi: "+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
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
                    "FROM `hoadon`";
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
}
