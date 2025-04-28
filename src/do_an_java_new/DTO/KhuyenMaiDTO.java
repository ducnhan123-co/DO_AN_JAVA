/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.DTO;
import java.sql.Date;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class KhuyenMaiDTO {
    private String 
            maKM,
            tenKM,
            noiDung,
            maSP,
            trangThai;
    
    private Date 
            ngayBD,
            ngayKT;
            
    private int giaTri, soLuong;

    public KhuyenMaiDTO() {
    }

    public KhuyenMaiDTO(String maKM, String tenKM, String noiDung, String maSP, Date ngayBD, Date ngayKT, int giaTri, int soLuong, String trangThai) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.noiDung = noiDung;
        this.maSP = maSP;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.giaTri = giaTri;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }



    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }
    
    
}
