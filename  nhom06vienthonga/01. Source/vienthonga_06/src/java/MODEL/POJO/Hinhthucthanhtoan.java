package MODEL.POJO;
// Generated Oct 13, 2011 8:14:39 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Hinhthucthanhtoan generated by hbm2java
 */
public class Hinhthucthanhtoan  implements java.io.Serializable {


     private String maHinhThucThanhToan;
     private String tenHinhThucThanhToan;
     private String noiDungThanhToan;
     private Integer tinhTrang;
     private Set donhangs = new HashSet(0);

    public Hinhthucthanhtoan() {
    }

	
    public Hinhthucthanhtoan(String maHinhThucThanhToan) {
        this.maHinhThucThanhToan = maHinhThucThanhToan;
    }
    public Hinhthucthanhtoan(String maHinhThucThanhToan, String tenHinhThucThanhToan, String noiDungThanhToan, Integer tinhTrang, Set donhangs) {
       this.maHinhThucThanhToan = maHinhThucThanhToan;
       this.tenHinhThucThanhToan = tenHinhThucThanhToan;
       this.noiDungThanhToan = noiDungThanhToan;
       this.tinhTrang = tinhTrang;
       this.donhangs = donhangs;
    }
   
    public String getMaHinhThucThanhToan() {
        return this.maHinhThucThanhToan;
    }
    
    public void setMaHinhThucThanhToan(String maHinhThucThanhToan) {
        this.maHinhThucThanhToan = maHinhThucThanhToan;
    }
    public String getTenHinhThucThanhToan() {
        return this.tenHinhThucThanhToan;
    }
    
    public void setTenHinhThucThanhToan(String tenHinhThucThanhToan) {
        this.tenHinhThucThanhToan = tenHinhThucThanhToan;
    }
    public String getNoiDungThanhToan() {
        return this.noiDungThanhToan;
    }
    
    public void setNoiDungThanhToan(String noiDungThanhToan) {
        this.noiDungThanhToan = noiDungThanhToan;
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


