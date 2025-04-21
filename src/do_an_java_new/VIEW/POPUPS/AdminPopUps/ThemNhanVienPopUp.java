/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.VIEW.POPUPS.AdminPopUps;

import do_an_java_new.BLL.NhanVienBLL;
import do_an_java_new.DTO.NhanVienDTO;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class ThemNhanVienPopUp extends NhanVienPopUp {
    @Override
    public void xacNhan() { 
        try {
            String maNV = txtId.getText().trim();
            String ho = txtHo.getText().trim();
            String tenLot = txtTenLot.getText().trim();
            String ten = txtTen.getText().trim();
            String phai = nam.isSelected() ? "nam" : nu.isSelected() ? "nu" : "null";
            Date ngaySinh = new Date(txtNgaySinh.getDate().getTime());
            String sdt = txtSDT.getText().trim();
            String tinh = (String) cbbTinh.getSelectedItem();
            String diaChi = txtDiaChi.getText().trim();
            int luong = (int) spnLuong.getValue();

            if (buttonGroupChucVu.getSelection() == null) {
                throw new Exception("Hay chon chuc vu");
            }
            String chucVu = QL.isSelected() ? "QL" : "NV";

            if (buttonGroupTrangThai.getSelection() == null) {
                throw new Exception("Hay chon trang thai cho tai khoan");
            }
            String trangThai = active.isSelected() ? "active" : "inactive";

            NhanVienDTO nhanvien = new NhanVienDTO(maNV, ho, tenLot, ten, phai, ngaySinh, sdt, tinh, diaChi, luong, chucVu, trangThai);
            
            NhanVienBLL.themNhanVien(nhanvien);
            
            dispose();
            JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
            
        } catch (Exception e){
            if (e.getMessage().contains("Duplicate entry"))
                JOptionPane.showMessageDialog(null, "Trùng mã nhân viên rồi");
            else 
                JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}
