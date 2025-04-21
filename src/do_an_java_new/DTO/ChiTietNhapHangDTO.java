/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.DTO;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class ChiTietNhapHangDTO {
    String 
            maPhieu,
            maHang;
    
    int donGia, soLuong;

    public ChiTietNhapHangDTO() {
    }

    public ChiTietNhapHangDTO(String maPhieu, String maHang, int donGia, int soLuong) {
        this.maPhieu = maPhieu;
        this.maHang = maHang;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
