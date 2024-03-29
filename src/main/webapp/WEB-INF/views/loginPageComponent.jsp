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
<title>${fn:toUpperCase(fn:substring(login, 0, 1))}${fn:toLowerCase(fn:substring(login, 1,fn:length(login)))}</title>
<style>
.page-header[filter-color="orange"] {
	background: linear-gradient(0deg, rgba(44, 44, 44, 0.2), #636c72);
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
				<a class="navbar-brand" href="<spring:url value="/"/>" rel="tooltip"
					title="Designed and Coded by Nikhil" data-placement="bottom">
					${project_name} </a>
			</div>
			<div class="collapse navbar-collapse justify-content-end"
				id="navigation" data-nav-image="./assets/img/blurred-image-1.jpg">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="<spring:url value="/register"/>"> <i
							class="now-ui-icons"><img alt="register"
								src="<spring:url value="/resources/icons/register.png"/>" /></i>
							<p>${register}</p>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<spring:url value="/forgotPassword"/>"> <i
							class="now-ui-icons"><img alt="register"
								src="<spring:url value="/resources/icons/forgotPassword.png"/>" /></i>
							<p>${forgotpassword}</p>
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
					<form:form action="${formUrl}login/${form_name}" method="POST"
						modelAttribute="loginFormBean">
						<h1 class="h1-seo">${login}</h1>
						<div class="farmer">
							<h3 class="login-text">${user_login}</h3>
							<div class="col-sm-4">
								<div class="input-group form-group-no-border">
									<span class="input-group-addon"> <i class=""><img
											class="icon-input-size" alt=""
											src="<spring:url value="/resources/icons/phone.png"/>"></i>
									</span>
									<form:input path="phoneNumber" cssClass="form-control"
										placeholder="${login_placeholder_text}" value="" />

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
						</div>
						<input type="submit"
							class=" login-button-position btn btn-primary btn-simple"
							value="${login}" />
					</form:form>
				</div>
			</div>
			<c:if test="${not empty passwordError || not empty nouserError || not empty otpnotVerifiedError || not empty wrongUserType}">
			<div class="alert alert-danger" role="alert"
				style="margin: -369px 372px 61px 361px; <c:if test="${not empty otpnotVerifiedError}"> margin: -369px 318px 61px 348px; </c:if> ">
				<div class="container">
					<div class="alert-icon">
						<i class="now-ui-icons objects_support-17"></i>
					</div>
					<c:if test="${not empty passwordError}">
						<spring:message code="login.passwordError" />
					</c:if>
					<c:if test="${not empty nouserError}">
						<spring:message code="login.noUserError" />
					</c:if>
					<c:if test="${not empty otpnotVerifiedError}">
						<spring:message code="login.otpNotVerifiedError" />
					</c:if>
					<c:if test="${not empty wrongUserType}">
						<spring:message code="login.wrongUserType" arguments="${user_type}" htmlEscape="false"/>
					</c:if>
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
</body>
<jsp:include page="BodyJS.jsp"></jsp:include>

</html>