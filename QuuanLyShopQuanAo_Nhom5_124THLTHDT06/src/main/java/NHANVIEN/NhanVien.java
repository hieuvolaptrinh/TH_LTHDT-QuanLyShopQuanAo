package NHANVIEN;

import NGUOI.Nguoi;

import java.util.Date;
import java.util.Scanner;

public abstract class NhanVien extends Nguoi {
    Scanner sc = new Scanner(System.in);
    protected String maNhanVien;

// Constructor


    public NhanVien(String CCCD, String hoTen, String soDienThoai, String gioiTinh, Date ngaySinh, String email, String diaChi, String maNhanVien) {
        super(CCCD, hoTen, soDienThoai, gioiTinh, ngaySinh, email, diaChi);
        this.maNhanVien = maNhanVien;
    }

    public NhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public NhanVien() {

    }


//Getter and Setter

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }


    //Các phương thức
    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.println("Nhập mã nhân viên : ");
        this.maNhanVien = sc.nextLine();

    }

    @Override
    public void inThongTin() {
        System.out.println("Mã nhân viên : "+this.maNhanVien);
        super.inThongTin();

    }
    public abstract double TienPhat();
    public abstract double LuongTangCa();
    public abstract double TongLuong();
}
