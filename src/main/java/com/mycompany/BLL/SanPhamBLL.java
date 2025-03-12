/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BLL;

import com.mycompany.DAO.SanPhamDAO;
import com.mycompany.DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class SanPhamBLL {
    public static ArrayList<SanPhamDTO> getDanhSachSanPham() throws Exception {
        return SanPhamDAO.getDanhSachSanPham();
    }
}
