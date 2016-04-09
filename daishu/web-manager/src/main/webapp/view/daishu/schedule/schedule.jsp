<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-12">
		<table id="schedule_table" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>保洁类型</th>
					<th>周一</th>
					<th>周二</th>
					<th>周三</th>
					<th>周四</th>
					<th>周五</th>
					<th>周六</th>
					<th>周日</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${schedules}" var="schedule">
					<tr>
	                    <td style="width:12.5%">
						    ${schedule.baojieName}
						</td>
						<td style="width:12.5%">
						    <a class="editable_item" href="javascript:;" data-type="text" id="xingqi1"  data-pk="${schedule.baojieType}" >${schedule.xingqi1}
						</td>
						<td style="width:12.5%">
						    <a class="editable_item" href="javascript:;" data-type="text" id="xingqi2"  data-pk="${schedule.baojieType}" >${schedule.xingqi2}
						</td>
						<td style="width:12.5%">
						    <a class="editable_item" href="javascript:;" data-type="text" id="xingqi3"  data-pk="${schedule.baojieType}" >${schedule.xingqi3}
						</td>
						<td style="width:12.5%">
						    <a class="editable_item" href="javascript:;" data-type="text" id="xingqi4"  data-pk="${schedule.baojieType}" >${schedule.xingqi4}
						</td>
						<td style="width:12.5%">
						    <a class="editable_item" href="javascript:;" data-type="text" id="xingqi5"  data-pk="${schedule.baojieType}" >${schedule.xingqi5}
						</td>
						<td style="width:12.5%">
						    <a class="editable_item" href="javascript:;" data-type="text" id="xingqi6"  data-pk="${schedule.baojieType}" >${schedule.xingqi6}
						</td>
						<td style="width:12.5%">
						    <a class="editable_item" href="javascript:;" data-type="text" id="xingqi7"  data-pk="${schedule.baojieType}" >${schedule.xingqi7}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>