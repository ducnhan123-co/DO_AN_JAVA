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
public class ThemKhuyenMaiPopUp extends KhuyenMaiPopUp {

    public ThemKhuyenMaiPopUp() {
        super();
        lbTrangThai.setVisible(false);
        active.setVisible(false);
        inactive.setVisible(false);        
    }
    
    @Override
    public void xacNhan() {
        try {
            String maKM = txtID.getText().trim();
            String tenKM = txtTen.getText().trim();
            String noiDung = txtNoiDung.getText().trim();
            String maSP = txtMaSP.getText().trim();
            Date ngayBD = new Date(txtNgayBD.getDate().getTime());
            Date ngayKT = new Date(txtNgayKT.getDate().getTime());
            int giaTri = (Integer) spnGiaTri.getValue();
            int soLuong = (Integer) spnSoLuong.getValue();
            String trangThai = "active";

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

            if (ngayBD.compareTo(ngayKT) >= 0)
                throw new Exception("Thời gian áp dụng không hợp lệ");

            KhuyenMaiDTO khuyenMai = new KhuyenMaiDTO(
                maKM, tenKM, noiDung, maSP, ngayBD, ngayKT, giaTri, soLuong, trangThai
            );

            KhuyenMaiBLL.themKhuyenMai(khuyenMai);

            dispose();
            JOptionPane.showMessageDialog(null, "Thêm khuyến mãi thành công");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }            
    }

}
