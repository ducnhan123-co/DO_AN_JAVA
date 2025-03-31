/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.BLL;

import do_an_java_new.DAO.LoaiSPDAO;
import do_an_java_new.DTO.LoaiSPDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class LoaiSPBLL {
    public static ArrayList<LoaiSPDTO> listOf_loaiSP = null;
    
    public static ArrayList<LoaiSPDTO> getDanhSachLoaiSP() throws Exception {
        if (listOf_loaiSP == null) 
            listOf_loaiSP = LoaiSPDAO.getDanhSachLoaiSP();

        return listOf_loaiSP;
    }
    
    public static void themLoaiSP(LoaiSPDTO loai) throws Exception {
        if (loai.getMaLoai().isBlank())
            throw new Exception("Mã loại không được rỗng");        
        if (loai.getTenLoai().isBlank())
            throw new Exception("Tên loại không được rỗng");
        
        LoaiSPDAO.themLoaiSP(loai);
        listOf_loaiSP.add(loai);
    }
    public static void suaLoaiSP(LoaiSPDTO loai) throws Exception {
        LoaiSPDAO.suaLoaiSP(loai);
        for (int i = 0 ; i < listOf_loaiSP.size() ; i++) 
            if (listOf_loaiSP.get(i).getMaLoai().equals(loai.getMaLoai()))
                listOf_loaiSP.set(i, loai);
    }    
    
    public static int getMaLoai(String ten) {
        for (LoaiSPDTO loai: listOf_loaiSP)
            if (loai.getTenLoai().equals(ten))
                return Integer.parseInt(loai.getMaLoai());
        return -1;
    }
    
    public static void xoaLoaiSP(String maloai) throws SQLException {
        LoaiSPDAO.xoaLoaiSP(maloai);
        
        for (int i = 0 ; i < listOf_loaiSP.size() ; i++) 
            if (listOf_loaiSP.get(i).getMaLoai().equals(maloai))
                listOf_loaiSP.remove(i);
    }
}
