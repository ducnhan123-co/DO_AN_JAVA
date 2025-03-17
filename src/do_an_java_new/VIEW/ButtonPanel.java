/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package do_an_java_new.VIEW;

import do_an_java_new.DTO.LoaiSPDTO;
import do_an_java_new.DTO.SanPhamDTO;
import do_an_java_new.VIEW.POPUPS.SuaLoaiSpPopUp;
import do_an_java_new.VIEW.POPUPS.SuaSanPhamPopUp;
import do_an_java_new.VIEW.POPUPS.ThemLoaiSPPopUp;
import do_an_java_new.VIEW.POPUPS.ThemSanPhamPopUp;
import javax.swing.DefaultButtonModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author pducn
 */
public class ButtonPanel extends javax.swing.JPanel {

    /**
     * Creates new form ButtonPanel
     */
    public ButtonPanel() {
        initComponents();
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

        jLabel13 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(976, 97));
        setLayout(new java.awt.GridBagLayout());

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/Add.png"))); // NOI18N
        jLabel13.setText("Thêm");
        jLabel13.setToolTipText("");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel13, gridBagConstraints);

        jLabel26.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/Delete.png"))); // NOI18N
        jLabel26.setText("Xoá");
        jLabel26.setToolTipText("");
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel26.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel26, gridBagConstraints);

        jLabel27.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/Pencil.png"))); // NOI18N
        jLabel27.setText("Sua");
        jLabel27.setToolTipText("");
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel27.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel27, gridBagConstraints);

        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/Info.png"))); // NOI18N
        jLabel28.setText("Chi tiết");
        jLabel28.setToolTipText("");
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel28.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel28, gridBagConstraints);

        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/Google Sheets.png"))); // NOI18N
        jLabel29.setText("Xuất excel");
        jLabel29.setToolTipText("");
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel29.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel29, gridBagConstraints);

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/Document.png"))); // NOI18N
        jLabel30.setText("Nhập excel");
        jLabel30.setToolTipText("");
        jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel30.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel30, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp", "A-Z", "Z-A", "Giá tăng dần", " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jComboBox5, gridBagConstraints);

        jTextField5.setText("Nhập từ khoá tìm kiếm");
        jTextField5.setMinimumSize(new java.awt.Dimension(148, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jTextField5, gridBagConstraints);

        jButton3.setText("Click");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jButton3, gridBagConstraints);

        jRadioButton7.setText("Mã");
        jRadioButton7.setMargin(new java.awt.Insets(2, 0, 3, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel2.add(jRadioButton7, gridBagConstraints);

        jRadioButton8.setText("Loại");
        jRadioButton8.setMargin(new java.awt.Insets(2, 0, 3, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(jRadioButton8, gridBagConstraints);

        jRadioButton9.setText("Tên");
        jRadioButton9.setMargin(new java.awt.Insets(2, 0, 3, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jRadioButton9, gridBagConstraints);

        jTextField6.setText("Tim thấy 50 sản phẩm");
        jTextField6.setMinimumSize(new java.awt.Dimension(120, 22));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jTextField6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 60, 0, 0);
        add(jPanel2, gridBagConstraints);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setText("KẾT QUẢ: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel31, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        
       // Lấy MainFrame
    MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);

    // Kiểm tra xem MainFrame đang ở panel nào (bạn đã có getCurrentPanel())
    if ("SANPHAM".equals(mainFrame.getCurrentPanel())) {
        // Lấy đối tượng SanPhamPanel
        SanPhamPanel spPanel = mainFrame.getSanPhamPanel();
        // Lấy tab đang chọn
        int selectedIndex = spPanel.getSelectedTabIndex(); 
        // Dựa vào selectedIndex để mở popup phù hợp
        switch (selectedIndex) {
            case 0:
                // Tab “Quản lý sản phẩm”
                ThemSanPhamPopUp popupSP = new ThemSanPhamPopUp();
                popupSP.setVisible(true);
                break;
            case 1:
                // Tab “Quản lý loại sản phẩm”
                ThemLoaiSPPopUp popupLoai = new ThemLoaiSPPopUp();
                popupLoai.setVisible(true);
                break;
            case 2:
                // Tab “Quản lý hàng hoá”
                // Mở popup “Thêm hàng hoá” (nếu có) hoặc xử lý gì khác
                // ThemHangHoaPopUp popupHH = new ThemHangHoaPopUp();
                // popupHH.setVisible(true);
                break;
        }
    }

    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
     MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
    if ("SANPHAM".equals(mainFrame.getCurrentPanel())) {
        SanPhamPanel spPanel = mainFrame.getSanPhamPanel();
        int selectedIndex = spPanel.getSelectedTabIndex(); 
        
        switch (selectedIndex) {
            case 0:
                // Tab “Quản lý sản phẩm”
                // => Sửa Sản phẩm
                SanPhamDTO sp = spPanel.getSelectedSanPham();
                if (sp == null) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 sản phẩm!");
                    return;
                }
                SuaSanPhamPopUp suaSPPopup = new SuaSanPhamPopUp(sp);
                suaSPPopup.setVisible(true);
                break;
                
            case 1:
                // Tab “Quản lý loại sản phẩm”
                // => Sửa Loại sản phẩm
                LoaiSPDTO loaiSP= spPanel.getSelectedLoaiSanPham();
                if (loaiSP == null) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 loại sản phẩm!");
                    return;
                }
                SuaLoaiSpPopUp suaLoaiPopup = new SuaLoaiSpPopUp(loaiSP);
                suaLoaiPopup.setVisible(true);
                break;
                
            case 2:
                // Tab “Quản lý hàng hóa” (nếu có)
                // => Xử lý sửa hàng hóa, v.v.
                break;
        }
    }
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
