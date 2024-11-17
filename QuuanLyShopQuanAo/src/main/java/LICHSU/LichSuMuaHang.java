package LICHSU;

import DONHANG.DonHang;

import java.text.ParseException; // xử lý lỗi khi làm việc với date
import java.text.SimpleDateFormat;
import java.util.Date;

public class LichSuMuaHang {
    private DonHang donHang;
    private Date thoiGianMua;

    // Constructor mặc định
    public LichSuMuaHang() {
        this.donHang = null;
        this.thoiGianMua = null;
    }

    // Constructor với thông tin đơn hàng
    public LichSuMuaHang(DonHang donHang) {
        this.donHang = donHang;
        this.thoiGianMua =new Date();
    }




    public Date getThoiGianMua() {
        return thoiGianMua;
    }

    // Phương thức chuyển đổi String sang Date
    private Date parseDate(String ngayDat) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(ngayDat);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Phương thức hiển thị thông tin lịch sử mua hàng
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String ngayMua = (thoiGianMua != null) ? formatter.format(thoiGianMua) : "N/A";
        String donHangInfo = (donHang != null) ? donHang.toString() : "Không có thông tin đơn hàng";

        return "Thời gian mua: " + ngayMua +
                "\nThông tin đơn hàng:\n" + donHangInfo;
    }

    // Phương thức in ra lịch sử mua hàng
    public void inLichSuMuaHang() {
        // Kiểm tra xem thông tin đơn hàng và thời gian mua có hợp lệ không
        if (donHang != null && thoiGianMua != null) {
            System.out.println(this.toString()); // Gọi phương thức toString() để hiển thị thông tin
        } else {
            System.out.println("Lịch sử mua hàng không có thông tin.");
        }
    }
}
