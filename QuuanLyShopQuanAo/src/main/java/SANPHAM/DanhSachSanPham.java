package SANPHAM;

import INTERFACE.File;

import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DanhSachSanPham implements File {
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
    public void docFileVaThemSanPham() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try (BufferedReader br = new BufferedReader(new FileReader(docSanPham))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length >= 14) {
                    try {
                        String loaiSanPham = data[0].trim();
                        String maSanPham = data[1].trim();
                        String tenSanPham = data[2].trim();
                        double giaNhap = Double.parseDouble(data[3].trim());
                        double giaBan = Double.parseDouble(data[4].trim());
                        Date ngaySanXuat = dateFormat.parse(data[5].trim());
                        int soLuong = Integer.parseInt(data[6].trim());
                        String chatLieu = data[7].trim();
                        String moTa = data[8].trim();
                        boolean trangThai = Boolean.parseBoolean(data[9].trim());
                        String mauSac = data[10].trim();

                        SanPham sanPham = null;

                        switch (loaiSanPham) {
                            case "QuanAo":
                                sanPham = new QuanAo(maSanPham, tenSanPham, giaNhap, giaBan, ngaySanXuat, soLuong, chatLieu, moTa, trangThai, mauSac, data[11].trim(), data[12].trim(), data[13].trim());
                                break;
                            case "PhuKien":
                                sanPham = new PhuKien(maSanPham, tenSanPham, giaNhap, giaBan, ngaySanXuat, soLuong, chatLieu, moTa, trangThai, mauSac, data[11].trim());
                                break;
                            case "GiayDep":
                                sanPham = new GiayDep(maSanPham, tenSanPham, giaNhap, giaBan, ngaySanXuat, soLuong, chatLieu, moTa, trangThai, mauSac, data[11].trim(), Integer.parseInt(data[12].trim()));
                                break;
                            default:
                                System.out.println("Loại sản phẩm không hợp lệ: " + loaiSanPham);
                                continue;
                        }

                        themSanPhamVaoDanhSach(sanPham);

                    } catch (ParseException e) {
                        System.out.println("Lỗi định dạng ngày: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi định dạng số: " + e.getMessage());
                    }
                } else {
                    System.out.println("Dòng dữ liệu không hợp lệ (thiếu thông tin): " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    // Thêm sản phẩm vào danh sách và kiểm tra trùng lặp
    private void themSanPhamVaoDanhSach(SanPham sanPham) {
        if (danhSachSanPham.containsKey(sanPham.getMaSanPham())) {
            System.out.println("Mã sản phẩm đã tồn tại: " + sanPham.getMaSanPham());
        } else {
            danhSachSanPham.put(sanPham.getMaSanPham(), sanPham);
            System.out.println("Thêm sản phẩm: " + sanPham.getTenSanPham() + " thành công!");
        }
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
