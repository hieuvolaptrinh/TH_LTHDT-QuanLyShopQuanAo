package NHANVIEN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LichLamViec {
    private Date ngayLamViec;
    private String caLamViec;

    //Constructor
    public LichLamViec(Date ngayLamViec, String caLamViec) {
        this.ngayLamViec = ngayLamViec;
        this.caLamViec = caLamViec;
    }

    public LichLamViec() {
    }
//Getter and Setter

    public Date getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(Date ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public String getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(String caLamViec) {
        this.caLamViec = caLamViec;
    }

    //đăng kí lịch làm việc
    public void DangKiLichLamViec() {
//        Scanner sc = new Scanner(System.in);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println("Nhập ngày làm việc dd/MM/yyyy : ");
//        String ngay = sc.nextLine();
//        try {
//            this.ngayLamViec = sdf.parse(ngay);
//        } catch (ParseException e) {
//            System.out.println("Ngày làm việc không hợp lệ.");
//            e.printStackTrace();
//        }
//        System.out.println("Nhập ca làm việc: ");
//        int luaChon = 0;
//        do {
//            System.out.println("1. Sáng (7h-11h)");
//            System.out.println("2. Chiều (13h-17h)");
//            System.out.println("3. Tăng ca Tối  (19h-23h)");
//            System.out.print("Chọn ca làm việc: ");
//            luaChon = sc.nextInt();
//            sc.nextLine();
//            switch (luaChon) {
//                case 1:
//                    this.caLamViec = "Sáng";
//                    break;
//                case 2:
//                    this.caLamViec = "Chiều";
//                    break;
//                case 3:
//                    this.caLamViec = "Tối";
//                    break;
//                default:
//                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
//                    break;
//            }
//        } while (luaChon < 1 || luaChon > 3);
    }

    //    int lịch làm việc
    public void InThongTin() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("-------------------------");
        System.out.println("Ngày làm việc : " + sdf.format(this.ngayLamViec));
        System.out.println("Ca làm việc : " + this.caLamViec);
    }
}
