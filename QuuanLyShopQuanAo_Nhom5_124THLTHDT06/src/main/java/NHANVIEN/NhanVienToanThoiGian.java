package NHANVIEN;

import CHECKTHONGTIN.CheckThongTin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class NhanVienToanThoiGian extends NhanVien {
    private final static double luongCoBan = 1500000;
    private final static double phuCap = 200000;
    private double heSoLuong;
    private final static double baoHiem = 250000;
    private int soCaTangCa;
    private int soNgayNghi;
    private Date ngayVaoLamViec;

    // Constructor


    public NhanVienToanThoiGian(String CCCD, String hoTen, String soDienThoai, String gioiTinh, Date ngaySinh, String email, String diaChi, String maNhanVien, double heSoLuong, int soCaTangCa, int soNgayNghi, Date ngayVaoLamViec) {
        super(CCCD, hoTen, soDienThoai, gioiTinh, ngaySinh, email, diaChi, maNhanVien);
        this.heSoLuong = heSoLuong;
        this.soCaTangCa = soCaTangCa;
        this.soNgayNghi = soNgayNghi;
        this.ngayVaoLamViec = ngayVaoLamViec;
    }

    public NhanVienToanThoiGian(String CCCD, String hoTen, String soDienThoai, String gioiTinh, Date ngaySinh, String email, String diaChi, String maNhanVien) {
        super(CCCD, hoTen, soDienThoai, gioiTinh, ngaySinh, email, diaChi, maNhanVien);
    }

    public NhanVienToanThoiGian(String CCCD, String hoTen, String soDienThoai, String gioiTinh, Date ngaySinh, String email, String diaChi, String maNhanVien, Date ngayVaoLamViec, double heSoLuong) {
        super(CCCD, hoTen, soDienThoai, gioiTinh, ngaySinh, email, diaChi, maNhanVien);
        this.ngayVaoLamViec = ngayVaoLamViec;
        this.heSoLuong = heSoLuong;
    }

    public NhanVienToanThoiGian() {
        this.soCaTangCa = 0;
        this.soNgayNghi = 0;
    }

    // Getter and Setter

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double getBaoHiem() {
        return baoHiem;
    }

    public int getSoCaTangCa() {
        return soCaTangCa;
    }

    public void setSoCaTangCa(int soCaTangCa) {
        this.soCaTangCa = soCaTangCa;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public Date getNgayVaoLamViec() {
        return ngayVaoLamViec;
    }

    public void setNgayVaoLamViec(Date ngayVaoLamViec) {
        this.ngayVaoLamViec = ngayVaoLamViec;
    }

    // Các phương thức
    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        // Nhập ngày vào làm việc
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Kiểm tra chặt chẽ định dạng ngày
        while (true) {
            try {
                System.out.println("Nhập bắt đầu làm việc (dd/MM/yyyy):");
                String inputngayVaoLamViec = sc.nextLine();
                this.ngayVaoLamViec = dateFormat.parse(inputngayVaoLamViec);
                break; // Thoát vòng lặp nếu nhập đúng
            } catch (ParseException e) {
                System.out.println("Ngày làm việc không hợp lệ. Vui lòng nhập lại!");
            }
        }
        System.out.println("Nhập hệ số lương :");
        this.heSoLuong = sc.nextDouble();

    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Tiền bảo hiểm : " + String.format("%,.0f", this.baoHiem));
        System.out.println("Phụ cấp : " + String.format("%,.0f", TinhPhuCap()));
        System.out.println("Tiền tăng ca : " + String.format("%,.0f", this.soCaTangCa));
        System.out.println("Tổng lương : " + String.format("%,.0f", TongLuong()));
    }

    public double TinhPhuCap() {
        return (LocalDate.now().getYear() - getNgayVaoLamViec().getYear()) * phuCap;
    }

    @Override
    public double TienPhat() {
        return this.soNgayNghi * 450000;
    }

    @Override
    public double LuongTangCa() {
        return this.soCaTangCa * 200000;
    }

    @Override
    public double TongLuong() {
        return this.heSoLuong * luongCoBan + TinhPhuCap() + LuongTangCa() - this.baoHiem - TienPhat();
    }

    // đăng kí tăng ca
    public void DangKiTangCa() {
        System.out.println("bạn có muốn đăng kí tăng ca không? (Có/Không)");
        int luaChon = 0;
        do {
            System.out.println("1. Có");
            System.out.println("2. Không");
            System.out.print("Chọn: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.println("Nhập số ca tăng ca :");
                    int soCaTangCa = sc.nextInt();
                    this.soCaTangCa += soCaTangCa;
                    break;
                case 2:
                    System.out.println("Không đăng kí tăng ca.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (luaChon < 1 || luaChon > 2);
    }

}
