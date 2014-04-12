<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Sensitive Comments</title>
    
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
        <table class="table">
            <caption>敏感评论列表</caption>
            <tr>
                <th>ID</th>
                <th>商品ID</th>
                <th>用户ID</th>
                <th>评论内容</th>
                <th>修改评论</th>
                <th>删除评论</th>
            </tr>
            
            <s:iterator value="sensitiveCommentList" id="sensitiveComment" status="st">
                <tr>
                    <td><s:property value="#sensitiveComment.id" /></td>
                    <td><s:property value="#sensitiveComment.cid" /></td>
                    <td><s:property value="#sensitiveComment.uid" /></td>
                    <td><s:property value="#sensitiveComment.details" /></td>
                    <td>
                        <s:a cssClass="btn btn-primary"
                        href='ModifySensitiveCommentAction?commentID=<s:property value="#sensitiveComment.id"/>'>修改</s:a>
                    </td>
                    <td>
                        <s:a cssClass="btn btn-danger"
                             href='DeleteSensitiveCommentAction?commentID=<s:property value="#sensitiveComment.id"/>'>删除</s:a>
                    </td>
                    
                </tr>
            </s:iterator>
        
        </table>
    
    </div>

</body>
</html>