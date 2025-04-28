/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package do_an_java_new;

import java.awt.Font;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;

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
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
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
