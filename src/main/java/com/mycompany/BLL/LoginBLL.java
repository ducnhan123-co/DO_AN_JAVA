/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BLL;

import com.mycompany.DAO.LoginDAO;
import com.mycompany.DAO.NhanVienDAO;
import com.mycompany.DTO.NhanVienDTO;
import com.mycompany.VIEW.AdminFrame;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class LoginBLL {
    public static NhanVienDTO checkLogin(String id, String password) throws Exception {
        if (id.isBlank())
            throw new Exception("Tên người dùng không được rỗng!");
        if (password.isBlank())
            throw new Exception("Mật khẩu không được rỗng!");
        
        if (!LoginDAO.getMatKhau(id).equals(password)) 
            throw new Exception("Sai mật khẩu!!");
        
        return NhanVienDAO.timNhanVien(id);
    }
}
