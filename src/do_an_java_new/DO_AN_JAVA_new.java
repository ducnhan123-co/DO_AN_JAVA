/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package do_an_java_new;

import do_an_java_new.VIEW.MainFrame;
import java.awt.Font;
import javax.swing.UIManager;

/**
 *
 * @author pducn
 */
public class DO_AN_JAVA_new {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Đặt Look and Feel Nimbus
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    // Tinh chỉnh font toàn cục (tùy chọn)
    UIManager.put("Button.font", new Font("Segoe UI", Font.PLAIN, 14));
    UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14));
    // Có thể thêm UIManager.put("Panel.background", Color.WHITE); ... nếu muốn

    // Khởi chạy Login
    java.awt.EventQueue.invokeLater(() -> {
        new Login().setVisible(true);
    });
}
}
