<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal-header">
    <a href="javascript:;" class="close" data-dismiss="modal" aria-hidden="true"></a>
    <h4 class="modal-title">选择角色</h4>
</div>
<div class="modal-body">
	<div class="table-container">
		<table id="datatable_choose_role" class="table table-striped table-bordered table-hover table-checkable">
			<thead>
				<tr role="row" class="heading">
					<th width="2%"><input type="checkbox" class="group-checkable"></th>
					<th width="25%">名称</th>
					<th width="73%">描述</th>
				</tr>
			</thead>
		</table>
	</div>
</div>
<div class="modal-footer">
    <a href="javascript:;" class="btn grey-salsa btn-outline" data-dismiss="modal">关闭</a>
    <a href="javascript:;" class="btn green" data-affirm="modal"><i class="fa fa-check"></i> 确认</a>
</div>
