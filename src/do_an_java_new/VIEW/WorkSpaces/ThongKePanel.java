/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package do_an_java_new.VIEW.WorkSpaces;

import do_an_java_new.BLL.ThongKeBLL;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
//import org.jfree.util.PublicCloneable;
import org.jfree.data.xy.XYSeries;
/**
 *
 * @author pducn
 */
public class ThongKePanel extends javax.swing.JPanel {

    private java.sql.Date parseDateFromCombo(
    javax.swing.JComboBox<String> comboDay,
    javax.swing.JComboBox<String> comboMonth,
    javax.swing.JComboBox<String> comboYear
) {
    String sDay = (String) comboDay.getSelectedItem();
    String sMonth = (String) comboMonth.getSelectedItem();
    String sYear = (String) comboYear.getSelectedItem();

    if ("Không".equals(sDay) || "Không".equals(sMonth) || "Không".equals(sYear)) {
        return null; // Người dùng không chọn ngày
    }
    try {
        int day = Integer.parseInt(sDay);
        int month = Integer.parseInt(sMonth);
        int year = Integer.parseInt(sYear);

        // Tạo LocalDate rồi chuyển sang java.sql.Date
        java.time.LocalDate ld = java.time.LocalDate.of(year, month, day);
        return java.sql.Date.valueOf(ld);
    } catch (NumberFormatException e) {
        return null; // Lỗi parse
    }
}


    /**
     * Creates new form NhanVienPanel
     */
    public ThongKePanel() {
        initComponents();
        
        ButtonGroup groupChonMa = new ButtonGroup();
    groupChonMa.add(jRadioButton1);  // Sản phẩm
    groupChonMa.add(jRadioButton2);  // Nhân viên
    groupChonMa.add(jRadioButton3);  // Khách hàng
    groupChonMa.add(jRadioButton4);  // Hóa đơn
    
     ButtonGroup groupKieuThongKe = new ButtonGroup();
    groupKieuThongKe.add(jRadioButton6);  // Doanh thu
    groupKieuThongKe.add(jRadioButton8);  // Số lượng
    groupKieuThongKe.add(jRadioButton7);  // Loại sản phẩm
    
     ButtonGroup groupThoiGian = new ButtonGroup();
    groupThoiGian.add(jRadioButton9);  // DD/MM/YY
    groupThoiGian.add(jRadioButton10); // Quý
    groupThoiGian.add(jRadioButton11); // Kỳ (4 tháng)
    }
    
