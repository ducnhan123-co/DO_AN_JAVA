/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.BLL;

import do_an_java_new.DAO.KhachHangDAO;
import do_an_java_new.DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class KhachHangBLL {
    public static ArrayList<KhachHangDTO> getDanhSachKhachHang() throws Exception {
        return KhachHangDAO.getDanhSachKhachHang();
    }
    
    public static void themKhacHang(KhachHangDTO khachhang) throws Exception {
        if (khachhang.getMaKH().isBlank()) 
            throw new Exception("Ma khach hang khong dc rong");
        if (khachhang.getHo().isBlank()) 
            throw new Exception("Ho khach hang khong dc rong");
        if (khachhang.getTen().isBlank()) 
            throw new Exception("Ten khach hang khong dc rong");
        if (khachhang.getPhai().isBlank()) 
            throw new Exception("Hay chon gioi tinh");
        
        int maTinh = TinhThanhBLL.getMaTinh(khachhang.getTinh());
        
        KhachHangDAO.themKhachHang(khachhang, maTinh);
    }
    
    public static void suaKhachHang(KhachHangDTO khachhang) throws Exception {
        if(khachhang.getHo().isBlank())
            throw new Exception("Ho khong duoc rong!");
        if(khachhang.getTen().isBlank())
            throw new Exception("Ho khong duoc rong!");
        
        int maTinh = TinhThanhBLL.getMaTinh(khachhang.getTinh());
        
        KhachHangDAO.suaKhachHang(khachhang, maTinh);
    }    
}
