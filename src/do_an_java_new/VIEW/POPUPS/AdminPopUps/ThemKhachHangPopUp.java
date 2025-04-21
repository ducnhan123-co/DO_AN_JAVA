/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.VIEW.POPUPS.AdminPopUps;

import do_an_java_new.BLL.KhachHangBLL;
import do_an_java_new.DTO.KhachHangDTO;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;
/**
 *
 * @author Tran Dinh Khanh Du
 */
public class ThemKhachHangPopUp extends KhachHangPopUp{

    @Override
    public void xacNhan() {
        try {
            String maKH = txtId.getText().trim();
            String ho = txtHo.getText().trim();
            String tenLot = txtTenLot.getText().trim();
            String ten = txtTen.getText().trim();
            String phai = nam.isSelected() ? "nam" : nu.isSelected() ? "nu" : null;
            Date ngaySinh = new Date(txtNgaySinh.getDate().getTime());
            String sdt = txtSDT.getText().trim();
            String tinh = (String) cbbTinh.getSelectedItem();
            String diaChi = txtDiaChi.getText().trim();
            Date ngayThamGia = Date.valueOf(LocalDate.now());
            int diem = (int) spnDiem.getValue();
            String trangThai = active.isSelected() ? "active" : "inactive";

            KhachHangDTO khachHang = new KhachHangDTO(maKH, ho, tenLot, ten, phai, ngaySinh, sdt, tinh, diaChi, ngayThamGia, diem, trangThai);
            
            KhachHangBLL.themKhacHang(khachHang);
            
            dispose();
            JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
