<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="HeaderCss.jsp"></jsp:include>
<title>${fn:toUpperCase(fn:substring(register, 0, 1))}${fn:toLowerCase(fn:substring(register, 1,fn:length(register)))}</title>
<style>
.page-header[filter-color="orange"] {
	background: linear-gradient(0deg, rgba(44, 44, 44, 0.2), #636c72);
}
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	if(window.location.href.indexOf('otp') > -1 ){
	$('.register-text').attr('style','margin: 24px 4px 32px -181px !important;');
	}
});
</script>
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
				<a class="navbar-brand" href="<spring:url value="/"/>" rel="tooltip"
					title="Designed and Coded by Nikhil" data-placement="bottom">
					<spring:message code="project.name"/> </a>
			</div>
			<div class="collapse navbar-collapse justify-content-end"
				id="navigation" data-nav-image="./assets/img/blurred-image-1.jpg">
				<ul class="navbar-nav">
					<c:if test="${!showOTPSection}">
					 <li class="nav-item">
                        <a class="nav-link" href="<spring:url value="/login"/>">
                            <i class="now-ui-icons"><img alt="login" src="<spring:url value="/resources/icons/login.png"/>"/></i>
                            <p>${login}</p>
                        </a>
                    </li>
					<li class="nav-item"><a class="nav-link"
						href="<spring:url value="/forgotPassword"/>"> <i
							class="now-ui-icons"><img alt="register"
								src="<spring:url value="/resources/icons/forgotPassword.png"/>" /></i>
							<p>${forgotpassword}</p>
					</a></li>
					</c:if>
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

	<!-- End Navbar -->
	<div class="wrapper">
		<div class="page-header clear-filter" filter-color="orange">
			<div class="page-header-image" data-parallax="true"
				style="background-image: url('<spring:url value="/resources/img/${background_name}"/>');">
			</div>
			<div class="container">

				<div class="content-center brand">

					<%-- <img class="n-logo" src="<spring:url value="/resources/img/now-logo.png"/>" alt="">
                    <h1 class="h1-seo">Grow Agriculture.</h1>
                    <h3>A Dedication to the Farmers of INDIA.</h3> --%>
					<spring:url value="/" var="formUrl" />
					
					<form:form action="${formUrl}register/${form_name}" method="POST"
						modelAttribute="registerFormBean">
						<h1 class="h1-seo">${register}</h1>
						<div class="farmer">
							<h3 class="register-text">${user_register}</h3>
							<c:if test="${empty showOTPSection}">
							<div class="col-sm-4">
								<div class="input-group form-group-no-border">
									<span class="input-group-addon"> <i class=""><img
											class="icon-input-size" alt=""
											src="<spring:url value="/resources/icons/phone.png"/>"></i>
									</span>
									<form:input path="phoneNumber" cssClass="form-control"
										placeholder="${register_placeholder_text}" value="" />

								</div>
								<span class="badge badge-danger"><form:errors
										path="phoneNumber" /></span>
							</div>
							<div class="col-sm-4">
								<div class="input-group form-group-no-border">
									<span class="input-group-addon"> <i class=""><img
											class="icon-input-size" alt=""
											src="<spring:url value="/resources/icons/password.png"/>"></i>
									</span>
									<form:input path="password" type="password"
										cssClass="form-control" placeholder="Password" />
								</div>
								<span class="badge badge-danger"><form:errors
										path="password" /></span>
							</div>
							</c:if>
							<c:if test="${showOTPSection}">
							<div class="col-sm-4">
								<div class="input-group form-group-no-border">
									<span class="input-group-addon"> <i class=""><img
											class="icon-input-size" alt=""
											src="<spring:url value="/resources/icons/pin.png"/>"></i>
									</span>
									<form:input path="OTP" cssClass="form-control"
										placeholder="${register_placeholder_text}" value="" />

								</div>
								<span class="badge badge-danger"><form:errors
										path="OTP" /></span>
								<form:input path="phoneNumber" type="hidden" value="${phoneNumber}" />
								<form:input path="sessionId" type="hidden" value="${sessionId}" />
							</div>
							</c:if>
						</div>
						<input type="submit"
							class="register-button-position btn btn-primary btn-simple"
							value="Validate" />
					</form:form>
					<form action="" method="">
						<c:if test="${showResendOTP}">
							<input type="submit"
								class="register-button-position btn btn-warning btn-simple"
								value="Resend OTP" />
						</c:if>
					</form>
					<c:if test="${not empty showUserAlreadyExists}">
								<div class="error-banner-display alert alert-danger" role="alert">
									<div class="container">
										<div class="alert-icon">
											<i class="now-ui-icons objects_support-17"></i>
										</div>
										<spring:message code="phone.already.exists"/>
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true"> <i
												class="now-ui-icons ui-1_simple-remove"></i>
											</span>
										</button>
									</div>
								</div>
							</c:if>
					<c:if test="${not empty showRegsiterSuccess}">
						<div class="error-banner-display alert alert-success" role="alert">
							<div class="container">
								<div class="alert-icon">
									<i class="icons-style now-ui-icons ui-2_like"></i>
								</div>
								<spring:message code="register.success"/>
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true"> <i
										class="now-ui-icons ui-1_simple-remove"></i>
									</span>
								</button>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
<jsp:include page="BodyJS.jsp"></jsp:include>

</html>