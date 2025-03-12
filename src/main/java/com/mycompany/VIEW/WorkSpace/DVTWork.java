/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.VIEW.WorkSpace;

import com.mycompany.BLL.LoaiSPBLL;
import com.mycompany.DTO.LoaiSPDTO;
import com.mycompany.VIEW.WorkSpace.RightPanelItems.ComboBoxPanel;
import com.mycompany.VIEW.WorkSpace.RightPanelItems.TextPanel;
import com.mycompany.VIEW.WorkSpace.WorkPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class DVTWork extends WorkPanel {
    TextPanel searchPanel = new TextPanel("Tìm kiếm");
    ComboBoxPanel sort = new ComboBoxPanel("Sắp xếp");
    
    public DVTWork() {
        super();
        
        renderComboboxs();
        
        addRightPanels(searchPanel, sort);
        
        addColumns("Mã", "Tên loại", "Mô tả");
        
        addRows();
    }
    
    public void renderComboboxs() {
        sort.addElement("A-Z", "Z-A");
    }

    
    @Override
    public void addRows() {
        try {
            for (LoaiSPDTO loai: LoaiSPBLL.getDanhSachLoaiSP()) {
                tableModel.addRow(new Object[] {
                    loai.getMaLoai(),
                    loai.getTenLoai(),
                    loai.getMota()
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
