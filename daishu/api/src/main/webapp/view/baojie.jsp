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
                <input type="text" class="am-form-field" placeholder="请填下您的称呼">
            </div>
        </div>
        <div class="am-u-sm-12 forminfo-wrapper margin-top-1">
            <div class="am-input-group am-input-group-lg">
                <span class="am-input-group-label">我的电话：</span>
                <input type="text" class="am-form-field" placeholder="请填下您的电话">
            </div>
        </div>
        <div class="am-u-sm-12 forminfo-wrapper margin-top-1">
            <div class="am-input-group am-input-group-lg">
                <span class="am-input-group-label">服务地址：</span>
                <input id="address" type="text" class="am-form-field" placeholder="请选择您的服务地址">
            </div>
        </div>
    </div>
    <div class="am-g margin-top-2" style="padding: 0 2rem">
        <a id="next" class="am-btn am-btn-warning am-btn-block am-btn-lg am-radius">下一步</a>
    </div>
</div>
<div id="baojie_second" class="am-container" style="padding: 0;display: none;">
    <div class="am-g week-container">
        <div class="am-u-sm-12 week-wrapper">
            <ul class="week">
                <li class="day active"><p>今天</p><p>1-27</p></li>
                <li class="day"><p>明天</p><p>1-28</p></li>
                <li class="day"><p>后天</p><p>1-29</p></li>
                <li class="day"><p>周三</p><p>1-30</p></li>
                <li class="day"><p>周四</p><p>1-31</p></li>
                <li class="day"><p>周五</p><p>2-1</p></li>
                <li class="day"><p>周六</p><p>2-2</p></li>
            </ul>
        </div>
    </div>
    <div class="am-g schedule-container">
        <div class="am-u-sm-6 schedule-wrapper">
            <a class="schedule-time">8:00-12:00</a>
        </div>
        <div class="am-u-sm-6 schedule-wrapper">
            <a class="schedule-time">12:00-15:00</a>
        </div>
        <div class="am-u-sm-6 schedule-wrapper">
            <a class="schedule-time">15:00-18:00</a>
        </div>
        <div class="am-u-sm-6 schedule-wrapper">
            <a class="schedule-time">18:00-20:00</a>
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
</div>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/amazeui.min.js"></script>
<script src="static/js/daishu.js"></script>
<script src="static/js/baojie.js"></script>
<script src="static/js/address.js"></script>
</body>
</html>