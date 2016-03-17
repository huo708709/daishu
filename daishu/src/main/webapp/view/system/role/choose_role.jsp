<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-header">
    <a href="javascript:;" class="close" data-dismiss="modal" aria-hidden="true"></a>
    <h4 class="modal-title">选择角色</h4>
</div>
<div class="modal-body">
	<table id="datatable_choose_role" class="table table-condensed table-striped table-bordered table-hover order-column">
		<thead>
		    <tr class="heading">
		        <th width="2%"></th>
		        <th width="30%">名称</th>
		        <th width="68%">描述</th>
		    </tr>
		</thead>
		<tbody>
			<c:forEach items="${roles }" var="role">
			<tr>
				<td>
				<c:choose>
					<c:when test="${role.selected }">
					<input type="checkbox" title="${role.id }" checked="checked" class="checkboxes" value="${role.id }" /></td>
					</c:when>
					<c:otherwise>
					<input type="checkbox" title="${role.id }" class="checkboxes" value="${role.id }" /></td>
					</c:otherwise>
				</c:choose>
				<td>${role.name }</td>
				<td>${role.description }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div class="modal-footer">
    <a href="javascript:;" class="btn grey-salsa btn-outline" data-dismiss="modal">关闭</a>
    <a href="javascript:;" class="btn green" data-affirm="modal"><i class="fa fa-check"></i> 确认</a>
</div>
