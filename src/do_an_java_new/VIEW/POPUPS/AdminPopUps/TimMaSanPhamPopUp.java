/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package do_an_java_new.VIEW.POPUPS.AdminPopUps;

import do_an_java_new.BLL.SanPhamBLL;
import do_an_java_new.DTO.SanPhamDTO;
import do_an_java_new.VIEW.WorkSpaces.AdminWorkSpaces.SanPhamPanel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

/**
 *
 * @author ASUS-PC
 */
public class TimMaSanPhamPopUp extends javax.swing.JFrame {
    /**
     * Creates new form TimSanPhamPopUp
    */
     JTextField field;
    
    public TimMaSanPhamPopUp(JTextField field) {
        initComponents();
        renderSanPhamTable();
        
        this.field = field;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        field.setText(maSanPham);
        
        dispose();
    }//GEN-LAST:event_btnFinishMouseClicked
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField txtKeyWord;
    private javax.swing.JLabel txtResultCount;
    // End of variables declaration//GEN-END:variables
}
