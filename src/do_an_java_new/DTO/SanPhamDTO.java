    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.DTO;  
public class SanPhamDTO {
    private String maSP;
    private String tenSP;
    private String loaiSP;
    private String donViTinh;
    private int hanSuDung;
    private String moTa;
    private int gia;
    private int soLuongTon;

    public SanPhamDTO(String maSP, String tenSP, String loaiSP, String donViTinh, int hanSuDung, String moTa, int gia, int soLuongTon) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.donViTinh = donViTinh;
        this.hanSuDung = hanSuDung;
        this.moTa = moTa;
        this.gia = gia;
        this.soLuongTon = soLuongTon;
    }

    // Getter và Setter
    public String getMaSP() { return maSP; }
    public void setMaSP(String maSP) { this.maSP = maSP; }

    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }

    public String getLoaiSP() { return loaiSP; }
    public void setLoaiSP(String loaiSP) { this.loaiSP = loaiSP; }

    public String getDonViTinh() { return donViTinh; }
    public void setDonViTinh(String donViTinh) { this.donViTinh = donViTinh; }

    public int getHanSuDung() { return hanSuDung; }
    public void setHanSuDung(int hanSuDung) { this.hanSuDung = hanSuDung; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    public int getGia() { return gia; }
    public void setGia(int gia) { this.gia = gia; }

    public int getSoLuongTon() { return soLuongTon; }
    public void setSoLuongTon(int soLuongTon) { this.soLuongTon = soLuongTon; }
}