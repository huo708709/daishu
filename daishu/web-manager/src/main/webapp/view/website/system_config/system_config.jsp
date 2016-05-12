<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-12">
		<table id="system_config_table" class="table table-bordered table-striped">
			<tbody>
				<tr>
					<td style="width:15%"> 招聘URL </td>
                    <td style="width:60%">
                        <a class="editable_item" href="javascript:;" id="recruitment_url" data-type="text" data-pk="recruitment_url" data-original-title="输入招聘URL">${systemConfig.recruitmentUrl }</a>
                    </td>
                    <td style="width:25%">
                        <span class="text-muted"> 输入正确的URL </span>
                    </td>
				</tr>
				<tr>
					<td style="width:15%"> 客户热线 </td>
                    <td style="width:60%">
                        <a class="editable_item" href="javascript:;" id="tel" data-type="text" data-pk="tel" data-original-title="客户热线">${systemConfig.tel }</a>
                    </td>
                    <td style="width:25%">
                        <span class="text-muted"> 输入正确的号码 </span>
                    </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="portlet light">
	<div class="portlet-body form">
		<form id="xieyi_form" class="form-horizontal" action="website/system_config/update_xieyi" method="post">
			<input name="name" type="hidden" value="xieyi">
			<div class="form-body">
				<div class="alert alert-danger display-hide">
                	<button data-close="alert" class="close"></button> You have some form errors. Please check below. </div>
                <div class="alert alert-success display-hide">
                	<button data-close="alert" class="close"></button> Your form validation is successful! </div>
				<h3 class="form-section">服务协议</h3>
		        <div class="form-group">
		            <label class="control-label col-md-2">协议内容</label>
		            <textarea style="display: none;" name="value" id="content_xieyi"></textarea>
		            <div class="col-md-10">
                        <div name="content" id="summernote_xieyi">${systemConfig.xieyi }</div>
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
<div class="portlet light">
	<div class="portlet-body form">
		<form id="guize_form" class="form-horizontal" action="website/system_config/update_guize" method="post">
			<input name="name" type="hidden" value="guize">
			<div class="form-body">
				<div class="alert alert-danger display-hide">
                	<button data-close="alert" class="close"></button> You have some form errors. Please check below. </div>
                <div class="alert alert-success display-hide">
                	<button data-close="alert" class="close"></button> Your form validation is successful! </div>
				<h3 class="form-section">使用规则</h3>
		        <div class="form-group">
		            <label class="control-label col-md-2">规则内容</label>
		            <textarea style="display: none;" name="value" id="content_guize"></textarea>
		            <div class="col-md-10">
                        <div name="content" id="summernote_guize">${systemConfig.guize }</div>
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