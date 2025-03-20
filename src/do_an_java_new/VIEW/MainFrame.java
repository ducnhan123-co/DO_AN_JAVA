/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package do_an_java_new.VIEW;

import do_an_java_new.DTO.NhanVienDTO;
import do_an_java_new.Login;
import do_an_java_new.VIEW.WorkSpaces.NhapHangPanel;
import do_an_java_new.VIEW.WorkSpaces.TrangChuPanel;
import do_an_java_new.VIEW.WorkSpaces.ThongKePanel;
import do_an_java_new.VIEW.WorkSpaces.NhanVienPanel;
import do_an_java_new.VIEW.WorkSpaces.SanPhamPanel;
import do_an_java_new.VIEW.WorkSpaces.KhuyenMaiPanel;
import do_an_java_new.VIEW.WorkSpaces.KhachHangPanel;
import do_an_java_new.VIEW.WorkSpaces.HoaDonPanel;
import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author pducn
 */
public class MainFrame extends javax.swing.JFrame {
    private String currentPanel;
    private CardLayout cardLayout;
    private SanPhamPanel sanPhamPanel;
    private final NhanVienPanel nhanVienPanel;
    private final TrangChuPanel trangChuPanel;
    private final HoaDonPanel hoaDonPanel;
    private final KhachHangPanel khachHangPanel;
    private final NhapHangPanel nhapHAngPanel;
    private final KhuyenMaiPanel khuyenMaiPanel;
    private final ThongKePanel thongKePanel;
    //tuong tu
    /**
     * Creates new form MainFrame
     */
       public String getCurrentPanel() {
        return currentPanel;
    }
    public MainFrame() throws Exception {
        initComponents();
        cardLayout = (CardLayout) pnCenter.getLayout();
        sanPhamPanel = new SanPhamPanel();
        nhanVienPanel = new NhanVienPanel();
        trangChuPanel = new TrangChuPanel();
        khachHangPanel = new KhachHangPanel();
        hoaDonPanel = new HoaDonPanel();
        nhapHAngPanel = new NhapHangPanel();
        khuyenMaiPanel = new KhuyenMaiPanel();
        thongKePanel = new ThongKePanel();
        
        pnCenter.add(trangChuPanel,"TRANGCHU");
        pnCenter.add(sanPhamPanel,"SANPHAM");
        pnCenter.add(nhanVienPanel,"NHANVIEN");
        pnCenter.add(khachHangPanel,"KHACHHANG");
        pnCenter.add(hoaDonPanel,"HOADON");
        pnCenter.add(nhapHAngPanel,"NHAPHANG");
        pnCenter.add(khuyenMaiPanel,"KHUYENMAI");
        pnCenter.add(thongKePanel,"THONGKE");
    }
    
