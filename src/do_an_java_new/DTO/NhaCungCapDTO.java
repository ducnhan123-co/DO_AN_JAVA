/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.DTO;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class NhaCungCapDTO {
    private String 
            maNCC,
            tenNCC,
            tenLienHe,
            sdt,
            tinhThanh,
            diaChi,
            trangThai;

    public NhaCungCapDTO() {
    }

    public NhaCungCapDTO(String maNCC, String tenNCC, String tenLienHe, String sdt, String tinhThanh, String diaChi, String trangThai) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.tenLienHe = tenLienHe;
        this.sdt = sdt;
        this.tinhThanh = tinhThanh;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getTenLienHe() {
        return tenLienHe;
    }

    public void setTenLienHe(String tenLienHe) {
        this.tenLienHe = tenLienHe;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
