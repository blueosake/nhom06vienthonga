package MODEL.POJO;
// Generated Oct 13, 2011 8:14:39 AM by Hibernate Tools 3.2.1.GA



/**
 * Chitietdonhang generated by hbm2java
 */
public class Chitietdonhang  implements java.io.Serializable {


     private String maChiTietDonHang;
     private Sanpham sanpham;
     private Donhang donhang;
     private Integer soLuong;
     private Float donGia;
     private Float giamGia;
     private Float thanhTien;
     private Integer trangThai;
     private Integer tinhTrang;

    public Chitietdonhang() {
    }

	
    public Chitietdonhang(String maChiTietDonHang) {
        this.maChiTietDonHang = maChiTietDonHang;
    }
    public Chitietdonhang(String maChiTietDonHang, Sanpham sanpham, Donhang donhang, Integer soLuong, Float donGia, Float giamGia, Float thanhTien, Integer trangThai, Integer tinhTrang) {
       this.maChiTietDonHang = maChiTietDonHang;
       this.sanpham = sanpham;
       this.donhang = donhang;
       this.soLuong = soLuong;
       this.donGia = donGia;
       this.giamGia = giamGia;
       this.thanhTien = thanhTien;
       this.trangThai = trangThai;
       this.tinhTrang = tinhTrang;
    }
   
    public String getMaChiTietDonHang() {
        return this.maChiTietDonHang;
    }
    
    public void setMaChiTietDonHang(String maChiTietDonHang) {
        this.maChiTietDonHang = maChiTietDonHang;
    }
    public Sanpham getSanpham() {
        return this.sanpham;
    }
    
    public void setSanpham(Sanpham sanpham) {
        this.sanpham = sanpham;
    }
    public Donhang getDonhang() {
        return this.donhang;
    }
    
    public void setDonhang(Donhang donhang) {
        this.donhang = donhang;
    }
    public Integer getSoLuong() {
        return this.soLuong;
    }
    
    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
    public Float getDonGia() {
        return this.donGia;
    }
    
    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }
    public Float getGiamGia() {
        return this.giamGia;
    }
    
    public void setGiamGia(Float giamGia) {
        this.giamGia = giamGia;
    }
    public Float getThanhTien() {
        return this.thanhTien;
    }
    
    public void setThanhTien(Float thanhTien) {
        this.thanhTien = thanhTien;
    }
    public Integer getTrangThai() {
        return this.trangThai;
    }
    
    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
    public Integer getTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }




}


