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
public class NhanVienDTO {
    String maNV;
    String ho;
    String tenLot;
    String ten;
    String phai;
    Date ngaysinh;
    String sdt;
    String tinh;
    String diachi;
    int luong;
    String chucVu;
    String trangthai;

    public NhanVienDTO() {
    }

    public NhanVienDTO(String maNV, String ho, String holot, String ten, String phai, Date ngaysinh, String sdt, String tinh, String diachi, int luong, String chucVu, String trangthai) {
        this.maNV = maNV;
        this.ho = ho;
        this.tenLot = holot;
        this.ten = ten;
        this.phai = phai;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.tinh = tinh;
        this.diachi = diachi;
        this.luong = luong;
        this.chucVu = chucVu;
        this.trangthai = trangthai;
    }

    public String getFullName() {
        return ho + " " + tenLot + " " + ten;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTenLot() {
        return tenLot;
    }

    public void setTenLot(String tenLot) {
        this.tenLot = tenLot;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}
