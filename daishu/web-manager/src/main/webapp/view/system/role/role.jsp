<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="role_container" class="table-container">
	<div class="form-horizontal">
		<div class="form-body">
			<div class="form-group">
                 <label class="control-label col-md-1">名称</label>
                 <div class="col-md-3">
                     <input name="name" type="text" placeholder="名称" class="form-control form-filter">
                 </div>
                 <div class="col-md-3">
                     <button class="btn btn-primary filter-submit">查询</button>
                 </div>
             </div>
		</div>
	</div>
	<div class="btn-group">
        <button class="btn green skip_to_edit" type="button" url="system/role/add">
            <i class="fa fa-plus"></i> 添加</button>
		<button class="btn red roles_delete" type="button">
            <i class="fa fa-plus"></i> 删除</button>
    </div>
	<table id="datatable_role" class="table table-striped table-bordered table-hover table-checkable">
		<thead>
			<tr role="row" class="heading">
				<th width="2%"><input type="checkbox" class="group-checkable"></th>
				<th width="25%">名称</th>
				<th width="50%">描述</th>
				<th width="23%">操作</th>
			</tr>
		</thead>
	</table>
</div>
