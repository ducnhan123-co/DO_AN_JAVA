/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DTO;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class ChiTietHoaDonDTO {
    private String maHD;
    private String maHang;
    private int soLuong;
    private int donGia;

    public ChiTietHoaDonDTO() {
    }

    public ChiTietHoaDonDTO(String maHD, String maHang, int soLuong, int donGia) {
        this.maHD = maHD;
        this.maHang = maHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    
}
