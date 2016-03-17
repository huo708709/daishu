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
    <style type="text/css">
    a:HOVER {
    	text-decoration: none;
    }
    </style>
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
                    <li class="current"><a href="#promo-block">首页</a></li>
                    <li><a href="#services">服务介绍</a></li>
                    <li><a href="#news">新闻动态</a></li>
                    <li><a href="#company">公司介绍</a></li>
                    <li><a href="#recruitment">招聘</a></li>
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
<!-- 服务介绍 -->
<div class="services-block content services content-center" id="services">
    <div class="container">
        <div class="title">
            <h2 style="font-size: 25px">服务介绍<span class="first" style="font-size: 15px">SERVICE</span><span style="font-size: 15px">INTRODUCTION</span></h2>
        </div>
        <div class="row">
            <div class="col-md-3 col-sm-3 col-xs-12 item">
            <a href="pc/business?code=changgui" style="color: #959595">
                <img src="static/pc/assets/img/changgui.png" alt="常规保洁">
                <h3 class="margin-top-10">常规保洁</h3>
                <p>1.6元/平米</p>
                <p>保持清洁袋鼠有责</p>
            </a>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-12 item">
            <a href="pc/business?code=jingxibaojie" style="color: #959595">
                <img src="static/pc/assets/img/jingxi.png">
                <h3 class="margin-top-10">精细保洁</h3>
                <p>2.2元/平米</p>
                <p>旮旮旯旯彻彻底底</p>
            </a>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-12 item">
            <a href="pc/business?code=caboli" style="color: #959595">
                <img src="static/pc/assets/img/caboli.png">
                <h3 class="margin-top-10">擦玻璃</h3>
                <p>8元/平米</p>
                <p>几乎看不到玻璃</p>
            </a>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-12 item">
            <a href="pc/business?code=ganxi" style="color: #959595">
                <img src="static/pc/assets/img/ganxi.png">
                <h3 class="margin-top-10">干洗</h3>
                <p>30元起/包取送</p>
                <p>2万平米超大洗涤工厂</p>
            </a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-sm-3 col-xs-12 item">
            <a href="pc/business?code=shengdubaojie" style="color: #959595">
                <img src="static/pc/assets/img/shengdu.png">
                <h3 class="margin-top-10">深度保洁</h3>
                <p>4元/平米</p>
                <p>专治高段位脏乱差</p>
            </a>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-12 item">
            <a href="pc/business?code=xinjukaihuang" style="color: #959595">
                <img src="static/pc/assets/img/xinjukaihuang.png">
                <h3 class="margin-top-10">新居开荒</h3>
                <p>1.6元/平米</p>
                <p>袋鼠祝您乔迁之喜</p>
            </a>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-12 item">
            <a href="pc/business?code=jiajuhuli" style="color: #959595">
                <img src="static/pc/assets/img/jiajuhuli.png">
                <h3 class="margin-top-10">家居护理</h3>
                <p>80元起</p>
                <p>方方面面周周到到</p>
            </a>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-12 item">
            <a href="pc/business?code=jiadianqingxi" style="color: #959595">
                <img src="static/pc/assets/img/jiadianqingxi.png">
                <h3 class="margin-top-10">家电清洗</h3>
                <p>40元起</p>
                <p>专业的人做专业的事</p>
            </a>
            </div>
        </div>
    </div>