    public MainFrame(NhanVienDTO nhanVien) throws Exception {
        initComponents();
        cardLayout = (CardLayout) pnCenter.getLayout();
        sanPhamPanel = new SanPhamPanel();
        nhanVienPanel = new NhanVienPanel();
        trangChuPanel = new TrangChuPanel();
        khachHangPanel = new KhachHangPanel();
        hoaDonPanel = new HoaDonPanel();
        nhapHAngPanel = new NhapHangPanel();
        khuyenMaiPanel = new KhuyenMaiPanel();
        thongKePanel = new ThongKePanel();
        
        pnCenter.add(trangChuPanel,"TRANGCHU");
        pnCenter.add(sanPhamPanel,"SANPHAM");
        pnCenter.add(nhanVienPanel,"NHANVIEN");
        pnCenter.add(khachHangPanel,"KHACHHANG");
        pnCenter.add(hoaDonPanel,"HOADON");
        pnCenter.add(nhapHAngPanel,"NHAPHANG");
        pnCenter.add(khuyenMaiPanel,"KHUYENMAI");
        pnCenter.add(thongKePanel,"THONGKE");
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

        pnLeft = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        TrangChu = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Quan_ly_san_pham = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Quan_ly_nhan_vien = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Quan_ly_khach_hang = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Quan_ly_hoa_don = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Quan_ly_nhap_hang = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Quan_ly_khuyen_mai = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Quan_ly_thong_ke = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        TrangChu10 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        pnCenter = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        pnLeft.setBackground(new java.awt.Color(153, 255, 204));
        pnLeft.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 51), 4, true));
        pnLeft.setMaximumSize(new java.awt.Dimension(200, 400));
        pnLeft.setMinimumSize(new java.awt.Dimension(200, 400));
        pnLeft.setPreferredSize(new java.awt.Dimension(200, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/desktop48.png"))); // NOI18N
        jLabel4.setText("<html>SIÊU QUẢN LÝ<br><small>ADMIN</small></html> ");
        jLabel4.setToolTipText("");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setVerifyInputWhenFocusTarget(false);
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnLeft.add(jLabel4);

        jPanel7.setBackground(new java.awt.Color(153, 255, 204));
        jPanel7.setPreferredSize(new java.awt.Dimension(195, 20));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pnLeft.add(jPanel7);

        TrangChu.setBackground(new java.awt.Color(153, 255, 204));
        TrangChu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 153)));
        TrangChu.setForeground(new java.awt.Color(255, 255, 255));
        TrangChu.setOpaque(true);
        TrangChu.setPreferredSize(new java.awt.Dimension(195, 40));
        TrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrangChuMouseClicked(evt);
            }
        });
        TrangChu.setLayout(new java.awt.GridBagLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/icons8-home-16.png"))); // NOI18N
        jLabel8.setFocusable(false);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        TrangChu.add(jLabel8, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText(" Trang chủ");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.8;
        TrangChu.add(jLabel5, gridBagConstraints);

        pnLeft.add(TrangChu);

        Quan_ly_san_pham.setBackground(new java.awt.Color(153, 255, 204));
        Quan_ly_san_pham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 153)));
        Quan_ly_san_pham.setForeground(new java.awt.Color(255, 255, 255));
        Quan_ly_san_pham.setOpaque(true);
        Quan_ly_san_pham.setPreferredSize(new java.awt.Dimension(195, 40));
        Quan_ly_san_pham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Quan_ly_san_phamMouseClicked(evt);
            }
        });
        Quan_ly_san_pham.setLayout(new java.awt.GridBagLayout());

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/icons8-product-16.png"))); // NOI18N
        jLabel20.setFocusable(false);
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 0, 0);
        Quan_ly_san_pham.add(jLabel20, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText(" Sản Phẩm");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.8;
        Quan_ly_san_pham.add(jLabel6, gridBagConstraints);

        pnLeft.add(Quan_ly_san_pham);

        Quan_ly_nhan_vien.setBackground(new java.awt.Color(153, 255, 204));
        Quan_ly_nhan_vien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 153)));
        Quan_ly_nhan_vien.setForeground(new java.awt.Color(255, 255, 255));
        Quan_ly_nhan_vien.setOpaque(true);
        Quan_ly_nhan_vien.setPreferredSize(new java.awt.Dimension(195, 40));
        Quan_ly_nhan_vien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Quan_ly_nhan_vienMouseClicked(evt);
            }
        });
        Quan_ly_nhan_vien.setLayout(new java.awt.GridBagLayout());

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/icons8-staff-16.png"))); // NOI18N
        jLabel21.setFocusable(false);
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 0, 0);
        Quan_ly_nhan_vien.add(jLabel21, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Nhân Viên");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.8;
        Quan_ly_nhan_vien.add(jLabel7, gridBagConstraints);

        pnLeft.add(Quan_ly_nhan_vien);

        Quan_ly_khach_hang.setBackground(new java.awt.Color(153, 255, 204));
        Quan_ly_khach_hang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 153)));
        Quan_ly_khach_hang.setForeground(new java.awt.Color(255, 255, 255));
        Quan_ly_khach_hang.setOpaque(true);
        Quan_ly_khach_hang.setPreferredSize(new java.awt.Dimension(195, 40));
        Quan_ly_khach_hang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Quan_ly_khach_hangMouseClicked(evt);
            }
        });
        Quan_ly_khach_hang.setLayout(new java.awt.GridBagLayout());

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/icons8-customer-16.png"))); // NOI18N
        jLabel22.setFocusable(false);
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 0, 0);
        Quan_ly_khach_hang.add(jLabel22, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Khách Hàng");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.8;
        Quan_ly_khach_hang.add(jLabel9, gridBagConstraints);

        pnLeft.add(Quan_ly_khach_hang);

        Quan_ly_hoa_don.setBackground(new java.awt.Color(153, 255, 204));
        Quan_ly_hoa_don.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 153)));
        Quan_ly_hoa_don.setForeground(new java.awt.Color(255, 255, 255));
        Quan_ly_hoa_don.setOpaque(true);
        Quan_ly_hoa_don.setPreferredSize(new java.awt.Dimension(195, 40));
        Quan_ly_hoa_don.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Quan_ly_hoa_donMouseClicked(evt);
            }
        });
        Quan_ly_hoa_don.setLayout(new java.awt.GridBagLayout());

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/icons8-bill-16.png"))); // NOI18N
        jLabel23.setFocusable(false);
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 0, 0);
        Quan_ly_hoa_don.add(jLabel23, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Hoá Đơn");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.8;
        Quan_ly_hoa_don.add(jLabel10, gridBagConstraints);

        pnLeft.add(Quan_ly_hoa_don);

        Quan_ly_nhap_hang.setBackground(new java.awt.Color(153, 255, 204));
        Quan_ly_nhap_hang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 153)));
        Quan_ly_nhap_hang.setForeground(new java.awt.Color(255, 255, 255));
        Quan_ly_nhap_hang.setOpaque(true);
        Quan_ly_nhap_hang.setPreferredSize(new java.awt.Dimension(195, 40));
        Quan_ly_nhap_hang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Quan_ly_nhap_hangMouseClicked(evt);
            }
        });
        Quan_ly_nhap_hang.setLayout(new java.awt.GridBagLayout());

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/icons8-list-view-16.png"))); // NOI18N
        jLabel24.setFocusable(false);
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 0, 0);
        Quan_ly_nhap_hang.add(jLabel24, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Nhập hàng");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.8;
        Quan_ly_nhap_hang.add(jLabel11, gridBagConstraints);

        pnLeft.add(Quan_ly_nhap_hang);

        Quan_ly_khuyen_mai.setBackground(new java.awt.Color(153, 255, 204));
        Quan_ly_khuyen_mai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 153)));
        Quan_ly_khuyen_mai.setForeground(new java.awt.Color(255, 255, 255));
        Quan_ly_khuyen_mai.setOpaque(true);
        Quan_ly_khuyen_mai.setPreferredSize(new java.awt.Dimension(195, 40));
        Quan_ly_khuyen_mai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Quan_ly_khuyen_maiMouseClicked(evt);
            }
        });
        Quan_ly_khuyen_mai.setLayout(new java.awt.GridBagLayout());

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/icons8-sale-16.png"))); // NOI18N
        jLabel25.setFocusable(false);
        jLabel25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 0, 0);
        Quan_ly_khuyen_mai.add(jLabel25, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Khuyến mãi");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.8;
        Quan_ly_khuyen_mai.add(jLabel12, gridBagConstraints);

        pnLeft.add(Quan_ly_khuyen_mai);

        Quan_ly_thong_ke.setBackground(new java.awt.Color(153, 255, 204));
        Quan_ly_thong_ke.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 153)));
        Quan_ly_thong_ke.setForeground(new java.awt.Color(255, 255, 255));
        Quan_ly_thong_ke.setOpaque(true);
        Quan_ly_thong_ke.setPreferredSize(new java.awt.Dimension(195, 40));
        Quan_ly_thong_ke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Quan_ly_thong_keMouseClicked(evt);
            }
        });
        Quan_ly_thong_ke.setLayout(new java.awt.GridBagLayout());

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/do_an_java_new/Resources/icons8-positive-dynamic-16.png"))); // NOI18N
        jLabel32.setFocusable(false);
        jLabel32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 5, 0, 0);
        Quan_ly_thong_ke.add(jLabel32, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Thống kê");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.8;
        Quan_ly_thong_ke.add(jLabel14, gridBagConstraints);

        pnLeft.add(Quan_ly_thong_ke);

        jPanel4.setBackground(new java.awt.Color(153, 255, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(195, 100));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnLeft.add(jPanel4);

        TrangChu10.setBackground(new java.awt.Color(255, 153, 255));
        TrangChu10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 153)));
        TrangChu10.setForeground(new java.awt.Color(255, 255, 255));
        TrangChu10.setOpaque(true);
        TrangChu10.setPreferredSize(new java.awt.Dimension(199, 40));
        TrangChu10.setLayout(new java.awt.GridLayout(1, 3, 0, 100));

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Đăng Xuất");
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });
        TrangChu10.add(jLabel36);

        pnLeft.add(TrangChu10);

        getContentPane().add(pnLeft, java.awt.BorderLayout.WEST);

        pnCenter.setBackground(new java.awt.Color(204, 255, 204));
        pnCenter.setMaximumSize(new java.awt.Dimension(1080, 800));
        pnCenter.setMinimumSize(new java.awt.Dimension(1080, 800));
        pnCenter.setPreferredSize(new java.awt.Dimension(1080, 800));
        pnCenter.setLayout(new java.awt.CardLayout());
        getContentPane().add(pnCenter, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        
         SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "SANPHAM");
        currentPanel="SANPHAM";

        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_jLabel6MouseClicked

    private void Quan_ly_san_phamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Quan_ly_san_phamMouseClicked
        // TODO add your handling code here:
         SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "SANPHAM");
    currentPanel="SANPHAM";
        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_Quan_ly_san_phamMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
         SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "TRANGCHU");
        
        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_jLabel5MouseClicked

    private void TrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrangChuMouseClicked
        // TODO add your handling code here:
         SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "TRANGCHU");

        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_TrangChuMouseClicked

    private void Quan_ly_nhan_vienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Quan_ly_nhan_vienMouseClicked
        // TODO add your handling code here:
           SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "NHANVIEN");
