package NHANVIEN;

import CHECKTHONGTIN.CheckThongTin;
import INTERFACE.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class DanhSachNhanVien implements File {
    Scanner sc = new Scanner(System.in);
    private HashMap<String, NhanVien> danhSachNhanVien;

    public DanhSachNhanVien() {
        this.danhSachNhanVien = new HashMap<>();
    }

    public HashMap<String, NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public void setDanhSachNhanVien(HashMap<String, NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
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
            System.out.println("------------------------");
        }
    }

    // hiển thị thông tin nhân viên theo loại toàn thời gian
    public void hienThiThongTinNhanVienToanThoiGian() {
        for (NhanVien nhanVien : danhSachNhanVien.values()) {
            if (nhanVien instanceof NhanVienToanThoiGian) {
                NhanVienToanThoiGian nhanVienToanThoiGian = (NhanVienToanThoiGian) nhanVien;
                nhanVienToanThoiGian.inThongTin();
            }
            System.out.println("------------------------");
        }

    }

    // hiển thị thông tin nhân viên
    public void hienThiThongTinNhanVien() {
        hienThiThongTinNhanVienBanThoiGian();
        hienThiThongTinNhanVienToanThoiGian();
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
        System.out.println("Tổng tiền trả cho nhân viên bán thời gian: " +String.format("%,.0f", tongTienTra) );
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
        System.out.println("Tổng tiền trả cho nhân viên chính thức: " + String.format("%,.0f", tongTienTra));
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
    public void docFileVaThemNhanVienToanThoiGian() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try (BufferedReader br = new BufferedReader(new FileReader(docNhanVienToanThoiGian))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 10) { // Đảm bảo đúng định dạng 10 trường thông tin
                    try {
                        // Parse các trường dữ liệu
                        String cccd = data[0].trim();
                        String hoTen = data[1].trim();
                        String soDienThoai = data[2].trim();
                        String gioiTinh = data[3].trim();
                        Date ngaySinh = dateFormat.parse(data[4].trim());
                        String email = data[5].trim();
                        String diaChi = data[6].trim();
                        String maNhanVien = data[7].trim();
                        Date ngayVaoLamViec = dateFormat.parse(data[8].trim());
                        double heSoLuong = Double.parseDouble(data[9].trim());

                        // Kiểm tra thông tin hợp lệ
                        if (CheckThongTin.kiemTraCCCD(cccd) &&
                                CheckThongTin.checkSoDienThoai(soDienThoai) &&
                                CheckThongTin.checkEmail(email)) {

                            // Thêm nhân viên vào danh sách
                            if (danhSachNhanVien.containsKey(maNhanVien)) {
                                System.out.println("Mã nhân viên đã tồn tại: " + maNhanVien);
                            } else {
                                NhanVien nv = new NhanVienToanThoiGian(cccd, hoTen, soDienThoai, gioiTinh, ngaySinh, email, diaChi, maNhanVien, ngayVaoLamViec, heSoLuong);
                                danhSachNhanVien.put(maNhanVien, nv);
                                System.out.println("Thêm nhân viên: " + hoTen + " (Mã nhân viên: " + maNhanVien + ") thành công!");
                            }
                        } else {
                            System.out.println("Thông tin nhân viên không hợp lệ: " + hoTen);
                        }
                    } catch (ParseException e) {
                        System.out.println("Lỗi định dạng ngày: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi định dạng hệ số lương: " + e.getMessage());
                    }
                } else {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
    public void docFileVaThemNhanVienBanThoiGian() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try (BufferedReader br = new BufferedReader(new FileReader(docNhanVienBanThoiGian))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 8) { // Đảm bảo có ít nhất 9 trường dữ liệu (không cần hệ số lương)
                    try {
                        // Parse các trường dữ liệu
                        String cccd = data[0].trim();
                        String hoTen = data[1].trim();
                        String soDienThoai = data[2].trim();
                        String gioiTinh = data[3].trim();
                        Date ngaySinh = dateFormat.parse(data[4].trim());
                        String email = data[5].trim();
                        String diaChi = data[6].trim();
                        String maNhanVien = data[7].trim();

                        // Kiểm tra thông tin hợp lệ
                        if (CheckThongTin.kiemTraCCCD(cccd) &&
                                CheckThongTin.checkSoDienThoai(soDienThoai) &&
                                CheckThongTin.checkEmail(email)) {

                            // Thêm nhân viên vào danh sách
                            if (danhSachNhanVien.containsKey(maNhanVien)) {
                                System.out.println("Mã nhân viên đã tồn tại: " + maNhanVien);
                            } else {
                                NhanVien nv = new NhanVienBanThoigian(cccd, hoTen, soDienThoai, gioiTinh, ngaySinh, email, diaChi, maNhanVien);
                                danhSachNhanVien.put(maNhanVien, nv);
                                System.out.println("Thêm nhân viên: " + hoTen + " (Mã nhân viên: " + maNhanVien + ") thành công!");
                            }
                        } else {
                            System.out.println("Thông tin nhân viên không hợp lệ: " + hoTen);
                        }
                    } catch (ParseException e) {
                        System.out.println("Lỗi định dạng ngày: " + e.getMessage());
                    }
                } else {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }


}
