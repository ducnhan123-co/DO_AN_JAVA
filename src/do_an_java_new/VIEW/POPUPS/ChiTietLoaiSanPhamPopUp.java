/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.VIEW.POPUPS;

import do_an_java_new.BLL.LoaiSPBLL;
import do_an_java_new.DTO.LoaiSPDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author pducn
 */
public class ChiTietLoaiSanPhamPopUp extends SuaLoaiSpPopUp{
     private LoaiSPDTO oldLoai ;
    
    public ChiTietLoaiSanPhamPopUp(LoaiSPDTO loai) {
        super(loai);
        lbID.setVisible(false);
        txtId.setVisible(false);
        oldLoai = loai;
        txtTenLoai.setText(loai.getTenLoai().trim());
        txtMota.setText(loai.getMota().trim());
        setLabel("Chi tiết loại sản phẩm");
        jButton1.setVisible(false);
        jButton2.setText("Đóng");
        
           txtId.setEditable(false);
    txtTenLoai.setEnabled(false);
    txtMota.setEnabled(false);
    }
    
    @Override
    public void xacNhan() {
       
    }
}
