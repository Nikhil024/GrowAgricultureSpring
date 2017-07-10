<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--   Core JS Files   -->
<script src="<spring:url value="/resources/js/core/jquery.3.2.1.min.js"/>" type="text/javascript"></script>
<script src="<spring:url value="/resources/js/core/tether.min.js"/>" type="text/javascript"></script>
<script src="<spring:url value="/resources/js/core/bootstrap.min.js"/>" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="<spring:url value="/resources/js/plugins/bootstrap-switch.js"/>"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="<spring:url value="/resources/js/plugins/nouislider.min.js"/>" type="text/javascript"></script>
<!--  Plugin for the DatePicker, full documentation here: https://github.com/uxsolutions/bootstrap-datepicker -->
<script src="<spring:url value="/resources/js/plugins/bootstrap-datepicker.js"/>" type="text/javascript"></script>
<!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
<script src="<spring:url value="/resources/js/now-ui-kit.js"/>" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function() {
        // the body of this function is in assets/js/now-ui-kit.js
        nowuiKit.initSliders();
   	});

	function scrollToDownload() {

		if ($('.section-download').length != 0) {
			$("html, body").animate({
				scrollTop : $('.section-download').offset().top
			}, 1000);
		}
	}
</script>