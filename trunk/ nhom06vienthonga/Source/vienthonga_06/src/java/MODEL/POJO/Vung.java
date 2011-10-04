package MODEL.POJO;
// Generated Oct 4, 2011 11:02:12 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Vung generated by hbm2java
 */
public class Vung  implements java.io.Serializable {


     private String maVung;
     private String tenVung;
     private Integer tinhTrang;
     private Set sieuthis = new HashSet(0);

    public Vung() {
    }

	
    public Vung(String maVung) {
        this.maVung = maVung;
    }
    public Vung(String maVung, String tenVung, Integer tinhTrang, Set sieuthis) {
       this.maVung = maVung;
       this.tenVung = tenVung;
       this.tinhTrang = tinhTrang;
       this.sieuthis = sieuthis;
    }
   
    public String getMaVung() {
        return this.maVung;
    }
    
    public void setMaVung(String maVung) {
        this.maVung = maVung;
    }
    public String getTenVung() {
        return this.tenVung;
    }
    
    public void setTenVung(String tenVung) {
        this.tenVung = tenVung;
    }
    public Integer getTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public Set getSieuthis() {
        return this.sieuthis;
    }
    
    public void setSieuthis(Set sieuthis) {
        this.sieuthis = sieuthis;
    }




}


