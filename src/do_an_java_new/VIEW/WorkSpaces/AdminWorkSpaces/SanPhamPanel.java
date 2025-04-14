/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package do_an_java_new.VIEW.WorkSpaces.AdminWorkSpaces;

import do_an_java_new.BLL.HangBLL;
import do_an_java_new.BLL.LoaiSPBLL;
import do_an_java_new.BLL.SanPhamBLL;
import do_an_java_new.DTO.HangDTO;
import do_an_java_new.DTO.LoaiSPDTO;
import do_an_java_new.DTO.SanPhamDTO;
import do_an_java_new.VIEW.POPUPS.SuaLoaiSpPopUp;
import do_an_java_new.VIEW.POPUPS.SuaSanPhamPopUp;
import do_an_java_new.VIEW.POPUPS.ThemLoaiSPPopUp;
import do_an_java_new.VIEW.POPUPS.ThemSanPhamPopUp;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pducn
 */
public class SanPhamPanel extends javax.swing.JPanel {
    private SanPhamBLL sanPhamBLL;
    private LoaiSPBLL loaiSPBLL;
    /**
     * Creates new form NhanVienPanel
     */
    public SanPhamPanel() throws Exception {
        initComponents();
        sanPhamBLL = new SanPhamBLL();
        loaiSPBLL = new LoaiSPBLL();
        loadDataToTable();
    }
    
    public int getSelectedTabIndex() {
        return tabs.getSelectedIndex();
    }
    
    public void renderSanPhamTable() {
        List<SanPhamDTO> listSP = null;
        
        int searchOption = 0;
        String keyWord = txtKeyWord.getText().trim();
        int sortOption = cbbSortOptions.getSelectedIndex();
        
        if (searchOption_group.getSelection() != null) 
            searchOption = searchOption_ma.isSelected() ? 1 : searchOption_loai.isSelected() ? 2 : 3 ;
        
        try {
            listSP = sanPhamBLL.getDanhSachSanPham(sortOption, searchOption, keyWord);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtResultCount.setText(String.format("Tìm thấy %d kết quả", listSP.size()));
        // Lấy model của jTable
        DefaultTableModel model = (DefaultTableModel) tbSanPham.getModel();

        model.setRowCount(0); // Xóa trắng dữ liệu cũ trước khi thêm

        // Duyệt danh sách sản phẩm và thêm vào model
        for (SanPhamDTO sp : listSP) {
            model.addRow(new Object[] {
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getLoaiSP(),
                sp.getDonViTinh(),
                sp.getHanSuDung(),
                sp.getMoTa(),
                sp.getGia(),
                sp.getSoLuongTon()
            });
        }
    }
    
    public void renderLoaiTable() {
        List<LoaiSPDTO> dsLoai = null;
        DefaultTableModel model = (DefaultTableModel) tbLoaiSP.getModel();
        model.setRowCount(0);
        
        try {
            dsLoai = loaiSPBLL.getDanhSachLoaiSP();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (LoaiSPDTO loai : dsLoai) {
            model.addRow(new Object[] {
                    loai.getMaLoai(),
                    loai.getTenLoai(),
                    loai.getMota()
            });
        }
    }

    public void renderHangTable() {
        List<HangDTO> dsHang = null;
        DefaultTableModel model = (DefaultTableModel) tbHang.getModel();
        model.setRowCount(0);
        
        try {
            dsHang = HangBLL.getHangs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (HangDTO hang: dsHang) {
            model.addRow(new Object[] {
                hang.getMaHang(),
                hang.getTenSP(),
                hang.getSoLuong(),
                hang.getNgaySanXuat(),
                hang.getGiamGia()
            });
        }
    }
    
    private void loadDataToTable() {
        renderHangTable();
        renderLoaiTable();
        renderSanPhamTable();
    }
       
    public SanPhamDTO getSelectedSanPham() {
        int selectedRow = tbSanPham.getSelectedRow();
        if (selectedRow == -1) {
            // Người dùng chưa chọn dòng
            return null;
        }

        // Lấy dữ liệu từng cột
        String maSP       = (String) tbSanPham.getValueAt(selectedRow, 0);
        String tenSP      = (String) tbSanPham.getValueAt(selectedRow, 1);
        String loai       = (String) tbSanPham.getValueAt(selectedRow, 2);
        String donViTinh  = (String) tbSanPham.getValueAt(selectedRow, 3);
        int hanSuDung  = (int) tbSanPham.getValueAt(selectedRow, 4);
        String moTa       = (String) tbSanPham.getValueAt(selectedRow, 5);
        int gia        = (int) tbSanPham.getValueAt(selectedRow, 6);
        int soLuong   = (int) tbSanPham.getValueAt(selectedRow, 7);

        // Tạo SanPhamDTO
        SanPhamDTO sp = new SanPhamDTO(maSP, tenSP, loai, donViTinh, hanSuDung, moTa, gia, soLuong);

        return sp;
    }
       
    public LoaiSPDTO getSelectedLoaiSanPham() {
        int selectedRow = tbLoaiSP.getSelectedRow();
        if (selectedRow == -1) {
            return null; // chưa chọn dòng
        }
        
        String maLoai = (String) tbLoaiSP.getValueAt(selectedRow, 0);
        String tenLoai = (String) tbLoaiSP.getValueAt(selectedRow, 1);
        String moTa = (String) tbLoaiSP.getValueAt(selectedRow, 2);

        LoaiSPDTO loaiSP = new LoaiSPDTO();
        loaiSP.setMaLoai(maLoai);
        loaiSP.setTenLoai(tenLoai);
        loaiSP.setMota(moTa);
        
        return loaiSP;
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

        searchOption_group = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLoaiSP = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnDetail = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbbSortOptions = new javax.swing.JComboBox<>();
        txtKeyWord = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        searchOption_ma = new javax.swing.JRadioButton();
        searchOption_loai = new javax.swing.JRadioButton();
        searchOption_ten = new javax.swing.JRadioButton();
        txtResultCount = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(1080, 800));
        setPreferredSize(new java.awt.Dimension(1080, 800));
        setLayout(new java.awt.BorderLayout());

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại", "Đơn vị tính", "Hạn sử dụng", "Mô tả", "Giá", "Số lượng tồn"
            }
        ));
        jScrollPane1.setViewportView(tbSanPham);

