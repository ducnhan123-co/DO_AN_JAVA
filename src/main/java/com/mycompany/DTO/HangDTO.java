/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DTO;

import java.sql.Date;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class HangDTO {
    private String maHang;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private Date ngaySanXuat;
    private int giamGia;

    public HangDTO() {
    }

    public HangDTO(String maHang, String maSP, String tenSP, int soLuong, Date ngaySanXuat, int giamGia) {
        this.maHang = maHang;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.ngaySanXuat = ngaySanXuat;
        this.giamGia = giamGia;
        this.tenSP = tenSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }
    
}
