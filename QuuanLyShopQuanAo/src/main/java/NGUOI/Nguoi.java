package NGUOI;

import CHECKTHONGTIN.CheckThongTin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Nguoi {
    Scanner sc = new Scanner(System.in);
    protected String CCCD;
    protected String hoTen;
    protected String soDienThoai;
    protected String gioiTinh;
    protected Date ngaySinh;
    protected String email;
    protected String diaChi;
    // Constructor
    public Nguoi(String CCCD, String hoTen, String soDienThoai, String gioiTinh,Date ngaySinh, String email, String diaChi) {
        this.CCCD = CCCD;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.diaChi = diaChi;
    }
//Getter and Setter

    public Nguoi() {
    }
    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    //Các phương thức
    public void nhapThongTin(){
        System.out.print("Nhập căn cước công dân: ");
        do{
            this.CCCD = sc.nextLine();
            if(!CheckThongTin.kiemTraCCCD(this.CCCD)){
                System.err.println("Căn cước công dân không hợp lệ. Vui lòng nhập lại. Căn cước phải đủ 12 số ");
            }
        }while(!CheckThongTin.kiemTraCCCD(this.CCCD));
        System.out.print("Nhập họ và tên: ");
        this.hoTen = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        do {
            this.soDienThoai = sc.nextLine();
            if(!CheckThongTin.checkSoDienThoai(this.soDienThoai)){
                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại. Số điện phải phải đủ 10 hoặc 11 số ");
            }
        }while (!CheckThongTin.checkSoDienThoai(this.soDienThoai));
        System.out.print("Nhập giới tính: ");
        this.gioiTinh = sc.nextLine();
        // Nhập ngày sinh
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Kiểm tra chặt chẽ định dạng ngày
        while (true) {
            try {
                System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                String inputNgaySinh = sc.nextLine();
                this.ngaySinh = dateFormat.parse(inputNgaySinh);
                break; // Thoát vòng lặp nếu nhập đúng
            } catch (ParseException e) {
                System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập lại!");
            }
        }
        System.out.print("Nhập địa chỉ email (vd:example@gmail.com): ");
        do {
            this.email = sc.nextLine();
            if(!CheckThongTin.checkEmail(this.email)){
                System.out.println("Email không hợp lệ. Email phải tuân thủ các quy tắc sau: "
                        + "\n1. Bắt đầu bằng một chữ cái (a-z hoặc A-Z)."
                        + "\n2. Chứa ký tự '@' ngăn cách giữa phần tên người dùng và tên miền."
                        + "\n3. Phần sau '@' phải là một tên miền hợp lệ (ví dụ: 'gmail.com')."
                        + "\n4. Tên miền phải có ít nhất 2 ký tự sau dấu '.' (ví dụ: '.com')."
                        + "\nVui lòng nhập lại.");
            }
        }while (!CheckThongTin.checkEmail(this.email));
        System.out.print("Nhập địa chỉ: ");
        this.diaChi = sc.nextLine();
    }
    public void inThongTin(){
        System.out.println("Căn cước công dân: "+this.CCCD);
        System.out.println("Họ và tên: "+this.hoTen);
        System.out.println("Số điện thoại: "+this.soDienThoai);
        System.out.println("Giới tính: "+this.gioiTinh);
        System.out.println("Email: "+this.email);
        System.out.println("Địa chỉ: "+this.diaChi);
    }
}
