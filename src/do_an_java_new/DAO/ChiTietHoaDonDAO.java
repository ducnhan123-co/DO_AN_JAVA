/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.DAO;


import do_an_java_new.DTO.ChiTietHoaDonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author Administrator
 */
public class ChiTietHoaDonDAO {
    public static ChiTietHoaDonDAO getInsance() {
        return new ChiTietHoaDonDAO();
    }
    
    public static ArrayList<ChiTietHoaDonDTO> getDanhSachCTHD() throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "SELECT * FROM chitiethoadon";
        
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        
        ArrayList<ChiTietHoaDonDTO> res = new ArrayList<>();
        
        while (rs.next()) {
            res.add(new ChiTietHoaDonDTO(
                    rs.getString("MaHD"),
                    rs.getString("MaHang"),
                    rs.getInt("DonGia"),
                    rs.getInt("SoLuong")
            ));
        }
        
        return res;
    }

    public int insert(ChiTietHoaDonDTO chiTietHoaDon) {
        int result=0;
        try {
            Connection cn = ConnectionDAO.getConnection();
            String sql = "insert into chitiethoadon(Mahd, Mahang, soluong, dongia) value=(?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, chiTietHoaDon.getMaHD());
            st.setString(2, chiTietHoaDon.getMaHang());
            st.setInt(3, chiTietHoaDon.getSoLuong());
            st.setInt(4, chiTietHoaDon.getDonGia());
            result = st.executeUpdate();
            System.out.println("Số dòng bị thay đổi: "+result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(ChiTietHoaDonDTO chiTietHoaDon) {
        int result=0;
        try {
            Connection cn = ConnectionDAO.getConnection();
            String sql = "update chitiethoadon set mahang=?, soluong=?, dongia=? where mahd=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, chiTietHoaDon.getMaHD());
            st.setString(2, chiTietHoaDon.getMaHang());
            st.setInt(3, chiTietHoaDon.getSoLuong());
            st.setInt(4, chiTietHoaDon.getDonGia());
            
            result = st.executeUpdate();
            System.out.println("Số dòng bị thay đổi: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
