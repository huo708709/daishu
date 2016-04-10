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
    <title>个人中心</title>

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
    <link rel="stylesheet" href="static/css/usercenter.css">
</head>
<body>
<div class="am-container" style="padding: 0">
    <div style="background-color: #f39910">
        <div style="text-align: center;padding: 0.8rem 0;"><img src="static/img/user_center_logo.png"></div>
    </div>
    <div class="user-center-opt">
        <ul class="am-navbar-nav am-cf am-avg-sm-2">
            <li>
                <img src="static/img/changyongdizhi.png"><a style="display: initial;height: auto;color: #ffffff;" href="address/addressList">常用地址</a>
            </li>
            <li>
                <img src="static/img/kefurexian.png">客服热线
            </li>
        </ul>
    </div>
    <div class="portlet light">
        <div class="portlet-title">
            <div class="caption">
                <span class="caption-subject"><img src="static/img/user_center_ganxi.png"></span>
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
            <div><span>支付方式：</span><label><div class="am-btn-group">
                <button type="button" class="am-btn am-btn-xs am-radius am-btn-warning">微信支付</button>
                <button type="button" class="am-btn am-btn-xs am-radius am-btn-warning">会员卡支付</button>
                <button type="button" class="am-btn am-btn-xs am-radius am-btn-default">现金支付</button></div></label></div>
        </div>
    </div>
    <div class="portlet light">
        <div class="portlet-title">
            <div class="caption">
                <span class="caption-subject"><img src="static/img/user_center_baojie.png"></span>
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
            <div><span>支付方式：</span><label><div class="am-btn-group">
                <button type="button" class="am-btn am-btn-xs am-radius am-btn-warning">微信支付</button>
                <button type="button" class="am-btn am-btn-xs am-radius am-btn-warning">会员卡支付</button>
                <button type="button" class="am-btn am-btn-xs am-radius am-btn-default">现金支付</button></div></label></div>
        </div>
    </div>
</div>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/amazeui.min.js"></script>
</body>
</html>