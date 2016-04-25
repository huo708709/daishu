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
<base href="<%=basePath %>" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1;maximum-scale=1.0, user-scalable=0;">
    <title>常用地址</title>

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
    <div id="address_list" style="padding: 0;">
	    <ul class="am-list">
	    <c:forEach items="${addressList }" var="address">
	        <li class="am-g am-list-item-dated list-item-address">
	            <div class="am-u-sm-12">
	                <div class="address-content-wrapper">
	                    <label><input type="checkbox" style="display: none;"><img class="address-icon" src="static/img/selected.png">
	                        <span class="address-content">${address.content }</span></label>
	                </div>
	            </div>
	            <div class="am-u-sm-5 am-u-sm-offset-1">
	                <label><img class="address-icon address-icon-small" src="static/img/localtion.png"><span class="address-loaction">${address.area }</span></label>
	            </div>
	            <div class="am-u-sm-3">
	                <a href="address/addressEdit?id=${address.id }"><img class="address-icon address-icon-small" src="static/img/edit.png"><span class="address-edit">编辑</span></a>
	            </div>
	            <div class="am-u-sm-3">
	                <a href="address/addressDel?id=${address.id }"><img class="address-icon address-icon-small" src="static/img/delete.png"><span class="address-delete">删除</span></a>
	            </div>
	        </li>
	    </c:forEach>
	    </ul>
	    <a href="address/addressEdit?id=0" class="am-btn am-btn-default am-btn-block">添加新地址</a>
	    <!-- <a href="userCenter" class="am-btn am-btn-default am-btn-block">个人中心</a> -->
	</div>
</div>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/amazeui.min.js"></script>
<script src="static/js/daishu.js"></script>
<script src="static/js/address.js"></script>
</body>
</html>