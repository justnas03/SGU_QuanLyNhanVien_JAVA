package DMNV;

public class Nhanvien {

	
	private static String ho_ten;
	private static String ngay_sinh;
	private static String dia_chi;
	private static String sdt;
	private static String bangcap;
	
	public Nhanvien() {
		
	}
	public Nhanvien(String ho_ten, String ngay_sinh, String dia_chi, String sdt, String bangcap) {
		this.ho_ten = ho_ten;
		this.ngay_sinh = ngay_sinh;
		this.dia_chi = dia_chi;
		this.sdt = sdt;
		this.bangcap = bangcap;
	}
	
	public static String getHo_ten() {
		return ho_ten;
	}
	public static void setHo_ten(String ho_ten) {
		Nhanvien.ho_ten = ho_ten;
	}
	
	public static String getNgay_sinh() {
		return ngay_sinh;
	}
	public static void setNgay_sinh(String ngay_sinh) {
		Nhanvien.ngay_sinh = ngay_sinh;
	}
	public static String getDia_chi() {
		return dia_chi;
	}
	public static void setDia_chi(String dia_chi) {
		Nhanvien.dia_chi = dia_chi;
	}
	public static String getSdt() {
		return sdt;
	}
	public static void setSdt(String sdt) {
		Nhanvien.sdt = sdt;
	}
	public static String getBangcap() {
		return bangcap;
	}
	public static void setBangcap(String bangcap) {
		Nhanvien.bangcap = bangcap;
	}
	
	
	
}
