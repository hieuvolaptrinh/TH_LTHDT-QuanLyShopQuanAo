/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GIAODIEN.admin;

import KHACHHANG.DanhSachKhachHang;
import NHANVIEN.DanhSachNhanVien;
import NHANVIEN.NhanVien;
import SANPHAM.DanhSachSanPham;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hieuvo
 */
public class PageDSNV extends javax.swing.JPanel {

    private DanhSachNhanVien dsnv;
    private DanhSachKhachHang danhSachKhachHang;
    private DanhSachSanPham danhSachSanPham;

    public PageDSNV() {
        initComponents();
    }

    public PageDSNV(DanhSachNhanVien dsnv, DanhSachKhachHang dskh, DanhSachSanPham dssp) {
        this.dsnv = dsnv;
        this.danhSachKhachHang = dskh;
        this.danhSachSanPham = dssp;
        initComponents();
        capNhatNV();
    }

    private void capNhatNV() {
        DefaultTableModel model = (DefaultTableModel) BangNhanVien.getModel();
        model.setRowCount(0);
        for (NhanVien nv : dsnv.getDanhSachNhanVien().values()) {
            model.addRow(new Object[]{
                nv.getMaNhanVien(),
                nv.getHoTen(),
                nv.getCCCD(),
                nv.getSoDienThoai(),
                nv.getGioiTinh(),
                nv.getNgaySinh(),
                nv.getEmail(),
                nv.getDiaChi()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BangNhanVien = new javax.swing.JTable();
        TextDSNV = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(51, 255, 153));

        BangNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        BangNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Loại nhân viên", "Mã nhân viên ", "Tên nhân viên ", "CCCD", "SĐT", "Giới tính", "Ngày sinh", "Email", "Địa chỉ"
            }
        ));
        BangNhanVien.setToolTipText("");
        jScrollPane1.setViewportView(BangNhanVien);

        TextDSNV.setBackground(new java.awt.Color(255, 228, 231));
        TextDSNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TextDSNV.setForeground(new java.awt.Color(0, 153, 153));
        TextDSNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextDSNV.setText("Danh Sách Nhân Viên");
        TextDSNV.setBorder(null);
        TextDSNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDSNVActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jButton1.setText("Đuổi việc nhân viên");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextDSNV)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1161, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(TextDSNV, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TextDSNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDSNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDSNVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = BangNhanVien.getSelectedRow();
        if (selectedRow != -1) {
            String maNV = (String) BangNhanVien.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this,
                    "bạn chắc chắn muốn đuổi việc em nó?",
                    "Xác Nhận",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dsnv.getDanhSachNhanVien().remove(maNV);
                capNhatNV();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Cần cọn nhân viên để xóa");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BangNhanVien;
    private javax.swing.JTextField TextDSNV;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
