<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul class="am-list" style="margin-bottom: 1rem;">
<c:forEach items="${list }" var="address">
    <li class="am-g am-list-item-dated list-item-address" data-addressid="${address.id }" data-content="${address.content }">
        <div class="am-u-sm-12">
            <div class="address-content-wrapper">
                <label><input type="checkbox" style="display: none;"><img class="address-icon address-selected" src="static/img/unselected.png">
                    <span class="address-content">${address.content }</span></label>
            </div>
        </div>
        <div class="am-u-sm-5 am-u-sm-offset-1" style="line-height: 1.2">
            <label><img class="address-icon address-icon-small" src="static/img/localtion.png"><span class="address-loaction">${address.area }</span></label>
        </div>
        <div class="am-u-sm-3" style="line-height: 1.2">
            <a href="address/addressEdit?id=${address.id }&type=1&baojieType=${baojieType}&title=${title}"><img class="address-icon address-icon-small" src="static/img/edit.png"><span class="address-edit">编辑</span></a>
        </div>
        <div class="am-u-sm-3" style="line-height: 1.2">
            <a href="address/addressDel?id=${address.id }&type=1&baojieType=${baojieType}&title=${title}"><img class="address-icon address-icon-small" src="static/img/delete.png"><span class="address-delete">删除</span></a>
        </div>
    </li>
</c:forEach>
	    </ul>
</body>
</html>