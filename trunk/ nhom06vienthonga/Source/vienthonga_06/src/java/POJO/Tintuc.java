package POJO;
// Generated Sep 30, 2011 2:20:10 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tintuc generated by hbm2java
 */
public class Tintuc  implements java.io.Serializable {


     private String maTinTuc;
     private String tenTinTuc;
     private String noiDungtTinTuc;
     private Date ngayDang;
     private Integer tinhTrang;
     private Set hinhanhtintucs = new HashSet(0);

    public Tintuc() {
    }

	
    public Tintuc(String maTinTuc) {
        this.maTinTuc = maTinTuc;
    }
    public Tintuc(String maTinTuc, String tenTinTuc, String noiDungtTinTuc, Date ngayDang, Integer tinhTrang, Set hinhanhtintucs) {
       this.maTinTuc = maTinTuc;
       this.tenTinTuc = tenTinTuc;
       this.noiDungtTinTuc = noiDungtTinTuc;
       this.ngayDang = ngayDang;
       this.tinhTrang = tinhTrang;
       this.hinhanhtintucs = hinhanhtintucs;
    }
   
    public String getMaTinTuc() {
        return this.maTinTuc;
    }
    
    public void setMaTinTuc(String maTinTuc) {
        this.maTinTuc = maTinTuc;
    }
    public String getTenTinTuc() {
        return this.tenTinTuc;
    }
    
    public void setTenTinTuc(String tenTinTuc) {
        this.tenTinTuc = tenTinTuc;
    }
    public String getNoiDungtTinTuc() {
        return this.noiDungtTinTuc;
    }
    
    public void setNoiDungtTinTuc(String noiDungtTinTuc) {
        this.noiDungtTinTuc = noiDungtTinTuc;
    }
    public Date getNgayDang() {
        return this.ngayDang;
    }
    
    public void setNgayDang(Date ngayDang) {
        this.ngayDang = ngayDang;
    }
    public Integer getTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public Set getHinhanhtintucs() {
        return this.hinhanhtintucs;
    }
    
    public void setHinhanhtintucs(Set hinhanhtintucs) {
        this.hinhanhtintucs = hinhanhtintucs;
    }




}