</div>
<!-- 新闻 -->
<c:if test="${not empty newsList }">
<div id="news" class="team-block content news content-center" style="background-image: url('static/pc/assets/img/xinwenbg.png')">
    <div class="container">
        <div class="title">
            <h2 style="font-size: 25px">新闻动态<span class="first" style="font-size: 15px">NEWS</span><span style="font-size: 15px">INFORMATION</span></h2>
        </div>
        <c:forEach items="${newsList }" var="news" varStatus="status">
        	<c:if test="${status.index % 3 == 0 }">
	        <div class="row margin-top-30">
        	</c:if>
	            <div class="col-md-4 col-sm-4 col-xs-12 news-item">
	            <a href="pc/news_detail?id=${news.id }">
	                <img class="img-responsive" src="static/upload/${news.fileId }" style="width: 100%;">
	                <div class="news-title">
	                    ${news.title }
	                </div>
	                <div class="news-desc">
	                	<p>${news.title }</p>
	                	<p style="font-size: 18px;">
	                    ${news.digest }
	                    </p>
	                </div>
	                </a>
	            </div>
	        <c:if test="${status.count % 3 == 0 }">
	        </div>
	        </c:if>
        </c:forEach>
        <div class="col-md-4 col-sm-4 col-xs-12 news-item">
        <a href="pc/news">
            <img class="img-responsive" src="static/pc/assets/img/new6.png" style="width: 100%;height: 236px;">
            <div class="news-title">
                了解更多精彩信息
            </div>
            <div class="news-desc">
            	<p>了解更多精彩信息</p>
            	<p style="font-size: 18px;">
                </p>
            </div>
            </a>
        </div>
        </div>
    </div>
</div>
</c:if>

<div class="team-block content company" id="company">
    <div class="container">
        <div class="title">
            <h2 style="font-size: 25px">公司介绍<span class="first" style="font-size: 15px">COMPANY</span><span style="font-size: 15px">INTRODUCTION</span></h2>
        </div>
        <div class="row margin-top-30">
            <div class="col-md-4 col-sm-4 col-xs-12">
                <img class="img-responsive" alt="公司介绍" src="static/pc/assets/img/company-logo.png">
                <img src="static/pc/assets/img/erweima.png" style="padding-left: 40px;padding-top: 20px;">
            </div>
            <div class="col-md-8 col-sm-8 col-xs-12 company-intr" style="text-align: left;">
                <p style="font-size: 17px;">袋鼠管家是做什么的？听起来好像是搞IT的……</p>
                <p style="font-size: 17px;">“管家”一词，源于旧时贵族阶层的家庭生活方式，意指家庭服务的管理人员。而当下各式“管家”林林总总，与“管家”原意相去甚远。而“袋鼠管家”让管家回归本源，也就是说，袋鼠管家就是家庭服务的管理人员。简单来说，就是高品质的家政人员。</p>
                <p style="font-size: 17px;">具体来说，袋鼠管家能做的事是多方面的，无论是家居保洁、衣物干洗、换季收纳、家庭保姆等，都是我们的服务方向。</p>
                <p style="font-size: 17px;">袋鼠管家更注重服务品质和流程标准，力求通过人才培训、工具革新、流程改造等给客服带来高品质、高效率的服务体验。</p>
                <br>
                <br>
                <br>
                <p style="font-size: 17px;">地址：</p>
                <p style="font-size: 17px;">成都市武侯区临江东路36号锦江花园城砖石座18-C</p>
                <br>
                <p style="font-size: 17px;">电话：</p>
                <p style="font-size: 17px;">4008-597-880</p>
            </div>
        </div>
    </div>
</div>

<div class="about-block content recruitment content-center" id="recruitment" style="background-color: #fdebcf;">
    <div class="container" style="padding-bottom: 0;">
        <div class="title">
            <h2 style="font-size: 25px">招聘<span class="first" style="font-size: 15px">JOIN</span><span style="font-size: 15px">US</span></h2>
        </div>
        <div class="margin-top-30" style="margin-left: 143px;">
        <c:choose>
        	<c:when test="${not empty systemConfig and not empty systemConfig.recruitmentUrl }">
        	<a href="${systemConfig.recruitmentUrl }">
	            <img class="img-responsive" src="static/pc/assets/img/recruitment-logo.png">
        	</a>
        	</c:when>
        	<c:otherwise>
	            <img class="img-responsive" src="static/pc/assets/img/recruitment-logo.png">
        	</c:otherwise>
        </c:choose>
        </div>
    </div>
</div>

<div class="content content-center" style="background-color: #f39910;margin-top:-5px">
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