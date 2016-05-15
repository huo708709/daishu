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
<div id="userCenterDiv" class="am-container" style="padding: 0">
    <div style="background-color: #f39910">
        <div style="text-align: center;padding: 0.8rem 0 2rem 0;"><img src="static/img/user_center_logo.png" style="width: 100px;"></div>
    </div>
    <div class="user-center-opt">
        <ul class="am-navbar-nav am-cf am-avg-sm-2">
            <li>
                <img src="static/img/changyongdizhi.png"><a style="display: initial;height: auto;color: #5d5d5d;" href="address/addressList">常用地址</a>
            </li>
            <li>
                <img src="static/img/kefurexian.png"><a style="display: initial;height: auto;color: #5d5d5d;" href="tel:${tel }">客服热线</a>
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
                <span class="caption-subject" style="color: #f39910;">${order.baojieTypeDTO }</span>
            </div>
            <div class="actions">
            	<c:choose>
            		<c:when test="${order.payStatus == 1 }">
	                <button type="button" data-orderid="${order.id }" class="am-btn am-btn-xs am-radius am-btn-warning order_cancel">取消</button>
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
            <div style="color: #5d5d5d;padding: 0.2rem 0"><span style="color: #a0a0a0">订单编号：</span>${order.orderNo }</div>
            <div style="color: #5d5d5d;padding: 0.2rem 0"><span style="color: #a0a0a0">预约时间：</span>${order.serviceDate } ${order.serviceTimeTypeDTO }</div>
            <div style="color: #5d5d5d;padding: 0.2rem 0"><span style="color: #a0a0a0">服务地址：</span>${order.addressContent }</div>
            <div style="color: #5d5d5d;padding: 0.2rem 0"><span style="color: #a0a0a0">服务金额：</span>${order.price }元</div>
            <div style="color: #5d5d5d;padding: 0.2rem 0"><span style="color: #a0a0a0">支付方式：</span><label><div>
            <c:choose>
            	<c:when test="${order.payStatus < 3 }">
            	<button type="button" class="am-btn am-btn-xs am-radius am-btn-warning weixin_pay" data-orderid="${order.id }" data-orderno="${order.orderNo }">微信支付</button>
                <button type="button" class="am-btn am-btn-xs am-radius am-btn-warning huiyuanka_pay" data-orderid="${order.id }" data-orderno="${order.orderNo }">会员卡支付</button>
                <button type="button" class="am-btn am-btn-xs am-radius am-btn-default xianjin_pay" style="background-color: #bfbfbf;color: #fff;" data-orderid="${order.id }" data-orderno="${order.orderNo }">现金支付</button>
                </c:when>
                <c:when test="${order.payStatus == 5 }">
                <span type="button" style="background-color: #fff;border: none;color: #f39910;font-weight: normal;">未支付</span>
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
<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">正在请求...</div>
    <div class="am-modal-bd">
      <span class="am-icon-spinner am-icon-spin"></span>
    </div>
  </div>
</div>
<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">提示</div>
    <div class="am-modal-bd">
      您确定要取消该订单么？
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
wx.ready(function() {
	$('#userCenterDiv').on('touchend', '.weixin_pay', function() {
		var orderId = $(this).data('orderid');
		var orderNo = $(this).data('orderno');
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
					//alert("支付成功");
					$('#my-alert .am-modal-bd').text('支付成功');
		    		$('#my-alert').modal();
					window.location.href = 'userCenter';
				},
				fail: function() {
					$('#my-alert .am-modal-bd').text('支付失败');
		    		$('#my-alert').modal();
					//alert("支付失败");
				},
				cancel: function() {
					//alert("支付取消");
					$('#my-alert .am-modal-bd').text('支付取消');
		    		$('#my-alert').modal();
				}
			});
    	}, function() {
    		$('#my-modal-loading').modal('close');
    	});
    }).on('touchend', '.huiyuanka_pay', function() {
    	var orderId = $(this).data('orderid');
		var orderNo = $(this).data('orderno');
    	$('#my-modal-loading').modal();
    	daishu.io.httppost('consume/add', {orderId: orderId,orderNo:orderNo}, '', function(data) {
    		$('#my-modal-loading').modal('close');
    		window.location.href = 'userCenter';
    	}, function() {
    		$('#my-modal-loading').modal('close');
    	});
    }).on('click', '.order_cancel', function() {
 	    var orderId = $(this).data('orderid');
    	$('#my-confirm').modal({
    		relatedTarget: this,
    		onConfirm: function(options) {
    			$('#my-modal-loading').modal();
    	    	daishu.io.httppost('order/cancel', {id: orderId}, '', function(data) {
    	    		$('#my-modal-loading').modal('close');
    	    		window.location.href = 'userCenter';
    	    	}, function() {
    	    		$('#my-modal-loading').modal('close');
    	    	});
    		},
    		onCancel: function() {
    		}
    	});
    });
});
</script>
</body>
</html>