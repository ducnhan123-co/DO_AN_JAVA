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
import java.util.Date;
/**
 *
 * @author Administrator
 */
public class HangDAO {
     public static ArrayList<HangDTO> getHangs() throws SQLException {
        ArrayList<HangDTO> res = new ArrayList<>();
        Connection conn = ConnectionDAL.getConnection();
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
                    new Date(rs.getDate("NgaySanXuat").getTime()),
                    rs.getInt("GiamGia")
            ));
        }
        
        return res ;
    }
}
