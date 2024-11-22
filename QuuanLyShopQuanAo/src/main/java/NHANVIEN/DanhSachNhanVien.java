package NHANVIEN;

import java.util.HashMap;
import java.util.Scanner;

public class DanhSachNhanVien {
    Scanner sc = new Scanner(System.in);
    private HashMap<String, NhanVien> danhSachNhanVien;

    public DanhSachNhanVien() {
        this.danhSachNhanVien = new HashMap<>();
    }

    // thêm nhân viên
    public void ThemNhanVien() {
        int luaChon;
        do {
            System.out.println("-----------THÊM NHÂN VIÊN-----------");
            System.out.println("1. Nhân viên bán thời gian");
            System.out.println("2. Nhân viên chính thức");
            System.out.println("3. Thoát");
            System.out.print("Chọn loại nhân viên: ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Xử lý ký tự xuống dòng còn sót lại
            switch (luaChon) {
                case 1:
                    NhanVienBanThoigian nhanVienBanThoiGian = new NhanVienBanThoigian();
                    nhanVienBanThoiGian.nhapThongTin();
                    danhSachNhanVien.put(nhanVienBanThoiGian.getMaNhanVien(), nhanVienBanThoiGian);
                    break;
                case 2:
                    NhanVienToanThoiGian nhanVienChinhThuc = new NhanVienToanThoiGian();
                    nhanVienChinhThuc.nhapThongTin();
                    danhSachNhanVien.put(nhanVienChinhThuc.getMaNhanVien(), nhanVienChinhThuc);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }

        } while (luaChon != 3);
    }

    // xóa nhân viên
    public void XoaNhanVien(String maNhanVien) {
        if (!danhSachNhanVien.containsKey(maNhanVien)) {
            System.out.println("Không tìm thấy nhân viên có mã " + maNhanVien);
            return;
        }
        this.danhSachNhanVien.remove(maNhanVien);
    }

    // thống kê số lượng nhân viên mỗi loại
    public void thongKeSoLuongNhanVien() {
        int soLuongNhanVienBanThoiGian = 0;
        int soLuongNhanVienChinhThuc = 0;
        for (NhanVien nhanVien : danhSachNhanVien.values()) {
            if (nhanVien instanceof NhanVienBanThoigian) {
                soLuongNhanVienBanThoiGian++;
            } else if (nhanVien instanceof NhanVienToanThoiGian) {
                soLuongNhanVienChinhThuc++;
            }
        }
        System.out.println("Số lượng nhân viên bán thời gian: " + soLuongNhanVienBanThoiGian);
        System.out.println("Số lượng nhân viên chính thức: " + soLuongNhanVienChinhThuc);
    }

    // hiển thị thông tin nhân viên theo loại
    public void hienThiThongTinNhanVienBanThoiGian() {

        for (NhanVien nhanVien : danhSachNhanVien.values()) {
            if (nhanVien instanceof NhanVienBanThoigian) {
                NhanVienBanThoigian nhanVienBanThoigian = (NhanVienBanThoigian) nhanVien;
                nhanVienBanThoigian.inThongTin();
            }

        }
    }

    // hiển thị thông tin nhân viên theo loại toàn thời gian
    public void hienThiThongTinNhanVienToanThoiGian() {
        for (NhanVien nhanVien : danhSachNhanVien.values()) {
            if (nhanVien instanceof NhanVienToanThoiGian) {
                NhanVienToanThoiGian nhanVienToanThoiGian = (NhanVienToanThoiGian) nhanVien;
                nhanVienToanThoiGian.inThongTin();
            }
        }

    }

    // hiển thị thông tin nhân viên
    public void hienThiThongTinNhanVien() {
        System.out.println("-------------------------------------------------");
        hienThiThongTinNhanVienBanThoiGian();
        System.out.println("-------------------------------------------------");
        hienThiThongTinNhanVienToanThoiGian();
        System.out.println("-------------------------------------------------");
    }

    // tìm nhân viên theo mã nhân viên
    public void timNhanVien(String maNV) {
        if (danhSachNhanVien.containsKey(maNV)) {
            NhanVien nhanVien = danhSachNhanVien.get(maNV);
            if (nhanVien instanceof NhanVienBanThoigian) {
                NhanVienBanThoigian nhanVienBanThoigian = (NhanVienBanThoigian) nhanVien;
                nhanVienBanThoigian.inThongTin();
            }
            if (nhanVien instanceof NhanVienToanThoiGian) {
                NhanVienToanThoiGian nhanVienToanThoiGian = (NhanVienToanThoiGian) nhanVien;
                nhanVienToanThoiGian.inThongTin();
            }
        } else {
            System.out.println("Không tìm thấy nhân viên có mã " + maNV);
        }
    }

    // tổng tiền trả có nhân viên bán thời gian
    public void tongTienTraNhanVienBanThoiGian() {
        double tongTienTra = 0;
        for (NhanVien nhanVien : danhSachNhanVien.values()) {
            if (nhanVien instanceof NhanVienBanThoigian) {
                NhanVienBanThoigian nhanVienBanThoigian = (NhanVienBanThoigian) nhanVien;
                tongTienTra += nhanVienBanThoigian.TongLuong();
            }
        }
        System.out.println("Tổng tiền trả cho nhân viên bán thời gian: " + tongTienTra);
    }

    // tổng tiền trả có nhân viên chính thức
    public void tongTienTraNhanVienChinhThuc() {
        double tongTienTra = 0;
        for (NhanVien nhanVien : danhSachNhanVien.values()) {
            if (nhanVien instanceof NhanVienToanThoiGian) {
                NhanVienToanThoiGian nhanVienToanThoiGian = (NhanVienToanThoiGian) nhanVien;
                tongTienTra += nhanVienToanThoiGian.TongLuong();
            }
        }
        System.out.println("Tổng tiền trả cho nhân viên chính thức: " + tongTienTra);
    }
//in lịch làm việc của nhân viên bán thời gian
    public void inLichLamViecNhanVienBanThoiGian() {
        for (NhanVien nhanVien : danhSachNhanVien.values()) {
            if (nhanVien instanceof NhanVienBanThoigian) {
                NhanVienBanThoigian nhanVienBanThoigian = (NhanVienBanThoigian) nhanVien;
                nhanVienBanThoigian.inLichLamViec();
            }
        }
    }
    // tổng tiền trả cho tất cả nhân viên
    public void tongTienTraNhanVien() {
        double tongTienTra = 0;
        for (NhanVien nhanVien : danhSachNhanVien.values()) {
            if (nhanVien instanceof NhanVienBanThoigian) {
                NhanVienBanThoigian nhanVienBanThoigian = (NhanVienBanThoigian) nhanVien;
                tongTienTra += nhanVienBanThoigian.TongLuong();
            }
            if (nhanVien instanceof NhanVienToanThoiGian) {
                NhanVienToanThoiGian nhanVienToanThoiGian = (NhanVienToanThoiGian) nhanVien;
                tongTienTra += nhanVienToanThoiGian.TongLuong();
            }
        }
        System.out.println("Tổng tiền trả cho tất cả nhân viên: " + tongTienTra);
    }
//    đăng nhập nhân viên
    public NhanVien dangNhapNhanVien(String maNV) {
        if (danhSachNhanVien.containsKey(maNV)) {
            NhanVien nhanVien = danhSachNhanVien.get(maNV);
            return nhanVien;
        }
        return null;
    }
}
