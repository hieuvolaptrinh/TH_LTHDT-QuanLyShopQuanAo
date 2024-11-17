package PHUONGTHUCTHANHTOAN;

import java.util.Scanner;

public class ThongTinThanhToan {
    Scanner sc = new Scanner(System.in);
    private String hinhThucThanhToan;
    private String trangThaiThanhToan;
    private String maThanhToan;

    // Constructor không tham số
    public ThongTinThanhToan() {
        this.hinhThucThanhToan = "";
        this.trangThaiThanhToan = "Chưa thanh toán";
        this.maThanhToan = "Unknown";

    }

    // Constructor có tham số
    public ThongTinThanhToan(String hinhThucThanhToan, String trangThaiThanhToan, String maThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.maThanhToan = maThanhToan;

    }

    //nhập thông tin thanh toán
    public void nhapThongTinThanhToan() {
        // Chọn hình thức thanh toán
        int luaChon;
        do {
            System.out.println("Nhập hình thức thanh toán:");
            System.out.println("1. Chuyển khoản");
            System.out.println("2. Tiền mặt");
            System.out.print("Lựa chọn: ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Xử lý dòng nhập

            if (luaChon == 1) {
                this.hinhThucThanhToan = "Chuyển khoản";
            } else if (luaChon == 2) {
                this.hinhThucThanhToan = "Tiền mặt";
            } else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (luaChon < 1 || luaChon > 2);

        // Tạo mã thanh toán ngẫu nhiên và yêu cầu xác thực
        int maThanhToan = (int) (Math.random() * 1000);
        System.out.println("Mã thanh toán (Hệ thống cấp): " + maThanhToan);
        int dem = 0;

        while (true) {
            System.out.print("Nhập mã thanh toán để xác nhận: ");
            int nhapMaThanhToan = sc.nextInt();
            sc.nextLine(); // Xử lý dòng nhập

            if (nhapMaThanhToan == maThanhToan) {
                this.maThanhToan = String.valueOf(maThanhToan);
                System.out.println("Xác nhận mã thanh toán thành công!");
                break;
            } else {
                System.out.println("Mã thanh toán không chính xác. Vui lòng nhập lại!");
                dem++;
            }

            if (dem == 3) {
                System.out.println("Bạn đã nhập sai mã quá 3 lần. Hệ thống sẽ thoát.");
                this.trangThaiThanhToan = "Chưa thanh toán";
                return;
            }
        }

        // Kiểm tra trạng thái thanh toán
        String traLoi;
        do {
            System.out.print("Bạn có muốn thanh toán ngay không (Có/Không)? ");
            traLoi = sc.nextLine();
            if (traLoi.equalsIgnoreCase("Có")) {
                this.trangThaiThanhToan = "Đã thanh toán";
            } else if (traLoi.equalsIgnoreCase("Không")) {
                this.trangThaiThanhToan = "Chưa thanh toán";
            } else {
                System.out.println("Vui lòng nhập 'Có' hoặc 'Không'!");
            }
        } while (!traLoi.equalsIgnoreCase("Có") && !traLoi.equalsIgnoreCase("Không"));
    }

    // Getter và Setter cho hinhThucThanhToan
    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    // Getter và Setter cho trangThaiThanhToan
    public String getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(String trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    // Getter và Setter cho maThanhToan
    public String getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }


    // Phương thức hiển thị thông tin thanh toán
    @Override
    public String toString() {
        return "Thông tin thanh toán:\n" +
                "Hình thức thanh toán: " + hinhThucThanhToan + "\n" +
                "Trạng thái thanh toán: " + trangThaiThanhToan + "\n" +
                "Mã thanh toán: " + maThanhToan + "\n";
    }

    // Phương thức in ra thông tin thanh toán
    public void inThongTinThanhToan() {
        System.out.println(this.toString());
    }
}
