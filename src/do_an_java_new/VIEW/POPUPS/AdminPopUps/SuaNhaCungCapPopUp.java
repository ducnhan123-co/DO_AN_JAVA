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
public class SuaNhaCungCapPopUp extends NhaCungCapPopUp{
    private NhaCungCapDTO oldNCC;
    
    public SuaNhaCungCapPopUp(NhaCungCapDTO ncc) {
        super(ncc);
        oldNCC = ncc;
        setLabel("Sửa nhà cung cấp");
    }
    
    @Override
    public void xacNhan() {
        String 
                id = oldNCC.getMaNCC(),
                ten = txtTen.getText().trim(),
                tenLH = txtTenLH.getText().trim(),
                sdt = txtSDT.getText().trim(),
                tinh = (String) cbbTinh.getSelectedItem(),
                diaChi = txtDiaChi.getText().trim(),
                trangThai = active.isSelected() ? "active" : "inactive";
        
        NhaCungCapDTO ncc = new NhaCungCapDTO(id, ten, tenLH, sdt, tinh, diaChi, trangThai);
        
        try {
            NhaCungCapBLL.suaNhaCungCap(ncc);
            
            dispose();
            JOptionPane.showMessageDialog(null, "Sửa nhà cung cấp thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
