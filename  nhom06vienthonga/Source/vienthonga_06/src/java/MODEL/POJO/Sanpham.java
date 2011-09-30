package MODEL.POJO;
// Generated Sep 30, 2011 4:04:39 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Sanpham generated by hbm2java
 */
public class Sanpham  implements java.io.Serializable {


     private String maSanPham;
     private Hang hang;
     private Loaisanpham loaisanpham;
     private String tenSanPham;
     private Float giaBan;
     private String mauSac;
     private String thoiGianBaoHanh;
     private String kichThuoc;
     private String trongLuong;
     private Integer tinhTrang;
     private Set chitietdonhangs = new HashSet(0);
     private Set hinhanhsanphams = new HashSet(0);
     private Set giamgias = new HashSet(0);
     private Set chitietlaptops = new HashSet(0);
     private Set chitietdienthoais = new HashSet(0);

    public Sanpham() {
    }

	
    public Sanpham(String maSanPham) {
        this.maSanPham = maSanPham;
    }
    public Sanpham(String maSanPham, Hang hang, Loaisanpham loaisanpham, String tenSanPham, Float giaBan, String mauSac, String thoiGianBaoHanh, String kichThuoc, String trongLuong, Integer tinhTrang, Set chitietdonhangs, Set hinhanhsanphams, Set giamgias, Set chitietlaptops, Set chitietdienthoais) {
       this.maSanPham = maSanPham;
       this.hang = hang;
       this.loaisanpham = loaisanpham;
       this.tenSanPham = tenSanPham;
       this.giaBan = giaBan;
       this.mauSac = mauSac;
       this.thoiGianBaoHanh = thoiGianBaoHanh;
       this.kichThuoc = kichThuoc;
       this.trongLuong = trongLuong;
       this.tinhTrang = tinhTrang;
       this.chitietdonhangs = chitietdonhangs;
       this.hinhanhsanphams = hinhanhsanphams;
       this.giamgias = giamgias;
       this.chitietlaptops = chitietlaptops;
       this.chitietdienthoais = chitietdienthoais;
    }
   
    public String getMaSanPham() {
        return this.maSanPham;
    }
    
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }
    public Hang getHang() {
        return this.hang;
    }
    
    public void setHang(Hang hang) {
        this.hang = hang;
    }
    public Loaisanpham getLoaisanpham() {
        return this.loaisanpham;
    }
    
    public void setLoaisanpham(Loaisanpham loaisanpham) {
        this.loaisanpham = loaisanpham;
    }
    public String getTenSanPham() {
        return this.tenSanPham;
    }
    
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
    public Float getGiaBan() {
        return this.giaBan;
    }
    
    public void setGiaBan(Float giaBan) {
        this.giaBan = giaBan;
    }
    public String getMauSac() {
        return this.mauSac;
    }
    
    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    public String getThoiGianBaoHanh() {
        return this.thoiGianBaoHanh;
    }
    
    public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }
    public String getKichThuoc() {
        return this.kichThuoc;
    }
    
    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }
    public String getTrongLuong() {
        return this.trongLuong;
    }
    
    public void setTrongLuong(String trongLuong) {
        this.trongLuong = trongLuong;
    }
    public Integer getTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public Set getChitietdonhangs() {
        return this.chitietdonhangs;
    }
    
    public void setChitietdonhangs(Set chitietdonhangs) {
        this.chitietdonhangs = chitietdonhangs;
    }
    public Set getHinhanhsanphams() {
        return this.hinhanhsanphams;
    }
    
    public void setHinhanhsanphams(Set hinhanhsanphams) {
        this.hinhanhsanphams = hinhanhsanphams;
    }
    public Set getGiamgias() {
        return this.giamgias;
    }
    
    public void setGiamgias(Set giamgias) {
        this.giamgias = giamgias;
    }
    public Set getChitietlaptops() {
        return this.chitietlaptops;
    }
    
    public void setChitietlaptops(Set chitietlaptops) {
        this.chitietlaptops = chitietlaptops;
    }
    public Set getChitietdienthoais() {
        return this.chitietdienthoais;
    }
    
    public void setChitietdienthoais(Set chitietdienthoais) {
        this.chitietdienthoais = chitietdienthoais;
    }




}


