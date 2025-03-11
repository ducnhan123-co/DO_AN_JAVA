/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.VIEW;

import com.mycompany.DTO.NhanVienDTO;
import com.mycompany.VIEW.WorkSpace.RightPanelItems.LoaiSanPhamWork;
import com.mycompany.VIEW.WorkSpace.SanPhamWorkSpace;
import com.mycompany.VIEW.WorkSpace.WorkPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS-PC
 */
public class AdminFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminFrame
     */
    ArrayList<MenuItem> itemList = new ArrayList<>();
    NhanVienDTO user ;
    CardLayout cardLayout;
    
    public AdminFrame(NhanVienDTO user) {
        initComponents();
        initTile();
        
        cardLayout = (CardLayout) rightPanel.getLayout();

        this.user = user ;
        userName.setText(user.getFullName());
        
        initMenuItem();
        addMenuItemEvent();
        
        initWorkSpace();
    }
    
    public AdminFrame() {
        initComponents();
        
        cardLayout = (CardLayout) rightPanel.getLayout();

        initTile();
        
        initMenuItem();
        addMenuItemEvent();
        
        initWorkSpace();
    }
    
    public final void initTile() {
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Images/desktop32.png"));
        setIconImage(icon.getImage());
    }
    
    private void initMenuItem() {
//        san pham
        MenuItem sp = new MenuItem("San pham");
        MenuItem qlsp = new MenuItem("Quan ly san pham", "qlsp");
        MenuItem qlhh = new MenuItem("Quan ly hang hoa", "qlhh");
        MenuItem qllsp = new MenuItem("Quan ly loai san pham", "qllsp");
        MenuItem tksp = new MenuItem("Thong ke san pham", "tksp");
        sp.addSubItems(qlsp, qlhh, qllsp, tksp);
        
//        nhan vien
        MenuItem nv = new MenuItem("Nhan vien");
        MenuItem qlnv = new MenuItem("Quan ly nhan vien", "qlnv");
        MenuItem tknv = new MenuItem("Thong ke nhan vien", "tknv");
        nv.addSubItems(qlnv, tknv);
        
//        khach hang
        MenuItem kh = new MenuItem("Khach hang");
        MenuItem qlkh = new MenuItem("Quan ly khach hang", "qlkh");
        kh.addSubItems(qlkh);
       
//        hoa don
        MenuItem hd = new MenuItem("Hoa Don");
        MenuItem qlhd = new MenuItem("Quan ly hoa don", "qlhd");
        hd.addSubItems(qlhd);
        
//        nhap hang
        MenuItem nh = new MenuItem("Nhap Hang");
        MenuItem qlnh = new MenuItem("Quan ly nhap hang", "qlnh");
        nh.addSubItems(qlnh);
        
//        khuyen mai
        MenuItem km = new MenuItem("Khuyen mai");
        MenuItem qlkm = new MenuItem("Quan ly khuyen mai", "qlkm");
        km.addSubItems(qlkm);
        
//       render
        addMenuItem(sp, qlsp, qlhh, qllsp, tksp, nv, qlnv, tknv, kh, qlkh, hd, qlhd, nh, qlnh, km, qlkm);
    }
    
    private void initWorkSpace() {
        rightPanel.add(new SanPhamWorkSpace(), "qlsp");
        rightPanel.add(new LoaiSanPhamWork(), "qllsp");
    }
    
    private void addMenuItem(MenuItem... items) {
        for (MenuItem item: items) {
            itemList.add(item);
            leftPanel.add(item);
            if (item.getParentItem() != null) 
                item.setVisible(false);
        }
    }
    
    private void addMenuItemEvent() {
        for (MenuItem item: itemList) {
            item.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    
                    for (MenuItem childItem: itemList) {
                        childItem.setFontColor(new java.awt.Color(30,30,30));
                    }
                    item.setFontColor(new java.awt.Color(204,255,51));
                    
                    if (item.getId().equals("")) {
                        item.setSelected(!item.isSelected());
                        
                        for (MenuItem childItemitem: itemList) {
                            if (childItemitem.getParentItem() == item) {
                                childItemitem.setVisible(item.isSelected());
                            }
                        }
                    } else {
                        switch(item.getId()) {
                            case "qlsp" :
                                cardLayout.show(rightPanel, "qlsp");
                                break;
                            case "qllsp":
                                cardLayout.show(rightPanel, "qllsp");
                                break;
                            default:
                                break;
                        }
                    }
                }
                
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        userName = new javax.swing.JLabel();
        btnSignOut = new javax.swing.JButton();
        leftPanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cửa hàng thực phẩm");
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        userName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userName.setText("Item label");
        jPanel3.add(userName);

        btnSignOut.setText("Đăng xuất");
        btnSignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSignOutMouseClicked(evt);
            }
        });
        jPanel3.add(btnSignOut);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        leftPanel.setToolTipText("");
        leftPanel.setName("Cửa hàng thực phẩm"); // NOI18N
        leftPanel.setLayout(new javax.swing.BoxLayout(leftPanel, javax.swing.BoxLayout.Y_AXIS));
        jPanel1.add(leftPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        rightPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(rightPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignOutMouseClicked
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn đăng xuất?", "Đăng xuất", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            new LoginFrame().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnSignOutMouseClicked

    @Override
    public synchronized void addWindowListener(WindowListener l) {
        super.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int closeConfirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắc muốn đóng chưa trình?", "Đóng chương trình", JOptionPane.YES_NO_OPTION);
                if (closeConfirm == JOptionPane.YES_OPTION) {
                    dispose();
                }
                // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
            
        }); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new AdminFrame().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignOut;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}
