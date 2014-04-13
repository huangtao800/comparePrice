<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>IModify Comment</title>
    <link rel="stylesheet" href="<s:url value="/css/bootstrap-theme.min.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<s:url value="/css/admin.css" />" />
    
    <script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
    <script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
</head>
<body>

    <div class="container modifySensitiveComment">
        <s:form method="post" action="SaveSensitiveCommentAction">
            <s:hidden name="commentID"></s:hidden>
            <s:textarea rows="6" cols="100" name="commentDetails" cssClass="center-block">
            </s:textarea>
            <br>
                <s:submit  cssClass="btn btn-primary center-block" value="保存"  />                 
        </s:form>
    
    
    </div>

</body>
</html>