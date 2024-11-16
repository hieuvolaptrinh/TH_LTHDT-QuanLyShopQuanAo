package SANPHAM;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SanPham {

    protected String maSanPham;
    protected String tenSanPham;
    protected double giaNhap;
    protected Date ngaySanXuat;
    protected int soLuong;
    protected String chatLieu;
    NhaCungCap nhaCungCap;
    protected String moTa;
    protected boolean trangThai;
    protected String mauSac;
    protected static final double giamGia = 0;

    public SanPham(String maSanPham, String tenSanPham, double giaNhap, Date ngaySanXuat, int soLuong, String chatLieu, String moTa, boolean trangThai, String mauSac) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaNhap = giaNhap;
        this.ngaySanXuat = ngaySanXuat;
        this.soLuong = soLuong;
        this.chatLieu = chatLieu;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.mauSac = mauSac;
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

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public void nhapTTSP(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm: ");
        this.maSanPham = sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        this.tenSanPham = sc.nextLine();
        System.out.print("Nhập giá tiền: ");
        this.giaNhap = sc.nextDouble();
        System.out.println("Nhập ngày sản xuất (dd/mm/yyyy): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.ngaySanXuat = dateFormat.parse(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Ngày sản xuất không hợp lệ. Đặt ngày sản xuất là ngày hiện tại.");
            this.ngaySanXuat = new Date();
        }
        System.out.print("Nhập số lượng: ");
        this.soLuong = sc.nextInt();
        if (this.soLuong < 0) {
            System.out.println("Số lượng không thể là giá trị âm. Đặt lại số lượng là 0.");
            this.soLuong = 0;
        }
        System.out.print("Nhập chất liệu: ");
        this.chatLieu = sc.nextLine();
        System.out.print("Nhập màu sắc: ");
        this.mauSac = sc.nextLine();
        System.out.print("Nhập mô tả: ");
        this.moTa = sc.nextLine();
        System.out.println("Nhập thông tin nhà cung cấp: ");
        System.out.print("Quốc gia: ");
        String quocGia = sc.nextLine();
        System.out.print("Tên công ty: ");
        String tenCongTy = sc.nextLine();
        System.out.print("Địa chỉ: ");
        String diaChi = sc.nextLine();

        this.nhaCungCap = new NhaCungCap(quocGia, tenCongTy, diaChi);
    }
    public void xuatTTSP(){
        System.out.println("Mã sản phẩm là: "+this.maSanPham);
        System.out.println("Tên sản phẩm là: "+this.tenSanPham);
        System.out.println("Giá bán cua sản phẩm là: "+this.giaNhap);
        System.out.println("Ngày sản xuất: "+this.ngaySanXuat);
        System.out.println("Số luọng: "+this.soLuong);
        System.out.println("Chất liệu: "+this.chatLieu);
        System.out.println("Màu sắc: "+this.mauSac);
        System.out.println("MoTa: "+this.moTa);
        System.out.println("Trạng thái: "+((this.soLuong > 0) ? "Còn hàng" : "Hết hàng"));
        if (this.nhaCungCap != null) {
            System.out.println("Thông tin nhà cung cấp:");
            System.out.println("  Quốc gia: " + this.nhaCungCap.getQuocGia());
            System.out.println("  Tên công ty: " + this.nhaCungCap.getTenCongTy());
            System.out.println("  Địa chỉ: " + this.nhaCungCap.getDiaChi());
        } else {
            System.out.println("Không có thông tin nhà cung cấp.");
        }
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

}
