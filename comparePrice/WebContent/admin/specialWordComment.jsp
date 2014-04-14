<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<s:url value="/css/bootstrap-theme.min.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/candidateWord.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/admin.css" />" />

    <script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>候选词评论</title>
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
			<a class="navbar-brand" class="active" >iBiJia</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
          	<li><a href='<s:url action="ManageSensitiveCommentAction"/>'>敏感评论</a></li>
          	<li><a href='<s:url action="SensitiveWordAction"/>'>敏感词</a></li>
          	<li><a href='<s:url action="CheckNavyAction"/>'>水军</a></li>
            <li><a href='<s:url action="BeforeForbidAction"/>'>商品屏蔽</a></li>
            <li><a href='<s:url action="BrandWeightAction"/>'>商家权重</a></li>
            <li><a href='<s:url action="candidateWordAction"/>'>商家候选词</a></li>
            <li class="active"><a href='<s:url action="specialWordCommentAction"/>'>候选词评论</a></li>
            <li><a href='<s:url action="CrawlerWebsiteAction"/>'>爬虫网站</a></li>
          </ul>
          	<div class="navbar-form navbar-right nav navbar-nav" >
          		<a class="btn btn-success"><s:property value="session.adminId" /></a>
				<a href='<s:url action="adminLogout"/>' class="btn btn-success">logout</a>
			</div> 
        </div>
      </div>
    </div>
    
    <div class="container text-center">
        <div id="sensitiveWordList" class="row top-buffer">
          <table class="table">
            <caption>候选词评论列表</caption>
            <tr>
                <td>商家</td>
                <td>评论</td>
                <td>操作</td>
            </tr>
            <s:iterator value="specialWordCommentList" status="st">
                <tr>
                    <td><s:property value="commodity.brand.name" /></td>
                    <td><s:property value="details" /></td>
                    <td>
                        <a class="btn btn-primary removeSensitiveWord" 
                        	href='cancelSpecial?commentId=<s:property value="id"/>'>已通知</a>
                    </td>
                </tr>
            </s:iterator>
          </table>
        </div>
    </div>
</body>
</html>