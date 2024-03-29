package MODEL.POJO;
// Generated Oct 13, 2011 8:14:39 AM by Hibernate Tools 3.2.1.GA



/**
 * Chitietdienthoai generated by hbm2java
 */
public class Chitietdienthoai  implements java.io.Serializable {


     private String maChiTietDienThoai;
     private Sanpham sanpham;
     private String mang;
     private String ngonNgu;
     private String loaiManHinh;
     private String kichThuocHienThi;
     private String kieuChuong;
     private String tinNhan;
     private String ketNoi;
     private String camera;
     private String danhBa;
     private String boNhoTrong;
     private String rung;
     private String gpgs;
     private String m3g;
     private String wlan;
     private String dongHo;
     private String baoThuc;
     private String daiFm;
     private String troChoi;
     private String trinhDuyet;
     private String jaVa;
     private String quayPhim;
     private String ghiAm;
     private String ngheNhac;
     private String xemPhim;
     private String ghiAmCuocGoi;
     private String loaNgoai;
     private Integer tinhTrang;

    public Chitietdienthoai() {
    }

	
    public Chitietdienthoai(String maChiTietDienThoai) {
        this.maChiTietDienThoai = maChiTietDienThoai;
    }
    public Chitietdienthoai(String maChiTietDienThoai, Sanpham sanpham, String mang, String ngonNgu, String loaiManHinh, String kichThuocHienThi, String kieuChuong, String tinNhan, String ketNoi, String camera, String danhBa, String boNhoTrong, String rung, String gpgs, String m3g, String wlan, String dongHo, String baoThuc, String daiFm, String troChoi, String trinhDuyet, String jaVa, String quayPhim, String ghiAm, String ngheNhac, String xemPhim, String ghiAmCuocGoi, String loaNgoai, Integer tinhTrang) {
       this.maChiTietDienThoai = maChiTietDienThoai;
       this.sanpham = sanpham;
       this.mang = mang;
       this.ngonNgu = ngonNgu;
       this.loaiManHinh = loaiManHinh;
       this.kichThuocHienThi = kichThuocHienThi;
       this.kieuChuong = kieuChuong;
       this.tinNhan = tinNhan;
       this.ketNoi = ketNoi;
       this.camera = camera;
       this.danhBa = danhBa;
       this.boNhoTrong = boNhoTrong;
       this.rung = rung;
       this.gpgs = gpgs;
       this.m3g = m3g;
       this.wlan = wlan;
       this.dongHo = dongHo;
       this.baoThuc = baoThuc;
       this.daiFm = daiFm;
       this.troChoi = troChoi;
       this.trinhDuyet = trinhDuyet;
       this.jaVa = jaVa;
       this.quayPhim = quayPhim;
       this.ghiAm = ghiAm;
       this.ngheNhac = ngheNhac;
       this.xemPhim = xemPhim;
       this.ghiAmCuocGoi = ghiAmCuocGoi;
       this.loaNgoai = loaNgoai;
       this.tinhTrang = tinhTrang;
    }
   
    public String getMaChiTietDienThoai() {
        return this.maChiTietDienThoai;
    }
    
    public void setMaChiTietDienThoai(String maChiTietDienThoai) {
        this.maChiTietDienThoai = maChiTietDienThoai;
    }
    public Sanpham getSanpham() {
        return this.sanpham;
    }
    
    public void setSanpham(Sanpham sanpham) {
        this.sanpham = sanpham;
    }
    public String getMang() {
        return this.mang;
    }
    
