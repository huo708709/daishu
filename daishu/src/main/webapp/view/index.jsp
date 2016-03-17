<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE>
<html lang="en">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->

    <head>
        <meta charset="utf-8" />
        <title>袋鼠管家</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <!-- <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" /> -->
        <link href="static/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="static/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="static/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="static/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
        <link href="static/global/plugins/bootstrap-switch/bootstrap-switch.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <link href="static/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
        <link href="static/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="static/global/plugins/bootstrap-toastr/toastr.css" rel="stylesheet" type="text/css" />
        <link href="static/global/plugins/jquery-treegrid/css/jquery.treegrid.css" rel="stylesheet" type="text/css" />
        <link href="static/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <link href="static/global/plugins/bootstrap-summernote/summernote.css" rel="stylesheet" type="text/css" />
        <link href="static/global/plugins/bootstrap-editable/bootstrap-editable/css/bootstrap-editable.css" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="static/global/css/components.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="static/global/css/plugins.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="static/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="static/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="static/layouts/layout/css/custom.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="favicon.ico" /> </head>
    <!-- END HEAD -->

    <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
        <div class="page-header navbar navbar-fixed-top">
            <div class="page-header-inner ">
                <div class="page-logo">
                    <a href="index.html">
                        <img src="static/layouts/layout/img/logo.png" alt="logo" class="logo-default" /> </a>
                    <div class="menu-toggler sidebar-toggler"> </div>
                </div>
                <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </a>
                <div class="top-menu">
                    <ul class="nav navbar-nav pull-right">
                        <li class="dropdown dropdown-user">
                            <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                <img alt="" class="img-circle" src="static/layouts/layout/img/avatar3_small.jpg" />
                                <span class="username username-hide-on-mobile"> ${sessionScope.user.loginName } </span>
                                <i class="fa fa-angle-down"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-default">
                                <li>
                                    <a href="loginout">
                                        <i class="icon-key"></i> 退出 </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="clearfix"> </div>
        <div class="page-container">
            <div class="page-sidebar-wrapper">
                <div class="page-sidebar navbar-collapse collapse">
                    <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200" style="padding-top: 0px">
                        <li class="sidebar-toggler-wrapper hide">
                            <div class="sidebar-toggler"> </div>
                        </li>
                        <c:forEach items="${menus }" var="menu">
                        <li class="nav-item">
                            <a href="javascript:;" class="nav-link nav-toggle">
                                <i class="icon-home"></i>
                                <span class="title">${menu.name }</span>
                                <span class="selected"></span>
                                <span class="arrow open"></span>
                            </a>
                            <c:if test="${not empty menu.children }">
                            <ul class="sub-menu">
                            	<c:forEach items="${menu.children }" var="child">
                                <li class="nav-item start">
                                    <a href="#${child.url }" class="nav-link ajaxify">
                                        <i class="icon-bar-chart"></i>
                                        <span class="title">${child.name }</span>
                                    </a>
                                </li>
                            	</c:forEach>
                            </ul>
                            </c:if>
                        </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="page-content-wrapper">
                <div class="page-content">
                    <div class="page-bar">
                        <ul class="page-breadcrumb">
                            <li>
                                <a href="index.html">Home</a>
                                <i class="fa fa-circle"></i>
                            </li>
                            <li>
                                <span>Dashboard</span>
                            </li>
                        </ul>
                    </div>
                    <div class="page-content-body" style="margin-top: 10px;">
                    </div>
                    <div class="page-edit-body" style="margin-top: 10px;display:none;">
                    </div>
                </div>
            </div>
        </div>
        <div class="page-footer">
            <div class="page-footer-inner"> 2014 &copy; Metronic by keenthemes.
                <a href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes" title="Purchase Metronic just for 27$ and get lifetime updates for free" target="_blank">Purchase Metronic!</a>
            </div>
            <div class="scroll-to-top">
                <i class="icon-arrow-up"></i>
            </div>
        </div>
        <!--[if lt IE 9]>
<script src="static/global/plugins/respond.min.js"></script>
<script src="static/global/plugins/excanvas.min.js"></script> 
<![endif]-->
        <!-- BEGIN CORE PLUGINS -->
        <script src="static/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="static/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
        <script src="static/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="static/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
        <script src="static/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="static/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="static/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
        <script src="static/global/plugins/bootstrap-switch/bootstrap-switch.js" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <script src="static/global/plugins/bootstrap-toastr/toastr.js" type="text/javascript"></script>
        <script src="static/global/plugins/bootbox/bootbox.js" type="text/javascript"></script>
        <script src="static/global/plugins/jquery-validation/js/jquery.validate.js" type="text/javascript"></script>
        <script src="static/global/plugins/jquery-validation/js/additional-methods.js" type="text/javascript"></script>
        <script src="static/global/plugins/jquery-validation/js/localization/messages_zh.js" type="text/javascript"></script>
        <script src="static/global/plugins/jquery-validation/js/jquery.form.js" type="text/javascript"></script>
        <script src="static/global/scripts/datatable.js" type="text/javascript"></script>
        <script src="static/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
        <script src="static/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
        <script src="static/global/plugins/jquery-treegrid/js/jquery.treegrid.js" type="text/javascript"></script>
        <script src="static/global/plugins/jquery-treegrid/js/jquery.treegrid.bootstrap3.js" type="text/javascript"></script>
        <script src="static/global/plugins/bootstrap-daterangepicker/moment.min.js" type="text/javascript"></script>
        <script src="static/global/plugins/bootstrap-daterangepicker/daterangepicker.js" type="text/javascript"></script>
        <script src="static/global/plugins/bootstrap-summernote/summernote.min.js" type="text/javascript"></script>
        <script src="static/global/plugins/bootstrap-summernote/lang/summernote-zh-CN.js" type="text/javascript"></script>
        <script src="static/global/plugins/jquery.mockjax.js" type="text/javascript"></script>
        <script src="static/global/plugins/bootstrap-editable/bootstrap-editable/js/bootstrap-editable.min.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="static/global/plugins/require.js" type="text/javascript"></script>
        <script src="static/global/scripts/app.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <script src="static/layouts/layout/scripts/layout.js" type="text/javascript"></script>
        <!-- END THEME LAYOUT SCRIPTS -->
        <script type="text/javascript">
        requirejs.config({
        	baseUrl: "static"
        });
        jQuery(document).ready(function() {
        	App.init(); // init metronic core componets
        	
        	toastr.options = {
        		closeButton: true,
        		debug: false,
        		positionClass: 'toast-bottom-right',
        		onclick: null,
        		showDuration: '500',
        		hideDuration: '500',
        		timeOut: '2000',
        		extendedTimeOut: '500',
        		showEasing: 'swing',
        		hideEasing: 'linear',
        		showMethod: 'fadeIn',
        		hideMethod: 'fadeOut'
        	}
        });
        </script>
    </body>
</html>