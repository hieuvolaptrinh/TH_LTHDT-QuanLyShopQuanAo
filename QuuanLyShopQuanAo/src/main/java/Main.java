
import NHANVIEN.DanhSachNhanVien;
import KHACHHANG.DanhSachKhachHang;
import NHANVIEN.NhanVien;
import NHANVIEN.NhanVienBanThoigian;
import NHANVIEN.NhanVienToanThoiGian;
import QUANLY.QuanLy;
import SANPHAM.DanhSachSanPham;
import KHACHHANG.KhachHang;
import DONHANG.DonHang;
import GIAODIEN.LoginADMIN;

import SANPHAM.SanPham;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // Các mã ANSI escape code cho màu sắc
    public static final String RESET = "\u001B[0m";  // Reset màu
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLy quanLy = new QuanLy();
        DanhSachNhanVien danhSachNhanVien = new DanhSachNhanVien();
        DanhSachKhachHang danhSachKhachHang = new DanhSachKhachHang();
        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
        LoginADMIN loginAdmin = new LoginADMIN(danhSachNhanVien, danhSachKhachHang, danhSachSanPham);

        int luaChonDangNhap = 0;
        do {
            System.out.println(PURPLE + "***** CHÀO MỪNG ĐẾN VỚI HỆ THỐNG QUẢN LÝ CỬA HÀNG *****" + RESET);
            System.out.println(GREEN + "1. Đăng nhập với quyền Admin");
            System.out.println("2. Đăng nhập với quyền Nhân viên");
            System.out.println("3. Truy cập quyền Khách hàng");
            System.out.println("4. Sử dụng giao diện đồ họa");
            System.out.println("0. Thoát" + RESET);
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
                        loginAdmin.setVisible(true);
                    case 0:
                        System.out.println("Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi.");
                        break;
                    default:
                        System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập số để chọn quyền truy cập.");
                sc.nextLine();
            }
        } while (luaChonDangNhap != 0);
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
            System.out.println(PURPLE + "***** MENU QUẢN TRỊ VIÊN *****" + RESET);
            System.out.println(BLUE + "1. Xem danh sách nhân viên");
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
            System.out.println("12. Xem sản phẩm trong kho");
            System.out.println("13. Thống kê lợi nhuận");
            System.out.println("14. Tuyển thêm nhân viên toàn thời gian từ file");
            System.out.println("15. Tuyển thêm nhân viên bán thời gian từ file");
            System.out.println("16. Thêm mặt hàng từ file");
            System.out.println("17. Đăng xuất" + RESET);
            System.out.print("Chọn chức năng: ");
            try {
                luaChon = sc.nextInt();
                sc.nextLine();
                switch (luaChon) {
                    case 1:
                        quanLy.xemDanhSachNhanVien(danhSachNhanVien);
                        break;
                    case 2:
                        quanLy.duoiViec(danhSachNhanVien);
                        break;
                    case 3:
                        quanLy.tienTraLuongNhanVien(danhSachNhanVien);
                        break;
                    case 4:
                        quanLy.thongKeDoanhThu(danhSachKhachHang);
                        break;
                    case 5:
                        quanLy.xemLichSuMuaHang(danhSachKhachHang);
                        break;
                    case 6:
                        quanLy.nhapSanPhamMoi(danhSachSanPham);
                        break;
                    case 7:
                        quanLy.themNhanVien(danhSachNhanVien);
                        break;
                    case 8:
                        quanLy.thongKeTienNhapHang(danhSachSanPham);
                        break;
                    case 9:
                        quanLy.timNhanVien(danhSachNhanVien);
                        break;
                    case 10:
                        quanLy.thongKeSoLuongNhanVien(danhSachNhanVien);
                        break;
                    case 11:
                        quanLy.xuatDanhSachKhachHang(danhSachKhachHang);
                        break;
                    case 12:
                        quanLy.xuatDanhSachSanPham(danhSachSanPham);
                        break;
                    case 13:
                        quanLy.thongKeLoiNhuan(danhSachSanPham, danhSachKhachHang);
                        break;
                    case 14:
                        quanLy.themNhanVienToanThoiGianFromFile(danhSachNhanVien);
                        break;
                    case 15:
                        quanLy.themNhanVienBanThoiGianFromFile(danhSachNhanVien);
                        break;
                    case 16:
                        quanLy.themSanPhamFromFile((danhSachSanPham));
                        break;
                    case 17:
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
        // Xác thực nhân viên
        NhanVien nhanVien = danhSachNhanVien.dangNhapNhanVien(maNV);
        if (nhanVien != null) {
            System.out.println("Đăng nhập thành công!");
            System.out.println("Chào mừng " + nhanVien.getHoTen());
            if (nhanVien instanceof NhanVienBanThoigian) {
                NhanVienBanThoigian nhanVienBanThoigian = (NhanVienBanThoigian) nhanVien;
                menuNhanVienBanThoiGian(sc, danhSachSanPham, danhSachKhachHang, danhSachNhanVien, nhanVienBanThoigian); // Hiển thị menu cho nhân viên

            }
            if (nhanVien instanceof NhanVienToanThoiGian) {
                NhanVienToanThoiGian nhanVienToanThoiGian = (NhanVienToanThoiGian) nhanVien;
                menuNhanVienToanThoiGian(sc, danhSachSanPham, danhSachKhachHang, danhSachNhanVien, nhanVienToanThoiGian); // Hiển thị menu cho nhân viên

            }
        } else {
            System.out.println("Đăng nhập thất bại. Vui lòng kiểm tra lại mã nhân viên hoặc họ tên.");
        }
        // Thêm logic xác thực nhân viên ở đây
    }

    // Menu Nhân viên
    private static void menuNhanVienToanThoiGian(Scanner sc, DanhSachSanPham danhSachSanPham, DanhSachKhachHang danhSachKhachHang, DanhSachNhanVien danhSachNhanVien, NhanVienToanThoiGian nhanVienToanThoiGian) {
        int luaChon;
        do {
            System.out.println("***** MENU NHÂN VIÊN *****");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Xem danh sách khách hàng");
//            System.out.println("3. Tạo đơn hàng mới");
            System.out.println("0. Đăng xuất");
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
//                    case 3:
//
//                        break;
                    case 0:
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

    private static void menuNhanVienBanThoiGian(Scanner sc, DanhSachSanPham danhSachSanPham, DanhSachKhachHang danhSachKhachHang, DanhSachNhanVien danhSachNhanVien, NhanVienBanThoigian nhanVienBanThoigian) {
        int luaChon;
        do {
            System.out.println(PURPLE + "***** MENU NHÂN VIÊN *****" + RESET);
            System.out.println(BLUE + "1. Xem danh sách sản phẩm");
            System.out.println("2. Xem danh sách khách hàng");
            System.out.println("3. Đăng ki lich lam viec");
            System.out.println("4. Xem lịch làm việc");
            System.out.println("5. Phoo tô lịch làm viêc ( ghi ra file)");
            System.out.println("0. Đăng xuất" + RESET);
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
                        nhanVienBanThoigian.DangKiLichLamViec();
                        break;
                    case 4:
                        nhanVienBanThoigian.inLichLamViec();
                        break;
                    case 5:
                        nhanVienBanThoigian.xuatFileLichLamViec();
                    case 0:
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
            System.out.println(PURPLE + "***** MENU KHÁCH HÀNG *****" + RESET);
            System.out.println(YELLOW + "1. Đăng ký tài khoản mới");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Xem danh sách sản phẩm");
            System.out.println("4. Thoát" + RESET);
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
                        System.out.println("Nhập mật khẩu: ");
                        String matKhau = sc.nextLine();
                        KhachHang khachHang = danhSachKhachHang.dangNhapKhachHang(cccd, matKhau);
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
            System.out.println(PURPLE + "***** MENU KHÁCH HÀNG ĐÃ ĐĂNG NHẬP *****" + RESET);
            System.out.println(YELLOW + "1. Xem thông tin cá nhân");
            System.out.println("2. Xem lịch sử mua hàng");
            System.out.println("3. Mua hàng");
            System.out.println("4. Đổi mật khẩu");
            System.out.println("5. Đổi điểm tích lũy");
            System.out.println("6. Gửi tiền");
            System.out.println("7. Kiểm tra số dư");
            System.out.println("0. Đăng xuất" + RESET);
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
                        khachHang.muaHang(danhSachSanPham);
                        break;
                    case 4:
                        khachHang.doiMatKhau();
                        break;
                    case 5:
                        khachHang.quyDoiDiemTichLuy();
                        break;
                    case 6:
                        khachHang.guiTien();
                        break;
                    case 7:
                        khachHang.kiemTraSoDu();
                        break;
                    case 0:
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