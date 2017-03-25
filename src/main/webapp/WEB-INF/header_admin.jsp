<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<!-- Head tag stores the title and the relevant libraries that are needed.-->
<head>
<title>Welcome to StuffSpot.</title>
   
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link  rel="stylesheet" type = "text/css" href="/Trane_TestCase_Repository/bootstrap/css/bootstrap.min.css" >
<script type="text/javascript" src="/Trane_TestCase_Repository/bootstrap/js/jquery-3.1.0.js"></script>
<script type="text/javascript" src="/Trane_TestCase_Repository/bootstrap/js/bootstrap.min.js"></script>

<!-- Start of style, These classes are for the carousel buttons -->
<style>   
#carouselButtons {
margin-left: 100px;
position: absolute;
bottom: 0px;
}
.carousel-caption {
position: relative;
left: auto;
right: auto;
color: black;
}
</style>
<!-- End of style -->      
</head>


<body>

<!-- This is the title message in the body that is to be displayed in all pages -->
<div class="jumbotron text-center">
<h1>Welcome to Stuff Spot.</h1>
<p>Your Economy Supermarket at your convenience.<br />
Hello! Dear ${currentUser}.
</p> 
<p color = "blue">${msg}</p>
</div>




<!-- ****************Start of the navigation bar**********************-->
<nav class="navbar navbar-default" role="navigation">
<div class="navbar-header">
  <button type="button" class="navbar-toggle" data-toggle="collapse"
	data-target="#example-navbar-collapse">
	<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
	<span class="icon-bar"></span> <span class="icon-bar"></span>
  </button>
	<a class="navbar-brand" href="/Trane_TestCase_Repository/all_landing">HOME</a>
	
</div>

<div class="collapse navbar-collapse" id="example-navbar-collapse">
<ul class="nav navbar-nav">
	<a class="navbar-brand" href="/Trane_TestCase_Repository/admin_add_category">CATEGORY</a>
</ul>
<ul class="nav navbar-nav">
	<a class="navbar-brand" href="/Trane_TestCase_Repository/admin_add_supplier">SUPPLIER</a>
</ul>
<ul class="nav navbar-nav">
	<a class="navbar-brand" href="/Trane_TestCase_Repository/admin_add_product">PRODUCT</a>
</ul>
    
<ul>
	<a class="navbar-brand pull-right" href="/Trane_TestCase_Repository/j_spring_security_logout">Logout</a>
</ul>
</div>
</nav>
<!-- ****************End of the navigation bar**********************-->


</body>
</html>