        tabs.addTab("Quản lý sản phẩm", jScrollPane1);

        tbLoaiSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên loại", "Mô tả"
            }
        ));
        jScrollPane2.setViewportView(tbLoaiSP);

        tabs.addTab("Quản lý loại sản phẩm", jScrollPane2);

        tbHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hàng", "Tên sản phẩm", "Số lượng", "Ngày sản xuất", "Giảm giá"
            }
        ));
        jScrollPane3.setViewportView(tbHang);

        tabs.addTab("Quản lý hàng hoá", jScrollPane3);

        add(tabs, java.awt.BorderLayout.CENTER);

        jPanel1.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(976, 97));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnInsert.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
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
        jPanel1.add(btnInsert, gridBagConstraints);

        btnDelete.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
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
        jPanel1.add(btnDelete, gridBagConstraints);

        btnUpdate.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/Pencil.png"))); // NOI18N
        btnUpdate.setText("Sua");
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
        jPanel1.add(btnUpdate, gridBagConstraints);

        btnDetail.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
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
        jPanel1.add(btnDetail, gridBagConstraints);

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
        jPanel1.add(jLabel29, gridBagConstraints);

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
        jPanel1.add(jLabel30, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        cbbSortOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "A-Z", "Z-A", "Giá tăng dần", "Giá giảm dần", "Số lượng tồn tăng dần", "Số lượng tồn giảm dần", " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(cbbSortOptions, gridBagConstraints);

        txtKeyWord.setMinimumSize(new java.awt.Dimension(148, 22));
        txtKeyWord.setPreferredSize(new java.awt.Dimension(150, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(txtKeyWord, gridBagConstraints);

        jButton3.setText("Refresh");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jButton3, gridBagConstraints);

        searchOption_group.add(searchOption_ma);
        searchOption_ma.setText("Mã");
        searchOption_ma.setMargin(new java.awt.Insets(2, 0, 3, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel2.add(searchOption_ma, gridBagConstraints);

        searchOption_group.add(searchOption_loai);
        searchOption_loai.setText("Loại");
        searchOption_loai.setMargin(new java.awt.Insets(2, 0, 3, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(searchOption_loai, gridBagConstraints);

        searchOption_group.add(searchOption_ten);
        searchOption_ten.setText("Tên");
        searchOption_ten.setMargin(new java.awt.Insets(2, 0, 3, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(searchOption_ten, gridBagConstraints);

        txtResultCount.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        jPanel2.add(txtResultCount, gridBagConstraints);

        btnReset.setText("Đặt lại");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        jPanel2.add(btnReset, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 60, 0, 0);
        jPanel1.add(jPanel2, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseClicked
        JFrame popUp = null ;
        switch(tabs.getSelectedIndex()) {
            case 0:
                popUp = new ThemSanPhamPopUp();
                break;
            case 1:  
                popUp = new ThemLoaiSPPopUp();
                break;
            case 2:
                break;
            default:
                break;
        }
        
        popUp.setVisible(true);
        
        popUp.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                loadDataToTable();
            }
        });
        
    }//GEN-LAST:event_btnInsertMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        JFrame popUp = null ;
        switch(tabs.getSelectedIndex()) {
            case 0:
                SanPhamDTO sanpham = getSelectedSanPham();
                if (sanpham == null) {
                    JOptionPane.showMessageDialog(null, "Hãy chọn sản phẩm để cập nhật");
                    return;
                }
                popUp = new SuaSanPhamPopUp(sanpham);
                break;
            case 1:  
                LoaiSPDTO loai = getSelectedLoaiSanPham();
                if (loai == null) {
                    JOptionPane.showMessageDialog(null, "Hãy chọn loại để cập nhật");
                    return;
                }
                popUp = new SuaLoaiSpPopUp(loai);
                break;
            case 2:
                break;
            default:
                break;
        }
        
        popUp.setVisible(true);
        
        popUp.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                loadDataToTable();
            }
            
        });
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetailMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        loadDataToTable();
    }//GEN-LAST:event_jButton3MouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        switch(tabs.getSelectedIndex()) {
            case 0:
                SanPhamDTO sanpham = getSelectedSanPham();
                if (sanpham == null) {
                    JOptionPane.showMessageDialog(null, "Hãy chọn sản phẩm để xoá");
                    return;
                }
                
                if (JOptionPane.showConfirmDialog(null, "Bạn thật sự muốn xoá sản phẩm này?", "Xoá sản phẩm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        sanPhamBLL.xoaSanPham(sanpham.getMaSP());
                        JOptionPane.showMessageDialog(null, "Xoá sản phẩm thành công");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
                break;
            case 1:
                LoaiSPDTO loai = getSelectedLoaiSanPham();
                if (loai == null) {
                    JOptionPane.showMessageDialog(null, "Hãy chọn loại sản phẩm để xoá");
                    return;
                }
                
                if (JOptionPane.showConfirmDialog(null, "Bạn thật sự muốn xoá loại sản phẩm này?", "Xoá loại sản phẩm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        loaiSPBLL.xoaLoaiSP(loai.getMaLoai());
                        JOptionPane.showMessageDialog(null, "Xoá loại sản phẩm thành công");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }                
                break;
            case 2:
                int selectedHang = tbHang.getSelectedRow();
                if (selectedHang < 0) {
                    JOptionPane.showMessageDialog(null, "Hãy chọn hàng cần xoá!");
                    return;
                }
                
                if (JOptionPane.showConfirmDialog(null, "Bạn thật sự muốn xoá hàng này?", "Xoá hàng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    String maHang = (String) tbHang.getValueAt(selectedHang, 0);
                    try {
                        HangBLL.xoaHang(maHang);
                        JOptionPane.showMessageDialog(null, "Xoá hàng thành công");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                } 
                break;
            default:
                break;
        }
        
        loadDataToTable();
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        txtKeyWord.setText("");
        searchOption_group.clearSelection();
        cbbSortOptions.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnDetail;
    private javax.swing.JLabel btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JComboBox<String> cbbSortOptions;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.ButtonGroup searchOption_group;
    private javax.swing.JRadioButton searchOption_loai;
    private javax.swing.JRadioButton searchOption_ma;
    private javax.swing.JRadioButton searchOption_ten;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbHang;
    private javax.swing.JTable tbLoaiSP;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField txtKeyWord;
    private javax.swing.JLabel txtResultCount;
    // End of variables declaration//GEN-END:variables
}
