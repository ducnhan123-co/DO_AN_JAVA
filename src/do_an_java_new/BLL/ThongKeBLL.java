package do_an_java_new.BLL;

import do_an_java_new.DAO.ThongKeDAO;
import java.sql.Date;
import java.util.List;
import java.sql.SQLException;

public class ThongKeBLL {

    public static List<Object[]> thongKeSanPham(String maSP, Date tuNgay, Date denNgay, String kieuThongKe) throws Exception {
        if (tuNgay != null && denNgay != null && tuNgay.after(denNgay)) {
            throw new Exception("Từ ngày không thể sau Đến ngày!");
        }
        try {
            return ThongKeDAO.thongKeSanPham(maSP, tuNgay, denNgay, kieuThongKe);
        } catch (SQLException ex) {
            throw new Exception("Lỗi SQL: " + ex.getMessage());
        }
    }
}