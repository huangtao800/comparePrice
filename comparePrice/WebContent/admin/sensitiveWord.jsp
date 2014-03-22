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
    <link rel="stylesheet" href="<s:url value="/css/bootstrap-theme.min.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/forbidCommodity.css" />" />

    <script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
    <script src=<s:url value="/js/sensitiveWord.js" /> type="text/javascript"></script>
</head>
<body>
    <head>
    </head>
    
    <div class="container">
        <div class="input-group" id="search">
             <s:form theme="simple"  role="form"  name="form_commodity_search" method="post" action="/SensitiveWordAction" >
                <s:textfield   id="sensitiveWord" name="sensitiveWord"  cssClass="textfield_mem_uid" placeholder="请输入要添加的敏感词：" />
                <s:submit cssClass="btn btn-primary" id="btn_forbid_search" name="btn_forbid_search" value="添加"/>
            </s:form>
        </div>
        
        <div id="sensitiveWordList">
        
          <table>
            <caption>已经被屏蔽的商品列表</caption>
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