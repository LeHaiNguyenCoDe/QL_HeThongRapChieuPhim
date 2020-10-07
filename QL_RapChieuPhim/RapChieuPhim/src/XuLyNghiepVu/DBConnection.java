/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package XuLyNghiepVu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NGUYENLEHAI
 */
public class DBConnection {
    public  static Connection conn = null;
    public  static String getConnection(){
        String connString = "jdbc:sqlserver://DESKTOP-VLA5JUU;databaseName:QL_RapPhim;user=nguyenlehai;password=1";
        String kq = "";
        try {
            conn = DriverManager.getConnection(connString);
        } catch (SQLException ex) {
            kq ="Lỗi kết nối: "+ ex;
        }
        return  kq;
    } 
    public static void main(String[] args) {
        System.out.println("Kết nối thành công");
    }
}
