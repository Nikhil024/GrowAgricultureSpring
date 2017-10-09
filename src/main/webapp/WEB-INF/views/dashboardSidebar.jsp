<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
    <ul class="nav">
	                <li class="<c:if test="${not empty dashboardActive}">active</c:if>">
	                    <a data-toggle="" href="<spring:url value="/dashboard"/>" aria-expanded="true">
	                        <i class="ti-panel"></i>
	                        <p><spring:message code="dashboard.title.name"/></p>
	                    </a>
	                </li>
					<li class="<c:if test="${not empty uploadActive}">active</c:if>">
						<a href="<spring:url value="/upload"/>">
							<i class="ti-package"></i>
							<p><spring:message code="upload.title.name"/></p>
						</a>
					</li>
					<li class="<c:if test="${not empty profileActive}">active</c:if>">
						<a href="<spring:url value="/profile"/>">
							<i class="ti-package"></i>
							<p><spring:message code="profile.title.name"/></p>
						</a>
					</li>
					<li class="<c:if test="${not empty aboutusActive}">active</c:if>">
	                    <a href="<spring:url value="/aboutus"/>">
	                        <i class="ti-bar-chart-alt"></i>
	                        <p><spring:message code="aboutus.title.name"/></p>
	                    </a>
	                </li>
	            </ul>