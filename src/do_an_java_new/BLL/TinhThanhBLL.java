/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package do_an_java_new.BLL;

import do_an_java_new.DAO.TinhThanhDAO;
import java.util.ArrayList;

/**
 *
 * @author ASUS-PC
 */
public class TinhThanhBLL {
    public static ArrayList<String> getDanhSachTinh() throws Exception {
        return TinhThanhDAO.getDanhSachTinh();
    }
    
    public static int getMaTinh(String tenTinh) {
        return TinhThanhDAO.getMaTinh(tenTinh);
    }
}
