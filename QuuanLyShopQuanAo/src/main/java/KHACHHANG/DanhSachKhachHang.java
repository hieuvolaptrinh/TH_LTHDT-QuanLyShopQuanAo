package KHACHHANG;

import DONHANG.DonHang;

import java.util.HashMap;

public class DanhSachKhachHang {
    private HashMap<String, KhachHang> danhSachKhachHang;

    public DanhSachKhachHang() {
        this.danhSachKhachHang = new HashMap<>();
    }

    public HashMap<String, KhachHang> getDanhSachKhachHang() {
        return danhSachKhachHang;
    }

    public void setDanhSachKhachHang(HashMap<String, KhachHang> danhSachKhachHang) {
        this.danhSachKhachHang = danhSachKhachHang;
    }

    //    thêm khách hàng
    public void dangKiKhachHang() {
        KhachHang khachHang = new KhachHang();
        khachHang.nhapThongTin();
        System.out.println("Bạn đã đăng kí thành công");
    }
//    đăng nhập khách hàng
    public KhachHang dangNhapKhachHang(String CCCD, String matKhau) {
        if(!danhSachKhachHang.containsKey(CCCD)) {
            System.out.println("Không tìm thấy khách hàng");
            return null;
        }
        KhachHang khachHang= danhSachKhachHang.get(CCCD);
        if (!khachHang.getMatKhau().equals(matKhau)) {
            System.out.println("Sai mật khẩu");
            return null;
        }
        return khachHang;
    }
//    xem thông tin khách hàng
    public void xemThongTinKhachHang() {
        for (KhachHang khachHang : danhSachKhachHang.values()) {
            khachHang.inThongTin();
        }
    }
//    tính doanh thu
    public double tongDoanhThu() {
        double doanhThu = 0;
        for (KhachHang khachHang : danhSachKhachHang.values()) {
            for (DonHang donHang: khachHang.getLichSuMuaHang()) {
                doanhThu += donHang.thanhTien();
            }
        }
        return doanhThu;
    }
//    lịch sử bản hàng
    public void lichSuMuaHang() {
        for (KhachHang khachHang : danhSachKhachHang.values()) {
            khachHang.hienThiLichSuMuaHang();
        }
    }
//    xuat danh sach khach hang
    public void xuatDanhSachKhachHang() {
        for (KhachHang khachHang : danhSachKhachHang.values()) {
            khachHang.inThongTin();
        }
    }
}
