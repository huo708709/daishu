<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-12">
		<table id="member_card_table" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>会员卡名字</th>
					<th>需要充值金额</th>
					<th>充值赠送金额</th>
				</tr>
			</thead>
			<tbody>
			<tr>
				<c:forEach items="${memberCards}" var="memberCard">
					<tr>
                    <td style="width:25%">
					    <a class="editable_item" href="javascript:;" data-type="text" id="name" data-pk="${memberCard.type}" >${memberCard.name}
					</td>
					<td style="width:25%">
					    <a class="editable_item" href="javascript:;" data-type="text" id="recharge_amount"  data-pk="${memberCard.type}" >${memberCard.rechargeAmount}
					</td>
					<td style="width:25%">
					    <a class="editable_item" href="javascript:;" data-type="text" id="give_amount"  data-pk="${memberCard.type}" >${memberCard.giveAmount}
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>