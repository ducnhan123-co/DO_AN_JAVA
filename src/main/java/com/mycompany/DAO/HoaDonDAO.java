package com.mycompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import com.mycompany.DTO.HoaDonDTO;

public class HoaDonDAO {
    public static HoaDonDAO getInstance() {
        return new HoaDonDAO();
    }

    public int insert(HoaDonDTO hoaDon) {
        int result = 0;
        try {
            Connection cn = ConnectionDAL.getConnection();
            String sql = "insert into hoaDon(MaHD, MaKH, MaNV, tongTien, thoiGian) (?,?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, hoaDon.getMaHD());
            st.setString(2, hoaDon.getMaKH());
            st.setString(3, hoaDon.getMaNV());
            st.setInt(4, hoaDon.getTongTien());
            st.setDate(5, hoaDon.getThoiGian());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(HoaDonDTO hoaDon) {
        int result = 0;
        try {
            Connection cn = ConnectionDAL.getConnection();
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
            Connection cn = ConnectionDAL.getConnection();
            String sql = ("delete from hoaDon where MaHD="+maHD);
            PreparedStatement st = cn.prepareStatement(sql);
            result = st.executeUpdate();
            System.out.println("Số dòng đã bị thay đổi: "+result);
            ConnectionDAL.closeConnection(cn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //Lấy tất cả dl của hoadon từ database
    public ArrayList<HoaDonDTO> selectAll() {
        ArrayList<HoaDonDTO> result = new ArrayList<HoaDonDTO>();
        try {
            Connection cn = ConnectionDAL.getConnection();
            String sql = "select * from hoadon";
            PreparedStatement st = cn.prepareStatement(sql);
            System.out.println("Chạy câu lệnh: "+sql);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                String maHD = rs.getString("MaHD");
                String maKH = rs.getString("MaKH");
                String maNV = rs.getString("MaNV");
                int tongTien = rs.getInt("TongTien");
                Date thoiGian = rs.getDate("ThoiGian");
                
                HoaDonDTO tmp = new HoaDonDTO(maHD, maKH, maNV, tongTien, thoiGian);
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
            Connection cn = ConnectionDAL.getConnection();
            String sql = "select * from hoadon where MaHD=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, id);
            System.out.println("Chạy câu lệnh: "+sql);

            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String maHD = rs.getString("MaHD");
                String maKH = rs.getString("MaKH");
                String maNV = rs.getString("MaNV");
                int tongTien = rs.getInt("TongTien");
                Date thoiGian = rs.getDate("ThoiGian");
                result = new HoaDonDTO(maHD, maKH, maNV, tongTien, thoiGian);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
