<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-header">
    <a href="javascript:;" class="close" data-dismiss="modal" aria-hidden="true"></a>
    <h4 class="modal-title">授权</h4>
</div>
<div class="modal-body">
	<form id="authorize_menu_form" action="system/role/authorize" method="post">
		<input name="roleId" value="${roleId }" type="hidden">
		<table id="authorize_menu_treegrid" class="table table-condensed table-bordered table-hover tree">
			<c:forEach items="${permissions }" var="permission">
			<c:choose>
				<c:when test="${permission.parentId > 0 }">
			<tr class="treegrid-${permission.id } treegrid-parent-${permission.parentId }">
				</c:when>
				<c:otherwise>
			<tr class="treegrid-${permission.id }">
				</c:otherwise>
			</c:choose>
				<td width="30%">${permission.name }</td>
				<td width="70%" style="padding-left: 30px;">
				<c:if test="${not empty permission.functions }">
				<div class="checkbox-list">
				<c:forEach items="${permission.functions }" var="function">
	                <label class="checkbox-inline">
	                	<c:choose>
	                		<c:when test="${function.selected }">
	                		<input name="functionIds" checked="checked" type="checkbox" value="${function.id }"> ${function.name } </label>
	                		</c:when>
	                		<c:otherwise>
	                		<input name="functionIds" type="checkbox" value="${function.id }"> ${function.name } </label>
	                		</c:otherwise>
	                	</c:choose>
				</c:forEach>
	            </div>
				</c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>
</div>
<div class="modal-footer">
    <a href="javascript:;" class="btn grey-salsa btn-outline" data-dismiss="modal">关闭</a>
    <a href="javascript:;" class="btn green" data-affirm="modal"><i class="fa fa-check"></i> 确认</a>
</div>
