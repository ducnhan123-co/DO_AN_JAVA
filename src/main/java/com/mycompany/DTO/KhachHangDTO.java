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
public class KhachHangDTO {
    String maKH;
    String ho;
    String tenlot;
    String ten;
    String phai;
    Date ngaysinh;
    String sdt;
    String tinh;
    String diachi;
    Date ngaythamgia;
    int diem;
    String trangthai;
    
    public KhachHangDTO() {};
    public KhachHangDTO(String maKH, String ho, String tenlot, String ten, String phai, Date ngaysinh, String sdt, String tinh, String diachi, Date ngaythamgia, int diem, String trangthai) {
        this.maKH = maKH;
        this.ho = ho;
        this.tenlot = tenlot;
        this.ten = ten;
        this.phai = phai;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.tinh = tinh;
        this.diachi = diachi;
        this.ngaythamgia = ngaythamgia;
        this.diem = diem;
        this.trangthai = trangthai;
    }public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTenlot() {
        return tenlot;
    }

    public void setTenlot(String tenlot) {
        this.tenlot = tenlot;
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

    public Date getNgaythamgia() {
        return ngaythamgia;
    }

    public void setNgaythamgia(Date ngaythamgia) {
        this.ngaythamgia = ngaythamgia;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    
    
}
