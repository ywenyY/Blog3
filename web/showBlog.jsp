<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="500.jsp" %>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>${blog.title}</title>
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="all" />
</head>
<body>
	<!-- Header -->
	<div id="header">
		<div class="shell">
			<!-- Logo + Top Nav -->
			<div id="top">
				<h1>
					<a>${blog.title}</a>
				</h1>
				<div id="top-navigation">
					welcome&nbsp;&nbsp;<a><strong>${loginUser.name}</strong>
					</a> <span>|</span> <a href="${pageContext.request.contextPath}/loginServlet">quit</a>
				</div>
			
			<!-- End Logo + Top Nav -->

			<!-- Main Nav -->
			<div id="navigation">
			&nbsp;
					<ul>

						<li><a class="active"><span>content</span>
						</a>
						</li>
					</ul>
				</div>
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
				<a href="${pageContext.request.contextPath}/findBlogByPageServlet">home page</a> <span>&gt;</span>
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
						<!-- Box Head -->
						<div class="box-head">
							<h2>content</h2>
						</div>
						<!-- End Box Head -->

						<form action="edited" method="post">

							<!-- Form -->
							<div class="form">
								<p>

									<label>author<span>*</span>
									</label> <label>${blog.author}</label>
								</p>
								<p>

									<label>title<span>*</span>
									</label> <label>${blog.title}</label>
								</p>
								
								<p class="inline-field">
									<label>Date</label><br>
									<label>${blog.date}</label>
								</p>

								<p>
									<label>content<span>*</span>
									</label>
								<div class="contentStyle">
									<label>${blog.content}</label>
								</div>
								</p>

							</div>
							<!-- End Form -->

							<!-- Form Buttons -->

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
			<span class="left">&copy; 2016 - For xxx</span> <span
				class="right"> Design by <a href="##"
				target="_blank" title="The Sweetest CSS Templates WorldWide">xxxTeam</a>
			</span>
		</div>
	</div>
	<!-- End Footer -->

</body>
</html>
