package DONHANG;

import PHUONGTHUCTHANHTOAN.ThongTinThanhToan;
import SANPHAM.SanPham;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class DonHang {
    private String maDonHang;
    private HashMap<String, ChiTietDonHang> dsChiTietDonHang;
    private ThongTinThanhToan thongTinThanhToan;
    private Date ngayMua;
    private double thanhTien;
//    private NhanVien nhanVienDaban;

    public DonHang( String maDonHang, Date ngayMua,  ThongTinThanhToan thongTinThanhToan) {
        this.dsChiTietDonHang = new HashMap<>();
        this.maDonHang = maDonHang;
        this.ngayMua = ngayMua;
//        this.nhanVienDaban = nhanVienDaban;
        this.thongTinThanhToan = thongTinThanhToan;
    }
    public DonHang() {
        this.dsChiTietDonHang = new HashMap<>();

    }
//    thêm một chi tiết đơn hàng
    public void themChiTietDonHang(SanPham sanPham, int soLuong){
        System.out.println("----------------------Nhập thông tin đơn hàng:----------------------------");
        System.out.println("nhập thông tin thanh toán ");
        thongTinThanhToan = new ThongTinThanhToan();
        thongTinThanhToan.nhapThongTinThanhToan();
        ChiTietDonHang chiTietDonHang = new ChiTietDonHang(sanPham,soLuong);
//        chiTietDonHang.themChiTietDonHang(sanPham,soLuong);
        dsChiTietDonHang.put(chiTietDonHang.getSanPham().getMaSanPham(),chiTietDonHang);
        this.thanhTien =thanhTien();
        this.ngayMua = new Date();
    }
//    in thông tin đơn hàng
    public void inDonHang(){
        System.out.println("--------------------------------------------------");
        System.out.println("Thông tin đơn hàng: ");
        System.out.println("Mã đơn hàng: " + maDonHang);

        // Định dạng ngày giờ
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

        System.out.println("Tổng tiền: " + String.format("%.2f",thanhTien) + " VND");
    }
//    xuất những sản phẩm có trong đơn hàng
    public void xuatSanPham(){
        System.out.println("--------------------------------------------------");
        System.out.println("Danh sách sản phẩm: ");
        for (String key: dsChiTietDonHang.keySet()){
            System.out.println("-----------");
            dsChiTietDonHang.get(key).getSanPham().xuatTTSP();
        }
    }
//    thành tiền
    public double thanhTien(){
        double tongTien = 0;
        for (String key: dsChiTietDonHang.keySet()){
            tongTien += dsChiTietDonHang.get(key).getSanPham().getGiaBan()* dsChiTietDonHang.get(key).getSanPham().getSoLuong();
        }
        return tongTien;
    }
//    tiền lời từ mỗi đơn hàng
    public double tienLoi(){
        double tongTien = 0;
        for (String key: dsChiTietDonHang.keySet()){
            tongTien += dsChiTietDonHang.get(key).getSanPham().getGiaBan() - dsChiTietDonHang.get(key).getSanPham().getGiaNhap();
        }
        return tongTien;
    }
}
