package NHANVIEN;

import java.util.ArrayList;

public class NhanVienBanThoigian extends NhanVien {
    private final static double luongTheoGio = 25000;
    private final static double luongTangCa = 35000;
    private double soGioLam;
    private double soGioLamTangCa;
    private double soGioNghi;
    ArrayList<LichLamViec> lichLamViecs;
//Constructor

    public NhanVienBanThoigian(String CCCD, String hoTen, String soDienThoai, String gioiTinh, String email, String diaChi, String maNhanVien, double soGioLam, double soGioLamTangCa, double soGioNghi, ArrayList<LichLamViec> lichLamViecs) {
        super(CCCD, hoTen, soDienThoai, gioiTinh, email, diaChi, maNhanVien);
        this.soGioLam = soGioLam;
        this.soGioLamTangCa = soGioLamTangCa;
        this.soGioNghi = soGioNghi;
        this.lichLamViecs = new ArrayList<>();
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
    @Override
    public void NhapThongTin() {
        super.NhapThongTin();
        System.out.println("");
        System.out.println("Bạn có muốn đăng kí lịch làm việc không? (Có/Không)");
        int luaChon = 0;
        do {
            System.out.println("1. Có");
            System.out.println("2. Không");
            System.out.print("Chọn: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    DangKiLichLamViec();
                    break;
                case 2:
                    System.out.println("Không đăng kí lịch làm việc.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (luaChon < 1 || luaChon > 2);

        double gioLam = 0, gioLamTangCa = 0, gioNghi = 0;
        for (LichLamViec lichLamViec : lichLamViecs) {
            if (lichLamViec.getCaLamViec().equals("Sáng")) {
                gioLam += 4;
            } else if (lichLamViec.getCaLamViec().equals("Chiều")) {
                gioLam += 4;
            } else {
                gioLamTangCa += 4;
            }
        }
        this.soGioLam = gioLam;
        this.soGioLamTangCa = gioLamTangCa;
        this.soGioNghi = gioNghi;
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Lịch làm việc : ");
        for (LichLamViec lichLamViec : lichLamViecs) {
            lichLamViec.InThongTin();
        }
        System.out.println("Số giờ làm: " + this.soGioLam);
        System.out.println("Số giờ làm tăng ca: " + this.soGioLamTangCa);
        System.out.println("Số giờ nghỉ: " + this.soGioNghi);

    }

    public void DangKiLichLamViec() {

        int luaChon = 0;
        do {
            LichLamViec lichLamViec = new LichLamViec();
            System.out.println(("1. Đăng kí lịch làm việc"));
            System.out.println("2. Không đăng kí lịch làm việc");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    lichLamViec.DangKiLichLamViec();
                    lichLamViecs.add(lichLamViec);
                    break;
                case 2:
                    System.out.println("Không đăng kí lịch làm việc.");
                    return;
                case 3:
                    System.out.println("Thoát.");
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
}
