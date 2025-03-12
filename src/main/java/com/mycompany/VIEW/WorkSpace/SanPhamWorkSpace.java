/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.VIEW.WorkSpace;

import com.mycompany.BLL.SanPhamBLL;
import com.mycompany.DTO.SanPhamDTO;
import com.mycompany.VIEW.WorkSpace.RightPanelItems.ComboBoxPanel;
import com.mycompany.VIEW.WorkSpace.RightPanelItems.TextPanel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class SanPhamWorkSpace extends WorkPanel {
    TextPanel searchPanel = new TextPanel("Tìm kiếm");
    ComboBoxPanel sort = new ComboBoxPanel("Sắp xếp");
    
    public SanPhamWorkSpace() {
        super();
        
        renderComboboxs();
        
        addRightPanels(searchPanel, sort);
        
        addColumns("Tên", "Mã SP", "Loại", "Đơn vị tính", "Hạn sử dụng", "Mô tả", "Giá", "Số lượng tồn");
        
        addRows();
    }
    
    public void renderComboboxs() {
        sort.addElement("A-Z", "Z-A", "Giá tăng", "Giá giảm");
    }

    @Override
    public void addRows() {
        try {
            for (SanPhamDTO sanPham: SanPhamBLL.getDanhSachSanPham()) {
                tableModel.addRow(new Object[] {
                    sanPham.getTenSP(),
                    sanPham.getMaSP(),
                    sanPham.getLoaiSP(),
                    sanPham.getDonViTinh(),
                    sanPham.getHanSuDung(),
                    sanPham.getMota(),
                    sanPham.getGia(),
                    sanPham.getSoLuongTon()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void insert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
