/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.BLL;

import do_an_java_new.DAO.HangDAO;
import do_an_java_new.DTO.HangDTO;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Administrator
 */
public class HangBLL {
    private static ArrayList<HangDTO> listOf_hang = null;
    
    public static ArrayList<HangDTO> getHangs() throws SQLException {
        if (listOf_hang == null) 
            listOf_hang = HangDAO.getHangs();
        
        return listOf_hang;
    }
    
    public static ArrayList<HangDTO> getHangs(String maHang) throws SQLException {
        if (listOf_hang == null) 
            listOf_hang = HangDAO.getHangs();
        
        ArrayList<HangDTO> res = new ArrayList<>();
        for (HangDTO hang: listOf_hang)
            if (hang.getMaHang().equals(maHang))
                res.add(hang);
        
        return res;
    }

    public static void xoaHang(String mahang) throws SQLException {
        HangDAO.xoaHang(mahang);
        
        for (int i = 0 ; i < listOf_hang.size() ; i++) 
            if (listOf_hang.get(i).getMaHang().equals(mahang))
                listOf_hang.remove(i);
    }
    
    public static HangDTO timHang(String mahang) throws SQLException {
        if (listOf_hang == null)
            listOf_hang = HangDAO.getHangs();
        
        for (HangDTO hang: listOf_hang) 
            if (hang.getMaHang().equals(mahang))
                return hang;
        
        return null;
    }
    
    public static void themHang(ArrayList<HangDTO> dsHang) throws SQLException, Exception {
        if (listOf_hang == null)
            listOf_hang = HangDAO.getHangs();
        
        HangDAO.themHang(dsHang);
        listOf_hang.addAll(dsHang);
        
        for (HangDTO hang: dsHang)
            SanPhamBLL.updateSoLuong(hang.getMaSP(), hang.getSoLuong());
    }
    
    public static void updateSoLuong(String maHang, int n) throws SQLException, Exception {
        if (listOf_hang == null)
            listOf_hang = HangDAO.getHangs();

        HangDAO.updateSoLuong(maHang, n);
        for (HangDTO hang: listOf_hang)
            if (hang.getMaHang().equals(maHang)) {
                hang.setSoLuong(hang.getSoLuong()+n);
                SanPhamBLL.updateSoLuong(hang.getMaSP(), n);
                return;
            }
    }    
}
