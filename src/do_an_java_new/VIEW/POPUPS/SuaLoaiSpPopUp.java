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
 * @author Tran Dinh Khanh Du
 */
public class SuaLoaiSpPopUp extends LoaiSPPopUp{
    private LoaiSPDTO oldLoai ;
    
    public SuaLoaiSpPopUp(LoaiSPDTO loai) {
        super();
        lbID.setVisible(false);
        txtId.setVisible(false);
        oldLoai = loai;
        txtTenLoai.setText(loai.getTenLoai().trim());
        txtMota.setText(loai.getMota().trim());
        setLabel("Sửa loại sản phẩm");
    }
    
    @Override
    public void xacNhan() {
        String id = oldLoai.getMaLoai();
        String ten = txtTenLoai.getText().trim();
        String mota = txtMota.getText().trim();
        
        try {
            LoaiSPBLL.suaLoaiSP(new LoaiSPDTO(id, ten, mota));
            dispose();
            JOptionPane.showMessageDialog(null, "Sửa loại sản phẩm thành công!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
