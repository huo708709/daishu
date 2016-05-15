<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>消费记录</title>

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
<c:forEach items="${orders }" var="order">
<div class="portlet light">
    <div class="portlet-title">
        <div class="caption">
       		<c:choose>
           		<c:when test="${order.baojieType == 8 }">
                <span class="caption-subject"><img src="static/img/user_center_ganxi.png"></span>
           		</c:when>
           		<c:otherwise>
           		<span class="caption-subject"><img src="static/img/user_center_baojie.png"></span>
           		</c:otherwise>
           	</c:choose>
            <span class="caption-subject" style="color: #f39910;">${order.baojieTypeDTO }</span>
        </div>
    </div>
    <div class="portlet-body">
        <div style="color: #5d5d5d;padding: 0.2rem 0"><span style="color: #a0a0a0">订单编号：</span>${order.orderNo }</div>
        <div style="color: #5d5d5d;padding: 0.2rem 0"><span style="color: #a0a0a0">预约时间：</span>${order.serviceDate } ${order.serviceTimeTypeDTO }</div>
        <div style="color: #5d5d5d;padding: 0.2rem 0"><span style="color: #a0a0a0">服务地址：</span>${order.addressContent }</div>
        <div style="color: #5d5d5d;padding: 0.2rem 0"><span style="color: #a0a0a0">服务金额：</span>${order.price }元</div>
    </div>
</div>
</c:forEach>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/amazeui.min.js"></script>
</body>
</html>