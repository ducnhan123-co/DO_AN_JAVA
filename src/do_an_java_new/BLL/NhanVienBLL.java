/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.BLL;

import do_an_java_new.DAO.NhanVienDAO;
import do_an_java_new.DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Administrator
 */
public class NhanVienBLL {
    private static ArrayList<NhanVienDTO> listOf_nhanVien = null;
    
    public static ArrayList<NhanVienDTO> getDanhSachNhanVien(int sortOption, int searchOption, String keyWord) throws Exception {
        if (listOf_nhanVien == null) 
            listOf_nhanVien = NhanVienDAO.getDanhSachNhanVien();
        
        ArrayList<NhanVienDTO> res ;
        if (searchOption > 0) {
            res = new ArrayList<>();
            switch (searchOption) {
                case 1:
                    for (NhanVienDTO nhanvien: listOf_nhanVien) 
                        if (nhanvien.getMaNV().contains(keyWord))
                            res.add(nhanvien);
                    break;
                case 2:
                    for (NhanVienDTO nhanvien: listOf_nhanVien) 
                        if (nhanvien.getTen().contains(keyWord))
                            res.add(nhanvien);
                    break;
                case 3:
                    for (NhanVienDTO nhanvien: listOf_nhanVien) 
                        if (nhanvien.getHo().contains(keyWord))
                            res.add(nhanvien);
                    break;
                case 4:
                    for (NhanVienDTO nhanvien: listOf_nhanVien) 
                        if (nhanvien.getSdt().contains(keyWord))
                            res.add(nhanvien);
                    break;
                default:
                    break;
            }
        } else 
            res = new ArrayList<>(listOf_nhanVien);
        
        switch (sortOption) {
            case 1: 
                res.sort(Comparator.comparing(NhanVienDTO::getTen));
                break;
            case 2: 
                res.sort(Comparator.comparing(NhanVienDTO::getTen).reversed());
                break;
            case 3: 
                res.sort(Comparator.comparingInt(NhanVienDTO::getLuong));
                break;
            case 4: 
                res.sort(Comparator.comparingInt(NhanVienDTO::getLuong).reversed());
                break;
        }
        
        return res;
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
        listOf_nhanVien.add(nhanvien);
    }
    
    public static void suaNhanVien(NhanVienDTO nhanVien) throws Exception {
        int matinh = TinhThanhBLL.getMaTinh(nhanVien.getTinh());
        NhanVienDAO.suaNhanVien(nhanVien, matinh);
        for (int i = 0 ; i < listOf_nhanVien.size() ; i++) 
            if (listOf_nhanVien.get(i).getMaNV().equals(nhanVien.getMaNV()))
                listOf_nhanVien.set(i, nhanVien);
    }    
    
    public static void xoaNhanVien(String manv) throws SQLException {
        NhanVienDAO.xoaNhanVien(manv);
        
        for (int i = 0 ; i < listOf_nhanVien.size() ; i++) 
            if (listOf_nhanVien.get(i).getMaNV().equals(manv))
                listOf_nhanVien.remove(i);
    }
    
    public static NhanVienDTO getNhanVien(String manv) throws Exception {
        if (listOf_nhanVien == null) 
            listOf_nhanVien = NhanVienDAO.getDanhSachNhanVien();
        
        for (NhanVienDTO nhanvien: listOf_nhanVien)
            if (nhanvien.getMaNV().equals(manv))
                return nhanvien;
        
        return null;
    }
}
