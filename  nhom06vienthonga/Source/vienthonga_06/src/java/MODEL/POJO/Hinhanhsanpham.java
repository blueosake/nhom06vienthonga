package MODEL.POJO;
// Generated Sep 30, 2011 5:07:38 PM by Hibernate Tools 3.2.1.GA



/**
 * Hinhanhsanpham generated by hbm2java
 */
public class Hinhanhsanpham  implements java.io.Serializable {


     private String maHinhAnhSanPham;
     private Sanpham sanpham;
     private String duongDan;
     private Integer tinhTrang;

    public Hinhanhsanpham() {
    }

	
    public Hinhanhsanpham(String maHinhAnhSanPham) {
        this.maHinhAnhSanPham = maHinhAnhSanPham;
    }
    public Hinhanhsanpham(String maHinhAnhSanPham, Sanpham sanpham, String duongDan, Integer tinhTrang) {
       this.maHinhAnhSanPham = maHinhAnhSanPham;
       this.sanpham = sanpham;
       this.duongDan = duongDan;
       this.tinhTrang = tinhTrang;
    }
   
    public String getMaHinhAnhSanPham() {
        return this.maHinhAnhSanPham;
    }
    
    public void setMaHinhAnhSanPham(String maHinhAnhSanPham) {
        this.maHinhAnhSanPham = maHinhAnhSanPham;
    }
    public Sanpham getSanpham() {
        return this.sanpham;
    }
    
    public void setSanpham(Sanpham sanpham) {
        this.sanpham = sanpham;
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


