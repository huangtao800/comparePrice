<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>commodities</title>

<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/commodityList.css" rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" class="active" href="homepage.jsp">iBiJia</a>
			</div>
			<div class="navbar-collapse collapse">
				<div class="navbar-form navbar-right nav navbar-nav">
					<s:action name="userBar" executeResult="true"></s:action>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-6">
        		<form action="commoditySearch" class="form-inline" method="post">
          			<div class="form-group" id="waitlist_email_group">
            			<input class="form-control input-lg waitlist-email" name="search" placeholder="Enter commodity infomation" size="40">
          			</div>
          			<div class="form-group">
            			<button class="btn btn-lg btn-default" type="submit">搜索</button>
          			</div>
        		</form>
  			</div>
  		</div>
  		
  		<div class="row left-space font20">
			<form action="commoditySort" class="form-inline">
				<div class="form-group">
					<label class="label-lg">排序方式:</label>
				</div>
				<div class="form-group">
					<select name = "method" class = "navigation"  onchange="this.form.submit()" class="select-lg">
						<option value="default" <s:if test="%{selectedMethod=='default'}">selected="selected"</s:if>>默认</option>
						<option value="price" <s:if test="%{selectedMethod=='price'}">selected="selected"</s:if>>价格</option>
					</select>
				</div>
			</form>
		</div>
		
		<div class="row">
			<s:iterator value="commodities" status="st">
				<div class="col-md-7 top-space">
					<a class="font20" href=<s:property value="link" />><s:property value="name" /></a>
					<a class="btn btn-primary pull-right">查看评论</a>
				</div>
			</s:iterator>
		</div>
		
	</div>
	<script src="js/jquery-2.1.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>