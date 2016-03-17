<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="portlet light bg-inverse">
	<div class="portlet-body form">
		<form id="user_form" class="form-horizontal" action="system/user/update" method="post">
			<input name="id" type="hidden" value="${user.id }">
			<div class="form-body">
				<div class="alert alert-danger display-hide">
                	<button data-close="alert" class="close"></button> You have some form errors. Please check below. </div>
                <div class="alert alert-success display-hide">
                	<button data-close="alert" class="close"></button> Your form validation is successful! </div>
				<h3 class="form-section">用户信息</h3>
				<div class="form-group">
		            <label class="control-label col-md-1 col-sm-2">用户名</label>
		            <div class="col-md-5 col-md-4">
		                <input name="username" value="${user.username }" type="text" placeholder="用户名" class="form-control">
		            </div>
		            <label class="control-label col-md-1 col-sm-2">密码</label>
		            <div class="col-md-5 col-md-4">
		                <input name="password" value="${user.password }" type="text" placeholder="密码" class="form-control">
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label col-md-1 col-sm-2">电话号码</label>
		            <div class="col-md-5 col-md-4">
		                <input name="phone" value="${user.phone }" type="text" placeholder="电话号码" class="form-control">
		            </div>
		            <label class="control-label col-md-1 col-sm-2">邮箱</label>
		            <div class="col-md-5 col-md-4">
		                <input name="email" value="${user.email }" type="text" placeholder="邮箱" class="form-control">
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