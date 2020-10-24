/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_rap;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author NguyenLinh
 */
public class Phim extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ArrayList<String> makh = new ArrayList();
    boolean them;

    public Phim() {
        initComponents();
        khoiDong();
        ActiveControls(false);
    }
    
    private void ActiveControls(boolean status)
    {
        txtMaPhim.setEditable(status);
        txtTenPhim.setEditable(status);
        txtDaoDien.setEditable(status); 
        txtDienVien.setEditable(status); 
        txtGioBD.setEditable(status); 
        txtGioKT.setEditable(status); 
        txtQuocGia.setEditable(status); 
        txtThoiGian.setEditable(status); 
        txtXuatChieu.setEditable(status);         
        btnHuy.setVisible(status);
        btnThem.setVisible(!status);
        btnXoa.setVisible(!status);
        btnSua.setVisible(!status);
        btnLuu.setVisible(status);
    }
    
    
    public void khoiDong(){
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        
        loadData();
    }
    
       
    private void loadData() {
String errConnect = MySqlConnect.getConnection();
        if (!errConnect.equals("")) {
            JOptionPane.showMessageDialog(this, errConnect, "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            String sql = "select * from ql_rap.phim";
            Statement stmt;
            try {
                stmt = MySqlConnect.conn.createStatement();
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int n = rsmd.getColumnCount();
                    Vector col, row = null;
                    col = new Vector();
                    for (int i = 1; i <= n; i++) {
                        col.add(rsmd.getColumnName(i));
                    }
                    dtm.setColumnIdentifiers(col);
                    while (rs.next()) {
                        row = new Vector();
                        for (int i = 1; i <= n; i++) {
                            row.addElement(rs.getString(i));
                        }
                        dtm.addRow(row);
                        tblPhim.setModel(dtm);
                    }
                    tblPhim.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
                        if (tblPhim.getSelectedRow() >= 0) {
                            txtMaPhim.setText((String) tblPhim.getValueAt(tblPhim.getSelectedRow(), 0));
                            txtTenPhim.setText((String) tblPhim.getValueAt(tblPhim.getSelectedRow(), 1));
                            txtThoiGian.setText((String) tblPhim.getValueAt(tblPhim.getSelectedRow(), 2));
                            txtQuocGia.setText((String) tblPhim.getValueAt(tblPhim.getSelectedRow(), 3));
                            txtDaoDien.setText((String) tblPhim.getValueAt(tblPhim.getSelectedRow(), 4));
                            txtDienVien.setText((String) tblPhim.getValueAt(tblPhim.getSelectedRow(), 5));
                            txtXuatChieu.setText((String) tblPhim.getValueAt(tblPhim.getSelectedRow(), 6));
                            txtGioBD.setText((String) tblPhim.getValueAt(tblPhim.getSelectedRow(), 7));
                            txtGioKT.setText((String) tblPhim.getValueAt(tblPhim.getSelectedRow(), 8));
                        }
                    });
                }
                stmt.close();
                MySqlConnect.conn.close();
                tblPhim.setRowSelectionInterval(0, 0);
                tblPhim.getColumnModel().getColumn(1).setPreferredWidth(150);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtThoiGian = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaPhim = new javax.swing.JTextField();
        txtTenPhim = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQuocGia = new javax.swing.JTextField();
        txtDaoDien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhim = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDienVien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtXuatChieu = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtGioBD = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtGioKT = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(949, 594));

        jLabel6.setText("Quốc Gia");

        jLabel7.setText("Đạo Diễn ");

        jLabel10.setText("Thời Gian ");

        jLabel2.setText("Mã Phim");

        jLabel4.setText("Tên Phim");

        tblPhim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPhim);

        jPanel1.setBackground(new java.awt.Color(153, 180, 209));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PHIM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jLabel8.setText("Diễn viên");

        jLabel9.setText("Xuất Chiếu");

        jLabel11.setText("Giờ Bắt Đầu");

        jLabel12.setText("Giờ Kết Thúc");

        btnThem.setText("Thêm");
        btnThem.setBorder(null);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.setBorder(null);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.setBorder(null);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.setBorder(null);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.setBorder(null);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDaoDien, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGioBD, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDienVien, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGioKT, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtXuatChieu, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(txtMaPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(txtDaoDien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtDienVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(txtQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtGioKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel11)
                            .addComponent(txtGioBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtXuatChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtThoiGian, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        them = true;
        ActiveControls(true);
        txtMaPhim.setText("");
        txtDaoDien.setText("");
        txtDienVien.setText("");
        txtGioBD.setText("");
        txtGioKT.setText("");
        txtQuocGia.setText("");
        txtTenPhim.setText("");
        txtThoiGian.setText("");
        txtXuatChieu.setText("");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
       them = false;
        ActiveControls(true);
        txtMaPhim.setEditable(false);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
String errConnect = MySqlConnect.getConnection();
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtDaoDien, "mã đạp diễn") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtDienVien, "tên diễn viên") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtGioBD, "giờ bắt đầu") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtGioKT, "giời kết thúc") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtMaPhim, "mã phim") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtQuocGia, "quốc gia") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtTenPhim, "tên phim") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtThoiGian, "thời gian") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtXuatChieu, "xuất chiếu") == false) return;
        if (!errConnect.equals("")) {
            JOptionPane.showMessageDialog(this, errConnect, "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            String sql = "INSERT into ql_rap.phim(maphim,tenphim,thoigian,quocgia,daodien,diendien,suatchieu,giobatdau,gioketthuc) values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            String sql1 = "update ql_rap.phim set tenphim=?,thoigian=?,quocgia=?,daodien=?,diendien=?,suatchieu=?,giobatdau=?, gioketthuc=? where maphim=?;";
            PreparedStatement pstmt;
            String kq;
                if(them){
                    try {
                        pstmt = MySqlConnect.conn.prepareStatement(sql);
                        pstmt.setString(1, txtMaPhim.getText());
                        pstmt.setString(2, txtTenPhim.getText());
                        pstmt.setString(3, txtThoiGian.getText());                        
                        pstmt.setString(4, txtQuocGia.getText());
                        pstmt.setString(5, txtDaoDien.getText());
                        pstmt.setString(6, txtDienVien.getText());
                        pstmt.setString(7, txtXuatChieu.getText());
                        pstmt.setString(8, txtGioBD.getText());
                        pstmt.setString(9, txtGioKT.getText());
                        pstmt.executeUpdate();
                        pstmt.close();
                        MySqlConnect.conn.close();
                        dtm.setRowCount(0);
                        loadData();
                        ActiveControls(false);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                       try {
                        pstmt = MySqlConnect.conn.prepareStatement(sql1);
                        pstmt.setString(1, txtTenPhim.getText());
                        pstmt.setString(2, txtThoiGian.getText());
                        pstmt.setString(3, txtQuocGia.getText());
                        pstmt.setString(4, txtDaoDien.getText());
                        pstmt.setString(5, txtDienVien.getText());
                        pstmt.setString(6, txtXuatChieu.getText());
                        pstmt.setString(7, txtGioBD.getText());
                        pstmt.setString(8, txtGioKT.getText());
                        pstmt.setString(9, txtMaPhim.getText());
                        pstmt.executeUpdate();
                        pstmt.close();
                        MySqlConnect.conn.close();
                        dtm.setRowCount(0);
                        loadData();
                        ActiveControls(false);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        them = false;
        dtm.setRowCount(0);
        loadData();
        ActiveControls(false);
        tblPhim.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String errConnect = MySqlConnect.getConnection();
        if (!errConnect.equals("")) {
            JOptionPane.showMessageDialog(this, errConnect, "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn muốn xóa phim "+txtMaPhim.getText()+" không?", "Xác nhận xóa", JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION) {
                PreparedStatement pstmt;                
                try {
                    String sql = "DELETE FROM ql_rap.phim WHERE maphim = ?;";
                    pstmt = MySqlConnect.conn.prepareStatement(sql);
                    pstmt.setString(1, txtMaPhim.getText());
                    pstmt.executeUpdate();
                    pstmt.close();
                    MySqlConnect.conn.close();
                    dtm.setRowCount(0);
                    loadData();
                    ActiveControls(false);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPhim;
    private javax.swing.JTextField txtDaoDien;
    private javax.swing.JTextField txtDienVien;
    private javax.swing.JTextField txtGioBD;
    private javax.swing.JTextField txtGioKT;
    private javax.swing.JTextField txtMaPhim;
    private javax.swing.JTextField txtQuocGia;
    private javax.swing.JTextField txtTenPhim;
    private javax.swing.JTextField txtThoiGian;
    private javax.swing.JTextField txtXuatChieu;
    // End of variables declaration//GEN-END:variables
}
