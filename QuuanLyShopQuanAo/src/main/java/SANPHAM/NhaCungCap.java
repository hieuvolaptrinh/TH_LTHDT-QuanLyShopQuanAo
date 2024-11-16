package SANPHAM;

public class NhaCungCap {
    private String quocGia;
    private String tenCongTy;
    private String diaChi;

    public NhaCungCap(String quocGia, String tenCongTy, String diaChi) {
        this.quocGia = quocGia;
        this.tenCongTy = tenCongTy;
        this.diaChi = diaChi;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
