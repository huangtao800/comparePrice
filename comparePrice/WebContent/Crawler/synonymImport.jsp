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