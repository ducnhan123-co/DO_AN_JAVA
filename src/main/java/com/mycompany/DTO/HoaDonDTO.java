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
public class HoaDonDTO {
    private String MaHD;
    private String maKH;
    private String maNV;
    private int tongTien;
    private Date thoiGian;

    public HoaDonDTO(String MaHD, String maKH, String maNV, int tongTien, Date thoiGian) {
        this.MaHD = MaHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.tongTien = tongTien;
        this.thoiGian = thoiGian;
    }

    public HoaDonDTO() {
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }
    
}
