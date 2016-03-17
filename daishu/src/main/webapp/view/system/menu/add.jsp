<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="portlet light bg-inverse">
	<div class="portlet-body form">
		<form id="menu_form" class="form-horizontal" action="system/menu/add" method="post">
			<div class="form-body">
				<div class="alert alert-danger display-hide">
                	<button data-close="alert" class="close"></button> You have some form errors. Please check below. </div>
                <div class="alert alert-success display-hide">
                	<button data-close="alert" class="close"></button> Your form validation is successful! </div>
				<h3 class="form-section">菜单信息</h3>
				<div class="form-group">
		            <label class="control-label col-sm-2 col-md-1">名称</label>
		            <div class="col-sm-4 col-md-5">
		                <input name="name" type="text" placeholder="名称" class="form-control">
		            </div>
		            <label class="control-label col-sm-2 col-md-1">编码</label>
		            <div class="col-sm-4 col-md-5">
		                <input name="code" type="text" placeholder="编码" class="form-control">
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label col-sm-2 col-md-1">地址</label>
		            <div class="col-sm-4 col-md-5">
		                <input name="url" type="text" placeholder="地址" class="form-control">
		            </div>
		            <label class="control-label col-sm-2 col-md-1">图标</label>
		            <div class="col-sm-4 col-md-5">
		                <input name="icon" type="text" placeholder="图标" class="form-control">
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label col-sm-2 col-md-1">父级</label>
		            <div class="col-sm-4 col-md-5">
		                <div class="input-group choose_menu">
                            <input name="parentId" type="text" placeholder="父级" class="form-control">
                            <span class="input-group-btn">
                                <button type="button" class="btn blue">选择</button>
                            </span>
                        </div>
		            </div>
		        </div>
			</div>
			<div class="form-actions">
                <div class="row">
                    <div class="col-md-offset-10 col-md-2">
                        <button class="btn green" type="submit">提交</button>
                        <button class="btn default skip_to_content" type="button">取消</button>
                    </div>
                </div>
		    </div>
		</form>
	</div>
</div>