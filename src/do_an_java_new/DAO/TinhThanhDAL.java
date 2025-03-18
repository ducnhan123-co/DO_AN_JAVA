/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.management.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS-PC
 */
public class TinhThanhDAL {
    public static ArrayList<String> getDanhSachTinh() {
        ArrayList<String> res = new ArrayList<>();
        try{
            Connection conn = ConnectionDAL.getConnection();
            Statement st = conn.createStatement();
            String query = "select * from TinhThanh";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                res.add(rs.getString("TenTThanh"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return res;
    }

    public static int getMaTinh(String tenTinh) {
        try {
            Connection con = ConnectionDAL.getConnection();
            String query = "select MaTThanh\n" +
                "from TinhThanh\n" +
                "where TenTThanh = ?";
            
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, tenTinh);
            
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("MaTThanh");
            } 
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
