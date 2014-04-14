<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Login</title>

	<link href="http://localhost:8080/comparePrice/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://localhost:8080/comparePrice/css/login.css" rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
        <div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            	<span class="icon-bar"></span>
            	<span class="icon-bar"></span>
            	<span class="icon-bar"></span>
          	</button>
			<a class="navbar-brand" class="active" href="homepage.jsp">iBiJia</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="<s:url action='CheckCrawlerWebsiteAction'/>">爬虫网站</a></li>
          	<li class="active"><a href='crawler.jsp'>开始爬取</a></li>
          	<li><a href="synonymImport.jsp">导入同义词</a></li>
          </ul>
          	<div class="navbar-form navbar-right nav navbar-nav" >
          		<a class="btn btn-success"><s:property value="session.dbAdminId" /></a>
				<a href='<s:url action="dbAdminLogout"/>' class="btn btn-success">logout</a>
			</div> 
        </div>
      </div>
    </div>


    <div class="container">
    <!-- http://localhost:8080/comparePrice/admin/UpdateCrawler -->
	<form class="form-signin" role="form" action="/comparePrice/admin/UpdateCrawler" method="post">
		<h2 class="form-signin-heading">Update Commodity</h2>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
      </form>
    </div> <!-- /container -->
    
    <script src="../js/jquery-2.1.0.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>