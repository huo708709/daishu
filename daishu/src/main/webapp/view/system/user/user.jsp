<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="user_container" class="table-container">
	<div class="form-horizontal">
		<div class="form-body">
			<div class="form-group">
                 <label class="control-label col-md-1">用户ID</label>
                 <div class="col-md-3">
                     <input name="id" type="text" placeholder="用户ID" class="form-control form-filter">
                 </div>
                 <label class="control-label col-md-1">用户名</label>
                 <div class="col-md-3">
                     <input name="username" type="text" placeholder="用户名" class="form-control form-filter">
                 </div>
                 <div class="col-md-3">
                     <button class="btn btn-primary filter-submit">查询</button>
                 </div>
             </div>
		</div>
	</div>
	<div class="btn-group">
        <button class="btn green skip_to_edit" type="button" url="system/user/add">
            <i class="fa fa-plus"></i> 添加</button>
		<button class="btn red users_delete" type="button">
            <i class="fa fa-plus"></i> 删除</button>
    </div>
	<table id="datatable_user" class="table table-striped table-bordered table-hover table-checkable">
		<thead>
			<tr role="row" class="heading">
				<th width="2%"><input type="checkbox" class="group-checkable"></th>
				<th width="20%">用户名</th>
				<th width="20%">邮箱</th>
				<th width="20%">电话</th>
				<th width="20%">状态</th>
				<th width="20%">操作</th>
			</tr>
		</thead>
	</table>
</div>
