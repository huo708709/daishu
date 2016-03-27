<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="portlet light bg-inverse">
	<div class="portlet-body form">
		<form id="unit_form" class="form-horizontal" action="daishu/unit/update" method="post">
			<input type="hidden" name="id" value="${unit.id }">
			<div class="form-body">
				<div class="alert alert-danger display-hide">
                	<button data-close="alert" class="close"></button> You have some form errors. Please check below. </div>
                <div class="alert alert-success display-hide">
                	<button data-close="alert" class="close"></button> Your form validation is successful! </div>
				<h3 class="form-section">单位信息</h3>
				<div class="form-group">
		            <label class="control-label col-sm-2 col-md-1">名称</label>
		            <div class="col-sm-4 col-md-5">
		                <input name="name" value="${unit.name }" type="text" placeholder="名称" class="form-control">
		            </div>
		            <label class="control-label col-sm-2 col-md-1">单价</label>
		            <div class="col-sm-4 col-md-5">
		                <input name="price" value="${unit.price }" type="text" placeholder="单价" class="form-control">
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