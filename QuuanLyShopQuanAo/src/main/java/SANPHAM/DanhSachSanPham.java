package SANPHAM;

import java.util.HashMap;
import java.util.Scanner;

public class DanhSachSanPham {
    Scanner sc = new Scanner(System.in);
    private HashMap<String, SanPham> danhSachSanPham;

    public DanhSachSanPham() {
        this.danhSachSanPham = new HashMap<>();
    }

    public HashMap<String, SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(HashMap<String, SanPham> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }

    //    nhập sản phẩm
    public void nhapDSSanPham(){
        int luaChon;
        do {
            System.out.println("1. Quần áo");
            System.out.println("2. Giày dép");
            System.out.println("3. Phụ kiện");
            System.out.println("4. Thoát");
            System.out.print("Chọn loại sản phẩm: ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Xử lý ký tự xuống dòng còn sót lại
            switch (luaChon) {
                case 1:
                    QuanAo quanAo = new QuanAo();
                    quanAo.nhapTTSP();
                    danhSachSanPham.put(quanAo.getMaSanPham(), quanAo);
                    break;
                case 2:
                    GiayDep giayDep = new GiayDep();
                    giayDep.nhapTTSP();
                    danhSachSanPham.put(giayDep.getMaSanPham(), giayDep);
                    break;
                case 3:
                    PhuKien phuKien = new PhuKien();
                    phuKien.nhapTTSP();
                    danhSachSanPham.put(phuKien.getMaSanPham(), phuKien);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (luaChon != 4);
    }

    //    xuất quần áo
    public void xuatQuanAo(){
        System.out.println("Danh sách quần áo");
        for (SanPham sanPham : danhSachSanPham.values()) {
            if (sanPham instanceof QuanAo) {
                QuanAo quanAo = (QuanAo) sanPham;
                quanAo.xuatTTSP();
            }
        }
    }
    //    xuất giày dép
    public void xuatGiayDep(){
        System.out.println("Danhs sách giày dép");
        for (SanPham sanPham : danhSachSanPham.values()) {
            if (sanPham instanceof GiayDep) {
                GiayDep giayDep = (GiayDep) sanPham;
                giayDep.xuatTTSP();
            }
        }
    }
    //    xuất phụ kiện
    public void xuatPhuKien(){
        System.out.println("Danh sách phụ kiện");

        for (SanPham sanPham : danhSachSanPham.values()) {
            if (sanPham instanceof PhuKien) {
                PhuKien phuKien = (PhuKien) sanPham;
                phuKien.xuatTTSP();
            }
        }
    }
    //    xuất danh sách sản phẩm
    public void xuatDSSanPham(){
        System.out.println("Danh sách tất cả sản phẩm");
        if (danhSachSanPham.isEmpty()) {
            System.out.println(" --------Không có sản phẩm nào--------");
            return;
        }
        this.xuatGiayDep();
        this.xuatQuanAo();
        this.xuatPhuKien();

    }
    //tổng tiền nhập sản phẩm mới
    public void tongTienNhapSanPham(){
        double tongTien = 0;
        for (SanPham sanPham : danhSachSanPham.values()) {
            tongTien += sanPham.tinhTienNhapSanPham();
        }
        System.out.println("Tổng tiền nhập sản phẩm mới: " + tongTien);
    }

}
