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
<base href="<%=basePath %>" />
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
</head>
<body>
<div id="baojie_payment" class="am-container"style="padding: 0;">
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
            <div data-paytype="1" class="pay_type" style="border-bottom: 1px solid #cccccc;margin: 0rem 1.5rem;">
            	<div style="margin: 1rem 0rem;">
                <img src="static/img/weixin.png" style="width: 30px;margin-right: 0.8rem"><span>微信支付</span>
                <img class="select_img" src="static/img/selected.png" style="float: right;width: 20px;margin-right: 1rem">
                <img class="unselect_img" src="static/img/unselected.png" style="float: right;width: 20px;margin-right: 1rem;display: none;">
            	</div>
            </div>
            <div data-paytype="2" class="pay_type" style="border-bottom: 1px solid #cccccc;margin: 0rem 1.5rem;">
            	<div style="margin: 1rem 0rem;">
                <img src="static/img/huiyuankazhifu.png" style="width: 30px;margin-right: 0.8rem"><span>会员卡支付</span>
                <img class="select_img" src="static/img/selected.png" style="float: right;width: 20px;margin-right: 1rem;display: none;">
                <img class="unselect_img" src="static/img/unselected.png" style="float: right;width: 20px;margin-right: 1rem">
            	</div>
            </div>
            <div data-paytype="3" class="pay_type" style="margin: 0rem 1.5rem;">
            	<div style="margin: 1rem 0rem;">
                <img src="static/img/xianchangzhifu.png" style="width: 30px;margin-right: 0.8rem"><span>现场支付</span>
                <img class="select_img" src="static/img/selected.png" style="float: right;width: 20px;margin-right: 1rem;display: none;">
                <img class="unselect_img" src="static/img/unselected.png" style="float: right;width: 20px;margin-right: 1rem">
            	</div>
            </div>
        </div>
    </div>
    <div style="position: fixed;bottom: 1rem;width: 100%;padding: 0 1rem">
        <a id="payButton" type="button" class="am-btn am-btn-warning am-btn-block am-btn-lg am-radius">确认支付</a>
    </div>
</div>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/amazeui.min.js"></script>
<script src="static/js/daishu.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js" type="text/javascript"></script>
<script type="text/javascript">
wx.config({
	debug: false,
	appId: "${appId}",
	timestamp: ${sign.timestamp} + "",
	nonceStr: "${sign.nonceStr}",
	signature: "${sign.signature}",
	jsApiList: ["chooseWXPay"]
});
wx.error(function(res) {
	alert(JSON.stringify(res));
});
var pay_type = 1;
wx.ready(function() {
	$('.pay_type').on('click', function() {
		$('.pay_type').find('img.select_img').hide();
		$('.pay_type').find('img.unselect_img').show();
		$(this).find('img.unselect_img').hide();
		$(this).find('img.select_img').show();
		pay_type = $(this).data('pay_type');
	});
	$('#payButton').on('click', function() {
		if (pay_type == 1) {
			$('#my-modal-loading').modal();
	    	daishu.io.httppost('order/pay', {orderId: 1}, '', function(data) {
	    		$('#my-modal-loading').modal('close');
	    		wx.chooseWXPay({
					appId: data.appId,
					timestamp: data.timeStamp + "",
					nonceStr: data.nonceStr,
					package: data.package,
					signType: "MD5",
					paySign: data.paySign,
					success: function(data) {
						alert("支付成功");
						window.location.href = 'userCenter';
					},
					fail: function() {
						alert("支付失败");
					},
					cancel: function() {
						alert("支付取消");
					}
				});
	    	});
		} else if (pay_type == 2) {
			alert('余额不足');
		}
    });
});
</script>
</body>
</html>