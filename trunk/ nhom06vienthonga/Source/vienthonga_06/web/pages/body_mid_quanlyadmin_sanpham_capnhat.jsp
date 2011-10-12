<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="MODEL.POJO.*"%>
<%@page import="MODEL.DAO.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    DecimalFormat df = new DecimalFormat("###,###,###");
    
    Sanpham sp = (Sanpham) request.getAttribute("sanpham");
    String path_hinhanh = "images/";
    Chitietdienthoai ctdt = new Chitietdienthoai();
    if (sp.getLoaisanpham().getMaLoaiSanPham().equals("DT")) {
        ctdt = (Chitietdienthoai) sp.getChitietdienthoais().toArray()[0];
        path_hinhanh += "dien thoai/";
    }
    Chitietlaptop ctlt = new Chitietlaptop();
    if (sp.getLoaisanpham().getMaLoaiSanPham().equals("LT")) {
        ctlt = (Chitietlaptop) sp.getChitietlaptops().toArray()[0];
        path_hinhanh += "laptop/";
    }
    path_hinhanh += sp.getHang().getTenHang() + "/";
    path_hinhanh += ((Hinhanhsanpham) sp.getHinhanhsanphams().toArray()[0]).getDuongDan();
%>

<style>
    .test tr
    {
        height: 30px;
    }
</style>

<script type="text/javascript" language="javascript">
    function showthongtin(lsp)
    {
        var hienthi = document.getElementById("thongtinchitiet");
        var laptop = document.getElementById("chitietlaptop");
        var dienthoai = document.getElementById("chitietdienthoai");
        if(lsp == "DT")
        {
            hienthi.innerHTML = dienthoai.innerHTML;
        }
        else
        {
            hienthi.innerHTML = laptop.innerHTML;
        }
    }
    
    function chuyentask(task)
    {
        var frm = document.getElementById("frmthemsanpham");
        frm.setAttribute("action", "process?task=quanlyadmin&task_chitiet=sanpham" + task);
    }
</script>

<div id="chitietdienthoai" style="display: none">
    <table class="test" width="100%" border="0" cellspacing="2" cellpadding="2">
        <tr>
        <th colspan="2" align="center"><h2>CHI TIẾT ĐIỆN THOẠI</h2></th>
        </tr>
        <tr>
        <td style="width: 35%;">Mạng: </td>
        <td><input type="text" name="Mang" value="<%= ctdt.getMang()%>" /></td>
        </tr>
        <tr>
        <td style="width: 35%;">Loại màn hình: </td>
        <td><input type="text" name="LoaiManHinh" value="<%= ctdt.getLoaiManHinh()%>" /></td>
        </tr>
        <tr>
        <td style="width: 35%;">Ngôn ngữ: </td>
        <td><input type="text" name="NgonNgu" value="<%= ctdt.getNgonNgu()%>" /></td>
        </tr>
    </table>
</div>

<div id="chitietlaptop" style="display: none">
    <table class="test" width="100%" border="0" cellspacing="2" cellpadding="2">
        <tr>
        <th colspan="2" align="center"><h2>CHI TIẾT LAPTOP</h2></th>
        </tr>
        <tr>
        <td style="width: 35%;">Công nghệ CPU: </td>
        <td><input type="text" name="CongNgheCPU" value="<%= ctlt.getCongNgheCpu()%>" /></td>
        </tr>
        <tr>
        <td style="width: 35%;">Tốc độ CPU: </td>
        <td><input type="text" name="TocDoCPU" value="<%= ctlt.getTocDoCpu()%>" /></td>
        </tr>
        <tr>
        <td style="width: 35%;">Bộ nhớ đệm: </td>
        <td><input type="text" name="BoNhoDem" value="<%= ctlt.getBoNhoDem()%>" /></td>
        </tr>
    </table>    
</div>

