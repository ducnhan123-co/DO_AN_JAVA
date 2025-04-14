/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.VIEW.POPUPS;

import do_an_java_new.BLL.KhachHangBLL;
import do_an_java_new.DTO.KhachHangDTO;
import java.sql.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class SuaKhachHangPopUp extends KhachHangPopUp {
    private KhachHangDTO oldKhachHang;
    
    public SuaKhachHangPopUp(KhachHangDTO khachHang) {
        super(khachHang);
        
        txtId.setVisible(false);
        lbID.setVisible(false);
        
        this.oldKhachHang = khachHang;
        setLabel("Sửa khách hàng");
    }

    @Override
    public void xacNhan() {
        try {
            if (buttonGroupTrangThai.getSelection() == null) {
                throw new Exception("Hay chon trang thai cua tai khoan!");
            }
            
            String id = oldKhachHang.getMaKH().trim();
            String ho = txtHo.getText().trim();
            String tenlot = txtTenLot.getText().trim();
            String ten = txtTen.getText().trim();
            String phai = nam.isSelected() ? "nam" : nu.isSelected() ? "nu" : null;
            Date ngaySinh = new Date(txtNgaySinh.getDate().getTime());
            String sdt = txtSDT.getText().trim();
            String tinh = cbbTinh.getSelectedItem().toString().trim();
            String diaChi = txtDiaChi.getText().trim();
            int diem =(int) spnDiem.getValue();
            String trangThai = active.isSelected() ? "Active" : "Inactive";
            
            KhachHangDTO khachhang = new KhachHangDTO(id, ho, tenlot, ten, phai, ngaySinh, sdt, tinh, diaChi, oldKhachHang.getNgaythamgia(), diem, trangThai);
            
            KhachHangBLL.suaKhachHang(khachhang);
            JOptionPane.showMessageDialog(null, "Sửa khách hàng thành công");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
