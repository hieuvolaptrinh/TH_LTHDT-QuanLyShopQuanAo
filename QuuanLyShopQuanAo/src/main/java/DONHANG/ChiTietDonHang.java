package DONHANG;

import SANPHAM.SanPham;

public class ChiTietDonHang {
    private SanPham sanPham;
    private int soLuong;
    private double giaBan;

    public ChiTietDonHang(SanPham sanPham, int soLuong, double giaBan) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public double tinhTongTien() {
        return soLuong * giaBan;
    }

}
