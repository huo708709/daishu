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
                <span class="caption-subject">${order.baojieTypeDTO }</span>
            </div>
            <div class="actions">
            	<c:choose>
            		<c:when test="${order.payStatus == 1 }">
	                <button type="button" class="am-btn am-btn-xs am-radius am-btn-warning">取消</button>
            		</c:when>
            		<c:when test="${order.payStatus == 2}">
	                <button type="button" class="am-btn am-btn-xs am-radius am-btn-default" style="background-color: #fff;border: none;color: #f39910">服务中</button>
            		</c:when>
            		<c:when test="${order.payStatus == 3}">
	                <a href="order/pingjia?id=${order.id }" type="button" class="am-btn am-btn-xs am-radius am-btn-warning">评价</a>
            		</c:when>
            		<c:when test="${order.payStatus == 4}">
	                <button type="button" class="am-btn am-btn-xs am-radius am-btn-default" style="background-color: #fff;border: none;color: #f39910">已评价</button>
            		</c:when>
            		<c:when test="${order.payStatus == 5}">
	                <button type="button" class="am-btn am-btn-xs am-radius am-btn-default" style="background-color: #fff;border: none;color: #f39910">已取消</button>
            		</c:when>
            		<c:otherwise></c:otherwise>
            	</c:choose>
            </div>
        </div>
        <div class="portlet-body">
            <div><span>订单编号：</span>${order.orderNo }</div>
            <div><span>预约时间：</span>${order.serviceDate } ${order.serviceTimeTypeDTO }</div>
            <div><span>服务地址：</span>${order.addressContent }</div>
            <div><span>服务金额：</span>${order.price }元</div>
            <div><span>支付方式：</span><label><div>
            <c:choose>
            	<c:when test="${order.payStatus == 1 }">
            	<button type="button" class="am-btn am-btn-xs am-radius am-btn-warning">微信支付</button>
                <button type="button" class="am-btn am-btn-xs am-radius am-btn-warning">会员卡支付</button>
                <button type="button" class="am-btn am-btn-xs am-radius am-btn-default">现金支付</button>
                </c:when>
                <c:otherwise>
                <span type="button" style="background-color: #fff;border: none;color: #f39910;font-weight: normal;">${order.payTypeDTO }</span>
                </c:otherwise>
            </c:choose>
                </div></label></div>
        </div>
    </div>
    </c:forEach>
    <!-- <div class="portlet light">
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
    </div> -->
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
var orderId = ${orderId};
var orderNo = ${orderNo};
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
		pay_type = $(this).data('paytype');
	});
	$('#payButton').on('click', function() {
		alert(pay_type);
		if (pay_type == 1) {
			$('#my-modal-loading').modal();
	    	daishu.io.httppost('order/pay', {orderId: orderId,orderNo:orderNo}, '', function(data) {
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
			daishu.io.httppost('consume/add', {orderId: orderId,orderNo:orderNo}, '', function(data) {
	    		$('#my-modal-loading').modal('close');
	    		window.location.href = 'userCenter';
	    	});
		}
    });
});
</script>
</body>
</html>