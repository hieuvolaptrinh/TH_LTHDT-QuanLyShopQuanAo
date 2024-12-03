package KHACHHANG;

import DONHANG.DonHang;
import NGUOI.Nguoi;
import SANPHAM.DanhSachSanPham;
import SANPHAM.SanPham;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class KhachHang extends Nguoi {
    Scanner sc = new Scanner(System.in);
    private String matKhau;
    private double diemTichLuy;
    private ArrayList<DonHang> lichSuMuaHang;
//Constructor


    public KhachHang(String CCCD, String hoTen, String soDienThoai, String gioiTinh, Date ngaySinh, String email, String diaChi, double diemTichLuy,String matKhau, ArrayList<DonHang> lichSuMuaHang ) {
        super(CCCD, hoTen, soDienThoai, gioiTinh, ngaySinh, email, diaChi);
        this.diemTichLuy = diemTichLuy;
        this.matKhau= matKhau;
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

    public void setLichSuMuaHang(ArrayList<DonHang> lichSuMuaHang) {
        this.lichSuMuaHang = lichSuMuaHang;
    }
//Các phương thức

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.println("Nhập mật khẩu mà bạn muốn đăng kí");
        this.matKhau= sc.nextLine();
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Điểm tích lũy: " + diemTichLuy);
        for (DonHang donHang : lichSuMuaHang) {
            System.out.println("- " + donHang.toString());
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
        dsSanPham.xuatDSSanPham();
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
            // Hỏi khách hàng có muốn tiếp tục mua hàng hay không
            System.out.print("Nhập 1 để tiếp tục mua, hoặc 2 để kết thúc: ");
            luaChon = sc.nextInt();
            sc.nextLine();

        } while (luaChon == 1);

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
        this.diemTichLuy = this.diemTichLuy + soTienMuaHang / 1000;
    }

}