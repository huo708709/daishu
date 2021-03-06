<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="portlet light bg-inverse">
	<div class="portlet-body form">
		<form id="business_form" class="form-horizontal" action="website/business/update" method="post">
			<input type="hidden" name="id" value="${business.id }">
			<div class="form-body">
				<div class="alert alert-danger display-hide">
                	<button data-close="alert" class="close"></button> You have some form errors. Please check below. </div>
                <div class="alert alert-success display-hide">
                	<button data-close="alert" class="close"></button> Your form validation is successful! </div>
				<h3 class="form-section">业务类型信息</h3>
				<div class="form-group">
		            <label class="control-label col-md-2">名称</label>
		            <div class="col-md-10">
		                <input name="name" type="text" placeholder="名称" class="form-control" value="${business.name }">
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label col-md-2">简介</label>
		            <div class="col-md-10">
		                <input name="intro" type="text" placeholder="名称" class="form-control" value="${business.intro }">
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label col-md-2">单位</label>
		            <div class="col-md-10">
		            	<select name="unitId" class="form-control">
		            		<option value="0">无</option>
		            		<c:forEach items="${units}" var="unit">
		            			<option value="${unit.id }" ${business.unitId==unit.id?'selected':'' }>${unit.name}</option>
				            </c:forEach>
		            	</select>
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label col-md-2">code</label>
		            <div class="col-md-10">
		            	<select name="code" class="form-control">
		            		<option value="changgui" ${business.code=='changgui'?'selected':'' }>changgui</option>
		            		<option value="jingxibaojie" ${business.code=='jingxibaojie'?'selected':'' }>jingxibaojie</option>
		            		<option value="caboli" ${business.code=='caboli'?'selected':'' }>caboli</option>
		            		<option value="ganxi" ${business.code=='ganxi'?'selected':'' }>ganxi</option>
		            		<option value="shendubaojie" ${business.code=='shendubaojie'?'selected':'' }>shendubaojie</option>
		            		<option value="xinjukaihuang" ${business.code=='xinjukaihuang'?'selected':'' }>xinjukaihuang</option>
		            		<option value="jiajuhuli" ${business.code=='jiajuhuli'?'selected':'' }>jiajuhuli</option>
		            		<option value="jiadianqingxi" ${business.code=='jiadianqingxi'?'selected':'' }>jiadianqingxi</option>
		            	</select>
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label col-md-2">描述</label>
		            <textarea style="display: none;" name="description" id="business_description"></textarea>
		            <div class="col-md-10">
                        <div name="description" id="summernote_business">${business.description }</div>
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