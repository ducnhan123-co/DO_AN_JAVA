/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package do_an_java_new.BLL;

import do_an_java_new.DAO.NhaCungCapDAO;
import do_an_java_new.DTO.NhaCungCapDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Tran Dinh Khanh Du
 */
public class NhaCungCapBLL {
    private static ArrayList<NhaCungCapDTO> listOf_NCC = null;
    
    public static ArrayList<NhaCungCapDTO> getDanhSachNCC(int sortOption, int searchOption, String keyWord) throws SQLException {
        if (listOf_NCC == null)
            listOf_NCC = NhaCungCapDAO.getDanhSachNCC();
        
        ArrayList<NhaCungCapDTO> res ;
        
        if (searchOption != 0) {
            res = new ArrayList<>();
            switch(searchOption) {
                case 1:
                    for (NhaCungCapDTO ncc: listOf_NCC) 
                        if (ncc.getMaNCC().contains(keyWord))
                            res.add(ncc);
                    break;
                case 2:
                    for (NhaCungCapDTO ncc: listOf_NCC) 
                        if (ncc.getTenNCC().contains(keyWord))
                            res.add(ncc);
                    break;
                case 3:
                    for (NhaCungCapDTO ncc: listOf_NCC) 
                        if (ncc.getTenLienHe().contains(keyWord))
                            res.add(ncc);
                    break;
                case 4:
                    for (NhaCungCapDTO ncc: listOf_NCC) 
                        if (ncc.getSdt().contains(keyWord))
                            res.add(ncc);
                    break;
            }   
        } else 
            res = new ArrayList<>(listOf_NCC);
        
        switch(sortOption) {
            case 1:
                res.sort(Comparator.comparing(NhaCungCapDTO::getTenNCC));
                break;
            case 2:
                res.sort(Comparator.comparing(NhaCungCapDTO::getTenNCC).reversed());
                break;
            case 3:
                res.sort(Comparator.comparing(NhaCungCapDTO::getTenLienHe));
                break;
            case 4:
                res.sort(Comparator.comparing(NhaCungCapDTO::getTenLienHe).reversed());
                break;
            default:
                break;
        }
        
        return res;
    }
    
    public static void themNhaCungCap(NhaCungCapDTO ncc) throws Exception {
        if (ncc.getMaNCC().isBlank() || ncc.getTenNCC().isBlank() || ncc.getTenLienHe().isBlank())
            throw new Exception("Thông tin nhà cung cấp không hợp lệ");
        
        int matinh = TinhThanhBLL.getMaTinh(ncc.getTinhThanh());
        
        NhaCungCapDAO.themNhaCungCap(ncc, matinh);
        listOf_NCC.add(ncc);
    }
    
    public static void suaNhaCungCap(NhaCungCapDTO ncc) throws SQLException {
        NhaCungCapDAO.suaNhaCungCap(ncc, TinhThanhBLL.getMaTinh(ncc.getTinhThanh()));
        
        for (int i = 0 ; i < listOf_NCC.size() ; i++) {
            if (listOf_NCC.get(i).getMaNCC().equals(ncc.getMaNCC()))
                listOf_NCC.set(i, ncc);
        }
    }
    
    public static void xoaNhaCungCap(String maNCC) throws SQLException {
        NhaCungCapDAO.xoaNhaCungCap(maNCC);
        
        for (int i = 0 ; i < listOf_NCC.size() ; i++) 
            if (listOf_NCC.get(i).getMaNCC().equals(maNCC))
                listOf_NCC.remove(i);
    }
}