<div id="body_mid" style="float: left; width: 75%; margin-left: 0px;">
    <form id="frmthemsanpham" method="post" action="process?task=quanlyadmin&task_chitiet=sanpham" enctype="multipart/form-data">
        <table width="100%" border="0" cellspacing="10" cellpadding="2">
            <tr>
            <td>Mã Sản Phẩm</td>
            <td><input type="text" name="MaSanPham" value="<%= sp.getMaSanPham()%>" readonly="readonly" /></td>
            <td rowspan="10" style="vertical-align:top">
                <table width="100%" border="0" cellspacing="2" cellpadding="2">
                    <tr>
                    <td style="width: 35%;"><img src="<%= path_hinhanh%>" width="100px" height="100px" /></td>
                    <td><input style="height: 25px;" type="file" name="HinhDaiDien" value="Browse" /></td>
                    </tr>
                </table>

                <div id="thongtinchitiet" style="float: none;">
                    <%
                        if (sp.getLoaisanpham().getMaLoaiSanPham().equals("DT")) {
                    %>
                    <table class="test" width="100%" border="0" cellspacing="2" cellpadding="2">
                        <tr>
                        <th colspan="2" align="center"><h2>CHI TIẾT ĐIỆN THOẠI</h2></th>
                        </tr>
                        <tr>
                        <td style="width: 35%;">Mạng: </td>
                        <td><input type="text" name="Mang" value="<%= ctdt.getMang()%>" /></td>
                        </tr>
                        <tr>
                        <td style="width: 35%;">Loại màn hình: </td>
                        <td><input type="text" name="LoaiManHinh" value="<%= ctdt.getLoaiManHinh()%>" /></td>
                        </tr>
                        <tr>
                        <td style="width: 35%;">Ngôn ngữ: </td>
                        <td><input type="text" name="NgonNgu" value="<%= ctdt.getNgonNgu()%>" /></td>
                        </tr>
                    </table>
                    <%
                    } else {
                    %>
                    <table class="test" width="100%" border="0" cellspacing="2" cellpadding="2">
                        <tr>
                        <th colspan="2" align="center"><h2>CHI TIẾT LAPTOP</h2></th>
                        </tr>
                        <tr>
                        <td style="width: 35%;">Công nghệ CPU: </td>
                        <td><input type="text" name="CongNgheCPU" value="<%= ctlt.getCongNgheCpu()%>" /></td>
                        </tr>
                        <tr>
                        <td style="width: 35%;">Tốc độ CPU: </td>
                        <td><input type="text" name="TocDoCPU" value="<%= ctlt.getTocDoCpu()%>" /></td>
                        </tr>
                        <tr>
                        <td style="width: 35%;">Bộ nhớ đệm: </td>
                        <td><input type="text" name="BoNhoDem" value="<%= ctlt.getBoNhoDem()%>" /></td>
                        </tr>
                    </table>
                    <%
                        }
                    %>
                </div>
            </td>
            </tr>
            <tr>
            <td>Tên Sản Phẩm</td>
            <td><input type="text" name="TenSanPham" value="<%= sp.getTenSanPham() %>" /></td>
            </tr>
            <tr>
            <td>Loại Sản Phẩm</td>
            <td>
                <select id="MaLoaiSanPham" name="MaLoaiSanPham" style="width: 125px;" >
                    <option <% if(sp.getLoaisanpham().getMaLoaiSanPham().equals("DT")){%>selected="true"<%} %> value="DT" onclick="showthongtin('DT');">- Điện Thoại -</option>
                    <option <% if(sp.getLoaisanpham().getMaLoaiSanPham().equals("LT")){%>selected="true"<%} %> value="LT" onclick="showthongtin('LT');">- Laptop -</option>
                </select>
            </td>
            </tr>
            <tr>
            <td>Mã Hãng <a href="view?task=quanly&task_chitiet=hang">(Tra mã hãng)</a></td>
            <td>
                <input type="text" name="MaHang" value="<%= sp.getHang().getMaHang()%>" />
            </td>
            </tr>
            <tr>
            <td>Số Lượng</td>
            <td><input type="text" name="SoLuong" value="<%= sp.getSoLuong()%>" /></td>
            </tr>
            <tr>
            <td>Giá Bán</td>
            <td><input type="text" name="GiaBan" value="<%= df.format(sp.getGiaBan())%>" /></td>
            </tr>
            <tr>
            <td>Màu Sắc</td>
            <td><input type="text" name="MauSac" value="<%= sp.getMauSac()%>" /></td>
            </tr>
            <tr>
            <td>Thời Gian Bảo Hành</td>
            <td><input type="text" name="ThoiGianBaoHanh" value="<%= sp.getThoiGianBaoHanh()%>" /></td>
            </tr>
            <tr>
            <td>Kích Thước</td>
            <td><input type="text" name="KichThuoc" value="<%= sp.getKichThuoc()%>" /></td>
            </tr>
            <tr>
            <td>Trọng Lượng</td>
            <td><input type="text" name="TrongLuong" value="<%= sp.getTrongLuong()%>" /></td>
            </tr>
            <tr>
            <td align="center" colspan="4">
                <input onclick="chuyentask('&CapNhat=chitiet')" type='submit' name='CapNhat' id='CapNhat' value='Cập Nhật' style="height: 30px"/>
            <span>&nbsp;</span>
            <input type='reset' name='XoaNhapLai' id='XoaNhapLai' value='Xoá Nhập Lại' style="height: 30px"/>
            </td>
            </tr>
        </table>
    </form>
</div>