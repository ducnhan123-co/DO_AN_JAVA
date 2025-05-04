/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.BLL;

import do_an_java_new.DAO.ChiTietNhaphangDAO;
import do_an_java_new.DTO.ChiTietNhapHangDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class ChiTietNhapHangBLL {
    public static ArrayList<ChiTietNhapHangDTO> listOf_CTNH  = null;
    
    public static ArrayList<ChiTietNhapHangDTO> getDanhSachCTNH() throws SQLException {
        if (listOf_CTNH == null) 
            listOf_CTNH = ChiTietNhaphangDAO.getDanhSachCTNH();
        
        return listOf_CTNH;
    }
    
    public static ArrayList<ChiTietNhapHangDTO> getCTNH(String maHD) throws SQLException {
        if (listOf_CTNH == null) 
            listOf_CTNH = ChiTietNhaphangDAO.getDanhSachCTNH();
        
        ArrayList<ChiTietNhapHangDTO> res = new ArrayList<>();
        for (ChiTietNhapHangDTO ctnh: listOf_CTNH) 
            if (ctnh.getMaPhieu().equals(maHD))
                res.add(ctnh);
        
        return res;
    }
    
    public static void themCTNH(ArrayList<ChiTietNhapHangDTO> dsCTNH) throws SQLException {
        if (listOf_CTNH == null) 
            listOf_CTNH = ChiTietNhaphangDAO.getDanhSachCTNH();
        
        ChiTietNhaphangDAO.themCTNH(dsCTNH);
        listOf_CTNH.addAll(dsCTNH);
    }
    public static void xoaPhieuNhap(String maNH) throws SQLException {
        if (listOf_CTNH == null)
            listOf_CTNH = ChiTietNhaphangDAO.getDanhSachCTNH();

        ChiTietNhaphangDAO.xoaPhieuNhap(maNH);

        listOf_CTNH.removeIf(ctnh -> ctnh.getMaPhieu().equals(maNH));
    }    
}
