<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
<base href="<%=basePath %>" />
    <meta charset="UTF-8">
    <title>袋鼠管家</title>

    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <meta content="Metronic Shop UI description" name="description">
    <meta content="Metronic Shop UI keywords" name="keywords">
    <meta content="keenthemes" name="author">

    <meta property="og:site_name" content="-CUSTOMER VALUE-">
    <meta property="og:title" content="-CUSTOMER VALUE-">
    <meta property="og:description" content="-CUSTOMER VALUE-">
    <meta property="og:type" content="website">
    <meta property="og:image" content="-CUSTOMER VALUE-"><!-- link to image for socio -->
    <meta property="og:url" content="-CUSTOMER VALUE-">

    <link href="static/pc/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/pc/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/pc/assets/plugins/slider-revolution-slider/rs-plugin/css/settings.css" rel="stylesheet">

    <link href="static/pc/assets/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">

    <link href="static/pc/assets/css/components.css" rel="stylesheet">
    <link href="static/pc/assets/css/style.css" rel="stylesheet">
    <link href="static/pc/assets/css/style-responsive.css" rel="stylesheet">
    <link href="static/pc/assets/css/red.css" rel="stylesheet" id="style-color">
    <link href="static/pc/assets/css/custom.css" rel="stylesheet">
</head>
<body class="menu-always-on-top">
<div class="header header-mobi-ext">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-3">
                <a class="scroll site-logo" href="#promo-block">
                    <img src="static/pc/assets/img/logo-daishu.png" alt="袋鼠管家">
                    <img src="static/pc/assets/img/logo.png" alt="袋鼠管家">
                </a>
            </div>
            <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>
            <div class="col-md-9 pull-right">
                <ul class="header-navigation">
                    <li><a href="/daishu/#promo-block">首页</a></li>
                    <li><a href="/daishu/#services">服务介绍</a></li>
                    <li class="current"><a href="/daishu/#news">新闻动态</a></li>
                    <li><a href="/daishu/#company">公司介绍</a></li>
                    <li><a href="/daishu/#recruitment">招聘</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<c:if test="${not empty banners }">
<div class="promo-block" id="promo-block">
    <div class="tp-banner-container">
        <div class="tp-banner">
            <ul>
            <c:forEach items="${banners }" var="banner">
            	<li data-transition="fade" data-slotamount="5" data-masterspeed="700" data-delay="9400" class="slider-item-1">
                    <img src="static/upload/${banner.fileId }" alt="" data-bgfit="cover" style="opacity:0.4 !important;" data-bgposition="center center" data-bgrepeat="no-repeat">
                    <div class="tp-caption large_text customin customout start"
                         data-x="center"
                         data-hoffset="0"
                         data-y="center"
                         data-voffset="60"
                         data-customin="x:0;y:0;z:0;rotationX:90;rotationY:0;rotationZ:0;scaleX:1;scaleY:1;skewX:0;skewY:0;opacity:0;transformPerspective:200;transformOrigin:50% 0%;"
                         data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
                         data-speed="1000"
                         data-start="500"
                         data-easing="Back.easeInOut"
                         data-endspeed="300">
                    </div>
                </li>
            </c:forEach>
            </ul>
        </div>
    </div>
</div>
</c:if>
<!-- 新闻 -->
<div id="news" class="team-block content news content-center">
    <div class="container">
        <div class="title">
            <h2 style="font-size: 25px;">${news.title }</h2>
        </div>
        <div class="row margin-top-30">
        	<div class="col-md-12" style="text-align: left;">
        		${news.content }
        	</div>
        </div>
    </div>
</div>

<div class="content content-center" style="background-color: #f39910;">
    <div class="container">
        <div>
            <ul class="footer-navigation">
                <li>首页</li>
                <li>服务介绍</li>
                <li>新闻动态</li>
                <li>公司介绍</li>
                <li>招聘</li>
            </ul>
        </div>
        <div style="display: inline-block;color: #ffffff;margin: 10px;">
            Copyright @ 2015-2016   四川司宅科技有限公司    蜀ICP备12214715号   All Rights
        </div>
    </div>
</div>

<a href="#promo-block" class="go2top scroll"><i class="fa fa-arrow-up"></i></a>

<script src="static/pc/assets/plugins/jquery.min.js" type="text/javascript"></script>
<script src="static/pc/assets/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<script src="static/pc/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

<script src="static/pc/assets/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.revolution.min.js" type="text/javascript"></script>
<script src="static/pc/assets/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.tools.min.js" type="text/javascript"></script>
<script src="static/pc/assets/js/revo-ini.js" type="text/javascript"></script>

<script src="static/pc/assets/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
<script src="static/pc/assets/plugins/jquery.easing.js"></script>
<script src="static/pc/assets/plugins/jquery.parallax.js"></script>
<script src="static/pc/assets/plugins/jquery.scrollTo.min.js"></script>
<script src="static/pc/assets/js/jquery.nav.js"></script>

<script src="static/pc/assets/js/layout.js" type="text/javascript"></script>
<script>
    $(document).ready(function() {
        Layout.init();
    });
</script>
</body>
</html>