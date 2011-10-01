package MODEL.POJO;
// Generated Sep 30, 2011 5:07:38 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Nguoidung generated by hbm2java
 */
public class Nguoidung  implements java.io.Serializable {


     private String maNguoiDung;
     private Loainguoidung loainguoidung;
     private String tenNguoiDung;
     private String email;
     private Integer cmnd;
     private Integer dienThoai;
     private String diaChi;
     private Date ngayDangKy;
     private Integer tinhTrang;
     private Set donhangs = new HashSet(0);

    public Nguoidung() {
    }

	
    public Nguoidung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }
    public Nguoidung(String maNguoiDung, Loainguoidung loainguoidung, String tenNguoiDung, String email, Integer cmnd, Integer dienThoai, String diaChi, Date ngayDangKy, Integer tinhTrang, Set donhangs) {
       this.maNguoiDung = maNguoiDung;
       this.loainguoidung = loainguoidung;
       this.tenNguoiDung = tenNguoiDung;
       this.email = email;
       this.cmnd = cmnd;
       this.dienThoai = dienThoai;
       this.diaChi = diaChi;
       this.ngayDangKy = ngayDangKy;
       this.tinhTrang = tinhTrang;
       this.donhangs = donhangs;
    }
   
    public String getMaNguoiDung() {
        return this.maNguoiDung;
    }
    
    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }
    public Loainguoidung getLoainguoidung() {
        return this.loainguoidung;
    }
    
    public void setLoainguoidung(Loainguoidung loainguoidung) {
        this.loainguoidung = loainguoidung;
    }
    public String getTenNguoiDung() {
        return this.tenNguoiDung;
    }
    
    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getCmnd() {
        return this.cmnd;
    }
    
    public void setCmnd(Integer cmnd) {
        this.cmnd = cmnd;
    }
    public Integer getDienThoai() {
        return this.dienThoai;
    }
    
    public void setDienThoai(Integer dienThoai) {
        this.dienThoai = dienThoai;
    }
    public String getDiaChi() {
        return this.diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public Date getNgayDangKy() {
        return this.ngayDangKy;
    }
    
    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }
    public Integer getTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public Set getDonhangs() {
        return this.donhangs;
    }
    
    public void setDonhangs(Set donhangs) {
        this.donhangs = donhangs;
    }




}

