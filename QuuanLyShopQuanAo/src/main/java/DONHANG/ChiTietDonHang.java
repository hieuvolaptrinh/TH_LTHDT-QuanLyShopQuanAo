package DONHANG;

import SANPHAM.GiayDep;
import SANPHAM.PhuKien;
import SANPHAM.QuanAo;
import SANPHAM.SanPham;

import java.util.Scanner;

public class ChiTietDonHang {
    Scanner sc = new Scanner(System.in);
    private SanPham sanPham;
    private int soLuong;

    public ChiTietDonHang(SanPham sanPham, int soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }
    public ChiTietDonHang() {
    }


    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double tinhTien() {
        return sanPham.getGiaBan() * soLuong;
    }
    public void themChiTietDonHang(SanPham sanPham, int soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }
    //    tạo chi tietDonhang
    public void themChiTietDonHang() {
        SanPham sp = null;
        int luaChon;
        do {
            System.out.println("1. Quần áo");
            System.out.println("2. Giày dép");
            System.out.println("3. Phụ kiện");
            System.out.print("Chọn loại sản phẩm: ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Xử lý ký tự xuống dòng còn sót lại

            switch (luaChon) {
                case 1:
                    sp = new QuanAo();
                    break;
                case 2:
                    sp = new GiayDep();
                    break;
                case 3:
                    sp = new PhuKien();
                    break;
                default:
                    System.out.println("Nhập sai! Vui lòng chọn lại.");
            }
        } while (luaChon < 1 || luaChon > 3);

        if (sp != null) {
            sp.nhapTTSP(); // Nhập thông tin sản phẩm sau khi đã chọn đúng
        }
        this.sanPham = sp;
        System.out.println("Nhập số lượng: ");
        int sl = sc.nextInt();
        do {
            if (sl <= 0) {
                System.out.println("Số lượng phải lớn hơn 0. Vui lòng nhập lại!");
            }
        } while (sl <= 0);
        this.soLuong = sl;
    }
//    in chi tiết đơn hàng
    public void inChiTietDonHang() {
        sanPham.xuatTTSP();
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Thành tiền: " + tinhTien());
    }

}

