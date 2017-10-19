<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


	<!--   Core JS Files. Extra: TouchPunch for touch library inside jquery-ui.min.js   -->
	<script src="<spring:url value="/resources/dashboard/js/jquery-3.1.1.min.js"/>" type="text/javascript"></script>
	<script src="<spring:url value="/resources/dashboard/js/jquery-ui.min.js"/>" type="text/javascript"></script>
	<script src="<spring:url value="/resources/dashboard/js/perfect-scrollbar.min.js"/>" type="text/javascript"></script>
	<script src="<spring:url value="/resources/dashboard/js/bootstrap.min.js"/>" type="text/javascript"></script>

	<!--  Forms Validations Plugin -->
	<script src="<spring:url value="/resources/dashboard/js/jquery.validate.min.js"/>"></script>
	
	<script src="<spring:url value="/resources/dashboard/js/nouislider.min.js"/>"></script>

	<!-- Promise Library for SweetAlert2 working on IE -->
	<script src="<spring:url value="/resources/dashboard/js/es6-promise-auto.min.js"/>"></script>

	<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
	<script src="<spring:url value="/resources/dashboard/js/moment.min.js"/>"></script>

	<!--  Date Time Picker Plugin is included in this js file -->
	<script src="<spring:url value="/resources/dashboard/js/bootstrap-datetimepicker.js"/>"></script>

	<!--  Select Picker Plugin -->
	<script src="<spring:url value="/resources/dashboard/js/bootstrap-selectpicker.js"/>"></script>

	<!--  Switch and Tags Input Plugins -->
	<script src="<spring:url value="/resources/dashboard/js/bootstrap-switch-tags.js"/>"></script>

	<!-- Circle Percentage-chart -->
	<script src="<spring:url value="/resources/dashboard/js/jquery.easypiechart.min.js"/>"></script>

	<!--  Charts Plugin -->
	<script src="<spring:url value="/resources/dashboard/js/chartist.min.js"/>"></script>

	<!--  Notifications Plugin    -->
	<script src="<spring:url value="/resources/dashboard/js/bootstrap-notify.js"/>"></script>

	<!-- Sweet Alert 2 plugin -->
	<script src="<spring:url value="/resources/dashboard/js/sweetalert2.js"/>"></script>

	<!-- Vector Map plugin -->
	<script src="<spring:url value="/resources/dashboard/js/jquery-jvectormap.js"/>"></script>

	<!--  Google Maps Plugin    -->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAFPQibxeDaLIUHsC6_KqDdFaUdhrbhZ3M"></script>

	<!-- Wizard Plugin    -->
	<script src="<spring:url value="/resources/dashboard/js/jquery.bootstrap.wizard.min.js"/>"></script>

	<!--  Bootstrap Table Plugin    -->
	<script src="<spring:url value="/resources/dashboard/js/bootstrap-table.js"/>"></script>

	<!--  Plugin for DataTables.net  -->
	<script src="<spring:url value="/resources/dashboard/js/jquery.datatables.js"/>"></script>

	<!--  Full Calendar Plugin    -->
	<script src="<spring:url value="/resources/dashboard/js/fullcalendar.min.js"/>"></script>

	<!-- Paper Dashboard PRO Core javascript and methods for Demo purpose> -->
	<script src="<spring:url value="/resources/dashboard/js/paper-dashboard.js?v=1.2.1"/>"></script>

    <!--   Sharrre Library    -->
    <script src="<spring:url value="/resources/dashboard/js/jquery.sharrre.js"/>"></script>

    <!-- Paper Dashboard PRO DEMO methods, don't include it in your proj -->
	<script src="<spring:url value="/resources/dashboard/js/demo.js"/>"></script>
	
	
	
	<script type="text/javascript">
    	$(document).ready(function(){
			demo.initOverviewDashboard();
			demo.initCirclePercentage();
    	});
	</script>