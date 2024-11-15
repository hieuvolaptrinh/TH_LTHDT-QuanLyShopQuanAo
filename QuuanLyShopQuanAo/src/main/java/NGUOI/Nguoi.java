package NGUOI;

public abstract class Nguoi {
    protected String CCCD;
    protected String hoTen;
    protected String soDienThoai;
    protected String email;
    protected String diaChi;

    public Nguoi(String maNguoi, String hoTen, String soDienThoai,String email, String diaChi) {
        this.CCCD = maNguoi;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }
}
