<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html class="no-js">
<head lang="en">
	<base href="<%=basePath %>" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1;maximum-scale=1.0, user-scalable=0;">
    <title>添加地址</title>

    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <meta name="msapplication-TileImage" content="static/i/app-icon72x72@2x.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
    <link rel="stylesheet" href="static/css/amazeui.min.css">
    <link rel="stylesheet" href="static/css/app.css">
    <link rel="stylesheet" href="static/css/order.css">
    <link rel="stylesheet" href="static/css/address.css">
</head>
<body>
<div class="am-container" style="padding: 0;">
	<div id="address_edit" style="padding: 0;">
		<form action="address/editAddress" method="post">
			<input type="hidden" name="id" value="${null == address ? 0 : address.id }">
		    <div class="am-g forminfo-container">
		        <div class="am-u-sm-12 forminfo-wrapper">
		            <div class="am-input-group am-input-group-lg">
		                <span class="am-input-group-label">所在区域：</span>
		                <input name="area" value="${address.area }" type="text" class="am-form-field" placeholder="请填写您所在省市区" required="required">
		            </div>
		        </div>
		        <div class="am-u-sm-12 forminfo-wrapper margin-top-1">
		            <div class="am-input-group am-input-group-lg">
		                <span class="am-input-group-label">街 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;道：</span>
		                <input name="street" value="${address.street }" type="text" class="am-form-field" placeholder="请填写您所在街道" required>
		            </div>
		        </div>
		        <div class="am-u-sm-12 forminfo-wrapper margin-top-1">
		            <div class="am-input-group am-input-group-lg">
		                <span class="am-input-group-label">详细地址：</span>
		                <input name="content" type="text" value="${address.content }" class="am-form-field" placeholder="请填写您的详细地址" required>
		            </div>
		        </div>
		    </div>
		    <div class="am-g margin-top-2" style="padding: 0 2rem">
		        <button type="submit" class="am-btn am-btn-warning am-btn-block am-btn-lg am-radius">保存</button>
		    </div>
	    </form>
	</div>
</div>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/amazeui.min.js"></script>
</body>
</html>