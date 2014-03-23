<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>compare price</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/homepage.css" rel="stylesheet">
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
			<a class="navbar-brand" class="active" href="../user/homepage.jsp">iBiJia</a>
        </div>
        <div class="navbar-collapse collapse">
          	<div class="navbar-form navbar-right nav navbar-nav" >
          		<s:action namespace="/user" name="userBar" executeResult="true"></s:action>
			</div> 
        </div>
      </div>
    </div>
    
	<div style="font-size:80px; margin-top:80px; margin-left:50px;">当前商品尚无评论</div>
	<a class="navbar-brand" class="active" style="margin-left:50px" href="../user/homepage.jsp">•̩̩̩́ ˑ̫ •̩̩̩̀ 对不起，因为程序猿偷懒所以你只能回到主页了...</a>


</body>
</html>

