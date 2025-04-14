/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.VIEW.POPUPS.AdminPopUps;

import do_an_java_new.BLL.SanPhamBLL;
import do_an_java_new.DTO.SanPhamDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class SuaSanPhamPopUp extends SanPhamPopUp {
    private SanPhamDTO oldSanPham;
    
    public SuaSanPhamPopUp(SanPhamDTO sanPham) {
        super(sanPham);
        oldSanPham = sanPham;
        lbID.setVisible(false);
        txtId.setVisible(false);
        setLabel("Sửa sản phẩm");
    }
    
    @Override
    public void xacNhan() {
        String maSP = txtId.getText().trim();
        String tenSP = txtTen.getText().trim();
        String loaiSP = (String) cbbLoai.getSelectedItem();
        String donViTinh = (String) cbbDVT.getSelectedItem();
        int hanSuDung = (Integer) spnHSD.getValue();
        String moTa = txtMota.getText().trim();
        int gia = (Integer) spnGia.getValue();
        
        try {
            SanPhamBLL.suaSanPham(new SanPhamDTO(maSP, tenSP, loaiSP, donViTinh, hanSuDung, moTa, gia, 0));
            dispose();
            JOptionPane.showMessageDialog(null, "Sửa sản phẩm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
