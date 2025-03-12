/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DTO;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class LoaiSPDTO {
    private String maLoai;
    private String tenLoai;
    private String mota;

    public LoaiSPDTO() {
    }

    public LoaiSPDTO(String maLoai, String tenLoai, String mota) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.mota = mota;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
        
}
