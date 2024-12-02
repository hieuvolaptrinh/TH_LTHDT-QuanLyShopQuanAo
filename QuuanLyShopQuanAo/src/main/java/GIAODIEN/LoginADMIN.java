/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GIAODIEN;

import KHACHHANG.DanhSachKhachHang;
import NHANVIEN.DanhSachNhanVien;
import SANPHAM.DanhSachSanPham;
import javax.swing.JOptionPane;

/**
 *
 * @author Cam Tien
 */
public class LoginADMIN extends javax.swing.JFrame {

    private DanhSachNhanVien danhSachNhanVien;
    private DanhSachKhachHang danhSachKhachHang;
    private DanhSachSanPham danhSachSanPham;

    public LoginADMIN(DanhSachNhanVien danhSachNhanVien, DanhSachKhachHang danhSachKhachHang, DanhSachSanPham danhSachSanPham) {
        this.danhSachNhanVien = danhSachNhanVien;
        this.danhSachKhachHang = danhSachKhachHang;
        this.danhSachSanPham = danhSachSanPham;
         this.setLocationRelativeTo(null);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TAIKHOAN = new javax.swing.JLabel();
        MATKHAU = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jBtnDangNhapAdmin = new javax.swing.JButton();
        HUY = new javax.swing.JButton();
        DANGNHAP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TAIKHOAN.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        TAIKHOAN.setText("TÀI KHOẢN");

        MATKHAU.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        MATKHAU.setText("MẬT KHẨU");

        jBtnDangNhapAdmin.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jBtnDangNhapAdmin.setText("ĐĂNG NHẬP");
        jBtnDangNhapAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDangNhapAdminActionPerformed(evt);
            }
        });

        HUY.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        HUY.setText("HỦY");
        HUY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HUYActionPerformed(evt);
            }
        });

        DANGNHAP.setFont(new java.awt.Font("Corbel Light", 1, 18)); // NOI18N
        DANGNHAP.setText("ĐĂNG NHẬP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TAIKHOAN)
                            .addComponent(MATKHAU))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jPasswordField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(DANGNHAP)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jBtnDangNhapAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(HUY)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(DANGNHAP)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TAIKHOAN)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MATKHAU)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnDangNhapAdmin)
                    .addComponent(HUY))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HUYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HUYActionPerformed
        // Tạo một đối tượng của LuaChon

        this.dispose(); // Đóng cửa sổ hiện tại (LoginADMIN)
    }//GEN-LAST:event_HUYActionPerformed

    private void jBtnDangNhapAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDangNhapAdminActionPerformed
        String username = jTextField1.getText();
        String password = new String(jPasswordField1.getPassword());

        if (username.equals("admin") && password.equals("admin")) {
//             Correct login
            ADMIN admin = new ADMIN(danhSachNhanVien, danhSachKhachHang, danhSachSanPham);
            admin.setVisible(true);
            this.dispose(); // Close the login window
        } else {
            // Incorrect login
            JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnDangNhapAdminActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DanhSachNhanVien danhSachNhanVien = new DanhSachNhanVien();
                DanhSachKhachHang danhSachKhachHang = new DanhSachKhachHang();
                DanhSachSanPham danhSachSanPham = new DanhSachSanPham();

                new LoginADMIN(danhSachNhanVien, danhSachKhachHang, danhSachSanPham).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DANGNHAP;
    private javax.swing.JButton HUY;
    private javax.swing.JLabel MATKHAU;
    private javax.swing.JLabel TAIKHOAN;
    private javax.swing.JButton jBtnDangNhapAdmin;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
