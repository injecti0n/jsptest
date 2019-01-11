<%@page import="jsptest.ControllerServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
div#header {
	height: 10%;
	background-color: yellow;
}

#left {
	float: left;
	border: 1px solid red;
}

#right {
	float: right;
	border: 1px solid blue;
}

#center {
	margin-left: 50px;
	margin-right: 50px;
	border: 1px solid green;
	text-align: center;
}

footer {
	height: 10%;
	background-color: #353535;
	color: white;
	padding: 23px;
}

#left img#mylogo {
	
}
</style>
</head>
<body>
	<div id="header">

		<div id="left">LOGO</div>
		<div id="center">RANDOM_STRING_METHOD_FOR_TITLE</div>

	</div>
	<div class="container">
		<form method="post">
			<br /> <br /> <br /> <input name="name"
				value="Type your name and enter" type="txt">
		</form>
		<h1>Hello ${greeting} Friend!</h1>
		<p>
			Today's date:
			<%=(new java.util.Date()).toLocaleString()%></p>
		<p>
			Your ip address: ${ip}</p>

	</div>
	<footer> footer </footer>
</body>
</html>
