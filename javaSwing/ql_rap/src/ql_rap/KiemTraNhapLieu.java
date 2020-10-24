/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_rap;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author NguyenLinh
 */
public class KiemTraNhapLieu {
    public static boolean kiemTraNhapLieu(JInternalFrame jit,JTextField txt,String msg)
    {

        if ("".equals(txt.getText())) {
            JOptionPane.showMessageDialog(jit, "Bạn chưa nhập " + msg, "Lỗi", JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean kiemTraSoThuc(JInternalFrame jit,JTextField txt, String msg)
    {
        if (txt.getText().equals("")) {
            JOptionPane.showMessageDialog(txt, "Bạn chưa nhập " + msg, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            txt.selectAll();
            return false;
        }
        float so = 0;
        try {
            so = Float.parseFloat(txt.getText());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(txt, "Kiểu dữ liệu " + msg+" không hợp lệ", "Error", JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            txt.selectAll();
            return false;
        }
    }
    
}
