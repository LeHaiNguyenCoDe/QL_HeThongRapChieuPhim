/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_rap;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author NguyenLinh
 */
public class NhanVien extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ArrayList<String> makh = new ArrayList();
    boolean them;

    public NhanVien() {
        initComponents();
        khoiDong();
        ActiveControls(false);
    }
    
    private void ActiveControls(boolean status)
    {
        txtMaNV.setEditable(status);
        txtTenNV.setEditable(status);
        rdbNam.setEnabled(status);
        rdbNu.setEnabled(status);
        txtQueQuan.setEditable(status); 
        txtSDT.setEditable(status); 
        txtEmail.setEditable(status); 
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
            String sql = "Select * from ql_rap.nhanvien;";
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
                        tblNV.setModel(dtm);
                    }
                    tblNV.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
                        if (tblNV.getSelectedRow() >= 0) {
                            txtMaNV.setText((String) tblNV.getValueAt(tblNV.getSelectedRow(), 0));
                            txtTenNV.setText((String) tblNV.getValueAt(tblNV.getSelectedRow(), 1));
                            txtNgaySinh.setText((String) tblNV.getValueAt(tblNV.getSelectedRow(), 2));
                            if (tblNV.getValueAt(tblNV.getSelectedRow(), 3).equals("Nam")) {
                                rdbNam.setSelected(true);
                            } else {
                                rdbNu.setSelected(true);
                            }
                            txtQueQuan.setText((String) tblNV.getValueAt(tblNV.getSelectedRow(), 4));
                            txtSDT.setText((String) tblNV.getValueAt(tblNV.getSelectedRow(), 5));
                            txtEmail.setText((String) tblNV.getValueAt(tblNV.getSelectedRow(), 6));
                            txtLuong.setText((String) tblNV.getValueAt(tblNV.getSelectedRow(), 7));
                        }
                    });
                }
                stmt.close();
                MySqlConnect.conn.close();
                tblNV.setRowSelectionInterval(0, 0);
                tblNV.getColumnModel().getColumn(1).setPreferredWidth(150);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        rdbNam = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtQueQuan = new javax.swing.JTextField();
        rdbNu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(949, 594));

        jLabel5.setText("Phải:");

        jLabel10.setText("Số điện thoại:");

        jLabel11.setText("Lương:");

        jLabel12.setText("Quê quán");

        jLabel2.setText("Mã nhân viên:");

        jLabel3.setText("Email:");

        buttonGroup1.add(rdbNam);
        rdbNam.setText("Nam");

        jLabel4.setText("Tên nhânn viên:");

        buttonGroup1.add(rdbNu);
        rdbNu.setText("Nữ");

        tblNV.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblNV);

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

        jPanel1.setBackground(new java.awt.Color(153, 180, 209));

        jLabel1.setBackground(new java.awt.Color(153, 180, 209));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BẢNG THÔNG TIN NHÂN VIÊN");

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

        jLabel13.setText("Ngày sinh:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(140, 140, 140)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel12))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtQueQuan)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(rdbNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdbNu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(10, 10, 10)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(rdbNam)
                            .addComponent(rdbNu)
                            .addComponent(jLabel13)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel11)
                            .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        them = true;
        ActiveControls(true);
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtQueQuan.setText("");
        txtSDT.setText("");
        txtLuong.setText("");
        txtEmail.setText("");
        rdbNam.setSelected(true);
        txtNgaySinh.setText("dd/mm/yy");
        txtMaNV.requestFocus();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
       them = false;
        ActiveControls(true);
        txtMaNV.setEditable(false);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        String errConnect = MySqlConnect.getConnection();
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtMaNV, "mã nhân viên") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtTenNV, "tên nhan viên") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtNgaySinh, "ngày sinh") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtQueQuan, "quê quán") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtLuong, "luong") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtSDT, "so diên thoai") == false) return;
        if (KiemTraNhapLieu.kiemTraNhapLieu(this, txtEmail, "email") == false) return;
        if (!errConnect.equals("")) {
            JOptionPane.showMessageDialog(this, errConnect, "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {

            
            String sql = "insert into ql_rap.nhanvien(manv,tennv,ngaysinh,gioitinh,quequan,sodienthoai,email,luong) values (?,?,?,?, ?, ?, ?, ?);";
            String sql1 = "UPDATE ql_rap.nhanvien SET tennv=? , ngaysinh=?, gioitinh= ? , quequan =? ,sodienthoai=?, email=?,luong=? where manv= ?;";
            PreparedStatement pstmt;
            String kq;
                if(them){
                    try {
                        pstmt = MySqlConnect.conn.prepareStatement(sql);
                        pstmt.setString(1, txtMaNV.getText());
                        pstmt.setString(2, txtTenNV.getText());
                        pstmt.setString(3, txtNgaySinh.getText());                        
                        if (rdbNam.isSelected()) {
                            pstmt.setString(4, "Nam");
                        } else {
                            pstmt.setString(4, "Nu");
                        }
                        pstmt.setString(5, txtQueQuan.getText());
                        pstmt.setString(6, txtSDT.getText());
                        pstmt.setString(7, txtEmail.getText());
                        pstmt.setString(8, txtLuong.getText());
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
                        pstmt.setString(1, txtTenNV.getText());
                        pstmt.setString(2, txtNgaySinh.getText());                        
                        if (rdbNam.isSelected()) {
                            pstmt.setString(3, "Nam");
                        } else {
                            pstmt.setString(3, "Nu");
                        }
                        pstmt.setString(4, txtQueQuan.getText());
                        pstmt.setString(5, txtSDT.getText());
                        pstmt.setString(6, txtEmail.getText());
                        pstmt.setString(7, txtLuong.getText());
                        pstmt.setString(8, txtMaNV.getText());
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
        tblNV.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String errConnect = MySqlConnect.getConnection();
        if (!errConnect.equals("")) {
            JOptionPane.showMessageDialog(this, errConnect, "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn muốn xóa sinh viên "+txtMaNV.getText()+" không?", "Xác nhận xóa", JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION) {
                PreparedStatement pstmt;                
                try {
                    String sql = "DELETE FROM ql_rap.nhanvien WHERE manv = ?;";
                    pstmt = MySqlConnect.conn.prepareStatement(sql);
                    pstmt.setString(1, txtMaNV.getText());
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbNam;
    private javax.swing.JRadioButton rdbNu;
    private javax.swing.JTable tblNV;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
