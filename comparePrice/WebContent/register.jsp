<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
</head>
<body>
    <div class="container">
	<form class="form-signin" role="form" action="userRegister">
		<h2 class="form-signin-heading">Please register in</h2>
        <input type="text" class="form-control" name="username" placeholder="Name" required autofocus>
        <input type="password" class="form-control" name="password" placeholder="Password" required>
        <input type="password" class="form-control" name="repeatPassword" placeholder="Repeat Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
      </form>
    </div> <!-- /container -->

    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</body>
</html>