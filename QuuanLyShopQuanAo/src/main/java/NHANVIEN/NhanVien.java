package NHANVIEN;

import NGUOI.Nguoi;

public abstract class NhanVien extends Nguoi {
    private String chucVu;
    private double luong;

    public NhanVien(String maNguoi, String hoTen, String soDienThoai,String email, String diaChi, String chucVu, double luong) {
        super(maNguoi, hoTen, soDienThoai,email, diaChi);
        this.chucVu = chucVu;
        this.luong = luong;
    }
    public String getChucVu() {
        return chucVu;
    }

    public double getLuong() {
        return luong;
    }
}
