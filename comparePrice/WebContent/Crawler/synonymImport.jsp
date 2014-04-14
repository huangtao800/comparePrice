<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Synonym Import</title>
	<link href="<s:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<s:url value="/css/login.css" />" rel="stylesheet">
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
          	<li><a href="crawler.jsp">开始爬取</a></li>
          	<li class="active"><a href="synonymImport.jsp">导入同义词</a></li>
          </ul>
          	<div class="navbar-form navbar-right nav navbar-nav" >
          		<a class="btn btn-success"><s:property value="session.dbAdminId" /></a>
				<a href='<s:url action="dbAdminLogout"/>' class="btn btn-success">logout</a>
			</div> 
        </div>
      </div>
    </div>

    <div class="container">
	<form class="form-signin" role="form" action="<s:url action="SynonymImportAction" namespace="/Crawler"/>" 
		enctype="multipart/form-data" method="post">
		<h2 class="form-signin-heading">Import Synonyms</h2>
		<div class="form-group">
			<s:file name="file"></s:file>
		</div>
		<div class="form-group">
        	<button class="btn btn-lg btn-primary btn-block" type="submit">Import</button>
        </div>
      </form>
    </div> <!-- /container -->
    
    <script src="<s:url value="/js/jquery-2.1.0.min.js" />"></script>
    <script src="<s:url value="/js/bootstrap.min.js" />"></script>
  </body>
</html>