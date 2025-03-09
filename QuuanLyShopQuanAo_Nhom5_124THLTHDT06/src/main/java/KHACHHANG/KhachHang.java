package KHACHHANG;

import DONHANG.DonHang;
import NGUOI.Nguoi;
import PHUONGTHUCTHANHTOAN.ThongTinThanhToan;
import SANPHAM.DanhSachSanPham;
import SANPHAM.SanPham;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class KhachHang extends Nguoi {
    Scanner sc = new Scanner(System.in);
    private String matKhau;
    private double diemTichLuy;
    private double soDu;
    private ArrayList<DonHang> lichSuMuaHang;
//Constructor


    public KhachHang(String CCCD, String hoTen, String soDienThoai, String gioiTinh, Date ngaySinh, String email, String diaChi, String matKhau, double diemTichLuy, double soDu, ArrayList<DonHang> lichSuMuaHang) {
        super(CCCD, hoTen, soDienThoai, gioiTinh, ngaySinh, email, diaChi);
        this.matKhau = matKhau;
        this.diemTichLuy = diemTichLuy;
        this.soDu = soDu;
        this.lichSuMuaHang = lichSuMuaHang;
    }


    public KhachHang() {
        this.lichSuMuaHang = new ArrayList<>();
    }

    //Getter and Setter
    public double getDiemTichLuy() {
        return diemTichLuy;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setDiemTichLuy(double diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public ArrayList<DonHang> getLichSuMuaHang() {
        return lichSuMuaHang;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public void setLichSuMuaHang(ArrayList<DonHang> lichSuMuaHang) {
        this.lichSuMuaHang = lichSuMuaHang;
    }
//Các phương thức

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        do {
            System.out.println("Nhập mật khẩu mà bạn muốn đăng kí");
            this.matKhau = sc.nextLine();
        } while (!KiemTraMatkhau(matKhau));

    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Điểm tích lũy: " + diemTichLuy);
        for (DonHang donHang : lichSuMuaHang) {
             donHang.inDonHang();
        }
    }

    //hiển thị danh sách sản phẩm khách hàng có thể mua
    public void hienThiDanhSachSanPham(DanhSachSanPham dsSanPham) {
        dsSanPham.xuatDSSanPham();


    }

    // mua hàng
    public void muaHang(DanhSachSanPham dsSanPham) {
        DonHang donHang = new DonHang();
        int luaChon = 0;
        double tongTienThanhToan = 0;
        double tongTienThanhToanQuaTaiKhoan = 0;
        dsSanPham.xuatDSSanPham();
        System.out.println("--------------------------------");
        if (dsSanPham.getDanhSachSanPham().isEmpty()) {
            System.out.println("Hiện tại không có sản phẩm nào để mua.");
            return;
        }
        do {
            System.out.print("Nhập mã sản phẩm bạn muốn mua: ");
            String maSanPham = sc.nextLine();

            SanPham sanPham = null;
            for (SanPham sp : dsSanPham.getDanhSachSanPham().values()) {
                if (sp.getMaSanPham().equals(maSanPham)) {
                    sanPham = sp;
                    System.out.println("Sản phẩm bạn chọn là: ");
                    sanPham.xuatTTSP();
                    break;
                }
            }

            if (sanPham == null) {
                System.out.println("Không tìm thấy sản phẩm với mã " + maSanPham);
                continue; // Quay lại vòng lặp để nhập lại mã sản phẩm
            }


            System.out.print("Nhập số lượng sản phẩm bạn muốn mua: ");
            int soLuong = sc.nextInt();
            sc.nextLine();
//            trừ số lượng sản phẩm đã mua khỏi số lượng tồn kho
            if (soLuong > sanPham.getSoLuong()) {
                System.out.println("Số lượng sản phẩm không đủ. Số lượng tồn kho: " + sanPham.getSoLuong());
                continue; // Quay lại vòng lặp để nhập lại số lượng
            } else {
                dsSanPham.getDanhSachSanPham().get(maSanPham).capNhatSoLuong(soLuong);
                System.out.println("Đã thêm vào đơn hàng thành công!");

            }
            // Thêm sản phẩm vào đơn hàng
            donHang.themChiTietDonHang(sanPham, soLuong);
            tongTienThanhToan = tongTienThanhToan + soLuong* sanPham.getGiaBan();
            if(donHang.getThongTinThanhToan().getHinhThucThanhToan().equals("Chuyển khoản"))
                    tongTienThanhToanQuaTaiKhoan = tongTienThanhToanQuaTaiKhoan + soLuong* sanPham.getGiaBan();
            // Hỏi khách hàng có muốn tiếp tục mua hàng hay không
            System.out.print("Nhập 1 để tiếp tục mua, hoặc 2 để kết thúc: ");
            luaChon = sc.nextInt();
            sc.nextLine();

        } while (luaChon == 1);
        System.out.println("Tổng số tiền phải thanh toán : "+tongTienThanhToan);
        setSoDu(getSoDu()-tongTienThanhToanQuaTaiKhoan);
        System.out.println("Số dư hiện tại của bạn là : "+getSoDu());
        themLichSuMuaHang(donHang);
        tinhDiemTichLuy(donHang.thanhTien());

    }


    // Thêm mua hàng vào lịch sử
    public void themLichSuMuaHang(DonHang donHang) {
        lichSuMuaHang.add(donHang);
    }

    // Hiển thị lịch sử mua hàng
    public void hienThiLichSuMuaHang() {
        System.out.println("Lịch sử giao dịch của khách hàng " + hoTen + ":");
        for (DonHang donHang : lichSuMuaHang) {
            donHang.inDonHang();
        }
    }

    public void hienThiLichSuMuaHangToFile() {
        String filePath = "src/main/resources/lichSuMuaHang_" + hoTen + ".txt";
        try (FileWriter fileWriter = new FileWriter(filePath, true); // true: ghi tiếp vào file nếu file đã tồn tại
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            writer.write("Lịch sử giao dịch của khách hàng " + hoTen + ":\n");
            for (DonHang donHang : lichSuMuaHang) {
                donHang.inDonHangToFile(writer); // Hàm này nên được viết để nhận BufferedWriter
            }
            System.out.println("Lịch sử mua hàng đã được ghi vào file: " + filePath);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void tinhDiemTichLuy(double soTienMuaHang) {
        this.diemTichLuy = this.diemTichLuy + soTienMuaHang / 10;
    }

    public int randomOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return otp;
    }

    public void quyDoiDiemTichLuy() {
        // Kiểm tra số dư
        boolean check = false;
        int dem = 0;
        int count = 0;
        String mk;

        do {
            System.out.println("Vui lòng nhập mật khẩu :");
            mk = sc.nextLine();
            if (mk.equals(getMatKhau())) {

                if (this.diemTichLuy < 1000) {
                    System.out.println("Điểm tích lũy phải trên 1000 mới mở khóa chức năng quy đổi điểm.");
                    break;
                }

                do {
                    System.out.println("Chọn một trong những loại mệnh giá sau với 1000 điểm tích lũy quy đổi được thẻ với mệnh giá 10,000 VND :");
                    System.out.println("10,000 VND   20,000 VND  50,000 VND  100,000 VND  200,000 VND  500,000 VND");
                    double menhGia = sc.nextDouble();
                    sc.nextLine();
                    if (menhGia != 10000 && menhGia != 20000 && menhGia != 50000 && menhGia != 100000 && menhGia != 200000 && menhGia != 500000) {
                        System.out.println("Mệnh giá thẻ không hợp lệ !!!");
                    } else {
                        // Tạo OTP và gửi mã OTP
                        int otp = randomOTP();
                        System.out.println("Mã OTP của bạn là: " + otp);
                        do {

                            System.out.println("Vui lòng nhập mã OTP: ");
                            int nhapOtp = sc.nextInt();
                            sc.nextLine();
                            if (nhapOtp == otp) {
                                // Hiển thị lựa chọn loại thẻ
                                System.out.println("1. Viettel");
                                System.out.println("2. Mobiphone");
                                System.out.println("3. Vinaphone");
                                System.out.println("4. Vietnammobile");
                                System.out.println("5. Gmobile");
                                System.out.println("6. Itelecom");
                                System.out.println("7. Garena");
                                System.out.println("Vui lòng chọn loại thẻ cào muốn mua :");
                                int loaiThe = sc.nextInt();
                                String tenLoaiThe;

                                // Sử dụng switch để chọn loại thẻ
                                switch (loaiThe) {
                                    case 1 -> tenLoaiThe = "Viettel";
                                    case 2 -> tenLoaiThe = "Mobiphone";
                                    case 3 -> tenLoaiThe = "Vinaphone";
                                    case 4 -> tenLoaiThe = "Vietnammobile";
                                    case 5 -> tenLoaiThe = "Gmobile";
                                    case 6 -> tenLoaiThe = "Itelecom";
                                    case 7 -> tenLoaiThe = "Garena";
                                    default -> {
                                        System.out.println("Loại thẻ không hợp lệ. Vui lòng thử lại.");
                                        return;
                                    }
                                }

                                // Tạo số seri và mã thẻ ngẫu nhiên
                                String soSeri = String.format("%012d", (long) (Math.random() * Math.pow(10, 12)));
                                String maThe = String.format("%012d", (long) (Math.random() * Math.pow(10, 12)));

                                // Trừ số dư
                                this.diemTichLuy -= menhGia / 10;


                                System.out.println("Card " + tenLoaiThe);
                                System.out.println("Số seri: " + soSeri);
                                System.out.println("Mã thẻ: " + maThe);
                                System.out.println("Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi.");
                                check = true;
                            } else {
                                count++;
                                if (count > 2) {
                                    System.out.println("Nhập sai quá số lần quy định dịch vụ sẽ bị đóng");
                                    break;
                                } else
                                    System.out.println("Mã OTP không đúng.");
                            }
                        } while (!check);
                        break;
                    }
                } while (!check);
                break;
            } else {
                dem++;
                if (dem > 2) {
                    System.out.println("nhập sai mật khẩu quá 2 lần, dịch vụ bị khóa.");
                    break;
                } else
                    System.out.println("sai mật khẩu, vui lòng nhập lại.");
            }
        } while (!check);
    }

    public void guiTien() {
        boolean check = false;
        int dem = 0;
        int count = 0;
        String mk;
        do {
            System.out.println("Vui lòng nhập mật khẩu :");
            mk = sc.nextLine();
            if (mk.equals(getMatKhau())) {
                //Tạo OTP và gửi mã OTP
                System.out.print("Nhập số tiền gửi: ");
                double tienGui = sc.nextDouble();
                if (tienGui > 0) {
                    int otp = randomOTP();
                    System.out.println("Mã OTP của bạn là: " + otp);
                    System.out.println("Vui lòng nhập mã OTP: ");
                    int nhapOTP = sc.nextInt();
                    sc.nextLine();
                    if (nhapOTP == otp) {
                        System.out.println("Bạn vừa gửi vào tài khoản." + tienGui);
                        this.setSoDu(this.getSoDu() + tienGui);
                        System.out.println("Số dư hiện tại của bạn là " + this.getSoDu());

                        check = true;
                    } else {
                        count++;
                        if (count > 2) {
                            System.out.println("Nhập sai quá số lần quy định dịch vụ sẽ bị đóng");
                            break;
                        } else
                            System.out.println("Mã OTP không đúng.");
                    }
                } else {
                    System.out.println("Số tiền không hợp lệ");
                    sc.nextLine();
                }

            } else {

                dem++;
                if (dem > 2) {
                    System.out.println("nhập sai mật khẩu quá 2 lần, dịch vụ bị khóa.");
                    break;
                } else
                    System.out.println("Sai mật khẩu, vui lòng nhập lại.");
            }
        } while (!check);
    }

    // Hàm kiểm tra mật khẩu
    public boolean KiemTraMatkhau(String matkhau) {
        // Kiểm tra độ dài mật khẩu
        if (matkhau.length() < 8) {
            System.out.println("Mật khẩu phải có ít nhất 8 ký tự.");
            return false;
        }

        // Biểu thức chính quy cho các ràng buộc mật khẩu
        String chuHoa = ".*[A-Z].*"; // ít nhất một chữ cái viết hoa
        String chuThuong = ".*[a-z].*"; // ít nhất một chữ cái viết thường
        String chuSo = ".*[0-9].*";     // ít nhất một chữ số
        String kiTuDacBiet = ".*[@#$%^&+=].*"; // ít nhất một ký tự đặc biệt (@, #, $, %, ^, &, +, =)

        // Kiểm tra từng ràng buộc bằng cách sử dụng regex
        if (!matkhau.matches(chuHoa)) {
            System.out.println("Mật khẩu phải có ít nhất một chữ cái viết hoa.");
            return false;
        }

        if (!matkhau.matches(chuThuong)) {
            System.out.println("Mật khẩu phải có ít nhất một chữ cái viết thường.");
            return false;
        }

        if (!matkhau.matches(chuSo)) {
            System.out.println("Mật khẩu phải có ít nhất một chữ số.");
            return false;
        }

        if (!matkhau.matches(kiTuDacBiet)) {
            System.out.println("Mật khẩu phải có ít nhất một ký tự đặc biệt.");
            return false;
        }

        // Nếu mật khẩu đáp ứng tất cả các điều kiện, trả về true
        return true;
    }
//    public boolean KiemTraTenTaiKhoan(String tenTaiKhoan) {
//        // Biểu thức chính quy cho tên tài khoản viết hoa không dấu
//        String regexTenTaiKhoan = "^[A-Z]+$";
//
//        // Kiểm tra tên tài khoản
//        if (!tenTaiKhoan.matches(regexTenTaiKhoan)) {
//            System.out.println("Tên tài khoản phải viết hoa và không có dấu.");
//            return false;
//        }
//
//        // Nếu tên tài khoản đúng định dạng, trả về true
//        return true;
//    }
//    public boolean KiemTraSoTaiKhoan(String soTaiKhoan) {
//        // Biểu thức chính quy cho số tài khoản đủ 10 chữ số
//        String regexSoTaiKhoan = "^\\d{10}$";
//
//        // Kiểm tra số tài khoản
//        if (!soTaiKhoan.matches(regexSoTaiKhoan)) {
//            System.out.println("Số tài khoản phải đủ 10 chữ số và chỉ chứa số.");
//            return false;
//        }
//
//        // Nếu số tài khoản đúng định dạng, trả về true
//        return true;
//    }

    public void doiMatKhau() {
        boolean check = false;
        int count = 0;
        System.out.print("Nhập mật khẩu cũ: ");
        String mkCu = sc.nextLine();

        if (mkCu.equals(this.matKhau)) {
            String mkMoi1, mkMoi2;
            do {
                System.out.println("Vui lòng nhập mật khẩu mới : ");
                mkMoi1 = sc.nextLine();
                if (KiemTraMatkhau(mkMoi1)) {
                    if (!mkMoi1.equals(mkCu)) {
                        System.out.println("Mật khẩu hợp lệ !!!");
                        do {
                            System.out.println("Vui lòng xác nhận lại mật khẩu mới : ");
                            mkMoi2 = sc.nextLine();
                            if (mkMoi1.equals(mkMoi2)) {
                                System.out.println("Mật khẩu trùng khớp!!!");
                                // Tạo OTP và gửi mã OTP
                                int otp = randomOTP();
                                System.out.println("Mã OTP của bạn là: " + otp);
                                do {
                                    System.out.println("Vui lòng nhập mã OTP: ");
                                    int nhapOtp = sc.nextInt();
                                    if (nhapOtp == otp) {
                                        setMatKhau(mkMoi1);
                                        System.out.println("Bạn đã đổi mật khẩu thành công, thông tin tài khoản hiện tại của bạn là : ");
                                        System.out.println("Chủ tài khoản : " + hoTen);
                                        System.out.println("Số tài khoản :  " + soDienThoai);
                                        System.out.println("Mật khẩu mới là : " + this.matKhau);
                                        check = true;
                                    } else {
                                        count++;
                                        if (count > 2) {
                                            System.out.println("Nhập sai quá số lần quy định dịch vụ sẽ bị đóng!!!");
                                            break;
                                        } else
                                            System.out.println("Mã OTP không đúng.");
                                    }
                                } while (!check);
                                break;
                            } else
                                System.out.println("Mật khẩu không trùng khớp!!!");
                        } while (!check);
                        break;
                    } else
                        System.out.println("Mật khẩu mới phải khác mật khẩu cũ!!!");
                }
            } while (!check);
        } else
            System.out.println("Bạn đã nhập sai mật khẩu !!! ");
    }
    public void kiemTraSoDu() {
        boolean check = false;
        int dem = 0;
        String mk;
        do {
            System.out.println("Vui lòng nhập mật khẩu :");
            mk = sc.nextLine();
            if (mk.equals(this.matKhau)) {
                System.out.println("Số dư tài khoản tiết kiệm của bạn là: " + this.soDu);
                check = true;
            } else {
                dem++;
                if (dem > 2) {
                    System.out.println("Nhập sai mật khẩu quá 2 lần, dịch vụ bị khóa.");
                    break;
                } else {
                    System.out.println("Mật khẩu khẩu đúng, vui lòng nhập lại.");
                }
            }
        } while (!check);

    }
}