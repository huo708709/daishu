<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <title>支付</title>

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
<div id="baojie_payment" class="am-container"style="padding: 0;display: none">
    <div class="am-g forminfo-container">
        <div class="am-u-sm-12 forminfo-wrapper">
            <div class="am-input-group-lg">
                <div>
                    <label class="am-input-group-label am-text-center">本次服务金额：<span>69元</span></label>
                </div>
                <p class="am-text-center am-margin-0" style="font-size: 0.8rem;color: #d2d2d2">您可以在保洁人员上门服务时,在我的订单里面再次选择付款</p>
            </div>
        </div>
        <div class="am-u-sm-12 forminfo-wrapper margin-top-1">
            <div class="am-input-group am-input-group-lg">
                <span class="am-input-group-label" style="text-align: left">请选择支付方式</span>
            </div>
            <div class="am-input-group am-input-group-lg">
                <img src="static/img/weixin.png">
            </div>
            <div class="am-input-group am-input-group-lg">
                <img src="static/img/weixin.png">
            </div>
        </div>
    </div>
    <div style="position: fixed;bottom: 1rem;width: 100%;padding: 0 1rem">
        <a type="button" class="am-btn am-btn-warning am-btn-block am-btn-lg am-radius">确认支付</a>
    </div>
</div>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/amazeui.min.js"></script>
<script src="static/js/daishu.js"></script>
</body>
</html>