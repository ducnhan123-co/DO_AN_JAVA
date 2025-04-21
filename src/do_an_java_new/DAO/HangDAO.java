/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.DAO;


import do_an_java_new.DTO.HangDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Administrator
 */
public class HangDAO {
    public static ArrayList<HangDTO> getHangs() throws SQLException {
        ArrayList<HangDTO> res = new ArrayList<>();
        Connection conn = ConnectionDAO.getConnection();
        String query = "select MaHang, hang.MaSP, TenSP, SoLuong, NgaySanXuat, GiamGia\n" +
                "from hang\n" +
                "inner join SanPham on SanPham.MaSP = hang.MaSP";
        
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            res.add(new HangDTO(
                    rs.getString("MaHang"),
                    rs.getString("MaSP"),
                    rs.getString("TenSP"),
                    rs.getInt("SoLuong"),
                    rs.getDate("NgaySanXuat"),
                    rs.getInt("GiamGia")
            ));
        }
        
        return res ;
    }
    
    public static void xoaHang(String mahang) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "DELETE FROM hang \n" +
                "WHERE MaHang = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, mahang);
        
        st.executeUpdate();
    }
    
    public static void themHang(ArrayList<HangDTO> dsHang) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "INSERT INTO `hang` (`MaHang`, `MaSP`, `SoLuong`, `NgaySanXuat`, `GiamGia`) \n" +
                "VALUES\n";
        
        for (int i = 0 ; i < dsHang.size()-1 ; i++) {
            HangDTO hang = dsHang.get(i);
            query += String.format("('%s', '%s', %d, '%s', %d),\n",
                    hang.getMaHang(),
                    hang.getMaSP(),
                    hang.getSoLuong(),
                    hang.getNgaySanXuat().toString(),
                    hang.getGiamGia()
                    );
        } 
        
        HangDTO hang = dsHang.get(dsHang.size()-1);
        
        query += String.format("('%s', '%s', %d, '%s', %d)\n",
                hang.getMaHang(),
                hang.getMaSP(),
                hang.getSoLuong(),
                hang.getNgaySanXuat().toString(),
                hang.getGiamGia()
                );
        
        PreparedStatement st = conn.prepareStatement(query);
        st.executeUpdate();
    }
    
    public static void updateSoLuong(String maHang, int n) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "UPDATE `hang` \n" +
                "SET `SoLuong` = SoLuong + ?\n" +
                "WHERE `hang`.`MaHang` = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setInt(1, n);
        st.setString(2, maHang);
        
        st.executeUpdate();
    }
}
