<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="portlet light bg-inverse">
	<div class="portlet-body form">
		<form id="order_copy_form" class="form-horizontal" action="ds/order/copy" method="post">
			<input type="hidden" name="id" value="${order.id }">
			<div class="form-body">
				<div class="alert alert-danger display-hide">
                	<button data-close="alert" class="close"></button> You have some form errors. Please check below. </div>
                <div class="alert alert-success display-hide">
                	<button data-close="alert" class="close"></button> Your form validation is successful! </div>
				<h3 class="form-section">订单信息</h3>
				<div class="form-group">
		            <label class="control-label col-sm-2 col-md-1">面积</label>
		            <div class="col-sm-4 col-md-5">
		                <input name="area" value="${order.area }"  type="text" placeholder="名称" class="form-control">
		            </div>
		            <label class="control-label col-sm-2 col-md-1">价格</label>
		            <div class="col-sm-4 col-md-5">
		                <input name="price" <%-- value="${order.price }" --%> type="text" placeholder="价格" class="form-control">
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label col-sm-2 col-md-1">服务时间</label>
		            <div class="col-sm-4 col-md-5">
		                <select name="serviceTimeType" class="form-control form-filter">
			            	<option value="1">8:00-12:00</option>
			            	<option value="2">12:00-15:00</option>
			            	<option value="3">15:00-18:00</option>
			            	<option value="4">18:00-20:00</option>
		            	</select>
		            </div>
		            <label class="control-label col-sm-2 col-md-1">服务日期</label>
		            <div class="col-sm-4 col-md-5">
		                <input id="serviceDate" 
		                <%--  value="<fmt:formatDate value="${order.serviceDate}" pattern="yyyy-MM-dd"/>"  --%> 
		                name=serviceDate type="text" placeholder="服务日期" class="form-control">
		            </div>
		        </div>
		        <div class="form-group">
			            <label class="control-label col-sm-2 col-md-1">保洁类型</label>
			            <div class="col-sm-4 col-md-5">
			                <select name="baojieType" class="form-control form-filter">
				            	<c:forEach items="${businessList }" var="business">
				            		<option value="${business.type}">${business.name}</option>
								</c:forEach>
			            	</select>
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