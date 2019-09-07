<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="500.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>Edit blog</title>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>
<body>
<!-- Header -->
<div id="header">
	<div class="shell">
		<!-- Logo + Top Nav -->
		<div id="top">
			<h1><a href="#">MagicWolf</a></h1>
			<div id="top-navigation">
				<span>|</span>
				<a href="#">quit</a>
			</div>
		</div>
		<!-- End Logo + Top Nav -->
		
		<!-- Main Nav -->
		<div id="navigation">
			<ul>
			    <li><a href="update.jsp" class="active"><span>Edit blog</span></a></li>
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
		<!-- End Small Nav -->
				
		<br />
		<!-- Main -->
		<div id="main">
			<div class="cl">&nbsp;</div>
			
			<!-- Content -->
			<div id="content">
				
				
				<!-- Box -->
				<div class="box">
					<!-- Box Head -->
					<div class="box-head">
						<h2>编辑博客</h2>
					</div>
					<!-- End Box Head -->
					
					<form action="${pageContext.request.contextPath}/updateBlogServlet" method="post">
						
						<!-- Form -->
						<div class="form">
								<p>
									<span class="req"></span>
									<label>title<span>*</span></label>
									<input type="text" name ="title" value="${blog.title}" class="field size1" />
								</p>	
								<p class="inline-field">
									<label>Date</label>
									<input type="text" name ="date" value="${blog.date}" class="field size2"/>
									<label>Writer</label>
									<input type="text" name="author" value="${blog.author}" class="field size3"/>
								</p>
							<!--隐藏域用来提交id-->
								<input type="hidden" name="id" value="${blog.id}"/>
								<p>
									<label>content<span>*</span></label>
									<textarea name="content" value="${blog.content}"class="field size1" rows="10" cols="30"></textarea>
								</p>	
							
						</div>
						<!-- End Form -->
						
						<!-- Form Buttons -->
						<div class="buttons">
							<input type="button" class="button" value="preview" />
							<button type="submit">submit</button>
						</div>

						<!-- End Form Buttons -->
					</form>
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