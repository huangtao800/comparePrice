<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Login</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
</head>
<body>
    <div class="container">
	<form class="form-signin" role="form" action="userLogin">
		<h2 class="form-signin-heading">Please sign in</h2>
		<%String failMsg = (String)session.getAttribute("fail");
		if (failMsg != null) {%>
		<span class="error"><%=failMsg%></span>
		<%} %>
        <input type="text" class="form-control" name="userId" placeholder="ID" required autofocus>
        <input type="password" class="form-control" name="password" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
      </form>
    </div> <!-- /container -->

    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>