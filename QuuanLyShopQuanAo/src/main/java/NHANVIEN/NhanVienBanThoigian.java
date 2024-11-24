package NHANVIEN;

import CHECKTHONGTIN.CheckThongTin;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class NhanVienBanThoigian extends NhanVien {
    private final static double luongTheoGio = 25000;
    private final static double luongTangCa = 35000;
    private double soGioLam;
    private double soGioLamTangCa;
    private double soGioNghi;
    ArrayList<LichLamViec> lichLamViecs;
//Constructor


    public NhanVienBanThoigian(String CCCD, String hoTen, String soDienThoai, String gioiTinh, Date ngaySinh, String email, String diaChi, String maNhanVien, double soGioLam, double soGioLamTangCa, double soGioNghi, ArrayList<LichLamViec> lichLamViecs) {
        super(CCCD, hoTen, soDienThoai, gioiTinh, ngaySinh, email, diaChi, maNhanVien);
        this.soGioLam = soGioLam;
        this.soGioLamTangCa = soGioLamTangCa;
        this.soGioNghi = soGioNghi;
        this.lichLamViecs = new ArrayList<>();
    }

    public NhanVienBanThoigian(String CCCD, String hoTen, String soDienThoai, String gioiTinh, Date ngaySinh, String email, String diaChi, String maNhanVien) {
        super(CCCD, hoTen, soDienThoai, gioiTinh, ngaySinh, email, diaChi, maNhanVien);
    }

    public NhanVienBanThoigian() {
        super();
        this.soGioLam = 0;
        this.soGioLamTangCa = 0;
        this.soGioNghi = 0;
        this.lichLamViecs = new ArrayList<>();
    }

//Getter and Setter


    public double getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(double soGioLam) {
        this.soGioLam = soGioLam;
    }

    public double getSoGioLamTangCa() {
        return soGioLamTangCa;
    }

    public void setSoGioLamTangCa(double soGioLamTangCa) {
        this.soGioLamTangCa = soGioLamTangCa;
    }

    public double getSoGioNghi() {
        return soGioNghi;
    }

    public void setSoGioNghi(double soGioNghi) {
        this.soGioNghi = soGioNghi;
    }

    public ArrayList<LichLamViec> getLichLamViecs() {
        return lichLamViecs;
    }

    public void setLichLamViecs(ArrayList<LichLamViec> lichLamViecs) {
        this.lichLamViecs = lichLamViecs;
    }

    //Các phương thức
//    @Override
//    public void nhapThongTin() {
//        super.nhapThongTin();
//        System.out.println("");
//        System.out.println("Bạn có muốn đăng kí lịch làm việc cho nhân viên  không? (Có/Không)");
//        int luaChon = 0;
//        do {
//            System.out.println("1. Có");
//            System.out.println("2. Không");
//            System.out.print("Chọn: ");
//            luaChon = sc.nextInt();
//            sc.nextLine();
//            switch (luaChon) {
//                case 1:
//                    DangKiLichLamViec();
//                    break;
//                case 2:
//                    System.out.println("Không đăng kí lịch làm việc.");
//                    return;
//                default:
//                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
//                    break;
//            }
//        } while (luaChon < 1 || luaChon > 2);
//    }


    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.println("");
    }
    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Số giờ làm: " + this.soGioLam);
        System.out.println("Số giờ làm tăng ca: " + this.soGioLamTangCa);
        System.out.println("Số giờ nghỉ: " + this.soGioNghi);

    }
    public void InLichLamViec(){
        System.out.println("-------------------Lịch làm việc của nhân viên  " + this.getHoTen() + "-------------------");
        for (LichLamViec lichLamViec : lichLamViecs) {
            try {
                lichLamViec.InThongTin();
            } catch (Exception e) {
                // Xử lý hoặc bỏ qua ngoại lệ nếu có lỗi xảy ra
                System.out.println("Có lỗi xảy ra khi in thông tin lịch làm việc: " + e.getMessage());
                // Bạn có thể bỏ qua hoặc xử lý khác tùy theo yêu cầu
            }
        }
    }
    public void DangKiLichLamViec() {
        int luaChon = 0;
        do {
            System.out.println("1. Sáng (7h-11h)");
            System.out.println("2. Chiều (13h-17h)");
            System.out.println("3. Tăng ca Tối  (19h-23h)");
            System.out.print("Chọn ca làm việc: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.println("Nhập ngày làm việc dd/MM/yyyy : ");
                    String ngay = sc.nextLine();
                    LichLamViec lichLamViec = new LichLamViec();
                    try {
                        lichLamViec.setNgayLamViec(new SimpleDateFormat("dd/MM/yyyy").parse(ngay));
                    } catch (ParseException e) {
                        System.out.println("Ngày làm việc không hợp lệ.");
                        e.printStackTrace();
                    }
                    lichLamViec.setCaLamViec("Sáng");
                    lichLamViecs.add(lichLamViec);
                    this.soGioLam += 4;
                case 2:
                    System.out.println("Nhập ngày làm việc dd/MM/yyyy : ");
                    String ngay1 = sc.nextLine();
                    LichLamViec lichLamViec1 = new LichLamViec();
                    try {
                        lichLamViec1.setNgayLamViec(new SimpleDateFormat("dd/MM/yyyy").parse(ngay1));
                    } catch (ParseException e) {
                        System.out.println("Ngày làm việc không hợp lệ.");
                        e.printStackTrace();
                    }
                    lichLamViec1.setCaLamViec("Chiều");
                    lichLamViecs.add(lichLamViec1);
                    this.soGioLam += 4;
                    break;
                case 3:
                    System.out.println("Nhập ngày làm việc dd/MM/yyyy : ");
                    String ngay2 = sc.nextLine();
                    LichLamViec lichLamViec2 = new LichLamViec();
                    try {
                        lichLamViec2.setNgayLamViec(new SimpleDateFormat("dd/MM/yyyy").parse(ngay2));
                    } catch (ParseException e) {
                        System.out.println("Ngày làm việc không hợp lệ.");
                        e.printStackTrace();
                    }
                    lichLamViec2.setCaLamViec("Tối");
                    lichLamViecs.add(lichLamViec2);
                    this.soGioLam += 4;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (luaChon < 1 || luaChon > 3);

    }

    @Override
    public double TienPhat() {
        return this.soGioNghi * 25000;
    }

    @Override
    public double LuongTangCa() {
        return this.soGioLamTangCa * luongTangCa;
    }

    @Override
    public double TongLuong() {
        return this.soGioLam * luongTheoGio + LuongTangCa() - TienPhat();
    }

    //xuất lịch laàm việc thằng nhân veieen
    public void xuatFileLichLamViec() {
        String filePath = "D:/OneDrive - University of Technology and Education/Dai_hoc/2024-2025/th lthdt/Nhom5_THLTHDT_CK/QuuanLyShopQuanAo/src/main/resources/LichLamViec_" + this.getMaNhanVien() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            writer.write("Lịch làm việc của nhân viên: \n");
            for (LichLamViec lich : lichLamViecs) {
                writer.write("Ngày: " + sdf.format(lich.getNgayLamViec()) + ", Ca: " + lich.getCaLamViec());
                writer.newLine();
            }
            writer.write("Tổng số giờ làm: " + soGioLam);
            writer.newLine();
            writer.write("Tổng số giờ làm tăng ca: " + soGioLamTangCa);
            writer.newLine();
            writer.write("Tổng số giờ nghỉ: " + soGioNghi);
            writer.newLine();
            System.out.println("Lịch làm việc đã được lưu tại: " + filePath);
        } catch (IOException e) {
            System.err.println("Lỗi ghi file lịch làm việc: " + e.getMessage());
        }
    }

    //     in lịch làm việc
    public void inLichLamViec() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Lịch làm việc của nhân viên: ");
        for (LichLamViec lich : lichLamViecs) {
            System.out.println("Ngày: " + sdf.format(lich.getNgayLamViec()) + ", Ca: " + lich.getCaLamViec());
        }
        System.out.println("Tổng số giờ làm: " + soGioLam);
        System.out.println("Tổng số giờ làm tăng ca: " + soGioLamTangCa);
        System.out.println("Tổng số giờ nghỉ: " + soGioNghi);
    }

}

