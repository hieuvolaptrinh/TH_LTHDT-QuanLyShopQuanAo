package PHUONGTHUCTHANHTOAN;

public class ThongTInThanhToan {
    public class ThongTinThanhToan {
        private String hinhThucThanhToan;
        private String trangThaiThanhToan;
        private String maThanhToan; // Thêm mã thanh toán
        private double tongTien; // Thêm tổng tiền thanh toán

        // Constructor không tham số
        public ThongTinThanhToan() {
            this.hinhThucThanhToan = "";
            this.trangThaiThanhToan = "Chưa thanh toán";
            this.maThanhToan = "Unknown"; // Mặc định cho mã thanh toán
            this.tongTien = 0.0; // Mặc định cho tổng tiền
        }

        // Constructor có tham số
        public ThongTinThanhToan(String hinhThucThanhToan, String trangThaiThanhToan, String maThanhToan, double tongTien) {
            this.hinhThucThanhToan = hinhThucThanhToan;
            this.trangThaiThanhToan = trangThaiThanhToan;
            this.maThanhToan = maThanhToan;
            this.tongTien = tongTien;
        }

        // Getter và Setter cho hinhThucThanhToan
        public String getHinhThucThanhToan() {
            return hinhThucThanhToan;
        }

        public void setHinhThucThanhToan(String hinhThucThanhToan) {
            this.hinhThucThanhToan = hinhThucThanhToan;
        }

        // Getter và Setter cho trangThaiThanhToan
        public String getTrangThaiThanhToan() {
            return trangThaiThanhToan;
        }

        public void setTrangThaiThanhToan(String trangThaiThanhToan) {
            this.trangThaiThanhToan = trangThaiThanhToan;
        }

        // Getter và Setter cho maThanhToan
        public String getMaThanhToan() {
            return maThanhToan;
        }

        public void setMaThanhToan(String maThanhToan) {
            this.maThanhToan = maThanhToan;
        }

        // Getter và Setter cho tongTien
        public double getTongTien() {
            return tongTien;
        }

        public void setTongTien(double tongTien) {
            if (tongTien >= 0) {
                this.tongTien = tongTien;
            } else {
                throw new IllegalArgumentException("Tổng tiền không thể âm.");
            }
        }

        // Phương thức hiển thị thông tin thanh toán
        @Override
        public String toString() {
            return "Mã thanh toán: " + maThanhToan +
                    "\nHình thức thanh toán: " + hinhThucThanhToan +
                    "\nTrạng thái thanh toán: " + trangThaiThanhToan +
                    "\nTổng tiền:" + tongTien;
        }
    }
}
