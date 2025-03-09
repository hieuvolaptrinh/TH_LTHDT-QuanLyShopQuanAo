package CHECKTHONGTIN;

public class CheckThongTin {
    // Hàm kiểm tra tính hợp lệ của email
    public static boolean checkEmail(String email) {
        return email.matches("^[a-zA-Z][\\w.-]*@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean checkSoDienThoai(String sdt) {
        return sdt.matches("\\d{10,11}");
    }

    public static boolean kiemTraCCCD(String cccd) {
        if (cccd == null || cccd.length() != 12) return false;
        for (char c : cccd.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
