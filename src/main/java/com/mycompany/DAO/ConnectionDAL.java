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
            String query = "select * from tinhthanh";
            
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
