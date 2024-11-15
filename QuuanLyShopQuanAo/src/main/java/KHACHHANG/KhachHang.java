package KHACHHANG;

import NGUOI.Nguoi;

import java.util.ArrayList;
import java.util.List;

public class KhachHang extends Nguoi {
    private int diemTichLuy;
    private List<String> lichSuMuaHang;

    public KhachHang(String CCCD, String hoTen, String soDienThoai,String email, String diaChi, int diemTichLuy) {
        super(CCCD, hoTen, soDienThoai,email, diaChi);
        this.diemTichLuy = diemTichLuy;
        this.lichSuMuaHang = new ArrayList<>();
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void themLichSuMuaHang(String donHang) {
        lichSuMuaHang.add(donHang);
    }

    public List<String> getLichSuMuaHang() {
        return lichSuMuaHang;
    }
}
