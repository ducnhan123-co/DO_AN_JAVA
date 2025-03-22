/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.VIEW.POPUPS;

import do_an_java_new.BLL.SanPhamBLL;
import do_an_java_new.DTO.SanPhamDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author pducn
 */
public class ChiTietSanPhamPopUp extends SanPhamPopUp{
    private SanPhamDTO oldSanPham;
    
     public ChiTietSanPhamPopUp(SanPhamDTO sanPham) {
        super(sanPham);
        oldSanPham = sanPham;
        lbID.setVisible(false);
        txtId.setVisible(false);
        setLabel("Chi tiết sản phẩm");
         btnXacNhan.setVisible(false);
         btnHuy.setText("Đóng");
         
           txtTen.setEditable(false);
    cbbLoai.setEnabled(false);
    cbbDVT.setEnabled(false);
    spnHSD.setEnabled(false);
    spnGia.setEnabled(false);
    txtMota.setEditable(false);
    }
    
    
     @Override
    public void xacNhan() {
       
        
       
    }
   
}
