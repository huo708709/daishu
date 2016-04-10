<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-header">
    <a href="javascript:;" class="close" data-dismiss="modal" aria-hidden="true"></a>
    <h4 class="modal-title">选择阿姨</h4>
</div>
<div class="modal-body">
	<table id="datatable_choose_ayi" class="table table-condensed table-striped table-bordered table-hover order-column">
		<thead>
		    <tr class="heading">
		        <th width="2%"></th>
		        <th width="30%">姓名</th>
		        <th width="68%">工号</th>
		    </tr>
		</thead>
		<tbody>
			<c:forEach items="${ayis }" var="ayi">
			<tr>
				<td>
				<c:choose>
					<c:when test="${ayi.selected }">
					<input type="checkbox" title="${ayi.id }" checked="checked" class="checkboxes" value="${ayi.id }" /></td>
					</c:when>
					<c:otherwise>
					<input type="checkbox" title="${ayi.id }" class="checkboxes" value="${ayi.id }" /></td>
					</c:otherwise>
				</c:choose>
				<td>${ayi.name }</td>
				<td>${ayi.cardNo }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div class="modal-footer">
    <a href="javascript:;" class="btn grey-salsa btn-outline" data-dismiss="modal">关闭</a>
    <a href="javascript:;" class="btn green" data-affirm="modal"><i class="fa fa-check"></i> 确认</a>
</div>