    public void setMang(String mang) {
        this.mang = mang;
    }
    public String getNgonNgu() {
        return this.ngonNgu;
    }
    
    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }
    public String getLoaiManHinh() {
        return this.loaiManHinh;
    }
    
    public void setLoaiManHinh(String loaiManHinh) {
        this.loaiManHinh = loaiManHinh;
    }
    public String getKichThuocHienThi() {
        return this.kichThuocHienThi;
    }
    
    public void setKichThuocHienThi(String kichThuocHienThi) {
        this.kichThuocHienThi = kichThuocHienThi;
    }
    public String getKieuChuong() {
        return this.kieuChuong;
    }
    
    public void setKieuChuong(String kieuChuong) {
        this.kieuChuong = kieuChuong;
    }
    public String getTinNhan() {
        return this.tinNhan;
    }
    
    public void setTinNhan(String tinNhan) {
        this.tinNhan = tinNhan;
    }
    public String getKetNoi() {
        return this.ketNoi;
    }
    
    public void setKetNoi(String ketNoi) {
        this.ketNoi = ketNoi;
    }
    public String getCamera() {
        return this.camera;
    }
    
    public void setCamera(String camera) {
        this.camera = camera;
    }
    public String getDanhBa() {
        return this.danhBa;
    }
    
    public void setDanhBa(String danhBa) {
        this.danhBa = danhBa;
    }
    public String getBoNhoTrong() {
        return this.boNhoTrong;
    }
    
    public void setBoNhoTrong(String boNhoTrong) {
        this.boNhoTrong = boNhoTrong;
    }
    public String getRung() {
        return this.rung;
    }
    
    public void setRung(String rung) {
        this.rung = rung;
    }
    public String getGpgs() {
        return this.gpgs;
    }
    
    public void setGpgs(String gpgs) {
        this.gpgs = gpgs;
    }
    public String getM3g() {
        return this.m3g;
    }
    
    public void setM3g(String m3g) {
        this.m3g = m3g;
    }
    public String getWlan() {
        return this.wlan;
    }
    
    public void setWlan(String wlan) {
        this.wlan = wlan;
    }
    public String getDongHo() {
        return this.dongHo;
    }
    
    public void setDongHo(String dongHo) {
        this.dongHo = dongHo;
    }
    public String getBaoThuc() {
        return this.baoThuc;
    }
    
    public void setBaoThuc(String baoThuc) {
        this.baoThuc = baoThuc;
    }
    public String getDaiFm() {
        return this.daiFm;
    }
    
    public void setDaiFm(String daiFm) {
        this.daiFm = daiFm;
    }
    public String getTroChoi() {
        return this.troChoi;
    }
    
    public void setTroChoi(String troChoi) {
        this.troChoi = troChoi;
    }
    public String getTrinhDuyet() {
        return this.trinhDuyet;
    }
    
    public void setTrinhDuyet(String trinhDuyet) {
        this.trinhDuyet = trinhDuyet;
    }
    public String getJaVa() {
        return this.jaVa;
    }
    
    public void setJaVa(String jaVa) {
        this.jaVa = jaVa;
    }
    public String getQuayPhim() {
        return this.quayPhim;
    }
    
    public void setQuayPhim(String quayPhim) {
        this.quayPhim = quayPhim;
    }
    public String getGhiAm() {
        return this.ghiAm;
    }
    
    public void setGhiAm(String ghiAm) {
        this.ghiAm = ghiAm;
    }
    public String getNgheNhac() {
        return this.ngheNhac;
    }
    
    public void setNgheNhac(String ngheNhac) {
        this.ngheNhac = ngheNhac;
    }
    public String getXemPhim() {
        return this.xemPhim;
    }
    
    public void setXemPhim(String xemPhim) {
        this.xemPhim = xemPhim;
    }
    public String getGhiAmCuocGoi() {
        return this.ghiAmCuocGoi;
    }
    
    public void setGhiAmCuocGoi(String ghiAmCuocGoi) {
        this.ghiAmCuocGoi = ghiAmCuocGoi;
    }
    public String getLoaNgoai() {
        return this.loaNgoai;
    }
    
    public void setLoaNgoai(String loaNgoai) {
        this.loaNgoai = loaNgoai;
    }
    public Integer getTinhTrang() {
        return this.tinhTrang;
    }
    
    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }




}


