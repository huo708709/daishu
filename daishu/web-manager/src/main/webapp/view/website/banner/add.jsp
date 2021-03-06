<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="portlet light bg-inverse">
	<div class="portlet-body form">
		<form id="banner_form" class="form-horizontal" action="website/banner/add" method="post">
			<div class="form-body">
				<div class="alert alert-danger display-hide">
                	<button data-close="alert" class="close"></button> You have some form errors. Please check below. </div>
                <div class="alert alert-success display-hide">
                	<button data-close="alert" class="close"></button> Your form validation is successful! </div>
				<h3 class="form-section">Banner</h3>
				<div class="form-group">
		            <label class="control-label col-md-2">标题</label>
		            <div class="col-md-10">
		                <input name="title" type="text" placeholder="标题" class="form-control">
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label col-md-2">链接地址</label>
		            <div class="col-md-10">
		                <input name="url" type="text" placeholder="链接地址" class="form-control">
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label col-md-2">显示位置</label>
		            <div class="col-md-10">
		                <select class="form-control" name="type">
		                	<option value="1" selected="selected">PC网站</option>
		                	<option value="2">微信平台</option>
		                </select>
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label col-md-2">封面图</label>
		            <div class="col-md-10">
		                <input name="file" type="file">
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label col-md-2">描述</label>
		            <div class="col-md-10">
		            	<textarea name="description" placeholder="描述" class="form-control" ></textarea>
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