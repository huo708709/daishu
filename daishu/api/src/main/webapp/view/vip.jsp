<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
    <title>会员</title>

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
    <link rel="stylesheet" href="static/css/huiyuanka.css">
</head>
<body>
<div class="am-container" style="padding: 0">
    <div style="display: inline-block;">
        <div class="am-u-sm-12 huiyuanka-logo-wrapper">
            <img src="static/img/huiyuanka-logo.png" style="width: 100%;height: 100%;">
        </div>
        <div class="am-u-sm-12 huiyuan-opt">
            <ul class="am-avg-sm-3">
                <li><a><img src="static/img/yue.png" style="height: 15px;width: auto;"><span style="display: block;color: #5d5d5d;font-size: 1.3rem;"> 余额:${balance/100 }元</span></a></li>
                <li><a href="consumeDetail"><img src="static/img/xiaofeijilu.png" style="height: 15px;width: auto;"><span style="display: block;color: #5d5d5d;font-size: 1.3rem;"> 消费记录</span></a></li>
                <li><a href="guize"><img src="static/img/shiyongguize.png" style="height: 15px;width: auto;"><span style="display: block;color: #5d5d5d;font-size: 1.3rem;"> 使用规则</span></a></li>
            </ul>
        </div>
    </div>

    <ul class="am-list huiyuanka-list">
        <li class="am-g am-list-item-dated">
            <div class="am-u-sm-12 am-list-main" style="padding: 0">
            	<div style="height: 4px;width: 100%;background: url('static/img/huiyuanka-border.png') repeat-x;"></div>
            	<div class="content">
					<img src="static/img/mama.png"/>
					<span>妈妈卡:充值${cards.mama.rechargeAmount }元 赠送<fmt:formatNumber value="${cards.mama.giveAmount }" pattern="#"/>元</span>
					<button data-viptype="1" type="button" class="am-btn am-btn-xs am-radius am-btn-default" style="color: #00bbe9;border-color: #00bbe9;">充值</button>
            	</div>
            	<div style="height: 4px;width: 100%;background: url('static/img/huiyuanka-border.png') repeat-x;"></div>
            </div>
        </li>
        <li class="am-g am-list-item-dated">
            <div class="am-u-sm-12 am-list-main" style="padding: 0">
            	<div style="height: 4px;width: 100%;background: url('static/img/huiyuanka-border.png') repeat-x;"></div>
            	<div class="content">
					<img src="static/img/baba.png"/>
					<span>爸爸卡:充值${cards.baba.rechargeAmount }元 赠送<fmt:formatNumber value="${cards.baba.giveAmount }" pattern="#"/>元</span>
					<button data-viptype="2" type="button" class="am-btn am-btn-xs am-radius am-btn-default" style="color: #00bbe9;border-color: #00bbe9;">充值</button>
				</div>
            	<div style="height: 4px;width: 100%;background: url('static/img/huiyuanka-border.png') repeat-x;"></div>
            </div>
        </li>
        <li class="am-g am-list-item-dated">
            <div class="am-u-sm-12 am-list-main" style="padding: 0">
            	<div style="height: 4px;width: 100%;background: url('static/img/huiyuanka-border.png') repeat-x;"></div>
            	<div class="content">
					<img src="static/img/baobao.png"/>
					<span>宝宝卡:充值${cards.baobao.rechargeAmount }元 赠送<fmt:formatNumber value="${cards.baobao.giveAmount }" pattern="#"/>元</span>
					<button data-viptype="3" type="button" class="am-btn am-btn-xs am-radius am-btn-default" style="color: #00bbe9;border-color: #00bbe9;">充值</button>
				</div>
            	<div style="height: 4px;width: 100%;background: url('static/img/huiyuanka-border.png') repeat-x;"></div>
            </div>
        </li>
    </ul>
</div>
<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">正在载入...</div>
    <div class="am-modal-bd">
      <span class="am-icon-spinner am-icon-spin"></span>
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
<script src="static/js/jquery.min.js" type="text/javascript"></script>
<script src="static/js/amazeui.min.js" type="text/javascript"></script>
<script src="static/js/daishu.js" type="text/javascript"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js" type="text/javascript"></script>
<script src="static/js/vip.js" type="text/javascript"></script>
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
	$('#my-modal-loading').modal('close');
});
</script>
</body>
</html>