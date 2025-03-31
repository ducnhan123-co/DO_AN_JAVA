/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.DAO;

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
}
