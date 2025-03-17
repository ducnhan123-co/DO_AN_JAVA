/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package do_an_java_new.VIEW;

import do_an_java_new.BLL.LoaiSPBLL;
import do_an_java_new.BLL.SanPhamBLL;
import do_an_java_new.DTO.LoaiSPDTO;
import do_an_java_new.DTO.SanPhamDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pducn
 */
public class SanPhamPanel extends javax.swing.JPanel {
     private SanPhamBLL sanPhamBLL;
     private LoaiSPBLL loaiSPBLL;
      private String currentSubMode;
    /**
     * Creates new form NhanVienPanel
     */
    public SanPhamPanel() throws Exception {
        initComponents();
        sanPhamBLL = new SanPhamBLL();
        loaiSPBLL = new LoaiSPBLL();
         currentSubMode = "SANPHAM";
         loadDataToTable();
    }
    
   public int getSelectedTabIndex() {
    return jTabbedPane1.getSelectedIndex();
}

      public String getCurrentSubMode() {
        return currentSubMode;
    }

    public void setCurrentSubMode(String mode) {
        this.currentSubMode = mode;
    }
       private void loadDataToTable() throws Exception {
        // Gọi hàm BLL để lấy danh sách sản phẩm
        List<SanPhamDTO> listSP = sanPhamBLL.getDanhSachSanPham();
        List<LoaiSPDTO> dsLoai = loaiSPBLL.getDanhSachLoaiSP();
        
        // Lấy model của jTable
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();

        model.setRowCount(0); // Xóa trắng dữ liệu cũ trước khi thêm
        model2.setRowCount(0); 

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
        for (LoaiSPDTO loai : dsLoai) {
        model2.addRow(new Object[] {
            loai.getMaLoai(),
            loai.getTenLoai(),
            loai.getMota()
        });
    }
    }
       
       public SanPhamDTO getSelectedSanPham() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            // Người dùng chưa chọn dòng
            return null;
        }

        // Lấy dữ liệu từng cột
        String maSP       = (String) jTable1.getValueAt(selectedRow, 0);
        String tenSP      = (String) jTable1.getValueAt(selectedRow, 1);
        String loai       = (String) jTable1.getValueAt(selectedRow, 2);
        String donViTinh  = (String) jTable1.getValueAt(selectedRow, 3);
        int hanSuDung  = (int) jTable1.getValueAt(selectedRow, 4);
        String moTa       = (String) jTable1.getValueAt(selectedRow, 5);
        int gia        = (int) jTable1.getValueAt(selectedRow, 6);
        Integer soLuong   = (Integer) jTable1.getValueAt(selectedRow, 7);

        // Tạo SanPhamDTO
        SanPhamDTO sp = new SanPhamDTO(maSP, tenSP, loai, donViTinh, 0, moTa, 0, 0);
        sp.setMaSP(maSP);
        sp.setTenSP(tenSP);
        sp.setLoaiSP(loai);
        sp.setDonViTinh(donViTinh);
        sp.setHanSuDung(hanSuDung);
        sp.setMoTa(moTa);
        sp.setGia(gia);
        sp.setSoLuongTon(soLuong);

        return sp;
    }
       
       public LoaiSPDTO getSelectedLoaiSanPham() {
    int selectedRow = jTable2.getSelectedRow();
    if (selectedRow == -1) {
        return null; // chưa chọn dòng
    }
    String maLoai = (String) jTable2.getValueAt(selectedRow, 0);
    String tenLoai = (String) jTable2.getValueAt(selectedRow, 1);
    String moTa = (String) jTable2.getValueAt(selectedRow, 2);

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

        jLabel1 = new javax.swing.JLabel();
        buttonPanel2 = new do_an_java_new.VIEW.ButtonPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(1080, 800));
        setPreferredSize(new java.awt.Dimension(1080, 800));

        buttonPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Quản lý sản phẩm", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("Quản lý loại sản phẩm", jScrollPane2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại", "Đơn vị tính", "Hạn sử dụng", "Mô tả ", "Giá", "Số lượng tồn"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jTabbedPane1.addTab("Quản lý hàng hoá", jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private do_an_java_new.VIEW.ButtonPanel buttonPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
