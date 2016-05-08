<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="order_statistic_container" class="table-container">
	<div class="form-horizontal">
		<div class="form-body">
			<div class="form-group">
                 <label class="control-label col-md-1">订单号</label>
                 <div class="col-md-2">
                     <input name="orderNo" type="text" placeholder="订单号" class="form-control form-filter">
                 </div>
                 <label class="control-label col-md-1">顾客名称</label>
                 <div class="col-md-2">
                     <input name="customerName" type="text" placeholder="顾客名称" class="form-control form-filter">
                 </div>
                 <label class="control-label col-md-1">联系人</label>
                 <div class="col-md-2">
                     <input name="name" type="text" placeholder="联系人" class="form-control form-filter">
                 </div>
             </div>
			<div class="form-group">
                 <label class="control-label col-md-1">支付状态</label>
                 <div class="col-md-2">
                    <select name="payStatus" class="form-control form-filter">
                    	<option value="0">请选择</option>
		            	<option value="1">待支付</option>
		            	<option value="2">服务中</option>
		            	<option value="3">待评价</option>
		            	<option value="4">已评价</option>
		            	<option value="5">已取消</option>
		            </select>
                 </div>
                 <label class="control-label col-md-1">审核状态</label>
                 <div class="col-md-2">
                    <select name="auditStatus" class="form-control form-filter">
                    	<option value="0">请选择</option>
		            	<option value="1">待审核</option>
		            	<option value="2">审核通过</option>
		            	<option value="3">审核不通过</option>
		            </select>
                 </div>
                 <label class="control-label col-md-1">服务时间</label>
                 <div class="col-md-2">
                     <select name="serviceTimeType" class="form-control form-filter">
                     	<option value="0">请选择</option>
		            	<option value="1">8:00-12:00</option>
		            	<option value="2">12:00-15:00</option>
		            	<option value="3">15:00-18:00</option>
		            	<option value="4">18:00-20:00</option>
		            </select>
                 </div>
             </div>
             <div class="form-group">
                 <div class="col-md-10" style="text-align: center;">
                     <button class="btn btn-primary filter-submit">查询</button>
                 </div>
             </div>
		</div>
	</div>
	<table id="datatable_order_statistic" class="table table-striped table-bordered table-hover table-checkable">
		<thead>
			<tr role="row" class="heading">
				<th width="2%"><input type="checkbox" class="group-checkable"></th>
				<th width="8%">订单号</th>
				<th width="5%">顾客</th>
				<th width="10%">电话</th>
				<th width="10%">地址</th>
				<th width="10%">下单时间</th>
				<th width="10%">服务日期</th>
				<th width="10%">服务时间</th>
				<th width="8%">审核状态</th>
				<th width="8%">支付状态</th>
				<th width="10%">保洁类型</th>
				<th width="10%">服务阿姨</th>
				<th width="8%">订单价格</th>
			</tr>
		</thead>
	</table>
</div>
