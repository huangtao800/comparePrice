<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<title>compare price</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/homepage.css" rel="stylesheet">
<style>
	.comment{
		margin-top: 20px;
		border-radius: 7px;
		border-style: dotted;
		border-color: rgba(0,0,0,0.8);
		border-width: thin;
		padding-top: 10px;
		padding-bottom: 10px;
		padding-left:15px;
		width:950px;
		font-size:20px;
		margin-left:auto;
		margin-right:auto;
	}
	
	#addCommentPart{
		margin-top:30px;
		margin-bottom:66px;
		margin-left: 170px;
		font-size: 20px;
	}

	.uid{
		text-align: right;
		font-size:10px;
		padding-right:25px;
	}
</style>
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
    
    
	<div style="font-size:80px; margin-top:80px; margin-left:50px;">当前商品尚无评论!</div>
	<a class="navbar-brand" class="active" style="margin-left:50px" href="../user/homepage.jsp">•̩̩̩́ ˑ̫ •̩̩̩̀ 对不起，因为程序猿偷懒所以你只能回到主页了...</a>
	

	<s:form id="addCommentPart" action="addComment" method="POST">
		<div><label style="font-size:26px;">评论：</label></div>
		<s:hidden name="comment.user.id" value="12306"> </s:hidden>
		<s:hidden name="comment.commodity.id" value="%{cid}"> </s:hidden>
		<s:hidden name="comment.state" value="0"> </s:hidden>
		<s:textarea name="comment.details" cols="97" rows="7"></s:textarea>
		<s:submit  cssClass="btn btn-success" cssStyle="margin-top:3px;margin-bottom:10px;" value="Submit"></s:submit>
	</s:form>
				
</body>

	<script src="../js/jquery-2.1.0.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</html>
