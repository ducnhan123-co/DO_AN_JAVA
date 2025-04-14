/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.BLL;

import do_an_java_new.DAO.ChiTietHoaDonDAO;
import do_an_java_new.DTO.ChiTietHoaDonDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class ChiTietHoaDonBLL {
    private static ArrayList<ChiTietHoaDonDTO> listOf_ChiTietHoaDon = null;
    
    public static ArrayList<ChiTietHoaDonDTO> getCTHD(String maHD) throws SQLException {
        if (listOf_ChiTietHoaDon == null) 
            listOf_ChiTietHoaDon = ChiTietHoaDonDAO.getDanhSachCTHD();
        
        ArrayList<ChiTietHoaDonDTO> res = new ArrayList<>();
        
        for (ChiTietHoaDonDTO cthd: listOf_ChiTietHoaDon) 
            if (cthd.getMaHD().equals(maHD))
                res.add(cthd);
        
        return res;
    }
    
    public static ArrayList<ChiTietHoaDonDTO> getDanhSachCTHD() throws SQLException {
        if (listOf_ChiTietHoaDon == null) 
            listOf_ChiTietHoaDon = ChiTietHoaDonDAO.getDanhSachCTHD();
        
        return listOf_ChiTietHoaDon;
    }

}
