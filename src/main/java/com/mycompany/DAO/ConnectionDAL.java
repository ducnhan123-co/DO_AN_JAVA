/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS-PC
 */
public class ConnectionDAL {
    private static final String URL = "jdbc:mysql://localhost:3306/cuahangthucpham";
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static void main(String[] args) {
        try{
            Connection conn = getConnection();
            String query = "select * from sanpham";
            
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            System.out.printf("%-12s| %-25s| %-5s| %-10s| %-8s| %-30s| %-10s| %-10s|\n",
                    "MaSP", "TenSP", "Loai", "DonViTinh", "HSDung", "MoTa", "Gia", "SoLuongTon");
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------------------------");

            // In dữ liệu từng dòng
            while (rs.next()) {
                System.out.printf("%-12s| %-25s| %-5d| %-10d| %-8d| %-30s| %-10d| %-10d|\n",
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("Loai"),
                        rs.getInt("DonViTinh"),
                        rs.getInt("HSDung"),
                        rs.getString("MoTa"),
                        rs.getInt("Gia"),
                        rs.getInt("SoLuongTon"));
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        } catch(Exception e) {
            e.printStackTrace();
        }

        
    }
    
    //Ngắt kết nối jdbc
    public static void closeConnection(Connection cn) {
        try {
            if(cn!=null) {
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
