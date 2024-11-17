package DONHANG;

import SANPHAM.SanPham;

import java.util.Scanner;

public class ChiTietDonHang {
    private SanPham sanPham;
    private int soLuong;
    private double giaBan;

    public ChiTietDonHang(SanPham sanPham, int soLuong, double giaBan) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double tinhTongTien() {
        return soLuong * giaBan;
    }

    public void nhapThongTin(SanPham sanPham) {
        Scanner sc = new Scanner(System.in);
        this.sanPham = sanPham; // Liên kết với sản phẩm đã nhập

        System.out.print("Nhập số lượng sản phẩm: ");
        this.soLuong = sc.nextInt();
        while (this.soLuong <= 0) {
            System.out.println("Số lượng phải lớn hơn 0. Vui lòng nhập lại:");
            this.soLuong = sc.nextInt();
        }

        System.out.print("Nhập giá bán mỗi sản phẩm: ");
        this.giaBan = sc.nextDouble();
        while (this.giaBan <= 0) {
            System.out.println("Giá bán phải lớn hơn 0. Vui lòng nhập lại:");
            this.giaBan = sc.nextDouble();
        }
    }

    public void xuatThongTin() {
        System.out.println("Thông tin chi tiết đơn hàng:");
        if (sanPham != null) {
            sanPham.xuatTTSP(); // Xuất thông tin sản phẩm
        }
        System.out.println("Số lượng: " +soLuong);
        System.out.println("Giá bán: " +giaBan);
        System.out.println("Tổng tiền: " +tinhTongTien());
    }

}
