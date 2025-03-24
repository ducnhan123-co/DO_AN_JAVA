/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.DAO;

import do_an_java_new.DAO.ConnectionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS-PC
 */
public class DonViTinhDAO {
    public static ArrayList<String> getDanhSachDVT() throws SQLException {
        ArrayList<String> res = new ArrayList<>();
        
        Connection con = ConnectionDAO.getConnection();
        String query = "select TenDonVi\n" +
            "from DonVi";
        PreparedStatement st = con.prepareStatement(query);

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            res.add(rs.getString("TenDonVi"));
        }
       
        
        return res;
    }
    
    public static int getMaDVT(String ten) {
        try {
            Connection con = ConnectionDAO.getConnection();
            String query = "select MaDonVi\n" +
                "from DonVi\n" +
                "where TenDonVi = ?";

            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, ten);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("MaDonVi");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}