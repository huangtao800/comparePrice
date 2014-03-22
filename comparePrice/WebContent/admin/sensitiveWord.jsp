<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 董仁广 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sensitive Word</title>
<title>Insert title here</title>
    <link rel="stylesheet" href="<s:url value="../css/bootstrap-theme.min.css" />" />
    <link rel="stylesheet" href="<s:url value="../css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<s:url value="../css/forbidCommodity.css" />" />
    <link rel="stylesheet" href="<s:url value="../css/admin.css" />" />

    <script src=<s:url value="../js/bootstrap.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="../js/jquery-2.1.0.js" /> type="text/javascript"></script>
    <script src=<s:url value="../js/sensitiveWord.js" /> type="text/javascript"></script>
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
          	<li class="active"><a href="sensitiveWord.jsp">敏感词管理</a></li>
            <li><a href="forbidCommodity.jsp">商品屏蔽</a></li>
            <li><a href="brandWeight.jsp">商家权重管理</a></li>
          </ul>
          	<div class="navbar-form navbar-right nav navbar-nav" >
          		<a class="btn btn-success"><s:property value="session.adminId" /></a>
				<a href='<s:url action="adminLogout"/>' class="btn btn-success">logout</a>
			</div> 
        </div>
      </div>
    </div>
    
    <div class="container text-center">
        <div class="input-group" id="search">
             <s:form theme="simple"  role="form"  name="form_commodity_search" method="post" action="/SensitiveWordAction" >
                <s:textfield   id="sensitiveWord" name="sensitiveWord"  cssClass="textfield_mem_uid" placeholder="请输入要添加的敏感词：" />
                <s:submit cssClass="btn btn-primary" id="btn_forbid_search" name="btn_forbid_search" value="添加"/>
            </s:form>
        </div>
        
        <div id="sensitiveWordList" class="row top-buffer">
        
          <table class="table">
            <caption>敏感词列表</caption>
            <tr>
                <th>ID</th>
                <th>敏感词</th>
                <th>操作</th>
            </tr>
            <s:iterator value="sensitiveWordList" id="sensitiveWord" status="st">
                <tr>
                    <td class="td_sensitiveWordId"><s:property value="#sensitiveWord.id" /></td>
                    <td><s:property value="#sensitiveWord.name" /></td>
                    <td>
                        <s:a cssClass="btn btn-primary removeSensitiveWord">删除</s:a>
                    </td>
                </tr>
            </s:iterator>
          </table>
        
        </div>
    
    </div>

</body>
</html>