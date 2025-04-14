/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.BLL;

import do_an_java_new.DAO.ChiTietHoaDonDAO;
import do_an_java_new.DAO.HoaDonDAO;
import do_an_java_new.DTO.ChiTietHoaDonDTO;
import do_an_java_new.DTO.HoaDonDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class HoaDonBLL {
    private static ArrayList<HoaDonDTO> listOf_hoaDon = null;
    
    public static ArrayList<HoaDonDTO> getDanhSachHoaDon(int sortOption, int searchOption, String keyWord) {
        if (listOf_hoaDon == null) {
            listOf_hoaDon = HoaDonDAO.getDanhSachHoaDon() ;
        }
        
        ArrayList<HoaDonDTO>res ;
        if (searchOption != 0) {
            res = new ArrayList<>();
            switch(searchOption) {
                case 1:
                    for (HoaDonDTO hoadon: listOf_hoaDon) 
                        if (hoadon.getMaHD().contains(keyWord))
                            res.add(hoadon);
                    break;
                case 2:
                    for (HoaDonDTO hoadon: listOf_hoaDon) 
                        if (hoadon.getMaNV().contains(keyWord))
                            res.add(hoadon);
                    break;
                case 3:
                    for (HoaDonDTO hoadon: listOf_hoaDon) 
                        if (hoadon.getMaKH().contains(keyWord))
                            res.add(hoadon);
                    break;
                default:
                    break;
            }
        } else 
            res = new ArrayList<>(listOf_hoaDon);
        
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
        
}
