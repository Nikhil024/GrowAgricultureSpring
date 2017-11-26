<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="../../assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="../../assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title><spring:message code="dashboard.title.name"/></title>
<style>

<<<<<<< HEAD:src/main/webapp/WEB-INF/views/dashboard.jsp
.img__wrap:hover .img__description {
  visibility: visible;
  opacity: 1;
}

=======
	@import url(https://fonts.googleapis.com/css?family=Raleway);

*, *:before, *:after{
  margin: 0;
  padding: 0;
  -webkit-box-sizing: border-box;
  -moz-box-sizing:border-box;
  box-sizing: border-box;
}

body{
  background: #f9f9f9;
  font-size: 16px;
  font-family: 'Raleway', sans-serif;
}

.main-title{
  color: #2d2d2d;
  text-align: center;
  text-transform: capitalize;
  padding: 0.7em 0;
}

.container-hover{
  padding: 1em 0;
  float: left;
  width: 50%;
}
@media screen and (max-width: 640px){
  .container-hover{
    display: block;
    width: 100%;
  }
}

@media screen and (min-width: 900px){
  .container-hover{
    width: 33.33333%;
  }
}

.container-hover .title{
  color: #1a1a1a;
  text-align: center;
  margin-bottom: 10px;
}

.content-hover {
  position: relative;
  width: 90%;
  max-width: 400px;
  margin: auto;
}

.content-hover .content-overlay {
  background: rgba(0,0,0,0.7);
  position: absolute;
  height: 1223%;
  width: 100%;
  left: 0;
  top: -100px;
  bottom: 0;
  right: 0;
  opacity: 0;
  -webkit-transition: all 0.4s ease-in-out 0s;
  -moz-transition: all 0.4s ease-in-out 0s;
  transition: all 0.4s ease-in-out 0s;
}

.content-hover:hover .content-overlay{
  opacity: 1;
}

.content-image{
  width: 100%;
}

.content-details {
  position: absolute;
  text-align: center;
  padding-left: 1em;
  padding-right: 1em;
  width: 100%;
  top: 50%;
  left: 50%;
  opacity: 0;
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  -webkit-transition: all 0.3s ease-in-out 0s;
  -moz-transition: all 0.3s ease-in-out 0s;
  transition: all 0.3s ease-in-out 0s;
}

.content-hover:hover .content-details{
  top: 50%;
  left: 50%;
  opacity: 1;
}

.content-details h3{
  color: #fff;
  font-weight: 500;
  letter-spacing: 0.15em;
  margin-bottom: 0.5em;
  text-transform: uppercase;
}

.content-details p{
  color: #fff;
  font-size: 0.8em;
}

.fadeIn-bottom{
  top: 80%;
}

.fadeIn-top{
  top: 20%;
}

.fadeIn-left{
  left: 20%;
}

.fadeIn-right{
  left: 80%;
}
	
>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d:src/main/webapp/WEB-INF/views/dashboardComponent.jsp
</style>

<jsp:include page="dashboardHeader.jsp"></jsp:include>
</head>

<body>
	<div class="wrapper">
	    <jsp:include page="dashboardSidebar.jsp"></jsp:include>
	    <div class="main-panel" style="overflow: auto;">
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
	                    <a class="navbar-brand" href="#Dashboard">
							<spring:message code="dashboard.title.name"/></a>
	                </div>
	                <div class="collapse navbar-collapse">

						<!-- <form class="navbar-form navbar-left navbar-search-form" role="search">
	    					<div class="input-group">
	    						<span class="input-group-addon"><i class="fa fa-search"></i></span>
	    						<input type="text" value="" class="form-control" placeholder="Search...">
	    					</div>
	    				</form> -->

	                   <!--  <ul class="nav navbar-nav navbar-right">
	                        <li>
	                            <a href="#stats" class="dropdown-toggle btn-magnify" data-toggle="dropdown">
	                                <i class="ti-panel"></i>
									<p>Stats</p>
	                            </a>
	                        </li>
	                        <li class="dropdown">
	                            <a href="#notifications" class="dropdown-toggle btn-rotate" data-toggle="dropdown">
	                                <i class="ti-bell"></i>
	                                <span class="notification">5</span>
									<p class="hidden-md hidden-lg">
										Notifications
										<b class="caret"></b>
									</p>
	                            </a>
	                            <ul class="dropdown-menu">
	                                <li><a href="#not1">Notification 1</a></li>
	                                <li><a href="#not2">Notification 2</a></li>
	                                <li><a href="#not3">Notification 3</a></li>
	                                <li><a href="#not4">Notification 4</a></li>
	                                <li><a href="#another">Another notification</a></li>
	                            </ul>
	                        </li>
							<li>
	                            <a href="#settings" class="btn-rotate">
									<i class="ti-settings"></i>
									<p class="hidden-md hidden-lg">
										Settings
									</p>
	                            </a>
	                        </li>
	                    </ul> -->
	                </div>
	            </div>
	        </nav>

	        <div class="content">
	            <div class="container-fluid">
	              <!--   <div class="row">
	                    <div class="col-lg-3 col-sm-6">
	                        <div class="card">
	                            <div class="card-content">
	                                <div class="row">
	                                    <div class="col-xs-5">
	                                        <div class="icon-big icon-warning text-center">
	                                            <i class="ti-server"></i>
	                                        </div>
	                                    </div>
	                                    <div class="col-xs-7">
	                                        <div class="numbers">
	                                            <p>Capacity</p>
	                                            105GB
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
								<div class="card-footer">
									<hr />
									<div class="stats">
										<i class="ti-reload"></i> Updated now
									</div>
								</div>
	                        </div>
	                    </div>
	                    <div class="col-lg-3 col-sm-6">
	                        <div class="card">
	                            <div class="card-content">
	                                <div class="row">
	                                    <div class="col-xs-5">
	                                        <div class="icon-big icon-success text-center">
	                                            <i class="ti-wallet"></i>
	                                        </div>
	                                    </div>
	                                    <div class="col-xs-7">
	                                        <div class="numbers">
	                                            <p>Revenue</p>
	                                            $1,345
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
								<div class="card-footer">
									<hr />
									<div class="stats">
										<i class="ti-calendar"></i> Last day
									</div>
								</div>
	                        </div>
	                    </div>
	                    <div class="col-lg-3 col-sm-6">
	                        <div class="card">
	                            <div class="card-content">
	                                <div class="row">
	                                    <div class="col-xs-5">
	                                        <div class="icon-big icon-danger text-center">
	                                            <i class="ti-pulse"></i>
	                                        </div>
	                                    </div>
	                                    <div class="col-xs-7">
	                                        <div class="numbers">
	                                            <p>Errors</p>
	                                            23
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
								<div class="card-footer">
									<hr />
									<div class="stats">
										<i class="ti-timer"></i> In the last hour
									</div>
								</div>
	                        </div>
	                    </div>
	                    <div class="col-lg-3 col-sm-6">
	                        <div class="card">
	                            <div class="card-content">
	                                <div class="row">
	                                    <div class="col-xs-5">
	                                        <div class="icon-big icon-info text-center">
	                                            <i class="ti-twitter-alt"></i>
	                                        </div>
	                                    </div>
	                                    <div class="col-xs-7">
	                                        <div class="numbers">
	                                            <p>Followers</p>
	                                            +45
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
								<div class="card-footer">
									<hr />
									<div class="stats">
										<i class="ti-reload"></i> Updated now
									</div>
								</div>
	                        </div>
	                    </div>
	                </div> -->
					<!-- <div class="row">
						<div class="col-lg-4 col-sm-6">
							<div class="card">
								<div class="card-content">
									<div class="row">
										<div class="col-xs-7">
											<div class="numbers pull-left">
												$34,657
											</div>
										</div>
										<div class="col-xs-5">
											<div class="pull-right">
												<span class="label label-success">
		 											+18%
												</span>
											</div>
										</div>
									</div>
									<h6 class="big-title">total earnings <span class="text-muted">in last</span> ten <span class="text-muted">quarters</span></h6>
		                            <div id="chartTotalEarnings"></div>
								</div>
								<div class="card-footer">
									<hr>
									<div class="footer-title">Financial Statistics</div>
									<div class="pull-right">
										<button class="btn btn-info btn-fill btn-icon btn-sm">
											<i class="ti-plus"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-sm-6">
							<div class="card">
								<div class="card-content">
									<div class="row">
										<div class="col-xs-7">
											<div class="numbers pull-left">
												169
											</div>
										</div>
										<div class="col-xs-5">
											<div class="pull-right">
												<span class="label label-danger">
		 											-14%
												</span>
											</div>
										</div>
									</div>
									<h6 class="big-title">total subscriptions <span class="text-muted">in last</span> 7 days</h6>
		                            <div id="chartTotalSubscriptions"></div>
								</div>
								<div class="card-footer">
									<hr>
									<div class="footer-title">View all members</div>
									<div class="pull-right">
										<button class="btn btn-default btn-fill btn-icon btn-sm">
											<i class="ti-angle-right"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-sm-6">
							<div class="card">
								<div class="card-content">
									<div class="row">
										<div class="col-xs-7">
											<div class="numbers pull-left">
												8,960
											</div>
										</div>
										<div class="col-xs-5">
											<div class="pull-right">
												<span class="label label-warning">
		 											~51%
												</span>
											</div>
										</div>
									</div>
									<h6 class="big-title">total downloads <span class="text-muted">in last</span> 6 years</h6>
		                            <div id="chartTotalDownloads" ></div>
								</div>
								<div class="card-footer">
									<hr>
									<div class="footer-title">View more details</div>
									<div class="pull-right">
										<button class="btn btn-success btn-fill btn-icon btn-sm">
											<i class="ti-info"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div> -->
					<c:if test="${not empty isFarmer}">
					<div class="row">
						<div class="col-lg-3 col-sm-6">
							<div class="card card-circle-chart" data-background-color="blue">
								<div class="card-header text-center">
	                                <h5 class="card-title"><spring:message code="profile.title.name"/></h5>
	                                <p class="description"><spring:message code="profile.description"/></p>
	                            </div>
								<div class="card-content">
									<div id="chartDashboard" class="chart-circle" data-percent="${profile_completion}">${profile_completion}%</div>
								</div>
							</div>
						</div>
<<<<<<< HEAD:src/main/webapp/WEB-INF/views/dashboard.jsp
						<div class="col-lg-9 col-xs-4">
						<div class="card">
								<div class="card-header text-center">
									<h5 class="card-title"><spring:message code="others.images.title.name"/></h5>
									<hr>
								</div>
								<div class="card-content">
									<div style="display: inline-flex;overflow-y: hidden;overflow-x: visible;">
									   <c:forEach var="notCurrentUser" items="${notCurrentUser}">
										 <img style="width: 43%;height: 223px;" class="img-thumbnail" src="<spring:url value="/images/"/>other/${notCurrentUser.name}" alt=""/>
									</c:forEach>
									</div>
							</div>
						</div>
					</div>
					</div>

					<div class="col-md-12">
						<div class="card">
								<div class="card-header text-center">
									<h5 class="card-title"><spring:message code="own.images.title.name"/></h5>
									<hr>
								</div>
								<div class="card-content">
									<div class="">
									   <c:forEach var="currentUser" items="${currentUser}">
										 <img style="width: 43%;height: 223px;" class="img-thumbnail" src="<spring:url value="/images/"/>other/${currentUser.name}" alt=""/>
									</c:forEach>
									</div>
							</div>
						</div>
					</div>


=======
						
						  <c:if test="${not empty notCurrentUser}">
							<div class="col-lg-9 col-xs-4">
							<div class="card">
									<div class="card-header text-center">
										<h5 class="card-title"><spring:message code="others.images.title.name"/></h5>
										<hr>
									</div>
									<div class="card-content">
										<div style="display: inline-flex;overflow-y: hidden;overflow-x: visible;">
										<c:set var="count" value="0"/>
										   <c:forEach var="notCurrentUser" items="${notCurrentUser}">
											 <img id="${count}" style="width: 43%;height: 223px;" onmouseover="bigImg(this.id)" onmouseout="normalImg(this)" class="img-thumbnail" src="<spring:url value="/images/"/>other/${notCurrentUser.name}" alt=""/>
										<c:set var="count" value="${count + 1}"/>
										</c:forEach>
										</div>
								</div>
							</div>
						</div>
						
					</c:if>
					</div>


					
					<div class="col-md-12">
						<div class="card">
								<div class="card-header text-center">
									<h5 class="card-title"><spring:message code="own.images.title.name"/></h5>
									<hr>
								</div>
								<div class="card-content">
									<div class="">
									   <c:forEach var="currentUser" items="${currentUser}">
										 <img style="width: 43%;height: 223px;" class="img-thumbnail" src="<spring:url value="/images/"/>other/${currentUser.name}" alt=""/>
									</c:forEach>
									</div>
							</div>
						</div>
					</div>
</c:if>


				<c:if test="${not empty isBuyer}">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header text-center">
								<h5 class="card-title">
									<spring:message code="others.images.title.name" />
								</h5>
								<hr>
							</div>
							<div class="card-content"
								style="overflow-x: visible; overflow-y: hidden; width: 99%;">
								<div>
									<c:set var="count" value="0" />
									<c:forEach var="allPics" items="${allPics}">
										<div class="container-hover">
											<div class="content-hover">
												<a onclick="document.forms['image${count}'].submit();return false;">
													<div class="content-overlay"></div> <img id="${count}"
													style="height: 223px;width: 530px;max-width: 348px;"
													class="img-thumbnail"
													src="<spring:url value="/images/"/>other/${allPics.name}"
													alt="" />
													<br/>
													<div class="content-details fadeIn-top">
														<h3>
															<spring:message code="farmers.images.seemore" />
														</h3>
														<p>
														  <spring:message code="farmers.images.clickhere" />
														</p>
													</div>
													<form name="image${count}" action="/agriculture/dashboard/viewMore" method="post">
													<input type="hidden" name="usersId" value="${allPics.usersId}">
													</form>
													</a>
											</div>
										</div>
										<c:set var="count" value="${count + 1}" />
									</c:forEach>
									
								</div>
							</div>
						</div>
					</div>
	</c:if>



	<c:if test="${not empty viewMore}">
	
	<div class="col-md-12">
						<div class="card">
								<div class="card-header text-center">
									<h5 class="card-title">
									<spring:message code="farmer.name.images.title.name" arguments="${farmerName}" htmlEscape="false"/>
									</h5>
									<hr>
								</div>
								<div class="card-content">
									<div class="">
									   <c:forEach var="currentUser" items="${currentUser}">
										 <img style="width: 43%;height: 223px;" class="img-thumbnail" src="<spring:url value="/images/"/>other/${currentUser.name}" alt=""/>
									</c:forEach>
									</div>
							</div>
						</div>
					</div>
	
	</c:if>








>>>>>>> d346bddbf80137e46bed0978a42d22d486f51d5d:src/main/webapp/WEB-INF/views/dashboardComponent.jsp
				</div>
	        </div>
	    </div>
	</div>

</body>

	<jsp:include page="dashboardBody.jsp"></jsp:include>



	<script type="text/javascript">
    	$(document).ready(function(){
			demo.initOverviewDashboard();
			demo.initCirclePercentage();

    	});
    	
    	function bigImg(x) {
    	    var class1 = $('#'+x).attr('class');
    	   console.log($('#'+x).addClass('view view-tenth mask'));
    	}

    	function normalImg(x) {
    	    x.style.height = "223px";
    	    x.style.width = "43%";
    	}
	</script>

</html>
