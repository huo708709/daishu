<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="news_container" class="table-container">
	<div class="form-horizontal">
		<div class="form-body">
			<div class="form-group">
                 <label class="control-label col-md-1">标题</label>
                 <div class="col-md-3">
                     <input name="name" type="text" placeholder="标题" class="form-control form-filter">
                 </div>
                 <div class="col-md-3">
                     <button class="btn btn-primary filter-submit">查询</button>
                 </div>
             </div>
		</div>
	</div>
	<div class="btn-group">
        <button class="btn green skip_to_edit" type="button" url="website/news/add">
            <i class="fa fa-plus"></i> 添加</button>
		<button class="btn red news_batch_delete" type="button">
            <i class="fa fa-plus"></i> 删除</button>
    </div>
	<table id="datatable_news" class="table table-striped table-bordered table-hover table-checkable">
		<thead>
			<tr role="row" class="heading">
				<th width="2%"><input type="checkbox" class="group-checkable"></th>
				<th width="20%">标题</th>
				<th width="15%">创建时间</th>
				<th width="50%">摘要</th>
				<th width="13%">操作</th>
			</tr>
		</thead>
	</table>
</div>
