package SANPHAM;

public class QuanAo extends SanPham {
    private String size;
    private String mauSac;

    public QuanAo(String maSanPham, String tenSanPham, double giaBan, String size, String mauSac) {
        super(maSanPham, tenSanPham, giaBan);
        this.size = size;
        this.mauSac = mauSac;
    }
}