currentPanel="NHANVIEN";
        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_Quan_ly_nhan_vienMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
           SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "NHANVIEN");
        currentPanel="NHANVIEN";

        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_jLabel7MouseClicked

    private void Quan_ly_khach_hangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Quan_ly_khach_hangMouseClicked
        // TODO add your handling code here:
           SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "KHACHHANG");
    currentPanel="KHACHHANG";
        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_Quan_ly_khach_hangMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
           SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "KHACHHANG");
 currentPanel="KHACHHANG";
        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_jLabel9MouseClicked

    private void Quan_ly_hoa_donMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Quan_ly_hoa_donMouseClicked
        // TODO add your handling code here:
           SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "HOADON");
 currentPanel="HOADON";
        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_Quan_ly_hoa_donMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
           SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "HOADON");
 currentPanel="HOADON";

        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_jLabel10MouseClicked

    private void Quan_ly_nhap_hangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Quan_ly_nhap_hangMouseClicked
        // TODO add your handling code here:
           SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "NHAPHANG");
 currentPanel="NHAPHANG";

        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_Quan_ly_nhap_hangMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
           SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "NHAPHANG");
 currentPanel="NHAPHANG";

        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_jLabel11MouseClicked

    private void Quan_ly_khuyen_maiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Quan_ly_khuyen_maiMouseClicked
        // TODO add your handling code here:
           SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "KHUYENMAI");
 currentPanel="KHUYENMAI";

        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_Quan_ly_khuyen_maiMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
           SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "KHUYENMAI");
 currentPanel="KHUYENMAI";

        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_jLabel12MouseClicked

    private void Quan_ly_thong_keMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Quan_ly_thong_keMouseClicked
        // TODO add your handling code here:
           SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "THONGKE");
 currentPanel="THONGKE";

        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_Quan_ly_thong_keMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
           SwingUtilities.invokeLater(() -> {
        CardLayout cardLayout = (CardLayout) pnCenter.getLayout();
        cardLayout.show(pnCenter, "THONGKE");
 currentPanel="THONGKE";

        pnCenter.revalidate();  // Cập nhật layout ngay
        pnCenter.repaint();     // Vẽ lại giao diện nhanh hơn
    });
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Chắc chắn muốn đăng xuất?", "Đăng xuất", JOptionPane.YES_NO_OPTION) ;
        if (confirm != JOptionPane.YES_OPTION)
            return ;
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jLabel36MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Quan_ly_hoa_don;
    private javax.swing.JPanel Quan_ly_khach_hang;
    private javax.swing.JPanel Quan_ly_khuyen_mai;
    private javax.swing.JPanel Quan_ly_nhan_vien;
    private javax.swing.JPanel Quan_ly_nhap_hang;
    private javax.swing.JPanel Quan_ly_san_pham;
    private javax.swing.JPanel Quan_ly_thong_ke;
    private javax.swing.JPanel TrangChu;
    private javax.swing.JPanel TrangChu10;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnLeft;
    // End of variables declaration//GEN-END:variables

    SanPhamPanel getSanPhamPanel() {
        return sanPhamPanel;
    }
}
