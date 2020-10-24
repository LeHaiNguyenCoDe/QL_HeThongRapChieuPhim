/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ql_rap;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author NguyenLeHai
 */
public class MySqlConnect {
    public static Connection conn = null;
    public static String userID = "";
    public static String name = "";
    public static String quyen ="";
    public static String pass ="";
   
    public  static  Connection ConnectDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connet=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/ql_rap","root","nguyenlehai");
            JOptionPane.showMessageDialog(null,"Connected to database");
            return connet;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public static String getConnection(){
    String kq="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ql_rap","root","nguyenlehai");
        } catch (Exception e) {
            kq= "Lỗi kết nối CSDL: "+ e;
        }
    return kq;
    }
 }
