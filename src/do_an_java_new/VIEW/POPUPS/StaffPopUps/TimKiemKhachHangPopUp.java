/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package do_an_java_new.VIEW.POPUPS.StaffPopUps;

import do_an_java_new.BLL.KhachHangBLL;
import do_an_java_new.DTO.KhachHangDTO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS-PC
 */
public class TimKiemKhachHangPopUp extends javax.swing.JFrame {

    /**
     * Creates new form TimKiemKhachHangPopUp
     */
    JTextField txtBox;
    public TimKiemKhachHangPopUp(JTextField txtBox) {
        initComponents();
        
        this.txtBox = txtBox;
        renderTable();
    }
    
    private void renderTable() {
        int sortOption = cbbSortOption1.getSelectedIndex();
        int searchOption = 0;
        String keyWord = txtKeyWord1.getText().trim();
        
        if (buttonGroup.getSelection() != null) 
            searchOption = searchOption_ma.isSelected() ? 1 : searchOption_ten.isSelected() ? 2 : searchOption_ho.isSelected() ? 3 : 4; 
        
        DefaultTableModel model = (DefaultTableModel) tbKhachHang.getModel();
        model.setRowCount(0);
        
        try {
            ArrayList<KhachHangDTO> listKhachHang = KhachHangBLL.getDanhSachKhachHang(sortOption, searchOption, keyWord);
            txtResultCount.setText(String.format("Tìm thấy %d kết quả", listKhachHang.size()));
            for(KhachHangDTO khachHang: listKhachHang) {
                if (khachHang.getTrangthai().equalsIgnoreCase("active"))
                    model.addRow(new Object[] {
                        khachHang.getMaKH(),
                        khachHang.getHo(),
                        khachHang.getTenlot(),
                        khachHang.getTen(),
                        khachHang.getPhai(),
                        khachHang.getSdt()
                    });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        cbbSortOption1 = new javax.swing.JComboBox<>();
        txtKeyWord1 = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        searchOption_ma = new javax.swing.JRadioButton();
        searchOption_ten = new javax.swing.JRadioButton();
        searchOption_ho = new javax.swing.JRadioButton();
        txtResultCount = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        searchOption_sdt = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Họ", "Tên lót", "Tên", "Phái", "SDT"
            }
        ));
        jScrollPane1.setViewportView(tbKhachHang);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        cbbSortOption1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "A-Z", "Z-A", " " }));
        cbbSortOption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSortOption1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(cbbSortOption1, gridBagConstraints);

        txtKeyWord1.setMinimumSize(new java.awt.Dimension(148, 22));
        txtKeyWord1.setPreferredSize(new java.awt.Dimension(150, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(txtKeyWord1, gridBagConstraints);

        btnRefresh.setText("Refresh");
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(btnRefresh, gridBagConstraints);

        buttonGroup.add(searchOption_ma);
        searchOption_ma.setText("Mã");
        searchOption_ma.setMargin(new java.awt.Insets(2, 0, 3, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel7.add(searchOption_ma, gridBagConstraints);

        buttonGroup.add(searchOption_ten);
        searchOption_ten.setText("Tên");
        searchOption_ten.setMargin(new java.awt.Insets(2, 0, 3, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        jPanel7.add(searchOption_ten, gridBagConstraints);

        buttonGroup.add(searchOption_ho);
        searchOption_ho.setText("Họ");
        searchOption_ho.setMargin(new java.awt.Insets(2, 0, 3, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel7.add(searchOption_ho, gridBagConstraints);

        txtResultCount.setText("Tìm thấy ... kết quả");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        jPanel7.add(txtResultCount, gridBagConstraints);

        btnReset.setText("Đặt lại");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        jPanel7.add(btnReset, gridBagConstraints);

        buttonGroup.add(searchOption_sdt);
        searchOption_sdt.setText("Số điện thoại");
        searchOption_sdt.setMargin(new java.awt.Insets(2, 0, 3, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel7.add(searchOption_sdt, gridBagConstraints);

        jPanel1.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnCancel.setBackground(new java.awt.Color(255, 153, 153));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancel.setText("Huỷ");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        jPanel5.add(btnCancel);

        btnFinish.setBackground(new java.awt.Color(153, 255, 153));
        btnFinish.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFinish.setText("Xác nhận");
        btnFinish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinishMouseClicked(evt);
            }
        });
        jPanel5.add(btnFinish);

        getContentPane().add(jPanel5, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        // TODO add your handling code here:
        renderTable();
    }//GEN-LAST:event_btnRefreshMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        txtKeyWord1.setText("");
        buttonGroup.clearSelection();
        cbbSortOption1.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnFinishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinishMouseClicked
        // TODO add your handling code here:
        int selectedRow = tbKhachHang.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Hãy chọn khách hàng muốn thêm", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        txtBox.setText((String) tbKhachHang.getValueAt(selectedRow, 0));
        dispose();
    }//GEN-LAST:event_btnFinishMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelMouseClicked

    private void cbbSortOption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSortOption1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSortOption1ActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox<String> cbbSortOption1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton searchOption_ho;
    private javax.swing.JRadioButton searchOption_ma;
    private javax.swing.JRadioButton searchOption_sdt;
    private javax.swing.JRadioButton searchOption_ten;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTextField txtKeyWord1;
    private javax.swing.JLabel txtResultCount;
    // End of variables declaration//GEN-END:variables
}
