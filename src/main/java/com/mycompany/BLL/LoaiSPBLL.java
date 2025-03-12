/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BLL;

import com.mycompany.DAO.LoaiSPDAO;
import com.mycompany.DTO.LoaiSPDTO;
import java.util.ArrayList;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class LoaiSPBLL {
    public static ArrayList<LoaiSPDTO> getDanhSachLoaiSP() throws Exception {
        return LoaiSPDAO.getDanhSachLoaiSP();
    }
}
