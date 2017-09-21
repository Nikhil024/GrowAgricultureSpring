<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="HeaderCss.jsp"></jsp:include>
<title><spring:message code="project.name"/></title>
<style>
.bg-one {
	background-image: url(<spring:url value="/resources/img/BuyerPopupPic.jpg"/>);
}

.bg-two {
	background-image: url(<spring:url value="/resources/img/FarmerPopupPic.jpg"/>);
}


.bg-three {
	background-image: url(<spring:url value="/resources/img/farmerRegister.gif"/>);
}

.bg-four {
	background-image: url(<spring:url value="/resources/img/buyerRegister.gif"/>);
}

.modal-header{
	padding-top: 0 !important;
}

.modal-title{
	margin-left: 97px !important;
}

.modal-content .modal-body {
    padding-top: 0;
}

</style>
</head>

<body class="index-page" style="overflow: hidden;">
	<!-- Navbar -->
	<nav
		class="navbar navbar-toggleable-md bg-primary fixed-top navbar-transparent "
		color-on-scroll="500">
		<div class="container">
			<div class="navbar-translate">
				<button class="navbar-toggler navbar-toggler-right" type="button"
					data-toggle="collapse" data-target="#navigation"
					aria-controls="navigation-index" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-bar bar1"></span> <span
						class="navbar-toggler-bar bar2"></span> <span
						class="navbar-toggler-bar bar3"></span>
				</button>
				<a class="navbar-brand" href="" rel="tooltip"
					title="Designed and Coded by Nikhil" data-placement="bottom"
					target="_blank"> <spring:message code="project.name"/> </a>
			</div>
			<div class="collapse navbar-collapse justify-content-end"
				id="navigation" data-nav-image="./assets/img/blurred-image-1.jpg">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="<spring:url value="/login"/>" data-toggle="modal"
						data-target="#loginModal"> <i class="now-ui-icons"><img
								alt="login"
								src="<spring:url value="/resources/icons/login.png"/>" /></i>
							<p>${login}</p>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<spring:url value="/register"/>" data-toggle="modal"
						data-target="#registerModal"> <i
							class="now-ui-icons"><img alt="register"
								src="<spring:url value="/resources/icons/register.png"/>" /></i>
							<p>${register}</p>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<spring:url value="/aboutUs"/>"> <!-- target="_blank" -->
							<i class="now-ui-icons"><img alt="aboutus"
								src="<spring:url value="/resources/icons/aboutus.png"/>" /></i>
							<p>${aboutus}</p>
					</a></li>
					<!--                     <li class="nav-item">
                        <a class="nav-link" rel="tooltip" title="Follow us on Twitter" data-placement="bottom" href="https://twitter.com/CreativeTim" target="_blank">
                            <i class="fa fa-twitter"></i>
                            <p class="hidden-lg-up">Twitter</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" rel="tooltip" title="Like us on Facebook" data-placement="bottom" href="https://www.facebook.com/CreativeTim" target="_blank">
                            <i class="fa fa-facebook-square"></i>
                            <p class="hidden-lg-up">Facebook</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" rel="tooltip" title="Follow us on Instagram" data-placement="bottom" href="https://www.instagram.com/CreativeTimOfficial" target="_blank">
                            <i class="fa fa-instagram"></i>
                            <p class="hidden-lg-up">Instagram</p>
                        </a>
                    </li>
 -->
				</ul>
			</div>
		</div>
	</nav>
	<!-- Modal Core -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel"><spring:message code="login.popup.title"/></h4>
				</div>
				<div class="modal-body">

					<div class="wrapper">
						<a href="/agriculture/login/buyerLogin">
							<div class="parent" onclick="">
								<div class="child bg-one">
									<span id="loginpopup"><spring:message code="buyerLogin.title.name"/></span>
								</div>
							</div>
						</a>
						
						<a href="/agriculture/login/farmerLogin">
							<div class="parent" onclick="">
								<div class="child bg-two">
									<span id="loginpopup"><spring:message code="farmerLogin.title.name"/></span>
								</div>
							</div>
						</a>
						
					</div>


				</div>
				<!-- <div class="modal-footer">
        <button type="button" class="btn btn-default btn-simple" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-info btn-simple">Save</button>
      </div> -->
			</div>
		</div>
	</div>

<div class="modal fade" id="registerModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel"><spring:message code="register.popup.title"/></h4>
				</div>
				<div class="modal-body">

					<div class="wrapper">
						<a href="/agriculture/register/buyerRegister">
							<div class="registerparent" onclick="">
								<div class="child bg-four">
									<span id="registerpopup"><b><spring:message code="buyerRegister.title.name"/></b></span>
								</div>
							</div>
						</a>
						
						<a href="/agriculture/register/farmerRegister">
							<div class="registerparent" onclick="">
								<div class="child bg-three">
									<span id="registerpopup"><b><spring:message code="farmerRegister.title.name"/></b></span>
								</div>
							</div>
						</a>
						
					</div>


				</div>
				<!-- <div class="modal-footer">
        <button type="button" class="btn btn-default btn-simple" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-info btn-simple">Save</button>
      </div> -->
			</div>
		</div>
	</div>


	<!-- End Navbar -->
	<div class="wrapper">
		<div class="page-header clear-filter" filter-color="orange">
			<div class="page-header-image" data-parallax="true"
				style="background-image: url('<spring:url value="/resources/img/${landing_page_background_image_name}"/>');">
			</div>
			<div class="container">
				<div class="content-center brand">
					<img class="n-logo"
						src="<spring:url value="/resources/img/${landing_page_logo_image_name}"/>"
						alt="">
					<h1 class="animated pulse infinite h1-seo">${project_name}</h1>
					<h3>${landing_page_description}</h3>
				</div>
				<%-- <h6 class="category category-absolute">Designed by
                    <a href="http://invisionapp.com/" target="_blank">
                        <img src="<spring:url value="/resources/img/invision-white-slim.png"/>" class="invision-logo" />
                    </a>. Coded by
                    <a href="https://www.creative-tim.com" target="_blank">
                        <img src="<spring:url value="/resources/img/creative-tim-white-slim2.png"/>" class="creative-tim-logo" />
                    </a>.</h6> --%>
			</div>
		</div>
	</div>
</body>
<jsp:include page="BodyJS.jsp"></jsp:include>

</html>