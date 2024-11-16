package SANPHAM;

import java.util.Scanner;

public class QuanAo extends SanPham {
    private String loaiQuanAo;
    private String size;
    private String mauSac;
    private String chatLieu;
    private String thuongHieu;
    private String gioiTinh;
    private String kieuDang;
    private String xuatXu;

    public QuanAo(String maSanPham, String tenSanPham, double giaBan, int soLuong, String moTa, boolean trangThai, double giamGia, String loaiQuanAo, String size, String mauSac, String chatLieu, String thuongHieu, String gioiTinh, String kieuDang, String xuatXu) {
        super(maSanPham, tenSanPham, giaBan, soLuong, moTa, trangThai, giamGia);
        this.loaiQuanAo = loaiQuanAo;
        this.size = size;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.thuongHieu = thuongHieu;
        this.gioiTinh = gioiTinh;
        this.kieuDang = kieuDang;
        this.xuatXu = xuatXu;
    }

    public String getLoaiQuanAo() {
        return loaiQuanAo;
    }

    public void setLoaiQuanAo(String loaiQuanAo) {
        this.loaiQuanAo = loaiQuanAo;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
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

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập loại quần áo: ");
        this.loaiQuanAo = sc.nextLine();
        System.out.println("Nhập size: ");
        this.size = sc.nextLine();
        System.out.println("Nhập màu sắc của quần áo: ");
        this.mauSac = sc.nextLine();
        System.out.println("Nhập chất liệu của quần ảo: ");
        this.chatLieu = sc.nextLine();
        System.out.println("Nhập thương hiệu của quần áo: ");
        this.thuongHieu = sc.nextLine();
        System.out.println("Quần áo dành cho (Nam/Nữ): ");
        this.gioiTinh = sc.nextLine();
        System.out.println("Kiểu dáng: ");
        this.kieuDang = sc.nextLine();
        System.out.println("Xuat su: ");
        this.xuatXu = sc.nextLine();
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Loại quần ao: "+this.loaiQuanAo);
        System.out.println("Size: "+this.size);
        System.out.println("Màu săc: "+this.mauSac);
        System.out.println("Chat Lieu: "+this.chatLieu);
        System.out.println("Thuong Hieu: "+this.thuongHieu);
        System.out.println("Quần áo dành cho: "+this.gioiTinh);
        System.out.println("Kiểu dáng: "+this.kieuDang);
        System.out.println("Xuat su: "+this.xuatXu);
    }
}

