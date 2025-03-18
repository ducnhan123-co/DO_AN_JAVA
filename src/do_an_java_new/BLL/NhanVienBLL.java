/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.BLL;

import do_an_java_new.DAO.NhanVienDAO;
import do_an_java_new.DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class NhanVienBLL {
    public static ArrayList<NhanVienDTO> getDanhSachNhanVien() throws Exception {
        return NhanVienDAO.getDanhSachNhanVien();
    }
    
    public static void themNhanVien(NhanVienDTO nhanvien) throws Exception {
        if (nhanvien.getMaNV() == null || nhanvien.getMaNV().isBlank()) {
            throw new Exception("Mã nhân viên không được để trống!");
        }
        if (nhanvien.getHo() == null || nhanvien.getHo().isBlank()) {
            throw new Exception("Họ không được để trống!");
        }
        if (nhanvien.getTen() == null || nhanvien.getTen().isEmpty()) {
            throw new Exception("Tên không được để trống!");
        }
        if (nhanvien.getSdt() == null || nhanvien.getSdt().isBlank()) {
            throw new Exception("Số điện thoại không được để trống!");
        }
        if (nhanvien.getLuong() < 0)
            throw new IllegalArgumentException("Luong khong duoc nho hon 0");
        int maTinh = TinhThanhBLL.getMaTinh(nhanvien.getTinh());
        
        NhanVienDAO.themNhanVien(nhanvien, maTinh);
    }
    
    public static void suaNhanVien(NhanVienDTO nhanVien) throws Exception {
        int matinh = TinhThanhBLL.getMaTinh(nhanVien.getTinh());
        NhanVienDAO.suaNhanVien(nhanVien, matinh);
    }    
}
