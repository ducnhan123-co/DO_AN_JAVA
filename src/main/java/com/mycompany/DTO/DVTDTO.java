/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.DTO;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class DVTDTO {
    private String maDV;
    private String tenDV;
    private String mota;

    public DVTDTO() {
    }

    public DVTDTO(String maDV, String tenDV, String mota) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.mota = mota;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
    
}
