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
    <title>快速保洁</title>

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
<div id="baojie_frist" class="am-container" style="padding: 0;">
    <div class="am-g forminfo-container">
        <div class="am-u-sm-12 forminfo-wrapper">
            <div class="am-input-group am-input-group-lg">
                <span class="am-input-group-label">我的姓名：</span>
                <input name="name" type="text" class="am-form-field" placeholder="请填下您的称呼">
            </div>
        </div>
        <div class="am-u-sm-12 forminfo-wrapper margin-top-1">
            <div class="am-input-group am-input-group-lg">
                <span class="am-input-group-label">我的电话：</span>
                <input name="phone" type="text" class="am-form-field" placeholder="请填下您的电话">
            </div>
        </div>
        <div class="am-u-sm-12 forminfo-wrapper margin-top-1">
            <div class="am-input-group am-input-group-lg">
                <span class="am-input-group-label">服务地址：</span>
                <a href="#address" type="text" class="am-form-field" placeholder="请选择您的服务地址">请选择您的服务地址</a>
            </div>
        </div>
    </div>
    <div class="am-g margin-top-2" style="padding: 0 2rem">
        <a href="#second" id="next" class="am-btn am-btn-warning am-btn-block am-btn-lg am-radius">下一步</a>
    </div>
</div>
<div id="baojie_second" class="am-container" style="padding: 0;display: none;">
    <div class="am-g week-container">
        <div class="am-u-sm-12 week-wrapper">
            <ul class="week">
            <c:forEach items="${dates }" var="date" varStatus="varStatus">
                <li class="day ${varStatus.index == 0 ? 'active' : '' }">
                <label style="font-weight: normal;"><p>${date.week }</p>
                <input style="display: none;" type="radio" name="serviceDate" ${varStatus.index == 0 ? 'checked' : '' }>
                <p>${date.date }</p>
                </label></li>
            </c:forEach>
        </div>
    </div>
    <div class="am-g schedule-container">
        <div class="am-u-sm-6 schedule-wrapper">
            <a class="schedule-time"><label style="font-weight: normal;margin: 0">8:00-12:00
            <input style="display: none;" type="radio" name="serviceTimeType">
            </label></a>
        </div>
        <div class="am-u-sm-6 schedule-wrapper">
            <a class="schedule-time"><label style="font-weight: normal;margin: 0">12:00-15:00
            <input style="display: none;" type="radio" name="serviceTimeType">
            </label></a>
        </div>
        <div class="am-u-sm-6 schedule-wrapper">
            <a class="schedule-time"><label style="font-weight: normal;margin: 0">15:00-18:00
            <input style="display: none;" type="radio" name="serviceTimeType">
            </label></a>
        </div>
        <div class="am-u-sm-6 schedule-wrapper">
            <a class="schedule-time"><label style="font-weight: normal;margin: 0">18:00-20:00
            <input style="display: none;" type="radio" name="serviceTimeType">
            </label></a>
        </div>
    </div>
    <div class="am-g forminfo-container">
        <div class="am-u-sm-12 forminfo-wrapper">
            <div class="am-input-group am-input-group-lg">
                <span class="am-input-group-label">服务面积：</span>
                <input type="text" class="am-form-field" placeholder="服务面积（单位：平方米）">
            </div>
            <div class="am-input-group am-input-group-lg">
                <span class="am-input-group-label">备注详情：</span>
                <input type="text" class="am-form-field" placeholder="请填写您的特殊要求">
            </div>
        </div>
        <div class="am-u-sm-12" style="margin: 0.5rem 0;padding: 0 1.5rem">
            <label><input type="checkbox"> 已阅读并同意<span>《袋鼠管家服务协议》</span></label>
        </div>
        <div class="am-u-sm-12 forminfo-wrapper">
            <div class="am-input-group am-input-group-lg">
                <span class="am-input-group-label">预计费用：</span>
                <input type="text" class="am-form-field" placeholder="填写相关信息后核算" disabled="true">
            </div>
        </div>
    </div>
    <div style="position: fixed;bottom: 1rem;width: 100%;padding: 0 1rem">
        <a id="submit_order" type="button" class="am-btn am-btn-warning am-btn-block am-btn-lg am-radius">提交订单</a>
    </div>
