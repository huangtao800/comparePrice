<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Crawler Website</title>
    <link rel="stylesheet" href="<s:url value="/css/bootstrap-theme.min.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/forbidCommodity.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/admin.css" />" />

    <script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
    <script src=<s:url value="/js/sensitiveWord.js" /> type="text/javascript"></script>
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
            <li class="active"><a href="<s:url action='CheckCrawlerWebsiteAction'/>">爬虫网站</a></li>
          	<li><a href='crawler.jsp'>开始爬取</a></li>
          	<li><a href='synonymImport.jsp'>导入同义词</a></li>
          </ul>
          	<div class="navbar-form navbar-right nav navbar-nav" >
          		<a class="btn btn-success"><s:property value="session.dbAdminId" /></a>
				<a href='<s:url action="dbAdminLogout"/>' class="btn btn-success">logout</a>
			</div> 
        </div>
      </div>
    </div>

    <div class="container">
        <br>
        
        <div>
            <table class="table">
                <caption>爬取的网站列表</caption>
                <tr>
                	<td>编号</td>
                	<td>网站名</td>
                	<td>链接</td>
                </tr>
                <s:iterator value="crawlerWebsiteList"  status="st">
                <tr>
                    <td><s:property value="id" /></td>
                    <td><s:property value="name" /></td>
                    <td><s:property value="link" /></td>
                </tr>
                </s:iterator>
            </table>
        
        </div>
    
    </div>

</body>
</html>