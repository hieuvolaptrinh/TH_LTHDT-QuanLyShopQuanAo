package DONHANG;

import KHACHHANG.KhachHang;
import NHANVIEN.NhanVienBanThoigian;
import NHANVIEN.NhanVienChinhThuc;

import java.util.List;

public class DonHang {
    private String maDonHang;
    private String ngayDat;
    private KhachHang khachHang;
    private NhanVienBanThoigian nhanVienBanThoigian;
    private NhanVienChinhThuc quanLy;
    private List<ChiTietDonHang> danhSachChiTiet;

    public DonHang(String maDonHang, String ngayDat, KhachHang khachHang, NhanVienBanThoigian nhanVienBanThoigian) {
        this.maDonHang = maDonHang;
        this.ngayDat = ngayDat;
        this.khachHang = khachHang;
        this.nhanVienBanThoigian = nhanVienBanThoigian;
    }

    public void setQuanLy(NhanVienChinhThuc quanLy) {
        this.quanLy = quanLy;
    }

    public void themChiTiet(ChiTietDonHang chiTiet) {
        danhSachChiTiet.add(chiTiet);
    }

}
