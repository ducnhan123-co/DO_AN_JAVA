/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.BLL;

import do_an_java_new.DAO.HoaDonDAO;
import do_an_java_new.DTO.HoaDonDTO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class HoaDonBLL {
    private static ArrayList<HoaDonDTO> listOf_hoaDon = null;
    
    public static ArrayList<HoaDonDTO> getDanhSachHoaDon(int sortOption, String keyWord) {
        if (listOf_hoaDon == null) {
            listOf_hoaDon = HoaDonDAO.getDanhSachHoaDon() ;
        }
        
        ArrayList<HoaDonDTO> res = new ArrayList<>();
       
        if (keyWord.equals("")) 
            res = listOf_hoaDon;
        else 
            for (HoaDonDTO hoadon: listOf_hoaDon) 
                if (hoadon.getMaHD().equals(keyWord)) {
                    res.add(hoadon);
                    return res;
                }
            
        
        switch(sortOption) {
            case 1:
                res.sort(Comparator.comparingInt(HoaDonDTO::getTongTien));
                break;
            case 2:
                res.sort(Comparator.comparingInt(HoaDonDTO::getTongTien).reversed());
                break;
            case 3:
                res.sort((x, y) -> (x.getThoiGian().compareTo(y.getThoiGian())));
                break;
            case 4:
                res.sort((x, y) -> (y.getThoiGian().compareTo(x.getThoiGian())));
                break;
            default: 
                break;
        }
        
        return res ;
    }
        
    public static void themHoaDon(HoaDonDTO hd) throws Exception {
        if (hd.getMaHD().isBlank() || hd.getMaKH().isBlank() || hd.getMaNV().isBlank())
            throw new Exception("Hãy nhập đủ thông tin!");
        
        if (listOf_hoaDon == null) {
            listOf_hoaDon = HoaDonDAO.getDanhSachHoaDon() ;
        }

        HoaDonDAO.themHoaDon(hd);
        listOf_hoaDon.add(hd);
    }
    
    public static void xoaHoaDon(String maHD) throws SQLException {
        if (listOf_hoaDon == null) 
            listOf_hoaDon = HoaDonDAO.getDanhSachHoaDon() ;
        
        HoaDonDAO.xoaHoaDon(maHD);
        
        for(int i = 0 ; i < listOf_hoaDon.size() ; i++) 
            if (listOf_hoaDon.get(i).getMaHD().equals(maHD))
                listOf_hoaDon.remove(i);
    }
    
    public static ArrayList<Object[]> thongKeDoanhThu(Date beginDate, Date endDate) throws SQLException {
        if (beginDate.after(endDate)) {
            throw new IllegalArgumentException("Ngày bắt đầu phải trước hoặc bằng ngày kết thúc.");
        }

        return HoaDonDAO.thongKeDoanhThu(beginDate, endDate);        
    }
    
    public static int[] thongKeTheoQuy(int year) throws SQLException {
       
        return HoaDonDAO.thongKeTheoQuy(year);        
        
    }    
}
