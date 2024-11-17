import NHANVIEN.DanhSachNhanVien;
import KHACHHANG.DanhSachKhachHang;
import NHANVIEN.NhanVien;
import QUANLY.QuanLy;
import SANPHAM.DanhSachSanPham;
import KHACHHANG.KhachHang;
import DONHANG.DonHang;
import SANPHAM.SanPham;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLy quanLy = new QuanLy();
        DanhSachNhanVien danhSachNhanVien = new DanhSachNhanVien();
        DanhSachKhachHang danhSachKhachHang = new DanhSachKhachHang();
        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();

        int luaChonDangNhap = 0;
        do {
            System.out.println("***** CHÀO MỪNG ĐẾN VỚI HỆ THỐNG QUẢN LÝ CỬA HÀNG *****");
            System.out.println("1. Đăng nhập với quyền Admin");
            System.out.println("2. Đăng nhập với quyền Nhân viên");
            System.out.println("3. Truy cập quyền Khách hàng");
            System.out.println("4. Thoát");
            System.out.print("Chọn quyền truy cập: ");
            try {
                luaChonDangNhap = sc.nextInt();
                sc.nextLine();
                switch (luaChonDangNhap) {
                    case 1:
                        dangNhapAdmin(sc, quanLy, danhSachSanPham, danhSachNhanVien, danhSachKhachHang);
                        break;
                    case 2:
                        dangNhapNhanVien(sc, danhSachNhanVien, danhSachSanPham, danhSachKhachHang);
                        break;
                    case 3:
                        menuKhachHang(sc, danhSachKhachHang, danhSachSanPham);
                        break;
                    case 4:
                        System.out.println("Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi.");
                        break;
                    default:
                        System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập số để chọn quyền truy cập.");
                sc.nextLine();
            }
        } while (luaChonDangNhap != 4);
        sc.close();
    }

    // Đăng nhập Admin
    private static void dangNhapAdmin(Scanner sc, QuanLy quanLy, DanhSachSanPham danhSachSanPham,
                                      DanhSachNhanVien danhSachNhanVien, DanhSachKhachHang danhSachKhachHang) {
        System.out.print("Nhập tài khoản Admin: ");
        String username = sc.nextLine();
        System.out.print("Nhập mật khẩu Admin: ");
        String password = sc.nextLine();
        if (quanLy.dangNhapAdmin(username, password)) {
            System.out.println("Đăng nhập Admin thành công.");
            menuAdmin(sc, quanLy, danhSachSanPham, danhSachNhanVien, danhSachKhachHang);
        } else {
            System.out.println("Đăng nhập Admin thất bại.");
        }
    }

    // Menu Admin
    private static void menuAdmin(Scanner sc, QuanLy quanLy, DanhSachSanPham danhSachSanPham,
                                  DanhSachNhanVien danhSachNhanVien, DanhSachKhachHang danhSachKhachHang) {
        int luaChon;
        do {
            System.out.println("***** MENU QUẢN TRỊ VIÊN *****");
            System.out.println("1. Xem danh sách nhân viên");
            System.out.println("2. Đuổi việc nhân viên");
            System.out.println("3. Thống kê tiền trả lương cho nhân viên");
            System.out.println("4. Thống kê doanh thu từ khách hàng");
            System.out.println("5. Xem lịch sử mua hàng của khách hàng");
            System.out.println("6. Nhập thêm sản phẩm");
            System.out.println("7. Tuyển thêm nhân viên");
            System.out.println("8. Thống kê tiền nhập hàng");
            System.out.println("9. Tìm kiếm thông tin nhân viên theo mã");
            System.out.println("10. Thống kê số lượng nhân viên trong cửa hàng");
            System.out.println("11. Xem danh sách khách hàng");
            System.out.println("12. Đăng xuất");
            System.out.print("Chọn chức năng: ");
            try {
                luaChon = sc.nextInt();
                sc.nextLine();
                switch (luaChon) {
                    case 1:
                        danhSachNhanVien.hienThiThongTinNhanVien();
                        break;
                    case 2:
                        System.out.print("Nhập mã nhân viên cần đuổi việc: ");
                        String maNV = sc.nextLine();
                        danhSachNhanVien.XoaNhanVien(maNV);

                        break;
                    case 3:
                        danhSachNhanVien.tongTienTraNhanVien();
                        break;
                    case 4:
                        System.out.println("Tổng doanh thu: " + danhSachKhachHang.tongDoanhThu());
                        break;
                    case 5:
                        danhSachKhachHang.lichSuMuaHang();
                        break;
                    case 6:
                        danhSachSanPham.nhapDSSanPham();
                        break;
                    case 7:
                        danhSachNhanVien.ThemNhanVien();
                        break;
                    case 8:
                        danhSachSanPham.tongTienNhapSanPham();
                        break;
                    case 9:
                        System.out.print("Nhập mã nhân viên cần tìm: ");
                        String maNhanVien = sc.nextLine();
                        danhSachNhanVien.timNhanVien(maNhanVien);
                        break;
                    case 10:
                        danhSachNhanVien.thongKeSoLuongNhanVien();
                        break;
                    case 11:
                        danhSachKhachHang.xuatDanhSachKhachHang();
                        break;
                    case 12:
                        System.out.println("Đăng xuất thành công.");
                        return;
                    default:
                        System.out.println("Chức năng không hợp lệ.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập số.");
                sc.nextLine();
            }
        } while (true);
    }

    // Đăng nhập Nhân viên
    private static void dangNhapNhanVien(Scanner sc, DanhSachNhanVien danhSachNhanVien,
                                         DanhSachSanPham danhSachSanPham, DanhSachKhachHang danhSachKhachHang) {
        System.out.print("Nhập mã nhân viên: ");
        String maNV = sc.nextLine();
        System.out.print("Nhập họ tên: ");
        String hoTen = sc.nextLine();
        // Xác thực nhân viên
        NhanVien nhanVien = danhSachNhanVien.dangNhapNhanVien(maNV);
        if (nhanVien != null) {
            System.out.println("Đăng nhập thành công!");
            System.out.println("Chào mừng " + nhanVien.getHoTen());
            menuNhanVien(sc, danhSachSanPham, danhSachKhachHang); // Hiển thị menu cho nhân viên
        } else {
            System.out.println("Đăng nhập thất bại. Vui lòng kiểm tra lại mã nhân viên hoặc họ tên.");
        }
        // Thêm logic xác thực nhân viên ở đây
    }

    // Menu Nhân viên
    private static void menuNhanVien(Scanner sc, DanhSachSanPham danhSachSanPham, DanhSachKhachHang danhSachKhachHang) {
        int luaChon;
        do {
            System.out.println("***** MENU NHÂN VIÊN *****");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Xem danh sách khách hàng");
            System.out.println("3. Tạo đơn hàng mới");
            System.out.println("4. Đăng xuất");
            System.out.print("Chọn chức năng: ");
            try {
                luaChon = sc.nextInt();
                sc.nextLine();
                switch (luaChon) {
                    case 1:
                        danhSachSanPham.xuatDSSanPham();
                        break;
                    case 2:
                        danhSachKhachHang.xuatDanhSachKhachHang();
                        break;
                    case 3:
                        // Thêm logic tạo đơn hàng mới
                        break;
                    case 4:
                        System.out.println("Đăng xuất thành công.");
                        return;
                    default:
                        System.out.println("Chức năng không hợp lệ.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập số.");
                sc.nextLine();
            }
        } while (true);
    }

    // Menu Khách hàng
    private static void menuKhachHang(Scanner sc, DanhSachKhachHang danhSachKhachHang, DanhSachSanPham danhSachSanPham) {
        int luaChon;
        do {
            System.out.println("***** MENU KHÁCH HÀNG *****");
            System.out.println("1. Đăng ký tài khoản mới");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Xem danh sách sản phẩm");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            try {
                luaChon = sc.nextInt();
                sc.nextLine();
                switch (luaChon) {
                    case 1:
                        danhSachKhachHang.dangKiKhachHang();
                        break;
                    case 2:
                        System.out.print("Nhập CCCD: ");
                        String cccd = sc.nextLine();

                        KhachHang khachHang = danhSachKhachHang.dangNhapKhachHang(cccd);
                        if (khachHang != null) {
                            // Nếu đăng nhập thành công, hiển thị menu
                            menuKhachHangDaDangNhap(sc, khachHang, danhSachSanPham);
                        } else {
                            System.out.println("Đăng nhập không thành công. Khách hàng không tồn tại.");
                        }
                        break;
                    case 3:
                        danhSachSanPham.xuatDSSanPham();
                        break;
                    case 4:
                        System.out.println("Cảm ơn bạn đã sử dụng dịch vụ.");
                        return;
                    default:
                        System.out.println("Chức năng không hợp lệ.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập số.");
                sc.nextLine();
            }
        } while (true);
    }

    // Menu Khách hàng đã đăng nhập
    private static void menuKhachHangDaDangNhap(Scanner sc, KhachHang khachHang, DanhSachSanPham danhSachSanPham) {
        int luaChon;
        do {
            System.out.println("***** MENU KHÁCH HÀNG ĐÃ ĐĂNG NHẬP *****");
            System.out.println("1. Xem thông tin cá nhân");
            System.out.println("2. Xem lịch sử mua hàng");
            System.out.println("3. Mua hàng");
            System.out.println("4. Đăng xuất");
            System.out.print("Chọn chức năng: ");
            try {
                luaChon = sc.nextInt();
                sc.nextLine();
                switch (luaChon) {
                    case 1:
                        khachHang.inThongTin();
                        break;
                    case 2:
                        khachHang.hienThiLichSuMuaHang();
                        break;
                    case 3:
                        KhachHang khachHang1 = new KhachHang();
                        khachHang1.muaHang(danhSachSanPham);
                        // Thêm logic mua hàng ở đây
                        break;
                    case 4:
                        System.out.println("Đăng xuất thành công.");
                        return;
                    default:
                        System.out.println("Chức năng không hợp lệ.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập số.");
                sc.nextLine();
            }
        } while (true);
    }
}