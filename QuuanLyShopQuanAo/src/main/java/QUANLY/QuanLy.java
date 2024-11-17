package QUANLY;

import KHACHHANG.DanhSachKhachHang;
import NHANVIEN.DanhSachNhanVien;
import SANPHAM.DanhSachSanPham;

import java.util.Scanner;

public class QuanLy {
    Scanner sc = new Scanner(System.in);
    String userName;
    String passWord;

    public QuanLy(String passWord, String userName) {
        this.passWord = passWord;
        this.userName = userName;
    }

    public QuanLy() {
        this.passWord = "admin";
        this.userName = "admin";
    }

    //đăng nhập quyền admin
    public boolean dangNhapAdmin(String username, String password) {
        return this.userName.equals(username) && this.passWord.equals(password);
    }

    //
    public void duoiViec(DanhSachNhanVien danhSachNhanVien) {
        System.out.println("nhập mã nhân viên cần đuổi việc: ");
        String maNhanVien = sc.nextLine();
        danhSachNhanVien.XoaNhanVien(maNhanVien);
    }

    //    xem danh sách nhân viên
    public void xemDanhSachNhanVien(DanhSachNhanVien danhSachNhanVien) {
        danhSachNhanVien.hienThiThongTinNhanVien();
    }

    //    thống kê số lượng nhân viên trong cửa hàng
    public void thongKeSoLuongNhanVien(DanhSachNhanVien danhSachNhanVien) {
        danhSachNhanVien.thongKeSoLuongNhanVien();
    }

    //tìm nhân viên them mã
    public void timNhanVien(DanhSachNhanVien danhSachNhanVien) {
        System.out.println("nhập mã nhân viên cần tìm: ");
        String maNhanVien = sc.nextLine();
        danhSachNhanVien.timNhanVien(maNhanVien);
    }

    //    thêm nhân viên
    public void themNhanVien(DanhSachNhanVien danhSachNhanVien) {
        danhSachNhanVien.ThemNhanVien();
    }

    //    tiền trả lương cho nhân viên
    public void tienTraLuongNhanVien(DanhSachNhanVien dsNhanVien) {
        System.out.println("Tổng tiền trả cho nhân viên bán thời gian: ");
        dsNhanVien.tongTienTraNhanVienBanThoiGian();
        System.out.println("Tổng tiền trả cho nhân viên chính thức: ");
        dsNhanVien.tongTienTraNhanVienChinhThuc();
        dsNhanVien.tongTienTraNhanVien();

    }

    public void nhapSanPhamMoi(DanhSachSanPham dsSanPham) {
        dsSanPham.nhapDSSanPham();
    }

    //    thống kê tiền nhập hàng
    public void thongKeTienNhapHang(DanhSachSanPham dsSanPham) {
        dsSanPham.tongTienNhapSanPham();
    }
//    thống kê doanh thu
    public void thongKeDoanhThu(DanhSachKhachHang danhSachKhachHang) {
        System.out.println("Tổng doanh thu: " + danhSachKhachHang.tongDoanhThu());

    }
//    xem lịch sử mua hàng
    public void xemLichSuMuaHang(DanhSachKhachHang danhSachKhachHang) {
        danhSachKhachHang.lichSuMuaHang();
    }
}
