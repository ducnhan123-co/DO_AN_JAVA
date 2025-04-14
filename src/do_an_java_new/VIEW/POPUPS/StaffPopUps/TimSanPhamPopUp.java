/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package do_an_java_new.VIEW.POPUPS.StaffPopUps;

import do_an_java_new.BLL.SanPhamBLL;
import do_an_java_new.DTO.ChiTietNhapHangDTO;
import do_an_java_new.DTO.HangDTO;
import do_an_java_new.DTO.SanPhamDTO;
import do_an_java_new.VIEW.WorkSpaces.AdminWorkSpaces.SanPhamPanel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author ASUS-PC
 */
public class TimSanPhamPopUp extends javax.swing.JFrame {

    /**
     * Creates new form TimSanPhamPopUp
     */
    private ChiTietNhapHangDTO ctnh;
    private HangDTO hang;
    
    public TimSanPhamPopUp(ChiTietNhapHangDTO ctnh, HangDTO hang) {
        initComponents();
        txtNgaySanXuat.setDate(Date.valueOf(LocalDate.now()));
        
        this.ctnh = ctnh;
        this.hang = hang;
        renderSanPhamTable();
    }
    
    public void renderSanPhamTable() {
        List<SanPhamDTO> listSP = null;
        
        String keyWord = txtKeyWord.getText().trim();
                
        try {
            listSP = SanPhamBLL.getDanhSachSanPham(0, 1, keyWord);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtResultCount.setText(String.format("Tìm thấy %d kết quả", listSP.size()));
        DefaultTableModel model = (DefaultTableModel) tbSanPham.getModel();

        model.setRowCount(0); 

        for (SanPhamDTO sp : listSP) {
            model.addRow(new Object[] {
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getLoaiSP(),
                sp.getMoTa()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtKeyWord = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        txtResultCount = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNgaySanXuat = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        spnSoLuong = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        spnDonGia = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(665, 450));

        jPanel4.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel4.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        txtKeyWord.setMinimumSize(new java.awt.Dimension(148, 22));
        txtKeyWord.setPreferredSize(new java.awt.Dimension(150, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(txtKeyWord, gridBagConstraints);

        btnRefresh.setText("Tìm");
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(btnRefresh, gridBagConstraints);

        txtResultCount.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        jPanel5.add(txtResultCount, gridBagConstraints);

        btnReset.setText("Đặt lại");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        jPanel5.add(btnReset, gridBagConstraints);

        jPanel4.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnCancel.setBackground(new java.awt.Color(255, 153, 153));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancel.setText("Huỷ");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        jPanel6.add(btnCancel);

        btnFinish.setBackground(new java.awt.Color(153, 255, 153));
        btnFinish.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFinish.setText("Xác nhận");
        btnFinish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinishMouseClicked(evt);
            }
        });
        jPanel6.add(btnFinish);

        getContentPane().add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.BorderLayout());

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại", "Mô tả"
            }
        ));
        jScrollPane1.setViewportView(tbSanPham);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ngày sản xuất:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel9.add(jLabel3, gridBagConstraints);

        txtNgaySanXuat.setPreferredSize(new java.awt.Dimension(130, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel9.add(txtNgaySanXuat, gridBagConstraints);

        jPanel2.add(jPanel9, new java.awt.GridBagConstraints());

        jPanel8.setLayout(new java.awt.GridBagLayout());

        spnSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spnSoLuong.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnSoLuong.setPreferredSize(new java.awt.Dimension(60, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel8.add(spnSoLuong, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Số lượng:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel8.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jPanel8, gridBagConstraints);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        spnDonGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spnDonGia.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 50000));
        spnDonGia.setPreferredSize(new java.awt.Dimension(100, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel7.add(spnDonGia, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Đơn giá:  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel7.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jPanel7, gridBagConstraints);

        jPanel1.add(jPanel2, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        renderSanPhamTable();
    }//GEN-LAST:event_btnRefreshMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        txtKeyWord.setText("");
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        dispose();
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnFinishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinishMouseClicked
        int selectedRow = tbSanPham.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Hãy chọn sản phẩm cần thêm!", "", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String maSanPham = (String) tbSanPham.getValueAt(selectedRow, 0);
        int soLuong = (int) spnSoLuong.getValue();
        int donGia = (int) spnDonGia.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yymmddhhmmss");
        String maHang = String.format("%s.%s", maSanPham, LocalDateTime.now().format(formatter));
        
        hang.setMaHang(maHang);
        hang.setMaSP(maSanPham);
        hang.setSoLuong(soLuong);
        hang.setNgaySanXuat(new Date(txtNgaySanXuat.getDate().getTime()));
        hang.setGiamGia(0);
        
        try {
            hang.setTenSP(SanPhamBLL.timSanPham(maSanPham).getTenSP());
        } catch (Exception e){
            e.printStackTrace();
        }
        
        ctnh.setMaHang(maHang);
        ctnh.setDonGia(donGia);
        ctnh.setSoLuong(soLuong);
        
        dispose();
    }//GEN-LAST:event_btnFinishMouseClicked
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnDonGia;
    private javax.swing.JSpinner spnSoLuong;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField txtKeyWord;
    private com.toedter.calendar.JDateChooser txtNgaySanXuat;
    private javax.swing.JLabel txtResultCount;
    // End of variables declaration//GEN-END:variables
}
