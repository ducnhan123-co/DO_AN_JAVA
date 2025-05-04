/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.VIEW.POPUPS.AdminPopUps;
import do_an_java_new.BLL.KhuyenMaiBLL;
import do_an_java_new.BLL.SanPhamBLL;
import do_an_java_new.DTO.KhuyenMaiDTO;
import do_an_java_new.DTO.SanPhamDTO;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class SuaKhuyenMaiPopUp extends KhuyenMaiPopUp {
    private String oldMaKM;
    
    public SuaKhuyenMaiPopUp(KhuyenMaiDTO oldKhuyenMai) {
        super(oldKhuyenMai);
        this.oldMaKM = oldKhuyenMai.getMaKM();
        setLabel("Sửa khuyến mãi");
    }
    
    @Override
    public void xacNhan() {
        try {
            String tenKM = txtTen.getText().trim();
            String noiDung = txtNoiDung.getText().trim();
            String maSP = txtMaSP.getText().trim();
            int giaTri = (Integer) spnGiaTri.getValue();
            int soLuong = (Integer) spnSoLuong.getValue();

            Date ngayBD = new Date(txtNgayBD.getDate().getTime());
            Date ngayKT = new Date(txtNgayKT.getDate().getTime());

            String trangThai = active.isSelected() ? "active" : "inactive";

            if (tenKM.isEmpty()) 
                throw new Exception("Tên khuyến mãi không được bỏ trống!");
            if (maSP.isBlank())
                maSP = null;
            else {
                boolean tmp = false;
                for (SanPhamDTO sp: SanPhamBLL.getDanhSachSanPham(0, 0, "")) 
                    if (sp.getMaSP().equals(maSP)) {
                        tmp = true;
                        break;
                    }

                if (!tmp)
                    throw new Exception("Mã sản phẩm không tồn tại");
            }
            

            KhuyenMaiDTO khuyenMai = new KhuyenMaiDTO(oldMaKM, tenKM, noiDung, maSP, ngayBD, ngayKT, giaTri, soLuong, trangThai);

            KhuyenMaiBLL.updateKhuyenMai(khuyenMai);
            dispose();
            
            JOptionPane.showMessageDialog(null, "Sửa khuyến mãi thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
