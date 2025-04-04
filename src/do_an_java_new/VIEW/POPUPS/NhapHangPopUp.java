/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package do_an_java_new.VIEW.POPUPS;

import do_an_java_new.BLL.HangBLL;
import do_an_java_new.DTO.ChiTietHoaDonDTO;
import do_an_java_new.DTO.ChiTietNhapHangDTO;
import do_an_java_new.DTO.HangDTO;
import do_an_java_new.DTO.HoaDonDTO;
import do_an_java_new.DTO.NhapHangDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS-PC
 */
public class NhapHangPopUp extends javax.swing.JFrame {

    /**
     * Creates new form HoaDonPopUp
     */
    public NhapHangPopUp(NhapHangDTO phieu, ArrayList<ChiTietNhapHangDTO> dsCTNH) {
        initComponents();
        
        txtMaNH.setText(phieu.getMaPhieu());
        txtMaNCC.setText(phieu.getMaNCC());
        txtMaNV.setText(phieu.getMaNV());
        txtTongTien.setText(String.format("%d", phieu.getTongTien()));
        txtThoiGian.setText(phieu.getThoiGian().toString());
        
        DefaultTableModel model = (DefaultTableModel) tbChiTietHoaDon.getModel();
        model.setRowCount(0);
        
        for (ChiTietNhapHangDTO ctnh: dsCTNH) {
            HangDTO hang = HangBLL.getHang(ctnh.getMaHang());
            model.addRow(new Object[] {
                ctnh.getMaHang(),
                hang.getTenSP(),
                ctnh.getSoLuong(),
                ctnh.getDonGia()
            });
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

        jPanel1 = new javax.swing.JPanel();
        txtMaNH = new javax.swing.JTextField();
        txtMaNCC = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtThoiGian = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChiTietHoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        jPanel1Layout.rowHeights = new int[] {0, 0, 0, 0, 0};
        jPanel1.setLayout(jPanel1Layout);

        txtMaNH.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel1.add(txtMaNH, gridBagConstraints);

        txtMaNCC.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        jPanel1.add(txtMaNCC, gridBagConstraints);

        txtMaNV.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        jPanel1.add(txtMaNV, gridBagConstraints);

        txtTongTien.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel1.add(txtTongTien, gridBagConstraints);

        txtThoiGian.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        jPanel1.add(txtThoiGian, gridBagConstraints);

        jLabel1.setText("Mã phiếu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Mã nhà cung cấp");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Mã nhân viên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Tổng tiền");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Thời gian");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        jPanel1.add(jLabel5, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tbChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã hàng", "Tên sản phẩm", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(tbChiTietHoaDon);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        btnClose.setBackground(new java.awt.Color(255, 102, 102));
        btnClose.setText("Đóng");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        jPanel2.add(btnClose);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbChiTietHoaDon;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtMaNH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtThoiGian;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
