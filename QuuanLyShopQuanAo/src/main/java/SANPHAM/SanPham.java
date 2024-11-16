package SANPHAM;

import java.util.Scanner;

public class SanPham {

    protected String maSanPham;
    protected String tenSanPham;
    protected double giaBan;
    protected int soLuong;
    protected String moTa;
    protected boolean trangThai;
    protected double giamGia;

    public SanPham(String maSanPham, String tenSanPham, double giaBan, int soLuong, String moTa, boolean trangThai, double giamGia) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.giamGia = giamGia;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }
    public void nhapThongTin(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm: ");
        this.maSanPham = sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        this.tenSanPham = sc.nextLine();
        System.out.print("Nhập giá tiền bán: ");
        this.giaBan = sc.nextDouble();
        System.out.print("Nhập số lượng: ");
        this.soLuong = sc.nextInt();
        if (this.soLuong < 0) {
            System.out.println("Số lượng không thể là giá trị âm. Đặt lại số lượng là 0.");
            this.soLuong = 0;
        }
        System.out.print("Nhập mức giảm giá(%): ");
        this.giamGia = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập mô tả: ");
        this.moTa = sc.nextLine();
    }
    public void xuatThongTin(){
        System.out.println("Mã sản phẩm là: "+this.maSanPham);
        System.out.println("Tên sản phẩm là: "+this.tenSanPham);
        System.out.println("Giá bán cua sản phẩm là: "+this.giaSauKhiGiam());
        System.out.println("Số luọng: "+this.soLuong);
        System.out.println("Giảm giá: "+this.giamGia+"%");
        System.out.println("MoTa: "+this.moTa);
        System.out.println("Trạng thái: "+((this.soLuong > 0) ? "Còn hàng" : "Hết hàng"));
    }
    public double capNhatSoLuong(int soLuongCapNhat){
        this.soLuong = soLuongCapNhat + soLuong;
        System.out.println("Số lượng sau khi cập nhật là: "+this.soLuong);
        capNhatTrangThai();
        return soLuong;
    }
    public void capNhatTrangThai(){
        this.trangThai = soLuong > 0;
        System.out.println("Trạng thái sau khi cập nhật số lượng: "+(this.trangThai ? "Còn hàng" : "Hết hàng"));
    }
    public double giaSauKhiGiam(){
        return giaBan - (giaBan * giamGia / 100);
    }

}
