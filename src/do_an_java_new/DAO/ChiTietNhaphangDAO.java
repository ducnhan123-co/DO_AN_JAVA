/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.DAO;

import do_an_java_new.DTO.ChiTietHoaDonDTO;
import do_an_java_new.DTO.ChiTietNhapHangDTO;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class ChiTietNhaphangDAO {
    public static ArrayList<ChiTietNhapHangDTO> getDanhSachCTNH() throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "SELECT * FROM chitietpnhap";
        
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        
        ArrayList<ChiTietNhapHangDTO> res = new ArrayList<>();
        while (rs.next()) {
            res.add(new ChiTietNhapHangDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4)
            ));
        }
        
        return res;
    }
    
    public static void themCTNH(ArrayList<ChiTietNhapHangDTO> dsCTNH) throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "INSERT INTO `chitietpnhap` (`MaPhieu`, `MaHang`, `DonGia`, `SoLuong`) \n" +
                "VALUES\n" ;
        
        for (int i = 0 ; i < dsCTNH.size()-1 ; i++) {
            ChiTietNhapHangDTO ct = dsCTNH.get(i);
            query += String.format("('%s', '%s', %d, %d),\n", 
                    ct.getMaPhieu(),
                    ct.getMaHang(),
                    ct.getDonGia(),
                    ct.getSoLuong()
                    );
        }
        
        ChiTietNhapHangDTO ct = dsCTNH.get(dsCTNH.size()-1);
        query += String.format("('%s', '%s', %d, %d)", 
                ct.getMaPhieu(),
                ct.getMaHang(),
                ct.getDonGia(),
                ct.getSoLuong()
                );

        PreparedStatement st = conn.prepareStatement(query);
        st.executeUpdate();
    }
}
