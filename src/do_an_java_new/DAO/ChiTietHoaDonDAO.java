/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.DAO;


import do_an_java_new.DTO.ChiTietHoaDonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author Administrator
 */
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
