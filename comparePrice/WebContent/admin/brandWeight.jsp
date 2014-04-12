<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <s:head theme="simple"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="<s:url value="/css/bootstrap-theme.min.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/forbidCommodity.css" />" />

    <script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
    <script src=<s:url value="/js/brandWeight.js" /> type="text/javascript"></script>
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
          	<li><a href='<s:url action="SensitiveWordAction"/>'>敏感词管理</a></li>
            <li><a href='<s:url action="BeforeForbidAction"/>'>商品屏蔽</a></li>
            <li class="active"><a href='<s:url action="BrandWeightAction"/>'>商家权重管理</a></li>
            <li><a href='<s:url action="candidateWordAction"/>'>商家候选词管理</a></li>
          </ul>
          	<div class="navbar-form navbar-right nav navbar-nav" >
          		<a class="btn btn-success"><s:property value="session.adminId" /></a>
				<a href='<s:url action="adminLogout"/>' class="btn btn-success">logout</a>
			</div> 
        </div>
      </div>
    </div>
    
    <div class="container">
        <s:form theme="simple"  role="form" method="post" action="SaveBrandsAction" >
            <br><br><br>
            <table class="table">
                <caption>商家权重列表</caption>
                <br>
                <tr>
                    <td>商家ID</td>
                    <td>商家名称</td>
                    <td>权重</td>
                </tr>
                <s:iterator value="brandList" id="brand" status="st">
                    <tr>
                        <td>
                           <s:property value="%{#brand.id}" />
                           <s:hidden  name="brandId"  value="%{#brand.id}" /></td>
                        <td>
                            <s:property value="%{#brand.name}" />
                        <td>
                           <s:textfield  name="brandWeight" value="%{#brand.weight}" >
                              <!--   <s:property value="%{#brand.weight}" />-->
                           </s:textfield>
                            
                        </td>
                    </tr>
                </s:iterator>
            
            </table>
            <s:submit   cssClass="btn btn-info btn-lg center-block" value="保存"/>
        </s:form>
    
    </div>

</body>
</html>