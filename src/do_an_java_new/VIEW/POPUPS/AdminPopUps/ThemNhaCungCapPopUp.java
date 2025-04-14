/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.VIEW.POPUPS.AdminPopUps;

import do_an_java_new.BLL.NhaCungCapBLL;
import do_an_java_new.DTO.NhaCungCapDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class ThemNhaCungCapPopUp extends NhaCungCapPopUp {

    @Override
    public void xacNhan() {
        String 
                id = txtId.getText().trim(),
                ten = txtTen.getText().trim(),
                tenLH = txtTenLH.getText().trim(),
                sdt = txtSDT.getText(),
                tinh = (String) cbbTinh.getSelectedItem(),
                diaChi = txtDiaChi.getText(),
                trangThai = inactive.isSelected()? "inactive" : "active";
        
        NhaCungCapDTO ncc = new NhaCungCapDTO(id, ten, tenLH, sdt, tinh, diaChi, trangThai);
        try {
            NhaCungCapBLL.themNhaCungCap(ncc);
            dispose();
            JOptionPane.showMessageDialog(null, "Thêm nhà cung cấp thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
