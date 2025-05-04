/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.BLL;

import do_an_java_new.DAO.KhachHangDAO;
import do_an_java_new.DTO.KhachHangDTO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class KhachHangBLL {
    private static ArrayList<KhachHangDTO> listOf_khachHang = null;
    
    public static ArrayList<KhachHangDTO> getDanhSachKhachHang(int sortOption, int searchOption, String keyWord) throws Exception {
        if (listOf_khachHang == null)
            listOf_khachHang = KhachHangDAO.getDanhSachKhachHang();
        
        ArrayList<KhachHangDTO> res ;
        
        if (searchOption != 0) {
            res = new ArrayList<>();
            switch(searchOption) {
                case 1:
                    for (KhachHangDTO khachhang: listOf_khachHang) 
                        if (khachhang.getMaKH().contains(keyWord))
                            res.add(khachhang);
                    break;
                case 2:
                    for (KhachHangDTO khachhang: listOf_khachHang) 
                        if (khachhang.getTen().contains(keyWord))
                            res.add(khachhang);
                    break;
                case 3:
                    for (KhachHangDTO khachhang: listOf_khachHang) 
                        if (khachhang.getHo().contains(keyWord))
                            res.add(khachhang);
                case 4: 
                    for (KhachHangDTO khachhang: listOf_khachHang) 
                        if (khachhang.getSdt().contains(keyWord))
                            res.add(khachhang);
                    break;
            }   
        } else 
            res = new ArrayList<>(listOf_khachHang);
        
        switch(sortOption) {
            case 1:
                res.sort(Comparator.comparing(KhachHangDTO::getTen));
                break;
            case 2:
                res.sort(Comparator.comparing(KhachHangDTO::getTen).reversed());
                break;
            case 3:
                res.sort(Comparator.comparingInt(KhachHangDTO::getDiem));
                break;
            case 4:
                res.sort(Comparator.comparingInt(KhachHangDTO::getDiem).reversed());
                break;
            default:
                break;
        }
        
        return res;
    }
    
    public static void themKhacHang(KhachHangDTO khachhang) throws Exception {
        if (listOf_khachHang == null)
            listOf_khachHang = KhachHangDAO.getDanhSachKhachHang();
        
        if (khachhang.getMaKH().isBlank()) 
            throw new Exception("Ma khach hang khong dc rong");
        if (khachhang.getHo().isBlank()) 
            throw new Exception("Ho khach hang khong dc rong");
        if (khachhang.getTen().isBlank()) 
            throw new Exception("Ten khach hang khong dc rong");
        if (khachhang.getPhai().isBlank()) 
            throw new Exception("Hay chon gioi tinh");
        for (KhachHangDTO khach: listOf_khachHang) 
            if (khach.getMaKH().equals(khachhang.getMaKH()))
                throw new Exception("Mã khách hàng đã được sử dụng");
        
        for (KhachHangDTO khachHang: listOf_khachHang) {
            if (khachHang.getSdt().equals(khachhang.getSdt()))
                throw new Exception("Số điện thoại đã được dùng");
        }
        int maTinh = TinhThanhBLL.getMaTinh(khachhang.getTinh());
        
        KhachHangDAO.themKhachHang(khachhang, maTinh);
        listOf_khachHang.add(khachhang);
    }
    
    public static void suaKhachHang(KhachHangDTO khachhang) throws Exception {
        if (listOf_khachHang == null)
            listOf_khachHang = KhachHangDAO.getDanhSachKhachHang();
        
        if(khachhang.getHo().isBlank())
            throw new Exception("Ho khong duoc rong!");
        if(khachhang.getTen().isBlank())
            throw new Exception("Ho khong duoc rong!");
        
        int maTinh = TinhThanhBLL.getMaTinh(khachhang.getTinh());
        
        KhachHangDAO.suaKhachHang(khachhang, maTinh);
        for (int i = 0 ; i < listOf_khachHang.size() ; i++) {
            if (listOf_khachHang.get(i).getMaKH().equals(khachhang.getMaKH()))
                listOf_khachHang.set(i, khachhang);
        }
    }    
    
    public static void xoaKhachHang(String makh) throws SQLException, Exception {
        if (listOf_khachHang == null)
            listOf_khachHang = KhachHangDAO.getDanhSachKhachHang();
        
        KhachHangDAO.xoaKhachHang(makh);
        
        for (int i = 0 ; i < listOf_khachHang.size() ; i++) 
            if (listOf_khachHang.get(i).getMaKH().equals(makh))
                listOf_khachHang.remove(i);
    }
    public static ArrayList<Object[]> thongKeKhachHang(Date beginDate, Date endDate) throws SQLException, Exception {
        if (beginDate.compareTo(endDate) >= 0) 
            throw new Exception("Thời gian thống kê không hợp lệ");
        
        return KhachHangDAO.thongKeKhachHang(beginDate, endDate);
    }
}
