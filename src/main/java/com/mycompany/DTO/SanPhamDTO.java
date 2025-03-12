/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DTO;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class SanPhamDTO {
    private String MaSP;
    private String tenSP;
    private String loaiSP;
    private String donViTinh;
    private int hanSuDung;
    private String mota;
    private int gia;
    private int soLuongTon;

    public SanPhamDTO(String MaSP, String tenSP, String loaiSP, String donViTinh, int hanSuDung, String mota, int gia, int soLuongTon) {
        this.MaSP = MaSP;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.donViTinh = donViTinh;
        this.hanSuDung = hanSuDung;
        this.mota = mota;
        this.gia = gia;
        this.soLuongTon = soLuongTon;
    }

    public SanPhamDTO() {
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(int hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }
    
    
}
