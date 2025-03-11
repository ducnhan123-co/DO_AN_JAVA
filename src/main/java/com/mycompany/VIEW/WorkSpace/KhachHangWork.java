/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.VIEW.WorkSpace;

import com.mycompany.VIEW.WorkSpace.RightPanelItems.ComboBoxPanel;
import com.mycompany.VIEW.WorkSpace.RightPanelItems.TextPanel;
import com.mycompany.VIEW.WorkSpace.WorkPanel;

/**
 *
 * @author ASUS-PC
 */
public class KhachHangWork extends WorkPanel {
    TextPanel searchPanel = new TextPanel("Tìm kiếm");
    ComboBoxPanel sort = new ComboBoxPanel("Sắp xếp");
    
    public KhachHangWork() {
        super();
        
        renderComboboxs();
        
        addRightPanels(searchPanel, sort);
        
        addColumns("maKH", "Họ", "Tên lót", "Tên", "phái", "Ngày sinh", "SDT", "Tỉnh", "Địa chỉ", "Ngày tham gia", "Điểm", "Trạng thái");

    }
    
    public void renderComboboxs() {
        sort.addElement("A-Z", "Z-A");
    }

    
    @Override
    public void addRows() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
