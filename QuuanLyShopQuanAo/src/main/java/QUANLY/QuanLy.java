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
        int chon = 0;
        do {
            System.out.println("1. Thống kê  nhân viên bán thời gian");
            System.out.println("2. Thống kê  nhân viên toàn thời gian");
            System.out.println("3. Thống kê  nhân viên");
            System.out.println("4. Thoát");
            System.out.println("Chọn: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    danhSachNhanVien.hienThiThongTinNhanVienBanThoiGian();
                    break;
                case 2:
                    danhSachNhanVien.hienThiThongTinNhanVienToanThoiGian();
                    break;
                case 3:
                    danhSachNhanVien.hienThiThongTinNhanVien();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Nhập sai, vui lòng nhập lại");
                    break;
            }

        } while (chon != 4);
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

    public void themNhanVienToanThoiGianFromFile(DanhSachNhanVien danhSachNhanVien) {
        danhSachNhanVien.docFileVaThemNhanVienToanThoiGian();
    }

    public void themNhanVienBanThoiGianFromFile(DanhSachNhanVien danhSachNhanVien) {
        danhSachNhanVien.docFileVaThemNhanVienBanThoiGian();
    }

    public void themSanPhamFromFile(DanhSachSanPham danhSachSanPham) {
        danhSachSanPham.docFileVaThemSanPham();
    }

    //    tiền trả lương cho nhân viên
    public void tienTraLuongNhanVien(DanhSachNhanVien dsNhanVien) {
        dsNhanVien.tongTienTraNhanVienBanThoiGian();
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
        System.out.println("Tổng doanh thu: " + String.format("%,.0f", danhSachKhachHang.tongDoanhThu()));

    }
    public void thongKeLoiNhuan(DanhSachSanPham danhSachSanPham, DanhSachKhachHang danhSachKhachHang){
        System.out.println("Tổng tiền nhập hàng: " + String.format("%,.0f", danhSachSanPham.tongTienNhap()));
        System.out.println("Tổng doanh thu: " + String.format("%,.0f", danhSachKhachHang.tongDoanhThu()));
        System.out.println("Tổng lợi nhuận: " + String.format("%,.0f", danhSachKhachHang.tongDoanhThu() - danhSachSanPham.tongTienNhap()));
    }

    //    xem lịch sử mua hàng
    public void xemLichSuMuaHang(DanhSachKhachHang danhSachKhachHang) {
        danhSachKhachHang.lichSuMuaHang();
    }

    //    xuất danh sách khách hàng
    public void xuatDanhSachKhachHang(DanhSachKhachHang danhSachKhachHang) {
        danhSachKhachHang.xuatDanhSachKhachHang();
    }

    //    xuất danh sách sản phẩm trong kho
    public void xuatDanhSachSanPham(DanhSachSanPham dsSanPham) {
        dsSanPham.xuatDSSanPham();
    }

}
