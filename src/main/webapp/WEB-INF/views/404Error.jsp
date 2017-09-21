<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html class="no-js">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>404</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
	
	<link rel="stylesheet" href="<spring:url value="/resources/error/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<spring:url value="/resources/error/css/animate.css"/>">
	<link rel="stylesheet" href="<spring:url value="/resources/error/css/style.css"/>">


	<script src="<spring:url value="/resources/error/js/modernizr-2.6.2.min.js"/>"></script>

	</head>
	<body>


		
		
		<div class="container fh5co-container">

			<div class="row">
				<div class="col-md-12 animate-box" data-animate-effect="fadeIn">
					<div class="fh5co-404-wrap" id="video" data-vide-bg="<spring:url value="/resources/error/video/Crocodile"/>" data-vide-options="position: 0 50%">
						<div class="overlay"></div>
					</div>
				</div>
				<div class="col-md-12 text-center fh5co-404-text animate-box"  data-animate-effect="fadeIn">
					<h2>Looks like you got lost</h2>
					<p><a href="/agriculture/" class="btn btn-primary">Go back home</a></p>
				</div>
				<div class="col-md-12 text-center fh5co-copyright animate-box" data-animate-effect="fadeInUp">
					<p><small>&copy; All Rights Reserved. Designed by <a href="#">Nikhil</a> Video by <a href="http://www.coverr.co/" rel="nofollow" target="_blank">Coverr</a></small></p>
				</div>
			</div>
		
		</div>
	
	<!-- jQuery -->
	<script src="<spring:url value="/resources/error/js/jquery.min.js"/>"></script>
	<!-- Bootstrap -->
	<script src="<spring:url value="/resources/error/js/bootstrap.min.js"/>"></script>
	<!-- Vide -->
	<script src="<spring:url value="/resources/error/js/jquery.vide.min.js"/>"></script>
	<!-- Waypoints -->
	<script src="<spring:url value="/resources/error/js/jquery.waypoints.min.js"/>"></script>
	<!-- Main JS -->
	<script src="<spring:url value="/resources/error/js/main.js"/>"></script>


	</body>
</html>

