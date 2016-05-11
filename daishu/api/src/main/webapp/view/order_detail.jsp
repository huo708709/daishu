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
    <title>订单详情</title>

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
<body style="background-color: #ffffff;">
<form action="order/pingjia" method="post">
<input name="orderId" type="hidden" value="${order.id }">
<input id="starLevel" name="starLevel" type="hidden" value="0">
<div id="order_detail_div" class="am-container">
    <div style="margin-top: 1rem;">
    <img style="width: 20px;" src="static/img/user_center_ganxi.png"> <span> 快速保洁</span></div>
    <hr data-am-widget="divider" style="margin: 1rem auto;" class="am-divider am-divider-default" />
    <div>
        <p style="margin-bottom: 1rem;">订单编号：${order.orderNo }</p>
        <p style="margin: 1rem 0;">服务面积：${order.area }平方米</p>
        <p style="margin-top: 1rem;">预计费用：${order.price }元</p>
    </div>
    <hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
    <div>
        <p style="margin-bottom: 1rem;">预约时间：${order.serviceDate } ${order.serviceTimeTypeDTO }</p>
        <p style="margin: 1rem 0;">服务地址：${order.addressContent }</p>
        <p style="margin-top: 1rem;">备注详情：${order.remark }</p>
    </div>
    <hr data-am-widget="divider" style="margin: 1rem auto;" class="am-divider am-divider-default" />
    <div>
        <p style="text-align: center;margin-bottom: 1rem;">评价</p>
        <div style="text-align: center;margin-bottom: 1rem;"><img class="star_img" data-fenshu="1" style="width: 25px;margin-right: 0.5rem" src="static/img/pingjia_icon.png">
            <img class="star_img" data-fenshu="2" style="width: 25px;margin: 0 0.5rem;" src="static/img/pingjia_icon.png">
            <img class="star_img" data-fenshu="3" style="width: 25px;margin: 0 0.5rem;" src="static/img/pingjia_icon.png">
            <img class="star_img" data-fenshu="4" style="width: 25px;margin: 0 0.5rem;" src="static/img/pingjia_icon.png">
            <img class="star_img" data-fenshu="5" style="width: 25px;margin-left: 0.5rem" src="static/img/pingjia_icon.png"></div>
        <div style="margin-bottom: 1rem;">
            <textarea name="content" class="am-form-field" placeholder="简单说两句，方便我们进步~~~" style="height: 10rem"></textarea>
        </div>
        <div>
            <button type="submit" class="am-btn am-btn-warning am-btn-block am-btn-lg am-radius">提交</button>
        </div>
    </div>
</div>
</form>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/amazeui.min.js"></script>
<script type="text/javascript">
$('#order_detail_div').on('click', '.star_img', function() {
	var fenshu = $(this).data('fenshu');
	var imgs = $('#order_detail_div').find('.star_img').attr('src', 'static/img/pingjia_icon.png');
	for (var i = 0; i < parseInt(fenshu); i++) {
		$(imgs[i]).attr('src', 'static/img/pingjia_icon1.png');
	}
	$('#starLevel').val(fenshu);
});
</script>
</body>
</html>