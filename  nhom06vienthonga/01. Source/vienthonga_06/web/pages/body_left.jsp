<%@page import="MODEL.POJO.Hang"%>
<%@page import="java.util.List"%>
<%@page import="MODEL.DAO.HangDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Hang> list = HangDAO.LayHang();
%>

<div id="body_left" style="float: left; width: 15%; margin-left: -25px;">
    <div class="highlightLev"> <div style="background: none repeat scroll 0% 0% transparent; width: 160px; height: 115px; display: none;" class="blocksearch">
            <a href=""><img src="images/linhtinh/icon_muahang.jpg" /></a>
        </div>
        <div style="background: none repeat scroll 0% 0% transparent; width: 160px; height: 160px;" class="blocksearch">
            <a href="">
                <img border="0" width="160" style="display: block; margin: 0pt auto;" src="images/linhtinh/_tuyendung.jpg" />
            </a>
        </div>	

        <br />
        <div class="blocSearch">
            <form style="background-image: url(images/linhtinh/bgd_top_timkiem.gif);" method="post" action="process?task=timkiem" name="frmSearch" id="frmSearch">
                <input type="hidden" value="com_search" id="option" name="option" />
                <input type="hidden" value="search" id="task" name="task" />
                <h2>Tìm kiếm</h2>
                <input type="text" name="TSP" id="TSP" />
                <select name="MLSP" id="MLSP">
                    <option value="-1">- Tất Cả -</option>
                    <option value="DT">- Điện Thoại -</option>
                    <option value="LT">- Laptop -</option>
                </select>
                <select name="MH" id="MH">
                    <option value="-1">- Chọn hãng -</option>
                    <%
                        for (int i = 0; i < list.size(); i++) {
                            %>
                            <option value="<%= list.get(i).getMaHang() %>">- <%= list.get(i).getTenHang()%> -</option>                            
                            <%
                        }
                    %>
                </select>

                <select style="width: 140px;" class="slsType01" name="Gia" id="Gia">
                    <option value="-1">- Chọn Giá -</option>
                    <option value="0"> Dưới 3,000,000 </option>                    
                    <option value="3000000"> 3,000,000 đến 5,000,000 </option>
                    <option value="5000000"> 5,000,000 đên 7,000,000 </option>
                    <option value="7000000"> 7,000,000 đến 9,000,000 </option>
                    <option value="9000000"> Trên 9,000,000 </option>
                </select>

                <input style="margin-bottom: 5px;" type="image" class="btnSearch" name="Search" id="Search" src="images/linhtinh/btn_timkiem.gif" />

            </form>
        </div>
        <div class="blocCategory">
            <h2 style="background-image: url(images/linhtinh/bgd_title.gif)" >Hãng Sản Xuất</h2>
            <ul>
                <%
                    for (int i = 0; i < list.size(); i++) {
                        Hang h = list.get(i);

                %>
                <li>
                    <a style="text-transform: none;" href="view?task=sanphamtheohang&MH=<%= h.getMaHang()%>"><%= h.getTenHang()%></a>
                </li> 
                <%
                    }
                %>

            </ul>
        </div>                                                                                                                           
    </div>
</div>