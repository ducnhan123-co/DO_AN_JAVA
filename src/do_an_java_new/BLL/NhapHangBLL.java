/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.BLL;

import do_an_java_new.DAO.NhapHangDAO;
import do_an_java_new.DTO.NhapHangDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class NhapHangBLL {
    public static ArrayList<NhapHangDTO> listOf_nhapHang = null;
    
    public static ArrayList<NhapHangDTO> getDanhSachNhapHang (int sortOption, int searchOption, String keyWord) throws SQLException {
        if (listOf_nhapHang == null) 
            listOf_nhapHang = NhapHangDAO.getDanhSachNhapHang();
        
        ArrayList<NhapHangDTO> res ;
        if (searchOption > 0) {
            res = new ArrayList<>();
            switch (searchOption) {
                case 1:
                    for (NhapHangDTO nhapHang: listOf_nhapHang) 
                        if (nhapHang.getMaPhieu().contains(keyWord))
                            res.add(nhapHang);
                    break;
                case 2:
                    for (NhapHangDTO nhapHang: listOf_nhapHang) 
                        if (nhapHang.getMaNCC().contains(keyWord))
                            res.add(nhapHang);
                    break;
                case 3:
                    for (NhapHangDTO nhapHang: listOf_nhapHang) 
                        if (nhapHang.getMaNV().contains(keyWord))
                            res.add(nhapHang);
                    break;
                default:
                    break;
            }
        } else 
            res = new ArrayList<>(listOf_nhapHang);
        
        switch (sortOption) {
            case 1: 
                res.sort(Comparator.comparing(NhapHangDTO::getTongTien));
                break;
            case 2: 
                res.sort(Comparator.comparing(NhapHangDTO::getTongTien).reversed());
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
        
        return res;
        
    }
}
