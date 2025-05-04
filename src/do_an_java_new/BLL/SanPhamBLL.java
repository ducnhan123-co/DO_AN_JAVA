/*
    
    public static void suaSanPham(SanPhamDTO sanPham) throws SQLException, Exception {
        if (sanPham.getMaSP().isBlank()) 
        throw new Exception("Mã sản phẩm k
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.BLL;

import do_an_java_new.DAO.SanPhamDAO;
import do_an_java_new.DTO.SanPhamDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class SanPhamBLL {
    private static ArrayList<SanPhamDTO> listOf_product = null;
    
    public static ArrayList<SanPhamDTO> getDanhSachSanPham(int sortOption, int searchOption, String keyWord) throws Exception {
        if (listOf_product == null) {
            listOf_product = SanPhamDAO.getDanhSachSanPham();
        }
        
        ArrayList<SanPhamDTO> res;
        
        if (searchOption == 0) 
            res = new ArrayList<>(listOf_product);
        else {
            res = new ArrayList<>();
            switch(searchOption) {
                case 1:
                    for (SanPhamDTO sanpham: listOf_product) 
                        if (sanpham.getMaSP().contains(keyWord))
                            res.add(sanpham);
                    break;
                case 2:
                    for (SanPhamDTO sanpham: listOf_product) 
                        if (sanpham.getLoaiSP().contains(keyWord))
                            res.add(sanpham);
                    break;
                case 3:
                    for (SanPhamDTO sanpham: listOf_product) 
                        if (sanpham.getTenSP().contains(keyWord))
                            res.add(sanpham);
                    break;
                default: 
                    break;
            }
        }
        
        switch(sortOption) {
            case 1:
                res.sort(Comparator.comparing(SanPhamDTO::getTenSP));
                break;
            case 2:
                res.sort(Comparator.comparing(SanPhamDTO::getTenSP).reversed());
                break;
            case 3:
                res.sort(Comparator.comparingInt(SanPhamDTO::getGia));
                break;
            case 4:
                res.sort(Comparator.comparingInt(SanPhamDTO::getGia).reversed());
                break;
            case 5:
                res.sort(Comparator.comparingInt(SanPhamDTO::getSoLuongTon));
                break;
            case 6:
                res.sort(Comparator.comparingInt(SanPhamDTO::getSoLuongTon).reversed());
                break;
            default:
                break;
        }
        
        return res;
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
        listOf_product.add(sanPham);
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
        for (int i = 0 ; i < listOf_product.size() ; i++) 
            if (listOf_product.get(i).getMaSP().equals(sanPham.getMaSP()))
                listOf_product.set(i, sanPham);
    }
    
    public static void xoaSanPham(String maSP) throws SQLException {
        SanPhamDAO.xoaSanPham(maSP);
        
        for (int i = 0 ; i < listOf_product.size() ; i++) {
            if (listOf_product.get(i).getMaSP().equals(maSP))
                listOf_product.remove(i);
        }
    }
    
    public static SanPhamDTO timSanPham(String masp) throws Exception {
        if (listOf_product == null) {
            listOf_product = SanPhamDAO.getDanhSachSanPham();
        }
        
        for (SanPhamDTO sanpham: listOf_product) {
            if (sanpham.getMaSP().equals(masp))
                return sanpham;
        }
        
        return null;
    }
    
    public static void updateSoLuong(String maSP, int n) throws SQLException, Exception {
        if (listOf_product == null) {
            listOf_product = SanPhamDAO.getDanhSachSanPham();
        }
        
        SanPhamDAO.updateSoLuong(maSP, n);
        for (SanPhamDTO sanPham: listOf_product)
            if (sanPham.getMaSP().equals(maSP)) {
                sanPham.setSoLuongTon(sanPham.getSoLuongTon() + n);
                return;
            }
    }    
    
    public static ArrayList<Object[]> getDanhSachThongKe(Date beginDate, Date endDate) throws SQLException, Exception {
        if (beginDate.compareTo(endDate) > 0)
            throw new Exception("Ngày thống kê không hợp lệ");
        return SanPhamDAO.getDanhSachThongKe(beginDate, endDate);
    }
}
