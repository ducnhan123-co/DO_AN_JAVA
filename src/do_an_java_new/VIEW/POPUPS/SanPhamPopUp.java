/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package do_an_java_new.VIEW.POPUPS;

import do_an_java_new.BLL.DonViTinhBLL;
import do_an_java_new.BLL.LoaiSPBLL;
import do_an_java_new.DTO.LoaiSPDTO;
import do_an_java_new.DTO.SanPhamDTO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS-PC
 */
public abstract class SanPhamPopUp extends javax.swing.JFrame {

    /**
     * Creates new form NhanVienPopUp
     */
    DefaultComboBoxModel<String> loaiBoxModel = new DefaultComboBoxModel();
    DefaultComboBoxModel<String> dvtBoxModel = new DefaultComboBoxModel();    
    
    public SanPhamPopUp() {
        initComponents();
        
        cbbLoai.setModel(loaiBoxModel);
        cbbDVT.setModel(dvtBoxModel);
        
        initWorkSpace();
    }
    public SanPhamPopUp(SanPhamDTO sanPham) {
        initComponents();
        
        cbbLoai.setModel(loaiBoxModel);
        cbbDVT.setModel(dvtBoxModel);
        
        initWorkSpace();
        
        txtId.setText(sanPham.getMaSP());
        txtTen.setText(sanPham.getTenSP());
        cbbLoai.setSelectedItem(sanPham.getLoaiSP());
        cbbDVT.setSelectedItem(sanPham.getDonViTinh());
        spnHSD.setValue(sanPham.getHanSuDung());
        txtMota.setText(sanPham.getMoTa());
        spnGia.setValue(sanPham.getGia());
    }    
    
    public void setLabel(String labelString) {
        label.setText(labelString);
    }
    
    private void initWorkSpace() {
        try {
            for (LoaiSPDTO loai: LoaiSPBLL.getDanhSachLoaiSP()) {
                loaiBoxModel.addElement(loai.getTenLoai());
            }

            for (String dvt: DonViTinhBLL.getDanhSachDVT()) {
                dvtBoxModel.addElement(dvt);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public abstract void xacNhan();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        cbbLoai = new javax.swing.JComboBox<>();
        cbbDVT = new javax.swing.JComboBox<>();
        spnGia = new javax.swing.JSpinner();
        spnHSD = new javax.swing.JSpinner();
        lbID1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnXacNhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(232, 245, 233));
        setPreferredSize(new java.awt.Dimension(390, 440));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setLayout(new java.awt.BorderLayout());

        label.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label.setForeground(new java.awt.Color(46, 125, 50));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Thêm sản phẩm");
        jPanel1.add(label, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 10, 0};
        jPanel2Layout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        jPanel2.setLayout(jPanel2Layout);

        lbID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbID.setText("id");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(lbID, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ten san pham");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Loai");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel2.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Don vi tinh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanel2.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Han su dung");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        jPanel2.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Mo ta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        jPanel2.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Gia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        jPanel2.add(jLabel8, gridBagConstraints);

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTen.setPreferredSize(new java.awt.Dimension(100, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel2.add(txtTen, gridBagConstraints);

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtId.setMinimumSize(new java.awt.Dimension(100, 26));
        txtId.setPreferredSize(new java.awt.Dimension(100, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel2.add(txtId, gridBagConstraints);

        txtMota.setColumns(10);
        txtMota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMota.setLineWrap(true);
        txtMota.setRows(3);
        jScrollPane1.setViewportView(txtMota);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        jPanel2.add(jScrollPane1, gridBagConstraints);

        cbbLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLoai.setPreferredSize(new java.awt.Dimension(130, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        jPanel2.add(cbbLoai, gridBagConstraints);

        cbbDVT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbDVT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbDVT.setPreferredSize(new java.awt.Dimension(100, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        jPanel2.add(cbbDVT, gridBagConstraints);

        spnGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spnGia.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 50000));
        spnGia.setPreferredSize(new java.awt.Dimension(100, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        jPanel2.add(spnGia, gridBagConstraints);

        spnHSD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spnHSD.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnHSD.setPreferredSize(new java.awt.Dimension(100, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        jPanel2.add(spnHSD, gridBagConstraints);

        lbID1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbID1.setText("id");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(lbID1, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Ten san pham");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Loai");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel2.add(jLabel10, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        btnXacNhan.setBackground(new java.awt.Color(102, 187, 106));
        btnXacNhan.setText("Xac nhan");
        btnXacNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXacNhanMouseClicked(evt);
            }
        });
        jPanel3.add(btnXacNhan);

        btnHuy.setBackground(new java.awt.Color(165, 214, 167));
        btnHuy.setText("Huy");
        btnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyMouseClicked(evt);
            }
        });
        jPanel3.add(btnHuy);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseClicked
        dispose();
    }//GEN-LAST:event_btnHuyMouseClicked

    private void btnXacNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXacNhanMouseClicked
        xacNhan();
    }//GEN-LAST:event_btnXacNhanMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnXacNhan;
    protected javax.swing.JComboBox<String> cbbDVT;
    protected javax.swing.JComboBox<String> cbbLoai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    protected javax.swing.JLabel lbID;
    protected javax.swing.JLabel lbID1;
    protected javax.swing.JSpinner spnGia;
    protected javax.swing.JSpinner spnHSD;
    protected javax.swing.JTextField txtId;
    protected javax.swing.JTextArea txtMota;
    protected javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
