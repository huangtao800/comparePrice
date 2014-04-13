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
    <div class="container">
        <div class="input-group" id="search">
             <s:form theme="simple"  role="form"  name="form_commodity_search" method="post" action="AddCrawlerWebsiteAction" >
                <s:textfield   id="websiteName" name="websiteName"  cssClass="textfield_mem_uid" placeholder="请输入要添加的网站名：" />
                <s:textfield   id="websiteLink" name="websiteLink"  cssClass="textfield_mem_uid" placeholder="网站的链接：" />
                <s:submit cssClass="btn btn-primary" id="btn_forbid_search" name="btn_forbid_search" value="添加"/>
            </s:form>
        </div>
        <br>
        
        <div>
            <table class="table">
                <caption>爬取的网站列表</caption>
                <tr>
                	<td>编号</td>
                	<td>网站名</td>
                	<td>链接</td>
                	<td>操作</td>
                </tr>
                <s:iterator value="crawlerWebsiteList"  status="st">
                <tr>
                    <td><s:property value="id" /></td>
                    <td><s:property value="name" /></td>
                    <td><s:property value="link" /></td>
                    <td>
                        <a  href="RemoveCrawlerWebsiteAction?crawlerWebsiteId=<s:property value='id' />"   
                              class="btn btn-danger">删除</a>
                    </td>
                </tr>
                </s:iterator>
            </table>
        
        </div>
    
    </div>

</body>
</html>