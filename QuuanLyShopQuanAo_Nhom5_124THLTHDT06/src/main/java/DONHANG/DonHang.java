package DONHANG;

import PHUONGTHUCTHANHTOAN.ThongTinThanhToan;
import SANPHAM.SanPham;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class DonHang {
    // private String maDonHang;
    private HashMap<String, ChiTietDonHang> dsChiTietDonHang;
    private ThongTinThanhToan thongTinThanhToan;
    private Date ngayMua;
    private double thanhTien;
    // private NhanVien nhanVienDaban;

    public DonHang(Date ngayMua, ThongTinThanhToan thongTinThanhToan) {
        this.dsChiTietDonHang = new HashMap<>();
        // this.maDonHang = maDonHang;
        this.ngayMua = ngayMua;
        // this.nhanVienDaban = nhanVienDaban;
        this.thongTinThanhToan = thongTinThanhToan;
    }

    public DonHang() {
        this.dsChiTietDonHang = new HashMap<>();
        this.ngayMua = new Date();

    }

    public HashMap<String, ChiTietDonHang> getDsChiTietDonHang() {
        return dsChiTietDonHang;
    }

    public void setDsChiTietDonHang(HashMap<String, ChiTietDonHang> dsChiTietDonHang) {
        this.dsChiTietDonHang = dsChiTietDonHang;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public ThongTinThanhToan getThongTinThanhToan() {
        return thongTinThanhToan;
    }

    public void setThongTinThanhToan(ThongTinThanhToan thongTinThanhToan) {
        this.thongTinThanhToan = thongTinThanhToan;
    }

    // thêm một chi tiết đơn hàng
    public void themChiTietDonHang(SanPham sanPham, int soLuong) {
        System.out.println("----------------------Nhập thông tin đơn hàng:----------------------------");
        System.out.println("nhập thông tin thanh toán ");
        thongTinThanhToan = new ThongTinThanhToan();
        thongTinThanhToan.nhapThongTinThanhToan();
        ChiTietDonHang chiTietDonHang = new ChiTietDonHang(sanPham, soLuong);
        // chiTietDonHang.themChiTietDonHang(sanPham,soLuong);
        dsChiTietDonHang.put(chiTietDonHang.getSanPham().getMaSanPham(), chiTietDonHang);
        this.thanhTien = thanhTien();
        this.ngayMua = new Date();
    }

    // in thông tin đơn hàng
    public void inDonHang() {
        System.out.println("--------------------------------------------------");
        System.out.println("Thông tin đơn hàng: ");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String ngayMuaFormatted = formatter.format(ngayMua);
        System.out.println("Ngày mua: " + ngayMuaFormatted);

        System.out.println("Hình thức thanh toán: " + thongTinThanhToan.getHinhThucThanhToan());
        System.out.println("Trạng thái thanh toán: " + thongTinThanhToan.getTrangThaiThanhToan());
        System.out.println("Chi tiết các mặt hàng:");

        // In chi tiết từng sản phẩm
        for (ChiTietDonHang chiTiet : dsChiTietDonHang.values()) {
            chiTiet.inChiTietDonHang();
        }

        // System.out.println("Tổng tiền: " + String.format("%.2f", thanhTien) + "
        // VND");
    }

    public void inDonHangToFile(BufferedWriter writer) throws IOException {
        writer.write("--------------------------------------------------\n");
        writer.write("Thông tin đơn hàng: \n");

        // Format date and write it
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String ngayMuaFormatted = formatter.format(ngayMua);
        writer.write("Ngày mua: " + ngayMuaFormatted + "\n");

        // Write payment details
        writer.write("Hình thức thanh toán: " + thongTinThanhToan.getHinhThucThanhToan() + "\n");
        writer.write("Trạng thái thanh toán: " + thongTinThanhToan.getTrangThaiThanhToan() + "\n");

        writer.write("Chi tiết các mặt hàng:\n");

        // Write each product detail
        for (ChiTietDonHang chiTiet : dsChiTietDonHang.values()) {
            chiTiet.inChiTietDonHangToFile(writer);
        }

        writer.write("Tổng tiền: " + String.format("%.2f", thanhTien) + " VND\n");
    }

    // xuất những sản phẩm có trong đơn hàng
    public void xuatSanPham() {
        System.out.println("--------------------------------------------------");
        System.out.println("Danh sách sản phẩm: ");
        for (String key : dsChiTietDonHang.keySet()) {
            System.out.println("-----------");
            dsChiTietDonHang.get(key).getSanPham().xuatTTSP();
        }
    }

    public double thanhTien() {
        double tongTien = 0;
        for (String key : dsChiTietDonHang.keySet()) {
            ChiTietDonHang chiTiet = dsChiTietDonHang.get(key);
            double giaBan = chiTiet.getSanPham().getGiaBan();
            int soLuong = chiTiet.getSanPham().getSoLuong();
            // System.out.println("Giá bán: " + giaBan + ", Số lượng: " + soLuong); // Debug
            // line
            tongTien += giaBan * soLuong;
        }
        return tongTien;
    }

    public double tienLoi() {
        double tongTien = 0;
        for (String key : dsChiTietDonHang.keySet()) {
            ChiTietDonHang chiTiet = dsChiTietDonHang.get(key);
            double giaBan = chiTiet.getSanPham().getGiaBan();
            double giaNhap = chiTiet.getSanPham().getGiaNhap();
            // System.out.println("Giá bán: " + giaBan + ", Giá nhập: " + giaNhap); // Debug
            // line
            tongTien += (giaBan - giaNhap);
        }
        return tongTien;
    }
}
