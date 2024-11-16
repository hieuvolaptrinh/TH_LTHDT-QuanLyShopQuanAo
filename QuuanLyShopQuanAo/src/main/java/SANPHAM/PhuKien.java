package SANPHAM;

public class PhuKien extends SanPham{
    private String loaiPhuKien;
    private String thuongHieu;
    private String chatLieu;

    public PhuKien(String maSanPham, String tenSanPham, double giaBan, int soLuong, String moTa, boolean trangThai, double giamGia, String loaiPhuKien, String thuongHieu, String chatLieu) {
        super(maSanPham, tenSanPham, giaBan, soLuong, moTa, trangThai, giamGia);
        this.loaiPhuKien = loaiPhuKien;
        this.thuongHieu = thuongHieu;
        this.chatLieu = chatLieu;
    }

    public String getLoaiPhuKien() {
        return loaiPhuKien;
    }

    public void setLoaiPhuKien(String loaiPhuKien) {
        this.loaiPhuKien = loaiPhuKien;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }
}
