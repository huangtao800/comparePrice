<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Check Navy</title>
    <link rel="stylesheet" href="<s:url value="/css/bootstrap-theme.min.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/forbidCommodity.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/admin.css" />" />

    <script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
</head>
<body>
    
    <div class="container">
        <div class="navy">
            <table class="table">
                <caption>水军列表</caption>
                <tr>
                    <th>ID</th>
                    <th>用户ID</th>
                    <th>用户名</th>
                </tr>
                
                <s:iterator value="navyList" id="navy" status="st">
                <tr>
                    <td class="td_sensitiveWordId"><s:property value="#navy.id" /></td>
                    <td class="td_sensitiveWordId"><s:property value="#navy.uid" /></td>
                    <td><s:property value="#navy.user.name" /></td>
                </tr>
                </s:iterator>
            </table>
        
        </div>
    
    
    </div>


</body>
</html>