package SANPHAM;

import java.util.Scanner;

public class PhuKien extends SanPham{
    private String loaiPhuKien;

    public PhuKien(String maSanPham, String tenSanPham, double giaNhap, String ngaySanXuat, int soLuong, String chatLieu, String moTa, boolean trangThai, String mauSac, String loaiPhuKien) {
        super(maSanPham, tenSanPham, giaNhap, ngaySanXuat, soLuong, chatLieu, moTa, trangThai, mauSac);
        this.loaiPhuKien = loaiPhuKien;
    }

    public String getLoaiPhuKien() {
        return loaiPhuKien;
    }

    public void setLoaiPhuKien(String loaiPhuKien) {
        this.loaiPhuKien = loaiPhuKien;
    }

    @Override
    public void nhapTTSP() {
        super.nhapTTSP();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập loại phụ kiện: ");
        this.loaiPhuKien = sc.nextLine();
    }

    @Override
    public void xuatTTSP() {
        super.xuatTTSP();
        System.out.println("Loại phụ kiện: "+this.loaiPhuKien);
    }
}
