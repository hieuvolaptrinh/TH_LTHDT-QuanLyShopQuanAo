package SANPHAM;

public class GiayDep extends SanPham {

    private int sizeGiay;


    public GiayDep(String maSanPham, String tenSanPham, double giaBan, int sizeGiay) {
        super(maSanPham, tenSanPham, giaBan);
        this.sizeGiay = sizeGiay;
    }

}
