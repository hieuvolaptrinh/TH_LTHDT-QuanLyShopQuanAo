package SANPHAM;

import java.util.Date;
import java.util.Scanner;

public class QuanAo extends SanPham {
    private String sizeQA;
    private String gioiTinh;
    private String kieuDang;

    public QuanAo(String maSanPham, String tenSanPham, double giaNhap, Date ngaySanXuat, int soLuong, String chatLieu, String moTa, boolean trangThai, String mauSac, String sizeQA, String gioiTinh, String kieuDang) {
        super(maSanPham, tenSanPham, giaNhap, ngaySanXuat, soLuong, chatLieu, moTa, trangThai, mauSac);
        this.sizeQA = sizeQA;
        this.gioiTinh = gioiTinh;
        this.kieuDang = kieuDang;
    }

    public String getSizeQA() {
        return sizeQA;
    }

    public void setSizeQA(String sizeQA) {
        this.sizeQA = sizeQA;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    @Override
    public void nhapTTSP() {
        super.nhapTTSP();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập size: ");
        this.sizeQA = sc.nextLine();
        System.out.println("Quần áo dành cho (Nam/Nữ): ");
        this.gioiTinh = sc.nextLine();
        System.out.println("Kiểu dáng: ");
        this.kieuDang = sc.nextLine();
    }

    @Override
    public void xuatTTSP() {
        super.xuatTTSP();
        System.out.println("Size: "+this.sizeQA);
        System.out.println("Quần áo dành cho: "+this.gioiTinh);
        System.out.println("Kiểu dáng: "+this.kieuDang);
    }
}

