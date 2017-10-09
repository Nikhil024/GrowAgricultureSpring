<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html lang="en">
<head>

	<title><spring:message code="profile.title.name"/></title>

<jsp:include page="dashboardHeader.jsp"></jsp:include>
</head>

<body>
	<div class="wrapper">
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
								Chet Faker
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
	             <jsp:include page="dashboardSidebar.jsp"></jsp:include>
	    	</div>
	    </div>

	    <div class="main-panel">
			<nav class="navbar navbar-default">
	            <div class="container-fluid">
					<div class="navbar-minimize">
						<button id="minimizeSidebar" class="btn btn-fill btn-icon"><i class="ti-more-alt"></i></button>
					</div>
	                <div class="navbar-header">
	                    <button type="button" class="navbar-toggle">
	                        <span class="sr-only">Toggle navigation</span>
	                        <span class="icon-bar bar1"></span>
	                        <span class="icon-bar bar2"></span>
	                        <span class="icon-bar bar3"></span>
	                    </button>
	                    <a class="navbar-brand" href="#userpage"><spring:message code="profile.title.name"/></a>
	                </div>
	            </div>
	        </nav>

	        <div class="content">
	            <div class="container-fluid">
	                <div class="row">
	                    <div class="col-lg-4 col-md-5">
	                        <div class="card card-user">
	                            <div class="image">
	                                <img src="../../assets/img/background.jpg" alt="..."/>
	                            </div>
	                            <div class="card-content">
	                                <div class="author">
	                                  <img class="avatar border-white" src="../../assets/img/faces/face-2.jpg" alt="..."/>
	                                  <h4 class="card-title">Chet Faker<br />
	                                     <a href="#"><small>@chetfaker</small></a>
	                                  </h4>
	                                </div>
	                                <p class="description text-center">
	                                    "I like the way you work it <br>
	                                    No diggity <br>
	                                    I wanna bag it up"
	                                </p>
	                            </div>
	                            <hr>
	                            <div class="text-center">
	                                <div class="row">
	                                    <div class="col-md-3 col-md-offset-1">
	                                        <h5>12<br /><small>Files</small></h5>
	                                    </div>
	                                    <div class="col-md-4">
	                                        <h5>2GB<br /><small>Used</small></h5>
	                                    </div>
	                                    <div class="col-md-3">
	                                        <h5>24<br /><small>Views</small></h5>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-lg-8 col-md-7">
	                        <div class="card">
	                            <div class="card-header">
	                                <h4 class="card-title">Edit Profile</h4>
	                            </div>
	                            <div class="card-content">
	                                <form:form path="/<spring:message code=""/>" modelAttribute="profileFormBean">
	                                    <div class="row">
	                                        <div class="col-md-5">
	                                            <div class="form-group">
	                                                <label>Company</label>
	                                                <input type="text" class="form-control border-input" disabled placeholder="Company" value="Creative Code Inc.">
	                                            </div>
	                                        </div>
	                                        <div class="col-md-3">
	                                            <div class="form-group">
	                                                <label>Username</label>
	                                                <input type="text" class="form-control border-input" placeholder="Username" value="michael23">
	                                            </div>
	                                        </div>
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label for="exampleInputEmail1">Email address</label>
	                                                <input type="email" class="form-control border-input" placeholder="Email">
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="row">
	                                        <div class="col-md-6">
	                                            <div class="form-group">
	                                                <label>First Name</label>
	                                                <input type="text" class="form-control border-input" placeholder="Company" value="Chet">
	                                            </div>
	                                        </div>
	                                        <div class="col-md-6">
	                                            <div class="form-group">
	                                                <label>Last Name</label>
	                                                <input type="text" class="form-control border-input" placeholder="Last Name" value="Faker">
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="row">
	                                        <div class="col-md-12">
	                                            <div class="form-group">
	                                                <label>Address</label>
	                                                <input type="text" class="form-control border-input" placeholder="Home Address" value="Melbourne, Australia">
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="row">
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>City</label>
	                                                <input type="text" class="form-control border-input" placeholder="City" value="Melbourne">
	                                            </div>
	                                        </div>
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>Country</label>
	                                                <input type="text" class="form-control border-input" placeholder="Country" value="Australia">
	                                            </div>
	                                        </div>
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>Postal Code</label>
	                                                <input type="number" class="form-control border-input" placeholder="ZIP Code">
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="row">
	                                        <div class="col-md-12">
	                                            <div class="form-group">
	                                                <label>About Me</label>
	                                                <textarea rows="5" class="form-control border-input" placeholder="Here can be your description" value="Mike">
Oh so, your weak rhyme
You doubt I'll bother, reading into it
I'll probably won't, left to my own devices
But that's the difference in our opinions.
													</textarea>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="text-center">
	                                        <button type="submit" class="btn btn-info btn-fill btn-wd">Update Profile</button>
	                                    </div>
	         				</form:form>
	                                    <div class="clearfix"></div>
	                                </form>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>

	    </div>
	</div>

</body>

<jsp:include page="dashboardBody.jsp"></jsp:include>
	
</html>
