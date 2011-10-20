/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.DAO.*;
import MODEL.POJO.*;
import com.itextpdf.text.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.ContentType;
import org.omg.CORBA.SystemException;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author HP
 */
@WebServlet(name = "process", urlPatterns = {"/process"})
public class process extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            String task = "";
            if (request.getParameter("task") != null) {
                task = request.getParameter("task").toString();
            }

            //<editor-fold defaultstate="collapsed" desc="tìm kiếm sản phẩm">
            if (task.equals("timkiem")) {
                Sanpham sp = new Sanpham();
                sp.setTenSanPham(request.getParameter("TSP"));
                Loaisanpham lsp = new Loaisanpham();
                lsp.setMaLoaiSanPham(request.getParameter("MLSP"));
                sp.setLoaisanpham(lsp);
                Hang h = new Hang();
                h.setMaHang(request.getParameter("MH"));
                sp.setHang(h);
                sp.setGiaBan(Float.parseFloat(request.getParameter("Gia").toString()));

                int sp1trang = ThamSoDao.LaySoSanPhamTrenTrang();
                int tongsotrang = 0;
                int trang = 1;
                if (request.getParameter("trang") != null) {
                    trang = Integer.parseInt(request.getParameter("trang").toString());
                }
                int batdau = 0;
                if (trang > 1) {
                    batdau = sp1trang * trang - sp1trang;
                }

                List<Sanpham> list = SanPhamDAO.TimKiem(sp, batdau, -1);
                tongsotrang = list.size() / sp1trang;
                if (list.size() % sp1trang > 0) {
                    tongsotrang = tongsotrang + 1;
                }
                list = SanPhamDAO.TimKiem(sp, batdau, sp1trang);
                //list = list.subList(0, sp1trang);

                request.setAttribute("tongsotrang", tongsotrang);
                request.setAttribute("list", list);
                request.getRequestDispatcher("TimKiem.jsp").forward(request, response);
                return;
            }
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="đặt mua sản phẩm">
            if (task.equals("datmua")) {
                String msp = request.getParameter("MSP");
                Sanpham sp = SanPhamDAO.LaySanPhamTheoMa(msp);
                if (session.getAttribute("TenDangNhap") == null) {

                    request.getRequestDispatcher("view?task=DangNhap").forward(request, response);
                    return;
                } else {

                    Giohang gh = GioHangDAO.LayGioHangCuoiCung();
                    int mgh = 1;
                    if (gh == null) {
                        gh = new Giohang();
                    } else {
                        mgh = Integer.parseInt(gh.getMaGioHang().substring(3));
                        mgh = mgh + 1;
                    }
                    gh = new Giohang();
                    gh.setMaGioHang("MGH" + String.valueOf(mgh));
                    gh.setDonGia(sp.getGiaBan());
                    gh.setSanpham(sp);
                    gh.setSoLuong(1);
                    gh.setThanhTien((float) 0);
                    gh.setTinhTrang(0);
                    Nguoidung nd = NguoiDungDAO.LayNguoiDungTheoTenDangNhap(session.getAttribute("TenDangNhap").toString());
                    gh.setNguoidung(nd);

                    request.setAttribute("TenSanPham", sp.getTenSanPham());
                    request.setAttribute("ThanhTien", sp.getGiaBan());

                    int kq = GioHangDAO.Them(gh);

                    if (kq == 1) {
                        String thongbao = "";
                        thongbao = "Đã đặt mua thành công";
                        request.setAttribute("thongbao", thongbao);
                    }

                    request.getRequestDispatcher("view?task=giohang").forward(request, response);

                }

                //request.getRequestDispatcher("view?task=chitietsanpham&MSP=MSP31").forward(request, response);
                request.setAttribute("sanpham", sp);
                request.getRequestDispatcher("ChiTietSanPham.jsp").forward(request, response);
                return;
            }
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Xử lý đăng nhập">
            if (task.equals("XuLy")) {

                Nguoidung ndung = NguoiDungDAO.DangNhap(request.getParameter("tenDangNhap"), request.getParameter("matKhau"));
                if (ndung != null) {
                    session.setAttribute("MaNguoiDung", ndung.getMaNguoiDung());
                    session.setAttribute("TenDangNhap", ndung.getTenDangNhap());
                    session.setAttribute("TenNguoiDung", ndung.getTenNguoiDung());
                    session.setAttribute("Email", ndung.getEmail());
                    request.getRequestDispatcher("view").forward(request, response);
                } else {
                    response.sendRedirect("view?task=DangNhap");
                }
            }
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Xử lý đăng ký">
            if(task.equals("Luu"))
            {
                Nguoidung pojo=new Nguoidung();
                Loainguoidung lnd = NguoiDungDAO.LayDoiTuongTheoMa("MLND2");

                //Lấy Mã người dùng kiểu String tăng tự động
                String MaND = NguoiDungDAO.LayMaNguoiDungCuoiCung();
                String ma = "MND";
                String ChuoiSo = MaND.substring(3);
                int So = Integer.parseInt(ChuoiSo) + 1;
                MaND = ma + So;   

                //Lấy giờ hệ thống
                long current_time = System.currentTimeMillis();
                java.sql.Date NgayHienTai = new java.sql.Date(current_time);


                pojo.setMaNguoiDung(MaND);
                pojo.setTenDangNhap(request.getParameter("txtTenDangNhap"));
                pojo.setTenNguoiDung(request.getParameter("txtName"));
                pojo.setMatKhau(request.getParameter("txtPass"));
                pojo.setEmail(request.getParameter("txtEmail"));
                pojo.setCmnd(Integer.parseInt(request.getParameter("txtCMND")));
                pojo.setDienThoai(Integer.parseInt(request.getParameter("txtDienThoai")));
                pojo.setDiaChi(request.getParameter("txtDiaChi"));
                pojo.setNgayDangKy(NgayHienTai);
                pojo.setLoainguoidung(lnd);
                pojo.setTinhTrang(0);

                int kq = NguoiDungDAO.DangKy(pojo);        

                //Gán Session Tên Đăng Nhập                    
                session.setAttribute("TenDangNhap", pojo.getTenDangNhap());                                        
                request.getRequestDispatcher("view").forward(request, response);                                  
            }
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Xử lý đăng xuất">
            if (task.equals("DangXuat")) 
            {
                session.invalidate();
                request.getRequestDispatcher("view").forward(request, response);
            }
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Xử lý liên hệ">
            if (task.equals("LienHe")) 
            {                
                request.getRequestDispatcher("view").forward(request, response);
            }
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="xử lý quản lý admin">
            if (task.equals("quanlyadmin")) {
                if (request.getParameter("task_chitiet") != null) {
                    String task_chitiet = request.getParameter("task_chitiet");

                    //<editor-fold defaultstate="collapsed" desc="công ty">
                    if (task_chitiet.equals("capnhatcongty")) {
                        Congty ct = new Congty();
                        ct.setMaCongTy(request.getParameter("maCongTy"));
                        ct.setDiaChi(request.getParameter("diaChi"));
                        ct.setDienThoai(request.getParameter("dienThoai"));
                        ct.setEmail(request.getParameter("email"));
                        ct.setFax(request.getParameter("fax"));
                        ct.setHotLine(request.getParameter("hotLine"));
                        ct.setTenCongTy(request.getParameter("tenCongTy"));
                        ct.setWebsite(request.getParameter("website"));
                        ct.setGioiThieu(request.getParameter("gioiThieu"));

                        int kq = CongTyDAO.CapNhatCongTy(ct);
                        if (kq == 1) {
                            String thongbao = "";
                            thongbao = "Đã cập nhật thành công";
                            request.setAttribute("thongbao", thongbao);
                        }

                        request.getRequestDispatcher("QuanLyAdmin_CongTy.jsp").forward(request, response);
                        return;
                    }
                    //</editor-fold>

                    //<editor-fold defaultstate="collapsed" desc="Người dùng">
                    if (task_chitiet.equals("nguoidung")) {
                        if (request.getParameter("btnXoa") != null) {
                            String[] CacMaXoa = request.getParameterValues("cbXoa");
                            if (CacMaXoa != null) {
                                for (int i = 0; i < CacMaXoa.length; i++) {
                                    String ms = CacMaXoa[i];
                                    int j = NguoiDungDAO.XoaNguoiDungTheoMa(ms);
                                }
                            }
                        }
                        if (request.getParameter("btnThem") != null) {
                            String tenDN = request.getParameter("tbTenDangNhapMoi");
                            String matKhau = request.getParameter("tbMatKhauMoi");
                            String tenND = request.getParameter("tbTenNguoiDungMoi");
                            String email = request.getParameter("tbEmailMoi");
                            String cmnd = request.getParameter("tbCMNDMoi");
                            String dienThoai = request.getParameter("tbDienThoaiMoi");
                            String diaChi = request.getParameter("tbDiaChiMoi");
                            String Malnd = request.getParameter("LND");
                            String ngayDK = request.getParameter("tbNgayDangKyMoi");

                            //Lấy giờ hệ thống
                            long current_time = System.currentTimeMillis();
                            java.sql.Date NgayHienTai = new java.sql.Date(current_time);
                            //Lay Loai Nguoi Dung qua MLND
                            Loainguoidung lnd = NguoiDungDAO.LayDoiTuongTheoMa(Malnd);
                            //Lấy Mã người dùng kiểu String tăng tự động
                            String MaND = NguoiDungDAO.LayMaNguoiDungCuoiCung();
                            String ma = "MND";
                            String ChuoiSo = MaND.substring(3);
                            int So = Integer.parseInt(ChuoiSo) + 1;
                            MaND = ma + So;

                            Nguoidung nd = new Nguoidung();
                            nd.setMaNguoiDung(MaND);
                            nd.setTenDangNhap(tenDN);
                            nd.setMatKhau(matKhau);
                            nd.setTenNguoiDung(tenND);
                            nd.setEmail(email);
                            nd.setCmnd(Integer.parseInt(cmnd));
                            nd.setDienThoai(Integer.parseInt(dienThoai));
                            nd.setDiaChi(diaChi);
                            nd.setLoainguoidung(lnd);
                            nd.setNgayDangKy(NgayHienTai);
                            nd.setTinhTrang(0);

                            try {
                                //Them Nguoi Dung Moi
                                int kq = NguoiDungDAO.DangKy(nd);
                            } catch (SystemException ex) {
                                Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if (request.getParameter("btnCapNhat") != null) {
                            String[] CacMaCapNhat = request.getParameterValues("cbCapnhat");
                            if (CacMaCapNhat != null) {
                                for (int i = 0; i < CacMaCapNhat.length; i++) {
                                    //////                                    
                                    String tenDN = request.getParameter("tbTenDangNhap" + CacMaCapNhat[i]);
                                    String matKhau = request.getParameter("tbMatKhau" + CacMaCapNhat[i]);
                                    String tenND = request.getParameter("tbTenNguoiDung" + CacMaCapNhat[i]);
                                    String email = request.getParameter("tbEmail" + CacMaCapNhat[i]);
                                    String cmnd = request.getParameter("tbCMND" + CacMaCapNhat[i]);
                                    String dienThoai = request.getParameter("tbDienThoai" + CacMaCapNhat[i]);
                                    String diaChi = request.getParameter("tbDiaChi" + CacMaCapNhat[i]);


                                    //Lấy thông tin cũ của Người Dùng đó
                                    Nguoidung ndCu = NguoiDungDAO.LayNguoiDungTheoMa(CacMaCapNhat[i]);

                                    Nguoidung nd = new Nguoidung();
                                    nd.setMaNguoiDung(CacMaCapNhat[i]);
                                    nd.setTenDangNhap(tenDN);
                                    nd.setMatKhau(matKhau);
                                    nd.setTenNguoiDung(tenND);
                                    nd.setEmail(email);
                                    nd.setCmnd(Integer.parseInt(cmnd));
                                    nd.setDienThoai(Integer.parseInt(dienThoai));
                                    nd.setDiaChi(diaChi);
                                    nd.setLoainguoidung(ndCu.getLoainguoidung());
                                    nd.setNgayDangKy(ndCu.getNgayDangKy());
                                    nd.setTinhTrang(ndCu.getTinhTrang());

                                    try {
                                        //Update lại
                                        int kq = NguoiDungDAO.DangKy(nd);
                                    } catch (SystemException ex) {
                                        Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }
                        //Load lai trang
                        request.getRequestDispatcher("QuanLyAdmin_NguoiDung.jsp").forward(request, response);
                        return;
                    }
                    //</editor-fold>

                    //<editor-fold defaultstate="collapsed" desc="Sản phẩm">
                    if (task_chitiet.equals("sanpham")) {
                        //<editor-fold defaultstate="collapsed" desc="thêm">
                        if (request.getParameter("Them") != null) {
                            ArrayList<FileItem> hinhanhsanpham_data = new ArrayList<FileItem>();
                            Hashtable params = new Hashtable();
                            if (ServletFileUpload.isMultipartContent(request)) {
                                ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
                                try {
                                    List fileItemsList = servletFileUpload.parseRequest(request);

                                    Iterator it = fileItemsList.iterator();

                                    while (it.hasNext()) {
                                        FileItem fileItem = (FileItem) it.next();
                                        if (fileItem.isFormField()) {
                                            String value = fileItem.getString("UTF-8");
                                            String key = fileItem.getFieldName();
                                            params.put(key, value);
                                        } else {
                                            hinhanhsanpham_data.add(fileItem);
                                        }
                                    }
                                } catch (Exception e) {
                                    out.println(e);
                                    return;
                                }

                                Sanpham sp = new Sanpham();
                                sp.setMaSanPham(params.get("MaSanPham").toString());
                                sp.setTenSanPham(params.get("TenSanPham").toString());
                                Loaisanpham lsp = new Loaisanpham();
                                lsp.setMaLoaiSanPham(params.get("MaLoaiSanPham").toString());
                                sp.setLoaisanpham(lsp);
                                Hang h = HangDAO.LayHangTheoMa(params.get("MaHang").toString());
                                sp.setHang(h);
                                sp.setSoLuong(Integer.parseInt(params.get("SoLuong").toString()));
                                sp.setGiaBan(Float.parseFloat(params.get("GiaBan").toString()));
                                sp.setMauSac(params.get("MauSac").toString());
                                sp.setThoiGianBaoHanh(params.get("ThoiGianBaoHanh").toString());
                                sp.setKichThuoc(params.get("KichThuoc").toString());
                                sp.setTrongLuong(params.get("TrongLuong").toString());
                                sp.setTinhTrang(0);

                                SanPhamDAO.ThemSanPham(sp);

                                String path = getServletContext().getRealPath("/") + "images\\";

                                if (sp.getLoaisanpham().getMaLoaiSanPham().equals("DT")) {
                                    path += "dien thoai\\";

                                    Chitietdienthoai ctdt = ChiTietDienThoaiDAO.LayChiTietDienThoaiCuoiCung();
                                    int chiso = 1;
                                    if (ctdt == null) {
                                        ctdt = new Chitietdienthoai();
                                    } else {
                                        chiso = Integer.parseInt(ctdt.getMaChiTietDienThoai().substring(5).toString());
                                        chiso += 1;
                                    }
                                    ctdt.setMaChiTietDienThoai("MCTDT" + chiso);
                                    ctdt.setSanpham(sp);
                                    ctdt.setMang(params.get("Mang").toString());
                                    ctdt.setLoaiManHinh(params.get("LoaiManHinh").toString());
                                    ctdt.setNgonNgu(params.get("NgonNgu").toString());

                                    ChiTietDienThoaiDAO.Them(ctdt);
                                }

                                if (sp.getLoaisanpham().getMaLoaiSanPham().equals("LT")) {
                                    path += "laptop\\";

                                    Chitietlaptop ctlt = ChiTietLaptopDAO.LayChiTietLaptopCuoiCung();
                                    int chiso = 1;
                                    if (ctlt == null) {
                                        ctlt = new Chitietlaptop();
                                    } else {
                                        chiso = Integer.parseInt(ctlt.getMaChiTietLaptop().substring(5).toString());
                                        chiso += 1;
                                    }
                                    ctlt.setMaChiTietLaptop("MCTLT" + chiso);
                                    ctlt.setSanpham(sp);
                                    ctlt.setCongNgheCpu(params.get("CongNgheCPU").toString());
                                    ctlt.setTocDoCpu(params.get("TocDoCPU").toString());
                                    ctlt.setBoNhoDem(params.get("BoNhoDem").toString());

                                    ChiTietLaptopDAO.Them(ctlt);
                                }

                                path += sp.getHang().getTenHang() + "\\";

                                Hinhanhsanpham hasp_cuoi = HinhAnhSanPhamDAO.LayHinhAnhSanPhamCuoiCung();
                                int chiso = 1;
                                if (hasp_cuoi == null) {
                                    hasp_cuoi = new Hinhanhsanpham();
                                } else {
                                    chiso = Integer.parseInt(hasp_cuoi.getMaHinhAnhSanPham().substring(5));
                                    chiso += 1;
                                }
                                String mhasp = "MHASP" + chiso;

                                for (int i = 0; i < hinhanhsanpham_data.size(); i++) {
                                    Hinhanhsanpham hasp = new Hinhanhsanpham();
                                    hasp.setMaHinhAnhSanPham(mhasp);
                                    hasp.setSanpham(sp);
                                    hasp.setTinhTrang(0);
                                    hasp.setDuongDan(hinhanhsanpham_data.get(i).getName());

                                    HinhAnhSanPhamDAO.Them(hasp);

                                    File file = new File(path + hinhanhsanpham_data.get(i).getName());
                                    try {
                                        hinhanhsanpham_data.get(i).write(file);
                                    } catch (Exception ex) {
                                        Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    chiso += 1;
                                    mhasp = "MHASP" + chiso;
                                }

                                String thongbao = "";
                                thongbao = "Đã thêm sản phẩm thành công";
                                request.setAttribute("thongbao", thongbao);
                            }

                            request.getRequestDispatcher("QuanLyAdmin_SanPham_Them.jsp").forward(request, response);
                            return;
                        }
                        //</editor-fold>

                        //<editor-fold defaultstate="collapsed" desc="cập nhật">                        
                        if (request.getParameter("CapNhat") != null) {
                            String capnhat = request.getParameter("CapNhat").toString();
                            DecimalFormat df = new DecimalFormat("###,###,###");

                            String msp = "";

                            if (capnhat.equals("chitiet")) {
                                //<editor-fold defaultstate="collapsed" desc="chi tiết">
                                ArrayList<FileItem> hinhanhsanpham_data = new ArrayList<FileItem>();
                                int[] hinhanhsanpham_chiso = new int[6];
                                Hashtable params = new Hashtable();
                                if (ServletFileUpload.isMultipartContent(request)) {
                                    ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
                                    try {
                                        List fileItemsList = servletFileUpload.parseRequest(request);

                                        Iterator it = fileItemsList.iterator();

                                        while (it.hasNext()) {
                                            FileItem fileItem = (FileItem) it.next();
                                            if (fileItem.isFormField()) {
                                                String value = fileItem.getString("UTF-8");
                                                String key = fileItem.getFieldName();
                                                params.put(key, value);
                                            } else {
                                                hinhanhsanpham_data.add(fileItem);
                                            }
                                        }
                                    } catch (Exception e) {
                                        out.println(e);
                                        return;
                                    }

                                    msp = params.get("MaSanPham").toString();

                                    String path_cu = getServletContext().getRealPath("/") + "images\\";;

                                    Sanpham sp = SanPhamDAO.LaySanPhamTheoMa(params.get("MaSanPham").toString());
                                    if (sp.getLoaisanpham().getMaLoaiSanPham().equals("DT")) {
                                        path_cu += "dien thoai\\";
                                    } else {
                                        path_cu += "laptop\\";
                                    }
                                    path_cu += sp.getHang().getTenHang() + "\\" + ((Hinhanhsanpham) sp.getHinhanhsanphams().toArray()[0]).getDuongDan();

                                    sp.setTenSanPham(params.get("TenSanPham").toString());
                                    Loaisanpham lsp = new Loaisanpham();
                                    lsp.setMaLoaiSanPham(params.get("MaLoaiSanPham").toString());
                                    sp.setLoaisanpham(lsp);
                                    Hang h = HangDAO.LayHangTheoMa(params.get("MaHang").toString());
                                    sp.setHang(h);
                                    sp.setSoLuong(Integer.parseInt(params.get("SoLuong").toString()));
                                    float giaban = 0;
                                    try {
                                        giaban = df.parse(params.get("GiaBan").toString()).floatValue();
                                    } catch (ParseException ex) {
                                        Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    sp.setGiaBan(giaban);
                                    sp.setMauSac(params.get("MauSac").toString());
                                    sp.setThoiGianBaoHanh(params.get("ThoiGianBaoHanh").toString());
                                    sp.setKichThuoc(params.get("KichThuoc").toString());
                                    sp.setTrongLuong(params.get("TrongLuong").toString());
                                    sp.setTinhTrang(0);

                                    SanPhamDAO.CapNhatSanPham(sp);

                                    String path = getServletContext().getRealPath("/") + "images\\";

                                    if (sp.getLoaisanpham().getMaLoaiSanPham().equals("DT")) {
                                        path += "dien thoai\\";

                                        Chitietdienthoai ctdt = (Chitietdienthoai) sp.getChitietdienthoais().toArray()[0];
                                        ctdt.setSanpham(sp);
                                        ctdt.setMang(params.get("Mang").toString());
                                        ctdt.setLoaiManHinh(params.get("LoaiManHinh").toString());
                                        ctdt.setNgonNgu(params.get("NgonNgu").toString());

                                        ChiTietDienThoaiDAO.CapNhatChiTietDienThoai(ctdt);
                                    }

                                    if (sp.getLoaisanpham().getMaLoaiSanPham().equals("LT")) {
                                        path += "laptop\\";

                                        Chitietlaptop ctlt = (Chitietlaptop) sp.getChitietlaptops().toArray()[0];
                                        ctlt.setSanpham(sp);
                                        ctlt.setCongNgheCpu(params.get("CongNgheCPU").toString());
                                        ctlt.setTocDoCpu(params.get("TocDoCPU").toString());
                                        ctlt.setBoNhoDem(params.get("BoNhoDem").toString());

                                        ChiTietLaptopDAO.CapNhatChiTietLaptop(ctlt);
                                    }

                                    path += sp.getHang().getTenHang() + "\\";

                                    for (int i = 0; i < hinhanhsanpham_data.size(); i++) {
                                        Hinhanhsanpham hasp = (Hinhanhsanpham) sp.getHinhanhsanphams().toArray()[i];
                                        hasp.setSanpham(sp);
                                        hasp.setTinhTrang(0);
                                        if (!hinhanhsanpham_data.get(i).getName().equals("")) {
                                            hasp.setDuongDan(hinhanhsanpham_data.get(i).getName());
                                        } else {
                                            try {
                                                String path_moi = path + hasp.getDuongDan();
                                                File hinh_cu = new File(path_cu);
                                                FileInputStream fis = new FileInputStream(hinh_cu);
                                                File hinh_moi = new File(path_moi);
                                                FileOutputStream fos = new FileOutputStream(hinh_moi);
                                                
                                                byte[] temp = new byte[10000];
                                                do {
                                                    fis.read(temp);
                                                    fos.write(temp);
                                                } while (fis.available() > 0);
                                                
                                                hinh_cu.delete();
                                                fis.close();
                                                fos.close();
                                            } catch (Exception ex) {
                                            }
                                        }
                                        HinhAnhSanPhamDAO.CapNhatHinhAnhSanPham(hasp);

                                        File file = new File(path + hinhanhsanpham_data.get(i).getName());
                                        try {
                                            hinhanhsanpham_data.get(i).write(file);
                                        } catch (Exception ex) {
                                            Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    //</editor-fold>
                                }
                            } else {
                                //<editor-fold defaultstate="collapsed" desc="cơ bản">                                                                
                                String[] stt = request.getParameterValues("ID");
                                for (int i = 0; i < stt.length; i++) {
                                    int k = Integer.parseInt(stt[i]);

                                    String masanpham = request.getParameterValues("MaSanPham")[k].toString();
                                    msp = masanpham;
                                    String tensanpham = request.getParameterValues("TenSanPham")[k].toString();
                                    Loaisanpham lsp = new Loaisanpham();
                                    lsp.setMaLoaiSanPham(request.getParameterValues("MaLoaiSanPham")[k].toString());
                                    Hang h = new Hang();
                                    h.setMaHang(request.getParameterValues("MaHang")[k].toString());
                                    int soluong = Integer.parseInt(request.getParameterValues("SoLuong")[k].toString());
                                    float giaban = 0;
                                    try {
                                        giaban = df.parse(request.getParameterValues("GiaBan")[k].toString()).floatValue();
                                    } catch (ParseException ex) {
                                        Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String mausac = request.getParameterValues("MauSac")[k].toString();
                                    String thoigianbaohanh = request.getParameterValues("ThoiGianBaoHanh")[k].toString();
                                    String kichthuoc = request.getParameterValues("KichThuoc")[k].toString();
                                    String trongluong = request.getParameterValues("TrongLuong")[k].toString();
                                    int tinhtrang = Integer.parseInt(request.getParameterValues("TinhTrang")[k].toString());

                                    Sanpham sp = SanPhamDAO.LaySanPhamTheoMa(masanpham);
                                    sp.setTenSanPham(tensanpham);
                                    sp.setLoaisanpham(lsp);
                                    sp.setHang(h);
                                    sp.setSoLuong(soluong);
                                    sp.setGiaBan(giaban);
                                    sp.setMauSac(mausac);
                                    sp.setThoiGianBaoHanh(thoigianbaohanh);
                                    sp.setKichThuoc(kichthuoc);
                                    sp.setTrongLuong(trongluong);
                                    sp.setTinhTrang(tinhtrang);

                                    SanPhamDAO.CapNhatSanPham(sp);
                                }
                                //</editor-fold>
                            }

                            String thongbao = "";
                            thongbao = "Đã cập nhật thành công";
                            request.setAttribute("thongbao", thongbao);

                            if (capnhat.equals("chitiet")) {
                                request.getRequestDispatcher("view?task=quanly&task_chitiet=sanpham&CapNhat=chitiet&MSP=" + msp).forward(request, response);
                            } else {
                                request.getRequestDispatcher("view?task=quanly&task_chitiet=sanpham").forward(request, response);
                            }
                            return;
                        }
                        //</editor-fold>

                        //<editor-fold defaultstate="collapsed" desc="xoá">                        
                        if (request.getParameter("Xoa") != null) {
                            String[] stt = request.getParameterValues("ID");
                            for (int i = 0; i < stt.length; i++) {
                                int k = Integer.parseInt(stt[i]);

                                String masanpham = request.getParameterValues("MaSanPham")[k].toString();
                                Sanpham sp = SanPhamDAO.LaySanPhamTheoMa(masanpham);
                                sp.setTinhTrang(1);

                                SanPhamDAO.CapNhatSanPham(sp);
                            }

                            String thongbao = "";
                            thongbao = "Đã xoá thành công";
                            request.setAttribute("thongbao", thongbao);

                            request.getRequestDispatcher("view?task=quanly&task_chitiet=sanpham").forward(request, response);
                            return;
                        }
                        //</editor-fold>

                        request.getRequestDispatcher("QuanLyAdmin_SanPham.jsp").forward(request, response);
                        return;
                    }

                    request.getRequestDispatcher("QuanLyAdmin_SanPham.jsp").forward(request, response);
                    return;
                }
                //</editor-fold>
            }
            //</editor-fold>

            request.getRequestDispatcher("QuanLyAdmin.jsp").forward(request, response);
            return;

        } finally {
            out.close();
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
