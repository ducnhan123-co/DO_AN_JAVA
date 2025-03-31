/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.DAO;

import do_an_java_new.DTO.NhapHangDTO;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class NhapHangDAO {
    public static ArrayList<NhapHangDTO> getDanhSachNhapHang() throws SQLException {
        Connection conn = ConnectionDAO.getConnection();
        String query = "SELECT * FROM phieunhaphang";
        
        PreparedStatement st = conn.prepareStatement(query);
        
        ResultSet rs = st.executeQuery();
        ArrayList<NhapHangDTO> res = new ArrayList<>();
        
        while (rs.next()) {
            res.add(new NhapHangDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getDate(5)
            ));
        }
        
        return res ;
    }
}
