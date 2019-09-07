<%--
  Created by IntelliJ IDEA.
  User: Jessica
  Date: 2019/8/29
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="500.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
  <title>back-stage management</title>
  <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
  <script>
    function deleteBlog(id) {
      if(confirm("sure to delete it ?")){
        location.href="${pageContext.request.contextPath}/delBlogServlet?id="+id;
      }
    }
    function nextPage(currentPage,totalPage) {
      if(currentPage==totalPage){
        confirm("没有下一页了噢")
      }else{
        location.href="${pageContext.request.contextPath}/findBlogByPageServlet?currentPage=${pb.totalPage}?rows=8"+currentPage;
      }
    }
  </script>
</head>
<body>
<!-- Header -->
<div id="header">
  <div class="shell">
    <!-- Logo + Top Nav -->
    <div id="top">
      <h1><a href="#">MagicWolf</a></h1>
      <div id="top-navigation">
        welcome &nbsp;&nbsp;<strong>${loginUser.name}</strong>
        <span>|</span>
        <a href="login.jsp">quit</a>
      </div>
    </div>
    <!-- End Logo + Top Nav -->

    <!-- Main Nav -->
    <div id="navigation">
      <ul>
        <li><a href="/Blog/findBlogByPageServlet" class="active"><span>home page</span></a></li>
        <li><a href="publish.jsp" ><span>publish</span></a></li>
      </ul>
    </div>
    <!-- End Main Nav -->
  </div>
</div>
<!-- End Header -->

<!-- Container -->
<div id="container">
  <div class="shell">

    <!-- Small Nav -->
    <div class="small-nav">
      <a href="/Blog/findBlogByPageServlet">home page</a>
      <span></span>
      article list
    </div>
    <!-- End Small Nav -->

    <br />
    <!-- Main -->
    <div id="main">
      <div class="cl">&nbsp;</div>

      <!-- Content -->
      <div id="content">

        <!-- Box -->
        <div class="box">
          <form action="${pageContext.request.contextPath}/searchBlogServlet?rows=8" method="post">
          <!-- Box Head -->
          <div class="box-head">
            <h2 class="left">article list</h2>
            <div class="right">
              <label>title</label>
              <input type="text" name ="title" class="field small-field" />
              <label>author</label>
              <input type="text" name ="author" class="field small-field" />
              <label>date</label>
              <input type="text" name ="date"  class="field small-field" />
              <input type="submit" class="button" value="search" />
            </div>
          </div>
          <!-- End Box Head -->
          </form>
          <!-- Table -->
          <div class="table">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><input type="checkbox" class="checkbox" /></td>
              <th>number</th>
              <th>title</th>
              <th>date</th>
              <th>author</th>
              <th width="110" class="ac"></th>
            </tr>
            <c:forEach items="${pb.list}" var="blogs" varStatus="s">
              <tr class="odd">
                <td><input type="checkbox" class="checkbox" /></td>
                <td>${s.count}</td>
                <td><a href="${pageContext.request.contextPath}/findBlogForShowServlet?id=${blogs.id}"> ${blogs.title}</a></td>
                <td>${blogs.date}</td>
                <td>${blogs.author}</td>
                <c:if test="${loginUser.spe == 1}"><td><a href="javascript:deleteBlog(${blogs.id});" class="ico edit">delete</a></c:if>
                <c:if test="${loginUser.spe == 1}"><a href="${pageContext.request.contextPath}/findBlogServlet?id=${blogs.id}" class="ico edit">Edit</a></td></c:if>
              </tr>
            </c:forEach>
            <!--<tr class="odd">
                <td><input type="checkbox" class="checkbox" /></td>
                <td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
                <td>12.05.09</td>
                <td><a href="#">管理员</a></td>
                <td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
            </tr>
            <tr class="odd">
                <td><input type="checkbox" class="checkbox" /></td>
                <td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
                <td>12.05.09</td>
                <td><a href="#">管理员</a></td>
                <td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
            </tr>
            <tr class="odd">
                <td><input type="checkbox" class="checkbox" /></td>
                <td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
                <td>12.05.09</td>
                <td><a href="#">管理员</a></td>
                <td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
            </tr>-->
            </table>


            <!-- Pagging -->
            <div class="pagging">
              <div class="left">1-2</div>
              <div class="right">
                    <a href="${pageContext.request.contextPath}/findBlogByPageServlet?currentPage=${pb.currentPage - 1}&rows=8">last</a>
                <c:forEach begin="1" end ="${pb.totalPage}" var = "i">
                   <a href="${pageContext.request.contextPath}/findBlogByPageServlet?currentPage=${i}&rows=8">${i}</a>
                </c:forEach>
                <span>...</span>
                <a href="${pageContext.request.contextPath}/findBlogByPageServlet?currentPage=${pb.totalPage}&rows=8">${pb.totalPage}</a>
                <!--<a href="javascript:nextPage();">下一页</a>-->
                <c:if test="${pb.currentPage != pb.totalPage}"><a href="${pageContext.request.contextPath}/findBlogByPageServlet?currentPage=${pb.currentPage + 1}&rows=8">next</a></c:if>
                <a href="${pageContext.request.contextPath}/findBlogByPageServlet?currentPage=${pb.totalPage}&rows=8">final page</a>
              </div>
            </div>
            <!-- End Pagging -->

          </div>
          <!-- Table -->

        </div>
        <!-- End Box -->

      </div>
      <!-- End Content -->
      <div class="cl">&nbsp;</div>
    </div>
    <!-- Main -->
  </div>
</div>
<!-- End Container -->

<!-- Footer -->
<div id="footer">
  <div class="shell">
    <span class="left">&copy; 2010 - CompanyName</span>
    <span class="right">
			Design by <a href="http://chocotemplates.com" target="_blank" title="The Sweetest CSS Templates WorldWide">Chocotemplates.com</a>
		</span>
  </div>
</div>
<!-- End Footer -->

</body>
</html>
