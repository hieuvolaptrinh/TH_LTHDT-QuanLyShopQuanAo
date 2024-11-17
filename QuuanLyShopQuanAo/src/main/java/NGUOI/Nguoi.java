package NGUOI;

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
    public Nguoi(String CCCD, String hoTen, String soDienThoai, String gioiTinh, String email, String diaChi) {
        this.CCCD = CCCD;
        this.hoTen = hoTen;
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
        System.out.println("Nhập căn cước công dân :");
        this.CCCD = sc.nextLine();
        System.out.println("Nhập họ và tên :");
        this.hoTen = sc.nextLine();
        System.out.println("Nhập số điện thoại :");
        this.soDienThoai = sc.nextLine();
        System.out.println("Nhập giới tính :");
        this.gioiTinh = sc.nextLine();
        // Nhập ngày sinh
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Kiểm tra chặt chẽ định dạng ngày
        while (true) {
            try {
                System.out.println("Nhập ngày sinh (dd/MM/yyyy):");
                String inputNgaySinh = sc.nextLine();
                this.ngaySinh = dateFormat.parse(inputNgaySinh);
                break; // Thoát vòng lặp nếu nhập đúng
            } catch (ParseException e) {
                System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập lại!");
            }
        }
        System.out.println("Nhập địa chỉ email :");
        this.email = sc.nextLine();
        System.out.println("Nhập địa chỉ :");
        this.diaChi = sc.nextLine();
    }
    public void inThongTin(){
        System.out.println("Căn cước công dân : "+this.CCCD);
        System.out.println("Họ và tên : "+this.hoTen);
        System.out.println("Số điện thoại : "+this.soDienThoai);
        System.out.println("Giới tính : "+this.gioiTinh);
        System.out.println("Email : "+this.email);
        System.out.println("Địa chỉ : "+this.diaChi);
    }
}
