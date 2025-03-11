package com.mycompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mycompany.DTO.ChiTietHoaDonDTO;

public class ChiTietHoaDonDAO {
    public static ChiTietHoaDonDAO getInsance() {
        return new ChiTietHoaDonDAO();
    }

    public int insert(ChiTietHoaDonDTO chiTietHoaDon) {
        int result=0;
        try {
            Connection cn = ConnectionDAL.getConnection();
            String sql = "insert into chitiethoadon(Mahd, Mahang, soluong, dongia) value=(?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, chiTietHoaDon.getMaHD());
            st.setString(2, chiTietHoaDon.getMaHang());
            st.setInt(3, chiTietHoaDon.getSoLuong());
            st.setInt(4, chiTietHoaDon.getDonGia());
            result = st.executeUpdate();
            System.out.println("Số dòng bị thay đổi: "+result);

            ConnectionDAL.closeConnection(cn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(ChiTietHoaDonDTO chiTietHoaDon) {
        int result=0;
        try {
            Connection cn = ConnectionDAL.getConnection();
            String sql = "update chitiethoadon set mahang=?, soluong=?, dongia=? where mahd=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, chiTietHoaDon.getMaHD());
            st.setString(2, chiTietHoaDon.getMaHang());
            st.setInt(3, chiTietHoaDon.getSoLuong());
            st.setInt(4, chiTietHoaDon.getDonGia());
            
            result = st.executeUpdate();
            System.out.println("Số dòng bị thay đổi: " + result);
            ConnectionDAL.closeConnection(cn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