</div>
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
<div id="address_container" class="am-container"style="padding: 0;display: none">
	<iframe name="address_iframe" id="address_iframe" style="width: 0;height: 0;display: none;"></iframe>
	<div id="address_list" style="padding: 0;">
	    <ul class="am-list">
	        <li class="am-g am-list-item-dated list-item-address">
	            <div class="am-u-sm-12">
	                <div class="address-content-wrapper">
	                    <label><input type="checkbox" style="display: none;"><img class="address-icon" src="static/img/selected.png">
	                        <span class="address-content">高新区天府大道中段11号</span></label>
	                </div>
	            </div>
	            <div class="am-u-sm-5 am-u-sm-offset-1">
	                <label><img class="address-icon address-icon-small" src="static/img/localtion.png"><span class="address-loaction">成都</span></label>
	            </div>
	            <div class="am-u-sm-3">
	                <a><img class="address-icon address-icon-small" src="static/img/edit.png"><span class="address-edit">编辑</span></a>
	            </div>
	            <div class="am-u-sm-3">
	                <a><img class="address-icon address-icon-small" src="static/img/delete.png"><span class="address-delete">删除</span></a>
	            </div>
	        </li>
	        <li class="am-g am-list-item-dated list-item-address">
	            <div class="am-u-sm-12">
	                <div class="address-content-wrapper">
	                    <label><input type="checkbox" style="display: none;"><img class="address-icon" src="static/img/selected.png">
	                        <span class="address-content">高新区天府大道中段11号</span></label>
	                </div>
	            </div>
	            <div class="am-u-sm-5 am-u-sm-offset-1">
	                <label><img class="address-icon address-icon-small" src="static/img/localtion.png"><span class="address-loaction">成都</span></label>
	            </div>
	            <div class="am-u-sm-3">
	                <a class="address_update"><img class="address-icon address-icon-small" src="static/img/edit.png"><span class="address-edit">编辑</span></a>
	            </div>
	            <div class="am-u-sm-3">
	                <a class="address_delete"><img class="address-icon address-icon-small" src="static/img/delete.png"><span class="address-delete">删除</span></a>
	            </div>
	        </li>
	    </ul>
	    <button type="button" class="am-btn am-btn-default am-btn-block">添加新地址</button>
	</div>
	<div id="address_edit" style="padding: 0;display: none">
		<form action="address/editAddress" method="post">
			<input type="hidden" name="id">
		    <div class="am-g forminfo-container">
		        <div class="am-u-sm-12 forminfo-wrapper">
		            <div class="am-input-group am-input-group-lg">
		                <span class="am-input-group-label">所在区域：</span>
		                <input type="text" class="am-form-field" placeholder="请填写您所在省市区" required="required">
		            </div>
		        </div>
		        <div class="am-u-sm-12 forminfo-wrapper margin-top-1">
		            <div class="am-input-group am-input-group-lg">
		                <span class="am-input-group-label">街 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;道：</span>
		                <input type="text" class="am-form-field" placeholder="请填写您所在街道" required>
		            </div>
		        </div>
		        <div class="am-u-sm-12 forminfo-wrapper margin-top-1">
		            <div class="am-input-group am-input-group-lg">
		                <span class="am-input-group-label">详细地址：</span>
		                <input type="text" class="am-form-field" placeholder="请填写您的详细地址" required>
		            </div>
		        </div>
		    </div>
		    <div class="am-g margin-top-2" style="padding: 0 2rem">
		        <button type="submit" class="am-btn am-btn-warning am-btn-block am-btn-lg am-radius">保存</button>
		    </div>
	    </form>
	</div>
</div>
<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">Amaze UI</div>
    <div class="am-modal-bd">
      你，确定要删除这条记录吗？
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
    </div>
  </div>
</div>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">提示</div>
    <div class="am-modal-bd">
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
    </div>
  </div>
</div>
<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">正在载入...</div>
    <div class="am-modal-bd">
      <span class="am-icon-spinner am-icon-spin"></span>
    </div>
  </div>
</div>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/amazeui.min.js"></script>
<script src="static/js/daishu.js"></script>
<script src="static/js/address.js"></script>
<script src="static/js/baojie.js"></script>
</body>
</html>