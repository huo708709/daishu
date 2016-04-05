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
			</tbody>
		</table>
	</div>
</div>