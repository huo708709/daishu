<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="customer_container" class="table-container">
	<div class="form-horizontal">
		<div class="form-body">
			<div class="form-group">
                 <label class="control-label col-md-1">名称</label>
                 <div class="col-md-3">
                     <input name="name" type="text" placeholder="名称" class="form-control form-filter">
                 </div>
                 <label class="control-label col-md-1">编码</label>
                 <div class="col-md-3">
                     <input name="code" type="text" placeholder="编码" class="form-control form-filter">
                 </div>
                 <div class="col-md-3">
                     <button class="btn btn-primary filter-submit">查询</button>
                 </div>
             </div>
		</div>
	</div>
	<div class="btn-group">
        <!-- <button class="btn green skip_to_edit" type="button" url="ds/customer/add">
            <i class="fa fa-plus"></i> 添加</button> -->
		<button class="btn red customers_delete" type="button">
            <i class="fa fa-plus"></i> 删除</button>
    </div>
	<table id="datatable_customer" class="table table-striped table-bordered table-hover table-checkable">
		<thead>
			<tr role="row" class="heading">
				<th width="2%"><input type="checkbox" class="group-checkable"></th>
				<th width="12%">微信名称</th>
				<th width="12%">名称</th>
				<th width="12%">电话</th>
				<th width="12%">状态</th>
				<th width="12%">上次登录时间</th>
				<th width="12%">首次登录时间</th>
				<th width="12%">地址</th>
				<th width="14%">操作</th>
			</tr>
		</thead>
	</table>
</div>
