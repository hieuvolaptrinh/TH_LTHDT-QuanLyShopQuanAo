package SANPHAM;

import java.util.Date;
import java.util.Scanner;

public class GiayDep extends SanPham {

    private String loaiGiayDep;
    private int sizeGD;

    public GiayDep(String maSanPham, String tenSanPham, double giaNhap,double giaBan, Date ngaySanXuat, int soLuong, String chatLieu, String moTa, boolean trangThai, String mauSac, String loaiGiayDep, int sizeGD) {
        super(maSanPham, tenSanPham, giaNhap,giaBan, ngaySanXuat, soLuong, chatLieu, moTa, trangThai, mauSac);
        this.loaiGiayDep = loaiGiayDep;
        this.sizeGD = sizeGD;
    }
    public GiayDep() {

    }

    @Override
    public void nhapTTSP() {
        super.nhapTTSP();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập loại giày dép: ");
        this.loaiGiayDep = sc.nextLine();
        System.out.print("Nhập size: ");
        this.sizeGD = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public void xuatTTSP() {
        super.xuatTTSP();
        System.out.println("Loại giày dép: "+this.loaiGiayDep);
        System.out.println("Size: "+this.sizeGD);
    }
}
