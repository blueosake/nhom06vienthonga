package MODEL.POJO;
// Generated Oct 13, 2011 8:14:39 AM by Hibernate Tools 3.2.1.GA



/**
 * Hinhanhtintuc generated by hbm2java
 */
public class Hinhanhtintuc  implements java.io.Serializable {


     private String maHinhAnhTinTuc;
     private Tintuc tintuc;
     private String tenHinhAnh;
     private String duongDan;
     private Integer tinhTrang;

    public Hinhanhtintuc() {
    }

	
    public Hinhanhtintuc(String maHinhAnhTinTuc) {
        this.maHinhAnhTinTuc = maHinhAnhTinTuc;
    }
    public Hinhanhtintuc(String maHinhAnhTinTuc, Tintuc tintuc, String tenHinhAnh, String duongDan, Integer tinhTrang) {
       this.maHinhAnhTinTuc = maHinhAnhTinTuc;
       this.tintuc = tintuc;
       this.tenHinhAnh = tenHinhAnh;
       this.duongDan = duongDan;
       this.tinhTrang = tinhTrang;
    }
   
    public String getMaHinhAnhTinTuc() {
        return this.maHinhAnhTinTuc;
    }
    
    public void setMaHinhAnhTinTuc(String maHinhAnhTinTuc) {
        this.maHinhAnhTinTuc = maHinhAnhTinTuc;
    }
    public Tintuc getTintuc() {
        return this.tintuc;
    }
    
    public void setTintuc(Tintuc tintuc) {
        this.tintuc = tintuc;
    }
    public String getTenHinhAnh() {
        return this.tenHinhAnh;
    }
    
    public void setTenHinhAnh(String tenHinhAnh) {
        this.tenHinhAnh = tenHinhAnh;
    }
    public String getDuongDan() {
        return this.duongDan;
    }
    
    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }
    public Integer getTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }




}


