/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.BLL;

import do_an_java_new.DAO.HangDAO;
import do_an_java_new.DTO.HangDTO;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Administrator
 */
public class HangBLL {
    public static ArrayList<HangDTO> getHangs() throws SQLException {
        return HangDAO.getHangs();
    }

    public static void xoaHang(String mahang) throws SQLException {
        HangDAO.xoaHang(mahang);
    }
}
