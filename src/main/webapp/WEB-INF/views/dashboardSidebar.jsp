<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
	            <div class="sidebar" data-background-color="brown" data-active-color="danger">
	    <!--
			Tip 1: you can change the color of the sidebar's background using: data-background-color="white | brown"
			Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
		-->
			<div class="logo">
				<a href="http://www.creative-tim.com" class="simple-text logo-mini">
					GA
				</a>

				<a href="http://www.creative-tim.com" class="simple-text logo-normal">
					<spring:message code="project.name"/>
				</a>
			</div>
	    	<div class="sidebar-wrapper">
				<div class="user">
	                <div class="photo">
	                    <img src="../../assets/img/faces/face-2.jpg" />
	                </div>
	                <div class="info">
						<a data-toggle="collapse" href="#collapseExample" class="collapsed">
	                        <span>
								${fname} ${lname}
		                        <b class="caret"></b>
							</span>
	                    </a>
						<div class="clearfix"></div>

	                    <div class="collapse" id="collapseExample">
	                        <ul class="nav">
	                            <li>
									<a href="#profile">
										<span class="sidebar-mini">Mp</span>
										<span class="sidebar-normal">My Profile</span>
									</a>
								</li>
	                            <li>
									<a href="#edit">
										<span class="sidebar-mini">Ep</span>
										<span class="sidebar-normal">Edit Profile</span>
									</a>
								</li>
	                            <li>
									<a href="#settings">
										<span class="sidebar-mini">S</span>
										<span class="sidebar-normal">Settings</span>
									</a>
								</li>
	                        </ul>
	                    </div>
	                </div>
	            </div>
	            <ul class="nav">
	                <li class="<c:if test="${not empty dashboardActive}">active</c:if>">
	                    <a data-toggle="" href="<spring:url value="/dashboard"/>" aria-expanded="true">
	                        <i class="ti-book"></i>
	                        <p><spring:message code="dashboard.title.name"/></p>
	                    </a>
	                </li>
					<li class="<c:if test="${not empty uploadActive}">active</c:if>">
						<%-- <a href="<spring:url value="/upload"/>"> --%>
						<a onclick="demo.showSwal('file-upload')">
							<i class="ti-export"></i>
							<p><spring:message code="upload.title.name"/></p>
						</a>
					</li>
					<li class="<c:if test="${not empty profileActive}">active</c:if>">
						<a href="<spring:url value="/profile"/>">
							<i class="ti-id-badge"></i>
							<p><spring:message code="profile.title.name"/></p>
						</a>
					</li>
					<li class="<c:if test="${not empty farmersListActive}">active</c:if>">
	                    <a href="<spring:url value="/farmersList"/>">
	                        <i class="ti-view-list-alt"></i>
	                        <p><spring:message code="farmersList.title.name"/></p>
	                    </a>
	                </li>
					<li class="<c:if test="${not empty aboutusActive}">active</c:if>">
	                    <a href="<spring:url value="/aboutus"/>">
	                        <i class="ti-comments-smiley"></i>
	                        <p><spring:message code="aboutus.title.name"/></p>
	                    </a>
	                </li>
	            </ul>
	    	</div>
	    </div>
	            
	            
	            
	            