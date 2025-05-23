/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package do_an_java_new.VIEW.WorkSpaces.AdminWorkSpaces;

import do_an_java_new.ExcelExporter;
import do_an_java_new.ExcelImporter;
import do_an_java_new.BLL.NhaCungCapBLL;
import do_an_java_new.DTO.NhaCungCapDTO;
import do_an_java_new.VIEW.POPUPS.AdminPopUps.SuaNhaCungCapPopUp;
import do_an_java_new.VIEW.POPUPS.AdminPopUps.ThemNhaCungCapPopUp;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class NhaCungCapPanel extends javax.swing.JPanel {

    /**
     * Creates new form NhanVienPanel
     */
    public NhaCungCapPanel() {
        initComponents();
        
        renderTable();
    }
    
    private void renderTable() {
        int searchOption = 0;
        String keyWord = txtKeyWord.getText().trim();
        int sortOption = cbbSortOption.getSelectedIndex();
        
        if (buttonGroup.getSelection() != null) 
            searchOption = searchOption_ma.isSelected() ? 1 : searchOption_ten.isSelected() ? 2 : searchOption_tenlh.isSelected() ? 3 : 4 ;

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        try {
            ArrayList<NhaCungCapDTO> dsNCC = NhaCungCapBLL.getDanhSachNCC(sortOption, searchOption, keyWord);
            txtResultCount.setText(String.format("Tìm thấy %d kết quả", dsNCC.size()));
            for (NhaCungCapDTO ncc: dsNCC) {
                model.addRow(new Object[] {
                    ncc.getMaNCC(),
                    ncc.getTenNCC(),
                    ncc.getTenLienHe(),
                    ncc.getSdt(),
                    ncc.getTinhThanh(),
                    ncc.getDiaChi(),
                    ncc.getTrangThai()
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
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnDetail = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cbbSortOption = new javax.swing.JComboBox<>();
        txtKeyWord = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        searchOption_ma = new javax.swing.JRadioButton();
        searchOption_ten = new javax.swing.JRadioButton();
        searchOption_tenlh = new javax.swing.JRadioButton();
        searchOption_sdt = new javax.swing.JRadioButton();
        txtResultCount = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(1080, 800));
        setPreferredSize(new java.awt.Dimension(1080, 800));
        setLayout(new java.awt.BorderLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cap", "Tên liên hệ", "SDT", "Tỉnh", "Địa chỉ", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(table);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(0, 173, 59));
        jPanel4.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel4.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(976, 97));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        btnInsert.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnInsert.setForeground(new java.awt.Color(255, 255, 255));
        btnInsert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/Add.png"))); // NOI18N
        btnInsert.setText("Thêm");
        btnInsert.setToolTipText("");
        btnInsert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInsert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnInsert, gridBagConstraints);

        btnDelete.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/Delete.png"))); // NOI18N
        btnDelete.setText("Xoá");
        btnDelete.setToolTipText("");
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnDelete, gridBagConstraints);

        btnUpdate.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/Pencil.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.setToolTipText("");
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnUpdate, gridBagConstraints);

        btnDetail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/Info.png"))); // NOI18N
        btnDetail.setText("Chi tiết");
        btnDetail.setToolTipText("");
        btnDetail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDetail.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDetailMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnDetail, gridBagConstraints);

        jLabel29.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/Google Sheets.png"))); // NOI18N
        jLabel29.setText("Xuất excel");
        jLabel29.setToolTipText("");
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel29.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel29, gridBagConstraints);

        jLabel30.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/Document.png"))); // NOI18N
        jLabel30.setText("Nhập excel");
        jLabel30.setToolTipText("");
        jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel30.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel30, gridBagConstraints);

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        cbbSortOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "Tên nhà cung cấp↑", "Tên nhà cung cấp↓", "Tên liên hệ↑", "Tên liên hệ↓" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(cbbSortOption, gridBagConstraints);

        txtKeyWord.setMinimumSize(new java.awt.Dimension(148, 22));
        txtKeyWord.setPreferredSize(new java.awt.Dimension(150, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(txtKeyWord, gridBagConstraints);

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
        jPanel5.add(btnRefresh, gridBagConstraints);

        buttonGroup.add(searchOption_ma);
        searchOption_ma.setText("Mã");
        searchOption_ma.setMargin(new java.awt.Insets(2, 0, 3, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel5.add(searchOption_ma, gridBagConstraints);

        buttonGroup.add(searchOption_ten);
        searchOption_ten.setText("Tên");
        searchOption_ten.setMargin(new java.awt.Insets(2, 0, 3, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        jPanel5.add(searchOption_ten, gridBagConstraints);

        buttonGroup.add(searchOption_tenlh);
        searchOption_tenlh.setText("Tên liên hệ");
        searchOption_tenlh.setMargin(new java.awt.Insets(2, 0, 3, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel5.add(searchOption_tenlh, gridBagConstraints);

        buttonGroup.add(searchOption_sdt);
        searchOption_sdt.setText("SDT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 1;
        jPanel5.add(searchOption_sdt, gridBagConstraints);

        txtResultCount.setText("Tìm thấy ... kết quả");
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 60, 0, 0);
        jPanel4.add(jPanel5, gridBagConstraints);

        add(jPanel4, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseClicked
        ThemNhaCungCapPopUp popUp = new ThemNhaCungCapPopUp();
        popUp.setVisible(true);
        
        popUp.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                
                renderTable();
            }
            
        });
    }//GEN-LAST:event_btnInsertMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhà cung cấp để sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String
                maNCC = (String) table.getValueAt(selectedRow, 0),
                ten = (String) table.getValueAt(selectedRow, 1),
                tenLH = (String) table.getValueAt(selectedRow, 2),
                sdt = (String) table.getValueAt(selectedRow, 3),
                tinh = (String) table.getValueAt(selectedRow, 4),
                diaChi = (String) table.getValueAt(selectedRow, 5),
                trangThai = (String) table.getValueAt(selectedRow, 6);
        
        NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, ten, tenLH, sdt, tinh, diaChi, trangThai);
        
        SuaNhaCungCapPopUp popUp = new SuaNhaCungCapPopUp(ncc);
        popUp.setVisible(true);

        popUp.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                renderTable(); 
            }
        });
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetailMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        // TODO add your handling code here:
        renderTable();
    }//GEN-LAST:event_btnRefreshMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        int selectedRow = table.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Hãy chọn nhà cung cấp để xoá");
            return;
        } 
        
        if (JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn nhà cung cấp ?", "Xoá nhà cung cấp", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                String maNCC = (String) table.getValueAt(selectedRow, 0);
                NhaCungCapBLL.xoaNhaCungCap(maNCC);
                
                renderTable();
                JOptionPane.showMessageDialog(null, "Xoá nhà cung cấp thành công");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        txtKeyWord.setText("");
        buttonGroup.clearSelection();
        cbbSortOption.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetMouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
        JFileChooser jf = new JFileChooser();
        jf.setDialogTitle("Chọn nơi lưu file Excel");
        jf.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files", "xlsx"));
        
        int userSelection = jf.showSaveDialog(this);
        if(userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = jf.getSelectedFile().getAbsolutePath();
            if(!filePath.endsWith(".xlsx")) {
                filePath+=".xlsx";
            }
            try {
                ExcelExporter.exportToExcel(table, "Danh sách nhà cung cấp", filePath);
                JOptionPane.showMessageDialog(this, "Xuất file Excel thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi xuất file Excel: "+e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);  
            }
        }
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        // TODO add your handling code here:
        JFileChooser jf = new JFileChooser();
        jf.setDialogTitle("Chọn file Excel để nhập");
        jf.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files", "xlsx"));
        
        int userSelection = jf.showOpenDialog(this);
        if(userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = jf.getSelectedFile().getAbsolutePath();
            
            try {
                List<List<String>> data = ExcelImporter.importFromExcel(filePath);
                
                for(int i=1 ; i<data.size(); i++) {
                    List<String> row = data.get(i);
                    String maNCC = row.get(0);
                    String tenNCC = row.get(1);
                    String tenLienHe = row.get(2);
                    String sđt = row.get(3);
                    String tinhThanh = row.get(4);
                    String diaChi = row.get(5);
                    String trangThai = row.get(6);
                    
                    NhaCungCapBLL.themNhaCungCap(new NhaCungCapDTO(maNCC, tenNCC, tenLienHe, sđt, tinhThanh, diaChi, trangThai));
                }
                
                JOptionPane.showMessageDialog(this, "Nhập dữ liệu từ Excel thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                renderTable();
            } catch(IOException e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi đọc file Excel: " +e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi xử lý dữ liệu: "+e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jLabel30MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnDetail;
    private javax.swing.JLabel btnInsert;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox<String> cbbSortOption;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton searchOption_ma;
    private javax.swing.JRadioButton searchOption_sdt;
    private javax.swing.JRadioButton searchOption_ten;
    private javax.swing.JRadioButton searchOption_tenlh;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtKeyWord;
    private javax.swing.JLabel txtResultCount;
    // End of variables declaration//GEN-END:variables
}
