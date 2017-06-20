<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <jsp:include page="HeaderCss.jsp"></jsp:include>  
    <title>GrowAgriculture</title>
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
                <a class="navbar-brand" href="" rel="tooltip" title="Designed and Coded by Nikhil" data-placement="bottom" target="_blank">
                    Grow Agriculture
                </a>
            </div>
            <div class="collapse navbar-collapse justify-content-end" id="navigation" data-nav-image="./assets/img/blurred-image-1.jpg">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="<spring:url value="/login"/>">
                            <i class="now-ui-icons"><img alt="login" src="<spring:url value="/resources/icons/login.png"/>"/></i>
                            <p>Login</p>
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
            <div class="page-header-image" data-parallax="true" style="background-image: url('<spring:url value="/resources/img/header.jpg"/>');">
            </div>
            <div class="container">
                <div class="content-center brand">
                    <img class="n-logo" src="<spring:url value="/resources/img/now-logo.png"/>" alt="">
                    <h1 class="h1-seo">Grow Agriculture.</h1>
                    <h3>A Dedication to the Farmers of INDIA.</h3>
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