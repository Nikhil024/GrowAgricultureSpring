<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <jsp:include page="HeaderCss.jsp"></jsp:include>  
    <title>Login</title>
</head>

<body class="index-page" style="overflow:hidden;">
    <!-- Navbar -->
    <nav class="navbar navbar-toggleable-md bg-primary fixed-top navbar-transparent " color-on-scroll="500">
        <div class="container">
            <div class="navbar-translate">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar bar1"></span>
                    <span class="navbar-toggler-bar bar2"></span>
                    <span class="navbar-toggler-bar bar3"></span>
                </button>
                <a class="navbar-brand" href="<spring:url value="/"/>" rel="tooltip" title="Designed and Coded by Nikhil" data-placement="bottom">
                    Grow Agriculture
                </a>
            </div>
            <div class="collapse navbar-collapse justify-content-end" id="navigation" data-nav-image="./assets/img/blurred-image-1.jpg">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="<spring:url value="/register"/>">
                            <i class="now-ui-icons"><img alt="register" src="<spring:url value="/resources/icons/register.png"/>"/></i>
                            <p>Register</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<spring:url value="/forgotPassword"/>">
                            <i class="now-ui-icons"><img alt="register" src="<spring:url value="/resources/icons/forgotPassword.png"/>"/></i>
                            <p>Forgot Password</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<spring:url value="/aboutUs"/>">  <!-- target="_blank" -->
                            <i class="now-ui-icons"><img alt="aboutus" src="<spring:url value="/resources/icons/aboutus.png"/>"/></i>
                            <p>About Us</p>
                        </a>
                    </li>
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
 -->                </ul>
            </div>
        </div>
    </nav>
    <!-- End Navbar -->
    <div class="wrapper">
        <div class="page-header clear-filter" filter-color="orange">
            <div class="page-header-image" data-parallax="true" style="background-image: url('<spring:url value="/resources/img/home.jpg"/>');">
            </div>
            <div class="container">
                <div class="content-center brand">
                    <%-- <img class="n-logo" src="<spring:url value="/resources/img/now-logo.png"/>" alt="">
                    <h1 class="h1-seo">Grow Agriculture.</h1>
                    <h3>A Dedication to the Farmers of INDIA.</h3> --%>
				<form:form method="POST" commandName="user">
					<h1 class="h1-seo">Login</h1>
					<div class="farmer">
					<h3 class="login-text">Farmer Login</h3>
					<div class="col-sm-4">
						<div class="input-group form-group-no-border">
							<span class="input-group-addon"> <i class=""><img
									class="icon-input-size" alt=""
									src="<spring:url value="/resources/icons/phone.png"/>"></i>
							</span> <input type="text" class="form-control"
								placeholder="Enter your number">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group form-group-no-border">
							<span class="input-group-addon"> <i class=""><img
									class="icon-input-size" alt=""
									src="<spring:url value="/resources/icons/pin.png"/>"></i>
							</span> <input type="password" class="form-control"
								placeholder="Password">
						</div>
					</div>
					</div>
					<div class="verticalLine"></div>
					
					<div class="buyer buyer-login-page">
					
						<h3 class="buyer-login-text">Buyer Login</h3>
					<div class="col-lg-19">
						<div class="input-group form-group-no-border">
							<span class="input-group-addon"> <i class=""><img
									class="icon-input-size" alt=""
									src="<spring:url value="/resources/icons/phone.png"/>"></i>
							</span> <input type="text" class="form-control"
								placeholder="Enter your number">
						</div>
					</div>
					<div class="col-lg-19">
						<div class="input-group form-group-no-border">
							<span class="input-group-addon"> <i class=""><img
									class="icon-input-size" alt=""
									src="<spring:url value="/resources/icons/pin.png"/>"></i>
							</span> <input type="password" class="form-control"
								placeholder="Password">
						</div>
					</div>
					
					</div>
					<%-- <h6 class="category category-absolute">Designed by
                    <a href="http://invisionapp.com/" target="_blank">
                        <img src="<spring:url value="/resources/img/invision-white-slim.png"/>" class="invision-logo" />
                    </a>. Coded by
                    <a href="https://www.creative-tim.com" target="_blank">
                        <img src="<spring:url value="/resources/img/creative-tim-white-slim2.png"/>" class="creative-tim-logo" />
                    </a>.</h6> --%>
            </div>
            <button class="btn btn-primary btn-simple" style="margin: 593px -15px 0 0 !important;padding: 14px 40px !important;">Login</button>
            </form:form>
        </div>
    </div>
</body>
<jsp:include page="BodyJS.jsp"></jsp:include>

</html>