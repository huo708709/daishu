<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="data_order_container" class="table-container">
	<div class="form-horizontal">
		<div class="form-body">
			<div class="form-group">
                 <label class="control-label col-md-1">开始时间</label>
                 <div class="col-md-3">
                     <input id="startTime" name="startTime" type="text" placeholder="订单创建时间起" class="form-control form-filter">
                 </div>
                 <label class="control-label col-md-1">结束时间</label>
                 <div class="col-md-3">
                     <input id="endTime" name="endTime" type="text" placeholder="订单创建时间止" class="form-control form-filter">
                 </div>
             </div>
		</div>
		<div class="form-body">
			<div class="form-group">
                 <label class="control-label col-md-1">阿姨</label>
                 <div class="col-md-3">
                     <select name="ayiId" class="form-control form-filter">
                     	<option value="0">全部</option>
                     	<c:forEach items="${ayis }" var="ayi">
                     	<option value="${ayi.id }">${ayi.name }</option>
                     	</c:forEach>
                     </select>
                 </div>
                 <div class="col-md-3">
                     <button class="btn btn-primary filter-submit">查询</button>
                 </div>
             </div>
		</div>
	</div>
	<table id="datatable_data_order" class="table table-striped table-bordered table-hover table-checkable">
		<thead>
			<tr role="row" class="heading">
				<th width="10%">下单日期</th>
				<th width="10%">订单数</th>
				<th width="10%">订单总额</th>
				<th width="10%">微信支付订单数</th>
				<th width="10%">现金支付订单数</th>
				<th width="10%">会员卡支付订单数</th>
			</tr>
		</thead>
	</table>
</div>
