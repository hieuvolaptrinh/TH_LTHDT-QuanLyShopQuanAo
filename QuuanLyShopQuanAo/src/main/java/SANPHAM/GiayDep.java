package SANPHAM;

import java.util.Scanner;

public class GiayDep extends SanPham {

    private String loaiGiayDep;
    private int size;
    private String mauSac;
    private String thuongHieu;
    private String chatLieu;
    private String xuatXu;

    public GiayDep(String maSanPham, String tenSanPham, double giaBan, int soLuong, String moTa, boolean trangThai, double giamGia, String loaiGiayDep, int size, String mauSac, String thuongHieu, String chatLieu, String xuatXu) {
        super(maSanPham, tenSanPham, giaBan, soLuong, moTa, trangThai, giamGia);
        this.loaiGiayDep = loaiGiayDep;
        this.size = size;
        this.mauSac = mauSac;
        this.thuongHieu = thuongHieu;
        this.chatLieu = chatLieu;
        this.xuatXu = xuatXu;
    }

    public GiayDep(String maSanPham, String tenSanPham, double giaBan, int soLuong, String moTa, boolean trangThai, double giamGia) {
        super(maSanPham, tenSanPham, giaBan, soLuong, moTa, trangThai, giamGia);
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập loại giày dép: ");
        this.loaiGiayDep = sc.nextLine();
        System.out.print("Nhập size: ");
        this.size = sc.nextInt();
        System.out.print("Nhập màu sắc: ");
        this.mauSac = sc.nextLine();
        System.out.print("Nhập thương hiệu: ");
        this.thuongHieu = sc.nextLine();
        System.out.print("Nhập chất liệu của giày dép: ");
        this.chatLieu = sc.nextLine();
        System.out.print("Nhập xuất sứ của sản phẩm: ");
        this.xuatXu = sc.nextLine();
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Loại giày dép: "+this.loaiGiayDep);
        System.out.println("Size: "+this.size);
        System.out.println("Màu sắc: "+this.mauSac);
        System.out.println("Thương hiệu: "+this.thuongHieu);
        System.out.println("Chất liệu: "+this.chatLieu);
        System.out.println("Xuất sứ: "+this.xuatXu);
    }
}
