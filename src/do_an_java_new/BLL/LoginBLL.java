/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.BLL;

import do_an_java_new.DAO.NhanVienDAO;
import do_an_java_new.DTO.NhanVienDTO;

/**
 *
 * @author Administrator
 */
public class LoginBLL {
    public static NhanVienDTO checkLogin(String id, String password) throws Exception {
        if (id.isBlank() || password.isBlank())
            throw new Exception("Hãy nhập đầy đủ thông tin!");
        
        NhanVienDTO nhanvien = NhanVienBLL.getNhanVien(id);
        
        if (nhanvien == null || !nhanvien.getMaNV().equals(password))
            throw new Exception("Sai tài khoản đăng nhập hoặc mật khẩu");
        
        return nhanvien;
    }
}
