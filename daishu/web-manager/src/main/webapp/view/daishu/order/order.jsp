<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="order_container" class="table-container">
	<div class="form-horizontal">
		<div class="form-body">
			<div class="form-group">
                 <label class="control-label col-md-1">顾客名称</label>
                 <div class="col-md-3">
                     <input name="customerName" type="text" placeholder="顾客名称" class="form-control form-filter">
                 </div>
                 <label class="control-label col-md-1">工号</label>
                 <div class="col-md-3">
                     <input name="orderNo" type="text" placeholder="订单号" class="form-control form-filter">
                 </div>
                 <div class="col-md-3">
                     <button class="btn btn-primary filter-submit">查询</button>
                 </div>
             </div>
		</div>
	</div>
	<div class="btn-group">
		<button class="btn red orders_delete" type="button">
            <i class="fa fa-plus"></i> 删除</button>
    </div>
	<table id="datatable_order" class="table table-striped table-bordered table-hover table-checkable">
		<thead>
			<tr role="row" class="heading">
				<th width="2%"><input type="checkbox" class="group-checkable"></th>
				<th width="16%">订单号</th>
				<th width="16%">顾客</th>
				<th width="16%">下单时间</th>
				<th width="16%">保洁类型</th>
				<th width="16%">服务阿姨</th>
				<th width="18%">操作</th>
			</tr>
		</thead>
	</table>
</div>
