/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.BLL;

import com.mycompany.DAO.HangDAO;
import com.mycompany.DTO.HangDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class HangBLL {
    public static ArrayList<HangDTO> getHangs() throws SQLException {
        return HangDAO.getHangs();
    }
}
