package NHANVIEN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class NhanVienToanThoiGian extends NhanVien {
    private final static double luongCoBan = 1500000;
    private final static double phuCap = 200000;
    private double heSoLuong;
    private final   static double baoHiem=250000;
    private int soCaTangCa;
    private int soNgayNghi;
    private Date ngayVaoLamViec;

    //Constructor
    public NhanVienToanThoiGian(String CCCD, String hoTen, String soDienThoai, String gioiTinh, String email, String diaChi, String maNhanVien, Date ngayVaoLamViec, double heSoLuong,  int soCaTangCa, int soNgayNghi) {
        super(CCCD, hoTen, soDienThoai, gioiTinh, email, diaChi, maNhanVien);
        this.heSoLuong = heSoLuong;

        this.ngayVaoLamViec = ngayVaoLamViec;
        this.soCaTangCa = soCaTangCa;
        this.soNgayNghi = soNgayNghi;
    }

    public NhanVienToanThoiGian() {
        this.soCaTangCa = 0;
        this.soNgayNghi = 0;
    }

//Getter and Setter


    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double getBaoHiem() {
        return baoHiem;
    }


    public int getSoCaTangCa() {
        return soCaTangCa;
    }

    public void setSoCaTangCa(int soCaTangCa) {
        this.soCaTangCa = soCaTangCa;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public Date getNgayVaoLamViec() {
        return ngayVaoLamViec;
    }

    public void setNgayVaoLamViec(Date ngayVaoLamViec) {
        this.ngayVaoLamViec = ngayVaoLamViec;
    }

    //Các phương thức
    @Override
    public void NhapThongTin() {
        super.NhapThongTin();
        // Nhập ngày vào làm việc
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Kiểm tra chặt chẽ định dạng ngày
        while (true) {
            try {
                System.out.println("Nhập bắt đầu làm việc (dd/MM/yyyy):");
                String inputngayVaoLamViec = sc.nextLine();
                this.ngayVaoLamViec = dateFormat.parse(inputngayVaoLamViec);
                break; // Thoát vòng lặp nếu nhập đúng
            } catch (ParseException e) {
                System.out.println("Ngày làm việc không hợp lệ. Vui lòng nhập lại!");
            }
        }
        System.out.println("Nhập hệ số lương :");
        this.heSoLuong = sc.nextDouble();


    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Tiền bảo hiểm : " + this.baoHiem);
        System.out.println("Phụ cấp : " + TinhPhuCap());
        System.out.println("Tiền tăng ca : " + this.soCaTangCa);
        System.out.println("Tổng lương : " + TongLuong());
    }

    public double TinhPhuCap() {
        return (LocalDate.now().getYear() - getNgayVaoLamViec().getYear()) * phuCap;
    }

    @Override
    public double TienPhat() {
        return this.soNgayNghi * 450000;
    }

    @Override
    public double LuongTangCa() {
        return this.soCaTangCa * 200000;
    }

    @Override
    public double TongLuong() {

        return this.heSoLuong * luongCoBan + TinhPhuCap() + LuongTangCa() - this.baoHiem - TienPhat();
    }

    //    đăng kí tăng ca
    public void DangKiTangCa() {
        System.out.println("bạn có muốn đăng kí tăng ca không? (Có/Không)");
        int luaChon = 0;
        do {
            System.out.println("1. Có");
            System.out.println("2. Không");
            System.out.print("Chọn: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.println("Nhập số ca tăng ca :");
                    int soCaTangCa = sc.nextInt();
                    this.soCaTangCa += soCaTangCa;
                    break;
                case 2:
                    System.out.println("Không đăng kí tăng ca.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (luaChon < 1 || luaChon > 2);
    }
}
