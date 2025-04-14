/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.VIEW.POPUPS;
import do_an_java_new.BLL.NhanVienBLL;
import do_an_java_new.DTO.NhanVienDTO;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class SuaNhanVienPopUp extends NhanVienPopUp {
    private NhanVienDTO oldNhanVien ;
    
    public SuaNhanVienPopUp(NhanVienDTO nhanVien) {
        super(nhanVien);
        
        this.oldNhanVien = nhanVien;
        lbID.setVisible(false);
        txtId.setVisible(false);
        setLabel("Sửa nhân viên");
    }
    @Override
    public void xacNhan() {
        String ho = txtHo.getText().trim();
        String tenLot = txtTenLot.getText().trim();
        String ten = txtTen.getText().trim();
        Date ngaySinh = new Date(txtNgaySinh.getDate().getTime());
        String sdt = txtSDT.getText().trim();
        String tinh = cbbTinh.getSelectedItem().toString();
        String diaChi = txtDiaChi.getText().trim();
        int luong = (int) spnLuong.getValue();

        String phai = nam.isSelected() ? "nam" : nu.isSelected() ? "nu" : null;

        String trangThai = active.isSelected() ? "active" : inactive.isSelected() ? "inactive" : null;

        String chucVu = QL.isSelected() ? "QL" : "NV";
        
        NhanVienDTO nhanVien = new NhanVienDTO(oldNhanVien.getMaNV(), ho, tenLot, ten, phai, ngaySinh, sdt, tinh, diaChi, luong, chucVu, trangThai);
        try {
            NhanVienBLL.suaNhanVien(nhanVien);
            
            dispose();
            JOptionPane.showMessageDialog(null, "Sửa nhân viên thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
