<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>袋鼠管家</title>

<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="袋鼠" />
<meta name="msapplication-TileColor" content="#0e90d2">
<link rel="stylesheet" href="static/css/amazeui.min.css">
<link rel="stylesheet" href="static/css/app.css">
<link rel="stylesheet" href="static/css/index.css">
</head>
<body>
	<div data-am-widget="slider" class="am-slider am-slider-a1"
		data-am-slider='{&quot;directionNav&quot;:false}'
		style="height: 21.4%">
		<ul class="am-slides">
			<li><img src="http://s.amazeui.org/media/i/demos/bing-1.jpg">
			</li>
			<li><img src="http://s.amazeui.org/media/i/demos/bing-2.jpg">
			</li>
			<li><img src="http://s.amazeui.org/media/i/demos/bing-3.jpg">
			</li>
			<li><img src="http://s.amazeui.org/media/i/demos/bing-4.jpg">
			</li>
		</ul>
	</div>
	<div class="am-container margin-top-10" style="height: 71.4%;">
		<div class="am-g">
			<div class="am-u-sm-6 index-panel margin-top-05 padding-right-025">
				<a href="baojie?type=1&title=${businessMap.changgui.title }">
					<div id="changguibaojie" class="changguibaojie">
						<img class="img-logo" src="static/img/changguibaojie_logo.png">
						<img class="img-title" src="static/img/changguibaojie_title.png">
						<span class="intro">${businessMap.changgui.intro }</span>
						<span class="unit">${businessMap.changgui.price }${businessMap.changgui.name }</span>
					</div>
				</a> <a href="baojie?type=2&title=${businessMap.jingxibaojie.title }">
					<div id="jingxibaojie" class="margin-top-05 jingxibaojie">
						<img class="img-logo" src="static/img/jingxibaojie_logo.png">
						<img class="img-title" src="static/img/jingxibaojie_title.png">
						<span class="intro">${businessMap.jingxibaojie.intro }</span>
						<span class="unit">${businessMap.jingxibaojie.price }${businessMap.jingxibaojie.name }</span>
					</div>
				</a>
			</div>
			<div class="am-u-sm-6 index-panel margin-top-05 padding-left-025">
				<a href="baojie?type=4&title=${businessMap.caboli.title }"><div id="caboli" class="caboli">
						<img class="img-logo" src="static/img/caboli_logo.png"> <img
							class="img-title" src="static/img/caboli_title.png">
						<span class="intro">${businessMap.caboli.intro }</span>
						<span class="unit">${businessMap.caboli.price }${businessMap.caboli.name }</span>
					</div></a> <a href="baojie?type=8&title=${businessMap.ganxi.title }"><div id="ganxi" class="ganxi margin-top-05">
						<img class="img-logo" src="static/img/ganxi_logo.png"> <img
							class="img-title" src="static/img/ganxi_title.png">
						<span class="intro">${businessMap.ganxi.intro }</span>
						<span class="unit">${businessMap.ganxi.price }${businessMap.ganxi.name }</span>
					</div></a>
			</div>
		</div>
		<div class="am-g">
			<div class="am-u-sm-9 index-panel padding-right-025">
				<ul class="am-avg-sm-2">
					<li class="padding-right-025 margin-top-05"><a href="baojie?type=3&title=${businessMap.shendubaojie.title }"><div
								id="shendubaojie" class="shendubaojie">
								<img class="img-logo" src="static/img/shendubaojie_logo.png">
								<img class="img-title" src="static/img/shendubaojie_title.png">
								<span class="intro">${businessMap.shendubaojie.intro }</span>
								<span class="unit">${businessMap.shendubaojie.price }${businessMap.shendubaojie.name }</span>
							</div></a></li>
					<li class="padding-left-025 margin-top-05"><a href="baojie?type=5&title=${businessMap.xinjukaihuang.title }"><div
								id="xinjukaihuang" class="xinjukaihuang">
								<img class="img-logo" src="static/img/xinjukaihuang_logo.png">
								<img class="img-title" src="static/img/xinjukaihuang_title.png">
								<span class="intro">${businessMap.xinjukaihuang.intro }</span>
								<span class="unit">${businessMap.xinjukaihuang.price }${businessMap.xinjukaihuang.name }</span>
							</div></a></li>
					<li class="padding-right-025 margin-top-05"><a href="baojie?type=7&title=${businessMap.jiajuhuli.title }"><div
								id="jiajuhuli" class="jiajuhuli">
								<img class="img-logo" src="static/img/jiajuhuli_logo.png">
								<img class="img-title" src="static/img/jiajuhuli_title.png">
								<span class="intro">${businessMap.jiajuhuli.intro }</span>
								<span class="unit">${businessMap.jiajuhuli.price }${businessMap.jiajuhuli.name }</span>
							</div></a></li>
					<li class="padding-left-025 margin-top-05"><a href="baojie?type=6&title=${businessMap.jiadianqingxi.title }"><div
								id="jiadianqingxi" class="jiadianqingxi">
								<img class="img-logo" src="static/img/jiadianqingxi_logo.png">
								<img class="img-title" src="static/img/jiadianqingxi_title.png">
								<span class="intro">${businessMap.jiadianqingxi.intro }</span>
								<span class="unit">${businessMap.jiadianqingxi.price }${businessMap.jiadianqingxi.name }</span>
							</div></a></li>
				</ul>
			</div>
			<div class="am-u-sm-3 index-panel padding-left-025 margin-top-05">
				<a href="baojie?type=9&title=包月"><div id="guanjiayuyue" class="guanjiayuyue"
						style="background-color: #f39910; border-radius: 8px;">
						<img class="img-yue" src="static/img/guanjiayuyue_yue.png">
						<img class="img-title" src="static/img/guanjiayuyue_title.png">
						<img class="img-logo" src="static/img/guanjiayuyue_logo.png">
					</div></a>
			</div>
		</div>
	</div>
	<div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default ">
		<ul class="am-navbar-nav am-cf am-avg-sm-4">
			<li><a href="vip" class=""> <span
					class="am-icon-phone"></span> <span class="am-navbar-label">会员卡</span>
			</a></li>
			<li><a href="userCenter" class=""> <span
					class="am-icon-share-square-o"></span> <span
					class="am-navbar-label">我的</span>
			</a></li>
			<li><a> <span
					class="am-icon-location-arrow"></span> <span
					class="am-navbar-label">定位</span>
			</a></li>
		</ul>
	</div>
	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/amazeui.min.js"></script>
	<script src="static/js/daishu.js"></script>
	<script src="static/js/index.js"></script>
</body>
</html>