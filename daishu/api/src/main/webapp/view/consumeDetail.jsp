<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html class="no-js">
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1;maximum-scale=1.0, user-scalable=0;">
    <title>Hello Amaze UI</title>

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
</head>
<body>
<div class="portlet light">
    <div class="portlet-title">
        <div class="caption">
            <span class="caption-subject">干洗</span>
        </div>
        <div class="actions">
            <button type="button" class="am-btn am-btn-xs am-radius am-btn-default">取消</button>
        </div>
    </div>
    <div class="portlet-body">
        <div><span>订单编号：</span>WSA19201019</div>
        <div><span>预约时间：</span>2016-01-23 08:00--12:00</div>
        <div><span>服务地址：</span>四川省成都市高新区天府大道中段11号</div>
        <div><span>服务金额：</span>79元</div>
    </div>
</div>
<div class="portlet light">
    <div class="portlet-title">
        <div class="caption">
            <span class="caption-subject">干洗</span>
        </div>
        <div class="actions">
            <button type="button" class="am-btn am-btn-xs am-radius am-btn-default">取消</button>
        </div>
    </div>
    <div class="portlet-body">
        <div><span>订单编号：</span>WSA19201019</div>
        <div><span>预约时间：</span>2016-01-23 08:00--12:00</div>
        <div><span>服务地址：</span>四川省成都市高新区天府大道中段11号</div>
        <div><span>服务金额：</span>79元</div>
    </div>
</div>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/amazeui.min.js"></script>
</body>
</html>