  private void thongKeAction() {
        try {
            String loaiDoiTuong = null;
            if (jRadioButton1.isSelected()) {
                loaiDoiTuong = "sanpham";
            } else if (jRadioButton2.isSelected()) {
                loaiDoiTuong = "nhanvien";
            } else if (jRadioButton3.isSelected()) {
                loaiDoiTuong = "khachhang";
            } else if (jRadioButton4.isSelected()) {
                loaiDoiTuong = "hoadon";
            }

            String kieuThongKe = "default";
            if (jRadioButton6.isSelected()) {
                kieuThongKe = "doanhthu";
            } else if (jRadioButton8.isSelected()) {
                kieuThongKe = "soluong";
            } else if (jRadioButton7.isSelected()) {
                kieuThongKe = "loaisp";
            }

            java.sql.Date tuNgay = parseDateFromCombo(jComboBox4, jComboBox5, jComboBox6);
            java.sql.Date denNgay = parseDateFromCombo(jComboBox1, jComboBox2, jComboBox3);
            String maSP = jTextField4.getText().trim();

            if ("sanpham".equals(loaiDoiTuong)) {
                List<Object[]> data = ThongKeBLL.thongKeSanPham(maSP, tuNgay, denNgay, kieuThongKe);
                hienThiKetQua(data, kieuThongKe, tuNgay, denNgay);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Lỗi thống kê: " + ex.getMessage());
        }
    }
    

private void hienThiKetQua(List<Object[]> data, String kieuThongKe, java.sql.Date tuNgay, java.sql.Date denNgay) {
    // Cập nhật bảng jTable1
    DefaultTableModel model = new DefaultTableModel();
    if (kieuThongKe.equals("loaisp")) {
        model.setColumnIdentifiers(new String[]{"Loại SP", "Tổng SL", "Tổng Doanh Thu"});
    } else if (kieuThongKe.equals("doanhthu")) {
        model.setColumnIdentifiers(new String[]{"Mã SP", "Tên SP", "Tổng Doanh Thu"});
    } else if (kieuThongKe.equals("soluong")) {
        model.setColumnIdentifiers(new String[]{"Mã SP", "Tên SP", "Tổng SL"});
    } else {
        model.setColumnIdentifiers(new String[]{"Mã SP", "Tên SP", "SL Tồn"});
    }

    for (Object[] row : data) {
        model.addRow(row);
    }
    jTable1.setModel(model);

    // Cập nhật jTextArea1
    jTextArea1.setText("");
    String strTuNgay = (tuNgay != null) ? tuNgay.toString() : "N/A";
    String strDenNgay = (denNgay != null) ? denNgay.toString() : "N/A";
    jTextArea1.append("Từ ngày: " + strTuNgay + "\n");
    jTextArea1.append("Đến ngày: " + strDenNgay + "\n");
    jTextArea1.append("---------------------------------\n");

    int totalSL = 0;
    long totalDT = 0;
    for (Object[] row : data) {
        if (kieuThongKe.equals("loaisp")) {
            String tenLoai = row[0].toString();
            int sl = (int) row[1];
            long dt = (long) row[2];
            jTextArea1.append("Loại: " + tenLoai + " | SL=" + sl + " | DT=" + dt + "\n");
            totalSL += sl;
            totalDT += dt;
        } else if (kieuThongKe.equals("doanhthu")) {
            String maSP = row[0].toString();
            String tenSP = row[1].toString();
            long dt = (long) row[2];
            jTextArea1.append("SP: " + maSP + " | " + tenSP + " | DT=" + dt + "\n");
            totalDT += dt;
        } else if (kieuThongKe.equals("soluong")) {
            String maSP = row[0].toString();
            String tenSP = row[1].toString();
            int sl = (int) row[2];
            jTextArea1.append("SP: " + maSP + " | " + tenSP + " | SL=" + sl + "\n");
            totalSL += sl;
        } else {
            String maSP = row[0].toString();
            String tenSP = row[1].toString();
            int slTon = (int) row[2];
            jTextArea1.append("SP: " + maSP + " | " + tenSP + " | SL Tồn=" + slTon + "\n");
            totalSL += slTon;
        }
    }
    jTextArea1.append("---------------------------------\n");
    if (!kieuThongKe.equals("doanhthu")) {
        jTextArea1.append("TỔNG SỐ LƯỢNG = " + totalSL + "\n");
    }
    if (kieuThongKe.equals("doanhthu") || kieuThongKe.equals("loaisp")) {
        jTextArea1.append("TỔNG DOANH THU = " + totalDT + "\n");
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
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jTextField3 = new javax.swing.JTextField();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextArea1 = new javax.swing.JTextArea();

        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(1080, 800));
        setPreferredSize(new java.awt.Dimension(1080, 800));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 3));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 800));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 10));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Tất cả");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 6, 9);
        jPanel3.add(jButton1, gridBagConstraints);

        jButton2.setText("Top");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.insets = new java.awt.Insets(7, 10, 7, 10);
        jPanel3.add(jButton2, gridBagConstraints);

        jPanel1.add(jPanel3);

        jPanel10.setBackground(new java.awt.Color(204, 255, 204));
        jPanel10.setPreferredSize(new java.awt.Dimension(70, 30));
        jPanel1.add(jPanel10);

        jPanel8.setBackground(new java.awt.Color(204, 255, 204));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jButton5.setText("Nhập PDF");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 6, 9);
        jPanel8.add(jButton5, gridBagConstraints);

        jButton6.setText("Xuất PDF");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.insets = new java.awt.Insets(7, 10, 7, 10);
        jPanel8.add(jButton6, gridBagConstraints);

        jPanel1.add(jPanel8);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(530, 200));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jTextField1.setText("Chọn mã");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 0);
        jPanel4.add(jTextField1, gridBagConstraints);

        jRadioButton1.setText("Sản phẩm");
        jPanel4.add(jRadioButton1, new java.awt.GridBagConstraints());

        jRadioButton2.setText("Nhân viên");
        jPanel4.add(jRadioButton2, new java.awt.GridBagConstraints());

        jRadioButton3.setText("Khách hàng");
        jPanel4.add(jRadioButton3, new java.awt.GridBagConstraints());

        jRadioButton4.setText("Hoá đơn");
        jPanel4.add(jRadioButton4, new java.awt.GridBagConstraints());

        jTextField2.setText("Chọn kiểu thống kê");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 0);
        jPanel4.add(jTextField2, gridBagConstraints);

        jRadioButton6.setText("Doanh Thu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel4.add(jRadioButton6, gridBagConstraints);

        jRadioButton7.setText("Loại sản phẩm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        jPanel4.add(jRadioButton7, gridBagConstraints);

        jRadioButton8.setText("Số lượng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        jPanel4.add(jRadioButton8, gridBagConstraints);

        jTextField3.setText("Chọn thời gian");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 0);
        jPanel4.add(jTextField3, gridBagConstraints);

        jRadioButton9.setText("DD/MM/YY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel4.add(jRadioButton9, gridBagConstraints);

        jRadioButton10.setText("Quý");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        jPanel4.add(jRadioButton10, gridBagConstraints);

        jRadioButton11.setText("Kỳ(4 tháng)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 1;
        jPanel4.add(jRadioButton11, gridBagConstraints);

        jPanel1.add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 100));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Mã sản phẩm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 9, 5, 9);
        jPanel5.add(jLabel1, gridBagConstraints);

        jTextField4.setMinimumSize(new java.awt.Dimension(100, 22));
        jTextField4.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel5.add(jTextField4, gridBagConstraints);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel8.setText("...");
        jLabel8.setToolTipText("");
        jLabel8.setFocusable(false);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel8);

        jPanel5.add(jPanel7, new java.awt.GridBagConstraints());

        jLabel2.setText("Đến ngày");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 11);
        jPanel5.add(jLabel2, gridBagConstraints);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel5.add(jComboBox1, gridBagConstraints);

        jLabel3.setText("/");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel5.add(jLabel3, gridBagConstraints);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " ", " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        jPanel5.add(jComboBox2, gridBagConstraints);

        jLabel4.setText("/");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        jPanel5.add(jLabel4, gridBagConstraints);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "2025", "2024", "2023", "2022", "2021", "2020", " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        jPanel5.add(jComboBox3, gridBagConstraints);

        jLabel5.setText("Từ ngày");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 11, 0, 11);
        jPanel5.add(jLabel5, gridBagConstraints);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel5.add(jComboBox4, gridBagConstraints);

        jLabel6.setText("/");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel5.add(jLabel6, gridBagConstraints);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " ", " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        jPanel5.add(jComboBox5, gridBagConstraints);

        jLabel7.setText("/");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        jPanel5.add(jLabel7, gridBagConstraints);

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "2025", "2024", "2023", "2022", "2021", "2020", " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        jPanel5.add(jComboBox6, gridBagConstraints);

        jPanel1.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setPreferredSize(new java.awt.Dimension(101, 100));
        jPanel6.setLayout(new java.awt.GridLayout(2, 0, 10, 20));

        jButton3.setText("Thống kê");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel6.add(jButton3);

        jButton4.setText("Đặt lại");
        jButton4.setHideActionText(true);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel6.add(jButton4);

        jPanel1.add(jPanel6);

        jPanel9.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.add(jPanel9);

        add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(480, 800));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sp", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setPreferredSize(new java.awt.Dimension(232, 150));
        jPanel2.add(jTextArea1, java.awt.BorderLayout.SOUTH);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        thongKeAction();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
      
    jRadioButton1.setSelected(false);
    jRadioButton2.setSelected(false);
    jRadioButton3.setSelected(false);
    jRadioButton4.setSelected(false);

    
    jComboBox1.setSelectedItem("Không");
    jComboBox2.setSelectedItem("Không");
    jComboBox3.setSelectedItem("Không");
    jComboBox4.setSelectedItem("Không");
    jComboBox5.setSelectedItem("Không");
    jComboBox6.setSelectedItem("Không");

  
    jTextField4.setText("");

    // Xóa dữ liệu trong bảng jTable1
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Xóa tất cả các hàng

   
    jTextArea1.setText("");
    }//GEN-LAST:event_jButton4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
