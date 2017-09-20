<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

/* Image zoom on hover + Overlay colour */
.parent {
    width: 45%;
	margin: 11px;
	height: 331px;
	border: 0px solid blue;
	overflow: hidden;
	position: relative;
	float: left;
	display: inline-block;
	cursor: pointer;
}

.child {
    height: 100%;
    width: 100%;
    background-size: cover;
    background-repeat: no-repeat;
    -webkit-transition: all .5s;
    -moz-transition: all .5s;
    -o-transition: all .5s;
    transition: all .5s;
}

/* Several different images */
.bg-one {background-image: url(<spring:url value="/resources/img/BuyerPopupPic.jpg"/>);}
.bg-two {background-image: url(<spring:url value="/resources/img/FarmerPopupPic.jpg"/>);}

#loginpopup{
    display: none;
    font-size: 35px;
    color: #ffffff !important;
    font-family: sans-serif;
    text-align: center;
    margin: auto;
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
    height: 50px;
    cursor: pointer;
    /*text-decoration: none;*/
}

.parent:hover .child, .parent:focus .child {
    -ms-transform: scale(1.2);
    -moz-transform: scale(1.2);
    -webkit-transform: scale(1.2);
    -o-transform: scale(1.2);
    transform: scale(1.2);
}

.parent:hover .child:before, .parent:focus .child:before {
    display: block;
}

.parent:hover #loginpopup, .parent:focus #loginpopup {
    display: block;
}

.child:before {
    content: "";
    display: none;
    height: 100%;
    width: 100%;
    position: absolute;
    top: 0;
    left: 0;
    background-color: rgba(52,73,94,0.75);
}

</style>
</head>
<body>


<div class="wrapper">
    <div class="parent" onclick="">
        <div class="child bg-one">
            <a id="loginpopup" href="#">Buyer Login</a>
        </div>
    </div>
	
	<div class="parent" onclick="">
        <div class="child bg-two">
            <a id="loginpopup" href="#">Farmer Login</a>
        </div>
    </div>
</div>


</body>
</html>