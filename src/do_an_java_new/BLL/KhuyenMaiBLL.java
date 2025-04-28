/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.BLL;

import do_an_java_new.DAO.KhuyenMaiDAO;
import do_an_java_new.DTO.KhuyenMaiDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class KhuyenMaiBLL {
    public static ArrayList<KhuyenMaiDTO> listOf_khuyenMai = null;
    
    public static ArrayList<KhuyenMaiDTO> getDanhSachKhuyenMai() throws SQLException {
        if (listOf_khuyenMai == null)
            listOf_khuyenMai = KhuyenMaiDAO.getDanhSachKhuyenMai();
        
        return listOf_khuyenMai;
    }
    
    public static void themKhuyenMai(KhuyenMaiDTO khuyenMai) throws SQLException {
        if (listOf_khuyenMai == null)
            listOf_khuyenMai = KhuyenMaiDAO.getDanhSachKhuyenMai();
        
        KhuyenMaiDAO.themKhuyenMai(khuyenMai);
        listOf_khuyenMai.add(khuyenMai);
    }
    
    public static KhuyenMaiDTO timKhuyenMai(String maKM) throws SQLException {
        if (listOf_khuyenMai == null)
            listOf_khuyenMai = KhuyenMaiDAO.getDanhSachKhuyenMai();

        for (KhuyenMaiDTO khuyenMai: listOf_khuyenMai)   
            if (khuyenMai.getMaKM().equals(maKM))
                return khuyenMai;

        return null;
    }
    
    public static void updateSoLuong(String maKM, int count) throws SQLException {
        if (listOf_khuyenMai == null)
            listOf_khuyenMai = KhuyenMaiDAO.getDanhSachKhuyenMai();

        KhuyenMaiDAO.updateSoLuong(maKM, count);
        for (KhuyenMaiDTO km: listOf_khuyenMai)
            if (km.getMaKM().equals(maKM))
                km.setSoLuong(km.getSoLuong()+count);
    }    
}
