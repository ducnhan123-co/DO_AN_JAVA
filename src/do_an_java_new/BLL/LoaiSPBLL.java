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
    public static ArrayList<LoaiSPDTO> getDanhSachLoaiSP() throws Exception {
        return LoaiSPDAO.getDanhSachLoaiSP();
    }
    
    public static void themLoaiSP(LoaiSPDTO loai) throws Exception {
        if (loai.getMaLoai().isBlank())
            throw new Exception("Mã loại không được rỗng");        
        if (loai.getTenLoai().isBlank())
            throw new Exception("Tên loại không được rỗng");
        
        LoaiSPDAO.themLoaiSP(loai);
    }
    public static void suaLoaiSP(LoaiSPDTO loai) throws Exception {
        LoaiSPDAO.suaLoaiSP(loai);
    }    
    
    public static int getMaLoai(String ten) {
        return LoaiSPDAO.getMaLoai(ten);
    }
    
    public static void xoaLoaiSP(String maloai) throws SQLException {
        LoaiSPDAO.xoaLoaiSP(maloai);
    }
}
