/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.BLL;

import do_an_java_new.DAO.SanPhamDAO;
import do_an_java_new.DTO.SanPhamDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class SanPhamBLL {
     public static ArrayList<SanPhamDTO> getDanhSachSanPham() throws Exception {
        return SanPhamDAO.getDanhSachSanPham();
    }
    
    public static void themSanPham(SanPhamDTO sanPham) throws Exception {
        if (sanPham.getMaSP().isBlank()) 
            throw new Exception("Mã sản phẩm không được để trống.");
        
        if (sanPham.getTenSP().isBlank()) 
            throw new Exception("Tên sản phẩm không được để trống.");
                        
        if (sanPham.getHanSuDung() <= 0) 
            throw new Exception("Hạn sử dụng phải lớn hơn 0.");
        
        if (sanPham.getGia() < 0) 
            throw new Exception("Giá sản phẩm không được âm.");
        
        int maDVT = DonViTinhBLL.getMaDVT(sanPham.getDonViTinh());
        int maloai = LoaiSPBLL.getMaLoai(sanPham.getLoaiSP());
        
        SanPhamDAO.themSanPham(sanPham, maloai, maDVT);
    }
    
    public static void suaSanPham(SanPhamDTO sanPham) throws SQLException, Exception {
        if (sanPham.getMaSP().isBlank()) 
        throw new Exception("Mã sản phẩm không được để trống.");
    
        if (sanPham.getTenSP().isBlank()) 
            throw new Exception("Tên sản phẩm không được để trống.");

        if (sanPham.getHanSuDung() <= 0) 
            throw new Exception("Hạn sử dụng phải lớn hơn 0.");

        if (sanPham.getGia() < 0) 
            throw new Exception("Giá sản phẩm không được âm.");
        
        int maDVT = DonViTinhBLL.getMaDVT(sanPham.getDonViTinh());
        int maloai = LoaiSPBLL.getMaLoai(sanPham.getLoaiSP());
        
        SanPhamDAO.suaSanPham(sanPham, maloai, maDVT);
    }
    public static void xoaSanPham(String maSP) throws Exception {
    if (maSP == null || maSP.isBlank()) 
        throw new Exception("Mã sản phẩm không được để trống.");
    SanPhamDAO.xoaSanPham(maSP);
}

    
    
}
